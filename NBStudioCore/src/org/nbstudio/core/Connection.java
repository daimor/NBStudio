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
import java.io.InvalidObjectException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.nbstudio.cachefilesystem.CacheFileSystem;
import org.openide.filesystems.FileAlreadyLockedException;
import org.openide.filesystems.FileLock;
import org.openide.filesystems.FileObject;
import org.openide.util.Exceptions;
import org.openide.windows.IOProvider;
import org.openide.windows.OutputWriter;

/**
 *
 * @author daimor
 */
public final class Connection {

    private static Map<String, Connection> connections = new HashMap<>();
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

    public Connection(FileObject propsFile, String name, String address, int port, String namespace, String username, String password) {
        this.propsFile = propsFile;
        this.name = name;
        this.address = address;
        if (port == 0) {
            port = 1972;
        }
        this.port = port;
        this.namespace = namespace;
        this.username = username.isEmpty() ? "_SYSTEM" : username;
        this.password = password.isEmpty() ? "SYS" : password;
        fs = new CacheFileSystem(this);

        addConnection(this);
        this.props = getProperties();
    }

    public Connection(FileObject propsFile) throws IOException, InternalError {
        this.propsFile = propsFile;
        this.props = new Properties();
        this.props.load(propsFile.getInputStream());
        this.name = propsFile.getName(); //props.getProperty("Name");
        this.address = props.getProperty("Server");
        String sSuperPort = props.getProperty("SuperPort");
        this.port = ((sSuperPort == null) || (sSuperPort.isEmpty())) ? 1972 : Integer.parseInt(sSuperPort);
        this.namespace = props.getProperty("Namespace");
        this.username = props.getProperty("Username");
        this.password = props.getProperty("Password");

        for (Map.Entry<String, Connection> entry : connections.entrySet()) {
            Connection connection = entry.getValue();
            if (connection.getConnectionString().equals(this.getConnectionString())) {
                throw new InternalError("Not unique connection");
            }
        }

        if ((this.address == null) || (this.namespace == null)) {
            throw new InternalError("Error serverName or namespace");
        }

        fs = new CacheFileSystem(this);
        addConnection(this);
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
                    private OutputWriter out = IOProvider.getDefault().getIO("Task", false).getOut();

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

    private static void addConnection(Connection conn) {
        String connName = conn.getTitle();
        if (connections.containsKey(connName)) {
            int i;
            for (i = 1;; i++) {
                if (!connections.containsKey(connName + i)) {
                    break;
                }
            }
            connName += i;
        }
        connections.put(connName, conn);
    }

    public static void clearConnections() {
        connections.clear();
    }

    public static Map<String, Connection> getConnections() {
        return connections;
    }

    public static Connection getConnection(String name) {
        return connections.get(name);
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
                OutputStream str = propsFile.getOutputStream(lock);
                try {
                    props.store(str, "");
                } catch (Exception ex) {
                    ex.printStackTrace();
                } finally {
                    str.close();
                }
            } finally {
                lock.releaseLock();
            }
        }
    }

    public void delete() throws IOException, CacheException {
        if (this.propsFile != null) {
            close();
            this.propsFile.delete();
            connections.remove(name);
        }
    }
}
