/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.syntax.mac;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.swing.event.ChangeListener;
import javax.swing.text.Document;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.RecognitionException;
import org.nbstudio.syntax.EditorParserResult;
import org.nbstudio.syntax.ErrorListener;
import org.nbstudio.syntax.SyntaxError;
import org.nbstudio.syntax.mac.macParser.ProgContext;
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
public class macEditorParser extends Parser {

    private Snapshot snapshot;
    private macParser macParser;
    public List<SyntaxError> syntaxErrors;
    public static int embeddedOffset;

    public macEditorParser() {
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
//        Logger.Log("macparse: " + syntaxErrors.size() + " - " + embeddedOffset);
        if (embeddedOffset <= 0) {
            syntaxErrors.clear();
        }
        ANTLRInputStream input = new ANTLRInputStream(snapshot.getText().toString());
        Lexer lexer = new macLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        macParser = new macParser(tokens);
        macParser.removeErrorListeners();
        macParser.addErrorListener(new ErrorListener(syntaxErrors, embeddedOffset));
        try {
            ProgContext prog = macParser.prog();
        } catch (RecognitionException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Result getResult(Task task) throws ParseException {
        return new EditorParserResult(snapshot, macParser, syntaxErrors);
    }

    @Override
    public void addChangeListener(ChangeListener cl) {
    }

    @Override
    public void removeChangeListener(ChangeListener cl) {
    }

    static public final class Factory extends ParserFactory {

        @Override
        public Parser createParser(Collection<Snapshot> snapshots) {
            return new macEditorParser();
        }
    }
}
