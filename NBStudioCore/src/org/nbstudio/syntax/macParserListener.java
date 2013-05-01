// Generated from macParser.g4 by ANTLR 4.0

    package org.nbstudio.syntax; 

import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.Token;

public interface macParserListener extends ParseTreeListener {
	void enterMergeCommand(macParser.MergeCommandContext ctx);
	void exitMergeCommand(macParser.MergeCommandContext ctx);

	void enterZprintCommand(macParser.ZprintCommandContext ctx);
	void exitZprintCommand(macParser.ZprintCommandContext ctx);

	void enterElseifCommand(macParser.ElseifCommandContext ctx);
	void exitElseifCommand(macParser.ElseifCommandContext ctx);

	void enterZzdumpStatement(macParser.ZzdumpStatementContext ctx);
	void exitZzdumpStatement(macParser.ZzdumpStatementContext ctx);

	void enterNewStatement(macParser.NewStatementContext ctx);
	void exitNewStatement(macParser.NewStatementContext ctx);

	void enterSetStatement(macParser.SetStatementContext ctx);
	void exitSetStatement(macParser.SetStatementContext ctx);

	void enterMergeArgument(macParser.MergeArgumentContext ctx);
	void exitMergeArgument(macParser.MergeArgumentContext ctx);

	void enterZwriteCommand(macParser.ZwriteCommandContext ctx);
	void exitZwriteCommand(macParser.ZwriteCommandContext ctx);

	void enterSimpleStatement(macParser.SimpleStatementContext ctx);
	void exitSimpleStatement(macParser.SimpleStatementContext ctx);

	void enterOpenStatement(macParser.OpenStatementContext ctx);
	void exitOpenStatement(macParser.OpenStatementContext ctx);

	void enterOpenCommand(macParser.OpenCommandContext ctx);
	void exitOpenCommand(macParser.OpenCommandContext ctx);

	void enterCloseStatement(macParser.CloseStatementContext ctx);
	void exitCloseStatement(macParser.CloseStatementContext ctx);

	void enterZloadCommand(macParser.ZloadCommandContext ctx);
	void exitZloadCommand(macParser.ZloadCommandContext ctx);

	void enterDoCommand(macParser.DoCommandContext ctx);
	void exitDoCommand(macParser.DoCommandContext ctx);

	void enterWhileCommand(macParser.WhileCommandContext ctx);
	void exitWhileCommand(macParser.WhileCommandContext ctx);

	void enterIfCommand(macParser.IfCommandContext ctx);
	void exitIfCommand(macParser.IfCommandContext ctx);

	void enterSetCommand(macParser.SetCommandContext ctx);
	void exitSetCommand(macParser.SetCommandContext ctx);

	void enterHaltCommand(macParser.HaltCommandContext ctx);
	void exitHaltCommand(macParser.HaltCommandContext ctx);

	void enterViewCommand(macParser.ViewCommandContext ctx);
	void exitViewCommand(macParser.ViewCommandContext ctx);

	void enterDoRoutine(macParser.DoRoutineContext ctx);
	void exitDoRoutine(macParser.DoRoutineContext ctx);

	void enterWriteStatement(macParser.WriteStatementContext ctx);
	void exitWriteStatement(macParser.WriteStatementContext ctx);

	void enterZkillCommand(macParser.ZkillCommandContext ctx);
	void exitZkillCommand(macParser.ZkillCommandContext ctx);

	void enterPc(macParser.PcContext ctx);
	void exitPc(macParser.PcContext ctx);

	void enterLockArgument2(macParser.LockArgument2Context ctx);
	void exitLockArgument2(macParser.LockArgument2Context ctx);

	void enterReadCommand(macParser.ReadCommandContext ctx);
	void exitReadCommand(macParser.ReadCommandContext ctx);

	void enterLockStatement(macParser.LockStatementContext ctx);
	void exitLockStatement(macParser.LockStatementContext ctx);

	void enterBreakStatement(macParser.BreakStatementContext ctx);
	void exitBreakStatement(macParser.BreakStatementContext ctx);

	void enterLockCommand(macParser.LockCommandContext ctx);
	void exitLockCommand(macParser.LockCommandContext ctx);

	void enterForCommand(macParser.ForCommandContext ctx);
	void exitForCommand(macParser.ForCommandContext ctx);

	void enterTrollbackCommand(macParser.TrollbackCommandContext ctx);
	void exitTrollbackCommand(macParser.TrollbackCommandContext ctx);

	void enterElseCommand1(macParser.ElseCommand1Context ctx);
	void exitElseCommand1(macParser.ElseCommand1Context ctx);

	void enterForStatement(macParser.ForStatementContext ctx);
	void exitForStatement(macParser.ForStatementContext ctx);

	void enterElseStatement(macParser.ElseStatementContext ctx);
	void exitElseStatement(macParser.ElseStatementContext ctx);

	void enterSetArgument(macParser.SetArgumentContext ctx);
	void exitSetArgument(macParser.SetArgumentContext ctx);

