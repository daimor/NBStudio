/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.core;

import com.intersys.classes.GlobalCharacterStream;
import com.intersys.classes.NBStudio.Routine;
import com.intersys.classes.RoutineMgr;
import com.intersys.objects.CacheException;
import com.intersys.objects.Database;
import com.intersys.objects.SList;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.util.Date;
import org.nbstudio.utils.Logger;
import org.openide.util.Exceptions;

/**
 *
 * @author daimor
 */
public class CacheRoutine extends CacheFile {

    Routine rtn;
    RoutineMgr rtnMgr;

    public CacheRoutine(Database db, String name) throws CacheException {
        super(db, name);
        rtnMgr = new RoutineMgr(db, name);
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

    @Override
    public void save(byte[] data) {
        try {
            GlobalCharacterStream stream = new GlobalCharacterStream(db);
            stream._write(new String(data));
            this.rtn.setContents(stream);
            SList result = this.rtn.compile();
            Logger.Log(result);

        } catch (CacheException ex) {
            Exceptions.printStackTrace(ex);
        }
    }
}
