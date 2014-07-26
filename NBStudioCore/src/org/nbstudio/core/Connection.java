/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.core;

import org.nbstudio.utils.Logger;
import com.intersys.objects.CacheDatabase;
import com.intersys.objects.CacheException;
import com.intersys.objects.Database;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.nbstudio.cachefilesystem.CacheFileSystem;
import org.netbeans.api.project.Project;
import org.netbeans.api.project.ProjectManager;
import org.netbeans.api.project.ui.OpenProjects;
import org.openide.filesystems.FileLock;
import org.openide.filesystems.FileObject;
import org.openide.windows.IOProvider;
import org.openide.windows.OutputWriter;

/**
 *
 * @author daimor
 */
public final class Connection {

    private static Map<FileObject, Connection> connections = new HashMap<>();
    private final String name;
    private final String address;
    private final int port;
    private final String namespace;
    private final String username;
    private final String password;
    private Database db;
    private CacheFileSystem fs;
    private Properties props;
    private final FileObject propsFile;
    private CacheProject rootProject;
    private List<CacheProject> projects;

    private Connection(FileObject propsFile, String name, String address, int port, String namespace, String username, String password) throws InternalError {
        this.projects = new ArrayList<>();
        this.propsFile = propsFile;
        this.name = name;
        this.address = address;
        this.namespace = namespace;
        if ((this.address == null) || (this.namespace == null)) {
            throw new InternalError("Error serverName or namespace");
        }

        this.port = port;
        this.username = ((username == null) || username.isEmpty()) ? "_SYSTEM" : username;
        this.password = ((password == null) || password.isEmpty()) ? "SYS" : password;
        fs = new CacheFileSystem(this);
        for (Map.Entry<FileObject, Connection> entry : connections.entrySet()) {
            Connection conn = entry.getValue();
            if (conn.getConnectionString().equals(this.getConnectionString())) {
                throw new InternalError("Connection already addedd");
            }
        }

        this.props = getProperties();

        Database testDB = getAssociatedConnection();
        if (testDB == null) {
            throw new InternalError("Error connect to " + getConnectionString());
        }

        getRootProject();
    }

    private Connection(FileObject propsFile, Properties props) throws IOException, InternalError {
        this(propsFile,
                propsFile.getName(),
                props.getProperty("Server"),
                ((props.getProperty("SuperPort") == null) || (props.getProperty("SuperPort").isEmpty())) ? 1972 : Integer.parseInt(props.getProperty("SuperPort")),
                props.getProperty("Namespace"),
                props.getProperty("Username"),
                props.getProperty("Password"));
    }

    private Connection(final FileObject propsFile) throws IOException, InternalError {
        this(propsFile, new Properties() {
            {
                load(propsFile.getInputStream());
            }
        });
    }

    public String getConnectionString() {
        String connString = "jdbc:Cache://" + this.address + ":" + this.port + "/" + this.namespace;
        return connString;
    }

    public Database getAssociatedConnection() {
        if (this.db == null) {
            try {
                String connString = getConnectionString();
                Logger.Log("Try to connect to " + connString);
                this.db = CacheDatabase.getDatabase(connString, username, password);
                OutputStream out = new OutputStream() {
                    private final OutputWriter out = IOProvider.getDefault().getIO("Task", false).getOut();

                    @Override
                    public void write(int i) throws IOException {
                        out.print(String.valueOf((char) i));
                    }

                    @Override
                    public void write(byte[] bytes) throws IOException {
                        out.print(new String(bytes));
                    }

                    @Override
                    public void write(byte[] bytes, int off, int len) throws IOException {
                        out.print(new String(bytes, off, len));
                    }
                };
                PrintStream cacheOutput = new PrintStream(out, true);
                this.db.setConsoleOutput(cacheOutput);
            } catch (CacheException ce) {
                ce.printStackTrace();
                this.db = null;
            }
        }

        return this.db;
    }

    public void close() {
        if (this.db != null) {
            try {
                this.db.close();
            } catch (CacheException ex) {
            }
            this.db = null;
        }
    }

    public String getTitle() {
        return name;
    }

//    private static void addConnection(Connection conn) {
//        String connName = conn.getTitle();
//        if (connections.containsKey(connName)) {
//            int i;
//            for (i = 1;; i++) {
//                if (!connections.containsKey(connName + i)) {
//                    break;
//                }
//            }
//            connName += i;
//        }
//        connections.put(connName, conn);
//    }
//    
    public static Connection load(FileObject propsFile) throws InternalError, IOException {
        if (connections.containsKey(propsFile)) {
            return connections.get(propsFile);
        } else {
            Connection conn = new Connection(propsFile);
            connections.put(propsFile, conn);
            return conn;
        }
    }

    public static Connection create(FileObject propsFile, String name, String address, int port, String namespace, String username, String password) throws InternalError, IOException {
        if (connections.containsKey(propsFile)) {
            throw new InternalError("Properties File already used.");
        } else {
            Connection conn = new Connection(propsFile, name, address, port, namespace, username, password);
            connections.put(propsFile, conn);
            conn.save();
            return conn;
        }
    }

//    public static void clearConnections() {
//        connections.clear();
//    }
    public static Map<String, Connection> getConnections() {
        HashMap<String, Connection> result = new HashMap<>();
        for (Map.Entry<FileObject, Connection> entry : connections.entrySet()) {
            Connection conn = entry.getValue();
            result.put(conn.getTitle(), conn);
        }
        return result;
    }

    public static Connection getConnection(String name) {
        for (Map.Entry<FileObject, Connection> entry : connections.entrySet()) {
            Connection conn = entry.getValue();
            if (conn.getTitle().equals(name)) {
                return conn;
            }
        }
        return null;
    }

    public CacheFileSystem getFileSystem() {
        return fs;
    }

    private Properties getProperties() {
        if (this.props == null) {
            this.props = new Properties();
        }

        return this.props;
    }

    public void save() throws IOException {
        if ((this.props != null) && (propsFile != null)) {
            props.setProperty("Name", name);
            props.setProperty("Server", address);
            props.setProperty("SuperPort", "" + port);
            props.setProperty("Namespace", namespace);
            props.setProperty("Username", username);
            props.setProperty("Password", password);
            System.out.println("saving connection: " + this.props + " - " + this.propsFile);

            FileLock lock = propsFile.lock();
            try {
                try (OutputStream str = propsFile.getOutputStream(lock)) {
                    props.store(str, "");
                } catch (Exception ex) {
                    System.err.println("Error saving: " + ex.getMessage());
                }
            } finally {
                lock.releaseLock();
            }
        }
    }

    public void delete() throws IOException, CacheException {
        OpenProjects.getDefault().close(projects.toArray(new Project[projects.size()]));
        OpenProjects.getDefault().close(new Project[]{rootProject});
        close();
        this.propsFile.delete();
        connections.remove(this.propsFile);
    }

    public CacheProject getRootProject() {
        if (this.rootProject == null) {
            FileObject root = getFileSystem().getRoot();
            try {
                this.rootProject = (CacheProject) ProjectManager.getDefault().findProject(root);
//                this.rootProject = new CacheProject(root, null);
                System.out.println("getRootProject: " + this.getConnectionString() + " - " + rootProject);
                addProject(rootProject);
            } catch (Exception ex) {
                System.out.println("getRootProjectErr: " + ex.getLocalizedMessage());
            }
        }
        return this.rootProject;
    }

    public boolean addProject(CacheProject project) {
        if (projects.contains(project)) {
            return false;
        }
        projects.add(project);
        OpenProjects.getDefault().open(new Project[]{project}, false);
        return true;
    }
}