	void enterKillCommand(macParser.KillCommandContext ctx);
	void exitKillCommand(macParser.KillCommandContext ctx);

	void enterTcommitCommand(macParser.TcommitCommandContext ctx);
	void exitTcommitCommand(macParser.TcommitCommandContext ctx);

	void enterProg(macParser.ProgContext ctx);
	void exitProg(macParser.ProgContext ctx);

	void enterCloseCommand(macParser.CloseCommandContext ctx);
	void exitCloseCommand(macParser.CloseCommandContext ctx);

	void enterForExpression(macParser.ForExpressionContext ctx);
	void exitForExpression(macParser.ForExpressionContext ctx);

	void enterContinueCommand(macParser.ContinueCommandContext ctx);
	void exitContinueCommand(macParser.ContinueCommandContext ctx);

	void enterArguments(macParser.ArgumentsContext ctx);
	void exitArguments(macParser.ArgumentsContext ctx);

	void enterUseCommand(macParser.UseCommandContext ctx);
	void exitUseCommand(macParser.UseCommandContext ctx);

	void enterPrintCommand(macParser.PrintCommandContext ctx);
	void exitPrintCommand(macParser.PrintCommandContext ctx);

	void enterZtrapCommand(macParser.ZtrapCommandContext ctx);
	void exitZtrapCommand(macParser.ZtrapCommandContext ctx);

	void enterColonExpression(macParser.ColonExpressionContext ctx);
	void exitColonExpression(macParser.ColonExpressionContext ctx);

	void enterJobProcessParams(macParser.JobProcessParamsContext ctx);
	void exitJobProcessParams(macParser.JobProcessParamsContext ctx);

	void enterJobStatement(macParser.JobStatementContext ctx);
	void exitJobStatement(macParser.JobStatementContext ctx);

	void enterElseCommand2(macParser.ElseCommand2Context ctx);
	void exitElseCommand2(macParser.ElseCommand2Context ctx);

	void enterGotoStatement(macParser.GotoStatementContext ctx);
	void exitGotoStatement(macParser.GotoStatementContext ctx);

	void enterVariable(macParser.VariableContext ctx);
	void exitVariable(macParser.VariableContext ctx);

	void enterComments(macParser.CommentsContext ctx);
	void exitComments(macParser.CommentsContext ctx);

	void enterZnspaceCommand(macParser.ZnspaceCommandContext ctx);
	void exitZnspaceCommand(macParser.ZnspaceCommandContext ctx);

	void enterExpression(macParser.ExpressionContext ctx);
	void exitExpression(macParser.ExpressionContext ctx);

	void enterLabelDef(macParser.LabelDefContext ctx);
	void exitLabelDef(macParser.LabelDefContext ctx);

	void enterZsaveCommand(macParser.ZsaveCommandContext ctx);
	void exitZsaveCommand(macParser.ZsaveCommandContext ctx);

	void enterReadStatement(macParser.ReadStatementContext ctx);
	void exitReadStatement(macParser.ReadStatementContext ctx);

	void enterXecuteStatement(macParser.XecuteStatementContext ctx);
	void exitXecuteStatement(macParser.XecuteStatementContext ctx);

	void enterLabelParameter(macParser.LabelParameterContext ctx);
	void exitLabelParameter(macParser.LabelParameterContext ctx);

	void enterMergeStatement(macParser.MergeStatementContext ctx);
	void exitMergeStatement(macParser.MergeStatementContext ctx);

	void enterKillStatement(macParser.KillStatementContext ctx);
	void exitKillStatement(macParser.KillStatementContext ctx);

	void enterZremoveCommand(macParser.ZremoveCommandContext ctx);
	void exitZremoveCommand(macParser.ZremoveCommandContext ctx);

	void enterZkillStatement(macParser.ZkillStatementContext ctx);
	void exitZkillStatement(macParser.ZkillStatementContext ctx);

	void enterDoArgument(macParser.DoArgumentContext ctx);
	void exitDoArgument(macParser.DoArgumentContext ctx);

	void enterHangCommand(macParser.HangCommandContext ctx);
	void exitHangCommand(macParser.HangCommandContext ctx);

	void enterZzdumpCommand(macParser.ZzdumpCommandContext ctx);
	void exitZzdumpCommand(macParser.ZzdumpCommandContext ctx);

	void enterGotoCommand(macParser.GotoCommandContext ctx);
	void exitGotoCommand(macParser.GotoCommandContext ctx);

	void enterHangStatement(macParser.HangStatementContext ctx);
	void exitHangStatement(macParser.HangStatementContext ctx);

	void enterCondition(macParser.ConditionContext ctx);
	void exitCondition(macParser.ConditionContext ctx);

	void enterBreakCommand(macParser.BreakCommandContext ctx);
	void exitBreakCommand(macParser.BreakCommandContext ctx);

	void enterPrintStatement(macParser.PrintStatementContext ctx);
	void exitPrintStatement(macParser.PrintStatementContext ctx);

