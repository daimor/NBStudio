/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.syntax;

import java.util.ArrayList;
import java.util.List;
import javax.swing.text.Document;
import org.nbstudio.syntax.clsEditorParser.SyntaxError;
import org.nbstudio.utils.Logger;
import org.netbeans.modules.parsing.spi.Parser.Result;
import org.netbeans.modules.parsing.spi.ParserResultTask;
import org.netbeans.modules.parsing.spi.Scheduler;
import org.netbeans.modules.parsing.spi.SchedulerEvent;
import org.netbeans.spi.editor.hints.ErrorDescription;
import org.netbeans.spi.editor.hints.ErrorDescriptionFactory;
import org.netbeans.spi.editor.hints.HintsController;
import org.netbeans.spi.editor.hints.Severity;


/**
 *
 * @author daimor
 */
public class clsSyntaxErrorsHighlightingTask<T extends Result> extends ParserResultTask {

    public clsSyntaxErrorsHighlightingTask() {
    }

    @Override
    public void run(Result result, SchedulerEvent event) {
        try {
            Document document = result.getSnapshot ().getSource ().getDocument(true);
            List<ErrorDescription> errors = new ArrayList<ErrorDescription> ();
            clsEditorParser.clsEditorParserResult rsaResult = (clsEditorParser.clsEditorParserResult) result;
            List<SyntaxError> syntaxErrors = rsaResult.getSyntaxErrors();
            for (SyntaxError syntaxError : syntaxErrors) { 
                ErrorDescription errorDescription = ErrorDescriptionFactory.createErrorDescription(
                    Severity.ERROR,
                    syntaxError.message,
                    document,
                    document.createPosition(syntaxError.start),
                    document.createPosition(syntaxError.stop)
                );
                errors.add (errorDescription);
                Logger.Log(errors.toString());
            }
            HintsController.setErrors (document, "clsEditor", errors);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public int getPriority() {
        return 100;
    }

    @Override
    public Class<? extends Scheduler> getSchedulerClass() {
        return Scheduler.EDITOR_SENSITIVE_TASK_SCHEDULER;
    }

    @Override
    public void cancel() {
    }
}
