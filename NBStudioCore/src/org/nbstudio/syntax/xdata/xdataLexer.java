// Generated from /home/daimor/Dropbox/myProjects/NBStudio/NBStudioCore/src/org/nbstudio/syntax/xdata/xdataLexer.g4 by ANTLR 4.1

    package org.nbstudio.syntax.xdata; 

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class xdataLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COMMENT=1, CDATA=2, DTD=3, EntityRef=4, CharRef=5, SEA_WS=6, OPEN=7, XMLDeclOpen=8, 
		TEXT=9, CLOSE=10, SPECIAL_CLOSE=11, SLASH_CLOSE=12, SLASH=13, EQUALS=14, 
		STRING=15, Name=16, S=17, PI=18;
	public static final int INSIDE = 1;
	public static final int PROC_INSTR = 2;
	public static String[] modeNames = {
		"DEFAULT_MODE", "INSIDE", "PROC_INSTR"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"COMMENT", "CDATA", "DTD", "EntityRef", "CharRef", "SEA_WS", "'<'", "XMLDeclOpen", 
		"TEXT", "'>'", "SPECIAL_CLOSE", "'/>'", "'/'", "'='", "STRING", "Name", 
		"S", "PI"
	};
	public static final String[] ruleNames = {
		"COMMENT", "CDATA", "DTD", "EntityRef", "CharRef", "SEA_WS", "OPEN", "XMLDeclOpen", 
		"SPECIAL_OPEN", "TEXT", "CLOSE", "SPECIAL_CLOSE", "SLASH_CLOSE", "SLASH", 
		"EQUALS", "STRING", "Name", "S", "HEXDIGIT", "DIGIT", "NameChar", "NameStartChar", 
		"PI", "IGNORE"
	};


	public xdataLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "xdataLexer.g4"; }

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
		case 2: DTD_action((RuleContext)_localctx, actionIndex); break;

		case 6: OPEN_action((RuleContext)_localctx, actionIndex); break;

		case 7: XMLDeclOpen_action((RuleContext)_localctx, actionIndex); break;

		case 8: SPECIAL_OPEN_action((RuleContext)_localctx, actionIndex); break;

		case 10: CLOSE_action((RuleContext)_localctx, actionIndex); break;

		case 11: SPECIAL_CLOSE_action((RuleContext)_localctx, actionIndex); break;

		case 12: SLASH_CLOSE_action((RuleContext)_localctx, actionIndex); break;

		case 17: S_action((RuleContext)_localctx, actionIndex); break;

		case 22: PI_action((RuleContext)_localctx, actionIndex); break;

		case 23: IGNORE_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void OPEN_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1: pushMode(INSIDE);  break;
		}
	}
	private void PI_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 8: popMode();  break;
		}
	}
	private void S_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 7: skip();  break;
		}
	}
	private void SLASH_CLOSE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 6: popMode();  break;
		}
	}
	private void SPECIAL_CLOSE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 5: popMode();  break;
		}
	}
	private void IGNORE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 9: more();  break;
		}
	}
	private void CLOSE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 4: popMode();  break;
		}
	}
	private void SPECIAL_OPEN_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 3: more(); pushMode(PROC_INSTR);  break;
		}
	}
	private void XMLDeclOpen_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2: pushMode(INSIDE);  break;
		}
	}
	private void DTD_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip();  break;
		}
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2\24\u00e8\b\1\b\1"+
		"\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4"+
		"\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t"+
		"\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t"+
		"\30\4\31\t\31\3\2\3\2\3\2\3\2\3\2\3\2\7\2<\n\2\f\2\16\2?\13\2\3\2\3\2"+
		"\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3P\n\3\f\3\16\3"+
		"S\13\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\7\4]\n\4\f\4\16\4`\13\4\3\4\3\4"+
		"\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\6\6n\n\6\r\6\16\6o\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\6\6y\n\6\r\6\16\6z\3\6\3\6\5\6\177\n\6\3\7\3\7\5\7"+
		"\u0083\n\7\3\7\6\7\u0086\n\7\r\7\16\7\u0087\3\b\3\b\3\b\3\b\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\6\13\u00a0"+
		"\n\13\r\13\16\13\u00a1\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3"+
		"\16\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\7\21\u00b8\n\21\f\21\16\21"+
		"\u00bb\13\21\3\21\3\21\3\21\7\21\u00c0\n\21\f\21\16\21\u00c3\13\21\3\21"+
		"\5\21\u00c6\n\21\3\22\3\22\7\22\u00ca\n\22\f\22\16\22\u00cd\13\22\3\23"+
		"\3\23\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\26\3\26\5\26\u00db\n\26"+
		"\3\27\5\27\u00de\n\27\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\5="+
		"Q^\32\5\3\1\7\4\1\t\5\2\13\6\1\r\7\1\17\b\1\21\t\3\23\n\4\25\2\5\27\13"+
		"\1\31\f\6\33\r\7\35\16\b\37\17\1!\20\1#\21\1%\22\1\'\23\t)\2\1+\2\1-\2"+
		"\1/\2\1\61\24\n\63\2\13\5\2\3\4\f\4\2\13\13\"\"\4\2((>>\4\2$$>>\4\2))"+
		">>\5\2\13\f\17\17\"\"\5\2\62;CHch\3\2\62;\4\2/\60aa\5\2\u00b9\u00b9\u0302"+
		"\u0371\u2041\u2042\n\2<<C\\c|\u2072\u2191\u2c02\u2ff1\u3003\ud801\uf902"+
		"\ufdd1\ufdf2\uffff\u00f2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2"+
		"\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2"+
		"\27\3\2\2\2\3\31\3\2\2\2\3\33\3\2\2\2\3\35\3\2\2\2\3\37\3\2\2\2\3!\3\2"+
		"\2\2\3#\3\2\2\2\3%\3\2\2\2\3\'\3\2\2\2\4\61\3\2\2\2\4\63\3\2\2\2\5\65"+
		"\3\2\2\2\7D\3\2\2\2\tX\3\2\2\2\13e\3\2\2\2\r~\3\2\2\2\17\u0085\3\2\2\2"+
		"\21\u0089\3\2\2\2\23\u008d\3\2\2\2\25\u0097\3\2\2\2\27\u009f\3\2\2\2\31"+
		"\u00a3\3\2\2\2\33\u00a7\3\2\2\2\35\u00ac\3\2\2\2\37\u00b1\3\2\2\2!\u00b3"+
		"\3\2\2\2#\u00c5\3\2\2\2%\u00c7\3\2\2\2\'\u00ce\3\2\2\2)\u00d2\3\2\2\2"+
		"+\u00d4\3\2\2\2-\u00da\3\2\2\2/\u00dd\3\2\2\2\61\u00df\3\2\2\2\63\u00e4"+
		"\3\2\2\2\65\66\7>\2\2\66\67\7#\2\2\678\7/\2\289\7/\2\29=\3\2\2\2:<\13"+
		"\2\2\2;:\3\2\2\2<?\3\2\2\2=>\3\2\2\2=;\3\2\2\2>@\3\2\2\2?=\3\2\2\2@A\7"+
		"/\2\2AB\7/\2\2BC\7@\2\2C\6\3\2\2\2DE\7>\2\2EF\7#\2\2FG\7]\2\2GH\7E\2\2"+
		"HI\7F\2\2IJ\7C\2\2JK\7V\2\2KL\7C\2\2LM\7]\2\2MQ\3\2\2\2NP\13\2\2\2ON\3"+
		"\2\2\2PS\3\2\2\2QR\3\2\2\2QO\3\2\2\2RT\3\2\2\2SQ\3\2\2\2TU\7_\2\2UV\7"+
		"_\2\2VW\7@\2\2W\b\3\2\2\2XY\7>\2\2YZ\7#\2\2Z^\3\2\2\2[]\13\2\2\2\\[\3"+
		"\2\2\2]`\3\2\2\2^_\3\2\2\2^\\\3\2\2\2_a\3\2\2\2`^\3\2\2\2ab\7@\2\2bc\3"+
		"\2\2\2cd\b\4\2\2d\n\3\2\2\2ef\7(\2\2fg\5%\22\2gh\7=\2\2h\f\3\2\2\2ij\7"+
		"(\2\2jk\7%\2\2km\3\2\2\2ln\5+\25\2ml\3\2\2\2no\3\2\2\2om\3\2\2\2op\3\2"+
		"\2\2pq\3\2\2\2qr\7=\2\2r\177\3\2\2\2st\7(\2\2tu\7%\2\2uv\7z\2\2vx\3\2"+
		"\2\2wy\5)\24\2xw\3\2\2\2yz\3\2\2\2zx\3\2\2\2z{\3\2\2\2{|\3\2\2\2|}\7="+
		"\2\2}\177\3\2\2\2~i\3\2\2\2~s\3\2\2\2\177\16\3\2\2\2\u0080\u0086\t\2\2"+
		"\2\u0081\u0083\7\17\2\2\u0082\u0081\3\2\2\2\u0082\u0083\3\2\2\2\u0083"+
		"\u0084\3\2\2\2\u0084\u0086\7\f\2\2\u0085\u0080\3\2\2\2\u0085\u0082\3\2"+
		"\2\2\u0086\u0087\3\2\2\2\u0087\u0085\3\2\2\2\u0087\u0088\3\2\2\2\u0088"+
		"\20\3\2\2\2\u0089\u008a\7>\2\2\u008a\u008b\3\2\2\2\u008b\u008c\b\b\3\2"+
		"\u008c\22\3\2\2\2\u008d\u008e\7>\2\2\u008e\u008f\7A\2\2\u008f\u0090\7"+
		"z\2\2\u0090\u0091\7o\2\2\u0091\u0092\7n\2\2\u0092\u0093\3\2\2\2\u0093"+
		"\u0094\5\'\23\2\u0094\u0095\3\2\2\2\u0095\u0096\b\t\4\2\u0096\24\3\2\2"+
		"\2\u0097\u0098\7>\2\2\u0098\u0099\7A\2\2\u0099\u009a\3\2\2\2\u009a\u009b"+
		"\5%\22\2\u009b\u009c\3\2\2\2\u009c\u009d\b\n\5\2\u009d\26\3\2\2\2\u009e"+
		"\u00a0\n\3\2\2\u009f\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u009f\3\2"+
		"\2\2\u00a1\u00a2\3\2\2\2\u00a2\30\3\2\2\2\u00a3\u00a4\7@\2\2\u00a4\u00a5"+
		"\3\2\2\2\u00a5\u00a6\b\f\6\2\u00a6\32\3\2\2\2\u00a7\u00a8\7A\2\2\u00a8"+
		"\u00a9\7@\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00ab\b\r\7\2\u00ab\34\3\2\2\2"+
		"\u00ac\u00ad\7\61\2\2\u00ad\u00ae\7@\2\2\u00ae\u00af\3\2\2\2\u00af\u00b0"+
		"\b\16\b\2\u00b0\36\3\2\2\2\u00b1\u00b2\7\61\2\2\u00b2 \3\2\2\2\u00b3\u00b4"+
		"\7?\2\2\u00b4\"\3\2\2\2\u00b5\u00b9\7$\2\2\u00b6\u00b8\n\4\2\2\u00b7\u00b6"+
		"\3\2\2\2\u00b8\u00bb\3\2\2\2\u00b9\u00b7\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba"+
		"\u00bc\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bc\u00c6\7$\2\2\u00bd\u00c1\7)\2"+
		"\2\u00be\u00c0\n\5\2\2\u00bf\u00be\3\2\2\2\u00c0\u00c3\3\2\2\2\u00c1\u00bf"+
		"\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c4\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c4"+
		"\u00c6\7)\2\2\u00c5\u00b5\3\2\2\2\u00c5\u00bd\3\2\2\2\u00c6$\3\2\2\2\u00c7"+
		"\u00cb\5/\27\2\u00c8\u00ca\5-\26\2\u00c9\u00c8\3\2\2\2\u00ca\u00cd\3\2"+
		"\2\2\u00cb\u00c9\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc&\3\2\2\2\u00cd\u00cb"+
		"\3\2\2\2\u00ce\u00cf\t\6\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00d1\b\23\t\2"+
		"\u00d1(\3\2\2\2\u00d2\u00d3\t\7\2\2\u00d3*\3\2\2\2\u00d4\u00d5\t\b\2\2"+
		"\u00d5,\3\2\2\2\u00d6\u00db\5/\27\2\u00d7\u00db\t\t\2\2\u00d8\u00db\5"+
		"+\25\2\u00d9\u00db\t\n\2\2\u00da\u00d6\3\2\2\2\u00da\u00d7\3\2\2\2\u00da"+
		"\u00d8\3\2\2\2\u00da\u00d9\3\2\2\2\u00db.\3\2\2\2\u00dc\u00de\t\13\2\2"+
		"\u00dd\u00dc\3\2\2\2\u00de\60\3\2\2\2\u00df\u00e0\7A\2\2\u00e0\u00e1\7"+
		"@\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e3\b\30\n\2\u00e3\62\3\2\2\2\u00e4"+
		"\u00e5\13\2\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00e7\b\31\13\2\u00e7\64\3\2"+
		"\2\2\25\2\3\4=Q^oz~\u0082\u0085\u0087\u00a1\u00b9\u00c1\u00c5\u00cb\u00da"+
		"\u00dd";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}