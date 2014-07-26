/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.cachefilesystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Objects;
import org.nbstudio.core.Connection;
import org.openide.filesystems.FileAlreadyLockedException;
import org.openide.filesystems.FileChangeListener;
import org.openide.filesystems.FileLock;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileStateInvalidException;
import org.openide.filesystems.FileSystem;

/**
 *
 * @author daimor
 */
public class CacheFileObject extends FileObject {

    private final CacheFileSystem fs;
    private final CacheFileObject parent;
    private final String name;
    private Reference lock;

    public CacheFileObject(CacheFileSystem fs, CacheFileObject parent, String name) {
        this.fs = fs;
        this.parent = parent;
        this.name = name;
    }

    @Override
    public String getName() {
        int i = name.lastIndexOf('.');
        return (i <= 0) ? name : name.substring(0, i);
    }

    @Override
    public String getExt() {
        int i = name.lastIndexOf('.') + 1;
        return (i <= 1) || (i == name.length()) ? "" : name.substring(i);
    }

    @Override
    public void rename(FileLock lock, String name, String ext) throws IOException {
    }

    @Override
    public FileSystem getFileSystem() throws FileStateInvalidException {
        return fs;
    }

    @Override
    public FileObject getParent() {
        return parent;
    }

    @Override
    public boolean isFolder() {
        return false || isRoot() || getExt().isEmpty() || "pkg".equalsIgnoreCase(getExt()) || "prj".equalsIgnoreCase(getExt());
    }

    @Override
    public Date lastModified() {
        return new Date(0);
    }

    @Override
    public boolean isRoot() {
        return (parent == null);
    }

    @Override
    public boolean isData() {
        return !isFolder();
    }

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public void delete(FileLock lock) throws IOException {
    }

    @Override
    public Object getAttribute(String attrName) {
        return fs.readAttribute(name, attrName);
    }

    @Override
    public void setAttribute(String attrName, Object value) throws IOException {
        fs.writeAttribute(name, attrName, value);
    }

    @Override
    public Enumeration<String> getAttributes() {
        return fs.attributes(name);
    }

    @Override
    public void addFileChangeListener(FileChangeListener fcl) {
    }

    @Override
    public void removeFileChangeListener(FileChangeListener fcl) {
    }

    @Override
    public long getSize() {
        return 0;
    }

    @Override
    public InputStream getInputStream() throws FileNotFoundException {
        return fs.inputStream(getFullName());
    }

    @Override
    public OutputStream getOutputStream(FileLock lock) throws IOException {
        if (this.name.equalsIgnoreCase(".netbeans.xml")) {
            return null;
        }
        return fs.outputStream(getFullName());
    }

    @Override
    public synchronized FileLock lock() throws IOException {
        if (lock != null) {
            FileLock f = (FileLock) lock.get();
            if (f != null) {
                //        System.out.println ("Already locked: " + this); // NOI18N
                throw new FileAlreadyLockedException();
            }
        }

        fs.lock(getPath());

        FileLock l = new AfLock();
        lock = new WeakReference(l);
        //    Thread.dumpStack ();
        //    System.out.println ("Locking file: " + this); // NOI18N

        return l;
    }

    synchronized void unlock(FileLock fLock) {
        FileLock currentLock = null;
        if (lock != null) {
            currentLock = (FileLock) lock.get();
        }
        if (currentLock == fLock) {
            fs.unlock(getPath());
            // clear my lock
            lock = null;
        }
    }

    @Override
    public void setImportant(boolean b) {
    }

    @Override
    public FileObject[] getChildren() {
        List<FileObject> children = new ArrayList();
        children.addAll(Arrays.asList(getChildren("*.cls,*.mac")));
        return children.toArray(new FileObject[children.size()]);
    }

    public CacheFileObject[] getChildren(String filter) {
        Connection conn = fs.getConnection();
        String fullPath = getFullPath();
        CacheRootFile curFile = new CacheRootFile(conn.getTitle() + fullPath);
        File[] files = curFile.listFiles(filter, false, false, false);
        List<FileObject> children = new ArrayList();
        for (File file : files) {
            String fileName = file.getName();
            children.add(new CacheFileObject(fs, this, fileName));
        }
        return children.toArray(new CacheFileObject[children.size()]);
    }

    public String getFullPath() {
        return (parent != null) ? parent.getFullPath() + "/" + name : name;
    }

    public String getFullName() {
        String parentName = (parent != null) ? parent.getFullName() : "";
        return (!parentName.isEmpty()) ? parentName + "." + name : name;
    }

    @Override
    public FileObject getFileObject(String name, String ext) {
        String fileName = name + (ext != null ? "." + ext : "");
        if (fileName.equalsIgnoreCase(".netbeans.xml")) {
            return null;
        }
        return new CacheFileObject(fs, this, fileName);
    }

    @Override
    public FileObject createFolder(String name) throws IOException {
        return new CacheFileObject(fs, this, name);
    }

    @Override
    public FileObject createData(String name, String ext) throws IOException {
        return new CacheFileObject(fs, this, name);
    }

    @Override
    public boolean isReadOnly() {
        return false;
    }

    /**
     * Implementation of lock for abstract files.
     */
    private class AfLock extends FileLock {

        AfLock() {
        }

        @Override
        public void releaseLock() {
            if (this.isValid()) {
                super.releaseLock();
                unlock(this);
            }
        }
    }

    @Override
    public int hashCode() {
        final int prime = 11;
        int hash = 1;
        hash = prime * hash + Objects.hashCode(this.fs);
        hash = prime * hash + Objects.hashCode(this.parent);
        hash = prime * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof CacheFileObject) {
            CacheFileObject cacheFileObj = (CacheFileObject) obj;
            boolean result = true;
            try {
                result = result && this.fs.equals(cacheFileObj.getFileSystem());
                result = result && this.getFullPath().equals(cacheFileObj.getFullPath());
            } catch (FileStateInvalidException ex) {
                result = false;
            }
            return result;
        } else {
            return false;
        }
    }
}
