// Generated from /home/daimor/Dropbox/myProjects/NBStudio/NBStudioCore/src/org/nbstudio/syntax/cls/clsParser.g4 by ANTLR 4.1

    package org.nbstudio.syntax.cls; 

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class clsParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ReadOnly=49, LBrace=116, ReturnResultsets=72, Method=3, CompileAfter=21, 
		SqlRowIdName=37, GenerateAfter=68, ForeignKeyName=98, Property=4, PublicList=71, 
		IndexName=100, Data=60, Extends=13, SoapNameSpace=75, ClassName=92, SoapBodyUse=35, 
		SqlViewName=81, TriggerDeclaration=115, DdlAllowed=22, EOL=105, CodeMode=66, 
		SoapAction=73, Comment=120, Inverse=46, Hidden=25, Required=50, Index=5, 
		OnUpdate=90, Class=1, ClientName=20, SqlName=63, SqlComputeOnChange=55, 
		UpdateColumnList=88, MethodDeclaration=112, ZenMethod=79, SqlView=80, 
		RParen=119, SqlComputeCode=53, SoapMessageName=74, ClientDataType=19, 
		LParen=118, SqlFieldName=56, OldTable=85, IncludeCode=27, Multidimensional=47, 
		Time=87, INT=102, PlaceAfter=70, XDataName=94, Foreach=83, ClassMethod=2, 
		WS=111, Projection=15, On=14, OnDelete=89, QueryDeclaration=114, Language=29, 
		DependsOn=23, Private=48, Abstract=17, Unique=65, NewTable=84, ServerOnly=33, 
		WebMethod=78, IdKey=61, Final=24, FLOAT=103, SoapBindingStyle=34, ID=101, 
		Internal=45, ExternalProcName=67, XDataDeclaration=113, Event=82, COMMA=107, 
		NotForProperty=69, EQUAL=110, PropertyName=96, SqlListDelimiter=57, ForeignKey=6, 
		Storage=91, DOT=106, Relationship=11, PrimaryKey=62, RBrace=117, Import=26, 
		ViewQuery=41, PERCENT=108, Query=7, Type=64, As=16, DOTCOMMA=109, ProcedureBlock=32, 
		Order=86, Trigger=10, SqlColumnNumber=52, QueryName=95, MethodName=93, 
		SqlCollation=51, SqlTableName=39, Include=12, ParameterName=97, Parameter=8, 
		SqlListType=58, Transient=59, InitialExpression=44, Owner=31, SoapTypeNameSpace=76, 
		Description=121, SqlCategory=36, StorageStrategy=40, SqlRowIdPrivate=38, 
		Calculated=42, SqlProc=77, ClassType=18, Identity=43, SqlComputed=54, 
		TriggerName=99, OdbcType=30, IncludeGenerator=28, XData=9, STRING=104;
	public static final String[] tokenNames = {
		"<INVALID>", "Class", "ClassMethod", "Method", "Property", "Index", "ForeignKey", 
		"Query", "Parameter", "XData", "Trigger", "Relationship", "Include", "Extends", 
		"On", "Projection", "As", "Abstract", "ClassType", "ClientDataType", "ClientName", 
		"CompileAfter", "DdlAllowed", "DependsOn", "Final", "Hidden", "Import", 
		"IncludeCode", "IncludeGenerator", "Language", "OdbcType", "Owner", "ProcedureBlock", 
		"ServerOnly", "SoapBindingStyle", "SoapBodyUse", "SqlCategory", "SqlRowIdName", 
		"SqlRowIdPrivate", "SqlTableName", "StorageStrategy", "ViewQuery", "Calculated", 
		"Identity", "InitialExpression", "Internal", "Inverse", "Multidimensional", 
		"Private", "ReadOnly", "Required", "SqlCollation", "SqlColumnNumber", 
		"SqlComputeCode", "SqlComputed", "SqlComputeOnChange", "SqlFieldName", 
		"SqlListDelimiter", "SqlListType", "Transient", "Data", "IdKey", "PrimaryKey", 
		"SqlName", "Type", "Unique", "CodeMode", "ExternalProcName", "GenerateAfter", 
		"NotForProperty", "PlaceAfter", "PublicList", "ReturnResultsets", "SoapAction", 
		"SoapMessageName", "SoapNameSpace", "SoapTypeNameSpace", "SqlProc", "WebMethod", 
		"ZenMethod", "SqlView", "SqlViewName", "Event", "Foreach", "NewTable", 
		"OldTable", "Order", "Time", "UpdateColumnList", "OnDelete", "OnUpdate", 
		"Storage", "ClassName", "MethodName", "XDataName", "QueryName", "PropertyName", 
		"ParameterName", "ForeignKeyName", "TriggerName", "IndexName", "ID", "INT", 
		"FLOAT", "STRING", "EOL", "'.'", "','", "'%'", "';'", "'='", "WS", "MethodDeclaration", 
		"XDataDeclaration", "QueryDeclaration", "TriggerDeclaration", "'{'", "'}'", 
		"'('", "')'", "Comment", "Description"
	};
	public static final int
		RULE_prog = 0, RULE_includeDefinition = 1, RULE_includeFile = 2, RULE_includeFiles = 3, 
		RULE_classDefintion = 4, RULE_classNames = 5, RULE_classExtends = 6, RULE_classContent = 7, 
		RULE_propertyDefinition = 8, RULE_propertyType = 9, RULE_parameterDefinition = 10, 
		RULE_methodDefintion = 11, RULE_xdataDefinition = 12, RULE_queryDefinition = 13, 
		RULE_ids = 14, RULE_listProperties = 15, RULE_indexDefinition = 16;
	public static final String[] ruleNames = {
		"prog", "includeDefinition", "includeFile", "includeFiles", "classDefintion", 
		"classNames", "classExtends", "classContent", "propertyDefinition", "propertyType", 
		"parameterDefinition", "methodDefintion", "xdataDefinition", "queryDefinition", 
		"ids", "listProperties", "indexDefinition"
	};

	@Override
	public String getGrammarFileName() { return "clsParser.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public clsParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public List<TerminalNode> Description() { return getTokens(clsParser.Description); }
		public TerminalNode Description(int i) {
			return getToken(clsParser.Description, i);
		}
		public ClassDefintionContext classDefintion() {
			return getRuleContext(ClassDefintionContext.class,0);
		}
		public IncludeDefinitionContext includeDefinition() {
			return getRuleContext(IncludeDefinitionContext.class,0);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof clsParserListener ) ((clsParserListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof clsParserListener ) ((clsParserListener)listener).exitProg(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			_la = _input.LA(1);
			if (_la==Include) {
				{
				setState(34); includeDefinition();
				}
			}

			setState(40);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Description) {
				{
				{
				setState(37); match(Description);
				}
				}
				setState(42);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(43); classDefintion();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IncludeDefinitionContext extends ParserRuleContext {
		public TerminalNode Include() { return getToken(clsParser.Include, 0); }
		public IncludeFilesContext includeFiles() {
			return getRuleContext(IncludeFilesContext.class,0);
		}
		public IncludeDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_includeDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof clsParserListener ) ((clsParserListener)listener).enterIncludeDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof clsParserListener ) ((clsParserListener)listener).exitIncludeDefinition(this);
		}
	}

	public final IncludeDefinitionContext includeDefinition() throws RecognitionException {
		IncludeDefinitionContext _localctx = new IncludeDefinitionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_includeDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45); match(Include);
			setState(46); includeFiles();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IncludeFileContext extends ParserRuleContext {
		public TerminalNode PERCENT() { return getToken(clsParser.PERCENT, 0); }
		public TerminalNode ID() { return getToken(clsParser.ID, 0); }
		public IncludeFileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_includeFile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof clsParserListener ) ((clsParserListener)listener).enterIncludeFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof clsParserListener ) ((clsParserListener)listener).exitIncludeFile(this);
		}
	}

	public final IncludeFileContext includeFile() throws RecognitionException {
		IncludeFileContext _localctx = new IncludeFileContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_includeFile);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			_la = _input.LA(1);
			if (_la==PERCENT) {
				{
				setState(48); match(PERCENT);
				}
			}

			setState(51); match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IncludeFilesContext extends ParserRuleContext {
		public TerminalNode LParen() { return getToken(clsParser.LParen, 0); }
		public IncludeFileContext includeFile(int i) {
			return getRuleContext(IncludeFileContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(clsParser.COMMA); }
		public List<IncludeFileContext> includeFile() {
			return getRuleContexts(IncludeFileContext.class);
		}
		public TerminalNode RParen() { return getToken(clsParser.RParen, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(clsParser.COMMA, i);
		}
		public IncludeFilesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_includeFiles; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof clsParserListener ) ((clsParserListener)listener).enterIncludeFiles(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof clsParserListener ) ((clsParserListener)listener).exitIncludeFiles(this);
		}
	}

	public final IncludeFilesContext includeFiles() throws RecognitionException {
		IncludeFilesContext _localctx = new IncludeFilesContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_includeFiles);
		int _la;
		try {
			setState(65);
			switch (_input.LA(1)) {
			case ID:
			case PERCENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(53); includeFile();
				}
				break;
			case LParen:
				enterOuterAlt(_localctx, 2);
				{
				setState(54); match(LParen);
				setState(55); includeFile();
				setState(60);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(56); match(COMMA);
					setState(57); includeFile();
					}
					}
					setState(62);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(63); match(RParen);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassDefintionContext extends ParserRuleContext {
		public ClassContentContext classContent(int i) {
			return getRuleContext(ClassContentContext.class,i);
		}
		public TerminalNode Class() { return getToken(clsParser.Class, 0); }
		public TerminalNode LBrace() { return getToken(clsParser.LBrace, 0); }
		public TerminalNode RBrace() { return getToken(clsParser.RBrace, 0); }
		public ClassNamesContext classNames() {
			return getRuleContext(ClassNamesContext.class,0);
		}
		public List<ClassContentContext> classContent() {
			return getRuleContexts(ClassContentContext.class);
		}
		public ClassExtendsContext classExtends() {
			return getRuleContext(ClassExtendsContext.class,0);
		}
		public ClassDefintionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDefintion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof clsParserListener ) ((clsParserListener)listener).enterClassDefintion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof clsParserListener ) ((clsParserListener)listener).exitClassDefintion(this);
		}
	}

	public final ClassDefintionContext classDefintion() throws RecognitionException {
		ClassDefintionContext _localctx = new ClassDefintionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_classDefintion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67); match(Class);
			setState(68); classNames();
			setState(70);
			_la = _input.LA(1);
			if (_la==Extends) {
				{
				setState(69); classExtends();
				}
			}

			setState(72); match(LBrace);
			setState(76);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ClassMethod) | (1L << Method) | (1L << Property) | (1L << Index) | (1L << Query) | (1L << Parameter) | (1L << XData))) != 0) || _la==Comment || _la==Description) {
				{
				{
				setState(73); classContent();
				}
				}
				setState(78);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(79); match(RBrace);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassNamesContext extends ParserRuleContext {
		public TerminalNode LParen() { return getToken(clsParser.LParen, 0); }
		public List<TerminalNode> COMMA() { return getTokens(clsParser.COMMA); }
		public List<TerminalNode> ClassName() { return getTokens(clsParser.ClassName); }
		public TerminalNode RParen() { return getToken(clsParser.RParen, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(clsParser.COMMA, i);
		}
		public TerminalNode ClassName(int i) {
			return getToken(clsParser.ClassName, i);
		}
		public ClassNamesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classNames; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof clsParserListener ) ((clsParserListener)listener).enterClassNames(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof clsParserListener ) ((clsParserListener)listener).exitClassNames(this);
		}
	}

	public final ClassNamesContext classNames() throws RecognitionException {
		ClassNamesContext _localctx = new ClassNamesContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_classNames);
		int _la;
		try {
			setState(92);
			switch (_input.LA(1)) {
			case ClassName:
				enterOuterAlt(_localctx, 1);
				{
				setState(81); match(ClassName);
				}
				break;
			case LParen:
				enterOuterAlt(_localctx, 2);
				{
				setState(82); match(LParen);
				setState(83); match(ClassName);
				setState(88);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(84); match(COMMA);
					setState(85); match(ClassName);
					}
					}
					setState(90);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(91); match(RParen);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassExtendsContext extends ParserRuleContext {
		public TerminalNode Extends() { return getToken(clsParser.Extends, 0); }
		public ClassNamesContext classNames() {
			return getRuleContext(ClassNamesContext.class,0);
		}
		public ClassExtendsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classExtends; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof clsParserListener ) ((clsParserListener)listener).enterClassExtends(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof clsParserListener ) ((clsParserListener)listener).exitClassExtends(this);
		}
	}

	public final ClassExtendsContext classExtends() throws RecognitionException {
		ClassExtendsContext _localctx = new ClassExtendsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_classExtends);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94); match(Extends);
			setState(95); classNames();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassContentContext extends ParserRuleContext {
		public TerminalNode Description() { return getToken(clsParser.Description, 0); }
		public IndexDefinitionContext indexDefinition() {
			return getRuleContext(IndexDefinitionContext.class,0);
		}
		public ParameterDefinitionContext parameterDefinition() {
			return getRuleContext(ParameterDefinitionContext.class,0);
		}
		public XdataDefinitionContext xdataDefinition() {
			return getRuleContext(XdataDefinitionContext.class,0);
		}
		public MethodDefintionContext methodDefintion() {
			return getRuleContext(MethodDefintionContext.class,0);
		}
		public QueryDefinitionContext queryDefinition() {
			return getRuleContext(QueryDefinitionContext.class,0);
		}
		public TerminalNode Comment() { return getToken(clsParser.Comment, 0); }
		public PropertyDefinitionContext propertyDefinition() {
			return getRuleContext(PropertyDefinitionContext.class,0);
		}
		public ClassContentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classContent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof clsParserListener ) ((clsParserListener)listener).enterClassContent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof clsParserListener ) ((clsParserListener)listener).exitClassContent(this);
		}
	}

	public final ClassContentContext classContent() throws RecognitionException {
		ClassContentContext _localctx = new ClassContentContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_classContent);
		try {
			setState(105);
			switch (_input.LA(1)) {
			case Description:
				enterOuterAlt(_localctx, 1);
				{
				setState(97); match(Description);
				}
				break;
			case Comment:
				enterOuterAlt(_localctx, 2);
				{
				setState(98); match(Comment);
				}
				break;
			case Property:
				enterOuterAlt(_localctx, 3);
				{
				setState(99); propertyDefinition();
				}
				break;
			case Parameter:
				enterOuterAlt(_localctx, 4);
				{
				setState(100); parameterDefinition();
				}
				break;
			case Index:
				enterOuterAlt(_localctx, 5);
				{
				setState(101); indexDefinition();
				}
				break;
			case ClassMethod:
			case Method:
				enterOuterAlt(_localctx, 6);
				{
				setState(102); methodDefintion();
				}
				break;
			case Query:
				enterOuterAlt(_localctx, 7);
				{
				setState(103); queryDefinition();
				}
				break;
			case XData:
				enterOuterAlt(_localctx, 8);
				{
				setState(104); xdataDefinition();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PropertyDefinitionContext extends ParserRuleContext {
		public TerminalNode DOTCOMMA() { return getToken(clsParser.DOTCOMMA, 0); }
		public TerminalNode Property() { return getToken(clsParser.Property, 0); }
		public TerminalNode As() { return getToken(clsParser.As, 0); }
		public TerminalNode PropertyName() { return getToken(clsParser.PropertyName, 0); }
		public PropertyTypeContext propertyType() {
			return getRuleContext(PropertyTypeContext.class,0);
		}
		public PropertyDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_propertyDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof clsParserListener ) ((clsParserListener)listener).enterPropertyDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof clsParserListener ) ((clsParserListener)listener).exitPropertyDefinition(this);
		}
	}

	public final PropertyDefinitionContext propertyDefinition() throws RecognitionException {
		PropertyDefinitionContext _localctx = new PropertyDefinitionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_propertyDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107); match(Property);
			setState(108); match(PropertyName);
			setState(111);
			_la = _input.LA(1);
			if (_la==As) {
				{
				setState(109); match(As);
				setState(110); propertyType();
				}
			}

			setState(113); match(DOTCOMMA);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PropertyTypeContext extends ParserRuleContext {
		public TerminalNode ClassName() { return getToken(clsParser.ClassName, 0); }
		public PropertyTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_propertyType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof clsParserListener ) ((clsParserListener)listener).enterPropertyType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof clsParserListener ) ((clsParserListener)listener).exitPropertyType(this);
		}
	}

	public final PropertyTypeContext propertyType() throws RecognitionException {
		PropertyTypeContext _localctx = new PropertyTypeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_propertyType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115); match(ClassName);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParameterDefinitionContext extends ParserRuleContext {
		public TerminalNode DOTCOMMA() { return getToken(clsParser.DOTCOMMA, 0); }
		public TerminalNode ParameterName() { return getToken(clsParser.ParameterName, 0); }
		public TerminalNode Parameter() { return getToken(clsParser.Parameter, 0); }
		public TerminalNode EQUAL() { return getToken(clsParser.EQUAL, 0); }
		public TerminalNode STRING() { return getToken(clsParser.STRING, 0); }
		public ParameterDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof clsParserListener ) ((clsParserListener)listener).enterParameterDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof clsParserListener ) ((clsParserListener)listener).exitParameterDefinition(this);
		}
	}

	public final ParameterDefinitionContext parameterDefinition() throws RecognitionException {
		ParameterDefinitionContext _localctx = new ParameterDefinitionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_parameterDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117); match(Parameter);
			setState(118); match(ParameterName);
			setState(121);
			_la = _input.LA(1);
			if (_la==EQUAL) {
				{
				setState(119); match(EQUAL);
				setState(120); match(STRING);
				}
			}

			setState(123); match(DOTCOMMA);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodDefintionContext extends ParserRuleContext {
		public TerminalNode Method() { return getToken(clsParser.Method, 0); }
		public TerminalNode LParen() { return getToken(clsParser.LParen, 0); }
		public TerminalNode MethodDeclaration() { return getToken(clsParser.MethodDeclaration, 0); }
		public TerminalNode RParen() { return getToken(clsParser.RParen, 0); }
		public TerminalNode ClassMethod() { return getToken(clsParser.ClassMethod, 0); }
		public TerminalNode MethodName() { return getToken(clsParser.MethodName, 0); }
		public MethodDefintionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDefintion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof clsParserListener ) ((clsParserListener)listener).enterMethodDefintion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof clsParserListener ) ((clsParserListener)listener).exitMethodDefintion(this);
		}
	}

	public final MethodDefintionContext methodDefintion() throws RecognitionException {
		MethodDefintionContext _localctx = new MethodDefintionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_methodDefintion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			_la = _input.LA(1);
			if ( !(_la==ClassMethod || _la==Method) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(126); match(MethodName);
			setState(127); match(LParen);
			setState(128); match(RParen);
			setState(129); match(MethodDeclaration);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class XdataDefinitionContext extends ParserRuleContext {
		public TerminalNode LParen() { return getToken(clsParser.LParen, 0); }
		public TerminalNode XDataDeclaration() { return getToken(clsParser.XDataDeclaration, 0); }
		public TerminalNode XData() { return getToken(clsParser.XData, 0); }
		public TerminalNode RParen() { return getToken(clsParser.RParen, 0); }
		public TerminalNode XDataName() { return getToken(clsParser.XDataName, 0); }
		public XdataDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_xdataDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof clsParserListener ) ((clsParserListener)listener).enterXdataDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof clsParserListener ) ((clsParserListener)listener).exitXdataDefinition(this);
		}
	}

	public final XdataDefinitionContext xdataDefinition() throws RecognitionException {
		XdataDefinitionContext _localctx = new XdataDefinitionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_xdataDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131); match(XData);
			setState(132); match(XDataName);
			setState(135);
			_la = _input.LA(1);
			if (_la==LParen) {
				{
				setState(133); match(LParen);
				setState(134); match(RParen);
				}
			}

			setState(137); match(XDataDeclaration);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QueryDefinitionContext extends ParserRuleContext {
		public TerminalNode LParen() { return getToken(clsParser.LParen, 0); }
		public TerminalNode QueryName() { return getToken(clsParser.QueryName, 0); }
		public TerminalNode Query() { return getToken(clsParser.Query, 0); }
		public TerminalNode RParen() { return getToken(clsParser.RParen, 0); }
		public TerminalNode QueryDeclaration() { return getToken(clsParser.QueryDeclaration, 0); }
		public QueryDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_queryDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof clsParserListener ) ((clsParserListener)listener).enterQueryDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof clsParserListener ) ((clsParserListener)listener).exitQueryDefinition(this);
		}
	}

	public final QueryDefinitionContext queryDefinition() throws RecognitionException {
		QueryDefinitionContext _localctx = new QueryDefinitionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_queryDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139); match(Query);
			setState(140); match(QueryName);
			setState(143);
			_la = _input.LA(1);
			if (_la==LParen) {
				{
				setState(141); match(LParen);
				setState(142); match(RParen);
				}
			}

			setState(145); match(QueryDeclaration);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdsContext extends ParserRuleContext {
		public TerminalNode LParen() { return getToken(clsParser.LParen, 0); }
		public List<TerminalNode> COMMA() { return getTokens(clsParser.COMMA); }
		public List<TerminalNode> ID() { return getTokens(clsParser.ID); }
		public TerminalNode RParen() { return getToken(clsParser.RParen, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(clsParser.COMMA, i);
		}
		public TerminalNode ID(int i) {
			return getToken(clsParser.ID, i);
		}
		public IdsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ids; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof clsParserListener ) ((clsParserListener)listener).enterIds(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof clsParserListener ) ((clsParserListener)listener).exitIds(this);
		}
	}

	public final IdsContext ids() throws RecognitionException {
		IdsContext _localctx = new IdsContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_ids);
		int _la;
		try {
			setState(158);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(147); match(ID);
				}
				break;
			case LParen:
				enterOuterAlt(_localctx, 2);
				{
				setState(148); match(LParen);
				setState(149); match(ID);
				setState(154);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(150); match(COMMA);
					setState(151); match(ID);
					}
					}
					setState(156);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(157); match(RParen);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ListPropertiesContext extends ParserRuleContext {
		public TerminalNode LParen() { return getToken(clsParser.LParen, 0); }
		public List<TerminalNode> COMMA() { return getTokens(clsParser.COMMA); }
		public TerminalNode PropertyName(int i) {
			return getToken(clsParser.PropertyName, i);
		}
		public TerminalNode RParen() { return getToken(clsParser.RParen, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(clsParser.COMMA, i);
		}
		public List<TerminalNode> PropertyName() { return getTokens(clsParser.PropertyName); }
		public ListPropertiesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listProperties; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof clsParserListener ) ((clsParserListener)listener).enterListProperties(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof clsParserListener ) ((clsParserListener)listener).exitListProperties(this);
		}
	}

	public final ListPropertiesContext listProperties() throws RecognitionException {
		ListPropertiesContext _localctx = new ListPropertiesContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_listProperties);
		int _la;
		try {
			setState(171);
			switch (_input.LA(1)) {
			case PropertyName:
				enterOuterAlt(_localctx, 1);
				{
				setState(160); match(PropertyName);
				}
				break;
			case LParen:
				enterOuterAlt(_localctx, 2);
				{
				setState(161); match(LParen);
				setState(162); match(PropertyName);
				setState(167);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(163); match(COMMA);
					setState(164); match(PropertyName);
					}
					}
					setState(169);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(170); match(RParen);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IndexDefinitionContext extends ParserRuleContext {
		public TerminalNode DOTCOMMA() { return getToken(clsParser.DOTCOMMA, 0); }
		public TerminalNode On() { return getToken(clsParser.On, 0); }
		public ListPropertiesContext listProperties() {
			return getRuleContext(ListPropertiesContext.class,0);
		}
		public TerminalNode IndexName() { return getToken(clsParser.IndexName, 0); }
		public TerminalNode Index() { return getToken(clsParser.Index, 0); }
		public IndexDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_indexDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof clsParserListener ) ((clsParserListener)listener).enterIndexDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof clsParserListener ) ((clsParserListener)listener).exitIndexDefinition(this);
		}
	}

	public final IndexDefinitionContext indexDefinition() throws RecognitionException {
		IndexDefinitionContext _localctx = new IndexDefinitionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_indexDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173); match(Index);
			setState(174); match(IndexName);
			setState(175); match(On);
			setState(176); listProperties();
			setState(177); match(DOTCOMMA);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3{\u00b6\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\5\2&\n\2\3\2\7\2)\n\2\f\2\16\2,\13\2\3\2\3\2\3\3\3\3\3\3\3\4\5\4"+
		"\64\n\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\7\5=\n\5\f\5\16\5@\13\5\3\5\3\5\5"+
		"\5D\n\5\3\6\3\6\3\6\5\6I\n\6\3\6\3\6\7\6M\n\6\f\6\16\6P\13\6\3\6\3\6\3"+
		"\7\3\7\3\7\3\7\3\7\7\7Y\n\7\f\7\16\7\\\13\7\3\7\5\7_\n\7\3\b\3\b\3\b\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\tl\n\t\3\n\3\n\3\n\3\n\5\nr\n\n\3\n\3"+
		"\n\3\13\3\13\3\f\3\f\3\f\3\f\5\f|\n\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\16\3\16\3\16\3\16\5\16\u008a\n\16\3\16\3\16\3\17\3\17\3\17\3\17\5\17"+
		"\u0092\n\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\7\20\u009b\n\20\f\20\16"+
		"\20\u009e\13\20\3\20\5\20\u00a1\n\20\3\21\3\21\3\21\3\21\3\21\7\21\u00a8"+
		"\n\21\f\21\16\21\u00ab\13\21\3\21\5\21\u00ae\n\21\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\2\23\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"\2\3\3\2"+
		"\4\5\u00bc\2%\3\2\2\2\4/\3\2\2\2\6\63\3\2\2\2\bC\3\2\2\2\nE\3\2\2\2\f"+
		"^\3\2\2\2\16`\3\2\2\2\20k\3\2\2\2\22m\3\2\2\2\24u\3\2\2\2\26w\3\2\2\2"+
		"\30\177\3\2\2\2\32\u0085\3\2\2\2\34\u008d\3\2\2\2\36\u00a0\3\2\2\2 \u00ad"+
		"\3\2\2\2\"\u00af\3\2\2\2$&\5\4\3\2%$\3\2\2\2%&\3\2\2\2&*\3\2\2\2\')\7"+
		"{\2\2(\'\3\2\2\2),\3\2\2\2*(\3\2\2\2*+\3\2\2\2+-\3\2\2\2,*\3\2\2\2-.\5"+
		"\n\6\2.\3\3\2\2\2/\60\7\16\2\2\60\61\5\b\5\2\61\5\3\2\2\2\62\64\7n\2\2"+
		"\63\62\3\2\2\2\63\64\3\2\2\2\64\65\3\2\2\2\65\66\7g\2\2\66\7\3\2\2\2\67"+
		"D\5\6\4\289\7x\2\29>\5\6\4\2:;\7m\2\2;=\5\6\4\2<:\3\2\2\2=@\3\2\2\2><"+
		"\3\2\2\2>?\3\2\2\2?A\3\2\2\2@>\3\2\2\2AB\7y\2\2BD\3\2\2\2C\67\3\2\2\2"+
		"C8\3\2\2\2D\t\3\2\2\2EF\7\3\2\2FH\5\f\7\2GI\5\16\b\2HG\3\2\2\2HI\3\2\2"+
		"\2IJ\3\2\2\2JN\7v\2\2KM\5\20\t\2LK\3\2\2\2MP\3\2\2\2NL\3\2\2\2NO\3\2\2"+
		"\2OQ\3\2\2\2PN\3\2\2\2QR\7w\2\2R\13\3\2\2\2S_\7^\2\2TU\7x\2\2UZ\7^\2\2"+
		"VW\7m\2\2WY\7^\2\2XV\3\2\2\2Y\\\3\2\2\2ZX\3\2\2\2Z[\3\2\2\2[]\3\2\2\2"+
		"\\Z\3\2\2\2]_\7y\2\2^S\3\2\2\2^T\3\2\2\2_\r\3\2\2\2`a\7\17\2\2ab\5\f\7"+
		"\2b\17\3\2\2\2cl\7{\2\2dl\7z\2\2el\5\22\n\2fl\5\26\f\2gl\5\"\22\2hl\5"+
		"\30\r\2il\5\34\17\2jl\5\32\16\2kc\3\2\2\2kd\3\2\2\2ke\3\2\2\2kf\3\2\2"+
		"\2kg\3\2\2\2kh\3\2\2\2ki\3\2\2\2kj\3\2\2\2l\21\3\2\2\2mn\7\6\2\2nq\7b"+
		"\2\2op\7\22\2\2pr\5\24\13\2qo\3\2\2\2qr\3\2\2\2rs\3\2\2\2st\7o\2\2t\23"+
		"\3\2\2\2uv\7^\2\2v\25\3\2\2\2wx\7\n\2\2x{\7c\2\2yz\7p\2\2z|\7j\2\2{y\3"+
		"\2\2\2{|\3\2\2\2|}\3\2\2\2}~\7o\2\2~\27\3\2\2\2\177\u0080\t\2\2\2\u0080"+
		"\u0081\7_\2\2\u0081\u0082\7x\2\2\u0082\u0083\7y\2\2\u0083\u0084\7r\2\2"+
		"\u0084\31\3\2\2\2\u0085\u0086\7\13\2\2\u0086\u0089\7`\2\2\u0087\u0088"+
		"\7x\2\2\u0088\u008a\7y\2\2\u0089\u0087\3\2\2\2\u0089\u008a\3\2\2\2\u008a"+
		"\u008b\3\2\2\2\u008b\u008c\7s\2\2\u008c\33\3\2\2\2\u008d\u008e\7\t\2\2"+
		"\u008e\u0091\7a\2\2\u008f\u0090\7x\2\2\u0090\u0092\7y\2\2\u0091\u008f"+
		"\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0094\7t\2\2\u0094"+
		"\35\3\2\2\2\u0095\u00a1\7g\2\2\u0096\u0097\7x\2\2\u0097\u009c\7g\2\2\u0098"+
		"\u0099\7m\2\2\u0099\u009b\7g\2\2\u009a\u0098\3\2\2\2\u009b\u009e\3\2\2"+
		"\2\u009c\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u009f\3\2\2\2\u009e\u009c"+
		"\3\2\2\2\u009f\u00a1\7y\2\2\u00a0\u0095\3\2\2\2\u00a0\u0096\3\2\2\2\u00a1"+
		"\37\3\2\2\2\u00a2\u00ae\7b\2\2\u00a3\u00a4\7x\2\2\u00a4\u00a9\7b\2\2\u00a5"+
		"\u00a6\7m\2\2\u00a6\u00a8\7b\2\2\u00a7\u00a5\3\2\2\2\u00a8\u00ab\3\2\2"+
		"\2\u00a9\u00a7\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00ac\3\2\2\2\u00ab\u00a9"+
		"\3\2\2\2\u00ac\u00ae\7y\2\2\u00ad\u00a2\3\2\2\2\u00ad\u00a3\3\2\2\2\u00ae"+
		"!\3\2\2\2\u00af\u00b0\7\7\2\2\u00b0\u00b1\7f\2\2\u00b1\u00b2\7\20\2\2"+
		"\u00b2\u00b3\5 \21\2\u00b3\u00b4\7o\2\2\u00b4#\3\2\2\2\24%*\63>CHNZ^k"+
		"q{\u0089\u0091\u009c\u00a0\u00a9\u00ad";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}