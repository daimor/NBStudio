/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.cachefilesystem;

import com.intersys.cache.CacheObject;
import com.intersys.cache.Dataholder;
import com.intersys.classes.RoutineMgr;
import com.intersys.objects.CacheException;
import com.intersys.objects.CacheQuery;
import com.intersys.objects.Database;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.nbstudio.core.CacheFile;
import org.nbstudio.core.Connection;
import org.nbstudio.core.cls.ClassFile;
import org.nbstudio.core.mac.RoutineFile;
import org.nbstudio.utils.Logger;

/**
 *
 * @author daimor
 */
public class CacheRootFile extends File {

    private final Database db;
    private final String path;
    private CacheObject cobj;
    private final String shortFileName;
    private String fullFileName;
    private final String connectionName;
    private final boolean isRoot;
    private final String fileExt;

    public CacheRootFile(String path) {
        super(path);
        this.path = path;
        String fullPath = path + (path.contains("/") ? "" : "/");
        this.connectionName = fullPath.substring(0, fullPath.indexOf("/"));
        Connection conn = Connection.getConnection(connectionName);
        if (conn != null) {
            this.db = conn.getAssociatedConnection();
        } else {
            this.db = null;
        }
        fullFileName = fullPath.substring(fullPath.indexOf("/") + 1, fullPath.length());
        isRoot = fullFileName.isEmpty();
        fullFileName = fullFileName.replaceAll("/", ".");
        shortFileName = fullPath.substring(fullPath.lastIndexOf("/") + 1, fullPath.length());
        fileExt = (fullFileName.contains(".") ? fullFileName.substring(fullFileName.lastIndexOf(".") + 1, fullFileName.length()) : "").toLowerCase();
    }

    private String normalize(String path) {
        return path;
    }

    @Override
    public String getPath() {
        if (fileExt.equalsIgnoreCase("pkg")) {
            return path.substring(0, path.lastIndexOf("."));
        } else {
            return path;
        }
    }

    protected String getCACHE_CLASS_NAME() {
        switch (fileExt) {
            case "bas":
            case "int":
            case "inc":
            case "mac":
                return "%Library.Routine";
            case "pkg":
                return "%Dictionary.PackageDefinition";
            case "cls":
                return "%Dictionary.ClassDefinition";
            default:
                return "";
        }
    }

    protected String getCacheName() {
        return this.fullFileName;
    }

    CacheObject getCacheObject() {
        if (this.cobj == null) {
            try {
                this.cobj = (((com.intersys.cache.SysDatabase) db).openCacheObject(getCACHE_CLASS_NAME(), getCacheName()));
            } catch (CacheException ex) {
            }
        }
        return this.cobj;
    }

    @Override
    public File[] listFiles(FileFilter filter) {
        return listFiles();
    }

    @Override
    public File[] listFiles(FilenameFilter filter) {
        return listFiles();
    }

    @Override
    public File[] listFiles() {
        return listFiles("", false, false, false);
    }

    public File[] listFiles(String filter, boolean showSystemFiles, boolean showGeneratedFiles, boolean showProjectFiles) {
        List<File> files = new ArrayList<>();
//        for (StackTraceElement ste : Thread.currentThread().getStackTrace()) {
//            System.out.println(ste);
//        }
        try {

            CacheQuery qrRoutines = RoutineMgr.query_StudioOpenDialog(db);
            String currentPath = getFullName();

            String searchPath = (currentPath.isEmpty()) ? "" : currentPath + "/";
//            searchPath = searchPath.replaceAll("\\.", "/");
            java.sql.ResultSet rs = qrRoutines.execute(new Object[]{searchPath + filter, 1, 1, showSystemFiles, false, false, showGeneratedFiles});
            while (rs.next()) {
                String fileName = rs.getString("Name");
                fileName = connectionName + "/" + (currentPath.isEmpty() ? "" : (currentPath + "/")) + fileName;
                int fileType = rs.getInt("Type");
//                FileTypes:
//                0 - MAC file, a routine containing macros
//                1 - INT file, a standard routine
//                2 - INC file, an include file
//                3 - BAS file, a Cache Basic routine
//                4 - CLS, a class
//                5 - CSP, a Cache Server Page or another file in this directory
//                7 - GBL, a Global
//                8 - PRJ, a Project
//                9 - a Package
//                10 - a CSP application
//                11 - MVB file, a MultiValue Basic macro routine
//                12 - MVI file, a MultiValue Basic routine
//                13 - OBJ, object code
                CacheRootFile file = null;
                if ((fileType == 0) || (fileType == 1) || (fileType == 2) || (fileType == 3) || (fileType == 11) || (fileType == 12)) {
                    file = new CacheRootFile(fileName);
                } else if (fileType == 4) {
                    file = new CacheRootFile(fileName);
                } else if (fileType == 5) {
                } else if ((fileType == 8) && (showProjectFiles)) {
                    file = new CacheRootFile(fileName);
                } else if (fileType == 9) {
                    file = new CacheRootFile(fileName + ".pkg");
                }
                if (file != null) {
//                    System.out.println("getFiles: " + fileName + " - " + fileType + " - " + ((file != null) && ((file.fileExt.equalsIgnoreCase("prj")) || (!file.isDirectory()) || (file.listFiles(filter, showSystemFiles, showGeneratedFiles, showProjectFiles).length > 0))));
                }
                // files and is not empty directories
                if ((file != null) && ((file.fileExt.equalsIgnoreCase("prj")) || (!file.isDirectory()) || (file.listFiles(filter, showSystemFiles, showGeneratedFiles, showProjectFiles).length > 0))) {
                    files.add(file);
                }


            }
        } catch (CacheException | SQLException ex) {
            ex.printStackTrace();
        }
        return files.toArray(new File[files.size()]);
    }

