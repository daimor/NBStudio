/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.cachefilesystem;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

/**
 *
 * @author daimor
 */
public class CacheURLHandler extends URLStreamHandler{

    @Override
    protected URLConnection openConnection(URL url) throws IOException {
        return new CacheURLConnection(url);
    }
    
}
