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
import java.util.HashMap;
import java.util.Map;
import org.nbstudio.cachefilesystem.CacheFileSystem;
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
    private final String port;
    private final String namespace;
    private final String username;
    private final String password;
    private Database db;
    private CacheFileSystem fs;
    
    public Connection(String name, String address, String port, String namespace, String username, String password) throws InternalError {
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
        
        Database testDB = getAssociatedConnection();
        if (testDB == null) {
            throw new InternalError("Error connect to " + getConnectionString());
        }
        
        connections.put(name, this);
    }
    
    public String getConnectionString() {
        String connString = "jdbc:Cache://" + this.address + ":" + this.port + "/" + this.namespace;
        return connString;
    }
    
    public Database getAssociatedConnection() {
        if (this.db == null) {
            try {
                String connString = getConnectionString();
                Logger.LogAdd("Connect to " + connString);
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
                Logger.LogAdd(" - Success");
            } catch (CacheException ce) {
                Logger.LogAdd(" - Error: " + ce.getLocalizedMessage());
                ce.printStackTrace();
                this.db = null;
            }
            Logger.LogAdd("\n");
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
    
    public static Map<String, Connection> getConnections() {
        return connections;
    }
    
    public static Connection getConnection(String name) {
        return connections.get(name);
    }
    
    public CacheFileSystem getFileSystem() {
        return fs;
    }
    
}
