/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.syntax.cls;

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
public class CLSLanguageHierarchy extends LanguageHierarchy<ANTLRTokenId> {

    private static List<ANTLRTokenId> tokens;
    private static Map<Integer, ANTLRTokenId> idToToken;
    private static final Language<ANTLRTokenId> language = new CLSLanguageHierarchy().language();

    public static Language<ANTLRTokenId> getLanguage() {
        return language;
    }

    private static void init() {
        ANTLRTokenReader reader = new ANTLRTokenReader();
        HashMap<String, String> tokenTypes = new HashMap<>();
        tokenTypes.put("Class", "keyword");
        tokenTypes.put("Include", "keyword");
        tokenTypes.put("Property", "keyword");
        tokenTypes.put("Relationship", "keyword");
        tokenTypes.put("Method", "keyword");
        tokenTypes.put("ClassMethod", "keyword");
        tokenTypes.put("Parameter", "keyword");
        tokenTypes.put("Extends", "keyword");
        tokenTypes.put("As", "keyword");
        tokenTypes.put("Index", "keyword");
        tokenTypes.put("ForeignKey", "keyword");
        tokenTypes.put("On", "keyword");
        tokenTypes.put("Method", "keyword");
        tokenTypes.put("ClassMethod", "keyword");
        tokenTypes.put("Query", "keyword");
        tokenTypes.put("XData", "keyword");
        
        tokenTypes.put("Comment", "comment");
        tokenTypes.put("Description", "description");
        
        tokenTypes.put("STRING", "string");
        
        tokens = reader.readTokenFile("org/nbstudio/syntax/cls/clsLexer.tokens", tokenTypes);
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
        return new clsEditorLexer(info);
    }

    @Override
    protected String mimeType() {
        return "text/isc-cls";
    }
}
