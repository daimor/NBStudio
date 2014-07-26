/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.core.mac;

import org.nbstudio.utils.Logger;
import org.netbeans.modules.editor.NbEditorKit;

/**
 *
 * @author daimor
 */
public class editorKit extends NbEditorKit {

    public editorKit() {
        super();
        Logger.Log("editorKit");
//        editorKitSettingsInitializer.init();
    }

    @Override
    public String getContentType() {
        return super.getContentType();
    }
}
