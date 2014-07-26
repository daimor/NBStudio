/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.core;

import com.intersys.classes.Dictionary.PackageDefinition;
import com.intersys.objects.CacheException;
import com.intersys.objects.Database;
import java.io.InputStream;
import java.util.Date;

/**
 *
 * @author daimor
 */
public class CachePackage extends CacheFile {
    
    PackageDefinition pkg = null;

    public CachePackage(Database db, String name) throws CacheException {
        super(db, name);
        pkg = new PackageDefinition(db, this.name);
    }

    @Override
    public Date getDate() {
        return null;
    }

    @Override
    public int getSize() {
        return -1;
    }

    @Override
    public InputStream open() {
        return null;
    }

}
