/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.core.cls;

import org.netbeans.api.editor.mimelookup.MimeRegistration;
import org.netbeans.spi.editor.fold.FoldManager;
import org.netbeans.spi.editor.fold.FoldManagerFactory;

@MimeRegistration(mimeType = "text/isc-cls", service = FoldManagerFactory.class)
public class clsFoldManagerFactory implements FoldManagerFactory{

    @Override
    public FoldManager createFoldManager() {
        return new clsFoldManager();
    }
    
}
