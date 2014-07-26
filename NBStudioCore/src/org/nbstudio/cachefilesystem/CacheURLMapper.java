/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.cachefilesystem;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import org.nbstudio.core.Connection;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileStateInvalidException;
import org.openide.filesystems.FileSystem;
import org.openide.filesystems.URLMapper;
import org.openide.util.Exceptions;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author daimor
 */
@ServiceProvider(service = URLMapper.class)
public class CacheURLMapper extends URLMapper {

    public static final String PROTOCOL = "isc";     //NOI18N

    @Override
    public URL getURL(FileObject fo, int type) {
        if (fo instanceof CacheFileObject) {
            try {
                CacheFileObject cfo = (CacheFileObject) fo;
                CacheFileSystem fs = (CacheFileSystem) cfo.getFileSystem();
                String connName = fs.getConnection().getTitle();
                return new URL(PROTOCOL, connName, cfo.getFullPath());
            } catch (MalformedURLException | FileStateInvalidException ex) {
            }
        }
        return null;
    }

    @Override
    public FileObject[] getFileObjects(URL url) {
        return (PROTOCOL.equals(url.getProtocol())) ? decodeURL(url) : null;
    }

    /**
     * Resolves URL into the array of the FileObjects.
     *
     * @param url to be resolved
     * @return FileObject[], returns null if unknown url protocol.
     */
    static FileObject[] decodeURL(URL url) {
        assert url != null;
        try {
            URI uri = new URI(url.toExternalForm());
            String protocol = uri.getScheme();
            if (PROTOCOL.equals(protocol)) {
                String connectionName = uri.getHost();
                String path = uri.getPath();
                try {
                    Connection conn = Connection.getConnection(connectionName);
                    if (conn != null) {
                        CacheRootFile file = new CacheRootFile(connectionName + path);
                        FileSystem fs = conn.getFileSystem();
                        if (fs.getRoot() != null) {
                            FileObject fo = fs.getRoot().getFileObject(path);
                            return new FileObject[]{fo};
                        }
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        } catch (URISyntaxException use) {
            Exceptions.printStackTrace(use);
        }
        return null;
    }
}
