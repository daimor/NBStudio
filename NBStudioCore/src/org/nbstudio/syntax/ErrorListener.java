/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.syntax;

import java.util.List;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token;

/**
 *
 * @author daimor
 */
public class ErrorListener extends BaseErrorListener {

    int embeddedOffset;
    List<SyntaxError> syntaxErrors;

    public ErrorListener(List<SyntaxError> syntaxErrors, int embeddedOffset) {
        this.syntaxErrors = syntaxErrors;
        this.embeddedOffset = embeddedOffset;
    }

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
        underlineError(recognizer, (Token) offendingSymbol, line, charPositionInLine, msg);
    }

    protected void underlineError(Recognizer<?, ?> recognizer, Token offendingToken, int line, int charPositionInLine, String msg) {
        CommonTokenStream tokens = (CommonTokenStream) recognizer.getInputStream();

        int start = offendingToken.getStartIndex() + embeddedOffset;
        int stop = offendingToken.getStopIndex() + embeddedOffset;

        SyntaxError syntaxError = new SyntaxError();
        syntaxError.message = msg;
        syntaxError.line = line;
        syntaxError.charPositionInLine = charPositionInLine;
        syntaxError.start = start;
        syntaxError.stop = stop + 1;
        syntaxErrors.add(syntaxError);
    }
}
