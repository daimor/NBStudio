/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.cachefilesystem;

import java.nio.file.attribute.DosFileAttributes;
import java.nio.file.attribute.FileTime;

/**
 *
 * @author daimor
 */
public class CacheFileAttributes implements DosFileAttributes {

    @Override
    public boolean isReadOnly() {
        return false;
    }

    @Override
    public boolean isHidden() {
        return false;
    }

    @Override
    public boolean isArchive() {
        return false;
    }

    @Override
    public boolean isSystem() {
        return false;
    }

    @Override
    public FileTime lastModifiedTime() {
        return FileTime.fromMillis(0);
    }

    @Override
    public FileTime lastAccessTime() {
        return FileTime.fromMillis(0);
    }

    @Override
    public FileTime creationTime() {
        return FileTime.fromMillis(0);
    }

    @Override
    public boolean isRegularFile() {
        return true;
    }

    @Override
    public boolean isDirectory() {
        return false;
    }

    @Override
    public boolean isSymbolicLink() {
        return false;
    }

    @Override
    public boolean isOther() {
        return false;
    }

    @Override
    public long size() {
        return 0;
    }

    @Override
    public Object fileKey() {
        return null;
    }
}
