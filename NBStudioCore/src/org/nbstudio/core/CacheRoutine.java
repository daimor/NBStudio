/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.core;

import com.intersys.classes.NBStudio.Routine;
import com.intersys.objects.CacheException;
import com.intersys.objects.Database;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.Date;
import org.openide.util.Exceptions;

/**
 *
 * @author daimor
 */
public class CacheRoutine extends CacheFile {

    Routine rtn;

    public CacheRoutine(Database db, String name) throws CacheException {
        super(db, name);
        this.rtn = new Routine(db, name);
    }

    @Override
    public Date getDate() {
        Date date = null;
        try {
            Timestamp ts = this.rtn.GetDate();
            date = new Date(ts.getTime());
        } catch (CacheException ex) {
            Exceptions.printStackTrace(ex);
        }
        return date;
    }

    @Override
    public int getSize() {
        int size = 0;
        try {
            size = this.rtn.GetSize();
        } catch (CacheException ex) {
            Exceptions.printStackTrace(ex);
        }
        return size;
    }

    @Override
    public InputStream open() {
        InputStream is = null;
        try {
            is = this.rtn.getContents().getInputStream();
        } catch (CacheException ex) {
            Exceptions.printStackTrace(ex);
        }
        return is;
    }
}
