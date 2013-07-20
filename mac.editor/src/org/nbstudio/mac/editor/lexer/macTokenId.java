/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.mac.editor.lexer;

import java.util.Collection;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import org.netbeans.api.lexer.Language;
import org.netbeans.api.lexer.TokenId;
import org.netbeans.spi.lexer.LanguageHierarchy;
import org.netbeans.spi.lexer.Lexer;
import org.netbeans.spi.lexer.LexerRestartInfo;

/**
 *
 * @author daimor
 */
public enum macTokenId implements TokenId {

    SPACE(null, "characters");
    
    private final String name;
    private final String primaryCategory;

    macTokenId(String name, String primaryCategory) {
        this.name = name;
        this.primaryCategory = primaryCategory;
    }

    public String primaryCategory() {
        return this.primaryCategory;
    }

    public static Language<macTokenId> language() {
        return languageHierarchy.language();
    }
    private static final macLanguageHierarchy languageHierarchy = new macLanguageHierarchy();

    private static class macLanguageHierarchy extends LanguageHierarchy<macTokenId> {

        public macLanguageHierarchy() {
        }

        @Override
        protected Collection<macTokenId> createTokenIds() {
            return EnumSet.allOf(macTokenId.class);
        }

        @Override
        protected Map<String, Collection<macTokenId>> createTokenCategories() {
            Map<String, Collection<macTokenId>> cats = new HashMap<String, Collection<macTokenId>>();
            return cats;
        }

        @Override
        protected Lexer<macTokenId> createLexer(LexerRestartInfo<macTokenId> info) {
            return null;
        }

        @Override
        protected String mimeType() {
            return "text/isc-mac";
        }
    }
}
