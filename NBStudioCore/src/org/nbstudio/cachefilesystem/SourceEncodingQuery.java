/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.cachefilesystem;

import java.nio.charset.Charset;
import org.netbeans.spi.queries.FileEncodingQueryImplementation;
import org.openide.filesystems.FileObject;
import org.openide.util.lookup.ServiceProvider;
import org.openide.util.lookup.ServiceProviders;

/**
 *
 * @author daimor
 */
@ServiceProviders({
    @ServiceProvider(service = FileEncodingQueryImplementation.class)})
public class SourceEncodingQuery extends FileEncodingQueryImplementation {

    private static final Charset UTF8 = Charset.forName("UTF-8");
    private static final Charset CP1251 = Charset.forName("windows-1251");

    @Override
    public Charset getEncoding(FileObject file) {
        Charset charset = UTF8;
        return charset;
    }
}
