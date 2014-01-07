/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.cachefilechooser;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.plaf.ComponentUI;
import org.nbstudio.cachefilesystem.CacheFileSystemView;

/**
 *
 * @author daimor
 */
public class CacheFileChooser extends JFileChooser {

    public CacheFileChooser(FileSystemView fsv) {
        super(fsv);
    }

    public CacheFileChooser(File currentDirectory) {
        super(currentDirectory);
    }

    @Override
    public final void setUI(ComponentUI comp) {
        boolean readOnly = UIManager.getBoolean("FileChooser.readOnly");
        UIManager.put("FileChooser.readOnly", Boolean.TRUE);

        super.setUI(new CacheFileChooserUI(this));
        UIManager.put("FileChooser.readOnly", readOnly);
    }

    @Override
    public void setFileFilter(FileFilter filter) {
        CacheFileSystemView fsv = (CacheFileSystemView) getFileSystemView();
        fsv.setFileFilter(filter);
        super.setFileFilter(filter);
    }

    public void setShowSystemFiles(boolean flag) {
        CacheFileSystemView fsv = (CacheFileSystemView) getFileSystemView();
        fsv.setShowSystemFiles(flag);
    }

    public void setShowGeneratedFiles(boolean flag) {
        CacheFileSystemView fsv = (CacheFileSystemView) getFileSystemView();
        fsv.setShowGeneratedFiles(flag);
    }

    public boolean getShowSystemFiles() {
        CacheFileSystemView fsv = (CacheFileSystemView) getFileSystemView();
        return fsv.getShowSystemFiles();
    }

    public boolean getShowGeneratedFiles() {
        CacheFileSystemView fsv = (CacheFileSystemView) getFileSystemView();
        return fsv.getShowGeneratedFiles();
    }

    @Override
    public FileSystemView getFileSystemView() {
        return super.getFileSystemView(); //To change body of generated methods, choose Tools | Templates.
    }
}