    @Override
    public boolean isDirectory() {
        switch (fileExt) {
            case "pkg":
            case "prj":
            case "":
                return true;
            default:
                return false;
        }
    }

    @Override
    public boolean isFile() {
        return !isDirectory();
    }

    @Override
    public boolean exists() {
        return true;
    }

    @Override
    public String getAbsolutePath() {
        return this.connectionName + "/" + this.fullFileName;
    }

    public String getFullName() {
        String fullName = this.fullFileName;
        if ("pkg".equals(fileExt)) {
            fullName = fullName.substring(0, fullName.lastIndexOf("."));
        }
        return fullName;
    }

    @Override
    public String getName() {
        String name = (shortFileName.isEmpty()) ? connectionName : shortFileName;
        if ("pkg".equals(fileExt)) {
            name = shortFileName.substring(0, shortFileName.lastIndexOf("."));
        }
        return name;
    }

    @Override
    public boolean isAbsolute() {
        return true;
    }

    @Override
    public String getCanonicalPath() throws IOException {
        return getAbsolutePath();
    }

    @Override
    public File getAbsoluteFile() {
        return this;
    }

    @Override
    public File getCanonicalFile() throws IOException {
        return this;
    }

    @Override
    public String getParent() {
        String parent = "";
        if (!isRoot) {
            String packageName = path.replaceAll("^[^\\/]*\\/(?:(.*)\\/)?.*$", "$1");
            if (packageName.isEmpty()) {
                parent = connectionName;
            } else {
                parent = connectionName + "/" + packageName.replaceAll("/", ".") + ".pkg";
            }
        }
        return parent;
    }

    @Override
    public File getParentFile() {
        String parent = getParent();
        if (parent.isEmpty()) {
            return null;
        } else {
            return new CacheRootFile(parent);
        }
    }

    @Override
    public long length() {
        long length = -1;
        try {
            CacheObject cacheObj = getCacheObject();
            if (null != cacheObj) {
                Dataholder prop = cacheObj.getProperty("Size", false);
                length = prop.getLong();
            }
        } catch (CacheException ex) {
        }
        return length;
    }

    @Override
    public long getUsableSpace() {
        return length();
    }

    @Override
    public long getTotalSpace() {
        return length();
    }

    @Override
    public long lastModified() {
        try {
            System.out.println("getLastTime: " + this.getAbsolutePath());
            CacheObject cacheObj = getCacheObject();
            Dataholder prop = cacheObj.getProperty("TimeStamp", true);
            Date date = prop.getDate();
            System.out.println("time is: " + date);
        } catch (CacheException ex) {
        }
        return 0;
    }

    public String getConnectionName() {
        return connectionName;
    }

    @Override
    public URI toURI() {
        try {
            return new URI("isc", this.connectionName, "/" + this.fullFileName, null);
        } catch (URISyntaxException ex) {
            return null;
        }
    }

    @Override
    public Path toPath() {
        return super.toPath();
    }
    
    public CacheFile getExtFile() {
        try {
            switch (fileExt) {
                case "bas":
                case "mac":
                case "inc":
                case "int":
                    return new RoutineFile(db, getName());
                case "cls":
                    String className = getName();
                    className = className.substring(0, className.length() - 4);
                    return new ClassFile(db, className);
                default:
                    return null;
            }
        } catch (CacheException ex) {
            return null;
        }
    }

    public InputStream open() throws CacheException {
        InputStream empty = new ByteArrayInputStream(new byte[0]);
        CacheFile extFile = getExtFile();
        return (extFile != null) ? extFile.open() : empty;
    }

    public void save(byte[] data) throws CacheException {
        CacheFile extFile = getExtFile();
        Logger.Log("Saving: " + getFullName());
        if (extFile != null) {
            extFile.save(data);
        } else {
            Logger.Log("SavingError: Cache object was not found.");
        }
    }
}
