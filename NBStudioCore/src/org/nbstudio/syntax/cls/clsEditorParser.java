/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.syntax.cls;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.swing.event.ChangeListener;
import javax.swing.text.Document;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.tree.*;
import org.nbstudio.syntax.EditorParserResult;
import org.nbstudio.syntax.ErrorListener;
import org.nbstudio.syntax.SyntaxError;
import org.nbstudio.syntax.cls.clsParser.ProgContext;
import static org.nbstudio.syntax.mac.macEditorParser.embeddedOffset;
import org.netbeans.modules.parsing.api.Snapshot;
import org.netbeans.modules.parsing.api.Task;
import org.netbeans.modules.parsing.spi.ParseException;
import org.netbeans.modules.parsing.spi.Parser;
import org.netbeans.modules.parsing.spi.ParserFactory;
import org.netbeans.modules.parsing.spi.SourceModificationEvent;

/**
 *
 * @author daimor
 */
public class clsEditorParser extends Parser {

    private Snapshot snapshot;
    private clsParser clsParser;
    public List<SyntaxError> syntaxErrors;

    public clsEditorParser() {
        this.syntaxErrors = new ArrayList<>();
    }

    @Override
    public void parse(Snapshot snapshot, Task task, SourceModificationEvent event) {
        this.snapshot = snapshot;
        Document document = snapshot.getSource().getDocument(true);
        syntaxErrors = (List<SyntaxError>) document.getProperty("syntaxErrors");
        if (syntaxErrors == null) {
            syntaxErrors = new ArrayList<>();
            document.putProperty("syntaxErrors", syntaxErrors);
        }
        embeddedOffset = snapshot.getOriginalOffset(0);
        if (embeddedOffset <= 0) {
            syntaxErrors.clear();
        }
        ANTLRInputStream input = new ANTLRInputStream(snapshot.getText().toString());
        Lexer lexer = new clsLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        syntaxErrors.clear();
        clsParser = new clsParser(tokens);
        clsParser.removeErrorListeners();
        clsParser.addErrorListener(new ErrorListener(syntaxErrors, 0));
        try {
            ProgContext prog = clsParser.prog();
            ParseTreeWalker walker = new ParseTreeWalker();
            clsMyParserListener listener = new clsMyParserListener(clsParser);
            walker.walk(listener, prog);
        } catch (RecognitionException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Result getResult(Task task) throws ParseException {
        return new EditorParserResult(snapshot, clsParser, syntaxErrors);
    }

    @Override
    public void addChangeListener(ChangeListener cl) {
    }

    @Override
    public void removeChangeListener(ChangeListener cl) {
    }

    static final public class Factory extends ParserFactory {

        @Override
        public Parser createParser(Collection<Snapshot> snapshots) {
            return new clsEditorParser();
        }
    }
}
