/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.project;

import com.intersys.objects.CacheException;
import java.io.IOException;
import org.nbstudio.cachefilesystem.CacheFileObject;
import org.nbstudio.utils.Logger;
import org.netbeans.api.project.Project;
import org.netbeans.spi.project.ProjectFactory;
import org.netbeans.spi.project.ProjectState;
import org.openide.filesystems.FileObject;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author daimor
 */
@ServiceProvider(service = ProjectFactory.class)
public class CacheProjectFactory implements ProjectFactory {

    public static final String PROJECT_FILE = "cacheProject.properties";

    @Override
    public boolean isProject(FileObject projectDirectory) {
        return projectDirectory.getFileObject(PROJECT_FILE) != null;
    }

    @Override
    public Project loadProject(FileObject prj, ProjectState state) throws IOException {
        if (prj instanceof CacheFileObject) {
            return null;
        }
        if (!isProject(prj)) {
            return null;
        }
        FileObject xml = prj.getFileObject(PROJECT_FILE);
        if (xml == null || !xml.isData()) {
            return null;
        }
        CacheProject project = null;
        try {
            project = new CacheProject(prj, state);
        } catch (CacheException ex) {
            ex.printStackTrace();
        }
        return project;
    }

    @Override
    public void saveProject(Project project) throws IOException, ClassCastException {
    }

}
