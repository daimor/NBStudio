// Generated from /mnt/disk3/NetBeansProjects/NBStudio/NBStudioCore/src/org/nbstudio/syntax/clsLexer.g4 by ANTLR 4.1

    package org.nbstudio.syntax; 

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class clsLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		Include=1;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"Include"
	};
	public static final String[] ruleNames = {
		"Include"
	};


	public clsLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "clsLexer.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2\3\r\b\1\4\2\t\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\2\3\3\3\1\3\2\t\4\2KKkk\4\2PPpp\4\2EEe"+
		"e\4\2NNnn\4\2WWww\4\2FFff\4\2GGgg\f\2\3\3\2\2\2\3\5\3\2\2\2\5\6\t\2\2"+
		"\2\6\7\t\3\2\2\7\b\t\4\2\2\b\t\t\5\2\2\t\n\t\6\2\2\n\13\t\7\2\2\13\f\t"+
		"\b\2\2\f\4\3\2\2\2\3\2";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}