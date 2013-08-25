/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.syntax;

import java.util.ArrayList;
import java.util.List;
import javax.swing.event.ChangeListener;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.nbstudio.syntax.clsParser.ProgContext;
import org.nbstudio.utils.Logger;
import org.netbeans.modules.parsing.api.Snapshot;
import org.netbeans.modules.parsing.api.Task;
import org.netbeans.modules.parsing.spi.ParseException;
import org.netbeans.modules.parsing.spi.Parser;
import org.netbeans.modules.parsing.spi.SourceModificationEvent;

/**
 *
 * @author daimor
 */
public class clsEditorParser extends Parser {

    private Snapshot snapshot;
    private clsParser clsParser;
    public static List<SyntaxError> syntaxErrors = new ArrayList<SyntaxError>();

    public static class SyntaxError {

        public String message;
        public int line;
        public int charPositionInLine;
        public int start;
        public int stop;
    }

    public static class clsErrorListener extends BaseErrorListener {

        public void syntaxError(Recognizer<?, ?> recognizer,
                Object offendingSymbol,
                int line, int charPositionInLine,
                String msg,
                RecognitionException e) {
            System.err.println("line " + line + ":" + charPositionInLine + " " + msg);
            underlineError(recognizer, (Token) offendingSymbol,
                    line, charPositionInLine, msg);
        }

        protected void underlineError(Recognizer recognizer,
                Token offendingToken, int line,
                int charPositionInLine, String msg) {
            CommonTokenStream tokens =
                    (CommonTokenStream) recognizer.getInputStream();
            String input = tokens.getTokenSource().getInputStream().toString();
            String[] lines = input.split("\n");
            String errorLine = lines[line - 1];
            System.err.println(errorLine);
            for (int i = 0; i < charPositionInLine; i++) {
                System.err.print(" ");
            }
            int start = offendingToken.getStartIndex();
            int stop = offendingToken.getStopIndex();
            if (start >= 0 && stop >= 0) {
                for (int i = start; i <= stop; i++) {
                    System.err.print("^");
                }
            }
            System.err.println();
            SyntaxError syntaxError = new SyntaxError();
            syntaxError.message = msg;
            syntaxError.line = line;
            syntaxError.charPositionInLine = charPositionInLine;
            syntaxError.start = start;
            syntaxError.stop = stop + 1;
            syntaxErrors.add(syntaxError);
        }
    }

    @Override
    public void parse(Snapshot snapshot, Task task, SourceModificationEvent event) {
        this.snapshot = snapshot;
        ANTLRInputStream input = new ANTLRInputStream(snapshot.getText().toString());
        Lexer lexer = new clsLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        syntaxErrors.clear();
        clsParser = new clsParser(tokens);
        clsParser.removeErrorListeners();
        clsParser.addErrorListener(new clsErrorListener());
        
        try {
            ProgContext prog = clsParser.prog();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Result getResult(Task task) throws ParseException {
        return new clsEditorParserResult(snapshot, clsParser, syntaxErrors);
    }

    @Override
    public void addChangeListener(ChangeListener cl) {
    }

    @Override
    public void removeChangeListener(ChangeListener cl) {
    }

    public static class clsEditorParserResult extends Result {

        private clsParser clsParser;
        private boolean valid = true;
        private List<SyntaxError> syntaxErrors = new ArrayList<SyntaxError>();

        clsEditorParserResult(Snapshot snapshot, clsParser clsParser, List<SyntaxError> syntaxErrors) {
            super(snapshot);
            this.clsParser = clsParser;
            this.syntaxErrors = syntaxErrors;
        }

        public clsParser getclsParser() throws ParseException {
            if (!valid) {
                throw new ParseException();
            }
            return clsParser;
        }

        public List<SyntaxError> getSyntaxErrors() throws ParseException {
            if (!valid) {
                throw new ParseException();
            }
            return syntaxErrors;
        }

        @Override
        protected void invalidate() {
            valid = false;
        }
    }
}
