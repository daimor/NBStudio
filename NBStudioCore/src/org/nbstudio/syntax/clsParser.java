// Generated from /home/daimor/Dropbox/myProjects/NBStudio/NBStudioCore/src/org/nbstudio/syntax/clsParser.g4 by ANTLR 4.1

    package org.nbstudio.syntax; 

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
		ReadOnly=49, LBrace=103, ReturnResultsets=72, Method=8, CompileAfter=21, 
		SqlRowIdName=37, GenerateAfter=68, Property=11, PublicList=71, Data=60, 
		Extends=3, SoapNameSpace=75, SoapBodyUse=35, SqlViewName=81, DdlAllowed=22, 
		CodeMode=66, EOL=96, SoapAction=73, Inverse=46, Hidden=25, Required=50, 
		Index=6, OnUpdate=90, Class=2, ClientName=20, SqlName=63, SqlComputeOnChange=55, 
		UpdateColumnList=88, ZenMethod=79, SqlView=80, RParen=106, SqlComputeCode=53, 
		SoapMessageName=74, ClientDataType=19, LParen=105, SqlFieldName=56, OldTable=85, 
		IncludeCode=27, Multidimensional=47, Time=87, INT=93, PlaceAfter=70, Foreach=83, 
		ClassMethod=4, WS=102, Projection=10, On=7, OnDelete=89, Language=29, 
		DependsOn=23, Private=48, Abstract=17, Unique=65, NewTable=84, ServerOnly=33, 
		WebMethod=78, IdKey=61, Final=24, SoapBindingStyle=34, FLOAT=94, ID=92, 
		Internal=45, ExternalProcName=67, Event=82, COMMA=98, NotForProperty=69, 
		EQUAL=101, SqlListDelimiter=57, ForeignKey=5, Storage=91, DOT=97, Relationship=13, 
		PrimaryKey=62, RBrace=104, Import=26, ViewQuery=41, PERCENT=99, Query=12, 
		Type=64, As=16, DOTCOMMA=100, ProcedureBlock=32, Order=86, Trigger=14, 
		SqlColumnNumber=52, SqlCollation=51, SqlTableName=39, Include=1, Parameter=9, 
		SqlListType=58, Transient=59, InitialExpression=44, Owner=31, SoapTypeNameSpace=76, 
		Description=107, SqlCategory=36, StorageStrategy=40, SqlRowIdPrivate=38, 
		Calculated=42, SqlProc=77, ClassType=18, Identity=43, SqlComputed=54, 
		OdbcType=30, IncludeGenerator=28, XData=15, STRING=95;
	public static final String[] tokenNames = {
		"<INVALID>", "Include", "Class", "Extends", "ClassMethod", "ForeignKey", 
		"Index", "On", "Method", "Parameter", "Projection", "Property", "Query", 
		"Relationship", "Trigger", "XData", "As", "Abstract", "ClassType", "ClientDataType", 
		"ClientName", "CompileAfter", "DdlAllowed", "DependsOn", "Final", "Hidden", 
		"Import", "IncludeCode", "IncludeGenerator", "Language", "OdbcType", "Owner", 
		"ProcedureBlock", "ServerOnly", "SoapBindingStyle", "SoapBodyUse", "SqlCategory", 
		"SqlRowIdName", "SqlRowIdPrivate", "SqlTableName", "StorageStrategy", 
		"ViewQuery", "Calculated", "Identity", "InitialExpression", "Internal", 
		"Inverse", "Multidimensional", "Private", "ReadOnly", "Required", "SqlCollation", 
		"SqlColumnNumber", "SqlComputeCode", "SqlComputed", "SqlComputeOnChange", 
		"SqlFieldName", "SqlListDelimiter", "SqlListType", "Transient", "Data", 
		"IdKey", "PrimaryKey", "SqlName", "Type", "Unique", "CodeMode", "ExternalProcName", 
		"GenerateAfter", "NotForProperty", "PlaceAfter", "PublicList", "ReturnResultsets", 
		"SoapAction", "SoapMessageName", "SoapNameSpace", "SoapTypeNameSpace", 
		"SqlProc", "WebMethod", "ZenMethod", "SqlView", "SqlViewName", "Event", 
		"Foreach", "NewTable", "OldTable", "Order", "Time", "UpdateColumnList", 
		"OnDelete", "OnUpdate", "Storage", "ID", "INT", "FLOAT", "STRING", "EOL", 
		"'.'", "','", "'%'", "';'", "'='", "WS", "'{'", "'}'", "'('", "')'", "Description"
	};
	public static final int
		RULE_prog = 0, RULE_includeDefinition = 1, RULE_includeFile = 2, RULE_includeFiles = 3, 
		RULE_classDefintion = 4, RULE_className = 5, RULE_classNames = 6, RULE_classExtends = 7, 
		RULE_classContent = 8, RULE_propertyDefinition = 9, RULE_propertyType = 10, 
		RULE_parameterDefinition = 11, RULE_ids = 12, RULE_dotid = 13, RULE_dotids = 14, 
		RULE_indexDefinition = 15;
	public static final String[] ruleNames = {
		"prog", "includeDefinition", "includeFile", "includeFiles", "classDefintion", 
		"className", "classNames", "classExtends", "classContent", "propertyDefinition", 
		"propertyType", "parameterDefinition", "ids", "dotid", "dotids", "indexDefinition"
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
		public TerminalNode Description() { return getToken(clsParser.Description, 0); }
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
			setState(33);
			_la = _input.LA(1);
			if (_la==Include) {
				{
				setState(32); includeDefinition();
				}
			}

			setState(36);
			_la = _input.LA(1);
			if (_la==Description) {
				{
				setState(35); match(Description);
				}
			}

			setState(38); classDefintion();
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
			setState(40); match(Include);
			setState(41); includeFiles();
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
			setState(44);
			_la = _input.LA(1);
			if (_la==PERCENT) {
				{
				setState(43); match(PERCENT);
				}
			}

			setState(46); match(ID);
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
			setState(60);
			switch (_input.LA(1)) {
			case ID:
			case PERCENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(48); includeFile();
				}
				break;
			case LParen:
				enterOuterAlt(_localctx, 2);
				{
				setState(49); match(LParen);
				setState(50); includeFile();
				setState(55);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(51); match(COMMA);
					setState(52); includeFile();
					}
					}
					setState(57);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(58); match(RParen);
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
		public ClassNameContext className() {
			return getRuleContext(ClassNameContext.class,0);
		}
		public TerminalNode Class() { return getToken(clsParser.Class, 0); }
		public TerminalNode LBrace() { return getToken(clsParser.LBrace, 0); }
		public TerminalNode RBrace() { return getToken(clsParser.RBrace, 0); }
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
			setState(62); match(Class);
			setState(63); className();
			setState(65);
			_la = _input.LA(1);
			if (_la==Extends) {
				{
				setState(64); classExtends();
				}
			}

			setState(67); match(LBrace);
			setState(71);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Index) | (1L << Parameter) | (1L << Property))) != 0) || _la==Description) {
				{
				{
				setState(68); classContent();
				}
				}
				setState(73);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(74); match(RBrace);
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

	public static class ClassNameContext extends ParserRuleContext {
		public List<TerminalNode> DOT() { return getTokens(clsParser.DOT); }
		public TerminalNode PERCENT() { return getToken(clsParser.PERCENT, 0); }
		public List<TerminalNode> ID() { return getTokens(clsParser.ID); }
		public TerminalNode DOT(int i) {
			return getToken(clsParser.DOT, i);
		}
		public TerminalNode ID(int i) {
			return getToken(clsParser.ID, i);
		}
		public ClassNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_className; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof clsParserListener ) ((clsParserListener)listener).enterClassName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof clsParserListener ) ((clsParserListener)listener).exitClassName(this);
		}
	}

	public final ClassNameContext className() throws RecognitionException {
		ClassNameContext _localctx = new ClassNameContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_className);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			_la = _input.LA(1);
			if (_la==PERCENT) {
				{
				setState(76); match(PERCENT);
				}
			}

			setState(79); match(ID);
			setState(84);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(80); match(DOT);
				setState(81); match(ID);
				}
				}
				setState(86);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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
		public List<ClassNameContext> className() {
			return getRuleContexts(ClassNameContext.class);
		}
		public TerminalNode LParen() { return getToken(clsParser.LParen, 0); }
		public List<TerminalNode> COMMA() { return getTokens(clsParser.COMMA); }
		public TerminalNode RParen() { return getToken(clsParser.RParen, 0); }
		public ClassNameContext className(int i) {
			return getRuleContext(ClassNameContext.class,i);
		}
		public TerminalNode COMMA(int i) {
			return getToken(clsParser.COMMA, i);
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
		enterRule(_localctx, 12, RULE_classNames);
		int _la;
		try {
			setState(99);
			switch (_input.LA(1)) {
			case ID:
			case PERCENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(87); className();
				}
				break;
			case LParen:
				enterOuterAlt(_localctx, 2);
				{
				setState(88); match(LParen);
				setState(89); className();
				setState(94);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(90); match(COMMA);
					setState(91); className();
					}
					}
					setState(96);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(97); match(RParen);
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
		enterRule(_localctx, 14, RULE_classExtends);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101); match(Extends);
			setState(102); classNames();
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
		enterRule(_localctx, 16, RULE_classContent);
		try {
			setState(108);
			switch (_input.LA(1)) {
			case Description:
				enterOuterAlt(_localctx, 1);
				{
				setState(104); match(Description);
				}
				break;
			case Property:
				enterOuterAlt(_localctx, 2);
				{
				setState(105); propertyDefinition();
				}
				break;
			case Parameter:
				enterOuterAlt(_localctx, 3);
				{
				setState(106); parameterDefinition();
				}
				break;
			case Index:
				enterOuterAlt(_localctx, 4);
				{
				setState(107); indexDefinition();
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
		public TerminalNode ID() { return getToken(clsParser.ID, 0); }
		public TerminalNode As() { return getToken(clsParser.As, 0); }
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
		enterRule(_localctx, 18, RULE_propertyDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110); match(Property);
			setState(111); match(ID);
			setState(114);
			_la = _input.LA(1);
			if (_la==As) {
				{
				setState(112); match(As);
				setState(113); propertyType();
				}
			}

			setState(116); match(DOTCOMMA);
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
		public List<TerminalNode> DOT() { return getTokens(clsParser.DOT); }
		public TerminalNode PERCENT() { return getToken(clsParser.PERCENT, 0); }
		public List<TerminalNode> ID() { return getTokens(clsParser.ID); }
		public TerminalNode DOT(int i) {
			return getToken(clsParser.DOT, i);
		}
		public TerminalNode ID(int i) {
			return getToken(clsParser.ID, i);
		}
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
		enterRule(_localctx, 20, RULE_propertyType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			_la = _input.LA(1);
			if (_la==PERCENT) {
				{
				setState(118); match(PERCENT);
				}
			}

			setState(121); match(ID);
			setState(126);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(122); match(DOT);
				setState(123); match(ID);
				}
				}
				setState(128);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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
		public TerminalNode ID() { return getToken(clsParser.ID, 0); }
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
		enterRule(_localctx, 22, RULE_parameterDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129); match(Parameter);
			setState(130); match(ID);
			setState(133);
			_la = _input.LA(1);
			if (_la==EQUAL) {
				{
				setState(131); match(EQUAL);
				setState(132); match(STRING);
				}
			}

			setState(135); match(DOTCOMMA);
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
		enterRule(_localctx, 24, RULE_ids);
		int _la;
		try {
			setState(148);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(137); match(ID);
				}
				break;
			case LParen:
				enterOuterAlt(_localctx, 2);
				{
				setState(138); match(LParen);
				setState(139); match(ID);
				setState(144);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(140); match(COMMA);
					setState(141); match(ID);
					}
					}
					setState(146);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(147); match(RParen);
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

	public static class DotidContext extends ParserRuleContext {
		public List<TerminalNode> DOT() { return getTokens(clsParser.DOT); }
		public List<TerminalNode> ID() { return getTokens(clsParser.ID); }
		public TerminalNode DOT(int i) {
			return getToken(clsParser.DOT, i);
		}
		public TerminalNode ID(int i) {
			return getToken(clsParser.ID, i);
		}
		public DotidContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dotid; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof clsParserListener ) ((clsParserListener)listener).enterDotid(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof clsParserListener ) ((clsParserListener)listener).exitDotid(this);
		}
	}

	public final DotidContext dotid() throws RecognitionException {
		DotidContext _localctx = new DotidContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_dotid);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150); match(ID);
			setState(155);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(151); match(DOT);
				setState(152); match(ID);
				}
				}
				setState(157);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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

	public static class DotidsContext extends ParserRuleContext {
		public TerminalNode LParen() { return getToken(clsParser.LParen, 0); }
		public List<TerminalNode> COMMA() { return getTokens(clsParser.COMMA); }
		public TerminalNode RParen() { return getToken(clsParser.RParen, 0); }
		public DotidContext dotid(int i) {
			return getRuleContext(DotidContext.class,i);
		}
		public TerminalNode COMMA(int i) {
			return getToken(clsParser.COMMA, i);
		}
		public List<DotidContext> dotid() {
			return getRuleContexts(DotidContext.class);
		}
		public DotidsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dotids; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof clsParserListener ) ((clsParserListener)listener).enterDotids(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof clsParserListener ) ((clsParserListener)listener).exitDotids(this);
		}
	}

	public final DotidsContext dotids() throws RecognitionException {
		DotidsContext _localctx = new DotidsContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_dotids);
		int _la;
		try {
			setState(170);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(158); dotid();
				}
				break;
			case LParen:
				enterOuterAlt(_localctx, 2);
				{
				setState(159); match(LParen);
				setState(160); dotid();
				setState(165);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(161); match(COMMA);
					setState(162); dotid();
					}
					}
					setState(167);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(168); match(RParen);
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
		public DotidsContext dotids() {
			return getRuleContext(DotidsContext.class,0);
		}
		public TerminalNode DOTCOMMA() { return getToken(clsParser.DOTCOMMA, 0); }
		public TerminalNode On() { return getToken(clsParser.On, 0); }
		public TerminalNode ID() { return getToken(clsParser.ID, 0); }
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
		enterRule(_localctx, 30, RULE_indexDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172); match(Index);
			setState(173); match(ID);
			setState(174); match(On);
			setState(175); dotids();
			setState(176); match(DOTCOMMA);
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3m\u00b5\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\5\2$\n"+
		"\2\3\2\5\2\'\n\2\3\2\3\2\3\3\3\3\3\3\3\4\5\4/\n\4\3\4\3\4\3\5\3\5\3\5"+
		"\3\5\3\5\7\58\n\5\f\5\16\5;\13\5\3\5\3\5\5\5?\n\5\3\6\3\6\3\6\5\6D\n\6"+
		"\3\6\3\6\7\6H\n\6\f\6\16\6K\13\6\3\6\3\6\3\7\5\7P\n\7\3\7\3\7\3\7\7\7"+
		"U\n\7\f\7\16\7X\13\7\3\b\3\b\3\b\3\b\3\b\7\b_\n\b\f\b\16\bb\13\b\3\b\3"+
		"\b\5\bf\n\b\3\t\3\t\3\t\3\n\3\n\3\n\3\n\5\no\n\n\3\13\3\13\3\13\3\13\5"+
		"\13u\n\13\3\13\3\13\3\f\5\fz\n\f\3\f\3\f\3\f\7\f\177\n\f\f\f\16\f\u0082"+
		"\13\f\3\r\3\r\3\r\3\r\5\r\u0088\n\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\7"+
		"\16\u0091\n\16\f\16\16\16\u0094\13\16\3\16\5\16\u0097\n\16\3\17\3\17\3"+
		"\17\7\17\u009c\n\17\f\17\16\17\u009f\13\17\3\20\3\20\3\20\3\20\3\20\7"+
		"\20\u00a6\n\20\f\20\16\20\u00a9\13\20\3\20\3\20\5\20\u00ad\n\20\3\21\3"+
		"\21\3\21\3\21\3\21\3\21\3\21\2\22\2\4\6\b\n\f\16\20\22\24\26\30\32\34"+
		"\36 \2\2\u00bb\2#\3\2\2\2\4*\3\2\2\2\6.\3\2\2\2\b>\3\2\2\2\n@\3\2\2\2"+
		"\fO\3\2\2\2\16e\3\2\2\2\20g\3\2\2\2\22n\3\2\2\2\24p\3\2\2\2\26y\3\2\2"+
		"\2\30\u0083\3\2\2\2\32\u0096\3\2\2\2\34\u0098\3\2\2\2\36\u00ac\3\2\2\2"+
		" \u00ae\3\2\2\2\"$\5\4\3\2#\"\3\2\2\2#$\3\2\2\2$&\3\2\2\2%\'\7m\2\2&%"+
		"\3\2\2\2&\'\3\2\2\2\'(\3\2\2\2()\5\n\6\2)\3\3\2\2\2*+\7\3\2\2+,\5\b\5"+
		"\2,\5\3\2\2\2-/\7e\2\2.-\3\2\2\2./\3\2\2\2/\60\3\2\2\2\60\61\7^\2\2\61"+
		"\7\3\2\2\2\62?\5\6\4\2\63\64\7k\2\2\649\5\6\4\2\65\66\7d\2\2\668\5\6\4"+
		"\2\67\65\3\2\2\28;\3\2\2\29\67\3\2\2\29:\3\2\2\2:<\3\2\2\2;9\3\2\2\2<"+
		"=\7l\2\2=?\3\2\2\2>\62\3\2\2\2>\63\3\2\2\2?\t\3\2\2\2@A\7\4\2\2AC\5\f"+
		"\7\2BD\5\20\t\2CB\3\2\2\2CD\3\2\2\2DE\3\2\2\2EI\7i\2\2FH\5\22\n\2GF\3"+
		"\2\2\2HK\3\2\2\2IG\3\2\2\2IJ\3\2\2\2JL\3\2\2\2KI\3\2\2\2LM\7j\2\2M\13"+
		"\3\2\2\2NP\7e\2\2ON\3\2\2\2OP\3\2\2\2PQ\3\2\2\2QV\7^\2\2RS\7c\2\2SU\7"+
		"^\2\2TR\3\2\2\2UX\3\2\2\2VT\3\2\2\2VW\3\2\2\2W\r\3\2\2\2XV\3\2\2\2Yf\5"+
		"\f\7\2Z[\7k\2\2[`\5\f\7\2\\]\7d\2\2]_\5\f\7\2^\\\3\2\2\2_b\3\2\2\2`^\3"+
		"\2\2\2`a\3\2\2\2ac\3\2\2\2b`\3\2\2\2cd\7l\2\2df\3\2\2\2eY\3\2\2\2eZ\3"+
		"\2\2\2f\17\3\2\2\2gh\7\5\2\2hi\5\16\b\2i\21\3\2\2\2jo\7m\2\2ko\5\24\13"+
		"\2lo\5\30\r\2mo\5 \21\2nj\3\2\2\2nk\3\2\2\2nl\3\2\2\2nm\3\2\2\2o\23\3"+
		"\2\2\2pq\7\r\2\2qt\7^\2\2rs\7\22\2\2su\5\26\f\2tr\3\2\2\2tu\3\2\2\2uv"+
		"\3\2\2\2vw\7f\2\2w\25\3\2\2\2xz\7e\2\2yx\3\2\2\2yz\3\2\2\2z{\3\2\2\2{"+
		"\u0080\7^\2\2|}\7c\2\2}\177\7^\2\2~|\3\2\2\2\177\u0082\3\2\2\2\u0080~"+
		"\3\2\2\2\u0080\u0081\3\2\2\2\u0081\27\3\2\2\2\u0082\u0080\3\2\2\2\u0083"+
		"\u0084\7\13\2\2\u0084\u0087\7^\2\2\u0085\u0086\7g\2\2\u0086\u0088\7a\2"+
		"\2\u0087\u0085\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u008a"+
		"\7f\2\2\u008a\31\3\2\2\2\u008b\u0097\7^\2\2\u008c\u008d\7k\2\2\u008d\u0092"+
		"\7^\2\2\u008e\u008f\7d\2\2\u008f\u0091\7^\2\2\u0090\u008e\3\2\2\2\u0091"+
		"\u0094\3\2\2\2\u0092\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0095\3\2"+
		"\2\2\u0094\u0092\3\2\2\2\u0095\u0097\7l\2\2\u0096\u008b\3\2\2\2\u0096"+
		"\u008c\3\2\2\2\u0097\33\3\2\2\2\u0098\u009d\7^\2\2\u0099\u009a\7c\2\2"+
		"\u009a\u009c\7^\2\2\u009b\u0099\3\2\2\2\u009c\u009f\3\2\2\2\u009d\u009b"+
		"\3\2\2\2\u009d\u009e\3\2\2\2\u009e\35\3\2\2\2\u009f\u009d\3\2\2\2\u00a0"+
		"\u00ad\5\34\17\2\u00a1\u00a2\7k\2\2\u00a2\u00a7\5\34\17\2\u00a3\u00a4"+
		"\7d\2\2\u00a4\u00a6\5\34\17\2\u00a5\u00a3\3\2\2\2\u00a6\u00a9\3\2\2\2"+
		"\u00a7\u00a5\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00aa\3\2\2\2\u00a9\u00a7"+
		"\3\2\2\2\u00aa\u00ab\7l\2\2\u00ab\u00ad\3\2\2\2\u00ac\u00a0\3\2\2\2\u00ac"+
		"\u00a1\3\2\2\2\u00ad\37\3\2\2\2\u00ae\u00af\7\b\2\2\u00af\u00b0\7^\2\2"+
		"\u00b0\u00b1\7\t\2\2\u00b1\u00b2\5\36\20\2\u00b2\u00b3\7f\2\2\u00b3!\3"+
		"\2\2\2\27#&.9>CIOV`enty\u0080\u0087\u0092\u0096\u009d\u00a7\u00ac";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}