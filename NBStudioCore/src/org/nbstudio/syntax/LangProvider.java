/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.syntax;

import org.nbstudio.syntax.cls.CLSLanguageHierarchy;
import org.nbstudio.syntax.cls.clsLexer;
import org.nbstudio.syntax.mac.macLanguageHierarchy;
import org.nbstudio.syntax.xdata.xdataLanguageHierarchy;
import org.netbeans.api.lexer.InputAttributes;
import org.netbeans.api.lexer.Language;
import org.netbeans.api.lexer.LanguagePath;
import org.netbeans.api.lexer.Token;
import org.netbeans.spi.lexer.LanguageEmbedding;
import org.netbeans.spi.lexer.LanguageProvider;

/**
 *
 * @author daimor
 */
@org.openide.util.lookup.ServiceProvider(service = org.netbeans.spi.lexer.LanguageProvider.class)
public class LangProvider extends LanguageProvider {

    @Override
    public Language<?> findLanguage(String mimeType) {
        if ("text/isc-mac".equals(mimeType)) {
            return new macLanguageHierarchy().language();
        }
        if ("text/isc-cls".equals(mimeType)) {
            return new CLSLanguageHierarchy().language();
        }
        if ("text/isc-xdata".equals(mimeType)) {
            return new xdataLanguageHierarchy().language();
        }
        return null;
    }

    @Override
    public LanguageEmbedding<?> findLanguageEmbedding(Token<?> token, LanguagePath languagePath, InputAttributes inputAttributes) {
//        Logger.Log("findEmbedding: " + languagePath.mimePath() + " - " + token.id().name());
        if (languagePath.mimePath().equals("text/isc-cls")) {
            if (CLSLanguageHierarchy.getToken(clsLexer.MethodDeclaration) == token.id()) {
                return LanguageEmbedding.create(new macLanguageHierarchy().language(), 1, 1);
            } else if (CLSLanguageHierarchy.getToken(clsLexer.XDataDeclaration) == token.id()) {
                return LanguageEmbedding.create(new xdataLanguageHierarchy().language(), 1, 1);
            }
        }
        return null;
    }
}
