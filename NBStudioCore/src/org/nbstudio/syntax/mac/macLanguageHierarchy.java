/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.syntax.mac;

import org.nbstudio.syntax.utils.ANTLRTokenReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.nbstudio.syntax.utils.ANTLRTokenId;
import org.netbeans.api.lexer.Language;
import org.netbeans.spi.lexer.LanguageHierarchy;
import org.netbeans.spi.lexer.Lexer;
import org.netbeans.spi.lexer.LexerRestartInfo;

/**
 *
 * @author daimor
 */
public class macLanguageHierarchy extends LanguageHierarchy<ANTLRTokenId> {

    private static List<ANTLRTokenId> tokens;
    private static Map<Integer, ANTLRTokenId> idToToken;
    private static final Language<ANTLRTokenId> language = new macLanguageHierarchy().language();

    public static Language<ANTLRTokenId> getLanguage() {
        return language;
    }

    private static void init() {
        ANTLRTokenReader reader = new ANTLRTokenReader();
        HashMap<String, String> tokenTypes = new HashMap<>();
        tokenTypes.put("CMD", "command");
        tokenTypes.put("Label", "label");

        tokenTypes.put("ID", "localvariable");
        tokenTypes.put("INT", "number");

        tokenTypes.put("COMMENT", "comment");
        tokenTypes.put("MACROCOMMENT", "comment");
        tokenTypes.put("MULTILINECOMMENT", "comment");

        tokenTypes.put("STRING", "character");

        tokens = reader.readTokenFile("org/nbstudio/syntax/mac/macLexer.tokens", tokenTypes);
        idToToken = new HashMap<>();
        for (ANTLRTokenId token : tokens) {
            idToToken.put(token.ordinal(), token);
        }
    }

    static synchronized ANTLRTokenId getToken(int id) {
        if (idToToken == null) {
            init();
        }
        return idToToken.get(id);
    }

    @Override
    protected Collection<ANTLRTokenId> createTokenIds() {
        if (tokens == null) {
            init();
        }
        return tokens;
    }

    @Override
    protected synchronized Lexer<ANTLRTokenId> createLexer(LexerRestartInfo<ANTLRTokenId> info) {
        return new macEditorLexer(info);
    }

    @Override
    protected String mimeType() {
        return "text/isc-mac";
    }
}
