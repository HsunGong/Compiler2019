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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, Identifier=6, IntegerLiteral=7, 
		DigitSequence=8, StringLiteral=9, Whitespace=10, Newline=11, LineCommnet=12, 
		BlockComment=13, Break=14, Continue=15, Default=16, Else=17, For=18, If=19, 
		Int=20, String=21, Return=22, Class=23, Void=24, While=25, Bool=26, LeftParen=27, 
		RightParen=28, LeftBracket=29, RightBracket=30, LeftBrace=31, RightBrace=32, 
		Less=33, LessEqual=34, Greater=35, GreaterEqual=36, LeftShift=37, RightShift=38, 
		Plus=39, PlusPlus=40, Minus=41, MinusMinus=42, Star=43, Div=44, Mod=45, 
		And=46, Or=47, AndAnd=48, OrOr=49, Caret=50, Not=51, Tilde=52, Question=53, 
		Colon=54, Semi=55, Comma=56, Assign=57, Equal=58, NotEqual=59, Arrow=60, 
		Dot=61, New=62;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "Identifier", "Letter", "Digit", 
			"IntegerLiteral", "DecimalConstant", "DigitSequence", "IntegerSuffix", 
			"StringLiteral", "SChar", "EscapeSequence", "Whitespace", "Newline", 
			"LineCommnet", "BlockComment", "Break", "Continue", "Default", "Else", 
			"For", "If", "Int", "String", "Return", "Class", "Void", "While", "Bool", 
			"LeftParen", "RightParen", "LeftBracket", "RightBracket", "LeftBrace", 
			"RightBrace", "Less", "LessEqual", "Greater", "GreaterEqual", "LeftShift", 
			"RightShift", "Plus", "PlusPlus", "Minus", "MinusMinus", "Star", "Div", 
			"Mod", "And", "Or", "AndAnd", "OrOr", "Caret", "Not", "Tilde", "Question", 
			"Colon", "Semi", "Comma", "Assign", "Equal", "NotEqual", "Arrow", "Dot", 
			"New"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'this'", "'true'", "'false'", "'null'", "'string'", null, null, 
			null, null, null, null, null, null, "'break'", "'continue'", "'default'", 
			"'else'", "'for'", "'if'", "'int'", "'String'", "'return'", "'class'", 
			"'void'", "'while'", "'bool'", "'('", "')'", "'['", "']'", "'{'", "'}'", 
			"'<'", "'<='", "'>'", "'>='", "'<<'", "'>>'", "'+'", "'++'", "'-'", "'--'", 
			"'*'", "'/'", "'%'", "'&'", "'|'", "'&&'", "'||'", "'^'", "'!'", "'~'", 
			"'?'", "':'", "';'", "','", "'='", "'=='", "'!='", "'->'", "'.'", "'new'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, "Identifier", "IntegerLiteral", "DigitSequence", 
			"StringLiteral", "Whitespace", "Newline", "LineCommnet", "BlockComment", 
			"Break", "Continue", "Default", "Else", "For", "If", "Int", "String", 
			"Return", "Class", "Void", "While", "Bool", "LeftParen", "RightParen", 
			"LeftBracket", "RightBracket", "LeftBrace", "RightBrace", "Less", "LessEqual", 
			"Greater", "GreaterEqual", "LeftShift", "RightShift", "Plus", "PlusPlus", 
			"Minus", "MinusMinus", "Star", "Div", "Mod", "And", "Or", "AndAnd", "OrOr", 
			"Caret", "Not", "Tilde", "Question", "Colon", "Semi", "Comma", "Assign", 
			"Equal", "NotEqual", "Arrow", "Dot", "New"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2@\u01bf\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\3\2\3\2\3\2\3\2\3\2\3"+
		"\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\5\7\u00ab\n\7\3\7\7\7\u00ae\n\7\f\7\16"+
		"\7\u00b1\13\7\3\b\3\b\3\t\3\t\3\n\3\n\5\n\u00b9\n\n\3\13\3\13\7\13\u00bd"+
		"\n\13\f\13\16\13\u00c0\13\13\3\f\6\f\u00c3\n\f\r\f\16\f\u00c4\3\r\3\r"+
		"\5\r\u00c9\n\r\3\r\3\r\3\r\3\r\3\r\5\r\u00d0\n\r\3\r\3\r\5\r\u00d4\n\r"+
		"\3\r\3\r\3\r\3\r\5\r\u00da\n\r\3\r\5\r\u00dd\n\r\5\r\u00df\n\r\3\16\3"+
		"\16\6\16\u00e3\n\16\r\16\16\16\u00e4\5\16\u00e7\n\16\3\16\3\16\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\5\17\u00f2\n\17\3\20\3\20\3\20\3\21\6\21"+
		"\u00f8\n\21\r\21\16\21\u00f9\3\21\3\21\3\22\3\22\5\22\u0100\n\22\3\22"+
		"\5\22\u0103\n\22\3\22\3\22\3\23\3\23\3\23\3\23\7\23\u010b\n\23\f\23\16"+
		"\23\u010e\13\23\3\23\3\23\3\24\3\24\3\24\3\24\7\24\u0116\n\24\f\24\16"+
		"\24\u0119\13\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\32\3\32"+
		"\3\32\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37"+
		"\3\37\3\37\3 \3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%"+
		"\3&\3&\3\'\3\'\3(\3(\3)\3)\3)\3*\3*\3+\3+\3+\3,\3,\3,\3-\3-\3-\3.\3.\3"+
		"/\3/\3/\3\60\3\60\3\61\3\61\3\61\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3"+
		"\65\3\66\3\66\3\67\3\67\3\67\38\38\38\39\39\3:\3:\3;\3;\3<\3<\3=\3=\3"+
		">\3>\3?\3?\3@\3@\3A\3A\3A\3B\3B\3B\3C\3C\3C\3D\3D\3E\3E\3E\3E\3\u0117"+
		"\2F\3\3\5\4\7\5\t\6\13\7\r\b\17\2\21\2\23\t\25\2\27\n\31\2\33\13\35\2"+
		"\37\2!\f#\r%\16\'\17)\20+\21-\22/\23\61\24\63\25\65\26\67\279\30;\31="+
		"\32?\33A\34C\35E\36G\37I K!M\"O#Q$S%U&W\'Y([)]*_+a,c-e.g/i\60k\61m\62"+
		"o\63q\64s\65u\66w\67y8{9}:\177;\u0081<\u0083=\u0085>\u0087?\u0089@\3\2"+
		"\13\4\2C\\c|\3\2\62;\3\2\63;\4\2WWww\4\2NNnn\6\2\f\f\17\17$$^^\f\2$$)"+
		")AA^^cdhhppttvvxx\4\2\13\13\"\"\4\2\f\f\17\17\2\u01d0\2\3\3\2\2\2\2\5"+
		"\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\23\3\2\2\2"+
		"\2\27\3\2\2\2\2\33\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2"+
		"\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2"+
		"\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2"+
		"\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2"+
		"M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3"+
		"\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2"+
		"\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2"+
		"s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177"+
		"\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0085\3\2\2\2\2\u0087\3\2\2"+
		"\2\2\u0089\3\2\2\2\3\u008b\3\2\2\2\5\u0090\3\2\2\2\7\u0095\3\2\2\2\t\u009b"+
		"\3\2\2\2\13\u00a0\3\2\2\2\r\u00a7\3\2\2\2\17\u00b2\3\2\2\2\21\u00b4\3"+
		"\2\2\2\23\u00b6\3\2\2\2\25\u00ba\3\2\2\2\27\u00c2\3\2\2\2\31\u00de\3\2"+
		"\2\2\33\u00e0\3\2\2\2\35\u00f1\3\2\2\2\37\u00f3\3\2\2\2!\u00f7\3\2\2\2"+
		"#\u0102\3\2\2\2%\u0106\3\2\2\2\'\u0111\3\2\2\2)\u011f\3\2\2\2+\u0125\3"+
		"\2\2\2-\u012e\3\2\2\2/\u0136\3\2\2\2\61\u013b\3\2\2\2\63\u013f\3\2\2\2"+
		"\65\u0142\3\2\2\2\67\u0146\3\2\2\29\u014d\3\2\2\2;\u0154\3\2\2\2=\u015a"+
		"\3\2\2\2?\u015f\3\2\2\2A\u0165\3\2\2\2C\u016a\3\2\2\2E\u016c\3\2\2\2G"+
		"\u016e\3\2\2\2I\u0170\3\2\2\2K\u0172\3\2\2\2M\u0174\3\2\2\2O\u0176\3\2"+
		"\2\2Q\u0178\3\2\2\2S\u017b\3\2\2\2U\u017d\3\2\2\2W\u0180\3\2\2\2Y\u0183"+
		"\3\2\2\2[\u0186\3\2\2\2]\u0188\3\2\2\2_\u018b\3\2\2\2a\u018d\3\2\2\2c"+
		"\u0190\3\2\2\2e\u0192\3\2\2\2g\u0194\3\2\2\2i\u0196\3\2\2\2k\u0198\3\2"+
		"\2\2m\u019a\3\2\2\2o\u019d\3\2\2\2q\u01a0\3\2\2\2s\u01a2\3\2\2\2u\u01a4"+
		"\3\2\2\2w\u01a6\3\2\2\2y\u01a8\3\2\2\2{\u01aa\3\2\2\2}\u01ac\3\2\2\2\177"+
		"\u01ae\3\2\2\2\u0081\u01b0\3\2\2\2\u0083\u01b3\3\2\2\2\u0085\u01b6\3\2"+
		"\2\2\u0087\u01b9\3\2\2\2\u0089\u01bb\3\2\2\2\u008b\u008c\7v\2\2\u008c"+
		"\u008d\7j\2\2\u008d\u008e\7k\2\2\u008e\u008f\7u\2\2\u008f\4\3\2\2\2\u0090"+
		"\u0091\7v\2\2\u0091\u0092\7t\2\2\u0092\u0093\7w\2\2\u0093\u0094\7g\2\2"+
		"\u0094\6\3\2\2\2\u0095\u0096\7h\2\2\u0096\u0097\7c\2\2\u0097\u0098\7n"+
		"\2\2\u0098\u0099\7u\2\2\u0099\u009a\7g\2\2\u009a\b\3\2\2\2\u009b\u009c"+
		"\7p\2\2\u009c\u009d\7w\2\2\u009d\u009e\7n\2\2\u009e\u009f\7n\2\2\u009f"+
		"\n\3\2\2\2\u00a0\u00a1\7u\2\2\u00a1\u00a2\7v\2\2\u00a2\u00a3\7t\2\2\u00a3"+
		"\u00a4\7k\2\2\u00a4\u00a5\7p\2\2\u00a5\u00a6\7i\2\2\u00a6\f\3\2\2\2\u00a7"+
		"\u00af\5\17\b\2\u00a8\u00ab\5\17\b\2\u00a9\u00ab\7a\2\2\u00aa\u00a8\3"+
		"\2\2\2\u00aa\u00a9\3\2\2\2\u00ab\u00ae\3\2\2\2\u00ac\u00ae\5\21\t\2\u00ad"+
		"\u00aa\3\2\2\2\u00ad\u00ac\3\2\2\2\u00ae\u00b1\3\2\2\2\u00af\u00ad\3\2"+
		"\2\2\u00af\u00b0\3\2\2\2\u00b0\16\3\2\2\2\u00b1\u00af\3\2\2\2\u00b2\u00b3"+
		"\t\2\2\2\u00b3\20\3\2\2\2\u00b4\u00b5\t\3\2\2\u00b5\22\3\2\2\2\u00b6\u00b8"+
		"\5\25\13\2\u00b7\u00b9\5\31\r\2\u00b8\u00b7\3\2\2\2\u00b8\u00b9\3\2\2"+
		"\2\u00b9\24\3\2\2\2\u00ba\u00be\t\4\2\2\u00bb\u00bd\5\21\t\2\u00bc\u00bb"+
		"\3\2\2\2\u00bd\u00c0\3\2\2\2\u00be\u00bc\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf"+
		"\26\3\2\2\2\u00c0\u00be\3\2\2\2\u00c1\u00c3\5\21\t\2\u00c2\u00c1\3\2\2"+
		"\2\u00c3\u00c4\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\30"+
		"\3\2\2\2\u00c6\u00c8\t\5\2\2\u00c7\u00c9\t\6\2\2\u00c8\u00c7\3\2\2\2\u00c8"+
		"\u00c9\3\2\2\2\u00c9\u00df\3\2\2\2\u00ca\u00cf\t\5\2\2\u00cb\u00cc\7n"+
		"\2\2\u00cc\u00d0\7n\2\2\u00cd\u00ce\7N\2\2\u00ce\u00d0\7N\2\2\u00cf\u00cb"+
		"\3\2\2\2\u00cf\u00cd\3\2\2\2\u00d0\u00df\3\2\2\2\u00d1\u00d3\t\6\2\2\u00d2"+
		"\u00d4\t\5\2\2\u00d3\u00d2\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00df\3\2"+
		"\2\2\u00d5\u00d6\7n\2\2\u00d6\u00da\7n\2\2\u00d7\u00d8\7N\2\2\u00d8\u00da"+
		"\7N\2\2\u00d9\u00d5\3\2\2\2\u00d9\u00d7\3\2\2\2\u00da\u00dc\3\2\2\2\u00db"+
		"\u00dd\t\5\2\2\u00dc\u00db\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd\u00df\3\2"+
		"\2\2\u00de\u00c6\3\2\2\2\u00de\u00ca\3\2\2\2\u00de\u00d1\3\2\2\2\u00de"+
		"\u00d9\3\2\2\2\u00df\32\3\2\2\2\u00e0\u00e6\7$\2\2\u00e1\u00e3\5\35\17"+
		"\2\u00e2\u00e1\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e4\u00e5"+
		"\3\2\2\2\u00e5\u00e7\3\2\2\2\u00e6\u00e2\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7"+
		"\u00e8\3\2\2\2\u00e8\u00e9\7$\2\2\u00e9\34\3\2\2\2\u00ea\u00f2\n\7\2\2"+
		"\u00eb\u00ec\7^\2\2\u00ec\u00f2\7\f\2\2\u00ed\u00ee\7^\2\2\u00ee\u00ef"+
		"\7\17\2\2\u00ef\u00f2\7\f\2\2\u00f0\u00f2\5\37\20\2\u00f1\u00ea\3\2\2"+
		"\2\u00f1\u00eb\3\2\2\2\u00f1\u00ed\3\2\2\2\u00f1\u00f0\3\2\2\2\u00f2\36"+
		"\3\2\2\2\u00f3\u00f4\7^\2\2\u00f4\u00f5\t\b\2\2\u00f5 \3\2\2\2\u00f6\u00f8"+
		"\t\t\2\2\u00f7\u00f6\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9\u00f7\3\2\2\2\u00f9"+
		"\u00fa\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb\u00fc\b\21\2\2\u00fc\"\3\2\2"+
		"\2\u00fd\u00ff\7\17\2\2\u00fe\u0100\7\f\2\2\u00ff\u00fe\3\2\2\2\u00ff"+
		"\u0100\3\2\2\2\u0100\u0103\3\2\2\2\u0101\u0103\7\f\2\2\u0102\u00fd\3\2"+
		"\2\2\u0102\u0101\3\2\2\2\u0103\u0104\3\2\2\2\u0104\u0105\b\22\2\2\u0105"+
		"$\3\2\2\2\u0106\u0107\7\61\2\2\u0107\u0108\7\61\2\2\u0108\u010c\3\2\2"+
		"\2\u0109\u010b\n\n\2\2\u010a\u0109\3\2\2\2\u010b\u010e\3\2\2\2\u010c\u010a"+
		"\3\2\2\2\u010c\u010d\3\2\2\2\u010d\u010f\3\2\2\2\u010e\u010c\3\2\2\2\u010f"+
		"\u0110\b\23\2\2\u0110&\3\2\2\2\u0111\u0112\7\61\2\2\u0112\u0113\7,\2\2"+
		"\u0113\u0117\3\2\2\2\u0114\u0116\13\2\2\2\u0115\u0114\3\2\2\2\u0116\u0119"+
		"\3\2\2\2\u0117\u0118\3\2\2\2\u0117\u0115\3\2\2\2\u0118\u011a\3\2\2\2\u0119"+
		"\u0117\3\2\2\2\u011a\u011b\7,\2\2\u011b\u011c\7\61\2\2\u011c\u011d\3\2"+
		"\2\2\u011d\u011e\b\24\2\2\u011e(\3\2\2\2\u011f\u0120\7d\2\2\u0120\u0121"+
		"\7t\2\2\u0121\u0122\7g\2\2\u0122\u0123\7c\2\2\u0123\u0124\7m\2\2\u0124"+
		"*\3\2\2\2\u0125\u0126\7e\2\2\u0126\u0127\7q\2\2\u0127\u0128\7p\2\2\u0128"+
		"\u0129\7v\2\2\u0129\u012a\7k\2\2\u012a\u012b\7p\2\2\u012b\u012c\7w\2\2"+
		"\u012c\u012d\7g\2\2\u012d,\3\2\2\2\u012e\u012f\7f\2\2\u012f\u0130\7g\2"+
		"\2\u0130\u0131\7h\2\2\u0131\u0132\7c\2\2\u0132\u0133\7w\2\2\u0133\u0134"+
		"\7n\2\2\u0134\u0135\7v\2\2\u0135.\3\2\2\2\u0136\u0137\7g\2\2\u0137\u0138"+
		"\7n\2\2\u0138\u0139\7u\2\2\u0139\u013a\7g\2\2\u013a\60\3\2\2\2\u013b\u013c"+
		"\7h\2\2\u013c\u013d\7q\2\2\u013d\u013e\7t\2\2\u013e\62\3\2\2\2\u013f\u0140"+
		"\7k\2\2\u0140\u0141\7h\2\2\u0141\64\3\2\2\2\u0142\u0143\7k\2\2\u0143\u0144"+
		"\7p\2\2\u0144\u0145\7v\2\2\u0145\66\3\2\2\2\u0146\u0147\7U\2\2\u0147\u0148"+
		"\7v\2\2\u0148\u0149\7t\2\2\u0149\u014a\7k\2\2\u014a\u014b\7p\2\2\u014b"+
		"\u014c\7i\2\2\u014c8\3\2\2\2\u014d\u014e\7t\2\2\u014e\u014f\7g\2\2\u014f"+
		"\u0150\7v\2\2\u0150\u0151\7w\2\2\u0151\u0152\7t\2\2\u0152\u0153\7p\2\2"+
		"\u0153:\3\2\2\2\u0154\u0155\7e\2\2\u0155\u0156\7n\2\2\u0156\u0157\7c\2"+
		"\2\u0157\u0158\7u\2\2\u0158\u0159\7u\2\2\u0159<\3\2\2\2\u015a\u015b\7"+
		"x\2\2\u015b\u015c\7q\2\2\u015c\u015d\7k\2\2\u015d\u015e\7f\2\2\u015e>"+
		"\3\2\2\2\u015f\u0160\7y\2\2\u0160\u0161\7j\2\2\u0161\u0162\7k\2\2\u0162"+
		"\u0163\7n\2\2\u0163\u0164\7g\2\2\u0164@\3\2\2\2\u0165\u0166\7d\2\2\u0166"+
		"\u0167\7q\2\2\u0167\u0168\7q\2\2\u0168\u0169\7n\2\2\u0169B\3\2\2\2\u016a"+
		"\u016b\7*\2\2\u016bD\3\2\2\2\u016c\u016d\7+\2\2\u016dF\3\2\2\2\u016e\u016f"+
		"\7]\2\2\u016fH\3\2\2\2\u0170\u0171\7_\2\2\u0171J\3\2\2\2\u0172\u0173\7"+
		"}\2\2\u0173L\3\2\2\2\u0174\u0175\7\177\2\2\u0175N\3\2\2\2\u0176\u0177"+
		"\7>\2\2\u0177P\3\2\2\2\u0178\u0179\7>\2\2\u0179\u017a\7?\2\2\u017aR\3"+
		"\2\2\2\u017b\u017c\7@\2\2\u017cT\3\2\2\2\u017d\u017e\7@\2\2\u017e\u017f"+
		"\7?\2\2\u017fV\3\2\2\2\u0180\u0181\7>\2\2\u0181\u0182\7>\2\2\u0182X\3"+
		"\2\2\2\u0183\u0184\7@\2\2\u0184\u0185\7@\2\2\u0185Z\3\2\2\2\u0186\u0187"+
		"\7-\2\2\u0187\\\3\2\2\2\u0188\u0189\7-\2\2\u0189\u018a\7-\2\2\u018a^\3"+
		"\2\2\2\u018b\u018c\7/\2\2\u018c`\3\2\2\2\u018d\u018e\7/\2\2\u018e\u018f"+
		"\7/\2\2\u018fb\3\2\2\2\u0190\u0191\7,\2\2\u0191d\3\2\2\2\u0192\u0193\7"+
		"\61\2\2\u0193f\3\2\2\2\u0194\u0195\7\'\2\2\u0195h\3\2\2\2\u0196\u0197"+
		"\7(\2\2\u0197j\3\2\2\2\u0198\u0199\7~\2\2\u0199l\3\2\2\2\u019a\u019b\7"+
		"(\2\2\u019b\u019c\7(\2\2\u019cn\3\2\2\2\u019d\u019e\7~\2\2\u019e\u019f"+
		"\7~\2\2\u019fp\3\2\2\2\u01a0\u01a1\7`\2\2\u01a1r\3\2\2\2\u01a2\u01a3\7"+
		"#\2\2\u01a3t\3\2\2\2\u01a4\u01a5\7\u0080\2\2\u01a5v\3\2\2\2\u01a6\u01a7"+
		"\7A\2\2\u01a7x\3\2\2\2\u01a8\u01a9\7<\2\2\u01a9z\3\2\2\2\u01aa\u01ab\7"+
		"=\2\2\u01ab|\3\2\2\2\u01ac\u01ad\7.\2\2\u01ad~\3\2\2\2\u01ae\u01af\7?"+
		"\2\2\u01af\u0080\3\2\2\2\u01b0\u01b1\7?\2\2\u01b1\u01b2\7?\2\2\u01b2\u0082"+
		"\3\2\2\2\u01b3\u01b4\7#\2\2\u01b4\u01b5\7?\2\2\u01b5\u0084\3\2\2\2\u01b6"+
		"\u01b7\7/\2\2\u01b7\u01b8\7@\2\2\u01b8\u0086\3\2\2\2\u01b9\u01ba\7\60"+
		"\2\2\u01ba\u0088\3\2\2\2\u01bb\u01bc\7p\2\2\u01bc\u01bd\7g\2\2\u01bd\u01be"+
		"\7y\2\2\u01be\u008a\3\2\2\2\27\2\u00aa\u00ad\u00af\u00b8\u00be\u00c4\u00c8"+
		"\u00cf\u00d3\u00d9\u00dc\u00de\u00e4\u00e6\u00f1\u00f9\u00ff\u0102\u010c"+
		"\u0117\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}