	void enterStatement(macParser.StatementContext ctx);
	void exitStatement(macParser.StatementContext ctx);

	void enterZwriteStatement(macParser.ZwriteStatementContext ctx);
	void exitZwriteStatement(macParser.ZwriteStatementContext ctx);

	void enterQuitCommand(macParser.QuitCommandContext ctx);
	void exitQuitCommand(macParser.QuitCommandContext ctx);

	void enterTryCommand(macParser.TryCommandContext ctx);
	void exitTryCommand(macParser.TryCommandContext ctx);

	void enterGlobalVariable(macParser.GlobalVariableContext ctx);
	void exitGlobalVariable(macParser.GlobalVariableContext ctx);

	void enterDoClass(macParser.DoClassContext ctx);
	void exitDoClass(macParser.DoClassContext ctx);

	void enterViewStatement(macParser.ViewStatementContext ctx);
	void exitViewStatement(macParser.ViewStatementContext ctx);

	void enterJobCommand(macParser.JobCommandContext ctx);
	void exitJobCommand(macParser.JobCommandContext ctx);

	void enterSystemFunction(macParser.SystemFunctionContext ctx);
	void exitSystemFunction(macParser.SystemFunctionContext ctx);

	void enterSimpleExpression(macParser.SimpleExpressionContext ctx);
	void exitSimpleExpression(macParser.SimpleExpressionContext ctx);

	void enterCatchCommand(macParser.CatchCommandContext ctx);
	void exitCatchCommand(macParser.CatchCommandContext ctx);

	void enterLocalVariable(macParser.LocalVariableContext ctx);
	void exitLocalVariable(macParser.LocalVariableContext ctx);

	void enterBlockStatement(macParser.BlockStatementContext ctx);
	void exitBlockStatement(macParser.BlockStatementContext ctx);

	void enterXeceuteArgument(macParser.XeceuteArgumentContext ctx);
	void exitXeceuteArgument(macParser.XeceuteArgumentContext ctx);

	void enterZinsertCommand(macParser.ZinsertCommandContext ctx);
	void exitZinsertCommand(macParser.ZinsertCommandContext ctx);

	void enterJobArgument(macParser.JobArgumentContext ctx);
	void exitJobArgument(macParser.JobArgumentContext ctx);

	void enterTryStatement(macParser.TryStatementContext ctx);
	void exitTryStatement(macParser.TryStatementContext ctx);

	void enterXecuteCommand(macParser.XecuteCommandContext ctx);
	void exitXecuteCommand(macParser.XecuteCommandContext ctx);

	void enterZbreakCommand(macParser.ZbreakCommandContext ctx);
	void exitZbreakCommand(macParser.ZbreakCommandContext ctx);

	void enterDoStatement(macParser.DoStatementContext ctx);
	void exitDoStatement(macParser.DoStatementContext ctx);

	void enterWriteArgument(macParser.WriteArgumentContext ctx);
	void exitWriteArgument(macParser.WriteArgumentContext ctx);

	void enterKillArgument(macParser.KillArgumentContext ctx);
	void exitKillArgument(macParser.KillArgumentContext ctx);

	void enterNewCommand(macParser.NewCommandContext ctx);
	void exitNewCommand(macParser.NewCommandContext ctx);

	void enterReadArgument(macParser.ReadArgumentContext ctx);
	void exitReadArgument(macParser.ReadArgumentContext ctx);

	void enterLockArgument(macParser.LockArgumentContext ctx);
	void exitLockArgument(macParser.LockArgumentContext ctx);

	void enterCatchStatement(macParser.CatchStatementContext ctx);
	void exitCatchStatement(macParser.CatchStatementContext ctx);

	void enterWriteCommand(macParser.WriteCommandContext ctx);
	void exitWriteCommand(macParser.WriteCommandContext ctx);

	void enterIfStatement(macParser.IfStatementContext ctx);
	void exitIfStatement(macParser.IfStatementContext ctx);

	void enterTstartCommand(macParser.TstartCommandContext ctx);
	void exitTstartCommand(macParser.TstartCommandContext ctx);

	void enterLocalVariableList(macParser.LocalVariableListContext ctx);
	void exitLocalVariableList(macParser.LocalVariableListContext ctx);

	void enterZbreakStatement(macParser.ZbreakStatementContext ctx);
	void exitZbreakStatement(macParser.ZbreakStatementContext ctx);

	void enterWhileStatement(macParser.WhileStatementContext ctx);
	void exitWhileStatement(macParser.WhileStatementContext ctx);

	void enterQuitStatement(macParser.QuitStatementContext ctx);
	void exitQuitStatement(macParser.QuitStatementContext ctx);

	void enterThrowCommand(macParser.ThrowCommandContext ctx);
	void exitThrowCommand(macParser.ThrowCommandContext ctx);

	void enterUseStatement(macParser.UseStatementContext ctx);
	void exitUseStatement(macParser.UseStatementContext ctx);
}