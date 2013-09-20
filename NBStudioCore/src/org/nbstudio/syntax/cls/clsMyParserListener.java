/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.syntax.cls;

import java.util.Arrays;
import org.antlr.v4.runtime.ParserRuleContext;
import org.netbeans.modules.parsing.api.Embedding;
import org.netbeans.modules.parsing.api.Source;

/**
 *
 * @author daimor
 */
public class clsMyParserListener extends clsParserBaseListener {

    clsParser parser;

    clsMyParserListener(clsParser parser) {
        this.parser = parser;
    }

}
