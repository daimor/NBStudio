/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.syntax;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import org.netbeans.modules.parsing.api.Snapshot;
import org.netbeans.modules.parsing.spi.ParseException;
import org.netbeans.modules.parsing.spi.Parser.Result;
import org.netbeans.modules.parsing.spi.ParserResultTask;
import org.netbeans.modules.parsing.spi.Scheduler;
import org.netbeans.modules.parsing.spi.SchedulerEvent;
import org.netbeans.modules.parsing.spi.SchedulerTask;
import org.netbeans.modules.parsing.spi.TaskFactory;
import org.netbeans.spi.editor.hints.ErrorDescription;
import org.netbeans.spi.editor.hints.ErrorDescriptionFactory;
import org.netbeans.spi.editor.hints.HintsController;
import org.netbeans.spi.editor.hints.Severity;

/**
 *
 * @author daimor
 */
public class SyntaxErrorsHighlightingTask<T extends Result> extends ParserResultTask {

    public SyntaxErrorsHighlightingTask() {
    }

    @Override
    public void run(Result result, SchedulerEvent event) {
        try {
            Document document = result.getSnapshot().getSource().getDocument(true);
            List<ErrorDescription> errors = new ArrayList<>();
            EditorParserResult parserResult = (EditorParserResult) result;
            List<SyntaxError> syntaxErrors = parserResult.getSyntaxErrors();
            int cnt = 0;
            for (SyntaxError syntaxError : syntaxErrors) {
                ErrorDescription errorDescription = ErrorDescriptionFactory.createErrorDescription(
                        Severity.ERROR,
                        syntaxError.message,
                        document,
                        document.createPosition(syntaxError.start),
                        document.createPosition(syntaxError.stop));
                errors.add(errorDescription);
                cnt++;
//                Logger.Log("hintError[" + (cnt) + "]: " + errorDescription.getDescription());
            }
//            Logger.Log("getErrors: " + offset + ":" + cnt + " - " + parserResult.getParser().getGrammarFileName());
            HintsController.setErrors(document, "editor", errors);
        } catch (BadLocationException | ParseException ex) {
//            ex.printStackTrace();
        }
    }

    @Override
    public int getPriority() {
        return 999;
    }

    @Override
    public Class<? extends Scheduler> getSchedulerClass() {
        return Scheduler.EDITOR_SENSITIVE_TASK_SCHEDULER;
    }

    @Override
    public void cancel() {
    }

    static public class Factory extends TaskFactory {

        @Override
        public Collection<? extends SchedulerTask> create(Snapshot snpsht) {
//            if (snpsht.getOriginalOffset(0) > 0) {
//                return Collections.EMPTY_LIST;
//            }
            return Collections.singleton(new SyntaxErrorsHighlightingTask<>());

        }
    }
}
