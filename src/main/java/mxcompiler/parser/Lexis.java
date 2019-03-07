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
		Identifier=1, IntegerLiteral=2, StringLiteral=3, Whitespace=4, Newline=5, 
		LineCommnet=6, BlockComment=7, Break=8, Continue=9, Default=10, Else=11, 
		For=12, If=13, Int=14, Long=15, String=16, Return=17, Class=18, Void=19, 
		While=20, Bool=21, Noreturn=22, LeftParen=23, RightParen=24, LeftBracket=25, 
		RightBracket=26, LeftBrace=27, RightBrace=28, Less=29, LessEqual=30, Greater=31, 
		GreaterEqual=32, LeftShift=33, RightShift=34, Plus=35, PlusPlus=36, Minus=37, 
		MinusMinus=38, Star=39, Div=40, Mod=41, And=42, Or=43, AndAnd=44, OrOr=45, 
		Caret=46, Not=47, Tilde=48, Question=49, Colon=50, Semi=51, Comma=52, 
		Assign=53, Equal=54, NotEqual=55, Arrow=56, Dot=57, Ellipsis=58;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"Identifier", "Letter", "Digit", "IntegerLiteral", "DecimalConstant", 
			"IntegerSuffix", "StringLiteral", "Char", "EscapeSequence", "Whitespace", 
			"Newline", "LineCommnet", "BlockComment", "Break", "Continue", "Default", 
			"Else", "For", "If", "Int", "Long", "String", "Return", "Class", "Void", 
			"While", "Bool", "Noreturn", "LeftParen", "RightParen", "LeftBracket", 
			"RightBracket", "LeftBrace", "RightBrace", "Less", "LessEqual", "Greater", 
			"GreaterEqual", "LeftShift", "RightShift", "Plus", "PlusPlus", "Minus", 
			"MinusMinus", "Star", "Div", "Mod", "And", "Or", "AndAnd", "OrOr", "Caret", 
			"Not", "Tilde", "Question", "Colon", "Semi", "Comma", "Assign", "Equal", 
			"NotEqual", "Arrow", "Dot", "Ellipsis"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, "'break'", "'continue'", 
			"'default'", "'else'", "'for'", "'if'", "'int'", "'long'", "'String'", 
			"'return'", "'class'", "'void'", "'while'", "'_Bool'", "'_Noreturn'", 
			"'('", "')'", "'['", "']'", "'{'", "'}'", "'<'", "'<='", "'>'", "'>='", 
			"'<<'", "'>>'", "'+'", "'++'", "'-'", "'--'", "'*'", "'/'", "'%'", "'&'", 
			"'|'", "'&&'", "'||'", "'^'", "'!'", "'~'", "'?'", "':'", "';'", "','", 
			"'='", "'=='", "'!='", "'->'", "'.'", "'...'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "Identifier", "IntegerLiteral", "StringLiteral", "Whitespace", 
			"Newline", "LineCommnet", "BlockComment", "Break", "Continue", "Default", 
			"Else", "For", "If", "Int", "Long", "String", "Return", "Class", "Void", 
			"While", "Bool", "Noreturn", "LeftParen", "RightParen", "LeftBracket", 
			"RightBracket", "LeftBrace", "RightBrace", "Less", "LessEqual", "Greater", 
			"GreaterEqual", "LeftShift", "RightShift", "Plus", "PlusPlus", "Minus", 
			"MinusMinus", "Star", "Div", "Mod", "And", "Or", "AndAnd", "OrOr", "Caret", 
			"Not", "Tilde", "Question", "Colon", "Semi", "Comma", "Assign", "Equal", 
			"NotEqual", "Arrow", "Dot", "Ellipsis"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2<\u01a6\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\3\2\3\2\3\2\5\2\u0087\n\2\3\2\7\2\u008a\n\2\f"+
		"\2\16\2\u008d\13\2\3\3\3\3\3\4\3\4\3\5\3\5\5\5\u0095\n\5\3\6\3\6\7\6\u0099"+
		"\n\6\f\6\16\6\u009c\13\6\3\7\3\7\5\7\u00a0\n\7\3\7\3\7\3\7\3\7\3\7\5\7"+
		"\u00a7\n\7\3\7\3\7\5\7\u00ab\n\7\3\7\3\7\3\7\3\7\5\7\u00b1\n\7\3\7\5\7"+
		"\u00b4\n\7\5\7\u00b6\n\7\3\b\3\b\6\b\u00ba\n\b\r\b\16\b\u00bb\5\b\u00be"+
		"\n\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u00c9\n\t\3\n\3\n\3\n\3\13"+
		"\6\13\u00cf\n\13\r\13\16\13\u00d0\3\13\3\13\3\f\3\f\5\f\u00d7\n\f\3\f"+
		"\5\f\u00da\n\f\3\f\3\f\3\r\3\r\3\r\3\r\7\r\u00e2\n\r\f\r\16\r\u00e5\13"+
		"\r\3\r\3\r\3\16\3\16\3\16\3\16\7\16\u00ed\n\16\f\16\16\16\u00f0\13\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25"+
		"\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\32"+
		"\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36"+
		"\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3%\3&\3&\3\'\3\'\3\'"+
		"\3(\3(\3(\3)\3)\3)\3*\3*\3+\3+\3+\3,\3,\3-\3-\3-\3.\3.\3/\3/\3\60\3\60"+
		"\3\61\3\61\3\62\3\62\3\63\3\63\3\63\3\64\3\64\3\64\3\65\3\65\3\66\3\66"+
		"\3\67\3\67\38\38\39\39\3:\3:\3;\3;\3<\3<\3=\3=\3=\3>\3>\3>\3?\3?\3?\3"+
		"@\3@\3A\3A\3A\3A\3\u00ee\2B\3\3\5\2\7\2\t\4\13\2\r\2\17\5\21\2\23\2\25"+
		"\6\27\7\31\b\33\t\35\n\37\13!\f#\r%\16\'\17)\20+\21-\22/\23\61\24\63\25"+
		"\65\26\67\279\30;\31=\32?\33A\34C\35E\36G\37I K!M\"O#Q$S%U&W\'Y([)]*_"+
		"+a,c-e.g/i\60k\61m\62o\63q\64s\65u\66w\67y8{9}:\177;\u0081<\3\2\13\4\2"+
		"C\\c|\3\2\62;\3\2\63;\4\2WWww\4\2NNnn\6\2\f\f\17\17$$^^\f\2$$))AA^^cd"+
		"hhppttvvxx\4\2\13\13\"\"\4\2\f\f\17\17\2\u01b6\2\3\3\2\2\2\2\t\3\2\2\2"+
		"\2\17\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35"+
		"\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)"+
		"\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2"+
		"\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2"+
		"A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3"+
		"\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2"+
		"\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2"+
		"g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3"+
		"\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177\3"+
		"\2\2\2\2\u0081\3\2\2\2\3\u0083\3\2\2\2\5\u008e\3\2\2\2\7\u0090\3\2\2\2"+
		"\t\u0092\3\2\2\2\13\u0096\3\2\2\2\r\u00b5\3\2\2\2\17\u00b7\3\2\2\2\21"+
		"\u00c8\3\2\2\2\23\u00ca\3\2\2\2\25\u00ce\3\2\2\2\27\u00d9\3\2\2\2\31\u00dd"+
		"\3\2\2\2\33\u00e8\3\2\2\2\35\u00f6\3\2\2\2\37\u00fc\3\2\2\2!\u0105\3\2"+
		"\2\2#\u010d\3\2\2\2%\u0112\3\2\2\2\'\u0116\3\2\2\2)\u0119\3\2\2\2+\u011d"+
		"\3\2\2\2-\u0122\3\2\2\2/\u0129\3\2\2\2\61\u0130\3\2\2\2\63\u0136\3\2\2"+
		"\2\65\u013b\3\2\2\2\67\u0141\3\2\2\29\u0147\3\2\2\2;\u0151\3\2\2\2=\u0153"+
		"\3\2\2\2?\u0155\3\2\2\2A\u0157\3\2\2\2C\u0159\3\2\2\2E\u015b\3\2\2\2G"+
		"\u015d\3\2\2\2I\u015f\3\2\2\2K\u0162\3\2\2\2M\u0164\3\2\2\2O\u0167\3\2"+
		"\2\2Q\u016a\3\2\2\2S\u016d\3\2\2\2U\u016f\3\2\2\2W\u0172\3\2\2\2Y\u0174"+
		"\3\2\2\2[\u0177\3\2\2\2]\u0179\3\2\2\2_\u017b\3\2\2\2a\u017d\3\2\2\2c"+
		"\u017f\3\2\2\2e\u0181\3\2\2\2g\u0184\3\2\2\2i\u0187\3\2\2\2k\u0189\3\2"+
		"\2\2m\u018b\3\2\2\2o\u018d\3\2\2\2q\u018f\3\2\2\2s\u0191\3\2\2\2u\u0193"+
		"\3\2\2\2w\u0195\3\2\2\2y\u0197\3\2\2\2{\u019a\3\2\2\2}\u019d\3\2\2\2\177"+
		"\u01a0\3\2\2\2\u0081\u01a2\3\2\2\2\u0083\u008b\5\5\3\2\u0084\u0087\5\5"+
		"\3\2\u0085\u0087\7a\2\2\u0086\u0084\3\2\2\2\u0086\u0085\3\2\2\2\u0087"+
		"\u008a\3\2\2\2\u0088\u008a\5\7\4\2\u0089\u0086\3\2\2\2\u0089\u0088\3\2"+
		"\2\2\u008a\u008d\3\2\2\2\u008b\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c"+
		"\4\3\2\2\2\u008d\u008b\3\2\2\2\u008e\u008f\t\2\2\2\u008f\6\3\2\2\2\u0090"+
		"\u0091\t\3\2\2\u0091\b\3\2\2\2\u0092\u0094\5\13\6\2\u0093\u0095\5\r\7"+
		"\2\u0094\u0093\3\2\2\2\u0094\u0095\3\2\2\2\u0095\n\3\2\2\2\u0096\u009a"+
		"\t\4\2\2\u0097\u0099\5\7\4\2\u0098\u0097\3\2\2\2\u0099\u009c\3\2\2\2\u009a"+
		"\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b\f\3\2\2\2\u009c\u009a\3\2\2\2"+
		"\u009d\u009f\t\5\2\2\u009e\u00a0\t\6\2\2\u009f\u009e\3\2\2\2\u009f\u00a0"+
		"\3\2\2\2\u00a0\u00b6\3\2\2\2\u00a1\u00a6\t\5\2\2\u00a2\u00a3\7n\2\2\u00a3"+
		"\u00a7\7n\2\2\u00a4\u00a5\7N\2\2\u00a5\u00a7\7N\2\2\u00a6\u00a2\3\2\2"+
		"\2\u00a6\u00a4\3\2\2\2\u00a7\u00b6\3\2\2\2\u00a8\u00aa\t\6\2\2\u00a9\u00ab"+
		"\t\5\2\2\u00aa\u00a9\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00b6\3\2\2\2\u00ac"+
		"\u00ad\7n\2\2\u00ad\u00b1\7n\2\2\u00ae\u00af\7N\2\2\u00af\u00b1\7N\2\2"+
		"\u00b0\u00ac\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b1\u00b3\3\2\2\2\u00b2\u00b4"+
		"\t\5\2\2\u00b3\u00b2\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b6\3\2\2\2\u00b5"+
		"\u009d\3\2\2\2\u00b5\u00a1\3\2\2\2\u00b5\u00a8\3\2\2\2\u00b5\u00b0\3\2"+
		"\2\2\u00b6\16\3\2\2\2\u00b7\u00bd\7$\2\2\u00b8\u00ba\5\21\t\2\u00b9\u00b8"+
		"\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc"+
		"\u00be\3\2\2\2\u00bd\u00b9\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\u00bf\3\2"+
		"\2\2\u00bf\u00c0\7$\2\2\u00c0\20\3\2\2\2\u00c1\u00c9\n\7\2\2\u00c2\u00c3"+
		"\7^\2\2\u00c3\u00c9\7\f\2\2\u00c4\u00c5\7^\2\2\u00c5\u00c6\7\17\2\2\u00c6"+
		"\u00c9\7\f\2\2\u00c7\u00c9\5\23\n\2\u00c8\u00c1\3\2\2\2\u00c8\u00c2\3"+
		"\2\2\2\u00c8\u00c4\3\2\2\2\u00c8\u00c7\3\2\2\2\u00c9\22\3\2\2\2\u00ca"+
		"\u00cb\7^\2\2\u00cb\u00cc\t\b\2\2\u00cc\24\3\2\2\2\u00cd\u00cf\t\t\2\2"+
		"\u00ce\u00cd\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d0\u00d1"+
		"\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d3\b\13\2\2\u00d3\26\3\2\2\2\u00d4"+
		"\u00d6\7\17\2\2\u00d5\u00d7\7\f\2\2\u00d6\u00d5\3\2\2\2\u00d6\u00d7\3"+
		"\2\2\2\u00d7\u00da\3\2\2\2\u00d8\u00da\7\f\2\2\u00d9\u00d4\3\2\2\2\u00d9"+
		"\u00d8\3\2\2\2\u00da\u00db\3\2\2\2\u00db\u00dc\b\f\2\2\u00dc\30\3\2\2"+
		"\2\u00dd\u00de\7\61\2\2\u00de\u00df\7\61\2\2\u00df\u00e3\3\2\2\2\u00e0"+
		"\u00e2\n\n\2\2\u00e1\u00e0\3\2\2\2\u00e2\u00e5\3\2\2\2\u00e3\u00e1\3\2"+
		"\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e6\3\2\2\2\u00e5\u00e3\3\2\2\2\u00e6"+
		"\u00e7\b\r\2\2\u00e7\32\3\2\2\2\u00e8\u00e9\7\61\2\2\u00e9\u00ea\7,\2"+
		"\2\u00ea\u00ee\3\2\2\2\u00eb\u00ed\13\2\2\2\u00ec\u00eb\3\2\2\2\u00ed"+
		"\u00f0\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ef\u00f1\3\2"+
		"\2\2\u00f0\u00ee\3\2\2\2\u00f1\u00f2\7,\2\2\u00f2\u00f3\7\61\2\2\u00f3"+
		"\u00f4\3\2\2\2\u00f4\u00f5\b\16\2\2\u00f5\34\3\2\2\2\u00f6\u00f7\7d\2"+
		"\2\u00f7\u00f8\7t\2\2\u00f8\u00f9\7g\2\2\u00f9\u00fa\7c\2\2\u00fa\u00fb"+
		"\7m\2\2\u00fb\36\3\2\2\2\u00fc\u00fd\7e\2\2\u00fd\u00fe\7q\2\2\u00fe\u00ff"+
		"\7p\2\2\u00ff\u0100\7v\2\2\u0100\u0101\7k\2\2\u0101\u0102\7p\2\2\u0102"+
		"\u0103\7w\2\2\u0103\u0104\7g\2\2\u0104 \3\2\2\2\u0105\u0106\7f\2\2\u0106"+
		"\u0107\7g\2\2\u0107\u0108\7h\2\2\u0108\u0109\7c\2\2\u0109\u010a\7w\2\2"+
		"\u010a\u010b\7n\2\2\u010b\u010c\7v\2\2\u010c\"\3\2\2\2\u010d\u010e\7g"+
		"\2\2\u010e\u010f\7n\2\2\u010f\u0110\7u\2\2\u0110\u0111\7g\2\2\u0111$\3"+
		"\2\2\2\u0112\u0113\7h\2\2\u0113\u0114\7q\2\2\u0114\u0115\7t\2\2\u0115"+
		"&\3\2\2\2\u0116\u0117\7k\2\2\u0117\u0118\7h\2\2\u0118(\3\2\2\2\u0119\u011a"+
		"\7k\2\2\u011a\u011b\7p\2\2\u011b\u011c\7v\2\2\u011c*\3\2\2\2\u011d\u011e"+
		"\7n\2\2\u011e\u011f\7q\2\2\u011f\u0120\7p\2\2\u0120\u0121\7i\2\2\u0121"+
		",\3\2\2\2\u0122\u0123\7U\2\2\u0123\u0124\7v\2\2\u0124\u0125\7t\2\2\u0125"+
		"\u0126\7k\2\2\u0126\u0127\7p\2\2\u0127\u0128\7i\2\2\u0128.\3\2\2\2\u0129"+
		"\u012a\7t\2\2\u012a\u012b\7g\2\2\u012b\u012c\7v\2\2\u012c\u012d\7w\2\2"+
		"\u012d\u012e\7t\2\2\u012e\u012f\7p\2\2\u012f\60\3\2\2\2\u0130\u0131\7"+
		"e\2\2\u0131\u0132\7n\2\2\u0132\u0133\7c\2\2\u0133\u0134\7u\2\2\u0134\u0135"+
		"\7u\2\2\u0135\62\3\2\2\2\u0136\u0137\7x\2\2\u0137\u0138\7q\2\2\u0138\u0139"+
		"\7k\2\2\u0139\u013a\7f\2\2\u013a\64\3\2\2\2\u013b\u013c\7y\2\2\u013c\u013d"+
		"\7j\2\2\u013d\u013e\7k\2\2\u013e\u013f\7n\2\2\u013f\u0140\7g\2\2\u0140"+
		"\66\3\2\2\2\u0141\u0142\7a\2\2\u0142\u0143\7D\2\2\u0143\u0144\7q\2\2\u0144"+
		"\u0145\7q\2\2\u0145\u0146\7n\2\2\u01468\3\2\2\2\u0147\u0148\7a\2\2\u0148"+
		"\u0149\7P\2\2\u0149\u014a\7q\2\2\u014a\u014b\7t\2\2\u014b\u014c\7g\2\2"+
		"\u014c\u014d\7v\2\2\u014d\u014e\7w\2\2\u014e\u014f\7t\2\2\u014f\u0150"+
		"\7p\2\2\u0150:\3\2\2\2\u0151\u0152\7*\2\2\u0152<\3\2\2\2\u0153\u0154\7"+
		"+\2\2\u0154>\3\2\2\2\u0155\u0156\7]\2\2\u0156@\3\2\2\2\u0157\u0158\7_"+
		"\2\2\u0158B\3\2\2\2\u0159\u015a\7}\2\2\u015aD\3\2\2\2\u015b\u015c\7\177"+
		"\2\2\u015cF\3\2\2\2\u015d\u015e\7>\2\2\u015eH\3\2\2\2\u015f\u0160\7>\2"+
		"\2\u0160\u0161\7?\2\2\u0161J\3\2\2\2\u0162\u0163\7@\2\2\u0163L\3\2\2\2"+
		"\u0164\u0165\7@\2\2\u0165\u0166\7?\2\2\u0166N\3\2\2\2\u0167\u0168\7>\2"+
		"\2\u0168\u0169\7>\2\2\u0169P\3\2\2\2\u016a\u016b\7@\2\2\u016b\u016c\7"+
		"@\2\2\u016cR\3\2\2\2\u016d\u016e\7-\2\2\u016eT\3\2\2\2\u016f\u0170\7-"+
		"\2\2\u0170\u0171\7-\2\2\u0171V\3\2\2\2\u0172\u0173\7/\2\2\u0173X\3\2\2"+
		"\2\u0174\u0175\7/\2\2\u0175\u0176\7/\2\2\u0176Z\3\2\2\2\u0177\u0178\7"+
		",\2\2\u0178\\\3\2\2\2\u0179\u017a\7\61\2\2\u017a^\3\2\2\2\u017b\u017c"+
		"\7\'\2\2\u017c`\3\2\2\2\u017d\u017e\7(\2\2\u017eb\3\2\2\2\u017f\u0180"+
		"\7~\2\2\u0180d\3\2\2\2\u0181\u0182\7(\2\2\u0182\u0183\7(\2\2\u0183f\3"+
		"\2\2\2\u0184\u0185\7~\2\2\u0185\u0186\7~\2\2\u0186h\3\2\2\2\u0187\u0188"+
		"\7`\2\2\u0188j\3\2\2\2\u0189\u018a\7#\2\2\u018al\3\2\2\2\u018b\u018c\7"+
		"\u0080\2\2\u018cn\3\2\2\2\u018d\u018e\7A\2\2\u018ep\3\2\2\2\u018f\u0190"+
		"\7<\2\2\u0190r\3\2\2\2\u0191\u0192\7=\2\2\u0192t\3\2\2\2\u0193\u0194\7"+
		".\2\2\u0194v\3\2\2\2\u0195\u0196\7?\2\2\u0196x\3\2\2\2\u0197\u0198\7?"+
		"\2\2\u0198\u0199\7?\2\2\u0199z\3\2\2\2\u019a\u019b\7#\2\2\u019b\u019c"+
		"\7?\2\2\u019c|\3\2\2\2\u019d\u019e\7/\2\2\u019e\u019f\7@\2\2\u019f~\3"+
		"\2\2\2\u01a0\u01a1\7\60\2\2\u01a1\u0080\3\2\2\2\u01a2\u01a3\7\60\2\2\u01a3"+
		"\u01a4\7\60\2\2\u01a4\u01a5\7\60\2\2\u01a5\u0082\3\2\2\2\26\2\u0086\u0089"+
		"\u008b\u0094\u009a\u009f\u00a6\u00aa\u00b0\u00b3\u00b5\u00bb\u00bd\u00c8"+
		"\u00d0\u00d6\u00d9\u00e3\u00ee\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}