/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.syntax.cls;

import org.nbstudio.syntax.utils.ANTLRCharStream;
import org.nbstudio.syntax.utils.ANTLRTokenId;
import org.netbeans.api.lexer.Token;
import org.netbeans.spi.lexer.Lexer;
import org.netbeans.spi.lexer.LexerRestartInfo;

/**
 *
 * @author daimor
 */
class clsEditorLexer implements Lexer<ANTLRTokenId> {

    private final LexerRestartInfo<ANTLRTokenId> info;
    private final clsLexer lexer;

    public clsEditorLexer(LexerRestartInfo<ANTLRTokenId> info) {
        this.info = info;
        ANTLRCharStream charStream = new ANTLRCharStream(info.input(), "editor");
        lexer = new clsLexer(charStream);
        clsLexer.lexerState state = (clsLexer.lexerState) info.state();

        lexer.setLexerState((clsLexer.lexerState) info.state());
    }

    @Override
    public Token<ANTLRTokenId> nextToken() {
        org.antlr.v4.runtime.Token token = lexer.nextToken();

        Token<ANTLRTokenId> createdToken = null;

        if (token.getType() != -1) {
            ANTLRTokenId tokenId = CLSLanguageHierarchy.getToken(token.getType());
            createdToken = info.tokenFactory().createToken(tokenId);
        } else if (info.input().readLength() > 0) {
            ANTLRTokenId tokenId = CLSLanguageHierarchy.getToken(clsLexer.WS);
            createdToken = info.tokenFactory().createToken(tokenId);
        }
        return createdToken;
    }

    @Override
    public Object state() {
        clsLexer.lexerState state = lexer.getLexerState();
        return state;
    }

    @Override
    public void release() {
    }
}
