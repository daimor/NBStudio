/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.core.cls;

import javax.swing.event.DocumentEvent;
import org.netbeans.api.editor.fold.Fold;
import org.netbeans.api.editor.fold.FoldType;
import org.netbeans.spi.editor.fold.FoldHierarchyTransaction;
import org.netbeans.spi.editor.fold.FoldManager;
import org.netbeans.spi.editor.fold.FoldOperation;

public class clsFoldManager implements FoldManager {

    private FoldOperation operation;
    public static final FoldType COMMENT_FOLD_TYPE = new FoldType("/*...*/");

    @Override
    public void init(FoldOperation operation) {
        this.operation = operation;
    }

    @Override
    public void initFolds(FoldHierarchyTransaction transaction) {
//        FoldHierarchy hierarchy = operation.getHierarchy();
//        Document document = hierarchy.getComponent().getDocument();
//        TokenHierarchy<Document> hi = TokenHierarchy.get(document);
//        TokenSequence<clsTokenId> ts = (TokenSequence<clsTokenId>) hi.tokenSequence();
//        FoldType type = null;
//        int start = 0;
//        int offset = 0;
//        while (ts.moveNext()) {
//            offset = ts.offset();
//            Token<clsTokenId> token = ts.token();
//            clsTokenId id = token.id();
//            if (id.name().equals("FORMAL_COMMENT") && type == null) {
//                type = COMMENT_FOLD_TYPE;
//                start = offset;
//                try {
//                    operation.addToHierarchy(
//                            type,
//                            type.toString(),
//                            false,
//                            start,
//                            offset + token.length(),
//                            0,
//                            0,
//                            hierarchy,
//                            transaction);
//                } catch (BadLocationException ex) {
//                    Exceptions.printStackTrace(ex);
//                }
//            }
//        }
    }

    @Override
    public void insertUpdate(DocumentEvent evt, FoldHierarchyTransaction transaction) {
    }

    @Override
    public void removeUpdate(DocumentEvent evt, FoldHierarchyTransaction transaction) {
    }

    @Override
    public void changedUpdate(DocumentEvent evt, FoldHierarchyTransaction transaction) {
    }

    @Override
    public void removeEmptyNotify(Fold epmtyFold) {
    }

    @Override
    public void removeDamagedNotify(Fold damagedFold) {
    }

    @Override
    public void expandNotify(Fold expandedFold) {
    }

    @Override
    public void release() {
    }
}
