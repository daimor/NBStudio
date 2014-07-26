/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.core.cls;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.swing.text.JTextComponent;
import javax.swing.text.StyledDocument;
import org.netbeans.api.editor.completion.Completion;
import org.netbeans.api.editor.mimelookup.MimeRegistration;
import org.netbeans.spi.editor.completion.CompletionItem;
import org.netbeans.spi.editor.completion.CompletionProvider;
import org.netbeans.spi.editor.completion.CompletionResultSet;
import org.netbeans.spi.editor.completion.CompletionTask;
import org.netbeans.spi.editor.completion.support.AsyncCompletionQuery;
import org.netbeans.spi.editor.completion.support.AsyncCompletionTask;
import org.netbeans.spi.editor.completion.support.CompletionUtilities;
import org.openide.util.Exceptions;

@MimeRegistration(mimeType = "text/isc-cls", service = CompletionProvider.class)
public class clsCodeCompletion implements CompletionProvider {

    @Override
    public CompletionTask createTask(int queryType, JTextComponent component) {
        if (queryType != CompletionProvider.COMPLETION_QUERY_TYPE) {
            return null;
        }

        return new AsyncCompletionTask(new AsyncCompletionQuery() {
            @Override
            protected void query(CompletionResultSet completionResultSet, Document document, int caretOffset) {

                String filter;
                int startOffset;

                try {
                    final StyledDocument bDoc = (StyledDocument) document;
                    final int lineStartOffset = getRowFirstNonWhite(bDoc, caretOffset);
                    final char[] line = bDoc.getText(lineStartOffset, caretOffset - lineStartOffset).toCharArray();
                    final int whiteOffset = indexOfWhite(line);
                    filter = new String(line, whiteOffset + 1, line.length - whiteOffset - 1);
                    filter = filter.toLowerCase();
                    if (whiteOffset > 0) {
                        startOffset = lineStartOffset + whiteOffset + 1;
                    } else {
                        startOffset = lineStartOffset;
                    }
                    
                    String[] keywords = new String[]{"ClassMethod", "Method", "Property", "Parameter", "Index"};
                    for (String keyword : keywords) {
                        if (!keyword.equals("") && keyword.toLowerCase().startsWith(filter)) {
                            completionResultSet.addItem(new clsCompletionItem(keyword, startOffset, caretOffset));
                        }
                    }
                    
                } catch (BadLocationException ex) {
                    Exceptions.printStackTrace(ex);
                }
                completionResultSet.finish();
            }
        }, component);
    }

    @Override
    public int getAutoQueryTypes(JTextComponent component, String typedText) {
        return 0;
    }

    static int getRowFirstNonWhite(StyledDocument doc, int offset)
            throws BadLocationException {
        Element lineElement = doc.getParagraphElement(offset);
        int start = lineElement.getStartOffset();
        while (start + 1 < lineElement.getEndOffset()) {
            try {
                if (doc.getText(start, 1).charAt(0) != ' ') {
                    break;
                }
            } catch (BadLocationException ex) {
                throw (BadLocationException) new BadLocationException(
                        "calling getText(" + start + ", " + (start + 1)
                        + ") on doc of length: " + doc.getLength(), start).initCause(ex);
            }
            start++;
        }
        return start;
    }

    static int indexOfWhite(char[] line) {
        int i = line.length;
        while (--i > -1) {
            final char c = line[i];
            if (Character.isWhitespace(c)) {
                return i;
            }
        }
        return -1;
    }

    private static class clsCompletionItem implements CompletionItem {

        private final String text;
        private static final Color fieldColor = Color.decode("0x0000B2");
        private final int caretOffset;
        private final int dotOffset;

        public clsCompletionItem(String text, int dotOffset, int caretOffset) {
            this.text = text;
            this.dotOffset = dotOffset;
            this.caretOffset = caretOffset;
        }

        @Override
        public void defaultAction(JTextComponent component) {
            try {
                StyledDocument doc = (StyledDocument) component.getDocument();
                //Here we remove the characters starting at the start offset
                //and ending at the point where the caret is currently found:
                doc.remove(dotOffset, caretOffset - dotOffset);
                doc.insertString(dotOffset, text, null);
                Completion.get().hideAll();
            } catch (BadLocationException ex) {
                Exceptions.printStackTrace(ex);
            }
        }

        @Override
        public void processKeyEvent(KeyEvent evt) {
        }

        @Override
        public int getPreferredWidth(Graphics graphics, Font font) {
            return CompletionUtilities.getPreferredWidth(text, null, graphics, font);
        }

        @Override
        public void render(Graphics g, Font defaultFont, Color defaultColor, Color backgroundColor, int width, int height, boolean selected) {
            CompletionUtilities.renderHtml(null, text, null, g, defaultFont,
                    (selected ? Color.white : fieldColor), width, height, selected);
        }

        @Override
        public CompletionTask createDocumentationTask() {
            return null;
        }

        @Override
        public CompletionTask createToolTipTask() {
            return null;
        }

        @Override
        public boolean instantSubstitution(JTextComponent component) {
            return false;
        }

        @Override
        public int getSortPriority() {
            return 0;
        }

        @Override
        public CharSequence getSortText() {
            return text;
        }

        @Override
        public CharSequence getInsertPrefix() {
            return text;
        }
    }
}
