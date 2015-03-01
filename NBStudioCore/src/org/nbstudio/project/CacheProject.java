/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.project;

import com.intersys.objects.CacheException;
import com.intersys.objects.CacheQuery;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import org.nbstudio.core.Connection;
import org.nbstudio.project.customizer.CacheProjectCustomizerProvider;
import org.netbeans.api.project.Project;
import org.netbeans.api.project.ProjectInformation;
import org.netbeans.spi.project.ProjectState;
import org.netbeans.spi.project.support.LookupProviderSupport;
import org.openide.filesystems.FileObject;
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
    private final String cacheProject;
    private List<String> items = null;

    public CacheProject(FileObject prj, ProjectState state) throws IOException, CacheException {
        this.prj = prj;
        this.state = state;

        Properties propsProject = new Properties();
        FileObject projectFile = prj.getFileObject(CacheProjectFactory.PROJECT_FILE);
        propsProject.load(projectFile.getInputStream());
        this.cacheProject = propsProject.getProperty("server.project");
        String addr = propsProject.getProperty("server.addr");
        String port = propsProject.getProperty("server.port");
        if (addr == null || port == null) {
            throw new IOException("Error in project properties");
        }
        String namespace = propsProject.getProperty("server.namespace");
        String login = propsProject.getProperty("login");
        String pass = propsProject.getProperty("pass");
        String url = "jdbc:Cache://" + addr + ":" + port + "/" + namespace;
        conn = new Connection(prj.getName(), addr, port, namespace, login, pass);
    }
    
    public List<String> getItems() {
        if (this.items != null) {
            return this.items;
        }
        this.items = new ArrayList<>();
        if ((getProjectName() == null) || (getProjectName().isEmpty())) {
            return this.items;
        }
        try {

            CacheQuery q = new CacheQuery(getConnection().getAssociatedConnection(), "%Studio.Project", "ProjectItemsList");
            java.sql.ResultSet rs = q.execute(new Object[]{getProjectName()});
            while (rs.next()) {
                String fileName = rs.getString("Name");
                String fileType = rs.getString("Type");
                if ("CLS".equalsIgnoreCase(fileType)) {
                    fileName += ".cls";
                }
                Pattern pattern = Pattern.compile("(\\w+)\\.(\\w+)\\.");
                Matcher matcher = pattern.matcher(fileName);
                while (matcher.find()) {
                    fileName = matcher.replaceFirst("$1\\/$2\\.");
                    matcher = pattern.matcher(fileName);
                }
                String[] path = fileName.split("\\/");
                StringBuilder newPath = new StringBuilder();
                for (String string : path) {
                    if (newPath.length() > 0) {
                        newPath.append(".");
                    }
                    newPath.append(string);
                    items.add(newPath.toString());
                }
            }
        } catch (CacheException | SQLException ex) {
            ex.printStackTrace();
        }
        return this.items;
    }

    public boolean containsItem(String fileName) {
        if (this.items == null) {
            getItems();
        }
        assert (items != null);
        if (items.isEmpty()) {
            return true;
        }
        return items.contains(fileName);
    }

    @Override
    public FileObject getProjectDirectory() {
        return prj;
    }

    public String getProjectName() {
        return this.cacheProject;
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

    @Override
    public Lookup getLookup() {
        if (lkp == null) {
            lkp = Lookups.fixed(new Object[]{
                this,
                new Info(),
                new CacheProjectLogicalView(this),
                new CacheProjectCustomizerProvider(this)
            });
        }
        return LookupProviderSupport.createCompositeLookup(
                lkp,
                "Projects/org-nbstudio-project/Lookup");
    }

    public Connection getConnection() {
        return conn;
    }

    public final class Info implements ProjectInformation {

        @Override
        public String getName() {
            return prj.getName();
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
