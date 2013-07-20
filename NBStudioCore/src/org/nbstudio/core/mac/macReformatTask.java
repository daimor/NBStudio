/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.core.mac;

import javax.swing.text.BadLocationException;
import javax.swing.text.Position;
import org.nbstudio.utils.Logger;
import org.netbeans.modules.editor.indent.spi.Context;
import org.netbeans.modules.editor.indent.spi.ExtraLock;
import org.netbeans.modules.editor.indent.spi.ReformatTask;

/**
 *
 * @author daimor
 */
public class macReformatTask implements ReformatTask {

    private Context context;
    private Position reformatPos;

    public macReformatTask(Context context) {
        this.context = context;
    }

    @Override
    public void reformat() throws BadLocationException {
        Logger.Log("reformat");
    }

    @Override
    public ExtraLock reformatLock() {
        return null;
    }
}
