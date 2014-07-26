/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.syntax.mac;

import org.nbstudio.syntax.utils.ANTLRCharStream;
import org.nbstudio.syntax.utils.ANTLRTokenId;
import org.netbeans.api.lexer.Token;
import org.netbeans.spi.lexer.Lexer;
import org.netbeans.spi.lexer.LexerRestartInfo;

/**
 *
 * @author daimor
 */
class macEditorLexer implements Lexer<ANTLRTokenId> {

    private final LexerRestartInfo<ANTLRTokenId> info;
    private final macLexer lexer;

    public macEditorLexer(LexerRestartInfo<ANTLRTokenId> info) {
        this.info = info;
        ANTLRCharStream charStream = new ANTLRCharStream(info.input(), "editor");
        lexer = new macLexer(charStream);
        macLexer.lexerState state = (macLexer.lexerState) info.state();
        
        lexer.setLexerState((macLexer.lexerState) info.state());
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
        macLexer.lexerState state = lexer.getLexerState();
        return state;
    }

    @Override
    public void release() {
    }
}
