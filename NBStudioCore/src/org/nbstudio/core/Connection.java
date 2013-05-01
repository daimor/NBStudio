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
    private String name;
    private String address;
    private int port;
    private String namespace;
    private Database connection;

    public Connection(String name) {
        this.name = name;
//        this.address = "127.0.0.1";
//        this.port = 1972;
//        this.namespace = "USER";
    }

    public Database getAssociatedConnection() {
        if (this.connection == null) {
            try {
                this.address = "127.0.0.1";
                this.port = 1972;
                this.namespace = "SAMPLES";
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
