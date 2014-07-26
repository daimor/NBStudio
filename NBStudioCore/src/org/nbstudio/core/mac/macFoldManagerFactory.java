/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.core.mac;

import org.netbeans.api.editor.mimelookup.MimeRegistration;
import org.netbeans.spi.editor.fold.FoldManager;
import org.netbeans.spi.editor.fold.FoldManagerFactory;

@MimeRegistration(mimeType = "text/isc-mac", service = FoldManagerFactory.class)
public class macFoldManagerFactory implements FoldManagerFactory{

    @Override
    public FoldManager createFoldManager() {
        return new macFoldManager();
    }
    
}
