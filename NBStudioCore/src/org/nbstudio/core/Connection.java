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
import java.io.Serializable;
import org.openide.windows.IOProvider;
import org.openide.windows.OutputWriter;

/**
 *
 * @author daimor
 */
public final class Connection implements Serializable {

    private static final long serialVersionUID = 1L;
    public String name;
    public final String address;
    public final int port;
    public final String namespace;
    private Database connection;

    public Connection(String name, String address, int port, String namespace) {
        this.name = name;
        this.address = address;
        if (port == 0) {
            port = 1972;
        }
        this.port = port;
        this.namespace = namespace;

//        this.connection = getAssociatedConnection();
    }

    public Database getAssociatedConnection() {
        if (this.connection == null) {
            try {
                System.out.println("connect to cache");
                String connString = "jdbc:Cache://" + this.address + ":" + this.port + "/" + this.namespace;
                Logger.Log("Try to connect to " + connString);
                this.connection = CacheDatabase.getDatabase(connString, "_SYSTEM", "SYS");

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
                this.connection.setConsoleOutput(cacheOutput);
            } catch (CacheException ce) {
                ce.printStackTrace();
            }
        }

        return this.connection;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getTitle() {
        return name;
    }
}
