/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.cachefilesystem;

import java.io.IOException;
import java.net.URL;
import sun.net.www.URLConnection;

/**
 *
 * @author daimor
 */
public class CacheURLConnection extends URLConnection {

    public CacheURLConnection(URL url) {
        super(url);
    }

    @Override
    public void connect() throws IOException {
        
    }
}
