/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.filesystems;

import com.intersys.objects.CacheException;
import com.intersys.objects.CacheQuery;
import com.intersys.objects.Database;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.ResultSet;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import org.openide.filesystems.AbstractFileSystem;
import org.openide.filesystems.AbstractFileSystem.Attr;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileSystem;
import org.openide.filesystems.FileUtil;
import java.lang.String;
import org.nbstudio.core.cls.clsFile;
import org.nbstudio.core.CacheFile;
import org.nbstudio.core.CachePackage;
import org.nbstudio.core.mac.CacheRoutine;
import org.openide.util.Enumerations;
import org.openide.util.Exceptions;
import org.openide.util.lookup.ServiceProvider;
import org.openide.util.lookup.ServiceProviders;

@ServiceProviders({
    @ServiceProvider(service = FileSystem.class),
    @ServiceProvider(service = ISCFileSystem.class)
})
public class ISCFileSystem extends AbstractFileSystem implements AbstractFileSystem.Info, AbstractFileSystem.Change, AbstractFileSystem.List, Attr {

    Database db;
    String name;
    private java.util.Date created = new java.util.Date();

    public ISCFileSystem() {
        attr = this;
        list = this;
        change = this;
        info = this;
    }

    public ISCFileSystem(Database db) {
        attr = this;
        list = this;
        change = this;
        info = this;

        this.db = db;

        refresh();
    }

