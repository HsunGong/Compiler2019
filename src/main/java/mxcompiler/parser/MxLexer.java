// Generated from /home/xun/Documents/mxc/src/main/java/mxcompiler/parser/grammar/Mx.g4 by ANTLR 4.7.2
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
public class MxLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, Identifier=5, IntegerLiteral=6, StringLiteral=7, 
		Whitespace=8, Newline=9, LineCommnet=10, BlockComment=11, Break=12, Continue=13, 
		Default=14, Else=15, For=16, If=17, Int=18, Long=19, String=20, Return=21, 
		Class=22, Void=23, While=24, Bool=25, Noreturn=26, LeftParen=27, RightParen=28, 
		LeftBracket=29, RightBracket=30, LeftBrace=31, RightBrace=32, Less=33, 
		LessEqual=34, Greater=35, GreaterEqual=36, LeftShift=37, RightShift=38, 
		Plus=39, PlusPlus=40, Minus=41, MinusMinus=42, Star=43, Div=44, Mod=45, 
		And=46, Or=47, AndAnd=48, OrOr=49, Caret=50, Not=51, Tilde=52, Question=53, 
		Colon=54, Semi=55, Comma=56, Assign=57, Equal=58, NotEqual=59, Arrow=60, 
		Dot=61, Ellipsis=62, New=63;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "Identifier", "Letter", "Digit", "IntegerLiteral", 
			"DecimalConstant", "IntegerSuffix", "StringLiteral", "Char", "EscapeSequence", 
			"Whitespace", "Newline", "LineCommnet", "BlockComment", "Break", "Continue", 
			"Default", "Else", "For", "If", "Int", "Long", "String", "Return", "Class", 
			"Void", "While", "Bool", "Noreturn", "LeftParen", "RightParen", "LeftBracket", 
			"RightBracket", "LeftBrace", "RightBrace", "Less", "LessEqual", "Greater", 
			"GreaterEqual", "LeftShift", "RightShift", "Plus", "PlusPlus", "Minus", 
			"MinusMinus", "Star", "Div", "Mod", "And", "Or", "AndAnd", "OrOr", "Caret", 
			"Not", "Tilde", "Question", "Colon", "Semi", "Comma", "Assign", "Equal", 
			"NotEqual", "Arrow", "Dot", "Ellipsis", "New"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'this'", "'null'", "'true'", "'false'", null, null, null, null, 
			null, null, null, "'break'", "'continue'", "'default'", "'else'", "'for'", 
			"'if'", "'int'", "'long'", "'String'", "'return'", "'class'", "'void'", 
			"'while'", "'_Bool'", "'_Noreturn'", "'('", "')'", "'['", "']'", "'{'", 
			"'}'", "'<'", "'<='", "'>'", "'>='", "'<<'", "'>>'", "'+'", "'++'", "'-'", 
			"'--'", "'*'", "'/'", "'%'", "'&'", "'|'", "'&&'", "'||'", "'^'", "'!'", 
			"'~'", "'?'", "':'", "';'", "','", "'='", "'=='", "'!='", "'->'", "'.'", 
			"'...'", "'new'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, "Identifier", "IntegerLiteral", "StringLiteral", 
			"Whitespace", "Newline", "LineCommnet", "BlockComment", "Break", "Continue", 
			"Default", "Else", "For", "If", "Int", "Long", "String", "Return", "Class", 
			"Void", "While", "Bool", "Noreturn", "LeftParen", "RightParen", "LeftBracket", 
			"RightBracket", "LeftBrace", "RightBrace", "Less", "LessEqual", "Greater", 
			"GreaterEqual", "LeftShift", "RightShift", "Plus", "PlusPlus", "Minus", 
			"MinusMinus", "Star", "Div", "Mod", "And", "Or", "AndAnd", "OrOr", "Caret", 
			"Not", "Tilde", "Question", "Colon", "Semi", "Comma", "Assign", "Equal", 
			"NotEqual", "Arrow", "Dot", "Ellipsis", "New"
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


	public MxLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Mx.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2A\u01c9\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\3\2\3\2\3\2\3\2"+
		"\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\6\3\6\3\6\5\6\u00a6\n\6\3\6\7\6\u00a9\n\6\f\6\16\6\u00ac\13\6\3\7\3\7"+
		"\3\b\3\b\3\t\3\t\5\t\u00b4\n\t\3\n\3\n\7\n\u00b8\n\n\f\n\16\n\u00bb\13"+
		"\n\3\13\3\13\5\13\u00bf\n\13\3\13\3\13\3\13\3\13\3\13\5\13\u00c6\n\13"+
		"\3\13\3\13\5\13\u00ca\n\13\3\13\3\13\3\13\3\13\5\13\u00d0\n\13\3\13\5"+
		"\13\u00d3\n\13\5\13\u00d5\n\13\3\f\3\f\6\f\u00d9\n\f\r\f\16\f\u00da\5"+
		"\f\u00dd\n\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00e8\n\r\3\16\3"+
		"\16\3\16\3\17\6\17\u00ee\n\17\r\17\16\17\u00ef\3\17\3\17\3\20\3\20\5\20"+
		"\u00f6\n\20\3\20\5\20\u00f9\n\20\3\20\3\20\3\21\3\21\3\21\3\21\7\21\u0101"+
		"\n\21\f\21\16\21\u0104\13\21\3\21\3\21\3\22\3\22\3\22\3\22\7\22\u010c"+
		"\n\22\f\22\16\22\u010f\13\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3"+
		"\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3"+
		"\27\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\33\3"+
		"\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3"+
		"\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3"+
		"\37\3\37\3 \3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3\"\3\"\3#\3"+
		"#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3)\3*\3*\3+\3+\3+\3,\3,\3,\3-"+
		"\3-\3-\3.\3.\3/\3/\3/\3\60\3\60\3\61\3\61\3\61\3\62\3\62\3\63\3\63\3\64"+
		"\3\64\3\65\3\65\3\66\3\66\3\67\3\67\3\67\38\38\38\39\39\3:\3:\3;\3;\3"+
		"<\3<\3=\3=\3>\3>\3?\3?\3@\3@\3A\3A\3A\3B\3B\3B\3C\3C\3C\3D\3D\3E\3E\3"+
		"E\3E\3F\3F\3F\3F\3\u010d\2G\3\3\5\4\7\5\t\6\13\7\r\2\17\2\21\b\23\2\25"+
		"\2\27\t\31\2\33\2\35\n\37\13!\f#\r%\16\'\17)\20+\21-\22/\23\61\24\63\25"+
		"\65\26\67\279\30;\31=\32?\33A\34C\35E\36G\37I K!M\"O#Q$S%U&W\'Y([)]*_"+
		"+a,c-e.g/i\60k\61m\62o\63q\64s\65u\66w\67y8{9}:\177;\u0081<\u0083=\u0085"+
		">\u0087?\u0089@\u008bA\3\2\13\4\2C\\c|\3\2\62;\3\2\63;\4\2WWww\4\2NNn"+
		"n\6\2\f\f\17\17$$^^\f\2$$))AA^^cdhhppttvvxx\4\2\13\13\"\"\4\2\f\f\17\17"+
		"\2\u01d9\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2"+
		"\2\21\3\2\2\2\2\27\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3"+
		"\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2"+
		"\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2"+
		"U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3"+
		"\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2"+
		"\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2"+
		"{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0085"+
		"\3\2\2\2\2\u0087\3\2\2\2\2\u0089\3\2\2\2\2\u008b\3\2\2\2\3\u008d\3\2\2"+
		"\2\5\u0092\3\2\2\2\7\u0097\3\2\2\2\t\u009c\3\2\2\2\13\u00a2\3\2\2\2\r"+
		"\u00ad\3\2\2\2\17\u00af\3\2\2\2\21\u00b1\3\2\2\2\23\u00b5\3\2\2\2\25\u00d4"+
		"\3\2\2\2\27\u00d6\3\2\2\2\31\u00e7\3\2\2\2\33\u00e9\3\2\2\2\35\u00ed\3"+
		"\2\2\2\37\u00f8\3\2\2\2!\u00fc\3\2\2\2#\u0107\3\2\2\2%\u0115\3\2\2\2\'"+
		"\u011b\3\2\2\2)\u0124\3\2\2\2+\u012c\3\2\2\2-\u0131\3\2\2\2/\u0135\3\2"+
		"\2\2\61\u0138\3\2\2\2\63\u013c\3\2\2\2\65\u0141\3\2\2\2\67\u0148\3\2\2"+
		"\29\u014f\3\2\2\2;\u0155\3\2\2\2=\u015a\3\2\2\2?\u0160\3\2\2\2A\u0166"+
		"\3\2\2\2C\u0170\3\2\2\2E\u0172\3\2\2\2G\u0174\3\2\2\2I\u0176\3\2\2\2K"+
		"\u0178\3\2\2\2M\u017a\3\2\2\2O\u017c\3\2\2\2Q\u017e\3\2\2\2S\u0181\3\2"+
		"\2\2U\u0183\3\2\2\2W\u0186\3\2\2\2Y\u0189\3\2\2\2[\u018c\3\2\2\2]\u018e"+
		"\3\2\2\2_\u0191\3\2\2\2a\u0193\3\2\2\2c\u0196\3\2\2\2e\u0198\3\2\2\2g"+
		"\u019a\3\2\2\2i\u019c\3\2\2\2k\u019e\3\2\2\2m\u01a0\3\2\2\2o\u01a3\3\2"+
		"\2\2q\u01a6\3\2\2\2s\u01a8\3\2\2\2u\u01aa\3\2\2\2w\u01ac\3\2\2\2y\u01ae"+
		"\3\2\2\2{\u01b0\3\2\2\2}\u01b2\3\2\2\2\177\u01b4\3\2\2\2\u0081\u01b6\3"+
		"\2\2\2\u0083\u01b9\3\2\2\2\u0085\u01bc\3\2\2\2\u0087\u01bf\3\2\2\2\u0089"+
		"\u01c1\3\2\2\2\u008b\u01c5\3\2\2\2\u008d\u008e\7v\2\2\u008e\u008f\7j\2"+
		"\2\u008f\u0090\7k\2\2\u0090\u0091\7u\2\2\u0091\4\3\2\2\2\u0092\u0093\7"+
		"p\2\2\u0093\u0094\7w\2\2\u0094\u0095\7n\2\2\u0095\u0096\7n\2\2\u0096\6"+
		"\3\2\2\2\u0097\u0098\7v\2\2\u0098\u0099\7t\2\2\u0099\u009a\7w\2\2\u009a"+
		"\u009b\7g\2\2\u009b\b\3\2\2\2\u009c\u009d\7h\2\2\u009d\u009e\7c\2\2\u009e"+
		"\u009f\7n\2\2\u009f\u00a0\7u\2\2\u00a0\u00a1\7g\2\2\u00a1\n\3\2\2\2\u00a2"+
		"\u00aa\5\r\7\2\u00a3\u00a6\5\r\7\2\u00a4\u00a6\7a\2\2\u00a5\u00a3\3\2"+
		"\2\2\u00a5\u00a4\3\2\2\2\u00a6\u00a9\3\2\2\2\u00a7\u00a9\5\17\b\2\u00a8"+
		"\u00a5\3\2\2\2\u00a8\u00a7\3\2\2\2\u00a9\u00ac\3\2\2\2\u00aa\u00a8\3\2"+
		"\2\2\u00aa\u00ab\3\2\2\2\u00ab\f\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ad\u00ae"+
		"\t\2\2\2\u00ae\16\3\2\2\2\u00af\u00b0\t\3\2\2\u00b0\20\3\2\2\2\u00b1\u00b3"+
		"\5\23\n\2\u00b2\u00b4\5\25\13\2\u00b3\u00b2\3\2\2\2\u00b3\u00b4\3\2\2"+
		"\2\u00b4\22\3\2\2\2\u00b5\u00b9\t\4\2\2\u00b6\u00b8\5\17\b\2\u00b7\u00b6"+
		"\3\2\2\2\u00b8\u00bb\3\2\2\2\u00b9\u00b7\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba"+
		"\24\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bc\u00be\t\5\2\2\u00bd\u00bf\t\6\2"+
		"\2\u00be\u00bd\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\u00d5\3\2\2\2\u00c0\u00c5"+
		"\t\5\2\2\u00c1\u00c2\7n\2\2\u00c2\u00c6\7n\2\2\u00c3\u00c4\7N\2\2\u00c4"+
		"\u00c6\7N\2\2\u00c5\u00c1\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c6\u00d5\3\2"+
		"\2\2\u00c7\u00c9\t\6\2\2\u00c8\u00ca\t\5\2\2\u00c9\u00c8\3\2\2\2\u00c9"+
		"\u00ca\3\2\2\2\u00ca\u00d5\3\2\2\2\u00cb\u00cc\7n\2\2\u00cc\u00d0\7n\2"+
		"\2\u00cd\u00ce\7N\2\2\u00ce\u00d0\7N\2\2\u00cf\u00cb\3\2\2\2\u00cf\u00cd"+
		"\3\2\2\2\u00d0\u00d2\3\2\2\2\u00d1\u00d3\t\5\2\2\u00d2\u00d1\3\2\2\2\u00d2"+
		"\u00d3\3\2\2\2\u00d3\u00d5\3\2\2\2\u00d4\u00bc\3\2\2\2\u00d4\u00c0\3\2"+
		"\2\2\u00d4\u00c7\3\2\2\2\u00d4\u00cf\3\2\2\2\u00d5\26\3\2\2\2\u00d6\u00dc"+
		"\7$\2\2\u00d7\u00d9\5\31\r\2\u00d8\u00d7\3\2\2\2\u00d9\u00da\3\2\2\2\u00da"+
		"\u00d8\3\2\2\2\u00da\u00db\3\2\2\2\u00db\u00dd\3\2\2\2\u00dc\u00d8\3\2"+
		"\2\2\u00dc\u00dd\3\2\2\2\u00dd\u00de\3\2\2\2\u00de\u00df\7$\2\2\u00df"+
		"\30\3\2\2\2\u00e0\u00e8\n\7\2\2\u00e1\u00e2\7^\2\2\u00e2\u00e8\7\f\2\2"+
		"\u00e3\u00e4\7^\2\2\u00e4\u00e5\7\17\2\2\u00e5\u00e8\7\f\2\2\u00e6\u00e8"+
		"\5\33\16\2\u00e7\u00e0\3\2\2\2\u00e7\u00e1\3\2\2\2\u00e7\u00e3\3\2\2\2"+
		"\u00e7\u00e6\3\2\2\2\u00e8\32\3\2\2\2\u00e9\u00ea\7^\2\2\u00ea\u00eb\t"+
		"\b\2\2\u00eb\34\3\2\2\2\u00ec\u00ee\t\t\2\2\u00ed\u00ec\3\2\2\2\u00ee"+
		"\u00ef\3\2\2\2\u00ef\u00ed\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\u00f1\3\2"+
		"\2\2\u00f1\u00f2\b\17\2\2\u00f2\36\3\2\2\2\u00f3\u00f5\7\17\2\2\u00f4"+
		"\u00f6\7\f\2\2\u00f5\u00f4\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6\u00f9\3\2"+
		"\2\2\u00f7\u00f9\7\f\2\2\u00f8\u00f3\3\2\2\2\u00f8\u00f7\3\2\2\2\u00f9"+
		"\u00fa\3\2\2\2\u00fa\u00fb\b\20\2\2\u00fb \3\2\2\2\u00fc\u00fd\7\61\2"+
		"\2\u00fd\u00fe\7\61\2\2\u00fe\u0102\3\2\2\2\u00ff\u0101\n\n\2\2\u0100"+
		"\u00ff\3\2\2\2\u0101\u0104\3\2\2\2\u0102\u0100\3\2\2\2\u0102\u0103\3\2"+
		"\2\2\u0103\u0105\3\2\2\2\u0104\u0102\3\2\2\2\u0105\u0106\b\21\2\2\u0106"+
		"\"\3\2\2\2\u0107\u0108\7\61\2\2\u0108\u0109\7,\2\2\u0109\u010d\3\2\2\2"+
		"\u010a\u010c\13\2\2\2\u010b\u010a\3\2\2\2\u010c\u010f\3\2\2\2\u010d\u010e"+
		"\3\2\2\2\u010d\u010b\3\2\2\2\u010e\u0110\3\2\2\2\u010f\u010d\3\2\2\2\u0110"+
		"\u0111\7,\2\2\u0111\u0112\7\61\2\2\u0112\u0113\3\2\2\2\u0113\u0114\b\22"+
		"\2\2\u0114$\3\2\2\2\u0115\u0116\7d\2\2\u0116\u0117\7t\2\2\u0117\u0118"+
		"\7g\2\2\u0118\u0119\7c\2\2\u0119\u011a\7m\2\2\u011a&\3\2\2\2\u011b\u011c"+
		"\7e\2\2\u011c\u011d\7q\2\2\u011d\u011e\7p\2\2\u011e\u011f\7v\2\2\u011f"+
		"\u0120\7k\2\2\u0120\u0121\7p\2\2\u0121\u0122\7w\2\2\u0122\u0123\7g\2\2"+
		"\u0123(\3\2\2\2\u0124\u0125\7f\2\2\u0125\u0126\7g\2\2\u0126\u0127\7h\2"+
		"\2\u0127\u0128\7c\2\2\u0128\u0129\7w\2\2\u0129\u012a\7n\2\2\u012a\u012b"+
		"\7v\2\2\u012b*\3\2\2\2\u012c\u012d\7g\2\2\u012d\u012e\7n\2\2\u012e\u012f"+
		"\7u\2\2\u012f\u0130\7g\2\2\u0130,\3\2\2\2\u0131\u0132\7h\2\2\u0132\u0133"+
		"\7q\2\2\u0133\u0134\7t\2\2\u0134.\3\2\2\2\u0135\u0136\7k\2\2\u0136\u0137"+
		"\7h\2\2\u0137\60\3\2\2\2\u0138\u0139\7k\2\2\u0139\u013a\7p\2\2\u013a\u013b"+
		"\7v\2\2\u013b\62\3\2\2\2\u013c\u013d\7n\2\2\u013d\u013e\7q\2\2\u013e\u013f"+
		"\7p\2\2\u013f\u0140\7i\2\2\u0140\64\3\2\2\2\u0141\u0142\7U\2\2\u0142\u0143"+
		"\7v\2\2\u0143\u0144\7t\2\2\u0144\u0145\7k\2\2\u0145\u0146\7p\2\2\u0146"+
		"\u0147\7i\2\2\u0147\66\3\2\2\2\u0148\u0149\7t\2\2\u0149\u014a\7g\2\2\u014a"+
		"\u014b\7v\2\2\u014b\u014c\7w\2\2\u014c\u014d\7t\2\2\u014d\u014e\7p\2\2"+
		"\u014e8\3\2\2\2\u014f\u0150\7e\2\2\u0150\u0151\7n\2\2\u0151\u0152\7c\2"+
		"\2\u0152\u0153\7u\2\2\u0153\u0154\7u\2\2\u0154:\3\2\2\2\u0155\u0156\7"+
		"x\2\2\u0156\u0157\7q\2\2\u0157\u0158\7k\2\2\u0158\u0159\7f\2\2\u0159<"+
		"\3\2\2\2\u015a\u015b\7y\2\2\u015b\u015c\7j\2\2\u015c\u015d\7k\2\2\u015d"+
		"\u015e\7n\2\2\u015e\u015f\7g\2\2\u015f>\3\2\2\2\u0160\u0161\7a\2\2\u0161"+
		"\u0162\7D\2\2\u0162\u0163\7q\2\2\u0163\u0164\7q\2\2\u0164\u0165\7n\2\2"+
		"\u0165@\3\2\2\2\u0166\u0167\7a\2\2\u0167\u0168\7P\2\2\u0168\u0169\7q\2"+
		"\2\u0169\u016a\7t\2\2\u016a\u016b\7g\2\2\u016b\u016c\7v\2\2\u016c\u016d"+
		"\7w\2\2\u016d\u016e\7t\2\2\u016e\u016f\7p\2\2\u016fB\3\2\2\2\u0170\u0171"+
		"\7*\2\2\u0171D\3\2\2\2\u0172\u0173\7+\2\2\u0173F\3\2\2\2\u0174\u0175\7"+
		"]\2\2\u0175H\3\2\2\2\u0176\u0177\7_\2\2\u0177J\3\2\2\2\u0178\u0179\7}"+
		"\2\2\u0179L\3\2\2\2\u017a\u017b\7\177\2\2\u017bN\3\2\2\2\u017c\u017d\7"+
		">\2\2\u017dP\3\2\2\2\u017e\u017f\7>\2\2\u017f\u0180\7?\2\2\u0180R\3\2"+
		"\2\2\u0181\u0182\7@\2\2\u0182T\3\2\2\2\u0183\u0184\7@\2\2\u0184\u0185"+
		"\7?\2\2\u0185V\3\2\2\2\u0186\u0187\7>\2\2\u0187\u0188\7>\2\2\u0188X\3"+
		"\2\2\2\u0189\u018a\7@\2\2\u018a\u018b\7@\2\2\u018bZ\3\2\2\2\u018c\u018d"+
		"\7-\2\2\u018d\\\3\2\2\2\u018e\u018f\7-\2\2\u018f\u0190\7-\2\2\u0190^\3"+
		"\2\2\2\u0191\u0192\7/\2\2\u0192`\3\2\2\2\u0193\u0194\7/\2\2\u0194\u0195"+
		"\7/\2\2\u0195b\3\2\2\2\u0196\u0197\7,\2\2\u0197d\3\2\2\2\u0198\u0199\7"+
		"\61\2\2\u0199f\3\2\2\2\u019a\u019b\7\'\2\2\u019bh\3\2\2\2\u019c\u019d"+
		"\7(\2\2\u019dj\3\2\2\2\u019e\u019f\7~\2\2\u019fl\3\2\2\2\u01a0\u01a1\7"+
		"(\2\2\u01a1\u01a2\7(\2\2\u01a2n\3\2\2\2\u01a3\u01a4\7~\2\2\u01a4\u01a5"+
		"\7~\2\2\u01a5p\3\2\2\2\u01a6\u01a7\7`\2\2\u01a7r\3\2\2\2\u01a8\u01a9\7"+
		"#\2\2\u01a9t\3\2\2\2\u01aa\u01ab\7\u0080\2\2\u01abv\3\2\2\2\u01ac\u01ad"+
		"\7A\2\2\u01adx\3\2\2\2\u01ae\u01af\7<\2\2\u01afz\3\2\2\2\u01b0\u01b1\7"+
		"=\2\2\u01b1|\3\2\2\2\u01b2\u01b3\7.\2\2\u01b3~\3\2\2\2\u01b4\u01b5\7?"+
		"\2\2\u01b5\u0080\3\2\2\2\u01b6\u01b7\7?\2\2\u01b7\u01b8\7?\2\2\u01b8\u0082"+
		"\3\2\2\2\u01b9\u01ba\7#\2\2\u01ba\u01bb\7?\2\2\u01bb\u0084\3\2\2\2\u01bc"+
		"\u01bd\7/\2\2\u01bd\u01be\7@\2\2\u01be\u0086\3\2\2\2\u01bf\u01c0\7\60"+
		"\2\2\u01c0\u0088\3\2\2\2\u01c1\u01c2\7\60\2\2\u01c2\u01c3\7\60\2\2\u01c3"+
		"\u01c4\7\60\2\2\u01c4\u008a\3\2\2\2\u01c5\u01c6\7p\2\2\u01c6\u01c7\7g"+
		"\2\2\u01c7\u01c8\7y\2\2\u01c8\u008c\3\2\2\2\26\2\u00a5\u00a8\u00aa\u00b3"+
		"\u00b9\u00be\u00c5\u00c9\u00cf\u00d2\u00d4\u00da\u00dc\u00e7\u00ef\u00f5"+
		"\u00f8\u0102\u010d\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}