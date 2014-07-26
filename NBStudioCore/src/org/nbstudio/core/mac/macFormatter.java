/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.core.mac;

import org.netbeans.api.editor.EditorRegistry;
import org.netbeans.editor.BaseDocument;
import org.netbeans.modules.csl.spi.ParserResult;
import org.netbeans.modules.editor.indent.spi.Context;
import org.netbeans.spi.lexer.MutableTextInput;

/**
 *
 * @author daimor
 */
public class macFormatter {

    public macFormatter() {
    }

    public void reformat(Context context, ParserResult info) {
        final Context formatContext = context;
        final BaseDocument doc = (BaseDocument) context.document();

        doc.runAtomic(new Runnable() {
            @Override
            public void run() {

                final int caretOffset = EditorRegistry.lastFocusedComponent() != null
                        ? EditorRegistry.lastFocusedComponent().getCaretPosition()
                        : 0;

                MutableTextInput mti = (MutableTextInput) doc.getProperty(MutableTextInput.class);
                try {
                    mti.tokenHierarchyControl().setActive(false);

                } finally {
                    mti.tokenHierarchyControl().setActive(true);
                }
            }
        });

    }
}
