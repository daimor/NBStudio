/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.core.mac;

import com.intersys.classes.RoutineMgr;
import com.intersys.objects.BooleanHolder;
import com.intersys.objects.CacheException;
import com.intersys.objects.Database;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.sql.Timestamp;
import java.util.Date;
import org.nbstudio.core.CacheFile;
import org.openide.util.Exceptions;

/**
 *
 * @author daimor
 */
public class RoutineFile extends CacheFile {

    RoutineMgr rtnMgr;

    public RoutineFile(Database db, String name) throws CacheException {
        super(db, name);
        rtnMgr = new RoutineMgr(db, name);
    }

    @Override
    public Date getDate() {
        Date date = null;
        try {
            Timestamp ts = this.rtnMgr.getTimeStamp();
            date = new Date(ts.getTime());
        } catch (CacheException ex) {
            Exceptions.printStackTrace(ex);
        }
        return date;
    }

    @Override
    public int getSize() {
        return -1;
    }

    @Override
    public InputStream open() {
        RoutineText os;
        ByteArrayInputStream is = null;
        try {
            os = new RoutineText();
            is = new ByteArrayInputStream(os.toByteArray());
        } catch (CacheException ex) {
            Exceptions.printStackTrace(ex);
        }

        return is;
    }

    @Override
    public void save(byte[] data) {
        try {
            this.rtnMgr.getCodeOut().write(new String(data));
            this.rtnMgr.sys_Save(new BooleanHolder(true));
            this.rtnMgr.Compile("/keepsource");

        } catch (CacheException | IOException ex) {
        }
    }

    final class RoutineText extends ByteArrayOutputStream {

        public RoutineText() throws CacheException {
            writeReader(rtnMgr.getCodeIn());
        }

        public void writeln() {
            write('\n');
        }

        public void writeln(String string) {
            write(string + '\n');
        }

        public void write(String string) {
            try {
//                write(string.getBytes("UTF-8"));
                write(string.getBytes());
            } catch (IOException ex) {
                Exceptions.printStackTrace(ex);
            }
        }

        public void writeReader(Reader isr) {
            try {
                BufferedReader buff;
                isr.reset();
                buff = new BufferedReader(isr);
                String str;
                while ((str = buff.readLine()) != null) {
                    if (str.isEmpty()) {
                        continue;
                    }
                    writeln(str);
                }
            } catch (IOException ex) {
                Exceptions.printStackTrace(ex);
            }
        }
    }

    class ObjectStream extends ByteArrayOutputStream {

        public ObjectStream() {
        }

        public void write(String string) throws IOException {
            write(string.getBytes());
        }
    }
}
