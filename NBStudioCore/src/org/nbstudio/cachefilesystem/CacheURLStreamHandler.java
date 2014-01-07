/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.cachefilesystem;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import org.openide.util.URLStreamHandlerRegistration;

/**
 *
 * @author daimor
 */
@URLStreamHandlerRegistration(protocol = {CacheURLMapper.PROTOCOL})
public class CacheURLStreamHandler extends URLStreamHandler {

    @Override
    protected URLConnection openConnection(URL url) throws IOException {
        System.out.println("MyHandler: " + this);
        return new CacheURLConnection(url);
    }
}
