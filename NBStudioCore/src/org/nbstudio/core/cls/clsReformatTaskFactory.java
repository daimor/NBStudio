/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.core.cls;

import org.netbeans.api.editor.mimelookup.MimeRegistration;
import org.netbeans.modules.editor.indent.spi.Context;
import org.netbeans.modules.editor.indent.spi.ReformatTask;

@MimeRegistration(mimeType = "text/isc-cls", service = ReformatTask.Factory.class)
public class clsReformatTaskFactory implements ReformatTask.Factory {

    @Override
    public ReformatTask createTask(Context cntxt) {
        return new clsReformatTask(cntxt);
    }
    
}
