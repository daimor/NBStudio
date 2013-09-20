// Generated from /home/daimor/Dropbox/myProjects/NBStudio/NBStudioCore/src/org/nbstudio/syntax/cls/clsParser.g4 by ANTLR 4.1

    package org.nbstudio.syntax.cls; 

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link clsParser}.
 */
public interface clsParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link clsParser#xdataDefinition}.
	 * @param ctx the parse tree
	 */
	void enterXdataDefinition(@NotNull clsParser.XdataDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link clsParser#xdataDefinition}.
	 * @param ctx the parse tree
	 */
	void exitXdataDefinition(@NotNull clsParser.XdataDefinitionContext ctx);

	/**
	 * Enter a parse tree produced by {@link clsParser#parameterDefinition}.
	 * @param ctx the parse tree
	 */
	void enterParameterDefinition(@NotNull clsParser.ParameterDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link clsParser#parameterDefinition}.
	 * @param ctx the parse tree
	 */
	void exitParameterDefinition(@NotNull clsParser.ParameterDefinitionContext ctx);

	/**
	 * Enter a parse tree produced by {@link clsParser#classDefintion}.
	 * @param ctx the parse tree
	 */
	void enterClassDefintion(@NotNull clsParser.ClassDefintionContext ctx);
	/**
	 * Exit a parse tree produced by {@link clsParser#classDefintion}.
	 * @param ctx the parse tree
	 */
	void exitClassDefintion(@NotNull clsParser.ClassDefintionContext ctx);

	/**
	 * Enter a parse tree produced by {@link clsParser#classContent}.
	 * @param ctx the parse tree
	 */
	void enterClassContent(@NotNull clsParser.ClassContentContext ctx);
	/**
	 * Exit a parse tree produced by {@link clsParser#classContent}.
	 * @param ctx the parse tree
	 */
	void exitClassContent(@NotNull clsParser.ClassContentContext ctx);

	/**
	 * Enter a parse tree produced by {@link clsParser#ids}.
	 * @param ctx the parse tree
	 */
	void enterIds(@NotNull clsParser.IdsContext ctx);
	/**
	 * Exit a parse tree produced by {@link clsParser#ids}.
	 * @param ctx the parse tree
	 */
	void exitIds(@NotNull clsParser.IdsContext ctx);

	/**
	 * Enter a parse tree produced by {@link clsParser#includeFiles}.
	 * @param ctx the parse tree
	 */
	void enterIncludeFiles(@NotNull clsParser.IncludeFilesContext ctx);
	/**
	 * Exit a parse tree produced by {@link clsParser#includeFiles}.
	 * @param ctx the parse tree
	 */
	void exitIncludeFiles(@NotNull clsParser.IncludeFilesContext ctx);

	/**
	 * Enter a parse tree produced by {@link clsParser#propertyDefinition}.
	 * @param ctx the parse tree
	 */
	void enterPropertyDefinition(@NotNull clsParser.PropertyDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link clsParser#propertyDefinition}.
	 * @param ctx the parse tree
	 */
	void exitPropertyDefinition(@NotNull clsParser.PropertyDefinitionContext ctx);

	/**
	 * Enter a parse tree produced by {@link clsParser#listProperties}.
	 * @param ctx the parse tree
	 */
	void enterListProperties(@NotNull clsParser.ListPropertiesContext ctx);
	/**
	 * Exit a parse tree produced by {@link clsParser#listProperties}.
	 * @param ctx the parse tree
	 */
	void exitListProperties(@NotNull clsParser.ListPropertiesContext ctx);

	/**
	 * Enter a parse tree produced by {@link clsParser#classNames}.
	 * @param ctx the parse tree
	 */
	void enterClassNames(@NotNull clsParser.ClassNamesContext ctx);
	/**
	 * Exit a parse tree produced by {@link clsParser#classNames}.
	 * @param ctx the parse tree
	 */
	void exitClassNames(@NotNull clsParser.ClassNamesContext ctx);

	/**
	 * Enter a parse tree produced by {@link clsParser#queryDefinition}.
	 * @param ctx the parse tree
	 */
	void enterQueryDefinition(@NotNull clsParser.QueryDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link clsParser#queryDefinition}.
	 * @param ctx the parse tree
	 */
	void exitQueryDefinition(@NotNull clsParser.QueryDefinitionContext ctx);

	/**
	 * Enter a parse tree produced by {@link clsParser#includeFile}.
	 * @param ctx the parse tree
	 */
	void enterIncludeFile(@NotNull clsParser.IncludeFileContext ctx);
	/**
	 * Exit a parse tree produced by {@link clsParser#includeFile}.
	 * @param ctx the parse tree
	 */
	void exitIncludeFile(@NotNull clsParser.IncludeFileContext ctx);

	/**
	 * Enter a parse tree produced by {@link clsParser#includeDefinition}.
	 * @param ctx the parse tree
	 */
	void enterIncludeDefinition(@NotNull clsParser.IncludeDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link clsParser#includeDefinition}.
	 * @param ctx the parse tree
	 */
	void exitIncludeDefinition(@NotNull clsParser.IncludeDefinitionContext ctx);

	/**
	 * Enter a parse tree produced by {@link clsParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(@NotNull clsParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link clsParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(@NotNull clsParser.ProgContext ctx);

	/**
	 * Enter a parse tree produced by {@link clsParser#propertyType}.
	 * @param ctx the parse tree
	 */
	void enterPropertyType(@NotNull clsParser.PropertyTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link clsParser#propertyType}.
	 * @param ctx the parse tree
	 */
	void exitPropertyType(@NotNull clsParser.PropertyTypeContext ctx);

	/**
	 * Enter a parse tree produced by {@link clsParser#classExtends}.
	 * @param ctx the parse tree
	 */
	void enterClassExtends(@NotNull clsParser.ClassExtendsContext ctx);
	/**
	 * Exit a parse tree produced by {@link clsParser#classExtends}.
	 * @param ctx the parse tree
	 */
	void exitClassExtends(@NotNull clsParser.ClassExtendsContext ctx);

	/**
	 * Enter a parse tree produced by {@link clsParser#indexDefinition}.
	 * @param ctx the parse tree
	 */
	void enterIndexDefinition(@NotNull clsParser.IndexDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link clsParser#indexDefinition}.
	 * @param ctx the parse tree
	 */
	void exitIndexDefinition(@NotNull clsParser.IndexDefinitionContext ctx);

	/**
	 * Enter a parse tree produced by {@link clsParser#methodDefintion}.
	 * @param ctx the parse tree
	 */
	void enterMethodDefintion(@NotNull clsParser.MethodDefintionContext ctx);
	/**
	 * Exit a parse tree produced by {@link clsParser#methodDefintion}.
	 * @param ctx the parse tree
	 */
	void exitMethodDefintion(@NotNull clsParser.MethodDefintionContext ctx);
}