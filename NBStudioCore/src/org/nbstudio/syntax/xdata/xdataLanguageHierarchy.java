/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.syntax.xdata;

import org.nbstudio.syntax.cls.*;
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
public class xdataLanguageHierarchy extends LanguageHierarchy<ANTLRTokenId> {

    private static List<ANTLRTokenId> tokens;
    private static Map<Integer, ANTLRTokenId> idToToken;
    private static final Language<ANTLRTokenId> language = new CLSLanguageHierarchy().language();

    public static Language<ANTLRTokenId> getLanguage() {
        return language;
    }

    private static void init() {
        ANTLRTokenReader reader = new ANTLRTokenReader();
        HashMap<String, String> tokenTypes = new HashMap<>();
        
        tokenTypes.put("Name", "tagname");
        tokenTypes.put("COMMENT", "comment");
        tokenTypes.put("STRING", "character");
        
        tokens = reader.readTokenFile("org/nbstudio/syntax/xdata/xdataLexer.tokens", tokenTypes);
        idToToken = new HashMap<>();
        for (ANTLRTokenId token : tokens) {
            idToToken.put(token.ordinal(), token);
        }
    }

    public static synchronized ANTLRTokenId getToken(int id) {
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
        return new xdataEditorLexer(info);
    }

    @Override
    protected String mimeType() {
        return "text/isc-xdata";
    }
}
