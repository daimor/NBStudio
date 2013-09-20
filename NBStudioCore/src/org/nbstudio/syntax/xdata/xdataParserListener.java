// Generated from /home/daimor/Dropbox/myProjects/NBStudio/NBStudioCore/src/org/nbstudio/syntax/xdata/xdataParser.g4 by ANTLR 4.1

    package org.nbstudio.syntax.xdata; 

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link xdataParser}.
 */
public interface xdataParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link xdataParser#content}.
	 * @param ctx the parse tree
	 */
	void enterContent(@NotNull xdataParser.ContentContext ctx);
	/**
	 * Exit a parse tree produced by {@link xdataParser#content}.
	 * @param ctx the parse tree
	 */
	void exitContent(@NotNull xdataParser.ContentContext ctx);

	/**
	 * Enter a parse tree produced by {@link xdataParser#element}.
	 * @param ctx the parse tree
	 */
	void enterElement(@NotNull xdataParser.ElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link xdataParser#element}.
	 * @param ctx the parse tree
	 */
	void exitElement(@NotNull xdataParser.ElementContext ctx);

	/**
	 * Enter a parse tree produced by {@link xdataParser#prolog}.
	 * @param ctx the parse tree
	 */
	void enterProlog(@NotNull xdataParser.PrologContext ctx);
	/**
	 * Exit a parse tree produced by {@link xdataParser#prolog}.
	 * @param ctx the parse tree
	 */
	void exitProlog(@NotNull xdataParser.PrologContext ctx);

	/**
	 * Enter a parse tree produced by {@link xdataParser#document}.
	 * @param ctx the parse tree
	 */
	void enterDocument(@NotNull xdataParser.DocumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link xdataParser#document}.
	 * @param ctx the parse tree
	 */
	void exitDocument(@NotNull xdataParser.DocumentContext ctx);

	/**
	 * Enter a parse tree produced by {@link xdataParser#attribute}.
	 * @param ctx the parse tree
	 */
	void enterAttribute(@NotNull xdataParser.AttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link xdataParser#attribute}.
	 * @param ctx the parse tree
	 */
	void exitAttribute(@NotNull xdataParser.AttributeContext ctx);

	/**
	 * Enter a parse tree produced by {@link xdataParser#chardata}.
	 * @param ctx the parse tree
	 */
	void enterChardata(@NotNull xdataParser.ChardataContext ctx);
	/**
	 * Exit a parse tree produced by {@link xdataParser#chardata}.
	 * @param ctx the parse tree
	 */
	void exitChardata(@NotNull xdataParser.ChardataContext ctx);

	/**
	 * Enter a parse tree produced by {@link xdataParser#reference}.
	 * @param ctx the parse tree
	 */
	void enterReference(@NotNull xdataParser.ReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link xdataParser#reference}.
	 * @param ctx the parse tree
	 */
	void exitReference(@NotNull xdataParser.ReferenceContext ctx);

	/**
	 * Enter a parse tree produced by {@link xdataParser#misc}.
	 * @param ctx the parse tree
	 */
	void enterMisc(@NotNull xdataParser.MiscContext ctx);
	/**
	 * Exit a parse tree produced by {@link xdataParser#misc}.
	 * @param ctx the parse tree
	 */
	void exitMisc(@NotNull xdataParser.MiscContext ctx);
}