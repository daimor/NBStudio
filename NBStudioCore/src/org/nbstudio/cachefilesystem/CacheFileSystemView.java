/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.cachefilesystem;

import com.intersys.objects.Database;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileSystemView;
import org.nbstudio.cachefilechooser.CacheFileNameExtensionFilter;
import org.nbstudio.core.Connection;

/**
 *
 * @author daimor
 */
public class CacheFileSystemView extends FileSystemView {

    private final Map<String, Database> connections = new HashMap<>();
    private final Map<String, File> roots = new HashMap<>();
    private FileFilter fileFilter = null;
    private boolean showSystemFiles = false;
    private boolean showGeneratedFiles = false;
    private boolean showProjectFiles = false;

    public CacheFileSystemView() {
        Map<String, Connection> allConnections = Connection.getConnections();
        for (Map.Entry<String, Connection> entry : allConnections.entrySet()) {
            String connectionName = entry.getKey();
            Connection connection = entry.getValue();
            addRoot(connection.getAssociatedConnection(), connectionName);
        }
    }

    public CacheFileSystemView(Database db, String rootName) throws IOException {
        addRoot(db, rootName);
    }

    public final void addRoot(Database db, String rootName) {
        connections.put(rootName, db);
        roots.put(rootName, new CacheRootFile(rootName));
    }

    @Override
    public File createNewFolder(File containingDir) throws IOException {
        return null;
    }

    public CacheRootFile createFileObject(CacheRootFile dir, String filename) {
        try {
            return new CacheRootFile(dir.getPath() + "/" + filename);
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public File getChild(File parent, String fileName) {
        return getDefaultDirectory();
    }

    @Override
    public boolean isFileSystem(File f) {
        return false; //f.equals(root);
    }

    @Override
    public File getParentDirectory(File dir) {
        if (dir instanceof CacheRootFile) {
            return dir.getParentFile();
        } else {
            return getDefaultDirectory();
        }
    }

    @Override
    public String getSystemDisplayName(File f) {
        if (f instanceof CacheRootFile) {
            return f.getName();
        } else {
            return super.getSystemDisplayName(f);
        }

    }

    @Override
    public File[] getFiles(File dir, boolean useFileHiding) {
        if (dir instanceof CacheRootFile) {
            String filterString = "";
            if ((getFileFilter() != null) && (getFileFilter() instanceof CacheFileNameExtensionFilter)) {
                filterString = ((CacheFileNameExtensionFilter) getFileFilter()).getFilterString();
            }
            return ((CacheRootFile) dir).listFiles(filterString, showSystemFiles, showGeneratedFiles, showProjectFiles);
        } else {
            return new File[]{};
        }
    }

    @Override
    public boolean isRoot(File f) {
        return roots.containsValue(f);
    }

    @Override
    public File[] getRoots() {
        return roots.values().toArray(new File[roots.values().size()]);
    }

    @Override
    public File getDefaultDirectory() {
        Collection<File> rootsList = this.roots.values();
        if (rootsList.size() > 0) {
            return rootsList.toArray(new File[rootsList.size()])[0];
        } else {
            return null;
        }
    }

    @Override
    public Boolean isTraversable(File f) {
        boolean res;
        try {
            CacheRootFile file = (CacheRootFile) f;
            res = file.isDirectory();
        } catch (Exception ex) {
            res = false;
        }
        return res;
    }

    @Override
    protected File createFileSystemRoot(File f) {
        return f;
    }

    public FileFilter getFileFilter() {
        return fileFilter;
    }

    public void setFileFilter(FileFilter fileFilter) {
        this.fileFilter = fileFilter;
    }

    public void setShowSystemFiles(boolean showSystemFiles) {
        this.showSystemFiles = showSystemFiles;
    }

    public void setShowGeneratedFiles(boolean showGeneratedFiles) {
        this.showGeneratedFiles = showGeneratedFiles;
    }

    public boolean getShowSystemFiles() {
        return this.showSystemFiles;
    }

    public boolean getShowGeneratedFiles() {
        return this.showGeneratedFiles;
    }

    public void setShowProjectFiles(boolean showProjectFiles) {
        this.showProjectFiles = showProjectFiles;
    }
    
    public boolean getShowProjectFiles(){
        return showProjectFiles;
    }
}
