// Generated from /mnt/disk3/NetBeansProjects/NBStudio/NBStudioCore/src/org/nbstudio/syntax/macParser.g4 by ANTLR 4.1

    package org.nbstudio.syntax; 

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link macParser}.
 */
public interface macParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link macParser#mergeCommand}.
	 * @param ctx the parse tree
	 */
	void enterMergeCommand(@NotNull macParser.MergeCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#mergeCommand}.
	 * @param ctx the parse tree
	 */
	void exitMergeCommand(@NotNull macParser.MergeCommandContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#zprintCommand}.
	 * @param ctx the parse tree
	 */
	void enterZprintCommand(@NotNull macParser.ZprintCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#zprintCommand}.
	 * @param ctx the parse tree
	 */
	void exitZprintCommand(@NotNull macParser.ZprintCommandContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#elseifCommand}.
	 * @param ctx the parse tree
	 */
	void enterElseifCommand(@NotNull macParser.ElseifCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#elseifCommand}.
	 * @param ctx the parse tree
	 */
	void exitElseifCommand(@NotNull macParser.ElseifCommandContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#zzdumpStatement}.
	 * @param ctx the parse tree
	 */
	void enterZzdumpStatement(@NotNull macParser.ZzdumpStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#zzdumpStatement}.
	 * @param ctx the parse tree
	 */
	void exitZzdumpStatement(@NotNull macParser.ZzdumpStatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#newStatement}.
	 * @param ctx the parse tree
	 */
	void enterNewStatement(@NotNull macParser.NewStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#newStatement}.
	 * @param ctx the parse tree
	 */
	void exitNewStatement(@NotNull macParser.NewStatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#setStatement}.
	 * @param ctx the parse tree
	 */
	void enterSetStatement(@NotNull macParser.SetStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#setStatement}.
	 * @param ctx the parse tree
	 */
	void exitSetStatement(@NotNull macParser.SetStatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#mergeArgument}.
	 * @param ctx the parse tree
	 */
	void enterMergeArgument(@NotNull macParser.MergeArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#mergeArgument}.
	 * @param ctx the parse tree
	 */
	void exitMergeArgument(@NotNull macParser.MergeArgumentContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#zwriteCommand}.
	 * @param ctx the parse tree
	 */
	void enterZwriteCommand(@NotNull macParser.ZwriteCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#zwriteCommand}.
	 * @param ctx the parse tree
	 */
	void exitZwriteCommand(@NotNull macParser.ZwriteCommandContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#simpleStatement}.
	 * @param ctx the parse tree
	 */
	void enterSimpleStatement(@NotNull macParser.SimpleStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#simpleStatement}.
	 * @param ctx the parse tree
	 */
	void exitSimpleStatement(@NotNull macParser.SimpleStatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#openStatement}.
	 * @param ctx the parse tree
	 */
	void enterOpenStatement(@NotNull macParser.OpenStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#openStatement}.
	 * @param ctx the parse tree
	 */
	void exitOpenStatement(@NotNull macParser.OpenStatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#openCommand}.
	 * @param ctx the parse tree
	 */
	void enterOpenCommand(@NotNull macParser.OpenCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#openCommand}.
	 * @param ctx the parse tree
	 */
	void exitOpenCommand(@NotNull macParser.OpenCommandContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#closeStatement}.
	 * @param ctx the parse tree
	 */
	void enterCloseStatement(@NotNull macParser.CloseStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#closeStatement}.
	 * @param ctx the parse tree
	 */
	void exitCloseStatement(@NotNull macParser.CloseStatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#zloadCommand}.
	 * @param ctx the parse tree
	 */
	void enterZloadCommand(@NotNull macParser.ZloadCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#zloadCommand}.
	 * @param ctx the parse tree
	 */
	void exitZloadCommand(@NotNull macParser.ZloadCommandContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#doCommand}.
	 * @param ctx the parse tree
	 */
	void enterDoCommand(@NotNull macParser.DoCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#doCommand}.
	 * @param ctx the parse tree
	 */
	void exitDoCommand(@NotNull macParser.DoCommandContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#whileCommand}.
	 * @param ctx the parse tree
	 */
	void enterWhileCommand(@NotNull macParser.WhileCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#whileCommand}.
	 * @param ctx the parse tree
	 */
	void exitWhileCommand(@NotNull macParser.WhileCommandContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#ifCommand}.
	 * @param ctx the parse tree
	 */
	void enterIfCommand(@NotNull macParser.IfCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#ifCommand}.
	 * @param ctx the parse tree
	 */
	void exitIfCommand(@NotNull macParser.IfCommandContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#setCommand}.
	 * @param ctx the parse tree
	 */
	void enterSetCommand(@NotNull macParser.SetCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#setCommand}.
	 * @param ctx the parse tree
	 */
	void exitSetCommand(@NotNull macParser.SetCommandContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#haltCommand}.
	 * @param ctx the parse tree
	 */
	void enterHaltCommand(@NotNull macParser.HaltCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#haltCommand}.
	 * @param ctx the parse tree
	 */
	void exitHaltCommand(@NotNull macParser.HaltCommandContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#viewCommand}.
	 * @param ctx the parse tree
	 */
	void enterViewCommand(@NotNull macParser.ViewCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#viewCommand}.
	 * @param ctx the parse tree
	 */
	void exitViewCommand(@NotNull macParser.ViewCommandContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#doRoutine}.
	 * @param ctx the parse tree
	 */
	void enterDoRoutine(@NotNull macParser.DoRoutineContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#doRoutine}.
	 * @param ctx the parse tree
	 */
	void exitDoRoutine(@NotNull macParser.DoRoutineContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#writeStatement}.
	 * @param ctx the parse tree
	 */
	void enterWriteStatement(@NotNull macParser.WriteStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#writeStatement}.
	 * @param ctx the parse tree
	 */
	void exitWriteStatement(@NotNull macParser.WriteStatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#zkillCommand}.
	 * @param ctx the parse tree
	 */
	void enterZkillCommand(@NotNull macParser.ZkillCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#zkillCommand}.
	 * @param ctx the parse tree
	 */
	void exitZkillCommand(@NotNull macParser.ZkillCommandContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#pc}.
	 * @param ctx the parse tree
	 */
	void enterPc(@NotNull macParser.PcContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#pc}.
	 * @param ctx the parse tree
	 */
	void exitPc(@NotNull macParser.PcContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#lockArgument2}.
	 * @param ctx the parse tree
	 */
	void enterLockArgument2(@NotNull macParser.LockArgument2Context ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#lockArgument2}.
	 * @param ctx the parse tree
	 */
	void exitLockArgument2(@NotNull macParser.LockArgument2Context ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#readCommand}.
	 * @param ctx the parse tree
	 */
	void enterReadCommand(@NotNull macParser.ReadCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#readCommand}.
	 * @param ctx the parse tree
	 */
	void exitReadCommand(@NotNull macParser.ReadCommandContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#lockStatement}.
	 * @param ctx the parse tree
	 */
	void enterLockStatement(@NotNull macParser.LockStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#lockStatement}.
	 * @param ctx the parse tree
	 */
	void exitLockStatement(@NotNull macParser.LockStatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#breakStatement}.
	 * @param ctx the parse tree
	 */
	void enterBreakStatement(@NotNull macParser.BreakStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#breakStatement}.
	 * @param ctx the parse tree
	 */
	void exitBreakStatement(@NotNull macParser.BreakStatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#lockCommand}.
	 * @param ctx the parse tree
	 */
	void enterLockCommand(@NotNull macParser.LockCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#lockCommand}.
	 * @param ctx the parse tree
	 */
	void exitLockCommand(@NotNull macParser.LockCommandContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#forCommand}.
	 * @param ctx the parse tree
	 */
	void enterForCommand(@NotNull macParser.ForCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#forCommand}.
	 * @param ctx the parse tree
	 */
	void exitForCommand(@NotNull macParser.ForCommandContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#trollbackCommand}.
	 * @param ctx the parse tree
	 */
	void enterTrollbackCommand(@NotNull macParser.TrollbackCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#trollbackCommand}.
	 * @param ctx the parse tree
	 */
	void exitTrollbackCommand(@NotNull macParser.TrollbackCommandContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#elseCommand1}.
	 * @param ctx the parse tree
	 */
	void enterElseCommand1(@NotNull macParser.ElseCommand1Context ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#elseCommand1}.
	 * @param ctx the parse tree
	 */
	void exitElseCommand1(@NotNull macParser.ElseCommand1Context ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(@NotNull macParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(@NotNull macParser.ForStatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#elseStatement}.
	 * @param ctx the parse tree
	 */
	void enterElseStatement(@NotNull macParser.ElseStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#elseStatement}.
	 * @param ctx the parse tree
	 */
	void exitElseStatement(@NotNull macParser.ElseStatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#setArgument}.
	 * @param ctx the parse tree
	 */
	void enterSetArgument(@NotNull macParser.SetArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#setArgument}.
	 * @param ctx the parse tree
	 */
	void exitSetArgument(@NotNull macParser.SetArgumentContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#killCommand}.
	 * @param ctx the parse tree
	 */
	void enterKillCommand(@NotNull macParser.KillCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#killCommand}.
	 * @param ctx the parse tree
	 */
	void exitKillCommand(@NotNull macParser.KillCommandContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#tcommitCommand}.
	 * @param ctx the parse tree
	 */
	void enterTcommitCommand(@NotNull macParser.TcommitCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#tcommitCommand}.
	 * @param ctx the parse tree
	 */
	void exitTcommitCommand(@NotNull macParser.TcommitCommandContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(@NotNull macParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(@NotNull macParser.ProgContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#closeCommand}.
	 * @param ctx the parse tree
	 */
	void enterCloseCommand(@NotNull macParser.CloseCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#closeCommand}.
	 * @param ctx the parse tree
	 */
	void exitCloseCommand(@NotNull macParser.CloseCommandContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#forExpression}.
	 * @param ctx the parse tree
	 */
	void enterForExpression(@NotNull macParser.ForExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#forExpression}.
	 * @param ctx the parse tree
	 */
	void exitForExpression(@NotNull macParser.ForExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#continueCommand}.
	 * @param ctx the parse tree
	 */
	void enterContinueCommand(@NotNull macParser.ContinueCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#continueCommand}.
	 * @param ctx the parse tree
	 */
	void exitContinueCommand(@NotNull macParser.ContinueCommandContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArguments(@NotNull macParser.ArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArguments(@NotNull macParser.ArgumentsContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#useCommand}.
	 * @param ctx the parse tree
	 */
	void enterUseCommand(@NotNull macParser.UseCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#useCommand}.
	 * @param ctx the parse tree
	 */
	void exitUseCommand(@NotNull macParser.UseCommandContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#printCommand}.
	 * @param ctx the parse tree
	 */
	void enterPrintCommand(@NotNull macParser.PrintCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#printCommand}.
	 * @param ctx the parse tree
	 */
	void exitPrintCommand(@NotNull macParser.PrintCommandContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#ztrapCommand}.
	 * @param ctx the parse tree
	 */
	void enterZtrapCommand(@NotNull macParser.ZtrapCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#ztrapCommand}.
	 * @param ctx the parse tree
	 */
	void exitZtrapCommand(@NotNull macParser.ZtrapCommandContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#colonExpression}.
	 * @param ctx the parse tree
	 */
	void enterColonExpression(@NotNull macParser.ColonExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#colonExpression}.
	 * @param ctx the parse tree
	 */
	void exitColonExpression(@NotNull macParser.ColonExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#jobProcessParams}.
	 * @param ctx the parse tree
	 */
	void enterJobProcessParams(@NotNull macParser.JobProcessParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#jobProcessParams}.
	 * @param ctx the parse tree
	 */
	void exitJobProcessParams(@NotNull macParser.JobProcessParamsContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#jobStatement}.
	 * @param ctx the parse tree
	 */
	void enterJobStatement(@NotNull macParser.JobStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#jobStatement}.
	 * @param ctx the parse tree
	 */
	void exitJobStatement(@NotNull macParser.JobStatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#elseCommand2}.
	 * @param ctx the parse tree
	 */
	void enterElseCommand2(@NotNull macParser.ElseCommand2Context ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#elseCommand2}.
	 * @param ctx the parse tree
	 */
	void exitElseCommand2(@NotNull macParser.ElseCommand2Context ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#gotoStatement}.
	 * @param ctx the parse tree
	 */
	void enterGotoStatement(@NotNull macParser.GotoStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#gotoStatement}.
	 * @param ctx the parse tree
	 */
	void exitGotoStatement(@NotNull macParser.GotoStatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(@NotNull macParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(@NotNull macParser.VariableContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#comments}.
	 * @param ctx the parse tree
	 */
	void enterComments(@NotNull macParser.CommentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#comments}.
	 * @param ctx the parse tree
	 */
	void exitComments(@NotNull macParser.CommentsContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#znspaceCommand}.
	 * @param ctx the parse tree
	 */
	void enterZnspaceCommand(@NotNull macParser.ZnspaceCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#znspaceCommand}.
	 * @param ctx the parse tree
	 */
	void exitZnspaceCommand(@NotNull macParser.ZnspaceCommandContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(@NotNull macParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(@NotNull macParser.ExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#labelDef}.
	 * @param ctx the parse tree
	 */
	void enterLabelDef(@NotNull macParser.LabelDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#labelDef}.
	 * @param ctx the parse tree
	 */
	void exitLabelDef(@NotNull macParser.LabelDefContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#zsaveCommand}.
	 * @param ctx the parse tree
	 */
	void enterZsaveCommand(@NotNull macParser.ZsaveCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#zsaveCommand}.
	 * @param ctx the parse tree
	 */
	void exitZsaveCommand(@NotNull macParser.ZsaveCommandContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#readStatement}.
	 * @param ctx the parse tree
	 */
	void enterReadStatement(@NotNull macParser.ReadStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#readStatement}.
	 * @param ctx the parse tree
	 */
	void exitReadStatement(@NotNull macParser.ReadStatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#xecuteStatement}.
	 * @param ctx the parse tree
	 */
	void enterXecuteStatement(@NotNull macParser.XecuteStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#xecuteStatement}.
	 * @param ctx the parse tree
	 */
	void exitXecuteStatement(@NotNull macParser.XecuteStatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#labelParameter}.
	 * @param ctx the parse tree
	 */
	void enterLabelParameter(@NotNull macParser.LabelParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#labelParameter}.
	 * @param ctx the parse tree
	 */
	void exitLabelParameter(@NotNull macParser.LabelParameterContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#mergeStatement}.
	 * @param ctx the parse tree
	 */
	void enterMergeStatement(@NotNull macParser.MergeStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#mergeStatement}.
	 * @param ctx the parse tree
	 */
	void exitMergeStatement(@NotNull macParser.MergeStatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#killStatement}.
	 * @param ctx the parse tree
	 */
	void enterKillStatement(@NotNull macParser.KillStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#killStatement}.
	 * @param ctx the parse tree
	 */
	void exitKillStatement(@NotNull macParser.KillStatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#zremoveCommand}.
	 * @param ctx the parse tree
	 */
	void enterZremoveCommand(@NotNull macParser.ZremoveCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#zremoveCommand}.
	 * @param ctx the parse tree
	 */
	void exitZremoveCommand(@NotNull macParser.ZremoveCommandContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#zkillStatement}.
	 * @param ctx the parse tree
	 */
	void enterZkillStatement(@NotNull macParser.ZkillStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#zkillStatement}.
	 * @param ctx the parse tree
	 */
	void exitZkillStatement(@NotNull macParser.ZkillStatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#doArgument}.
	 * @param ctx the parse tree
	 */
	void enterDoArgument(@NotNull macParser.DoArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#doArgument}.
	 * @param ctx the parse tree
	 */
	void exitDoArgument(@NotNull macParser.DoArgumentContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#hangCommand}.
	 * @param ctx the parse tree
	 */
	void enterHangCommand(@NotNull macParser.HangCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#hangCommand}.
	 * @param ctx the parse tree
	 */
	void exitHangCommand(@NotNull macParser.HangCommandContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#zzdumpCommand}.
	 * @param ctx the parse tree
	 */
	void enterZzdumpCommand(@NotNull macParser.ZzdumpCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#zzdumpCommand}.
	 * @param ctx the parse tree
	 */
	void exitZzdumpCommand(@NotNull macParser.ZzdumpCommandContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#gotoCommand}.
	 * @param ctx the parse tree
	 */
	void enterGotoCommand(@NotNull macParser.GotoCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#gotoCommand}.
	 * @param ctx the parse tree
	 */
	void exitGotoCommand(@NotNull macParser.GotoCommandContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#hangStatement}.
	 * @param ctx the parse tree
	 */
	void enterHangStatement(@NotNull macParser.HangStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#hangStatement}.
	 * @param ctx the parse tree
	 */
	void exitHangStatement(@NotNull macParser.HangStatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(@NotNull macParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(@NotNull macParser.ConditionContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#breakCommand}.
	 * @param ctx the parse tree
	 */
	void enterBreakCommand(@NotNull macParser.BreakCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#breakCommand}.
	 * @param ctx the parse tree
	 */
	void exitBreakCommand(@NotNull macParser.BreakCommandContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void enterPrintStatement(@NotNull macParser.PrintStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void exitPrintStatement(@NotNull macParser.PrintStatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(@NotNull macParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(@NotNull macParser.StatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#zwriteStatement}.
	 * @param ctx the parse tree
	 */
	void enterZwriteStatement(@NotNull macParser.ZwriteStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#zwriteStatement}.
	 * @param ctx the parse tree
	 */
	void exitZwriteStatement(@NotNull macParser.ZwriteStatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#quitCommand}.
	 * @param ctx the parse tree
	 */
	void enterQuitCommand(@NotNull macParser.QuitCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#quitCommand}.
	 * @param ctx the parse tree
	 */
	void exitQuitCommand(@NotNull macParser.QuitCommandContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#tryCommand}.
	 * @param ctx the parse tree
	 */
	void enterTryCommand(@NotNull macParser.TryCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#tryCommand}.
	 * @param ctx the parse tree
	 */
	void exitTryCommand(@NotNull macParser.TryCommandContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#globalVariable}.
	 * @param ctx the parse tree
	 */
	void enterGlobalVariable(@NotNull macParser.GlobalVariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#globalVariable}.
	 * @param ctx the parse tree
	 */
	void exitGlobalVariable(@NotNull macParser.GlobalVariableContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#doClass}.
	 * @param ctx the parse tree
	 */
	void enterDoClass(@NotNull macParser.DoClassContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#doClass}.
	 * @param ctx the parse tree
	 */
	void exitDoClass(@NotNull macParser.DoClassContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#viewStatement}.
	 * @param ctx the parse tree
	 */
	void enterViewStatement(@NotNull macParser.ViewStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#viewStatement}.
	 * @param ctx the parse tree
	 */
	void exitViewStatement(@NotNull macParser.ViewStatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#jobCommand}.
	 * @param ctx the parse tree
	 */
	void enterJobCommand(@NotNull macParser.JobCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#jobCommand}.
	 * @param ctx the parse tree
	 */
	void exitJobCommand(@NotNull macParser.JobCommandContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#systemFunction}.
	 * @param ctx the parse tree
	 */
	void enterSystemFunction(@NotNull macParser.SystemFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#systemFunction}.
	 * @param ctx the parse tree
	 */
	void exitSystemFunction(@NotNull macParser.SystemFunctionContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#simpleExpression}.
	 * @param ctx the parse tree
	 */
	void enterSimpleExpression(@NotNull macParser.SimpleExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#simpleExpression}.
	 * @param ctx the parse tree
	 */
	void exitSimpleExpression(@NotNull macParser.SimpleExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#catchCommand}.
	 * @param ctx the parse tree
	 */
	void enterCatchCommand(@NotNull macParser.CatchCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#catchCommand}.
	 * @param ctx the parse tree
	 */
	void exitCatchCommand(@NotNull macParser.CatchCommandContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#localVariable}.
	 * @param ctx the parse tree
	 */
	void enterLocalVariable(@NotNull macParser.LocalVariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#localVariable}.
	 * @param ctx the parse tree
	 */
	void exitLocalVariable(@NotNull macParser.LocalVariableContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void enterBlockStatement(@NotNull macParser.BlockStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void exitBlockStatement(@NotNull macParser.BlockStatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#xeceuteArgument}.
	 * @param ctx the parse tree
	 */
	void enterXeceuteArgument(@NotNull macParser.XeceuteArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#xeceuteArgument}.
	 * @param ctx the parse tree
	 */
	void exitXeceuteArgument(@NotNull macParser.XeceuteArgumentContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#zinsertCommand}.
	 * @param ctx the parse tree
	 */
	void enterZinsertCommand(@NotNull macParser.ZinsertCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#zinsertCommand}.
	 * @param ctx the parse tree
	 */
	void exitZinsertCommand(@NotNull macParser.ZinsertCommandContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#jobArgument}.
	 * @param ctx the parse tree
	 */
	void enterJobArgument(@NotNull macParser.JobArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#jobArgument}.
	 * @param ctx the parse tree
	 */
	void exitJobArgument(@NotNull macParser.JobArgumentContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#tryStatement}.
	 * @param ctx the parse tree
	 */
	void enterTryStatement(@NotNull macParser.TryStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#tryStatement}.
	 * @param ctx the parse tree
	 */
	void exitTryStatement(@NotNull macParser.TryStatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#xecuteCommand}.
	 * @param ctx the parse tree
	 */
	void enterXecuteCommand(@NotNull macParser.XecuteCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#xecuteCommand}.
	 * @param ctx the parse tree
	 */
	void exitXecuteCommand(@NotNull macParser.XecuteCommandContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#zbreakCommand}.
	 * @param ctx the parse tree
	 */
	void enterZbreakCommand(@NotNull macParser.ZbreakCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#zbreakCommand}.
	 * @param ctx the parse tree
	 */
	void exitZbreakCommand(@NotNull macParser.ZbreakCommandContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#doStatement}.
	 * @param ctx the parse tree
	 */
	void enterDoStatement(@NotNull macParser.DoStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#doStatement}.
	 * @param ctx the parse tree
	 */
	void exitDoStatement(@NotNull macParser.DoStatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#writeArgument}.
	 * @param ctx the parse tree
	 */
	void enterWriteArgument(@NotNull macParser.WriteArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#writeArgument}.
	 * @param ctx the parse tree
	 */
	void exitWriteArgument(@NotNull macParser.WriteArgumentContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#killArgument}.
	 * @param ctx the parse tree
	 */
	void enterKillArgument(@NotNull macParser.KillArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#killArgument}.
	 * @param ctx the parse tree
	 */
	void exitKillArgument(@NotNull macParser.KillArgumentContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#newCommand}.
	 * @param ctx the parse tree
	 */
	void enterNewCommand(@NotNull macParser.NewCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#newCommand}.
	 * @param ctx the parse tree
	 */
	void exitNewCommand(@NotNull macParser.NewCommandContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#readArgument}.
	 * @param ctx the parse tree
	 */
	void enterReadArgument(@NotNull macParser.ReadArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#readArgument}.
	 * @param ctx the parse tree
	 */
	void exitReadArgument(@NotNull macParser.ReadArgumentContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#lockArgument}.
	 * @param ctx the parse tree
	 */
	void enterLockArgument(@NotNull macParser.LockArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#lockArgument}.
	 * @param ctx the parse tree
	 */
	void exitLockArgument(@NotNull macParser.LockArgumentContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#catchStatement}.
	 * @param ctx the parse tree
	 */
	void enterCatchStatement(@NotNull macParser.CatchStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#catchStatement}.
	 * @param ctx the parse tree
	 */
	void exitCatchStatement(@NotNull macParser.CatchStatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#writeCommand}.
	 * @param ctx the parse tree
	 */
	void enterWriteCommand(@NotNull macParser.WriteCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#writeCommand}.
	 * @param ctx the parse tree
	 */
	void exitWriteCommand(@NotNull macParser.WriteCommandContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(@NotNull macParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(@NotNull macParser.IfStatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#tstartCommand}.
	 * @param ctx the parse tree
	 */
	void enterTstartCommand(@NotNull macParser.TstartCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#tstartCommand}.
	 * @param ctx the parse tree
	 */
	void exitTstartCommand(@NotNull macParser.TstartCommandContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#localVariableList}.
	 * @param ctx the parse tree
	 */
	void enterLocalVariableList(@NotNull macParser.LocalVariableListContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#localVariableList}.
	 * @param ctx the parse tree
	 */
	void exitLocalVariableList(@NotNull macParser.LocalVariableListContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#zbreakStatement}.
	 * @param ctx the parse tree
	 */
	void enterZbreakStatement(@NotNull macParser.ZbreakStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#zbreakStatement}.
	 * @param ctx the parse tree
	 */
	void exitZbreakStatement(@NotNull macParser.ZbreakStatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(@NotNull macParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(@NotNull macParser.WhileStatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#quitStatement}.
	 * @param ctx the parse tree
	 */
	void enterQuitStatement(@NotNull macParser.QuitStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#quitStatement}.
	 * @param ctx the parse tree
	 */
	void exitQuitStatement(@NotNull macParser.QuitStatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#throwCommand}.
	 * @param ctx the parse tree
	 */
	void enterThrowCommand(@NotNull macParser.ThrowCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#throwCommand}.
	 * @param ctx the parse tree
	 */
	void exitThrowCommand(@NotNull macParser.ThrowCommandContext ctx);

	/**
	 * Enter a parse tree produced by {@link macParser#useStatement}.
	 * @param ctx the parse tree
	 */
	void enterUseStatement(@NotNull macParser.UseStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link macParser#useStatement}.
	 * @param ctx the parse tree
	 */
	void exitUseStatement(@NotNull macParser.UseStatementContext ctx);
}