/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.core.mac;

import javax.swing.text.BadLocationException;
import org.netbeans.editor.BaseDocument;
import org.netbeans.editor.Utilities;
import org.netbeans.modules.editor.indent.spi.Context;
import org.netbeans.modules.editor.indent.spi.ExtraLock;
import org.netbeans.modules.editor.indent.spi.IndentTask;

/**
 *
 * @author daimor
 */
public class macIndentTask implements IndentTask {

    private final Context context;
    private final CodeStyle codeStyle;

    public macIndentTask(Context context) {
        this.context = context;
        this.codeStyle = CodeStyle.getCodeStyle(context.document());
    }

    @Override
    public void reindent() throws BadLocationException {

        int caretOffset = context.caretOffset();
        int lineOffset = context.lineStartOffset(caretOffset);

        final BaseDocument doc = (BaseDocument) context.document();

        int lastNonWhite = Utilities.getFirstNonWhiteBwd(doc, lineOffset);

        IndentMode mode = getMode(lineOffset, lastNonWhite, doc);
        int currentIndent = getCurrentIndent(lastNonWhite, doc);

        switch (mode) {
            case NEW_BLOCK:
                indentNewBlock(lineOffset, currentIndent);
                break;

            case SAME_LEVEL:
                indentSameLevel(lineOffset, currentIndent);
                break;
        }
    }

    @Override
    public ExtraLock indentLock() {
        return null;
    }

    private IndentMode getMode(int lineOffset, int lastNonWhite, BaseDocument doc) throws BadLocationException {
        IndentMode mode = IndentMode.UNKNOWN;
        if (lastNonWhite >= 0 && lastNonWhite < lineOffset) {
            String s = doc.getText(lastNonWhite, 1);
            if (s != null && s.equals("{")) {
                mode = IndentMode.NEW_BLOCK;
            } else {
                mode = IndentMode.SAME_LEVEL;
            }
        }
        return mode;
    }

    private int getCurrentIndent(int lastNonWhite, BaseDocument doc) throws BadLocationException {
        int prevLineStart = Utilities.getRowStart(doc, lastNonWhite);
        int currentIndent = 0;
        if (prevLineStart >= 0) {
            int p = Utilities.getFirstNonWhiteFwd(doc, prevLineStart);
            if (p >= 0 && p >= prevLineStart && p <= lastNonWhite) {
                String s = doc.getText(prevLineStart, p - prevLineStart);

                for (int i = 0; i < s.length(); ++i) {
                    if (s.charAt(i) == '\t') {
                        currentIndent += codeStyle.getTabSize();
                    } else {
                        currentIndent++;
                    }
                }
            }
        }
        return currentIndent;
    }

    private void indentNewBlock(int lineOffset, int indent) throws BadLocationException {
        final BaseDocument doc = (BaseDocument) context.document();

        int countLCurl = getCurlCount(false, lineOffset, doc);
        int countRCurl = getCurlCount(true, lineOffset, doc);

        String s = getIndentString(indent + codeStyle.getIndentSize());
        int newCaretPos = lineOffset + s.length();

        if (countLCurl == (countRCurl + 1)) {

            s += "\n";
            s += getIndentString(indent);
            s += "}";
        }

        doc.insertString(lineOffset, s, null);
        context.setCaretOffset(newCaretPos);
    }

    private void indentSameLevel(int lineOffset, int indent) throws BadLocationException {
        final BaseDocument doc = (BaseDocument) context.document();
        String s = getIndentString(indent);
        int newCaretPos = lineOffset + s.length();
        doc.insertString(lineOffset, s, null);
        context.setCaretOffset(newCaretPos);
    }

    private int getCurlCount(boolean forward, int offset, BaseDocument doc) throws BadLocationException {

        char fwchar, bwchar;
        int from;
        int to;
        int incval;
        if (forward) {
            fwchar = '}';
            bwchar = '{';
            from = offset;
            to = doc.getLength();
            incval = 1;
        } else {
            fwchar = '{';
            bwchar = '}';
            from = offset;
            to = 0;
            incval = -1;
        }

        int count = 0;
        char ca[] = new char[1];
        int mode = 0; // 1 = ', 2 = "

        for (int i = from; i != to; i += incval) {
            doc.getChars(i, ca, 0, 1);

            char c = ca[0];

            if (c == fwchar && mode == 0) {
                count++;
            }

            if (c == bwchar && mode == 0) {
                count--;
            }

            if (c == '"') {
                if (mode == 0) {
                    mode = 2;
                } else if (mode == 2) {
                    mode = 0;
                }
            }

            if (c == '\'') {
                if (mode == 0) {
                    mode = 1;
                } else if (mode == 1) {
                    mode = 0;
                }
            }
        }
        return count;
    }

    private String getIndentString(int indent) {

        StringBuilder sb = new StringBuilder(indent + 2);

        if (codeStyle.getExpandTabToSpaces()) {

            for (int i = 0; i < indent; ++i) {
                sb.append(' ');
            }

        } else {

            int tabCount = indent / codeStyle.getTabSize();
            int spaceCount = indent % codeStyle.getTabSize();

            for (int i = 0; i < tabCount; ++i) {
                sb.append('\t');
            }

            for (int i = 0; i < spaceCount; ++i) {
                sb.append(' ');
            }
        }

        return sb.toString();
    }

    private enum IndentMode {

        UNKNOWN,
        NEW_BLOCK,
        SAME_LEVEL
    };
}
