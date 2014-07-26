/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.core.cls;

import org.netbeans.api.editor.mimelookup.MimeRegistration;
import org.netbeans.modules.editor.indent.spi.Context;
import org.netbeans.modules.editor.indent.spi.IndentTask;

@MimeRegistration(mimeType = "text/isc-cls", service = IndentTask.Factory.class)
public class clsIndentTaskFactory implements IndentTask.Factory {

    @Override
    public IndentTask createTask(Context cntxt) {
        return new clsIndentTask(cntxt);
    }
    
}
