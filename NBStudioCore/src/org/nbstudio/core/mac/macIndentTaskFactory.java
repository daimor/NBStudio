/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.core.mac;

import org.netbeans.api.editor.mimelookup.MimeRegistration;
import org.netbeans.modules.editor.indent.spi.Context;
import org.netbeans.modules.editor.indent.spi.IndentTask;

@MimeRegistration(mimeType = "text/isc-mac", service = IndentTask.Factory.class)
public class macIndentTaskFactory implements IndentTask.Factory {

    @Override
    public IndentTask createTask(Context cntxt) {
        return new macIndentTask(cntxt);
    }
    
}
