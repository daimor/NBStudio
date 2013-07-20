// Generated from macLexer.g4 by ANTLR 4.0

    package org.nbstudio.mac.editor.lexer; 

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
		SpecialGlobal=7, ID=8, INT=9, FLOAT=10, STRING=11, EOL=12, EQUAL=13, COMMA=14, 
		Dollar=15, Colon=16, DOT=17, PLUS=18, MINUS=19, PERCENT=20, AT=21, SHARP=22, 
		EXCLAMATION=23, QUESTON=24, ASTERISK=25, UNDERSCORE=26, SLASH=27, BACKSLASH=28, 
		Spaces=29, LPClass=30, RPClass=31, LPAREN=32, RPAREN=33, LBRACK=34, RBRACK=35, 
		FUNCTION=36, COMMENT=37, MACROCOMMENT=38, CARET=39, VertBar=40, WS=41, 
		WSNL=42, CondOper=43, Negative=44, ObjectClass=45, ObjectSuper=46, ObjectThis=47, 
		CommandDO=48, CommandGOTO=49, CommandJOB=50, CMD=51, CommandSPACE=52, 
		CommandCOLON=53, CommandEOL=54, CommandLBRACK=55, CommandRBRACK=56, CommandCOMMA=57;
	public static final int COMMAND = 1;
	public static String[] modeNames = {
		"DEFAULT_MODE", "COMMAND"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"ObjectMethod", "ObjectName", "Label", "RoutineName", "GlobalName", "SystemVariable", 
		"SpecialGlobal", "ID", "INT", "FLOAT", "STRING", "EOL", "EQUAL", "COMMA", 
		"'$'", "Colon", "'.'", "'+'", "'-'", "'%'", "'@'", "'#'", "'!'", "'?'", 
		"'*'", "'_'", "'/'", "'\\'", "Spaces", "LPClass", "RPClass", "LPAREN", 
		"RPAREN", "LBRACK", "RBRACK", "FUNCTION", "COMMENT", "MACROCOMMENT", "'^'", 
		"'|'", "WS", "WSNL", "CondOper", "'''", "'##class'", "'##super'", "'##this'", 
		"CommandDO", "CommandGOTO", "CommandJOB", "CMD", "CommandSPACE", "CommandCOLON", 
		"CommandEOL", "CommandLBRACK", "CommandRBRACK", "CommandCOMMA"
	};
	public static final String[] ruleNames = {
		"ObjectMethod", "ObjectName", "Label", "RoutineName", "GlobalName", "SystemVariable", 
		"SpecialGlobal", "ID", "INT", "FLOAT", "STRING", "EXPONENT", "EOL", "EQUAL", 
		"COMMA", "Dollar", "Colon", "DOT", "PLUS", "MINUS", "PERCENT", "AT", "SHARP", 
		"EXCLAMATION", "QUESTON", "ASTERISK", "UNDERSCORE", "SLASH", "BACKSLASH", 
		"Spaces", "LPClass", "RPClass", "LPAREN", "RPAREN", "LBRACK", "RBRACK", 
		"FUNCTION", "COMMENT", "MACROCOMMENT", "CARET", "VertBar", "WS", "WSNL", 
		"CondOper", "Negative", "ObjectClass", "ObjectSuper", "ObjectThis", "CommandDO", 
		"CommandGOTO", "CommandJOB", "CMD", "CommandSPACE", "CommandCOLON", "CommandEOL", 
		"CommandLBRACK", "CommandRBRACK", "CommandCOMMA"
	};


	    int nesting = 0;
	    boolean isCommand = false;
	    boolean isClass = false;
	    boolean isClassMethod = false;
	    boolean doArg = false;
	    boolean caret = false;
	    boolean labelDef = false;
	    int lastTokenType = 0;
	    void isCMD() {
	        isCommand=true;
	        setType(CMD);
	    }
	public void emit(Token token) {
	    super.emit(token);
	    lastTokenType = token.getType();
	//    if(lastTokenType>=0&&lastTokenType!=EOL)System.out.printf("%20s - %20s (%d)\n",token.getText(),tokenNames[lastTokenType],lastTokenType);
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

		case 1: ObjectName_action((RuleContext)_localctx, actionIndex); break;

		case 2: Label_action((RuleContext)_localctx, actionIndex); break;

		case 3: RoutineName_action((RuleContext)_localctx, actionIndex); break;

		case 4: GlobalName_action((RuleContext)_localctx, actionIndex); break;

		case 12: EOL_action((RuleContext)_localctx, actionIndex); break;

		case 29: Spaces_action((RuleContext)_localctx, actionIndex); break;

		case 30: LPClass_action((RuleContext)_localctx, actionIndex); break;

		case 31: RPClass_action((RuleContext)_localctx, actionIndex); break;

		case 32: LPAREN_action((RuleContext)_localctx, actionIndex); break;

		case 33: RPAREN_action((RuleContext)_localctx, actionIndex); break;

		case 34: LBRACK_action((RuleContext)_localctx, actionIndex); break;

		case 35: RBRACK_action((RuleContext)_localctx, actionIndex); break;

		case 39: CARET_action((RuleContext)_localctx, actionIndex); break;

		case 45: ObjectClass_action((RuleContext)_localctx, actionIndex); break;

		case 48: CommandDO_action((RuleContext)_localctx, actionIndex); break;

		case 49: CommandGOTO_action((RuleContext)_localctx, actionIndex); break;

		case 50: CommandJOB_action((RuleContext)_localctx, actionIndex); break;

		case 51: CMD_action((RuleContext)_localctx, actionIndex); break;

		case 52: CommandSPACE_action((RuleContext)_localctx, actionIndex); break;

		case 53: CommandCOLON_action((RuleContext)_localctx, actionIndex); break;

		case 54: CommandEOL_action((RuleContext)_localctx, actionIndex); break;

		case 56: CommandRBRACK_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void RBRACK_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 8: isCommand=false; break;
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
	private void GlobalName_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		}
	}
	private void EOL_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2: isCommand=false; break;
		}
	}
	private void LBRACK_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 18: pushMode(COMMAND);  break;
		}
	}
	private void RPClass_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 5: nesting--;isClassMethod=true;isClass=false; break;
		}
	}
	private void CommandCOLON_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 19: popMode();  break;
		}
	}
	private void CommandJOB_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 13: doArg = true;isCMD(); break;
		}
	}
	private void LPClass_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 4: nesting++; break;
		}
	}
	private void Spaces_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 3: 
		             if (nesting==0){
		                if (isCommand){isCommand=false;setType(CommandSPACE);} 
		                else {pushMode(COMMAND);}
		             }
		             break;
		}
	}
	private void CommandDO_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 11: doArg = true;isCMD(); break;
		}
	}
	private void CARET_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 9: caret=true; break;
		}
	}
	private void RoutineName_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		}
	}
	private void CMD_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 14: doArg=false;isCMD(); break;
		}
	}
	private void CommandEOL_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 16: popMode();isCommand=false; break;
		}
	}
	private void CommandGOTO_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 12: doArg = true;isCMD(); break;
		}
	}
	private void CommandSPACE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 15: popMode();isCommand=false; break;
		}
	}
	private void ObjectClass_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 10: isClass=true; break;
		}
	}
	private void Label_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1:  labelDef = (getCharPositionInLine()==0); break;
		}
	}
	private void CommandRBRACK_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 17: popMode();isCommand=false; break;
		}
	}
	private void ObjectName_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		}
	}
	private void LPAREN_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 6: nesting++; break;
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

		case 30: return LPClass_sempred((RuleContext)_localctx, predIndex);

		case 31: return RPClass_sempred((RuleContext)_localctx, predIndex);

		case 34: return LBRACK_sempred((RuleContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean GlobalName_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4: return (lastTokenType==CARET);
		}
		return true;
	}
	private boolean ObjectMethod_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return isClassMethod;
		}
		return true;
	}
	private boolean LBRACK_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 7: return nesting==0;
		}
		return true;
	}
	private boolean RPClass_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6: return isClass;
		}
		return true;
	}
	private boolean LPClass_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5: return isClass;
		}
		return true;
	}
	private boolean Label_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2: return ((getCharPositionInLine()==0)||(doArg&&(lastTokenType==CommandSPACE)));
		}
		return true;
	}
	private boolean ObjectName_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1: return nesting>0&&isClass;
		}
		return true;
	}
	private boolean RoutineName_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3: return doArg&&(lastTokenType==CARET);
		}
		return true;
	}

	public static final String _serializedATN =
		"\2\4;\u0206\b\1\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4"+
		"\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4"+
		"\20\t\20\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4"+
		"\27\t\27\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4"+
		"\36\t\36\4\37\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'"+
		"\4(\t(\4)\t)\4*\t*\4+\t+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4"+
		"\62\t\62\4\63\t\63\4\64\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t"+
		"9\4:\t:\4;\t;\3\2\3\2\3\2\3\2\3\3\3\3\5\3\177\n\3\3\3\3\3\3\3\7\3\u0084"+
		"\n\3\f\3\16\3\u0087\13\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3"+
		"\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\7\t\u009c\n\t\f\t\16\t\u009f\13\t\3\n\6"+
		"\n\u00a2\n\n\r\n\16\n\u00a3\3\13\3\13\3\13\5\13\u00a9\n\13\3\13\5\13\u00ac"+
		"\n\13\3\13\3\13\3\13\5\13\u00b1\n\13\3\13\6\13\u00b4\n\13\r\13\16\13\u00b5"+
		"\3\13\3\13\5\13\u00ba\n\13\3\f\3\f\7\f\u00be\n\f\f\f\16\f\u00c1\13\f\3"+
		"\f\3\f\3\r\3\r\5\r\u00c7\n\r\3\r\6\r\u00ca\n\r\r\r\16\r\u00cb\3\16\6\16"+
		"\u00cf\n\16\r\16\16\16\u00d0\3\16\3\16\3\17\7\17\u00d6\n\17\f\17\16\17"+
		"\u00d9\13\17\3\17\3\17\7\17\u00dd\n\17\f\17\16\17\u00e0\13\17\3\20\7\20"+
		"\u00e3\n\20\f\20\16\20\u00e6\13\20\3\20\3\20\7\20\u00ea\n\20\f\20\16\20"+
		"\u00ed\13\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3"+
		"\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3"+
		"\35\3\36\3\36\3\37\6\37\u010c\n\37\r\37\16\37\u010d\3\37\3\37\3 \3 \3"+
		" \3 \3!\3!\3!\3!\3!\3!\3\"\3\"\7\"\u011e\n\"\f\"\16\"\u0121\13\"\3\"\3"+
		"\"\3#\7#\u0126\n#\f#\16#\u0129\13#\3#\3#\7#\u012d\n#\f#\16#\u0130\13#"+
		"\3#\3#\3$\3$\7$\u0136\n$\f$\16$\u0139\13$\3$\3$\3$\3$\3%\7%\u0140\n%\f"+
		"%\16%\u0143\13%\3%\3%\3%\3&\3&\3&\7&\u014b\n&\f&\16&\u014e\13&\3\'\6\'"+
		"\u0151\n\'\r\'\16\'\u0152\3\'\3\'\3\'\6\'\u0158\n\'\r\'\16\'\u0159\5\'"+
		"\u015c\n\'\3\'\7\'\u015f\n\'\f\'\16\'\u0162\13\'\3\'\6\'\u0165\n\'\r\'"+
		"\16\'\u0166\3(\7(\u016a\n(\f(\16(\u016d\13(\3(\3(\3(\3(\7(\u0173\n(\f"+
		"(\16(\u0176\13(\3(\6(\u0179\n(\r(\16(\u017a\3)\3)\3)\3*\3*\3+\3+\3,\3"+
		",\3-\7-\u0187\n-\f-\16-\u018a\13-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-"+
		"\3-\3-\3-\5-\u019b\n-\3-\7-\u019e\n-\f-\16-\u01a1\13-\3.\3.\3/\3/\3/\3"+
		"/\3/\3/\3/\3/\3/\3/\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\61\3\61"+
		"\3\61\3\61\3\61\3\61\3\61\3\62\3\62\5\62\u01c0\n\62\3\62\3\62\3\63\3\63"+
		"\3\63\3\63\5\63\u01c8\n\63\3\63\3\63\3\64\3\64\3\64\5\64\u01cf\n\64\3"+
		"\64\3\64\3\65\3\65\7\65\u01d5\n\65\f\65\16\65\u01d8\13\65\3\65\3\65\3"+
		"\66\3\66\3\66\3\67\3\67\3\67\3\67\38\68\u01e4\n8\r8\168\u01e5\38\38\3"+
		"9\39\79\u01ec\n9\f9\169\u01ef\139\3:\7:\u01f2\n:\f:\16:\u01f5\13:\3:\3"+
		":\3:\3;\7;\u01fb\n;\f;\16;\u01fe\13;\3;\3;\7;\u0202\n;\f;\16;\u0205\13"+
		";\4\u0160\u0174<\4\3\2\6\4\1\b\5\3\n\6\1\f\7\1\16\b\1\20\t\1\22\n\1\24"+
		"\13\1\26\f\1\30\r\1\32\2\1\34\16\4\36\17\1 \20\1\"\21\1$\22\1&\23\1(\24"+
		"\1*\25\1,\26\1.\27\1\60\30\1\62\31\1\64\32\1\66\33\18\34\1:\35\1<\36\1"+
		">\37\5@ \6B!\7D\"\bF#\tH$\24J%\nL&\1N\'\1P(\1R)\13T*\1V+\1X,\1Z-\1\\."+
		"\1^/\f`\60\1b\61\1d\62\rf\63\16h\64\17j\65\20l\66\21n\67\25p8\22r9\1t"+
		":\23v;\1\4\2\3\"\4C\\c|\5\62;C\\c|\3\62;\3$$\4GGgg\4--//\3\62;\4\f\f\17"+
		"\17\4C\\c|\5\62;C\\c|\4\f\f\17\17\4\f\f\17\17\4\13\13\"\"\5\13\f\17\17"+
		"\"\"\4>>@@\4FFff\4QQqq\4IIii\4QQqq\4VVvv\4QQqq\4LLll\4QQqq\4DDdd\4C\\"+
		"c|\5\62;C\\c|\3\"\"\4\f\f\17\17\5\13\f\17\17\"\"\5\13\f\17\17\"\"\4\13"+
		"\13\"\"\4\13\13\"\"\u0236\2\4\3\2\2\2\2\6\3\2\2\2\2\b\3\2\2\2\2\n\3\2"+
		"\2\2\2\f\3\2\2\2\2\16\3\2\2\2\2\20\3\2\2\2\2\22\3\2\2\2\2\24\3\2\2\2\2"+
		"\26\3\2\2\2\2\30\3\2\2\2\2\34\3\2\2\2\2\36\3\2\2\2\2 \3\2\2\2\2\"\3\2"+
		"\2\2\2$\3\2\2\2\2&\3\2\2\2\2(\3\2\2\2\2*\3\2\2\2\2,\3\2\2\2\2.\3\2\2\2"+
		"\2\60\3\2\2\2\2\62\3\2\2\2\2\64\3\2\2\2\2\66\3\2\2\2\28\3\2\2\2\2:\3\2"+
		"\2\2\2<\3\2\2\2\2>\3\2\2\2\2@\3\2\2\2\2B\3\2\2\2\2D\3\2\2\2\2F\3\2\2\2"+
		"\2H\3\2\2\2\2J\3\2\2\2\2L\3\2\2\2\2N\3\2\2\2\2P\3\2\2\2\2R\3\2\2\2\2T"+
		"\3\2\2\2\2V\3\2\2\2\2X\3\2\2\2\2Z\3\2\2\2\2\\\3\2\2\2\2^\3\2\2\2\2`\3"+
		"\2\2\2\2b\3\2\2\2\3d\3\2\2\2\3f\3\2\2\2\3h\3\2\2\2\3j\3\2\2\2\3l\3\2\2"+
		"\2\3n\3\2\2\2\3p\3\2\2\2\3r\3\2\2\2\3t\3\2\2\2\3v\3\2\2\2\4x\3\2\2\2\6"+
		"|\3\2\2\2\b\u0088\3\2\2\2\n\u008c\3\2\2\2\f\u008f\3\2\2\2\16\u0092\3\2"+
		"\2\2\20\u0095\3\2\2\2\22\u0099\3\2\2\2\24\u00a1\3\2\2\2\26\u00b9\3\2\2"+
		"\2\30\u00bb\3\2\2\2\32\u00c4\3\2\2\2\34\u00ce\3\2\2\2\36\u00d7\3\2\2\2"+
		" \u00e4\3\2\2\2\"\u00ee\3\2\2\2$\u00f0\3\2\2\2&\u00f2\3\2\2\2(\u00f4\3"+
		"\2\2\2*\u00f6\3\2\2\2,\u00f8\3\2\2\2.\u00fa\3\2\2\2\60\u00fc\3\2\2\2\62"+
		"\u00fe\3\2\2\2\64\u0100\3\2\2\2\66\u0102\3\2\2\28\u0104\3\2\2\2:\u0106"+
		"\3\2\2\2<\u0108\3\2\2\2>\u010b\3\2\2\2@\u0111\3\2\2\2B\u0115\3\2\2\2D"+
		"\u011b\3\2\2\2F\u0127\3\2\2\2H\u0133\3\2\2\2J\u0141\3\2\2\2L\u0147\3\2"+
		"\2\2N\u0150\3\2\2\2P\u016b\3\2\2\2R\u017c\3\2\2\2T\u017f\3\2\2\2V\u0181"+
		"\3\2\2\2X\u0183\3\2\2\2Z\u0188\3\2\2\2\\\u01a2\3\2\2\2^\u01a4\3\2\2\2"+
		"`\u01ae\3\2\2\2b\u01b6\3\2\2\2d\u01bd\3\2\2\2f\u01c3\3\2\2\2h\u01cb\3"+
		"\2\2\2j\u01d2\3\2\2\2l\u01db\3\2\2\2n\u01de\3\2\2\2p\u01e3\3\2\2\2r\u01e9"+
		"\3\2\2\2t\u01f3\3\2\2\2v\u01fc\3\2\2\2xy\6\2\2\2yz\5\22\t\2z{\b\2\2\2"+
		"{\5\3\2\2\2|~\6\3\3\2}\177\7\'\2\2~}\3\2\2\2~\177\3\2\2\2\177\u0080\3"+
		"\2\2\2\u0080\u0085\5\22\t\2\u0081\u0082\7\60\2\2\u0082\u0084\5\22\t\2"+
		"\u0083\u0081\3\2\2\2\u0084\u0087\3\2\2\2\u0085\u0083\3\2\2\2\u0085\u0086"+
		"\3\2\2\2\u0086\7\3\2\2\2\u0087\u0085\3\2\2\2\u0088\u0089\6\4\4\2\u0089"+
		"\u008a\5\22\t\2\u008a\u008b\b\4\3\2\u008b\t\3\2\2\2\u008c\u008d\6\5\5"+
		"\2\u008d\u008e\5\22\t\2\u008e\13\3\2\2\2\u008f\u0090\6\6\6\2\u0090\u0091"+
		"\5\22\t\2\u0091\r\3\2\2\2\u0092\u0093\5\"\21\2\u0093\u0094\5\22\t\2\u0094"+
		"\17\3\2\2\2\u0095\u0096\5R)\2\u0096\u0097\5\"\21\2\u0097\u0098\5\22\t"+
		"\2\u0098\21\3\2\2\2\u0099\u009d\t\2\2\2\u009a\u009c\t\3\2\2\u009b\u009a"+
		"\3\2\2\2\u009c\u009f\3\2\2\2\u009d\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e"+
		"\23\3\2\2\2\u009f\u009d\3\2\2\2\u00a0\u00a2\t\4\2\2\u00a1\u00a0\3\2\2"+
		"\2\u00a2\u00a3\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\25"+
		"\3\2\2\2\u00a5\u00a6\5\24\n\2\u00a6\u00a8\7\60\2\2\u00a7\u00a9\5\24\n"+
		"\2\u00a8\u00a7\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00ab\3\2\2\2\u00aa\u00ac"+
		"\5\32\r\2\u00ab\u00aa\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00ba\3\2\2\2"+
		"\u00ad\u00ae\7\60\2\2\u00ae\u00b0\5\24\n\2\u00af\u00b1\5\32\r\2\u00b0"+
		"\u00af\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00ba\3\2\2\2\u00b2\u00b4\5\24"+
		"\n\2\u00b3\u00b2\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b5"+
		"\u00b6\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b8\5\32\r\2\u00b8\u00ba\3"+
		"\2\2\2\u00b9\u00a5\3\2\2\2\u00b9\u00ad\3\2\2\2\u00b9\u00b3\3\2\2\2\u00ba"+
		"\27\3\2\2\2\u00bb\u00bf\7$\2\2\u00bc\u00be\n\5\2\2\u00bd\u00bc\3\2\2\2"+
		"\u00be\u00c1\3\2\2\2\u00bf\u00bd\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c2"+
		"\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c2\u00c3\7$\2\2\u00c3\31\3\2\2\2\u00c4"+
		"\u00c6\t\6\2\2\u00c5\u00c7\t\7\2\2\u00c6\u00c5\3\2\2\2\u00c6\u00c7\3\2"+
		"\2\2\u00c7\u00c9\3\2\2\2\u00c8\u00ca\t\b\2\2\u00c9\u00c8\3\2\2\2\u00ca"+
		"\u00cb\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc\33\3\2\2"+
		"\2\u00cd\u00cf\t\t\2\2\u00ce\u00cd\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00ce"+
		"\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d3\b\16\4\2"+
		"\u00d3\35\3\2\2\2\u00d4\u00d6\5V+\2\u00d5\u00d4\3\2\2\2\u00d6\u00d9\3"+
		"\2\2\2\u00d7\u00d5\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00da\3\2\2\2\u00d9"+
		"\u00d7\3\2\2\2\u00da\u00de\7?\2\2\u00db\u00dd\5V+\2\u00dc\u00db\3\2\2"+
		"\2\u00dd\u00e0\3\2\2\2\u00de\u00dc\3\2\2\2\u00de\u00df\3\2\2\2\u00df\37"+
		"\3\2\2\2\u00e0\u00de\3\2\2\2\u00e1\u00e3\5V+\2\u00e2\u00e1\3\2\2\2\u00e3"+
		"\u00e6\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00e7\3\2"+
		"\2\2\u00e6\u00e4\3\2\2\2\u00e7\u00eb\7.\2\2\u00e8\u00ea\5V+\2\u00e9\u00e8"+
		"\3\2\2\2\u00ea\u00ed\3\2\2\2\u00eb\u00e9\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec"+
		"!\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ee\u00ef\7&\2\2\u00ef#\3\2\2\2\u00f0"+
		"\u00f1\7<\2\2\u00f1%\3\2\2\2\u00f2\u00f3\7\60\2\2\u00f3\'\3\2\2\2\u00f4"+
		"\u00f5\7-\2\2\u00f5)\3\2\2\2\u00f6\u00f7\7/\2\2\u00f7+\3\2\2\2\u00f8\u00f9"+
		"\7\'\2\2\u00f9-\3\2\2\2\u00fa\u00fb\7B\2\2\u00fb/\3\2\2\2\u00fc\u00fd"+
		"\7%\2\2\u00fd\61\3\2\2\2\u00fe\u00ff\7#\2\2\u00ff\63\3\2\2\2\u0100\u0101"+
		"\7A\2\2\u0101\65\3\2\2\2\u0102\u0103\7,\2\2\u0103\67\3\2\2\2\u0104\u0105"+
		"\7a\2\2\u01059\3\2\2\2\u0106\u0107\7\61\2\2\u0107;\3\2\2\2\u0108\u0109"+
		"\7^\2\2\u0109=\3\2\2\2\u010a\u010c\5V+\2\u010b\u010a\3\2\2\2\u010c\u010d"+
		"\3\2\2\2\u010d\u010b\3\2\2\2\u010d\u010e\3\2\2\2\u010e\u010f\3\2\2\2\u010f"+
		"\u0110\b\37\5\2\u0110?\3\2\2\2\u0111\u0112\6 \7\2\u0112\u0113\7*\2\2\u0113"+
		"\u0114\b \6\2\u0114A\3\2\2\2\u0115\u0116\6!\b\2\u0116\u0117\7+\2\2\u0117"+
		"\u0118\7\60\2\2\u0118\u0119\3\2\2\2\u0119\u011a\b!\7\2\u011aC\3\2\2\2"+
		"\u011b\u011f\7*\2\2\u011c\u011e\5V+\2\u011d\u011c\3\2\2\2\u011e\u0121"+
		"\3\2\2\2\u011f\u011d\3\2\2\2\u011f\u0120\3\2\2\2\u0120\u0122\3\2\2\2\u0121"+
		"\u011f\3\2\2\2\u0122\u0123\b\"\b\2\u0123E\3\2\2\2\u0124\u0126\5V+\2\u0125"+
		"\u0124\3\2\2\2\u0126\u0129\3\2\2\2\u0127\u0125\3\2\2\2\u0127\u0128\3\2"+
		"\2\2\u0128\u012a\3\2\2\2\u0129\u0127\3\2\2\2\u012a\u012e\7+\2\2\u012b"+
		"\u012d\5V+\2\u012c\u012b\3\2\2\2\u012d\u0130\3\2\2\2\u012e\u012c\3\2\2"+
		"\2\u012e\u012f\3\2\2\2\u012f\u0131\3\2\2\2\u0130\u012e\3\2\2\2\u0131\u0132"+
		"\b#\t\2\u0132G\3\2\2\2\u0133\u0137\7}\2\2\u0134\u0136\5X,\2\u0135\u0134"+
		"\3\2\2\2\u0136\u0139\3\2\2\2\u0137\u0135\3\2\2\2\u0137\u0138\3\2\2\2\u0138"+
		"\u013a\3\2\2\2\u0139\u0137\3\2\2\2\u013a\u013b\6$\t\2\u013b\u013c\3\2"+
		"\2\2\u013c\u013d\b$\24\2\u013dI\3\2\2\2\u013e\u0140\5X,\2\u013f\u013e"+
		"\3\2\2\2\u0140\u0143\3\2\2\2\u0141\u013f\3\2\2\2\u0141\u0142\3\2\2\2\u0142"+
		"\u0144\3\2\2\2\u0143\u0141\3\2\2\2\u0144\u0145\7\177\2\2\u0145\u0146\b"+
		"%\n\2\u0146K\3\2\2\2\u0147\u0148\7&\2\2\u0148\u014c\t\n\2\2\u0149\u014b"+
		"\t\13\2\2\u014a\u0149\3\2\2\2\u014b\u014e\3\2\2\2\u014c\u014a\3\2\2\2"+
		"\u014c\u014d\3\2\2\2\u014dM\3\2\2\2\u014e\u014c\3\2\2\2\u014f\u0151\5"+
		"V+\2\u0150\u014f\3\2\2\2\u0151\u0152\3\2\2\2\u0152\u0150\3\2\2\2\u0152"+
		"\u0153\3\2\2\2\u0153\u015b\3\2\2\2\u0154\u015c\7=\2\2\u0155\u0157\7\61"+
		"\2\2\u0156\u0158\7\61\2\2\u0157\u0156\3\2\2\2\u0158\u0159\3\2\2\2\u0159"+
		"\u0157\3\2\2\2\u0159\u015a\3\2\2\2\u015a\u015c\3\2\2\2\u015b\u0154\3\2"+
		"\2\2\u015b\u0155\3\2\2\2\u015c\u0160\3\2\2\2\u015d\u015f\13\2\2\2\u015e"+
		"\u015d\3\2\2\2\u015f\u0162\3\2\2\2\u0160\u0161\3\2\2\2\u0160\u015e\3\2"+
		"\2\2\u0161\u0164\3\2\2\2\u0162\u0160\3\2\2\2\u0163\u0165\t\f\2\2\u0164"+
		"\u0163\3\2\2\2\u0165\u0166\3\2\2\2\u0166\u0164\3\2\2\2\u0166\u0167\3\2"+
		"\2\2\u0167O\3\2\2\2\u0168\u016a\5V+\2\u0169\u0168\3\2\2\2\u016a\u016d"+
		"\3\2\2\2\u016b\u0169\3\2\2\2\u016b\u016c\3\2\2\2\u016c\u016e\3\2\2\2\u016d"+
		"\u016b\3\2\2\2\u016e\u016f\7%\2\2\u016f\u0170\7=\2\2\u0170\u0174\3\2\2"+
		"\2\u0171\u0173\13\2\2\2\u0172\u0171\3\2\2\2\u0173\u0176\3\2\2\2\u0174"+
		"\u0175\3\2\2\2\u0174\u0172\3\2\2\2\u0175\u0178\3\2\2\2\u0176\u0174\3\2"+
		"\2\2\u0177\u0179\t\r\2\2\u0178\u0177\3\2\2\2\u0179\u017a\3\2\2\2\u017a"+
		"\u0178\3\2\2\2\u017a\u017b\3\2\2\2\u017bQ\3\2\2\2\u017c\u017d\7`\2\2\u017d"+
		"\u017e\b)\13\2\u017eS\3\2\2\2\u017f\u0180\7~\2\2\u0180U\3\2\2\2\u0181"+
		"\u0182\t\16\2\2\u0182W\3\2\2\2\u0183\u0184\t\17\2\2\u0184Y\3\2\2\2\u0185"+
		"\u0187\5V+\2\u0186\u0185\3\2\2\2\u0187\u018a\3\2\2\2\u0188\u0186\3\2\2"+
		"\2\u0188\u0189\3\2\2\2\u0189\u019a\3\2\2\2\u018a\u0188\3\2\2\2\u018b\u018c"+
		"\7(\2\2\u018c\u019b\7(\2\2\u018d\u018e\7~\2\2\u018e\u019b\7~\2\2\u018f"+
		"\u0190\7@\2\2\u0190\u019b\7?\2\2\u0191\u0192\7>\2\2\u0192\u019b\7?\2\2"+
		"\u0193\u0194\7)\2\2\u0194\u019b\7?\2\2\u0195\u019b\t\20\2\2\u0196\u0197"+
		"\7)\2\2\u0197\u019b\7>\2\2\u0198\u0199\7)\2\2\u0199\u019b\7@\2\2\u019a"+
		"\u018b\3\2\2\2\u019a\u018d\3\2\2\2\u019a\u018f\3\2\2\2\u019a\u0191\3\2"+
		"\2\2\u019a\u0193\3\2\2\2\u019a\u0195\3\2\2\2\u019a\u0196\3\2\2\2\u019a"+
		"\u0198\3\2\2\2\u019b\u019f\3\2\2\2\u019c\u019e\5V+\2\u019d\u019c\3\2\2"+
		"\2\u019e\u01a1\3\2\2\2\u019f\u019d\3\2\2\2\u019f\u01a0\3\2\2\2\u01a0["+
		"\3\2\2\2\u01a1\u019f\3\2\2\2\u01a2\u01a3\7)\2\2\u01a3]\3\2\2\2\u01a4\u01a5"+
		"\7%\2\2\u01a5\u01a6\7%\2\2\u01a6\u01a7\7e\2\2\u01a7\u01a8\7n\2\2\u01a8"+
		"\u01a9\7c\2\2\u01a9\u01aa\7u\2\2\u01aa\u01ab\7u\2\2\u01ab\u01ac\3\2\2"+
		"\2\u01ac\u01ad\b/\f\2\u01ad_\3\2\2\2\u01ae\u01af\7%\2\2\u01af\u01b0\7"+
		"%\2\2\u01b0\u01b1\7u\2\2\u01b1\u01b2\7w\2\2\u01b2\u01b3\7r\2\2\u01b3\u01b4"+
		"\7g\2\2\u01b4\u01b5\7t\2\2\u01b5a\3\2\2\2\u01b6\u01b7\7%\2\2\u01b7\u01b8"+
		"\7%\2\2\u01b8\u01b9\7v\2\2\u01b9\u01ba\7j\2\2\u01ba\u01bb\7k\2\2\u01bb"+
		"\u01bc\7u\2\2\u01bcc\3\2\2\2\u01bd\u01bf\t\21\2\2\u01be\u01c0\t\22\2\2"+
		"\u01bf\u01be\3\2\2\2\u01bf\u01c0\3\2\2\2\u01c0\u01c1\3\2\2\2\u01c1\u01c2"+
		"\b\62\r\2\u01c2e\3\2\2\2\u01c3\u01c7\t\23\2\2\u01c4\u01c5\t\24\2\2\u01c5"+
		"\u01c6\t\25\2\2\u01c6\u01c8\t\26\2\2\u01c7\u01c4\3\2\2\2\u01c7\u01c8\3"+
		"\2\2\2\u01c8\u01c9\3\2\2\2\u01c9\u01ca\b\63\16\2\u01cag\3\2\2\2\u01cb"+
		"\u01ce\t\27\2\2\u01cc\u01cd\t\30\2\2\u01cd\u01cf\t\31\2\2\u01ce\u01cc"+
		"\3\2\2\2\u01ce\u01cf\3\2\2\2\u01cf\u01d0\3\2\2\2\u01d0\u01d1\b\64\17\2"+
		"\u01d1i\3\2\2\2\u01d2\u01d6\t\32\2\2\u01d3\u01d5\t\33\2\2\u01d4\u01d3"+
		"\3\2\2\2\u01d5\u01d8\3\2\2\2\u01d6\u01d4\3\2\2\2\u01d6\u01d7\3\2\2\2\u01d7"+
		"\u01d9\3\2\2\2\u01d8\u01d6\3\2\2\2\u01d9\u01da\b\65\20\2\u01dak\3\2\2"+
		"\2\u01db\u01dc\t\34\2\2\u01dc\u01dd\b\66\21\2\u01ddm\3\2\2\2\u01de\u01df"+
		"\7<\2\2\u01df\u01e0\3\2\2\2\u01e0\u01e1\b\67\25\2\u01e1o\3\2\2\2\u01e2"+
		"\u01e4\t\35\2\2\u01e3\u01e2\3\2\2\2\u01e4\u01e5\3\2\2\2\u01e5\u01e3\3"+
		"\2\2\2\u01e5\u01e6\3\2\2\2\u01e6\u01e7\3\2\2\2\u01e7\u01e8\b8\22\2\u01e8"+
		"q\3\2\2\2\u01e9\u01ed\7}\2\2\u01ea\u01ec\t\36\2\2\u01eb\u01ea\3\2\2\2"+
		"\u01ec\u01ef\3\2\2\2\u01ed\u01eb\3\2\2\2\u01ed\u01ee\3\2\2\2\u01ees\3"+
		"\2\2\2\u01ef\u01ed\3\2\2\2\u01f0\u01f2\t\37\2\2\u01f1\u01f0\3\2\2\2\u01f2"+
		"\u01f5\3\2\2\2\u01f3\u01f1\3\2\2\2\u01f3\u01f4\3\2\2\2\u01f4\u01f6\3\2"+
		"\2\2\u01f5\u01f3\3\2\2\2\u01f6\u01f7\7\177\2\2\u01f7\u01f8\b:\23\2\u01f8"+
		"u\3\2\2\2\u01f9\u01fb\t \2\2\u01fa\u01f9\3\2\2\2\u01fb\u01fe\3\2\2\2\u01fc"+
		"\u01fa\3\2\2\2\u01fc\u01fd\3\2\2\2\u01fd\u01ff\3\2\2\2\u01fe\u01fc\3\2"+
		"\2\2\u01ff\u0203\7.\2\2\u0200\u0202\t!\2\2\u0201\u0200\3\2\2\2\u0202\u0205"+
		"\3\2\2\2\u0203\u0201\3\2\2\2\u0203\u0204\3\2\2\2\u0204w\3\2\2\2\u0205"+
		"\u0203\3\2\2\2\60\2\3~\u0085\u009d\u00a3\u00a8\u00ab\u00b0\u00b5\u00b9"+
		"\u00bf\u00c6\u00cb\u00d0\u00d7\u00de\u00e4\u00eb\u010d\u011f\u0127\u012e"+
		"\u0137\u0141\u014c\u0152\u0159\u015b\u0160\u0166\u016b\u0174\u017a\u0188"+
		"\u019a\u019f\u01bf\u01c7\u01ce\u01d6\u01e5\u01ed\u01f3\u01fc\u0203";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}