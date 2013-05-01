/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.syntax;

import java.util.Collection;
import java.util.Collections;
import org.netbeans.modules.parsing.api.Snapshot;
import org.netbeans.modules.parsing.spi.SchedulerTask;
import org.netbeans.modules.parsing.spi.TaskFactory;
import org.netbeans.modules.parsing.spi.Parser.Result;

/**
 *
 * @author daimor
 */
public class macSyntaxErrorsHighlightingTaskFactory extends TaskFactory{

    @Override
    public Collection<? extends SchedulerTask> create(Snapshot snpsht) {
        return Collections.singleton(new macSyntaxErrorsHighlightingTask<Result>());
    }
    
}