    public void refresh() {
        entries.clear();
        try {
            FileObject classes = getRoot().createFolder("Classess");
            refreshClassess(classes);

            FileObject routines = getRoot().createFolder("Routines");
            refreshRoutines(routines);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void refreshRoutines(FileObject root) {
        try {
            HashMap<String, FileObject> packages = new HashMap<String, FileObject>();

            CacheQuery qrRoutines = new CacheQuery(db, "%Library.Routine", "RoutineList");
            final ResultSet rsRoutines = qrRoutines.execute("*.MAC,*.INT");
            while (rsRoutines.next()) {
                String rtnName = rsRoutines.getString("Name");
                FileSystem fs = FileUtil.createMemoryFileSystem();
                String ext = rtnName.substring(rtnName.lastIndexOf(".") + 1, rtnName.length()).toLowerCase();

                rtnName = rtnName.substring(0, rtnName.lastIndexOf("."));

                String[] tmp = rtnName.split("\\.");
                FileObject rootPKG = root;
                for (int i = 0; i < (tmp.length - 1); i++) {
                    String pkgName = "";
                    for (int j = 0; j <= i; j++) {
                        if (j > 0) {
                            pkgName += ".";
                        }
                        pkgName += tmp[j];
                    }
                    if (packages.get(pkgName) == null) {
                        rootPKG = rootPKG.createFolder(tmp[i]);
                        packages.put(pkgName, rootPKG);
                    } else {
                        rootPKG = packages.get(pkgName);
                    }
                }
                FileObject fob = rootPKG.createData(tmp[tmp.length - 1], ext);

//                FileObject fob = root.createData(rtnName.substring(0, rtnName.length() - 4), ext);
            }
            rsRoutines.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void refreshClassess(FileObject root) {
        try {
            HashMap<String, FileObject> packages = new HashMap<String, FileObject>();

            CacheQuery qrRoutines = new CacheQuery(db, "%Dictionary.ClassDefinitionQuery", "Summary");
            final ResultSet rsClassess = qrRoutines.execute();
            while (rsClassess.next()) {
                String clsName = rsClassess.getString("Name");
                boolean hidden = rsClassess.getBoolean("Hidden");
                if (hidden) {
                    continue;
                }
                if (clsName.charAt(0) == '%') {
                    continue;
                }
                String[] tmp = clsName.split("\\.");
                FileObject rootPKG = root;
                for (int i = 0; i < (tmp.length - 1); i++) {
                    String pkgName = "";
                    for (int j = 0; j <= i; j++) {
                        if (j > 0) {
                            pkgName += ".";
                        }
                        pkgName += tmp[j];
                    }
                    if (packages.get(pkgName) == null) {
                        rootPKG = rootPKG.createFolder(tmp[i]);
                        packages.put(pkgName, rootPKG);
                    } else {
                        rootPKG = packages.get(pkgName);
                    }
                }
                FileObject fob = rootPKG.createData(tmp[tmp.length - 1], "cls");
//                DataObject dob = DataObject.find(fob);
//                Node node = dob.getNodeDelegate();
            }
            rsClassess.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public String getDisplayName() {
        return db.getConnectionString();
    }

    static final class Entry {

        public HashMap<String, Object> attrs = new HashMap<String, Object>();
        public Boolean isFolder;
        public java.util.Date last;
        public String extension;
        public CacheFile obj = null;
        public String Name;
        public String Title;
    }
    private Hashtable<String, Entry> entries = new Hashtable<String, Entry>();

    private Entry e(String n) {
        if (n.length() > 0 && n.charAt(0) == '/') {
            n = n.substring(1);
        }

        Entry x = entries.get(n);
        if (x == null) {
            x = new Entry();
            entries.put(n, x);
        }
        return x;
    }

    /**
     * finds whether there already is this name
     */
    private boolean is(String n) {
        if (n.length() > 0 && n.charAt(0) == '/') {
            n = n.substring(1);
        }
        Entry x = entries.get(n);
        return x != null;
    }

    @Override
    public boolean isReadOnly() {
        return false;
    }

    @Override
    public Date lastModified(String name) {
        java.util.Date d = e(name).last;
        return d == null ? created : d;
    }

    @Override
    public boolean folder(String name) {
        return is(name) ? e(name).isFolder : false;
    }

    @Override
    public boolean readOnly(String name) {
        return false;
    }

    @Override
    public String mimeType(String name) {
        return (String) e(name).attrs.get("mimeType");
    }

    @Override
    public long size(String name) {
        return 0;
    }

    @Override
    public InputStream inputStream(String name) throws FileNotFoundException {
        InputStream is = null;
        Entry entry = e(name);
        if (entry.obj != null) {
            try {
                is = entry.obj.open();
            } catch (Exception ex) {
                Exceptions.printStackTrace(ex);
            }
            return is;
        }
        byte[] arr = new byte[0];
        if (arr == null) {
            arr = new byte[0];
        }
        return new ByteArrayInputStream(arr);
    }

    @Override
    public OutputStream outputStream(final String name) throws IOException {
        class Out extends ByteArrayOutputStream {

            @Override
            public void close() throws IOException {
                super.close();
                Entry entry = e(name);
                if (entry.obj != null) {
                    try {
                        entry.obj.save(toByteArray());
                    } catch (Exception ex) {
                        Exceptions.printStackTrace(ex);
                    }
                }
                e(name).last = new Date();
            }
        }

        return new Out();
    }

    @Override
    public void lock(String name) throws IOException {
    }

    @Override
    public void unlock(String name) {
    }

    @Override
    public void markUnimportant(String name) {
    }

    @Override
    public void createFolder(String name) throws IOException {
        if (is(name)) {
            throw new IOException("File already exists");
        }
        Entry entry = e(name);
        entry.isFolder = true;
        if (name.indexOf("/") > 0) {
            name = name.substring(name.indexOf("/") + 1, name.length());
            name = name.replace('/', '.');
            try {
                CacheFile obj;
                obj = new CachePackage(db, name);
                entry.obj = obj;
            } catch (CacheException ex) {
                Exceptions.printStackTrace(ex);
            }
        }
    }

    @Override
    public void createData(String name) throws IOException {
        if (is(name)) {
            throw new IOException("File already exists");
        }
        String ext = name.substring(name.lastIndexOf(".") + 1, name.length()).toLowerCase();
        CacheFile obj = null;
        try {
            Entry entry = e(name);
            name = name.substring(name.indexOf("/") + 1, name.length());
            name = name.replace('/', '.');
            Boolean isFolder = false;
            if ((ext.equals("mac")) || (ext.equals("bas")) || (ext.equals("int"))) {
                obj = new CacheRoutine(db, name);
            } else if (ext.equals("cls")) {
                name = name.substring(0, name.length() - 4);
                obj = new clsFile(db, name);
            }
            entry.obj = obj;
            entry.isFolder = isFolder;
            entry.extension = ext;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void rename(String oldName, String newName) throws IOException {
    }

    @Override
    public void delete(String name) throws IOException {
    }

    @Override
    public String[] children(String f) {
        if (f.length() > 0 && f.charAt(0) == '/') {
            f = f.substring(1);
        }
        if (f.length() > 0 && !f.endsWith("/")) {
            f = f + "/";
        }

        HashSet<String> l = new HashSet<String>();

        Iterator<String> it = entries.keySet().iterator();
        while (it.hasNext()) {
            String name = it.next();

            if (name.startsWith(f) || f.trim().length() == 0) {
                int i = name.indexOf('/', f.length());
                String child = null;
                if (i > 0) {
                    child = name.substring(f.length(), i);
                } else {
                    child = name.substring(f.length());
                }

                if (child.trim().length() > 0) {
                    l.add(child);
                }
            }
        }
        return l.toArray(new String[0]);
    }

    @Override
    public Object readAttribute(String name, String attrName) {
        return is(name) ? e(name).attrs.get(attrName) : null;
    }

    @Override
    public void writeAttribute(String name, String attrName, Object value) throws IOException {
        e(name).attrs.put(attrName, value);
    }

    @Override
    public Enumeration<String> attributes(String name) {
        if (is(name)) {
            return Collections.enumeration(e(name).attrs.keySet());
        } else {
            return Enumerations.empty();
        }
    }

    @Override
    public void renameAttributes(String oldName, String newName) {
    }

    @Override
    public void deleteAttributes(String name) {
    }
}
