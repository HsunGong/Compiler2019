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
		Identifier=1, IntegerLiteral=2, DigitSequence=3, StringLiteral=4, Whitespace=5, 
		Newline=6, LineCommnet=7, BlockComment=8, Break=9, Continue=10, Default=11, 
		Else=12, For=13, If=14, Int=15, String=16, Return=17, Class=18, Void=19, 
		While=20, Bool=21, LeftParen=22, RightParen=23, LeftBracket=24, RightBracket=25, 
		LeftBrace=26, RightBrace=27, Less=28, LessEqual=29, Greater=30, GreaterEqual=31, 
		LeftShift=32, RightShift=33, Plus=34, PlusPlus=35, Minus=36, MinusMinus=37, 
		Star=38, Div=39, Mod=40, And=41, Or=42, AndAnd=43, OrOr=44, Caret=45, 
		Not=46, Tilde=47, Question=48, Colon=49, Semi=50, Comma=51, Assign=52, 
		Equal=53, NotEqual=54, Arrow=55, Dot=56, New=57;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"Identifier", "Letter", "Digit", "IntegerLiteral", "DecimalConstant", 
			"DigitSequence", "IntegerSuffix", "StringLiteral", "SChar", "EscapeSequence", 
			"Whitespace", "Newline", "LineCommnet", "BlockComment", "Break", "Continue", 
			"Default", "Else", "For", "If", "Int", "String", "Return", "Class", "Void", 
			"While", "Bool", "LeftParen", "RightParen", "LeftBracket", "RightBracket", 
			"LeftBrace", "RightBrace", "Less", "LessEqual", "Greater", "GreaterEqual", 
			"LeftShift", "RightShift", "Plus", "PlusPlus", "Minus", "MinusMinus", 
			"Star", "Div", "Mod", "And", "Or", "AndAnd", "OrOr", "Caret", "Not", 
			"Tilde", "Question", "Colon", "Semi", "Comma", "Assign", "Equal", "NotEqual", 
			"Arrow", "Dot", "New"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, "'break'", "'continue'", 
			"'default'", "'else'", "'for'", "'if'", "'int'", "'String'", "'return'", 
			"'class'", "'void'", "'while'", "'bool'", "'('", "')'", "'['", "']'", 
			"'{'", "'}'", "'<'", "'<='", "'>'", "'>='", "'<<'", "'>>'", "'+'", "'++'", 
			"'-'", "'--'", "'*'", "'/'", "'%'", "'&'", "'|'", "'&&'", "'||'", "'^'", 
			"'!'", "'~'", "'?'", "':'", "';'", "','", "'='", "'=='", "'!='", "'->'", 
			"'.'", "'new'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "Identifier", "IntegerLiteral", "DigitSequence", "StringLiteral", 
			"Whitespace", "Newline", "LineCommnet", "BlockComment", "Break", "Continue", 
			"Default", "Else", "For", "If", "Int", "String", "Return", "Class", "Void", 
			"While", "Bool", "LeftParen", "RightParen", "LeftBracket", "RightBracket", 
			"LeftBrace", "RightBrace", "Less", "LessEqual", "Greater", "GreaterEqual", 
			"LeftShift", "RightShift", "Plus", "PlusPlus", "Minus", "MinusMinus", 
			"Star", "Div", "Mod", "And", "Or", "AndAnd", "OrOr", "Caret", "Not", 
			"Tilde", "Question", "Colon", "Semi", "Comma", "Assign", "Equal", "NotEqual", 
			"Arrow", "Dot", "New"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2;\u0199\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\3\2\3\2\3\2\5\2\u0085\n\2\3\2\7\2\u0088\n\2\f\2\16"+
		"\2\u008b\13\2\3\3\3\3\3\4\3\4\3\5\3\5\5\5\u0093\n\5\3\6\3\6\7\6\u0097"+
		"\n\6\f\6\16\6\u009a\13\6\3\7\6\7\u009d\n\7\r\7\16\7\u009e\3\b\3\b\5\b"+
		"\u00a3\n\b\3\b\3\b\3\b\3\b\3\b\5\b\u00aa\n\b\3\b\3\b\5\b\u00ae\n\b\3\b"+
		"\3\b\3\b\3\b\5\b\u00b4\n\b\3\b\5\b\u00b7\n\b\5\b\u00b9\n\b\3\t\3\t\6\t"+
		"\u00bd\n\t\r\t\16\t\u00be\5\t\u00c1\n\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\5\n\u00cc\n\n\3\13\3\13\3\13\3\f\6\f\u00d2\n\f\r\f\16\f\u00d3\3"+
		"\f\3\f\3\r\3\r\5\r\u00da\n\r\3\r\5\r\u00dd\n\r\3\r\3\r\3\16\3\16\3\16"+
		"\3\16\7\16\u00e5\n\16\f\16\16\16\u00e8\13\16\3\16\3\16\3\17\3\17\3\17"+
		"\3\17\7\17\u00f0\n\17\f\17\16\17\u00f3\13\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23"+
		"\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3"+
		"\"\3\"\3#\3#\3$\3$\3$\3%\3%\3&\3&\3&\3\'\3\'\3\'\3(\3(\3(\3)\3)\3*\3*"+
		"\3*\3+\3+\3,\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\62"+
		"\3\63\3\63\3\63\3\64\3\64\3\65\3\65\3\66\3\66\3\67\3\67\38\38\39\39\3"+
		":\3:\3;\3;\3<\3<\3<\3=\3=\3=\3>\3>\3>\3?\3?\3@\3@\3@\3@\3\u00f1\2A\3\3"+
		"\5\2\7\2\t\4\13\2\r\5\17\2\21\6\23\2\25\2\27\7\31\b\33\t\35\n\37\13!\f"+
		"#\r%\16\'\17)\20+\21-\22/\23\61\24\63\25\65\26\67\279\30;\31=\32?\33A"+
		"\34C\35E\36G\37I K!M\"O#Q$S%U&W\'Y([)]*_+a,c-e.g/i\60k\61m\62o\63q\64"+
		"s\65u\66w\67y8{9}:\177;\3\2\13\4\2C\\c|\3\2\62;\3\2\63;\4\2WWww\4\2NN"+
		"nn\6\2\f\f\17\17$$^^\f\2$$))AA^^cdhhppttvvxx\4\2\13\13\"\"\4\2\f\f\17"+
		"\17\2\u01aa\2\3\3\2\2\2\2\t\3\2\2\2\2\r\3\2\2\2\2\21\3\2\2\2\2\27\3\2"+
		"\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2"+
		"#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3"+
		"\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2"+
		"\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G"+
		"\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2"+
		"\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2"+
		"\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m"+
		"\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2"+
		"\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\3\u0081\3\2\2\2\5\u008c\3\2\2"+
		"\2\7\u008e\3\2\2\2\t\u0090\3\2\2\2\13\u0094\3\2\2\2\r\u009c\3\2\2\2\17"+
		"\u00b8\3\2\2\2\21\u00ba\3\2\2\2\23\u00cb\3\2\2\2\25\u00cd\3\2\2\2\27\u00d1"+
		"\3\2\2\2\31\u00dc\3\2\2\2\33\u00e0\3\2\2\2\35\u00eb\3\2\2\2\37\u00f9\3"+
		"\2\2\2!\u00ff\3\2\2\2#\u0108\3\2\2\2%\u0110\3\2\2\2\'\u0115\3\2\2\2)\u0119"+
		"\3\2\2\2+\u011c\3\2\2\2-\u0120\3\2\2\2/\u0127\3\2\2\2\61\u012e\3\2\2\2"+
		"\63\u0134\3\2\2\2\65\u0139\3\2\2\2\67\u013f\3\2\2\29\u0144\3\2\2\2;\u0146"+
		"\3\2\2\2=\u0148\3\2\2\2?\u014a\3\2\2\2A\u014c\3\2\2\2C\u014e\3\2\2\2E"+
		"\u0150\3\2\2\2G\u0152\3\2\2\2I\u0155\3\2\2\2K\u0157\3\2\2\2M\u015a\3\2"+
		"\2\2O\u015d\3\2\2\2Q\u0160\3\2\2\2S\u0162\3\2\2\2U\u0165\3\2\2\2W\u0167"+
		"\3\2\2\2Y\u016a\3\2\2\2[\u016c\3\2\2\2]\u016e\3\2\2\2_\u0170\3\2\2\2a"+
		"\u0172\3\2\2\2c\u0174\3\2\2\2e\u0177\3\2\2\2g\u017a\3\2\2\2i\u017c\3\2"+
		"\2\2k\u017e\3\2\2\2m\u0180\3\2\2\2o\u0182\3\2\2\2q\u0184\3\2\2\2s\u0186"+
		"\3\2\2\2u\u0188\3\2\2\2w\u018a\3\2\2\2y\u018d\3\2\2\2{\u0190\3\2\2\2}"+
		"\u0193\3\2\2\2\177\u0195\3\2\2\2\u0081\u0089\5\5\3\2\u0082\u0085\5\5\3"+
		"\2\u0083\u0085\7a\2\2\u0084\u0082\3\2\2\2\u0084\u0083\3\2\2\2\u0085\u0088"+
		"\3\2\2\2\u0086\u0088\5\7\4\2\u0087\u0084\3\2\2\2\u0087\u0086\3\2\2\2\u0088"+
		"\u008b\3\2\2\2\u0089\u0087\3\2\2\2\u0089\u008a\3\2\2\2\u008a\4\3\2\2\2"+
		"\u008b\u0089\3\2\2\2\u008c\u008d\t\2\2\2\u008d\6\3\2\2\2\u008e\u008f\t"+
		"\3\2\2\u008f\b\3\2\2\2\u0090\u0092\5\13\6\2\u0091\u0093\5\17\b\2\u0092"+
		"\u0091\3\2\2\2\u0092\u0093\3\2\2\2\u0093\n\3\2\2\2\u0094\u0098\t\4\2\2"+
		"\u0095\u0097\5\7\4\2\u0096\u0095\3\2\2\2\u0097\u009a\3\2\2\2\u0098\u0096"+
		"\3\2\2\2\u0098\u0099\3\2\2\2\u0099\f\3\2\2\2\u009a\u0098\3\2\2\2\u009b"+
		"\u009d\5\7\4\2\u009c\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u009c\3\2"+
		"\2\2\u009e\u009f\3\2\2\2\u009f\16\3\2\2\2\u00a0\u00a2\t\5\2\2\u00a1\u00a3"+
		"\t\6\2\2\u00a2\u00a1\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00b9\3\2\2\2\u00a4"+
		"\u00a9\t\5\2\2\u00a5\u00a6\7n\2\2\u00a6\u00aa\7n\2\2\u00a7\u00a8\7N\2"+
		"\2\u00a8\u00aa\7N\2\2\u00a9\u00a5\3\2\2\2\u00a9\u00a7\3\2\2\2\u00aa\u00b9"+
		"\3\2\2\2\u00ab\u00ad\t\6\2\2\u00ac\u00ae\t\5\2\2\u00ad\u00ac\3\2\2\2\u00ad"+
		"\u00ae\3\2\2\2\u00ae\u00b9\3\2\2\2\u00af\u00b0\7n\2\2\u00b0\u00b4\7n\2"+
		"\2\u00b1\u00b2\7N\2\2\u00b2\u00b4\7N\2\2\u00b3\u00af\3\2\2\2\u00b3\u00b1"+
		"\3\2\2\2\u00b4\u00b6\3\2\2\2\u00b5\u00b7\t\5\2\2\u00b6\u00b5\3\2\2\2\u00b6"+
		"\u00b7\3\2\2\2\u00b7\u00b9\3\2\2\2\u00b8\u00a0\3\2\2\2\u00b8\u00a4\3\2"+
		"\2\2\u00b8\u00ab\3\2\2\2\u00b8\u00b3\3\2\2\2\u00b9\20\3\2\2\2\u00ba\u00c0"+
		"\7$\2\2\u00bb\u00bd\5\23\n\2\u00bc\u00bb\3\2\2\2\u00bd\u00be\3\2\2\2\u00be"+
		"\u00bc\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\u00c1\3\2\2\2\u00c0\u00bc\3\2"+
		"\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c3\7$\2\2\u00c3"+
		"\22\3\2\2\2\u00c4\u00cc\n\7\2\2\u00c5\u00c6\7^\2\2\u00c6\u00cc\7\f\2\2"+
		"\u00c7\u00c8\7^\2\2\u00c8\u00c9\7\17\2\2\u00c9\u00cc\7\f\2\2\u00ca\u00cc"+
		"\5\25\13\2\u00cb\u00c4\3\2\2\2\u00cb\u00c5\3\2\2\2\u00cb\u00c7\3\2\2\2"+
		"\u00cb\u00ca\3\2\2\2\u00cc\24\3\2\2\2\u00cd\u00ce\7^\2\2\u00ce\u00cf\t"+
		"\b\2\2\u00cf\26\3\2\2\2\u00d0\u00d2\t\t\2\2\u00d1\u00d0\3\2\2\2\u00d2"+
		"\u00d3\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00d5\3\2"+
		"\2\2\u00d5\u00d6\b\f\2\2\u00d6\30\3\2\2\2\u00d7\u00d9\7\17\2\2\u00d8\u00da"+
		"\7\f\2\2\u00d9\u00d8\3\2\2\2\u00d9\u00da\3\2\2\2\u00da\u00dd\3\2\2\2\u00db"+
		"\u00dd\7\f\2\2\u00dc\u00d7\3\2\2\2\u00dc\u00db\3\2\2\2\u00dd\u00de\3\2"+
		"\2\2\u00de\u00df\b\r\2\2\u00df\32\3\2\2\2\u00e0\u00e1\7\61\2\2\u00e1\u00e2"+
		"\7\61\2\2\u00e2\u00e6\3\2\2\2\u00e3\u00e5\n\n\2\2\u00e4\u00e3\3\2\2\2"+
		"\u00e5\u00e8\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00e9"+
		"\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e9\u00ea\b\16\2\2\u00ea\34\3\2\2\2\u00eb"+
		"\u00ec\7\61\2\2\u00ec\u00ed\7,\2\2\u00ed\u00f1\3\2\2\2\u00ee\u00f0\13"+
		"\2\2\2\u00ef\u00ee\3\2\2\2\u00f0\u00f3\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f1"+
		"\u00ef\3\2\2\2\u00f2\u00f4\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f4\u00f5\7,"+
		"\2\2\u00f5\u00f6\7\61\2\2\u00f6\u00f7\3\2\2\2\u00f7\u00f8\b\17\2\2\u00f8"+
		"\36\3\2\2\2\u00f9\u00fa\7d\2\2\u00fa\u00fb\7t\2\2\u00fb\u00fc\7g\2\2\u00fc"+
		"\u00fd\7c\2\2\u00fd\u00fe\7m\2\2\u00fe \3\2\2\2\u00ff\u0100\7e\2\2\u0100"+
		"\u0101\7q\2\2\u0101\u0102\7p\2\2\u0102\u0103\7v\2\2\u0103\u0104\7k\2\2"+
		"\u0104\u0105\7p\2\2\u0105\u0106\7w\2\2\u0106\u0107\7g\2\2\u0107\"\3\2"+
		"\2\2\u0108\u0109\7f\2\2\u0109\u010a\7g\2\2\u010a\u010b\7h\2\2\u010b\u010c"+
		"\7c\2\2\u010c\u010d\7w\2\2\u010d\u010e\7n\2\2\u010e\u010f\7v\2\2\u010f"+
		"$\3\2\2\2\u0110\u0111\7g\2\2\u0111\u0112\7n\2\2\u0112\u0113\7u\2\2\u0113"+
		"\u0114\7g\2\2\u0114&\3\2\2\2\u0115\u0116\7h\2\2\u0116\u0117\7q\2\2\u0117"+
		"\u0118\7t\2\2\u0118(\3\2\2\2\u0119\u011a\7k\2\2\u011a\u011b\7h\2\2\u011b"+
		"*\3\2\2\2\u011c\u011d\7k\2\2\u011d\u011e\7p\2\2\u011e\u011f\7v\2\2\u011f"+
		",\3\2\2\2\u0120\u0121\7U\2\2\u0121\u0122\7v\2\2\u0122\u0123\7t\2\2\u0123"+
		"\u0124\7k\2\2\u0124\u0125\7p\2\2\u0125\u0126\7i\2\2\u0126.\3\2\2\2\u0127"+
		"\u0128\7t\2\2\u0128\u0129\7g\2\2\u0129\u012a\7v\2\2\u012a\u012b\7w\2\2"+
		"\u012b\u012c\7t\2\2\u012c\u012d\7p\2\2\u012d\60\3\2\2\2\u012e\u012f\7"+
		"e\2\2\u012f\u0130\7n\2\2\u0130\u0131\7c\2\2\u0131\u0132\7u\2\2\u0132\u0133"+
		"\7u\2\2\u0133\62\3\2\2\2\u0134\u0135\7x\2\2\u0135\u0136\7q\2\2\u0136\u0137"+
		"\7k\2\2\u0137\u0138\7f\2\2\u0138\64\3\2\2\2\u0139\u013a\7y\2\2\u013a\u013b"+
		"\7j\2\2\u013b\u013c\7k\2\2\u013c\u013d\7n\2\2\u013d\u013e\7g\2\2\u013e"+
		"\66\3\2\2\2\u013f\u0140\7d\2\2\u0140\u0141\7q\2\2\u0141\u0142\7q\2\2\u0142"+
		"\u0143\7n\2\2\u01438\3\2\2\2\u0144\u0145\7*\2\2\u0145:\3\2\2\2\u0146\u0147"+
		"\7+\2\2\u0147<\3\2\2\2\u0148\u0149\7]\2\2\u0149>\3\2\2\2\u014a\u014b\7"+
		"_\2\2\u014b@\3\2\2\2\u014c\u014d\7}\2\2\u014dB\3\2\2\2\u014e\u014f\7\177"+
		"\2\2\u014fD\3\2\2\2\u0150\u0151\7>\2\2\u0151F\3\2\2\2\u0152\u0153\7>\2"+
		"\2\u0153\u0154\7?\2\2\u0154H\3\2\2\2\u0155\u0156\7@\2\2\u0156J\3\2\2\2"+
		"\u0157\u0158\7@\2\2\u0158\u0159\7?\2\2\u0159L\3\2\2\2\u015a\u015b\7>\2"+
		"\2\u015b\u015c\7>\2\2\u015cN\3\2\2\2\u015d\u015e\7@\2\2\u015e\u015f\7"+
		"@\2\2\u015fP\3\2\2\2\u0160\u0161\7-\2\2\u0161R\3\2\2\2\u0162\u0163\7-"+
		"\2\2\u0163\u0164\7-\2\2\u0164T\3\2\2\2\u0165\u0166\7/\2\2\u0166V\3\2\2"+
		"\2\u0167\u0168\7/\2\2\u0168\u0169\7/\2\2\u0169X\3\2\2\2\u016a\u016b\7"+
		",\2\2\u016bZ\3\2\2\2\u016c\u016d\7\61\2\2\u016d\\\3\2\2\2\u016e\u016f"+
		"\7\'\2\2\u016f^\3\2\2\2\u0170\u0171\7(\2\2\u0171`\3\2\2\2\u0172\u0173"+
		"\7~\2\2\u0173b\3\2\2\2\u0174\u0175\7(\2\2\u0175\u0176\7(\2\2\u0176d\3"+
		"\2\2\2\u0177\u0178\7~\2\2\u0178\u0179\7~\2\2\u0179f\3\2\2\2\u017a\u017b"+
		"\7`\2\2\u017bh\3\2\2\2\u017c\u017d\7#\2\2\u017dj\3\2\2\2\u017e\u017f\7"+
		"\u0080\2\2\u017fl\3\2\2\2\u0180\u0181\7A\2\2\u0181n\3\2\2\2\u0182\u0183"+
		"\7<\2\2\u0183p\3\2\2\2\u0184\u0185\7=\2\2\u0185r\3\2\2\2\u0186\u0187\7"+
		".\2\2\u0187t\3\2\2\2\u0188\u0189\7?\2\2\u0189v\3\2\2\2\u018a\u018b\7?"+
		"\2\2\u018b\u018c\7?\2\2\u018cx\3\2\2\2\u018d\u018e\7#\2\2\u018e\u018f"+
		"\7?\2\2\u018fz\3\2\2\2\u0190\u0191\7/\2\2\u0191\u0192\7@\2\2\u0192|\3"+
		"\2\2\2\u0193\u0194\7\60\2\2\u0194~\3\2\2\2\u0195\u0196\7p\2\2\u0196\u0197"+
		"\7g\2\2\u0197\u0198\7y\2\2\u0198\u0080\3\2\2\2\27\2\u0084\u0087\u0089"+
		"\u0092\u0098\u009e\u00a2\u00a9\u00ad\u00b3\u00b6\u00b8\u00be\u00c0\u00cb"+
		"\u00d3\u00d9\u00dc\u00e6\u00f1\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}