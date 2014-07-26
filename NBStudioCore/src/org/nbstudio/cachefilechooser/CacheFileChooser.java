/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.cachefilechooser;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.filechooser.FileFilter;
import javax.swing.plaf.ComponentUI;
import org.nbstudio.cachefilesystem.CacheFileSystemView;
import org.nbstudio.cachefilesystem.CacheFileView;
import org.openide.util.NbPreferences;

/**
 *
 * @author daimor
 */
public class CacheFileChooser extends JFileChooser {

    private final static Preferences preferences = NbPreferences.forModule(CacheFileChooser.class);

    public CacheFileChooser() {
        this(new CacheFileSystemView() {
            {
                setShowSystemFiles(preferences.getBoolean("FileDialog.ShowSystemFiles", false));
                setShowGeneratedFiles(preferences.getBoolean("FileDialog.ShowGeneratedFiles", false));
            }
        });
    }

    public CacheFileChooser(CacheFileSystemView fsv) {
        super(fsv);
        setFileView(new CacheFileView());
        setMultiSelectionEnabled(true);

        int height = preferences.getInt("FileDialog.Height", 500);
        int width = preferences.getInt("FileDialog.Width", 700);
        setPreferredSize(new Dimension(width, height));
    }

    @Override
    public final void setUI(ComponentUI comp) {
        boolean readOnly = UIManager.getBoolean("FileChooser.readOnly");
        UIManager.put("FileChooser.readOnly", Boolean.TRUE);

        super.setUI(new CacheFileChooserUI(this));
        UIManager.put("FileChooser.readOnly", readOnly);
    }

    @Override
    public int showDialog(Component parent, String approveButtonText) throws HeadlessException {
        try {
            int res = super.showDialog(parent, approveButtonText);
            CacheFileSystemView fsv = getFileSystemView();
            preferences.putBoolean("FileDialog.ShowSystemFiles", fsv.getShowSystemFiles());
            preferences.putBoolean("FileDialog.ShowGeneratedFiles", fsv.getShowGeneratedFiles());
            preferences.putInt("FileDialog.Height", getHeight());
            preferences.putInt("FileDialog.Width", getWidth());
            preferences.sync();
            return res;
        } catch (BackingStoreException ex) {
            return CANCEL_OPTION;
        }
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
    public CacheFileSystemView getFileSystemView() {
        return (CacheFileSystemView) super.getFileSystemView();
    }
}
