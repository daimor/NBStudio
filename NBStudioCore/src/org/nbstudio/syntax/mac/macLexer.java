// Generated from /home/daimor/Dropbox/myProjects/NBStudio/NBStudioCore/src/org/nbstudio/syntax/mac/macLexer.g4 by ANTLR 4.1

    package org.nbstudio.syntax.mac; 

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class macLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ObjectMethod=1, ObjectName=2, Label=3, RoutineName=4, GlobalName=5, SystemVariable=6, 
		SpecialGlobal=7, MACMethodPrivate=8, MACMethodPublic=9, SQLBlock=10, JSBlock=11, 
		HTMLBlock=12, Property=13, ID=14, INT=15, FLOAT=16, STRING=17, EOL=18, 
		EQUAL=19, COMMA=20, Dollar=21, Colon=22, DOT=23, PLUS=24, MINUS=25, PERCENT=26, 
		AT=27, SHARP=28, EXCLAMATION=29, QUESTON=30, ASTERISK=31, UNDERSCORE=32, 
		SLASH=33, BACKSLASH=34, COMMENT=35, Spaces=36, LPClass=37, RPClass=38, 
		LPAREN=39, RPAREN=40, LBRACE=41, RBRACE=42, LBRACK=43, RBRACK=44, FUNCTION=45, 
		UserFunction=46, Macros=47, CARET=48, VertBar=49, WS=50, WSNL=51, CondOper=52, 
		Negative=53, ObjectClass=54, ObjectSuper=55, ObjectThis=56, Define=57, 
		DefineExpression=58, Include=59, CMDComments=60, CommandDO=61, CommandGOTO=62, 
		CommandJOB=63, CMD=64, CommandSPACE=65, CommandCOLON=66, CommandEOL=67, 
		CommandLBRACE=68, CommandRBRACE=69, CommandCOMMA=70, Special=71, CMDMacros=72;
	public static final int COMMAND = 1;
	public static String[] modeNames = {
		"DEFAULT_MODE", "COMMAND"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"ObjectMethod", "ObjectName", "Label", "RoutineName", "GlobalName", "SystemVariable", 
		"SpecialGlobal", "MACMethodPrivate", "MACMethodPublic", "SQLBlock", "JSBlock", 
		"HTMLBlock", "Property", "ID", "INT", "FLOAT", "STRING", "EOL", "EQUAL", 
		"COMMA", "'$'", "Colon", "'.'", "PLUS", "MINUS", "'%'", "'@'", "'#'", 
		"'!'", "'?'", "'*'", "UNDERSCORE", "'/'", "'\\'", "COMMENT", "Spaces", 
		"LPClass", "RPClass", "LPAREN", "RPAREN", "LBRACE", "RBRACE", "LBRACK", 
		"RBRACK", "FUNCTION", "UserFunction", "Macros", "'^'", "'|'", "WS", "WSNL", 
		"CondOper", "'''", "ObjectClass", "ObjectSuper", "ObjectThis", "Define", 
		"DefineExpression", "Include", "CMDComments", "CommandDO", "CommandGOTO", 
		"CommandJOB", "CMD", "CommandSPACE", "CommandCOLON", "CommandEOL", "CommandLBRACE", 
		"CommandRBRACE", "CommandCOMMA", "'&'", "CMDMacros"
	};
	public static final String[] ruleNames = {
		"ObjectMethod", "ObjectName", "Label", "RoutineName", "GlobalName", "SystemVariable", 
		"SpecialGlobal", "MACMethodPrivate", "MACMethodPublic", "ParenBlock", 
		"ChevronBlock", "SQLBlock", "JSBlock", "HTMLBlock", "Property", "ID", 
		"INT", "FLOAT", "STRING", "EXPONENT", "EOL", "EQUAL", "COMMA", "Dollar", 
		"Colon", "DOT", "PLUS", "MINUS", "PERCENT", "AT", "SHARP", "EXCLAMATION", 
		"QUESTON", "ASTERISK", "UNDERSCORE", "SLASH", "BACKSLASH", "COMMENT", 
		"Spaces", "LPClass", "RPClass", "LPAREN", "RPAREN", "LBRACE", "RBRACE", 
		"LBRACK", "RBRACK", "FUNCTION", "UserFunction", "Macros", "CARET", "VertBar", 
		"WS", "WSNL", "CondOper", "Negative", "ObjectClass", "ObjectSuper", "ObjectThis", 
		"Define", "DefineExpression", "Include", "MethodType", "CMDComments", 
		"CommandDO", "CommandGOTO", "CommandJOB", "CMD", "CommandSPACE", "CommandCOLON", 
		"CommandEOL", "CommandLBRACE", "CommandRBRACE", "CommandCOMMA", "Special", 
		"CMDMacros"
	};


	class lexerState extends Object 
	{
	    int charPositionInLine = -1;
	    int line = -1;
	    
	    int nesting = 0;
	    boolean isCommand = false;
	    boolean isClass = false;
	    boolean isClassMethod = false;
	    boolean doArg = false;
	    boolean caret = false;
	    boolean labelDef = false;
	    int lastTokenType = 0;
	    int mode = DEFAULT_MODE;
	    IntegerStack modeStack;
	    boolean macroline = false;
	    
	}
	public lexerState getLexerState() 
	{
	    lexerState state = new lexerState();
	    
	    state.line = getLine();
	    state.charPositionInLine = getCharPositionInLine();

	    state.nesting = nesting;
	    state.isCommand = isCommand;
	    state.isClass = isClass;
	    state.isClassMethod = isClassMethod;
	    state.doArg = doArg;
	    state.caret = caret;
	    state.labelDef = labelDef;
	    state.lastTokenType = lastTokenType;
	    state.mode = _mode;
	    state.modeStack = new IntegerStack();
	    state.macroline = macroline;
	    for (int i = 0; i < _modeStack.size(); i++) {
	        state.modeStack.push(_modeStack.get(i));
	    }
	    return state;
	}

	public void setLexerState(lexerState state) 
	{ 
	    if(state==null) return;
	    setLine(state.line);
	    setCharPositionInLine(state.charPositionInLine);
	    
	    nesting = state.nesting;
	    isCommand = state.isCommand;
	    isClass = state.isClass = isClass;
	    isClassMethod = state.isClassMethod;
	    doArg = state.doArg;
	    caret = state.caret;
	    labelDef = state.labelDef;
	    lastTokenType = state.lastTokenType;
	    _modeStack.clear();
	    for (int i = 0; i < state.modeStack.size(); i++) {
	        pushMode(state.modeStack.get(i));
	    }
	    mode(state.mode);
	    macroline = state.macroline;
	}

	    int nesting = 0;
	    boolean isCommand = false;
	    boolean isClass = false;
	    boolean isClassMethod = false;
	    boolean doArg = false;
	    boolean caret = false;
	    boolean labelDef = false;
	    int lastTokenType = 0;
	    boolean macroline = false;
	    
	    void isCMD() {
	        isCommand=true;
	        setType(CMD);
	    }
	public void emit(Token token) {
	    super.emit(token);
	    lastTokenType = token.getType();
	}


	public macLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "macLexer.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 0: ObjectMethod_action((RuleContext)_localctx, actionIndex); break;

		case 2: Label_action((RuleContext)_localctx, actionIndex); break;

		case 20: EOL_action((RuleContext)_localctx, actionIndex); break;

		case 38: Spaces_action((RuleContext)_localctx, actionIndex); break;

		case 39: LPClass_action((RuleContext)_localctx, actionIndex); break;

		case 40: RPClass_action((RuleContext)_localctx, actionIndex); break;

		case 41: LPAREN_action((RuleContext)_localctx, actionIndex); break;

		case 42: RPAREN_action((RuleContext)_localctx, actionIndex); break;

		case 43: LBRACE_action((RuleContext)_localctx, actionIndex); break;

		case 44: RBRACE_action((RuleContext)_localctx, actionIndex); break;

		case 46: RBRACK_action((RuleContext)_localctx, actionIndex); break;

		case 50: CARET_action((RuleContext)_localctx, actionIndex); break;

		case 56: ObjectClass_action((RuleContext)_localctx, actionIndex); break;

		case 59: Define_action((RuleContext)_localctx, actionIndex); break;

		case 61: Include_action((RuleContext)_localctx, actionIndex); break;

		case 62: MethodType_action((RuleContext)_localctx, actionIndex); break;

		case 63: CMDComments_action((RuleContext)_localctx, actionIndex); break;

		case 64: CommandDO_action((RuleContext)_localctx, actionIndex); break;

		case 65: CommandGOTO_action((RuleContext)_localctx, actionIndex); break;

		case 66: CommandJOB_action((RuleContext)_localctx, actionIndex); break;

		case 67: CMD_action((RuleContext)_localctx, actionIndex); break;

		case 68: CommandSPACE_action((RuleContext)_localctx, actionIndex); break;

		case 69: CommandCOLON_action((RuleContext)_localctx, actionIndex); break;

		case 70: CommandEOL_action((RuleContext)_localctx, actionIndex); break;

		case 72: CommandRBRACE_action((RuleContext)_localctx, actionIndex); break;

		case 74: Special_action((RuleContext)_localctx, actionIndex); break;

		case 75: CMDMacros_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void RBRACK_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 9: isCommand=false; break;
		}
	}
	private void Special_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 23: popMode();more(); break;
		}
	}
	private void CommandRBRACE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 22: popMode();isCommand=false; break;
		}
	}
	private void RBRACE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 8: isCommand=false; break;
		}
	}
	private void CommandJOB_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 18: doArg = true;isCMD(); break;
		}
	}
	private void CommandDO_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 16: doArg = true;isCMD(); break;
		}
	}
	private void LBRACE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 25: pushMode(COMMAND);  break;
		}
	}
	private void CMDComments_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 15: popMode();more(); break;
		}
	}
	private void CMD_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 19: doArg=false;isCMD();labelDef=false; break;
		}
	}
	private void CommandGOTO_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 17: doArg = true;isCMD(); break;
		}
	}
	private void MethodType_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 14: 
		   String str = getText().toLowerCase(); 
		   if(str.equals("public")){popMode();setType(MACMethodPublic);}
		   if(str.equals("private")){popMode();setType(MACMethodPrivate);}
		    break;
		}
	}
	private void CommandSPACE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 20: popMode();isCommand=false; break;
		}
	}
	private void Define_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 12: macroline = true; break;
		}
	}
	private void Include_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 13: macroline = true; break;
		}
	}
	private void LPAREN_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 6: nesting++; break;
		}
	}
	private void RPAREN_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 7: nesting--; break;
		}
	}
	private void ObjectMethod_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: isClass=false;isClassMethod=false; break;
		}
	}
	private void CMDMacros_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 24: popMode(); break;
		}
	}
	private void EOL_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2: isCommand=false;macroline=false; break;
		}
	}
	private void RPClass_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 5: nesting--;isClassMethod=true;isClass=false; break;
		}
	}
	private void LPClass_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 4: nesting++; break;
		}
	}
	private void CommandCOLON_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 26: popMode();  break;
		}
	}
	private void Spaces_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 3: 
		             if (nesting==0&&!macroline){
		                if (isCommand){isCommand=false;setType(CommandSPACE);} 
		                else {pushMode(COMMAND);}
		             }
		             break;
		}
	}
	private void CARET_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 10: caret=true; break;
		}
	}
	private void CommandEOL_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 21: popMode();isCommand=false; break;
		}
	}
	private void ObjectClass_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 11: isClass=true; break;
		}
	}
	private void Label_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1:  labelDef = (!doArg); break;
		}
	}
	@Override
	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 0: return ObjectMethod_sempred((RuleContext)_localctx, predIndex);

		case 1: return ObjectName_sempred((RuleContext)_localctx, predIndex);

		case 2: return Label_sempred((RuleContext)_localctx, predIndex);

		case 3: return RoutineName_sempred((RuleContext)_localctx, predIndex);

		case 4: return GlobalName_sempred((RuleContext)_localctx, predIndex);

		case 7: return MACMethodPrivate_sempred((RuleContext)_localctx, predIndex);

		case 8: return MACMethodPublic_sempred((RuleContext)_localctx, predIndex);

		case 37: return COMMENT_sempred((RuleContext)_localctx, predIndex);

		case 39: return LPClass_sempred((RuleContext)_localctx, predIndex);

		case 40: return RPClass_sempred((RuleContext)_localctx, predIndex);

		case 43: return LBRACE_sempred((RuleContext)_localctx, predIndex);

		case 59: return Define_sempred((RuleContext)_localctx, predIndex);

		case 61: return Include_sempred((RuleContext)_localctx, predIndex);

		case 62: return MethodType_sempred((RuleContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean ObjectMethod_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return isClassMethod;
		}
		return true;
	}
	private boolean GlobalName_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4: return (lastTokenType==CARET);
		}
		return true;
	}
	private boolean MACMethodPrivate_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5: return labelDef;
		}
		return true;
	}
	private boolean RPClass_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 9: return isClass;
		}
		return true;
	}
	private boolean LPClass_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 8: return isClass;
		}
		return true;
	}
	private boolean LBRACE_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 10: return nesting==0&&!macroline;
		}
		return true;
	}
	private boolean RoutineName_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3: return doArg&&(lastTokenType==CARET);
		}
		return true;
	}
	private boolean MACMethodPublic_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6: return labelDef;
		}
		return true;
	}
	private boolean MethodType_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 13: return labelDef;
		}
		return true;
	}
	private boolean COMMENT_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 7: return (getCharPositionInLine()==0);
		}
		return true;
	}
	private boolean Label_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2: return ((getCharPositionInLine()==0)||(doArg&&(lastTokenType==CommandSPACE)));
		}
		return true;
	}
	private boolean Define_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 11: return (getCharPositionInLine()==0);
		}
		return true;
	}
	private boolean Include_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 12: return (getCharPositionInLine()==0);
		}
		return true;
	}
	private boolean ObjectName_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1: return nesting>0&&isClass;
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2J\u0325\b\1\b\1\4"+
		"\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n"+
		"\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t"+
		"=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4"+
		"I\tI\4J\tJ\4K\tK\4L\tL\4M\tM\3\2\3\2\3\2\3\2\3\3\3\3\5\3\u00a3\n\3\3\3"+
		"\3\3\3\3\7\3\u00a8\n\3\f\3\16\3\u00ab\13\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5"+
		"\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\7\13\u00d2\n\13"+
		"\f\13\16\13\u00d5\13\13\3\13\5\13\u00d8\n\13\3\f\3\f\3\f\7\f\u00dd\n\f"+
		"\f\f\16\f\u00e0\13\f\3\f\5\f\u00e3\n\f\3\r\7\r\u00e6\n\r\f\r\16\r\u00e9"+
		"\13\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\7\16\u00f2\n\16\f\16\16\16\u00f5\13"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\17\7\17\u00fd\n\17\f\17\16\17\u0100\13"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\21\3"+
		"\21\7\21\u0110\n\21\f\21\16\21\u0113\13\21\3\22\6\22\u0116\n\22\r\22\16"+
		"\22\u0117\3\23\3\23\3\23\5\23\u011d\n\23\3\23\5\23\u0120\n\23\3\23\3\23"+
		"\3\23\5\23\u0125\n\23\3\23\6\23\u0128\n\23\r\23\16\23\u0129\3\23\3\23"+
		"\5\23\u012e\n\23\3\24\3\24\7\24\u0132\n\24\f\24\16\24\u0135\13\24\3\24"+
		"\3\24\3\25\3\25\5\25\u013b\n\25\3\25\6\25\u013e\n\25\r\25\16\25\u013f"+
		"\3\26\6\26\u0143\n\26\r\26\16\26\u0144\3\26\3\26\3\27\7\27\u014a\n\27"+
		"\f\27\16\27\u014d\13\27\3\27\3\27\7\27\u0151\n\27\f\27\16\27\u0154\13"+
		"\27\3\30\7\30\u0157\n\30\f\30\16\30\u015a\13\30\3\30\3\30\7\30\u015e\n"+
		"\30\f\30\16\30\u0161\13\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\7\34\u016a"+
		"\n\34\f\34\16\34\u016d\13\34\3\34\3\34\7\34\u0171\n\34\f\34\16\34\u0174"+
		"\13\34\3\35\7\35\u0177\n\35\f\35\16\35\u017a\13\35\3\35\3\35\7\35\u017e"+
		"\n\35\f\35\16\35\u0181\13\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3"+
		"#\3#\3$\7$\u0190\n$\f$\16$\u0193\13$\3$\3$\7$\u0197\n$\f$\16$\u019a\13"+
		"$\3%\3%\3&\3&\3\'\6\'\u01a1\n\'\r\'\16\'\u01a2\3\'\3\'\3\'\3\'\7\'\u01a9"+
		"\n\'\f\'\16\'\u01ac\13\'\3\'\3\'\3\'\3\'\7\'\u01b2\n\'\f\'\16\'\u01b5"+
		"\13\'\3\'\5\'\u01b8\n\'\3\'\6\'\u01bb\n\'\r\'\16\'\u01bc\3\'\3\'\3\'\5"+
		"\'\u01c2\n\'\3\'\7\'\u01c5\n\'\f\'\16\'\u01c8\13\'\3\'\6\'\u01cb\n\'\r"+
		"\'\16\'\u01cc\3\'\5\'\u01d0\n\'\3\'\3\'\7\'\u01d4\n\'\f\'\16\'\u01d7\13"+
		"\'\3\'\3\'\3\'\3\'\3\'\7\'\u01de\n\'\f\'\16\'\u01e1\13\'\3\'\5\'\u01e4"+
		"\n\'\3\'\5\'\u01e7\n\'\3(\6(\u01ea\n(\r(\16(\u01eb\3(\3(\3)\3)\3)\3)\3"+
		"*\3*\3*\3*\3*\3*\3+\3+\7+\u01fc\n+\f+\16+\u01ff\13+\3+\3+\3,\7,\u0204"+
		"\n,\f,\16,\u0207\13,\3,\3,\3,\3-\3-\7-\u020e\n-\f-\16-\u0211\13-\3-\3"+
		"-\3-\3-\3.\7.\u0218\n.\f.\16.\u021b\13.\3.\3.\3.\3/\7/\u0221\n/\f/\16"+
		"/\u0224\13/\3/\3/\3\60\3\60\7\60\u022a\n\60\f\60\16\60\u022d\13\60\3\60"+
		"\3\60\3\61\3\61\3\61\7\61\u0234\n\61\f\61\16\61\u0237\13\61\3\62\3\62"+
		"\3\62\3\62\3\62\7\62\u023e\n\62\f\62\16\62\u0241\13\62\3\63\3\63\3\63"+
		"\3\63\3\63\3\63\7\63\u0249\n\63\f\63\16\63\u024c\13\63\3\64\3\64\3\64"+
		"\3\65\3\65\3\66\3\66\3\67\3\67\38\78\u0258\n8\f8\168\u025b\138\38\38\3"+
		"8\38\38\38\38\38\38\38\38\38\38\38\38\58\u026c\n8\38\78\u026f\n8\f8\16"+
		"8\u0272\138\39\39\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3;\3;\3;\3;\3;\3;\3;\3"+
		";\3;\3<\3<\3<\3<\3<\3<\3<\3<\3=\3=\7=\u0293\n=\f=\16=\u0296\13=\3=\3="+
		"\3=\3=\3=\3=\3=\3=\3=\3>\3>\7>\u02a3\n>\f>\16>\u02a6\13>\3>\6>\u02a9\n"+
		">\r>\16>\u02aa\3?\3?\7?\u02af\n?\f?\16?\u02b2\13?\3?\3?\3?\3?\3?\3?\3"+
		"?\3?\3?\3?\3@\3@\6@\u02c0\n@\r@\16@\u02c1\3@\3@\3A\3A\3A\5A\u02c9\nA\3"+
		"A\3A\3B\3B\5B\u02cf\nB\3B\3B\3C\3C\3C\3C\5C\u02d7\nC\3C\3C\3D\3D\3D\5"+
		"D\u02de\nD\3D\3D\3E\3E\7E\u02e4\nE\fE\16E\u02e7\13E\3E\3E\3F\3F\3F\3G"+
		"\3G\3G\3G\3H\6H\u02f3\nH\rH\16H\u02f4\3H\3H\3I\3I\7I\u02fb\nI\fI\16I\u02fe"+
		"\13I\3J\7J\u0301\nJ\fJ\16J\u0304\13J\3J\3J\3J\3K\7K\u030a\nK\fK\16K\u030d"+
		"\13K\3K\3K\7K\u0311\nK\fK\16K\u0314\13K\3L\3L\3L\3M\3M\3M\3M\3M\3M\7M"+
		"\u031f\nM\fM\16M\u0322\13M\3M\3M\4\u01aa\u02a4N\4\3\2\6\4\1\b\5\3\n\6"+
		"\1\f\7\1\16\b\1\20\t\1\22\n\1\24\13\1\26\2\1\30\2\1\32\f\1\34\r\1\36\16"+
		"\1 \17\1\"\20\1$\21\1&\22\1(\23\1*\2\1,\24\4.\25\1\60\26\1\62\27\1\64"+
		"\30\1\66\31\18\32\1:\33\1<\34\1>\35\1@\36\1B\37\1D \1F!\1H\"\1J#\1L$\1"+
		"N%\1P&\5R\'\6T(\7V)\bX*\tZ+\33\\,\n^-\1`.\13b/\1d\60\1f\61\1h\62\fj\63"+
		"\1l\64\1n\65\1p\66\1r\67\1t8\rv9\1x:\1z;\16|<\1~=\17\u0080\2\20\u0082"+
		">\21\u0084?\22\u0086@\23\u0088A\24\u008aB\25\u008cC\26\u008eD\34\u0090"+
		"E\27\u0092F\1\u0094G\30\u0096H\1\u0098I\31\u009aJ\32\4\2\3%\4\2RRrr\4"+
		"\2TTtt\4\2KKkk\4\2XXxx\4\2CCcc\4\2VVvv\4\2GGgg\4\2WWww\4\2DDdd\4\2NNn"+
		"n\4\2EEee\3\2*+\3\3++\4\2>>@@\3\3@@\4\2UUuu\4\2SSss\4\2LLll\4\2JJjj\4"+
		"\2OOoo\4\2C\\c|\5\2\62;C\\c|\3\2\62;\3\2$$\4\2--//\4\2\f\f\17\17\6\2\f"+
		"\f\17\17\61\61^^\4\2\13\13\"\"\5\2\13\f\17\17\"\"\4\2FFff\4\2HHhh\4\2"+
		"PPpp\4\2QQqq\4\2IIii\3\2\"\"\u036f\2\4\3\2\2\2\2\6\3\2\2\2\2\b\3\2\2\2"+
		"\2\n\3\2\2\2\2\f\3\2\2\2\2\16\3\2\2\2\2\20\3\2\2\2\2\22\3\2\2\2\2\24\3"+
		"\2\2\2\2\32\3\2\2\2\2\34\3\2\2\2\2\36\3\2\2\2\2 \3\2\2\2\2\"\3\2\2\2\2"+
		"$\3\2\2\2\2&\3\2\2\2\2(\3\2\2\2\2,\3\2\2\2\2.\3\2\2\2\2\60\3\2\2\2\2\62"+
		"\3\2\2\2\2\64\3\2\2\2\2\66\3\2\2\2\28\3\2\2\2\2:\3\2\2\2\2<\3\2\2\2\2"+
		">\3\2\2\2\2@\3\2\2\2\2B\3\2\2\2\2D\3\2\2\2\2F\3\2\2\2\2H\3\2\2\2\2J\3"+
		"\2\2\2\2L\3\2\2\2\2N\3\2\2\2\2P\3\2\2\2\2R\3\2\2\2\2T\3\2\2\2\2V\3\2\2"+
		"\2\2X\3\2\2\2\2Z\3\2\2\2\2\\\3\2\2\2\2^\3\2\2\2\2`\3\2\2\2\2b\3\2\2\2"+
		"\2d\3\2\2\2\2f\3\2\2\2\2h\3\2\2\2\2j\3\2\2\2\2l\3\2\2\2\2n\3\2\2\2\2p"+
		"\3\2\2\2\2r\3\2\2\2\2t\3\2\2\2\2v\3\2\2\2\2x\3\2\2\2\2z\3\2\2\2\2|\3\2"+
		"\2\2\2~\3\2\2\2\3\u0082\3\2\2\2\3\u0084\3\2\2\2\3\u0086\3\2\2\2\3\u0088"+
		"\3\2\2\2\3\u008a\3\2\2\2\3\u008c\3\2\2\2\3\u008e\3\2\2\2\3\u0090\3\2\2"+
		"\2\3\u0092\3\2\2\2\3\u0094\3\2\2\2\3\u0096\3\2\2\2\3\u0098\3\2\2\2\3\u009a"+
		"\3\2\2\2\4\u009c\3\2\2\2\6\u00a0\3\2\2\2\b\u00ac\3\2\2\2\n\u00b0\3\2\2"+
		"\2\f\u00b3\3\2\2\2\16\u00b6\3\2\2\2\20\u00b9\3\2\2\2\22\u00bd\3\2\2\2"+
		"\24\u00c6\3\2\2\2\26\u00ce\3\2\2\2\30\u00d9\3\2\2\2\32\u00e7\3\2\2\2\34"+
		"\u00f3\3\2\2\2\36\u00fe\3\2\2\2 \u0108\3\2\2\2\"\u010d\3\2\2\2$\u0115"+
		"\3\2\2\2&\u012d\3\2\2\2(\u012f\3\2\2\2*\u0138\3\2\2\2,\u0142\3\2\2\2."+
		"\u014b\3\2\2\2\60\u0158\3\2\2\2\62\u0162\3\2\2\2\64\u0164\3\2\2\2\66\u0166"+
		"\3\2\2\28\u016b\3\2\2\2:\u0178\3\2\2\2<\u0182\3\2\2\2>\u0184\3\2\2\2@"+
		"\u0186\3\2\2\2B\u0188\3\2\2\2D\u018a\3\2\2\2F\u018c\3\2\2\2H\u0191\3\2"+
		"\2\2J\u019b\3\2\2\2L\u019d\3\2\2\2N\u01e6\3\2\2\2P\u01e9\3\2\2\2R\u01ef"+
		"\3\2\2\2T\u01f3\3\2\2\2V\u01f9\3\2\2\2X\u0205\3\2\2\2Z\u020b\3\2\2\2\\"+
		"\u0219\3\2\2\2^\u0222\3\2\2\2`\u0227\3\2\2\2b\u0230\3\2\2\2d\u0238\3\2"+
		"\2\2f\u0242\3\2\2\2h\u024d\3\2\2\2j\u0250\3\2\2\2l\u0252\3\2\2\2n\u0254"+
		"\3\2\2\2p\u0259\3\2\2\2r\u0273\3\2\2\2t\u0275\3\2\2\2v\u027f\3\2\2\2x"+
		"\u0288\3\2\2\2z\u0290\3\2\2\2|\u02a0\3\2\2\2~\u02ac\3\2\2\2\u0080\u02bd"+
		"\3\2\2\2\u0082\u02c8\3\2\2\2\u0084\u02cc\3\2\2\2\u0086\u02d2\3\2\2\2\u0088"+
		"\u02da\3\2\2\2\u008a\u02e1\3\2\2\2\u008c\u02ea\3\2\2\2\u008e\u02ed\3\2"+
		"\2\2\u0090\u02f2\3\2\2\2\u0092\u02f8\3\2\2\2\u0094\u0302\3\2\2\2\u0096"+
		"\u030b\3\2\2\2\u0098\u0315\3\2\2\2\u009a\u0318\3\2\2\2\u009c\u009d\6\2"+
		"\2\2\u009d\u009e\5\"\21\2\u009e\u009f\b\2\2\2\u009f\5\3\2\2\2\u00a0\u00a2"+
		"\6\3\3\2\u00a1\u00a3\7\'\2\2\u00a2\u00a1\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3"+
		"\u00a4\3\2\2\2\u00a4\u00a9\5\"\21\2\u00a5\u00a6\7\60\2\2\u00a6\u00a8\5"+
		"\"\21\2\u00a7\u00a5\3\2\2\2\u00a8\u00ab\3\2\2\2\u00a9\u00a7\3\2\2\2\u00a9"+
		"\u00aa\3\2\2\2\u00aa\7\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ac\u00ad\6\4\4\2"+
		"\u00ad\u00ae\5\"\21\2\u00ae\u00af\b\4\3\2\u00af\t\3\2\2\2\u00b0\u00b1"+
		"\6\5\5\2\u00b1\u00b2\5\"\21\2\u00b2\13\3\2\2\2\u00b3\u00b4\6\6\6\2\u00b4"+
		"\u00b5\5\"\21\2\u00b5\r\3\2\2\2\u00b6\u00b7\5\62\31\2\u00b7\u00b8\5\""+
		"\21\2\u00b8\17\3\2\2\2\u00b9\u00ba\5h\64\2\u00ba\u00bb\5\62\31\2\u00bb"+
		"\u00bc\5\"\21\2\u00bc\21\3\2\2\2\u00bd\u00be\6\t\7\2\u00be\u00bf\t\2\2"+
		"\2\u00bf\u00c0\t\3\2\2\u00c0\u00c1\t\4\2\2\u00c1\u00c2\t\5\2\2\u00c2\u00c3"+
		"\t\6\2\2\u00c3\u00c4\t\7\2\2\u00c4\u00c5\t\b\2\2\u00c5\23\3\2\2\2\u00c6"+
		"\u00c7\6\n\b\2\u00c7\u00c8\t\2\2\2\u00c8\u00c9\t\t\2\2\u00c9\u00ca\t\n"+
		"\2\2\u00ca\u00cb\t\13\2\2\u00cb\u00cc\t\4\2\2\u00cc\u00cd\t\f\2\2\u00cd"+
		"\25\3\2\2\2\u00ce\u00d3\7*\2\2\u00cf\u00d2\5\26\13\2\u00d0\u00d2\n\r\2"+
		"\2\u00d1\u00cf\3\2\2\2\u00d1\u00d0\3\2\2\2\u00d2\u00d5\3\2\2\2\u00d3\u00d1"+
		"\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00d7\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d6"+
		"\u00d8\t\16\2\2\u00d7\u00d6\3\2\2\2\u00d8\27\3\2\2\2\u00d9\u00de\7>\2"+
		"\2\u00da\u00dd\5\30\f\2\u00db\u00dd\n\17\2\2\u00dc\u00da\3\2\2\2\u00dc"+
		"\u00db\3\2\2\2\u00dd\u00e0\3\2\2\2\u00de\u00dc\3\2\2\2\u00de\u00df\3\2"+
		"\2\2\u00df\u00e2\3\2\2\2\u00e0\u00de\3\2\2\2\u00e1\u00e3\t\20\2\2\u00e2"+
		"\u00e1\3\2\2\2\u00e3\31\3\2\2\2\u00e4\u00e6\5l\66\2\u00e5\u00e4\3\2\2"+
		"\2\u00e6\u00e9\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8\u00ea"+
		"\3\2\2\2\u00e9\u00e7\3\2\2\2\u00ea\u00eb\7(\2\2\u00eb\u00ec\t\21\2\2\u00ec"+
		"\u00ed\t\22\2\2\u00ed\u00ee\t\13\2\2\u00ee\u00ef\5\26\13\2\u00ef\33\3"+
		"\2\2\2\u00f0\u00f2\5l\66\2\u00f1\u00f0\3\2\2\2\u00f2\u00f5\3\2\2\2\u00f3"+
		"\u00f1\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4\u00f6\3\2\2\2\u00f5\u00f3\3\2"+
		"\2\2\u00f6\u00f7\7(\2\2\u00f7\u00f8\t\23\2\2\u00f8\u00f9\t\21\2\2\u00f9"+
		"\u00fa\5\30\f\2\u00fa\35\3\2\2\2\u00fb\u00fd\5l\66\2\u00fc\u00fb\3\2\2"+
		"\2\u00fd\u0100\3\2\2\2\u00fe\u00fc\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff\u0101"+
		"\3\2\2\2\u0100\u00fe\3\2\2\2\u0101\u0102\7(\2\2\u0102\u0103\t\24\2\2\u0103"+
		"\u0104\t\7\2\2\u0104\u0105\t\25\2\2\u0105\u0106\t\13\2\2\u0106\u0107\5"+
		"\30\f\2\u0107\37\3\2\2\2\u0108\u0109\7\60\2\2\u0109\u010a\7\60\2\2\u010a"+
		"\u010b\3\2\2\2\u010b\u010c\5\"\21\2\u010c!\3\2\2\2\u010d\u0111\t\26\2"+
		"\2\u010e\u0110\t\27\2\2\u010f\u010e\3\2\2\2\u0110\u0113\3\2\2\2\u0111"+
		"\u010f\3\2\2\2\u0111\u0112\3\2\2\2\u0112#\3\2\2\2\u0113\u0111\3\2\2\2"+
		"\u0114\u0116\t\30\2\2\u0115\u0114\3\2\2\2\u0116\u0117\3\2\2\2\u0117\u0115"+
		"\3\2\2\2\u0117\u0118\3\2\2\2\u0118%\3\2\2\2\u0119\u011a\5$\22\2\u011a"+
		"\u011c\7\60\2\2\u011b\u011d\5$\22\2\u011c\u011b\3\2\2\2\u011c\u011d\3"+
		"\2\2\2\u011d\u011f\3\2\2\2\u011e\u0120\5*\25\2\u011f\u011e\3\2\2\2\u011f"+
		"\u0120\3\2\2\2\u0120\u012e\3\2\2\2\u0121\u0122\7\60\2\2\u0122\u0124\5"+
		"$\22\2\u0123\u0125\5*\25\2\u0124\u0123\3\2\2\2\u0124\u0125\3\2\2\2\u0125"+
		"\u012e\3\2\2\2\u0126\u0128\5$\22\2\u0127\u0126\3\2\2\2\u0128\u0129\3\2"+
		"\2\2\u0129\u0127\3\2\2\2\u0129\u012a\3\2\2\2\u012a\u012b\3\2\2\2\u012b"+
		"\u012c\5*\25\2\u012c\u012e\3\2\2\2\u012d\u0119\3\2\2\2\u012d\u0121\3\2"+
		"\2\2\u012d\u0127\3\2\2\2\u012e\'\3\2\2\2\u012f\u0133\7$\2\2\u0130\u0132"+
		"\n\31\2\2\u0131\u0130\3\2\2\2\u0132\u0135\3\2\2\2\u0133\u0131\3\2\2\2"+
		"\u0133\u0134\3\2\2\2\u0134\u0136\3\2\2\2\u0135\u0133\3\2\2\2\u0136\u0137"+
		"\7$\2\2\u0137)\3\2\2\2\u0138\u013a\t\b\2\2\u0139\u013b\t\32\2\2\u013a"+
		"\u0139\3\2\2\2\u013a\u013b\3\2\2\2\u013b\u013d\3\2\2\2\u013c\u013e\t\30"+
		"\2\2\u013d\u013c\3\2\2\2\u013e\u013f\3\2\2\2\u013f\u013d\3\2\2\2\u013f"+
		"\u0140\3\2\2\2\u0140+\3\2\2\2\u0141\u0143\t\33\2\2\u0142\u0141\3\2\2\2"+
		"\u0143\u0144\3\2\2\2\u0144\u0142\3\2\2\2\u0144\u0145\3\2\2\2\u0145\u0146"+
		"\3\2\2\2\u0146\u0147\b\26\4\2\u0147-\3\2\2\2\u0148\u014a\5l\66\2\u0149"+
		"\u0148\3\2\2\2\u014a\u014d\3\2\2\2\u014b\u0149\3\2\2\2\u014b\u014c\3\2"+
		"\2\2\u014c\u014e\3\2\2\2\u014d\u014b\3\2\2\2\u014e\u0152\7?\2\2\u014f"+
		"\u0151\5l\66\2\u0150\u014f\3\2\2\2\u0151\u0154\3\2\2\2\u0152\u0150\3\2"+
		"\2\2\u0152\u0153\3\2\2\2\u0153/\3\2\2\2\u0154\u0152\3\2\2\2\u0155\u0157"+
		"\5l\66\2\u0156\u0155\3\2\2\2\u0157\u015a\3\2\2\2\u0158\u0156\3\2\2\2\u0158"+
		"\u0159\3\2\2\2\u0159\u015b\3\2\2\2\u015a\u0158\3\2\2\2\u015b\u015f\7."+
		"\2\2\u015c\u015e\5l\66\2\u015d\u015c\3\2\2\2\u015e\u0161\3\2\2\2\u015f"+
		"\u015d\3\2\2\2\u015f\u0160\3\2\2\2\u0160\61\3\2\2\2\u0161\u015f\3\2\2"+
		"\2\u0162\u0163\7&\2\2\u0163\63\3\2\2\2\u0164\u0165\7<\2\2\u0165\65\3\2"+
		"\2\2\u0166\u0167\7\60\2\2\u0167\67\3\2\2\2\u0168\u016a\5l\66\2\u0169\u0168"+
		"\3\2\2\2\u016a\u016d\3\2\2\2\u016b\u0169\3\2\2\2\u016b\u016c\3\2\2\2\u016c"+
		"\u016e\3\2\2\2\u016d\u016b\3\2\2\2\u016e\u0172\7-\2\2\u016f\u0171\5l\66"+
		"\2\u0170\u016f\3\2\2\2\u0171\u0174\3\2\2\2\u0172\u0170\3\2\2\2\u0172\u0173"+
		"\3\2\2\2\u01739\3\2\2\2\u0174\u0172\3\2\2\2\u0175\u0177\5l\66\2\u0176"+
		"\u0175\3\2\2\2\u0177\u017a\3\2\2\2\u0178\u0176\3\2\2\2\u0178\u0179\3\2"+
		"\2\2\u0179\u017b\3\2\2\2\u017a\u0178\3\2\2\2\u017b\u017f\7/\2\2\u017c"+
		"\u017e\5l\66\2\u017d\u017c\3\2\2\2\u017e\u0181\3\2\2\2\u017f\u017d\3\2"+
		"\2\2\u017f\u0180\3\2\2\2\u0180;\3\2\2\2\u0181\u017f\3\2\2\2\u0182\u0183"+
		"\7\'\2\2\u0183=\3\2\2\2\u0184\u0185\7B\2\2\u0185?\3\2\2\2\u0186\u0187"+
		"\7%\2\2\u0187A\3\2\2\2\u0188\u0189\7#\2\2\u0189C\3\2\2\2\u018a\u018b\7"+
		"A\2\2\u018bE\3\2\2\2\u018c\u018d\7,\2\2\u018dG\3\2\2\2\u018e\u0190\5l"+
		"\66\2\u018f\u018e\3\2\2\2\u0190\u0193\3\2\2\2\u0191\u018f\3\2\2\2\u0191"+
		"\u0192\3\2\2\2\u0192\u0194\3\2\2\2\u0193\u0191\3\2\2\2\u0194\u0198\7a"+
		"\2\2\u0195\u0197\5l\66\2\u0196\u0195\3\2\2\2\u0197\u019a\3\2\2\2\u0198"+
		"\u0196\3\2\2\2\u0198\u0199\3\2\2\2\u0199I\3\2\2\2\u019a\u0198\3\2\2\2"+
		"\u019b\u019c\7\61\2\2\u019cK\3\2\2\2\u019d\u019e\7^\2\2\u019eM\3\2\2\2"+
		"\u019f\u01a1\5l\66\2\u01a0\u019f\3\2\2\2\u01a1\u01a2\3\2\2\2\u01a2\u01a0"+
		"\3\2\2\2\u01a2\u01a3\3\2\2\2\u01a3\u01a4\3\2\2\2\u01a4\u01a5\7\61\2\2"+
		"\u01a5\u01a6\7,\2\2\u01a6\u01aa\3\2\2\2\u01a7\u01a9\13\2\2\2\u01a8\u01a7"+
		"\3\2\2\2\u01a9\u01ac\3\2\2\2\u01aa\u01ab\3\2\2\2\u01aa\u01a8\3\2\2\2\u01ab"+
		"\u01b7\3\2\2\2\u01ac\u01aa\3\2\2\2\u01ad\u01ae\7,\2\2\u01ae\u01af\7\61"+
		"\2\2\u01af\u01b3\3\2\2\2\u01b0\u01b2\5l\66\2\u01b1\u01b0\3\2\2\2\u01b2"+
		"\u01b5\3\2\2\2\u01b3\u01b1\3\2\2\2\u01b3\u01b4\3\2\2\2\u01b4\u01b8\3\2"+
		"\2\2\u01b5\u01b3\3\2\2\2\u01b6\u01b8\7\2\2\3\u01b7\u01ad\3\2\2\2\u01b7"+
		"\u01b6\3\2\2\2\u01b8\u01e7\3\2\2\2\u01b9\u01bb\5l\66\2\u01ba\u01b9\3\2"+
		"\2\2\u01bb\u01bc\3\2\2\2\u01bc\u01ba\3\2\2\2\u01bc\u01bd\3\2\2\2\u01bd"+
		"\u01c1\3\2\2\2\u01be\u01bf\7\61\2\2\u01bf\u01c2\7\61\2\2\u01c0\u01c2\7"+
		"=\2\2\u01c1\u01be\3\2\2\2\u01c1\u01c0\3\2\2\2\u01c2\u01c6\3\2\2\2\u01c3"+
		"\u01c5\n\33\2\2\u01c4\u01c3\3\2\2\2\u01c5\u01c8\3\2\2\2\u01c6\u01c4\3"+
		"\2\2\2\u01c6\u01c7\3\2\2\2\u01c7\u01cf\3\2\2\2\u01c8\u01c6\3\2\2\2\u01c9"+
		"\u01cb\t\33\2\2\u01ca\u01c9\3\2\2\2\u01cb\u01cc\3\2\2\2\u01cc\u01ca\3"+
		"\2\2\2\u01cc\u01cd\3\2\2\2\u01cd\u01d0\3\2\2\2\u01ce\u01d0\7\2\2\3\u01cf"+
		"\u01ca\3\2\2\2\u01cf\u01ce\3\2\2\2\u01d0\u01e7\3\2\2\2\u01d1\u01d5\6\'"+
		"\t\2\u01d2\u01d4\5l\66\2\u01d3\u01d2\3\2\2\2\u01d4\u01d7\3\2\2\2\u01d5"+
		"\u01d3\3\2\2\2\u01d5\u01d6\3\2\2\2\u01d6\u01d8\3\2\2\2\u01d7\u01d5\3\2"+
		"\2\2\u01d8\u01d9\7%\2\2\u01d9\u01da\7=\2\2\u01da\u01db\3\2\2\2\u01db\u01df"+
		"\n\34\2\2\u01dc\u01de\n\33\2\2\u01dd\u01dc\3\2\2\2\u01de\u01e1\3\2\2\2"+
		"\u01df\u01dd\3\2\2\2\u01df\u01e0\3\2\2\2\u01e0\u01e3\3\2\2\2\u01e1\u01df"+
		"\3\2\2\2\u01e2\u01e4\7\17\2\2\u01e3\u01e2\3\2\2\2\u01e3\u01e4\3\2\2\2"+
		"\u01e4\u01e5\3\2\2\2\u01e5\u01e7\7\f\2\2\u01e6\u01a0\3\2\2\2\u01e6\u01ba"+
		"\3\2\2\2\u01e6\u01d1\3\2\2\2\u01e7O\3\2\2\2\u01e8\u01ea\5l\66\2\u01e9"+
		"\u01e8\3\2\2\2\u01ea\u01eb\3\2\2\2\u01eb\u01e9\3\2\2\2\u01eb\u01ec\3\2"+
		"\2\2\u01ec\u01ed\3\2\2\2\u01ed\u01ee\b(\5\2\u01eeQ\3\2\2\2\u01ef\u01f0"+
		"\6)\n\2\u01f0\u01f1\7*\2\2\u01f1\u01f2\b)\6\2\u01f2S\3\2\2\2\u01f3\u01f4"+
		"\6*\13\2\u01f4\u01f5\7+\2\2\u01f5\u01f6\7\60\2\2\u01f6\u01f7\3\2\2\2\u01f7"+
		"\u01f8\b*\7\2\u01f8U\3\2\2\2\u01f9\u01fd\7*\2\2\u01fa\u01fc\5l\66\2\u01fb"+
		"\u01fa\3\2\2\2\u01fc\u01ff\3\2\2\2\u01fd\u01fb\3\2\2\2\u01fd\u01fe\3\2"+
		"\2\2\u01fe\u0200\3\2\2\2\u01ff\u01fd\3\2\2\2\u0200\u0201\b+\b\2\u0201"+
		"W\3\2\2\2\u0202\u0204\5l\66\2\u0203\u0202\3\2\2\2\u0204\u0207\3\2\2\2"+
		"\u0205\u0203\3\2\2\2\u0205\u0206\3\2\2\2\u0206\u0208\3\2\2\2\u0207\u0205"+
		"\3\2\2\2\u0208\u0209\7+\2\2\u0209\u020a\b,\t\2\u020aY\3\2\2\2\u020b\u020f"+
		"\7}\2\2\u020c\u020e\5l\66\2\u020d\u020c\3\2\2\2\u020e\u0211\3\2\2\2\u020f"+
		"\u020d\3\2\2\2\u020f\u0210\3\2\2\2\u0210\u0212\3\2\2\2\u0211\u020f\3\2"+
		"\2\2\u0212\u0213\6-\f\2\u0213\u0214\3\2\2\2\u0214\u0215\b-\33\2\u0215"+
		"[\3\2\2\2\u0216\u0218\5n\67\2\u0217\u0216\3\2\2\2\u0218\u021b\3\2\2\2"+
		"\u0219\u0217\3\2\2\2\u0219\u021a\3\2\2\2\u021a\u021c\3\2\2\2\u021b\u0219"+
		"\3\2\2\2\u021c\u021d\7\177\2\2\u021d\u021e\b.\n\2\u021e]\3\2\2\2\u021f"+
		"\u0221\5n\67\2\u0220\u021f\3\2\2\2\u0221\u0224\3\2\2\2\u0222\u0220\3\2"+
		"\2\2\u0222\u0223\3\2\2\2\u0223\u0225\3\2\2\2\u0224\u0222\3\2\2\2\u0225"+
		"\u0226\7]\2\2\u0226_\3\2\2\2\u0227\u022b\7_\2\2\u0228\u022a\5n\67\2\u0229"+
		"\u0228\3\2\2\2\u022a\u022d\3\2\2\2\u022b\u0229\3\2\2\2\u022b\u022c\3\2"+
		"\2\2\u022c\u022e\3\2\2\2\u022d\u022b\3\2\2\2\u022e\u022f\b\60\13\2\u022f"+
		"a\3\2\2\2\u0230\u0231\7&\2\2\u0231\u0235\t\26\2\2\u0232\u0234\t\27\2\2"+
		"\u0233\u0232\3\2\2\2\u0234\u0237\3\2\2\2\u0235\u0233\3\2\2\2\u0235\u0236"+
		"\3\2\2\2\u0236c\3\2\2\2\u0237\u0235\3\2\2\2\u0238\u0239\7&\2\2\u0239\u023a"+
		"\7&\2\2\u023a\u023b\3\2\2\2\u023b\u023f\t\26\2\2\u023c\u023e\t\27\2\2"+
		"\u023d\u023c\3\2\2\2\u023e\u0241\3\2\2\2\u023f\u023d\3\2\2\2\u023f\u0240"+
		"\3\2\2\2\u0240e\3\2\2\2\u0241\u023f\3\2\2\2\u0242\u0243\7&\2\2\u0243\u0244"+
		"\7&\2\2\u0244\u0245\7&\2\2\u0245\u0246\3\2\2\2\u0246\u024a\t\26\2\2\u0247"+
		"\u0249\t\27\2\2\u0248\u0247\3\2\2\2\u0249\u024c\3\2\2\2\u024a\u0248\3"+
		"\2\2\2\u024a\u024b\3\2\2\2\u024bg\3\2\2\2\u024c\u024a\3\2\2\2\u024d\u024e"+
		"\7`\2\2\u024e\u024f\b\64\f\2\u024fi\3\2\2\2\u0250\u0251\7~\2\2\u0251k"+
		"\3\2\2\2\u0252\u0253\t\35\2\2\u0253m\3\2\2\2\u0254\u0255\t\36\2\2\u0255"+
		"o\3\2\2\2\u0256\u0258\5l\66\2\u0257\u0256\3\2\2\2\u0258\u025b\3\2\2\2"+
		"\u0259\u0257\3\2\2\2\u0259\u025a\3\2\2\2\u025a\u026b\3\2\2\2\u025b\u0259"+
		"\3\2\2\2\u025c\u025d\7(\2\2\u025d\u026c\7(\2\2\u025e\u025f\7~\2\2\u025f"+
		"\u026c\7~\2\2\u0260\u0261\7@\2\2\u0261\u026c\7?\2\2\u0262\u0263\7>\2\2"+
		"\u0263\u026c\7?\2\2\u0264\u0265\7)\2\2\u0265\u026c\7?\2\2\u0266\u026c"+
		"\t\17\2\2\u0267\u0268\7)\2\2\u0268\u026c\7>\2\2\u0269\u026a\7)\2\2\u026a"+
		"\u026c\7@\2\2\u026b\u025c\3\2\2\2\u026b\u025e\3\2\2\2\u026b\u0260\3\2"+
		"\2\2\u026b\u0262\3\2\2\2\u026b\u0264\3\2\2\2\u026b\u0266\3\2\2\2\u026b"+
		"\u0267\3\2\2\2\u026b\u0269\3\2\2\2\u026c\u0270\3\2\2\2\u026d\u026f\5l"+
		"\66\2\u026e\u026d\3\2\2\2\u026f\u0272\3\2\2\2\u0270\u026e\3\2\2\2\u0270"+
		"\u0271\3\2\2\2\u0271q\3\2\2\2\u0272\u0270\3\2\2\2\u0273\u0274\7)\2\2\u0274"+
		"s\3\2\2\2\u0275\u0276\7%\2\2\u0276\u0277\7%\2\2\u0277\u0278\3\2\2\2\u0278"+
		"\u0279\t\f\2\2\u0279\u027a\t\13\2\2\u027a\u027b\t\6\2\2\u027b\u027c\t"+
		"\21\2\2\u027c\u027d\t\21\2\2\u027d\u027e\b:\r\2\u027eu\3\2\2\2\u027f\u0280"+
		"\7%\2\2\u0280\u0281\7%\2\2\u0281\u0282\3\2\2\2\u0282\u0283\t\21\2\2\u0283"+
		"\u0284\t\t\2\2\u0284\u0285\t\2\2\2\u0285\u0286\t\b\2\2\u0286\u0287\t\3"+
		"\2\2\u0287w\3\2\2\2\u0288\u0289\7%\2\2\u0289\u028a\7%\2\2\u028a\u028b"+
		"\3\2\2\2\u028b\u028c\t\7\2\2\u028c\u028d\t\24\2\2\u028d\u028e\t\4\2\2"+
		"\u028e\u028f\t\21\2\2\u028fy\3\2\2\2\u0290\u0294\6=\r\2\u0291\u0293\5"+
		"l\66\2\u0292\u0291\3\2\2\2\u0293\u0296\3\2\2\2\u0294\u0292\3\2\2\2\u0294"+
		"\u0295\3\2\2\2\u0295\u0297\3\2\2\2\u0296\u0294\3\2\2\2\u0297\u0298\7%"+
		"\2\2\u0298\u0299\t\37\2\2\u0299\u029a\t\b\2\2\u029a\u029b\t \2\2\u029b"+
		"\u029c\t\4\2\2\u029c\u029d\t!\2\2\u029d\u029e\t\b\2\2\u029e\u029f\b=\16"+
		"\2\u029f{\3\2\2\2\u02a0\u02a4\5z=\2\u02a1\u02a3\13\2\2\2\u02a2\u02a1\3"+
		"\2\2\2\u02a3\u02a6\3\2\2\2\u02a4\u02a5\3\2\2\2\u02a4\u02a2\3\2\2\2\u02a5"+
		"\u02a8\3\2\2\2\u02a6\u02a4\3\2\2\2\u02a7\u02a9\t\33\2\2\u02a8\u02a7\3"+
		"\2\2\2\u02a9\u02aa\3\2\2\2\u02aa\u02a8\3\2\2\2\u02aa\u02ab\3\2\2\2\u02ab"+
		"}\3\2\2\2\u02ac\u02b0\6?\16\2\u02ad\u02af\5l\66\2\u02ae\u02ad\3\2\2\2"+
		"\u02af\u02b2\3\2\2\2\u02b0\u02ae\3\2\2\2\u02b0\u02b1\3\2\2\2\u02b1\u02b3"+
		"\3\2\2\2\u02b2\u02b0\3\2\2\2\u02b3\u02b4\7%\2\2\u02b4\u02b5\t\4\2\2\u02b5"+
		"\u02b6\t!\2\2\u02b6\u02b7\t\f\2\2\u02b7\u02b8\t\13\2\2\u02b8\u02b9\t\t"+
		"\2\2\u02b9\u02ba\t\37\2\2\u02ba\u02bb\t\b\2\2\u02bb\u02bc\b?\17\2\u02bc"+
		"\177\3\2\2\2\u02bd\u02bf\6@\17\2\u02be\u02c0\t\26\2\2\u02bf\u02be\3\2"+
		"\2\2\u02c0\u02c1\3\2\2\2\u02c1\u02bf\3\2\2\2\u02c1\u02c2\3\2\2\2\u02c2"+
		"\u02c3\3\2\2\2\u02c3\u02c4\b@\20\2\u02c4\u0081\3\2\2\2\u02c5\u02c9\7="+
		"\2\2\u02c6\u02c7\7\61\2\2\u02c7\u02c9\7\61\2\2\u02c8\u02c5\3\2\2\2\u02c8"+
		"\u02c6\3\2\2\2\u02c9\u02ca\3\2\2\2\u02ca\u02cb\bA\21\2\u02cb\u0083\3\2"+
		"\2\2\u02cc\u02ce\t\37\2\2\u02cd\u02cf\t\"\2\2\u02ce\u02cd\3\2\2\2\u02ce"+
		"\u02cf\3\2\2\2\u02cf\u02d0\3\2\2\2\u02d0\u02d1\bB\22\2\u02d1\u0085\3\2"+
		"\2\2\u02d2\u02d6\t#\2\2\u02d3\u02d4\t\"\2\2\u02d4\u02d5\t\7\2\2\u02d5"+
		"\u02d7\t\"\2\2\u02d6\u02d3\3\2\2\2\u02d6\u02d7\3\2\2\2\u02d7\u02d8\3\2"+
		"\2\2\u02d8\u02d9\bC\23\2\u02d9\u0087\3\2\2\2\u02da\u02dd\t\23\2\2\u02db"+
		"\u02dc\t\"\2\2\u02dc\u02de\t\n\2\2\u02dd\u02db\3\2\2\2\u02dd\u02de\3\2"+
		"\2\2\u02de\u02df\3\2\2\2\u02df\u02e0\bD\24\2\u02e0\u0089\3\2\2\2\u02e1"+
		"\u02e5\t\26\2\2\u02e2\u02e4\t\27\2\2\u02e3\u02e2\3\2\2\2\u02e4\u02e7\3"+
		"\2\2\2\u02e5\u02e3\3\2\2\2\u02e5\u02e6\3\2\2\2\u02e6\u02e8\3\2\2\2\u02e7"+
		"\u02e5\3\2\2\2\u02e8\u02e9\bE\25\2\u02e9\u008b\3\2\2\2\u02ea\u02eb\t$"+
		"\2\2\u02eb\u02ec\bF\26\2\u02ec\u008d\3\2\2\2\u02ed\u02ee\7<\2\2\u02ee"+
		"\u02ef\3\2\2\2\u02ef\u02f0\bG\34\2\u02f0\u008f\3\2\2\2\u02f1\u02f3\t\33"+
		"\2\2\u02f2\u02f1\3\2\2\2\u02f3\u02f4\3\2\2\2\u02f4\u02f2\3\2\2\2\u02f4"+
		"\u02f5\3\2\2\2\u02f5\u02f6\3\2\2\2\u02f6\u02f7\bH\27\2\u02f7\u0091\3\2"+
		"\2\2\u02f8\u02fc\7}\2\2\u02f9\u02fb\t\35\2\2\u02fa\u02f9\3\2\2\2\u02fb"+
		"\u02fe\3\2\2\2\u02fc\u02fa\3\2\2\2\u02fc\u02fd\3\2\2\2\u02fd\u0093\3\2"+
		"\2\2\u02fe\u02fc\3\2\2\2\u02ff\u0301\t\36\2\2\u0300\u02ff\3\2\2\2\u0301"+
		"\u0304\3\2\2\2\u0302\u0300\3\2\2\2\u0302\u0303\3\2\2\2\u0303\u0305\3\2"+
		"\2\2\u0304\u0302\3\2\2\2\u0305\u0306\7\177\2\2\u0306\u0307\bJ\30\2\u0307"+
		"\u0095\3\2\2\2\u0308\u030a\t\35\2\2\u0309\u0308\3\2\2\2\u030a\u030d\3"+
		"\2\2\2\u030b\u0309\3\2\2\2\u030b\u030c\3\2\2\2\u030c\u030e\3\2\2\2\u030d"+
		"\u030b\3\2\2\2\u030e\u0312\7.\2\2\u030f\u0311\t\35\2\2\u0310\u030f\3\2"+
		"\2\2\u0311\u0314\3\2\2\2\u0312\u0310\3\2\2\2\u0312\u0313\3\2\2\2\u0313"+
		"\u0097\3\2\2\2\u0314\u0312\3\2\2\2\u0315\u0316\7(\2\2\u0316\u0317\bL\31"+
		"\2\u0317\u0099\3\2\2\2\u0318\u0319\7&\2\2\u0319\u031a\7&\2\2\u031a\u031b"+
		"\7&\2\2\u031b\u031c\3\2\2\2\u031c\u0320\t\26\2\2\u031d\u031f\t\27\2\2"+
		"\u031e\u031d\3\2\2\2\u031f\u0322\3\2\2\2\u0320\u031e\3\2\2\2\u0320\u0321"+
		"\3\2\2\2\u0321\u0323\3\2\2\2\u0322\u0320\3\2\2\2\u0323\u0324\bM\32\2\u0324"+
		"\u009b\3\2\2\2N\2\3\u00a2\u00a9\u00d1\u00d3\u00d7\u00dc\u00de\u00e2\u00e7"+
		"\u00f3\u00fe\u0111\u0117\u011c\u011f\u0124\u0129\u012d\u0133\u013a\u013f"+
		"\u0144\u014b\u0152\u0158\u015f\u016b\u0172\u0178\u017f\u0191\u0198\u01a2"+
		"\u01aa\u01b3\u01b7\u01bc\u01c1\u01c6\u01cc\u01cf\u01d5\u01df\u01e3\u01e6"+
		"\u01eb\u01fd\u0205\u020f\u0219\u0222\u022b\u0235\u023f\u024a\u0259\u026b"+
		"\u0270\u0294\u02a4\u02aa\u02b0\u02c1\u02c8\u02ce\u02d6\u02dd\u02e5\u02f4"+
		"\u02fc\u0302\u030b\u0312\u0320";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}