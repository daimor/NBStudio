/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.syntax;

import java.util.ArrayList;
import java.util.List;
import org.antlr.v4.runtime.Parser;
import org.netbeans.modules.parsing.api.Snapshot;
import org.netbeans.modules.parsing.spi.ParseException;
import org.netbeans.modules.parsing.spi.Parser.Result;

/**
 *
 * @author daimor
 */
public class EditorParserResult extends Result {

    private final Parser parser;
    private boolean valid = false;
    private List<SyntaxError> syntaxErrors = new ArrayList<>();

    public EditorParserResult(Snapshot snapshot, Parser parser, List<SyntaxError> syntaxErrors) {
        super(snapshot);
        this.parser = parser;
        this.syntaxErrors = syntaxErrors;
        this.valid = true;
    }

    public Parser getParser() throws ParseException {
        if (!valid) {
            throw new ParseException();
        }
        return parser;
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
