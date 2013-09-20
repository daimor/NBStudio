/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.core;

import org.nbstudio.utils.Logger;
import com.intersys.objects.CacheDatabase;
import com.intersys.objects.CacheException;
import com.intersys.objects.Database;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author daimor
 */
public class Connection implements Serializable {

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
    }

    public Database getAssociatedConnection() {
        if (this.connection == null) {
            try {
                System.out.println("connect to cache");
                String connString = "jdbc:Cache://" + this.address + ":" + this.port + "/" + this.namespace;
                Logger.Log("Try to connect to " + connString);
                this.connection = CacheDatabase.getDatabase(connString, "_SYSTEM", "SYS");
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
