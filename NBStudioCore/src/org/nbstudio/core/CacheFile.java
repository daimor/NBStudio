/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.core;

import com.intersys.objects.Database;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

/**
 *
 * @author daimor
 */
public class CacheFile {

    static String name;
    public static Database db;

    public CacheFile(Database db, String name) {
        this.name = name;
        this.db = db;
    }

    public String getName() {
        return this.name;
    }

    public String getTitle() {
        return this.name;
    }

    public Date getDate() {
        return null;
    }

    public int getSize() {
        return -1;
    }

    public InputStream open() {
        return null;
    }

    public void save(byte[] data) {
    }
}