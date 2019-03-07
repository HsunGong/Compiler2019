// Generated from /home/xun/Documents/mxc/src/main/java/mxcompiler/parser/grammar/Lexis.g4 by ANTLR 4.7.2
package mxcompiler.parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class Lexis extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		Break=1, Continue=2, Default=3, Else=4, For=5, If=6, Int=7, Long=8, Return=9, 
		Class=10, Void=11, While=12, Bool=13, Noreturn=14, LeftParen=15, RightParen=16, 
		LeftBracket=17, RightBracket=18, LeftBrace=19, RightBrace=20, Less=21, 
		LessEqual=22, Greater=23, GreaterEqual=24, LeftShift=25, RightShift=26, 
		Plus=27, PlusPlus=28, Minus=29, MinusMinus=30, Star=31, Div=32, Mod=33, 
		And=34, Or=35, AndAnd=36, OrOr=37, Caret=38, Not=39, Tilde=40, Question=41, 
		Colon=42, Semi=43, Comma=44, Assign=45, Equal=46, NotEqual=47, Arrow=48, 
		Dot=49, Ellipsis=50;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"Break", "Continue", "Default", "Else", "For", "If", "Int", "Long", "Return", 
			"Class", "Void", "While", "Bool", "Noreturn", "LeftParen", "RightParen", 
			"LeftBracket", "RightBracket", "LeftBrace", "RightBrace", "Less", "LessEqual", 
			"Greater", "GreaterEqual", "LeftShift", "RightShift", "Plus", "PlusPlus", 
			"Minus", "MinusMinus", "Star", "Div", "Mod", "And", "Or", "AndAnd", "OrOr", 
			"Caret", "Not", "Tilde", "Question", "Colon", "Semi", "Comma", "Assign", 
			"Equal", "NotEqual", "Arrow", "Dot", "Ellipsis"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'break'", "'continue'", "'default'", "'else'", "'for'", "'if'", 
			"'int'", "'long'", "'return'", "'class'", "'void'", "'while'", "'_Bool'", 
			"'_Noreturn'", "'('", "')'", "'['", "']'", "'{'", "'}'", "'<'", "'<='", 
			"'>'", "'>='", "'<<'", "'>>'", "'+'", "'++'", "'-'", "'--'", "'*'", "'/'", 
			"'%'", "'&'", "'|'", "'&&'", "'||'", "'^'", "'!'", "'~'", "'?'", "':'", 
			"';'", "','", "'='", "'=='", "'!='", "'->'", "'.'", "'...'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "Break", "Continue", "Default", "Else", "For", "If", "Int", "Long", 
			"Return", "Class", "Void", "While", "Bool", "Noreturn", "LeftParen", 
			"RightParen", "LeftBracket", "RightBracket", "LeftBrace", "RightBrace", 
			"Less", "LessEqual", "Greater", "GreaterEqual", "LeftShift", "RightShift", 
			"Plus", "PlusPlus", "Minus", "MinusMinus", "Star", "Div", "Mod", "And", 
			"Or", "AndAnd", "OrOr", "Caret", "Not", "Tilde", "Question", "Colon", 
			"Semi", "Comma", "Assign", "Equal", "NotEqual", "Arrow", "Dot", "Ellipsis"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public Lexis(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Lexis.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\64\u0110\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\b"+
		"\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26"+
		"\3\26\3\27\3\27\3\27\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\33\3\33"+
		"\3\33\3\34\3\34\3\35\3\35\3\35\3\36\3\36\3\37\3\37\3\37\3 \3 \3!\3!\3"+
		"\"\3\"\3#\3#\3$\3$\3%\3%\3%\3&\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3"+
		",\3,\3-\3-\3.\3.\3/\3/\3/\3\60\3\60\3\60\3\61\3\61\3\61\3\62\3\62\3\63"+
		"\3\63\3\63\3\63\2\2\64\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27"+
		"\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33"+
		"\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63"+
		"e\64\3\2\2\2\u010f\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13"+
		"\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2"+
		"\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2"+
		"!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3"+
		"\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2"+
		"\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E"+
		"\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2"+
		"\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2"+
		"\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\3g\3\2\2\2\5m\3\2\2\2\7v"+
		"\3\2\2\2\t~\3\2\2\2\13\u0083\3\2\2\2\r\u0087\3\2\2\2\17\u008a\3\2\2\2"+
		"\21\u008e\3\2\2\2\23\u0093\3\2\2\2\25\u009a\3\2\2\2\27\u00a0\3\2\2\2\31"+
		"\u00a5\3\2\2\2\33\u00ab\3\2\2\2\35\u00b1\3\2\2\2\37\u00bb\3\2\2\2!\u00bd"+
		"\3\2\2\2#\u00bf\3\2\2\2%\u00c1\3\2\2\2\'\u00c3\3\2\2\2)\u00c5\3\2\2\2"+
		"+\u00c7\3\2\2\2-\u00c9\3\2\2\2/\u00cc\3\2\2\2\61\u00ce\3\2\2\2\63\u00d1"+
		"\3\2\2\2\65\u00d4\3\2\2\2\67\u00d7\3\2\2\29\u00d9\3\2\2\2;\u00dc\3\2\2"+
		"\2=\u00de\3\2\2\2?\u00e1\3\2\2\2A\u00e3\3\2\2\2C\u00e5\3\2\2\2E\u00e7"+
		"\3\2\2\2G\u00e9\3\2\2\2I\u00eb\3\2\2\2K\u00ee\3\2\2\2M\u00f1\3\2\2\2O"+
		"\u00f3\3\2\2\2Q\u00f5\3\2\2\2S\u00f7\3\2\2\2U\u00f9\3\2\2\2W\u00fb\3\2"+
		"\2\2Y\u00fd\3\2\2\2[\u00ff\3\2\2\2]\u0101\3\2\2\2_\u0104\3\2\2\2a\u0107"+
		"\3\2\2\2c\u010a\3\2\2\2e\u010c\3\2\2\2gh\7d\2\2hi\7t\2\2ij\7g\2\2jk\7"+
		"c\2\2kl\7m\2\2l\4\3\2\2\2mn\7e\2\2no\7q\2\2op\7p\2\2pq\7v\2\2qr\7k\2\2"+
		"rs\7p\2\2st\7w\2\2tu\7g\2\2u\6\3\2\2\2vw\7f\2\2wx\7g\2\2xy\7h\2\2yz\7"+
		"c\2\2z{\7w\2\2{|\7n\2\2|}\7v\2\2}\b\3\2\2\2~\177\7g\2\2\177\u0080\7n\2"+
		"\2\u0080\u0081\7u\2\2\u0081\u0082\7g\2\2\u0082\n\3\2\2\2\u0083\u0084\7"+
		"h\2\2\u0084\u0085\7q\2\2\u0085\u0086\7t\2\2\u0086\f\3\2\2\2\u0087\u0088"+
		"\7k\2\2\u0088\u0089\7h\2\2\u0089\16\3\2\2\2\u008a\u008b\7k\2\2\u008b\u008c"+
		"\7p\2\2\u008c\u008d\7v\2\2\u008d\20\3\2\2\2\u008e\u008f\7n\2\2\u008f\u0090"+
		"\7q\2\2\u0090\u0091\7p\2\2\u0091\u0092\7i\2\2\u0092\22\3\2\2\2\u0093\u0094"+
		"\7t\2\2\u0094\u0095\7g\2\2\u0095\u0096\7v\2\2\u0096\u0097\7w\2\2\u0097"+
		"\u0098\7t\2\2\u0098\u0099\7p\2\2\u0099\24\3\2\2\2\u009a\u009b\7e\2\2\u009b"+
		"\u009c\7n\2\2\u009c\u009d\7c\2\2\u009d\u009e\7u\2\2\u009e\u009f\7u\2\2"+
		"\u009f\26\3\2\2\2\u00a0\u00a1\7x\2\2\u00a1\u00a2\7q\2\2\u00a2\u00a3\7"+
		"k\2\2\u00a3\u00a4\7f\2\2\u00a4\30\3\2\2\2\u00a5\u00a6\7y\2\2\u00a6\u00a7"+
		"\7j\2\2\u00a7\u00a8\7k\2\2\u00a8\u00a9\7n\2\2\u00a9\u00aa\7g\2\2\u00aa"+
		"\32\3\2\2\2\u00ab\u00ac\7a\2\2\u00ac\u00ad\7D\2\2\u00ad\u00ae\7q\2\2\u00ae"+
		"\u00af\7q\2\2\u00af\u00b0\7n\2\2\u00b0\34\3\2\2\2\u00b1\u00b2\7a\2\2\u00b2"+
		"\u00b3\7P\2\2\u00b3\u00b4\7q\2\2\u00b4\u00b5\7t\2\2\u00b5\u00b6\7g\2\2"+
		"\u00b6\u00b7\7v\2\2\u00b7\u00b8\7w\2\2\u00b8\u00b9\7t\2\2\u00b9\u00ba"+
		"\7p\2\2\u00ba\36\3\2\2\2\u00bb\u00bc\7*\2\2\u00bc \3\2\2\2\u00bd\u00be"+
		"\7+\2\2\u00be\"\3\2\2\2\u00bf\u00c0\7]\2\2\u00c0$\3\2\2\2\u00c1\u00c2"+
		"\7_\2\2\u00c2&\3\2\2\2\u00c3\u00c4\7}\2\2\u00c4(\3\2\2\2\u00c5\u00c6\7"+
		"\177\2\2\u00c6*\3\2\2\2\u00c7\u00c8\7>\2\2\u00c8,\3\2\2\2\u00c9\u00ca"+
		"\7>\2\2\u00ca\u00cb\7?\2\2\u00cb.\3\2\2\2\u00cc\u00cd\7@\2\2\u00cd\60"+
		"\3\2\2\2\u00ce\u00cf\7@\2\2\u00cf\u00d0\7?\2\2\u00d0\62\3\2\2\2\u00d1"+
		"\u00d2\7>\2\2\u00d2\u00d3\7>\2\2\u00d3\64\3\2\2\2\u00d4\u00d5\7@\2\2\u00d5"+
		"\u00d6\7@\2\2\u00d6\66\3\2\2\2\u00d7\u00d8\7-\2\2\u00d88\3\2\2\2\u00d9"+
		"\u00da\7-\2\2\u00da\u00db\7-\2\2\u00db:\3\2\2\2\u00dc\u00dd\7/\2\2\u00dd"+
		"<\3\2\2\2\u00de\u00df\7/\2\2\u00df\u00e0\7/\2\2\u00e0>\3\2\2\2\u00e1\u00e2"+
		"\7,\2\2\u00e2@\3\2\2\2\u00e3\u00e4\7\61\2\2\u00e4B\3\2\2\2\u00e5\u00e6"+
		"\7\'\2\2\u00e6D\3\2\2\2\u00e7\u00e8\7(\2\2\u00e8F\3\2\2\2\u00e9\u00ea"+
		"\7~\2\2\u00eaH\3\2\2\2\u00eb\u00ec\7(\2\2\u00ec\u00ed\7(\2\2\u00edJ\3"+
		"\2\2\2\u00ee\u00ef\7~\2\2\u00ef\u00f0\7~\2\2\u00f0L\3\2\2\2\u00f1\u00f2"+
		"\7`\2\2\u00f2N\3\2\2\2\u00f3\u00f4\7#\2\2\u00f4P\3\2\2\2\u00f5\u00f6\7"+
		"\u0080\2\2\u00f6R\3\2\2\2\u00f7\u00f8\7A\2\2\u00f8T\3\2\2\2\u00f9\u00fa"+
		"\7<\2\2\u00faV\3\2\2\2\u00fb\u00fc\7=\2\2\u00fcX\3\2\2\2\u00fd\u00fe\7"+
		".\2\2\u00feZ\3\2\2\2\u00ff\u0100\7?\2\2\u0100\\\3\2\2\2\u0101\u0102\7"+
		"?\2\2\u0102\u0103\7?\2\2\u0103^\3\2\2\2\u0104\u0105\7#\2\2\u0105\u0106"+
		"\7?\2\2\u0106`\3\2\2\2\u0107\u0108\7/\2\2\u0108\u0109\7@\2\2\u0109b\3"+
		"\2\2\2\u010a\u010b\7\60\2\2\u010bd\3\2\2\2\u010c\u010d\7\60\2\2\u010d"+
		"\u010e\7\60\2\2\u010e\u010f\7\60\2\2\u010ff\3\2\2\2\3\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}