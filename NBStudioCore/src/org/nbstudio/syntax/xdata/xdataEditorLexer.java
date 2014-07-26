/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.syntax.xdata;

import org.nbstudio.syntax.utils.ANTLRCharStream;
import org.nbstudio.syntax.utils.ANTLRTokenId;
import org.netbeans.api.lexer.Token;
import org.netbeans.spi.lexer.Lexer;
import org.netbeans.spi.lexer.LexerRestartInfo;

/**
 *
 * @author daimor
 */
class xdataEditorLexer implements Lexer<ANTLRTokenId> {

    private final LexerRestartInfo<ANTLRTokenId> info;
    private final xdataLexer lexer;

    public xdataEditorLexer(LexerRestartInfo<ANTLRTokenId> info) {
        this.info = info;
        ANTLRCharStream charStream = new ANTLRCharStream(info.input(), "editor");
        lexer = new xdataLexer(charStream);
//        xdataLexer.lexerState state = (xdataLexer.lexerState) info.state();
//        
//        lexer.setLexerState((xdataLexer.lexerState) info.state());
    }

    @Override
    public Token<ANTLRTokenId> nextToken() {
        org.antlr.v4.runtime.Token token = lexer.nextToken();

        Token<ANTLRTokenId> createdToken = null;

        if (token.getType() != -1) {
            ANTLRTokenId tokenId = xdataLanguageHierarchy.getToken(token.getType());
            createdToken = info.tokenFactory().createToken(tokenId);
        } else if (info.input().readLength() > 0) {
            ANTLRTokenId tokenId = xdataLanguageHierarchy.getToken(xdataLexer.S);
            createdToken = info.tokenFactory().createToken(tokenId);
        }

        return createdToken;
    }

    @Override
    public Object state() {
        return null;
//        xdataLexer.lexerState state = lexer.getLexerState();
//        return state;
    }

    @Override
    public void release() {
    }
}
