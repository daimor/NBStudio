/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.core.mac;

import java.io.IOException;
import org.openide.filesystems.FileObject;
import org.openide.loaders.DataObjectExistsException;
import org.openide.loaders.ExtensionList;
import org.openide.loaders.MultiDataObject;
import org.openide.loaders.UniFileLoader;

/**
 *
 * @author daimor
 */
public class macDataLoader extends UniFileLoader {

    public static final String EXT = "mac";
    public static final String MIME = "text/isc-mac";

    public macDataLoader() {
        super("org.nbstudio.core.mac.macDataObject");
    }
    
    

    @Override
    protected void initialize() {
        super.initialize();
        
        ExtensionList ext = getExtensions();
        ext.addExtension(EXT);
        ext.addMimeType(MIME);
        setExtensions(ext);
    }

    @Override
    protected MultiDataObject createMultiObject(FileObject primaryFile) throws DataObjectExistsException, IOException {
        return new macDataObject(primaryFile, this);
    }
}
