/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.core;

import java.beans.PropertyChangeListener;
import java.util.Objects;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import org.nbstudio.cachefilesystem.CacheFileSystem;
import org.nbstudio.utils.Logger;
import org.netbeans.api.project.Project;
import org.netbeans.api.project.ProjectInformation;
import org.netbeans.spi.project.ProjectState;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileStateInvalidException;
import org.openide.util.ImageUtilities;
import org.openide.util.Lookup;
import org.openide.util.lookup.Lookups;

/**
 *
 * @author daimor
 */
public class CacheProject implements Project {

    private Lookup lkp;
    private final FileObject prj;
    private final ProjectState state;
    private final Connection conn;

    public CacheProject(FileObject prj, ProjectState state) {
        Logger.Log("OpenProject: " + prj + " - " + state);
        System.out.println("---------------------------- " + prj);
        StackTraceElement[] stack = Thread.currentThread().getStackTrace();
        for (StackTraceElement stackTraceElement : stack) {
            System.out.println(stackTraceElement.toString());
        }
        System.out.println("----------------------------");
        this.prj = prj;
        this.state = state;
        try {
            CacheFileSystem fs = (CacheFileSystem) prj.getFileSystem();
            this.conn = fs.getConnection();
        } catch (FileStateInvalidException ex) {
            throw new InternalError("Error open project");
        }
    }

    @Override
    public FileObject getProjectDirectory() {
        return prj;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof CacheProject) {
            return this.prj.equals(((CacheProject) obj).getProjectDirectory());
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.prj);
        return hash;
    }

//    public Connection getConnection() {
//        return conn;
//    }
    @Override
    public Lookup getLookup() {
        if (lkp == null) {
            lkp = Lookups.fixed(new Object[]{
                new Info(),
                new CacheProjectLogicalView(this)
            });
        }
        return lkp;
    }

    public final class Info implements ProjectInformation {

        @Override
        public String getName() {
            return conn.getTitle() + (prj.isRoot() ? "" : ": " + prj.getName());
        }

        @Override
        public String getDisplayName() {
            return getName();
        }

        @Override
        public Icon getIcon() {
            return new ImageIcon(ImageUtilities.loadImage("resources/prjFilesIcon.gif"));
        }

        @Override
        public Project getProject() {
            return CacheProject.this;
        }

        @Override
        public void addPropertyChangeListener(PropertyChangeListener listener) {
        }

        @Override
        public void removePropertyChangeListener(PropertyChangeListener listener) {
        }
    }
}
