/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.syntax;

import org.nbstudio.syntax.utils.ANTLRCharStream;
import org.nbstudio.syntax.utils.ANTLRTokenId;
import org.nbstudio.utils.Logger;
import org.netbeans.api.lexer.Token;
import org.netbeans.spi.lexer.Lexer;
import org.netbeans.spi.lexer.LexerRestartInfo;

/**
 *
 * @author daimor
 */
class macEditorLexer implements Lexer<ANTLRTokenId> {

    private LexerRestartInfo<ANTLRTokenId> info;
    private macLexer lexer;

    public macEditorLexer(LexerRestartInfo<ANTLRTokenId> info) {
        this.info = info;
        ANTLRCharStream charStream = new ANTLRCharStream(info.input(), "macEditor", true);
        lexer = new macLexer(charStream);
    }

    @Override
    public Token<ANTLRTokenId> nextToken() {
        org.antlr.v4.runtime.Token token = lexer.nextToken();

        Token<ANTLRTokenId> createdToken = null;

        if (token.getType() != -1) {
            ANTLRTokenId tokenId = macLanguageHierarchy.getToken(token.getType());
            createdToken = info.tokenFactory().createToken(tokenId);
        } else if (info.input().readLength() > 0) {
            ANTLRTokenId tokenId = macLanguageHierarchy.getToken(macLexer.WS);
            createdToken = info.tokenFactory().createToken(tokenId);
        }
        return createdToken;
    }

    @Override
    public Object state() {
        return null;
    }

    @Override
    public void release() {
    }
}
