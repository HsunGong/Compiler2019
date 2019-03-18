// Generated from /home/xun/Documents/mxc/src/main/java/mxcompiler/parser/grammar/Mx.g4 by ANTLR 4.7.2
package mxcompiler.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MxParser extends Parser {
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
	public static final int
		RULE_compilationUnit = 0, RULE_translationUnit = 1, RULE_logicalOrExpression = 2, 
		RULE_logicalAndExpression = 3, RULE_binaryOrExpression = 4, RULE_binaryNorExpression = 5, 
		RULE_binaryAndExpression = 6, RULE_equalExpression = 7, RULE_compareExpression = 8, 
		RULE_shiftExpression = 9, RULE_addExpression = 10, RULE_multiExpression = 11, 
		RULE_term = 12, RULE_unaryExpression = 13, RULE_unaryOperator = 14, RULE_postfixExpression = 15, 
		RULE_args = 16, RULE_primaryExpression = 17, RULE_expression10 = 18, RULE_expression = 19, 
		RULE_variableDeclaration = 20, RULE_variableDeclarator = 21, RULE_newExpression = 22, 
		RULE_type = 23, RULE_typeName = 24, RULE_typedefName = 25, RULE_directDeclarator = 26, 
		RULE_statement = 27, RULE_block = 28, RULE_forCondition = 29, RULE_forDeclaration = 30, 
		RULE_functionDeclaration = 31, RULE_functionDeclarator = 32, RULE_parameterList = 33, 
		RULE_parameterDeclaration = 34, RULE_classDeclaration = 35, RULE_classBody = 36;
	private static String[] makeRuleNames() {
		return new String[] {
			"compilationUnit", "translationUnit", "logicalOrExpression", "logicalAndExpression", 
			"binaryOrExpression", "binaryNorExpression", "binaryAndExpression", "equalExpression", 
			"compareExpression", "shiftExpression", "addExpression", "multiExpression", 
			"term", "unaryExpression", "unaryOperator", "postfixExpression", "args", 
			"primaryExpression", "expression10", "expression", "variableDeclaration", 
			"variableDeclarator", "newExpression", "type", "typeName", "typedefName", 
			"directDeclarator", "statement", "block", "forCondition", "forDeclaration", 
			"functionDeclaration", "functionDeclarator", "parameterList", "parameterDeclaration", 
			"classDeclaration", "classBody"
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

	@Override
	public String getGrammarFileName() { return "Mx.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MxParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class CompilationUnitContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(MxParser.EOF, 0); }
		public List<TranslationUnitContext> translationUnit() {
			return getRuleContexts(TranslationUnitContext.class);
		}
		public TranslationUnitContext translationUnit(int i) {
			return getRuleContext(TranslationUnitContext.class,i);
		}
		public CompilationUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compilationUnit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterCompilationUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitCompilationUnit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitCompilationUnit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompilationUnitContext compilationUnit() throws RecognitionException {
		CompilationUnitContext _localctx = new CompilationUnitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_compilationUnit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << Identifier) | (1L << Int) | (1L << Class) | (1L << Void) | (1L << Bool) | (1L << Semi))) != 0)) {
				{
				{
				setState(74);
				translationUnit();
				}
				}
				setState(79);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(80);
			match(EOF);
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

	public static class TranslationUnitContext extends ParserRuleContext {
		public FunctionDeclarationContext functionDeclaration() {
			return getRuleContext(FunctionDeclarationContext.class,0);
		}
		public ClassDeclarationContext classDeclaration() {
			return getRuleContext(ClassDeclarationContext.class,0);
		}
		public VariableDeclarationContext variableDeclaration() {
			return getRuleContext(VariableDeclarationContext.class,0);
		}
		public TerminalNode Semi() { return getToken(MxParser.Semi, 0); }
		public TranslationUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_translationUnit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterTranslationUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitTranslationUnit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitTranslationUnit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TranslationUnitContext translationUnit() throws RecognitionException {
		TranslationUnitContext _localctx = new TranslationUnitContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_translationUnit);
		try {
			setState(86);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(82);
				functionDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(83);
				classDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(84);
				variableDeclaration();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(85);
				match(Semi);
				}
				break;
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

	public static class LogicalOrExpressionContext extends ParserRuleContext {
		public List<LogicalAndExpressionContext> logicalAndExpression() {
			return getRuleContexts(LogicalAndExpressionContext.class);
		}
		public LogicalAndExpressionContext logicalAndExpression(int i) {
			return getRuleContext(LogicalAndExpressionContext.class,i);
		}
		public List<TerminalNode> OrOr() { return getTokens(MxParser.OrOr); }
		public TerminalNode OrOr(int i) {
			return getToken(MxParser.OrOr, i);
		}
		public LogicalOrExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalOrExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterLogicalOrExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitLogicalOrExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitLogicalOrExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicalOrExpressionContext logicalOrExpression() throws RecognitionException {
		LogicalOrExpressionContext _localctx = new LogicalOrExpressionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_logicalOrExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			logicalAndExpression();
			setState(93);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OrOr) {
				{
				{
				setState(89);
				match(OrOr);
				setState(90);
				logicalAndExpression();
				}
				}
				setState(95);
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

	public static class LogicalAndExpressionContext extends ParserRuleContext {
		public List<BinaryOrExpressionContext> binaryOrExpression() {
			return getRuleContexts(BinaryOrExpressionContext.class);
		}
		public BinaryOrExpressionContext binaryOrExpression(int i) {
			return getRuleContext(BinaryOrExpressionContext.class,i);
		}
		public List<TerminalNode> AndAnd() { return getTokens(MxParser.AndAnd); }
		public TerminalNode AndAnd(int i) {
			return getToken(MxParser.AndAnd, i);
		}
		public LogicalAndExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalAndExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterLogicalAndExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitLogicalAndExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitLogicalAndExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicalAndExpressionContext logicalAndExpression() throws RecognitionException {
		LogicalAndExpressionContext _localctx = new LogicalAndExpressionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_logicalAndExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			binaryOrExpression();
			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AndAnd) {
				{
				{
				setState(97);
				match(AndAnd);
				setState(98);
				binaryOrExpression();
				}
				}
				setState(103);
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

	public static class BinaryOrExpressionContext extends ParserRuleContext {
		public List<BinaryNorExpressionContext> binaryNorExpression() {
			return getRuleContexts(BinaryNorExpressionContext.class);
		}
		public BinaryNorExpressionContext binaryNorExpression(int i) {
			return getRuleContext(BinaryNorExpressionContext.class,i);
		}
		public List<TerminalNode> Or() { return getTokens(MxParser.Or); }
		public TerminalNode Or(int i) {
			return getToken(MxParser.Or, i);
		}
		public BinaryOrExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binaryOrExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterBinaryOrExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitBinaryOrExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitBinaryOrExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BinaryOrExpressionContext binaryOrExpression() throws RecognitionException {
		BinaryOrExpressionContext _localctx = new BinaryOrExpressionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_binaryOrExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			binaryNorExpression();
			setState(109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Or) {
				{
				{
				setState(105);
				match(Or);
				setState(106);
				binaryNorExpression();
				}
				}
				setState(111);
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

	public static class BinaryNorExpressionContext extends ParserRuleContext {
		public List<BinaryAndExpressionContext> binaryAndExpression() {
			return getRuleContexts(BinaryAndExpressionContext.class);
		}
		public BinaryAndExpressionContext binaryAndExpression(int i) {
			return getRuleContext(BinaryAndExpressionContext.class,i);
		}
		public List<TerminalNode> Caret() { return getTokens(MxParser.Caret); }
		public TerminalNode Caret(int i) {
			return getToken(MxParser.Caret, i);
		}
		public BinaryNorExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binaryNorExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterBinaryNorExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitBinaryNorExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitBinaryNorExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BinaryNorExpressionContext binaryNorExpression() throws RecognitionException {
		BinaryNorExpressionContext _localctx = new BinaryNorExpressionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_binaryNorExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			binaryAndExpression();
			setState(117);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Caret) {
				{
				{
				setState(113);
				match(Caret);
				setState(114);
				binaryAndExpression();
				}
				}
				setState(119);
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

	public static class BinaryAndExpressionContext extends ParserRuleContext {
		public List<EqualExpressionContext> equalExpression() {
			return getRuleContexts(EqualExpressionContext.class);
		}
		public EqualExpressionContext equalExpression(int i) {
			return getRuleContext(EqualExpressionContext.class,i);
		}
		public List<TerminalNode> And() { return getTokens(MxParser.And); }
		public TerminalNode And(int i) {
			return getToken(MxParser.And, i);
		}
		public BinaryAndExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binaryAndExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterBinaryAndExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitBinaryAndExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitBinaryAndExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BinaryAndExpressionContext binaryAndExpression() throws RecognitionException {
		BinaryAndExpressionContext _localctx = new BinaryAndExpressionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_binaryAndExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			equalExpression();
			setState(125);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==And) {
				{
				{
				setState(121);
				match(And);
				setState(122);
				equalExpression();
				}
				}
				setState(127);
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

	public static class EqualExpressionContext extends ParserRuleContext {
		public List<CompareExpressionContext> compareExpression() {
			return getRuleContexts(CompareExpressionContext.class);
		}
		public CompareExpressionContext compareExpression(int i) {
			return getRuleContext(CompareExpressionContext.class,i);
		}
		public List<TerminalNode> Equal() { return getTokens(MxParser.Equal); }
		public TerminalNode Equal(int i) {
			return getToken(MxParser.Equal, i);
		}
		public List<TerminalNode> NotEqual() { return getTokens(MxParser.NotEqual); }
		public TerminalNode NotEqual(int i) {
			return getToken(MxParser.NotEqual, i);
		}
		public EqualExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equalExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterEqualExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitEqualExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitEqualExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EqualExpressionContext equalExpression() throws RecognitionException {
		EqualExpressionContext _localctx = new EqualExpressionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_equalExpression);
		int _la;
		try {
			setState(144);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(128);
				compareExpression();
				setState(133);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Equal) {
					{
					{
					setState(129);
					match(Equal);
					setState(130);
					compareExpression();
					}
					}
					setState(135);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(136);
				compareExpression();
				setState(141);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NotEqual) {
					{
					{
					setState(137);
					match(NotEqual);
					setState(138);
					compareExpression();
					}
					}
					setState(143);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
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

	public static class CompareExpressionContext extends ParserRuleContext {
		public List<ShiftExpressionContext> shiftExpression() {
			return getRuleContexts(ShiftExpressionContext.class);
		}
		public ShiftExpressionContext shiftExpression(int i) {
			return getRuleContext(ShiftExpressionContext.class,i);
		}
		public List<TerminalNode> Less() { return getTokens(MxParser.Less); }
		public TerminalNode Less(int i) {
			return getToken(MxParser.Less, i);
		}
		public List<TerminalNode> Greater() { return getTokens(MxParser.Greater); }
		public TerminalNode Greater(int i) {
			return getToken(MxParser.Greater, i);
		}
		public List<TerminalNode> LessEqual() { return getTokens(MxParser.LessEqual); }
		public TerminalNode LessEqual(int i) {
			return getToken(MxParser.LessEqual, i);
		}
		public List<TerminalNode> GreaterEqual() { return getTokens(MxParser.GreaterEqual); }
		public TerminalNode GreaterEqual(int i) {
			return getToken(MxParser.GreaterEqual, i);
		}
		public CompareExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compareExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterCompareExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitCompareExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitCompareExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompareExpressionContext compareExpression() throws RecognitionException {
		CompareExpressionContext _localctx = new CompareExpressionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_compareExpression);
		int _la;
		try {
			setState(178);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(146);
				shiftExpression();
				setState(151);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Less) {
					{
					{
					setState(147);
					match(Less);
					setState(148);
					shiftExpression();
					}
					}
					setState(153);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(154);
				shiftExpression();
				setState(159);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Greater) {
					{
					{
					setState(155);
					match(Greater);
					setState(156);
					shiftExpression();
					}
					}
					setState(161);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(162);
				shiftExpression();
				setState(167);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LessEqual) {
					{
					{
					setState(163);
					match(LessEqual);
					setState(164);
					shiftExpression();
					}
					}
					setState(169);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(170);
				shiftExpression();
				setState(175);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==GreaterEqual) {
					{
					{
					setState(171);
					match(GreaterEqual);
					setState(172);
					shiftExpression();
					}
					}
					setState(177);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
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

	public static class ShiftExpressionContext extends ParserRuleContext {
		public List<AddExpressionContext> addExpression() {
			return getRuleContexts(AddExpressionContext.class);
		}
		public AddExpressionContext addExpression(int i) {
			return getRuleContext(AddExpressionContext.class,i);
		}
		public List<TerminalNode> RightShift() { return getTokens(MxParser.RightShift); }
		public TerminalNode RightShift(int i) {
			return getToken(MxParser.RightShift, i);
		}
		public List<TerminalNode> LeftShift() { return getTokens(MxParser.LeftShift); }
		public TerminalNode LeftShift(int i) {
			return getToken(MxParser.LeftShift, i);
		}
		public ShiftExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shiftExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterShiftExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitShiftExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitShiftExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ShiftExpressionContext shiftExpression() throws RecognitionException {
		ShiftExpressionContext _localctx = new ShiftExpressionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_shiftExpression);
		int _la;
		try {
			setState(196);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(180);
				addExpression();
				setState(185);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==RightShift) {
					{
					{
					setState(181);
					match(RightShift);
					setState(182);
					addExpression();
					}
					}
					setState(187);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(188);
				addExpression();
				setState(193);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LeftShift) {
					{
					{
					setState(189);
					match(LeftShift);
					setState(190);
					addExpression();
					}
					}
					setState(195);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
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

	public static class AddExpressionContext extends ParserRuleContext {
		public List<MultiExpressionContext> multiExpression() {
			return getRuleContexts(MultiExpressionContext.class);
		}
		public MultiExpressionContext multiExpression(int i) {
			return getRuleContext(MultiExpressionContext.class,i);
		}
		public List<TerminalNode> Plus() { return getTokens(MxParser.Plus); }
		public TerminalNode Plus(int i) {
			return getToken(MxParser.Plus, i);
		}
		public List<TerminalNode> Minus() { return getTokens(MxParser.Minus); }
		public TerminalNode Minus(int i) {
			return getToken(MxParser.Minus, i);
		}
		public AddExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterAddExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitAddExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitAddExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddExpressionContext addExpression() throws RecognitionException {
		AddExpressionContext _localctx = new AddExpressionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_addExpression);
		int _la;
		try {
			setState(214);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(198);
				multiExpression();
				setState(203);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Plus) {
					{
					{
					setState(199);
					match(Plus);
					setState(200);
					multiExpression();
					}
					}
					setState(205);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(206);
				multiExpression();
				setState(211);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Minus) {
					{
					{
					setState(207);
					match(Minus);
					setState(208);
					multiExpression();
					}
					}
					setState(213);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
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

	public static class MultiExpressionContext extends ParserRuleContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public List<TerminalNode> Star() { return getTokens(MxParser.Star); }
		public TerminalNode Star(int i) {
			return getToken(MxParser.Star, i);
		}
		public List<TerminalNode> Div() { return getTokens(MxParser.Div); }
		public TerminalNode Div(int i) {
			return getToken(MxParser.Div, i);
		}
		public List<TerminalNode> Mod() { return getTokens(MxParser.Mod); }
		public TerminalNode Mod(int i) {
			return getToken(MxParser.Mod, i);
		}
		public MultiExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterMultiExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitMultiExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitMultiExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultiExpressionContext multiExpression() throws RecognitionException {
		MultiExpressionContext _localctx = new MultiExpressionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_multiExpression);
		int _la;
		try {
			setState(240);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(216);
				term();
				setState(221);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Star) {
					{
					{
					setState(217);
					match(Star);
					setState(218);
					term();
					}
					}
					setState(223);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(224);
				term();
				setState(229);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Div) {
					{
					{
					setState(225);
					match(Div);
					setState(226);
					term();
					}
					}
					setState(231);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(232);
				term();
				setState(237);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Mod) {
					{
					{
					setState(233);
					match(Mod);
					setState(234);
					term();
					}
					}
					setState(239);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
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

	public static class TermContext extends ParserRuleContext {
		public UnaryExpressionContext unaryExpression() {
			return getRuleContext(UnaryExpressionContext.class,0);
		}
		public TerminalNode DigitSequence() { return getToken(MxParser.DigitSequence, 0); }
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_term);
		try {
			setState(244);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case T__1:
			case T__2:
			case T__3:
			case Identifier:
			case IntegerLiteral:
			case StringLiteral:
			case LeftParen:
			case Plus:
			case PlusPlus:
			case Minus:
			case MinusMinus:
			case Not:
			case Tilde:
				enterOuterAlt(_localctx, 1);
				{
				setState(242);
				unaryExpression();
				}
				break;
			case DigitSequence:
				enterOuterAlt(_localctx, 2);
				{
				setState(243);
				match(DigitSequence);
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

	public static class UnaryExpressionContext extends ParserRuleContext {
		public UnaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryExpression; }
	 
		public UnaryExpressionContext() { }
		public void copyFrom(UnaryExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class UnaryExpressionPrefixContext extends UnaryExpressionContext {
		public UnaryOperatorContext unaryOperator() {
			return getRuleContext(UnaryOperatorContext.class,0);
		}
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public UnaryExpressionPrefixContext(UnaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterUnaryExpressionPrefix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitUnaryExpressionPrefix(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitUnaryExpressionPrefix(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnaryExpressionPrefixIncContext extends UnaryExpressionContext {
		public TerminalNode PlusPlus() { return getToken(MxParser.PlusPlus, 0); }
		public UnaryExpressionContext unaryExpression() {
			return getRuleContext(UnaryExpressionContext.class,0);
		}
		public UnaryExpressionPrefixIncContext(UnaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterUnaryExpressionPrefixInc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitUnaryExpressionPrefixInc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitUnaryExpressionPrefixInc(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnaryExpressionPrefixDecContext extends UnaryExpressionContext {
		public TerminalNode MinusMinus() { return getToken(MxParser.MinusMinus, 0); }
		public UnaryExpressionContext unaryExpression() {
			return getRuleContext(UnaryExpressionContext.class,0);
		}
		public UnaryExpressionPrefixDecContext(UnaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterUnaryExpressionPrefixDec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitUnaryExpressionPrefixDec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitUnaryExpressionPrefixDec(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnaryExpressionPostfixContext extends UnaryExpressionContext {
		public PostfixExpressionContext postfixExpression() {
			return getRuleContext(PostfixExpressionContext.class,0);
		}
		public UnaryExpressionPostfixContext(UnaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterUnaryExpressionPostfix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitUnaryExpressionPostfix(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitUnaryExpressionPostfix(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryExpressionContext unaryExpression() throws RecognitionException {
		UnaryExpressionContext _localctx = new UnaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_unaryExpression);
		try {
			setState(254);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PlusPlus:
				_localctx = new UnaryExpressionPrefixIncContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(246);
				match(PlusPlus);
				setState(247);
				unaryExpression();
				}
				break;
			case MinusMinus:
				_localctx = new UnaryExpressionPrefixDecContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(248);
				match(MinusMinus);
				setState(249);
				unaryExpression();
				}
				break;
			case Plus:
			case Minus:
			case Not:
			case Tilde:
				_localctx = new UnaryExpressionPrefixContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(250);
				unaryOperator();
				setState(251);
				term();
				}
				break;
			case T__0:
			case T__1:
			case T__2:
			case T__3:
			case Identifier:
			case IntegerLiteral:
			case StringLiteral:
			case LeftParen:
				_localctx = new UnaryExpressionPostfixContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(253);
				postfixExpression(0);
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

	public static class UnaryOperatorContext extends ParserRuleContext {
		public TerminalNode Plus() { return getToken(MxParser.Plus, 0); }
		public TerminalNode Minus() { return getToken(MxParser.Minus, 0); }
		public TerminalNode Not() { return getToken(MxParser.Not, 0); }
		public TerminalNode Tilde() { return getToken(MxParser.Tilde, 0); }
		public UnaryOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterUnaryOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitUnaryOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitUnaryOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryOperatorContext unaryOperator() throws RecognitionException {
		UnaryOperatorContext _localctx = new UnaryOperatorContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_unaryOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(256);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Plus) | (1L << Minus) | (1L << Not) | (1L << Tilde))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class PostfixExpressionContext extends ParserRuleContext {
		public PrimaryExpressionContext primaryExpression() {
			return getRuleContext(PrimaryExpressionContext.class,0);
		}
		public PostfixExpressionContext postfixExpression() {
			return getRuleContext(PostfixExpressionContext.class,0);
		}
		public TerminalNode PlusPlus() { return getToken(MxParser.PlusPlus, 0); }
		public TerminalNode MinusMinus() { return getToken(MxParser.MinusMinus, 0); }
		public TerminalNode LeftBracket() { return getToken(MxParser.LeftBracket, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RightBracket() { return getToken(MxParser.RightBracket, 0); }
		public TerminalNode Dot() { return getToken(MxParser.Dot, 0); }
		public TerminalNode Identifier() { return getToken(MxParser.Identifier, 0); }
		public TerminalNode LeftParen() { return getToken(MxParser.LeftParen, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(MxParser.RightParen, 0); }
		public PostfixExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfixExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterPostfixExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitPostfixExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitPostfixExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PostfixExpressionContext postfixExpression() throws RecognitionException {
		return postfixExpression(0);
	}

	private PostfixExpressionContext postfixExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		PostfixExpressionContext _localctx = new PostfixExpressionContext(_ctx, _parentState);
		PostfixExpressionContext _prevctx = _localctx;
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_postfixExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(259);
			primaryExpression();
			}
			_ctx.stop = _input.LT(-1);
			setState(280);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(278);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
					case 1:
						{
						_localctx = new PostfixExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfixExpression);
						setState(261);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(262);
						match(PlusPlus);
						}
						break;
					case 2:
						{
						_localctx = new PostfixExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfixExpression);
						setState(263);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(264);
						match(MinusMinus);
						}
						break;
					case 3:
						{
						_localctx = new PostfixExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfixExpression);
						setState(265);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(266);
						match(LeftBracket);
						setState(267);
						expression();
						setState(268);
						match(RightBracket);
						}
						break;
					case 4:
						{
						_localctx = new PostfixExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfixExpression);
						setState(270);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(271);
						match(Dot);
						setState(272);
						match(Identifier);
						}
						break;
					case 5:
						{
						_localctx = new PostfixExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfixExpression);
						setState(273);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(274);
						match(LeftParen);
						setState(275);
						args();
						setState(276);
						match(RightParen);
						}
						break;
					}
					} 
				}
				setState(282);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ArgsContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode Comma() { return getToken(MxParser.Comma, 0); }
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitArgs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitArgs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_args);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(287);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << Identifier) | (1L << IntegerLiteral) | (1L << DigitSequence) | (1L << StringLiteral) | (1L << LeftParen) | (1L << Plus) | (1L << PlusPlus) | (1L << Minus) | (1L << MinusMinus) | (1L << Not) | (1L << Tilde) | (1L << New))) != 0)) {
				{
				setState(283);
				expression();
				{
				setState(284);
				match(Comma);
				setState(285);
				expression();
				}
				}
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

	public static class PrimaryExpressionContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(MxParser.Identifier, 0); }
		public TerminalNode StringLiteral() { return getToken(MxParser.StringLiteral, 0); }
		public TerminalNode IntegerLiteral() { return getToken(MxParser.IntegerLiteral, 0); }
		public TerminalNode LeftParen() { return getToken(MxParser.LeftParen, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(MxParser.RightParen, 0); }
		public PrimaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterPrimaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitPrimaryExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitPrimaryExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryExpressionContext primaryExpression() throws RecognitionException {
		PrimaryExpressionContext _localctx = new PrimaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_primaryExpression);
		try {
			setState(300);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(289);
				match(T__0);
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(290);
				match(T__1);
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 3);
				{
				setState(291);
				match(T__2);
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 4);
				{
				setState(292);
				match(T__3);
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 5);
				{
				setState(293);
				match(Identifier);
				}
				break;
			case StringLiteral:
				enterOuterAlt(_localctx, 6);
				{
				setState(294);
				match(StringLiteral);
				}
				break;
			case IntegerLiteral:
				enterOuterAlt(_localctx, 7);
				{
				setState(295);
				match(IntegerLiteral);
				}
				break;
			case LeftParen:
				enterOuterAlt(_localctx, 8);
				{
				setState(296);
				match(LeftParen);
				setState(297);
				expression();
				setState(298);
				match(RightParen);
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

	public static class Expression10Context extends ParserRuleContext {
		public LogicalOrExpressionContext logicalOrExpression() {
			return getRuleContext(LogicalOrExpressionContext.class,0);
		}
		public Expression10Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression10; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterExpression10(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitExpression10(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitExpression10(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expression10Context expression10() throws RecognitionException {
		Expression10Context _localctx = new Expression10Context(_ctx, getState());
		enterRule(_localctx, 36, RULE_expression10);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(302);
			logicalOrExpression();
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

	public static class ExpressionContext extends ParserRuleContext {
		public NewExpressionContext newExpression() {
			return getRuleContext(NewExpressionContext.class,0);
		}
		public Expression10Context expression10() {
			return getRuleContext(Expression10Context.class,0);
		}
		public UnaryExpressionContext unaryExpression() {
			return getRuleContext(UnaryExpressionContext.class,0);
		}
		public TerminalNode Assign() { return getToken(MxParser.Assign, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_expression);
		try {
			setState(310);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(304);
				newExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(305);
				expression10();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(306);
				unaryExpression();
				setState(307);
				match(Assign);
				setState(308);
				expression();
				}
				break;
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

	public static class VariableDeclarationContext extends ParserRuleContext {
		public VariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclaration; }
	 
		public VariableDeclarationContext() { }
		public void copyFrom(VariableDeclarationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class VarDeclarationInitContext extends VariableDeclarationContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<VariableDeclaratorContext> variableDeclarator() {
			return getRuleContexts(VariableDeclaratorContext.class);
		}
		public VariableDeclaratorContext variableDeclarator(int i) {
			return getRuleContext(VariableDeclaratorContext.class,i);
		}
		public TerminalNode Semi() { return getToken(MxParser.Semi, 0); }
		public List<TerminalNode> Comma() { return getTokens(MxParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(MxParser.Comma, i);
		}
		public VarDeclarationInitContext(VariableDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterVarDeclarationInit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitVarDeclarationInit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitVarDeclarationInit(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VarDeclarationNoneContext extends VariableDeclarationContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode Semi() { return getToken(MxParser.Semi, 0); }
		public VarDeclarationNoneContext(VariableDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterVarDeclarationNone(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitVarDeclarationNone(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitVarDeclarationNone(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclarationContext variableDeclaration() throws RecognitionException {
		VariableDeclarationContext _localctx = new VariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_variableDeclaration);
		int _la;
		try {
			setState(326);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				_localctx = new VarDeclarationInitContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(312);
				type(0);
				setState(313);
				variableDeclarator();
				setState(318);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(314);
					match(Comma);
					setState(315);
					variableDeclarator();
					}
					}
					setState(320);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(321);
				match(Semi);
				}
				break;
			case 2:
				_localctx = new VarDeclarationNoneContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(323);
				type(0);
				setState(324);
				match(Semi);
				}
				break;
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

	public static class VariableDeclaratorContext extends ParserRuleContext {
		public VariableDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclarator; }
	 
		public VariableDeclaratorContext() { }
		public void copyFrom(VariableDeclaratorContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class VariableDeclaratorNoneContext extends VariableDeclaratorContext {
		public DirectDeclaratorContext directDeclarator() {
			return getRuleContext(DirectDeclaratorContext.class,0);
		}
		public VariableDeclaratorNoneContext(VariableDeclaratorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterVariableDeclaratorNone(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitVariableDeclaratorNone(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitVariableDeclaratorNone(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VariableDeclaratorInitContext extends VariableDeclaratorContext {
		public DirectDeclaratorContext directDeclarator() {
			return getRuleContext(DirectDeclaratorContext.class,0);
		}
		public TerminalNode Assign() { return getToken(MxParser.Assign, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VariableDeclaratorInitContext(VariableDeclaratorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterVariableDeclaratorInit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitVariableDeclaratorInit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitVariableDeclaratorInit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclaratorContext variableDeclarator() throws RecognitionException {
		VariableDeclaratorContext _localctx = new VariableDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_variableDeclarator);
		try {
			setState(333);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				_localctx = new VariableDeclaratorNoneContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(328);
				directDeclarator(0);
				}
				break;
			case 2:
				_localctx = new VariableDeclaratorInitContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(329);
				directDeclarator(0);
				setState(330);
				match(Assign);
				setState(331);
				expression();
				}
				break;
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

	public static class NewExpressionContext extends ParserRuleContext {
		public NewExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newExpression; }
	 
		public NewExpressionContext() { }
		public void copyFrom(NewExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NewExpressionNonarrayContext extends NewExpressionContext {
		public TerminalNode New() { return getToken(MxParser.New, 0); }
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public TerminalNode LeftParen() { return getToken(MxParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(MxParser.RightParen, 0); }
		public NewExpressionNonarrayContext(NewExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterNewExpressionNonarray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitNewExpressionNonarray(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitNewExpressionNonarray(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NewExpressionErrorContext extends NewExpressionContext {
		public TerminalNode New() { return getToken(MxParser.New, 0); }
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public List<TerminalNode> LeftBracket() { return getTokens(MxParser.LeftBracket); }
		public TerminalNode LeftBracket(int i) {
			return getToken(MxParser.LeftBracket, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> RightBracket() { return getTokens(MxParser.RightBracket); }
		public TerminalNode RightBracket(int i) {
			return getToken(MxParser.RightBracket, i);
		}
		public NewExpressionErrorContext(NewExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterNewExpressionError(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitNewExpressionError(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitNewExpressionError(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NewExpressionArrayContext extends NewExpressionContext {
		public TerminalNode New() { return getToken(MxParser.New, 0); }
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public List<TerminalNode> LeftBracket() { return getTokens(MxParser.LeftBracket); }
		public TerminalNode LeftBracket(int i) {
			return getToken(MxParser.LeftBracket, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> RightBracket() { return getTokens(MxParser.RightBracket); }
		public TerminalNode RightBracket(int i) {
			return getToken(MxParser.RightBracket, i);
		}
		public NewExpressionArrayContext(NewExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterNewExpressionArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitNewExpressionArray(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitNewExpressionArray(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NewExpressionContext newExpression() throws RecognitionException {
		NewExpressionContext _localctx = new NewExpressionContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_newExpression);
		int _la;
		try {
			int _alt;
			setState(382);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				_localctx = new NewExpressionErrorContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(335);
				match(New);
				setState(336);
				typeName();
				setState(341); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(337);
						match(LeftBracket);
						setState(338);
						expression();
						setState(339);
						match(RightBracket);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(343); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(347); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(345);
						match(LeftBracket);
						setState(346);
						match(RightBracket);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(349); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(355); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(351);
					match(LeftBracket);
					setState(352);
					expression();
					setState(353);
					match(RightBracket);
					}
					}
					setState(357); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==LeftBracket );
				}
				break;
			case 2:
				_localctx = new NewExpressionArrayContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(359);
				match(New);
				setState(360);
				typeName();
				setState(365); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(361);
						match(LeftBracket);
						setState(362);
						expression();
						setState(363);
						match(RightBracket);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(367); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(373);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LeftBracket) {
					{
					{
					setState(369);
					match(LeftBracket);
					setState(370);
					match(RightBracket);
					}
					}
					setState(375);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 3:
				_localctx = new NewExpressionNonarrayContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(376);
				match(New);
				setState(377);
				typeName();
				setState(380);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LeftParen) {
					{
					setState(378);
					match(LeftParen);
					setState(379);
					match(RightParen);
					}
				}

				}
				break;
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

	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	 
		public TypeContext() { }
		public void copyFrom(TypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TypeArrayContext extends TypeContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode LeftBracket() { return getToken(MxParser.LeftBracket, 0); }
		public TerminalNode RightBracket() { return getToken(MxParser.RightBracket, 0); }
		public TypeArrayContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterTypeArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitTypeArray(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitTypeArray(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TypeTypeContext extends TypeContext {
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public TypeTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterTypeType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitTypeType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitTypeType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		return type(0);
	}

	private TypeContext type(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TypeContext _localctx = new TypeContext(_ctx, _parentState);
		TypeContext _prevctx = _localctx;
		int _startState = 46;
		enterRecursionRule(_localctx, 46, RULE_type, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new TypeTypeContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(385);
			typeName();
			}
			_ctx.stop = _input.LT(-1);
			setState(392);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TypeArrayContext(new TypeContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_type);
					setState(387);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(388);
					match(LeftBracket);
					setState(389);
					match(RightBracket);
					}
					} 
				}
				setState(394);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class TypeNameContext extends ParserRuleContext {
		public TerminalNode Void() { return getToken(MxParser.Void, 0); }
		public TerminalNode Int() { return getToken(MxParser.Int, 0); }
		public TerminalNode Bool() { return getToken(MxParser.Bool, 0); }
		public TypedefNameContext typedefName() {
			return getRuleContext(TypedefNameContext.class,0);
		}
		public TypeNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterTypeName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitTypeName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitTypeName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeNameContext typeName() throws RecognitionException {
		TypeNameContext _localctx = new TypeNameContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_typeName);
		try {
			setState(400);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Void:
				enterOuterAlt(_localctx, 1);
				{
				setState(395);
				match(Void);
				}
				break;
			case Int:
				enterOuterAlt(_localctx, 2);
				{
				setState(396);
				match(Int);
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 3);
				{
				setState(397);
				match(T__4);
				}
				break;
			case Bool:
				enterOuterAlt(_localctx, 4);
				{
				setState(398);
				match(Bool);
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 5);
				{
				setState(399);
				typedefName();
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

	public static class TypedefNameContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(MxParser.Identifier, 0); }
		public TypedefNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typedefName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterTypedefName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitTypedefName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitTypedefName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypedefNameContext typedefName() throws RecognitionException {
		TypedefNameContext _localctx = new TypedefNameContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_typedefName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(402);
			match(Identifier);
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

	public static class DirectDeclaratorContext extends ParserRuleContext {
		public DirectDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_directDeclarator; }
	 
		public DirectDeclaratorContext() { }
		public void copyFrom(DirectDeclaratorContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DirectDeclaratorIdentifierContext extends DirectDeclaratorContext {
		public TerminalNode Identifier() { return getToken(MxParser.Identifier, 0); }
		public DirectDeclaratorIdentifierContext(DirectDeclaratorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterDirectDeclaratorIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitDirectDeclaratorIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitDirectDeclaratorIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DirectDeclaratorWithParameterListContext extends DirectDeclaratorContext {
		public DirectDeclaratorContext directDeclarator() {
			return getRuleContext(DirectDeclaratorContext.class,0);
		}
		public TerminalNode LeftParen() { return getToken(MxParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(MxParser.RightParen, 0); }
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public DirectDeclaratorWithParameterListContext(DirectDeclaratorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterDirectDeclaratorWithParameterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitDirectDeclaratorWithParameterList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitDirectDeclaratorWithParameterList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DirectDeclaratorContext directDeclarator() throws RecognitionException {
		return directDeclarator(0);
	}

	private DirectDeclaratorContext directDeclarator(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		DirectDeclaratorContext _localctx = new DirectDeclaratorContext(_ctx, _parentState);
		DirectDeclaratorContext _prevctx = _localctx;
		int _startState = 52;
		enterRecursionRule(_localctx, 52, RULE_directDeclarator, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new DirectDeclaratorIdentifierContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(405);
			match(Identifier);
			}
			_ctx.stop = _input.LT(-1);
			setState(415);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new DirectDeclaratorWithParameterListContext(new DirectDeclaratorContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_directDeclarator);
					setState(407);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(408);
					match(LeftParen);
					setState(410);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << Identifier) | (1L << Int) | (1L << Void) | (1L << Bool))) != 0)) {
						{
						setState(409);
						parameterList();
						}
					}

					setState(412);
					match(RightParen);
					}
					} 
				}
				setState(417);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IterationStatementForContext extends StatementContext {
		public TerminalNode For() { return getToken(MxParser.For, 0); }
		public TerminalNode LeftParen() { return getToken(MxParser.LeftParen, 0); }
		public ForConditionContext forCondition() {
			return getRuleContext(ForConditionContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(MxParser.RightParen, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public IterationStatementForContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterIterationStatementFor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitIterationStatementFor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitIterationStatementFor(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IterationStatementWhileContext extends StatementContext {
		public TerminalNode While() { return getToken(MxParser.While, 0); }
		public TerminalNode LeftParen() { return getToken(MxParser.LeftParen, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(MxParser.RightParen, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public IterationStatementWhileContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterIterationStatementWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitIterationStatementWhile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitIterationStatementWhile(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BlockStatementContext extends StatementContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public BlockStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterBlockStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitBlockStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitBlockStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprStatementContext extends StatementContext {
		public TerminalNode Semi() { return getToken(MxParser.Semi, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExprStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterExprStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitExprStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitExprStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class JumpStatementBreakContext extends StatementContext {
		public TerminalNode Break() { return getToken(MxParser.Break, 0); }
		public TerminalNode Semi() { return getToken(MxParser.Semi, 0); }
		public JumpStatementBreakContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterJumpStatementBreak(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitJumpStatementBreak(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitJumpStatementBreak(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class JumpStatementReturnContext extends StatementContext {
		public TerminalNode Return() { return getToken(MxParser.Return, 0); }
		public TerminalNode Semi() { return getToken(MxParser.Semi, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public JumpStatementReturnContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterJumpStatementReturn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitJumpStatementReturn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitJumpStatementReturn(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SwitchStatementContext extends StatementContext {
		public TerminalNode If() { return getToken(MxParser.If, 0); }
		public TerminalNode LeftParen() { return getToken(MxParser.LeftParen, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(MxParser.RightParen, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode Else() { return getToken(MxParser.Else, 0); }
		public SwitchStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterSwitchStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitSwitchStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitSwitchStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class JumpStatementContinueContext extends StatementContext {
		public TerminalNode Continue() { return getToken(MxParser.Continue, 0); }
		public TerminalNode Semi() { return getToken(MxParser.Semi, 0); }
		public JumpStatementContinueContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterJumpStatementContinue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitJumpStatementContinue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitJumpStatementContinue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_statement);
		int _la;
		try {
			setState(453);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case T__1:
			case T__2:
			case T__3:
			case Identifier:
			case IntegerLiteral:
			case DigitSequence:
			case StringLiteral:
			case LeftParen:
			case Plus:
			case PlusPlus:
			case Minus:
			case MinusMinus:
			case Not:
			case Tilde:
			case Semi:
			case New:
				_localctx = new ExprStatementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(419);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << Identifier) | (1L << IntegerLiteral) | (1L << DigitSequence) | (1L << StringLiteral) | (1L << LeftParen) | (1L << Plus) | (1L << PlusPlus) | (1L << Minus) | (1L << MinusMinus) | (1L << Not) | (1L << Tilde) | (1L << New))) != 0)) {
					{
					setState(418);
					expression();
					}
				}

				setState(421);
				match(Semi);
				}
				break;
			case LeftBrace:
				_localctx = new BlockStatementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(422);
				block();
				}
				break;
			case If:
				_localctx = new SwitchStatementContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(423);
				match(If);
				setState(424);
				match(LeftParen);
				setState(425);
				expression();
				setState(426);
				match(RightParen);
				setState(427);
				statement();
				setState(430);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
				case 1:
					{
					setState(428);
					match(Else);
					setState(429);
					statement();
					}
					break;
				}
				}
				break;
			case While:
				_localctx = new IterationStatementWhileContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(432);
				match(While);
				setState(433);
				match(LeftParen);
				setState(434);
				expression();
				setState(435);
				match(RightParen);
				setState(436);
				statement();
				}
				break;
			case For:
				_localctx = new IterationStatementForContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(438);
				match(For);
				setState(439);
				match(LeftParen);
				setState(440);
				forCondition();
				setState(441);
				match(RightParen);
				setState(442);
				statement();
				}
				break;
			case Continue:
				_localctx = new JumpStatementContinueContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(444);
				match(Continue);
				setState(445);
				match(Semi);
				}
				break;
			case Break:
				_localctx = new JumpStatementBreakContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(446);
				match(Break);
				setState(447);
				match(Semi);
				}
				break;
			case Return:
				_localctx = new JumpStatementReturnContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(448);
				match(Return);
				setState(450);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << Identifier) | (1L << IntegerLiteral) | (1L << DigitSequence) | (1L << StringLiteral) | (1L << LeftParen) | (1L << Plus) | (1L << PlusPlus) | (1L << Minus) | (1L << MinusMinus) | (1L << Not) | (1L << Tilde) | (1L << New))) != 0)) {
					{
					setState(449);
					expression();
					}
				}

				setState(452);
				match(Semi);
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

	public static class BlockContext extends ParserRuleContext {
		public TerminalNode LeftBrace() { return getToken(MxParser.LeftBrace, 0); }
		public TerminalNode RightBrace() { return getToken(MxParser.RightBrace, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<VariableDeclarationContext> variableDeclaration() {
			return getRuleContexts(VariableDeclarationContext.class);
		}
		public VariableDeclarationContext variableDeclaration(int i) {
			return getRuleContext(VariableDeclarationContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(455);
			match(LeftBrace);
			setState(460);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << Identifier) | (1L << IntegerLiteral) | (1L << DigitSequence) | (1L << StringLiteral) | (1L << Break) | (1L << Continue) | (1L << For) | (1L << If) | (1L << Int) | (1L << Return) | (1L << Void) | (1L << While) | (1L << Bool) | (1L << LeftParen) | (1L << LeftBrace) | (1L << Plus) | (1L << PlusPlus) | (1L << Minus) | (1L << MinusMinus) | (1L << Not) | (1L << Tilde) | (1L << Semi) | (1L << New))) != 0)) {
				{
				setState(458);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
				case 1:
					{
					setState(456);
					statement();
					}
					break;
				case 2:
					{
					setState(457);
					variableDeclaration();
					}
					break;
				}
				}
				setState(462);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(463);
			match(RightBrace);
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

	public static class ForConditionContext extends ParserRuleContext {
		public ForConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forCondition; }
	 
		public ForConditionContext() { }
		public void copyFrom(ForConditionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ForConditionNoneContext extends ForConditionContext {
		public List<TerminalNode> Semi() { return getTokens(MxParser.Semi); }
		public TerminalNode Semi(int i) {
			return getToken(MxParser.Semi, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ForConditionNoneContext(ForConditionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterForConditionNone(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitForConditionNone(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitForConditionNone(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ForConditionInitContext extends ForConditionContext {
		public ForDeclarationContext forDeclaration() {
			return getRuleContext(ForDeclarationContext.class,0);
		}
		public List<TerminalNode> Semi() { return getTokens(MxParser.Semi); }
		public TerminalNode Semi(int i) {
			return getToken(MxParser.Semi, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ForConditionInitContext(ForConditionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterForConditionInit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitForConditionInit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitForConditionInit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForConditionContext forCondition() throws RecognitionException {
		ForConditionContext _localctx = new ForConditionContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_forCondition);
		int _la;
		try {
			setState(485);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,57,_ctx) ) {
			case 1:
				_localctx = new ForConditionInitContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(465);
				forDeclaration();
				setState(466);
				match(Semi);
				setState(468);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << Identifier) | (1L << IntegerLiteral) | (1L << DigitSequence) | (1L << StringLiteral) | (1L << LeftParen) | (1L << Plus) | (1L << PlusPlus) | (1L << Minus) | (1L << MinusMinus) | (1L << Not) | (1L << Tilde) | (1L << New))) != 0)) {
					{
					setState(467);
					expression();
					}
				}

				setState(470);
				match(Semi);
				setState(472);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << Identifier) | (1L << IntegerLiteral) | (1L << DigitSequence) | (1L << StringLiteral) | (1L << LeftParen) | (1L << Plus) | (1L << PlusPlus) | (1L << Minus) | (1L << MinusMinus) | (1L << Not) | (1L << Tilde) | (1L << New))) != 0)) {
					{
					setState(471);
					expression();
					}
				}

				}
				break;
			case 2:
				_localctx = new ForConditionNoneContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(475);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << Identifier) | (1L << IntegerLiteral) | (1L << DigitSequence) | (1L << StringLiteral) | (1L << LeftParen) | (1L << Plus) | (1L << PlusPlus) | (1L << Minus) | (1L << MinusMinus) | (1L << Not) | (1L << Tilde) | (1L << New))) != 0)) {
					{
					setState(474);
					expression();
					}
				}

				setState(477);
				match(Semi);
				setState(479);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << Identifier) | (1L << IntegerLiteral) | (1L << DigitSequence) | (1L << StringLiteral) | (1L << LeftParen) | (1L << Plus) | (1L << PlusPlus) | (1L << Minus) | (1L << MinusMinus) | (1L << Not) | (1L << Tilde) | (1L << New))) != 0)) {
					{
					setState(478);
					expression();
					}
				}

				setState(481);
				match(Semi);
				setState(483);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << Identifier) | (1L << IntegerLiteral) | (1L << DigitSequence) | (1L << StringLiteral) | (1L << LeftParen) | (1L << Plus) | (1L << PlusPlus) | (1L << Minus) | (1L << MinusMinus) | (1L << Not) | (1L << Tilde) | (1L << New))) != 0)) {
					{
					setState(482);
					expression();
					}
				}

				}
				break;
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

	public static class ForDeclarationContext extends ParserRuleContext {
		public ForDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forDeclaration; }
	 
		public ForDeclarationContext() { }
		public void copyFrom(ForDeclarationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ForDeclarationNoneContext extends ForDeclarationContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ForDeclarationNoneContext(ForDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterForDeclarationNone(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitForDeclarationNone(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitForDeclarationNone(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ForDeclarationInitContext extends ForDeclarationContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<VariableDeclaratorContext> variableDeclarator() {
			return getRuleContexts(VariableDeclaratorContext.class);
		}
		public VariableDeclaratorContext variableDeclarator(int i) {
			return getRuleContext(VariableDeclaratorContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(MxParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(MxParser.Comma, i);
		}
		public ForDeclarationInitContext(ForDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterForDeclarationInit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitForDeclarationInit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitForDeclarationInit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForDeclarationContext forDeclaration() throws RecognitionException {
		ForDeclarationContext _localctx = new ForDeclarationContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_forDeclaration);
		int _la;
		try {
			setState(497);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,59,_ctx) ) {
			case 1:
				_localctx = new ForDeclarationInitContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(487);
				type(0);
				setState(488);
				variableDeclarator();
				setState(493);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(489);
					match(Comma);
					setState(490);
					variableDeclarator();
					}
					}
					setState(495);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				_localctx = new ForDeclarationNoneContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(496);
				type(0);
				}
				break;
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

	public static class FunctionDeclarationContext extends ParserRuleContext {
		public FunctionDeclaratorContext functionDeclarator() {
			return getRuleContext(FunctionDeclaratorContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public FunctionDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterFunctionDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitFunctionDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitFunctionDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDeclarationContext functionDeclaration() throws RecognitionException {
		FunctionDeclarationContext _localctx = new FunctionDeclarationContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_functionDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(500);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,60,_ctx) ) {
			case 1:
				{
				setState(499);
				type(0);
				}
				break;
			}
			setState(502);
			functionDeclarator();
			setState(503);
			block();
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

	public static class FunctionDeclaratorContext extends ParserRuleContext {
		public TypedefNameContext typedefName() {
			return getRuleContext(TypedefNameContext.class,0);
		}
		public TerminalNode LeftParen() { return getToken(MxParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(MxParser.RightParen, 0); }
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public FunctionDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterFunctionDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitFunctionDeclarator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitFunctionDeclarator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDeclaratorContext functionDeclarator() throws RecognitionException {
		FunctionDeclaratorContext _localctx = new FunctionDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_functionDeclarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(505);
			typedefName();
			setState(506);
			match(LeftParen);
			setState(508);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << Identifier) | (1L << Int) | (1L << Void) | (1L << Bool))) != 0)) {
				{
				setState(507);
				parameterList();
				}
			}

			setState(510);
			match(RightParen);
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

	public static class ParameterListContext extends ParserRuleContext {
		public ParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterList; }
	 
		public ParameterListContext() { }
		public void copyFrom(ParameterListContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ParameterListMultiContext extends ParameterListContext {
		public List<ParameterDeclarationContext> parameterDeclaration() {
			return getRuleContexts(ParameterDeclarationContext.class);
		}
		public ParameterDeclarationContext parameterDeclaration(int i) {
			return getRuleContext(ParameterDeclarationContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(MxParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(MxParser.Comma, i);
		}
		public ParameterListMultiContext(ParameterListContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterParameterListMulti(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitParameterListMulti(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitParameterListMulti(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterListContext parameterList() throws RecognitionException {
		ParameterListContext _localctx = new ParameterListContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_parameterList);
		int _la;
		try {
			_localctx = new ParameterListMultiContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(512);
			parameterDeclaration();
			setState(517);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(513);
				match(Comma);
				setState(514);
				parameterDeclaration();
				}
				}
				setState(519);
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

	public static class ParameterDeclarationContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(MxParser.Identifier, 0); }
		public ParameterDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterParameterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitParameterDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitParameterDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterDeclarationContext parameterDeclaration() throws RecognitionException {
		ParameterDeclarationContext _localctx = new ParameterDeclarationContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_parameterDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(520);
			type(0);
			setState(521);
			match(Identifier);
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

	public static class ClassDeclarationContext extends ParserRuleContext {
		public ClassDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDeclaration; }
	 
		public ClassDeclarationContext() { }
		public void copyFrom(ClassDeclarationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ClassBodyDeclContext extends ClassDeclarationContext {
		public TerminalNode Class() { return getToken(MxParser.Class, 0); }
		public TerminalNode LeftBrace() { return getToken(MxParser.LeftBrace, 0); }
		public TerminalNode RightBrace() { return getToken(MxParser.RightBrace, 0); }
		public TerminalNode Identifier() { return getToken(MxParser.Identifier, 0); }
		public List<ClassBodyContext> classBody() {
			return getRuleContexts(ClassBodyContext.class);
		}
		public ClassBodyContext classBody(int i) {
			return getRuleContext(ClassBodyContext.class,i);
		}
		public ClassBodyDeclContext(ClassDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterClassBodyDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitClassBodyDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitClassBodyDecl(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ClassBodyNoneContext extends ClassDeclarationContext {
		public TerminalNode Class() { return getToken(MxParser.Class, 0); }
		public TerminalNode Identifier() { return getToken(MxParser.Identifier, 0); }
		public ClassBodyNoneContext(ClassDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterClassBodyNone(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitClassBodyNone(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitClassBodyNone(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassDeclarationContext classDeclaration() throws RecognitionException {
		ClassDeclarationContext _localctx = new ClassDeclarationContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_classDeclaration);
		int _la;
		try {
			setState(537);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,65,_ctx) ) {
			case 1:
				_localctx = new ClassBodyDeclContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(523);
				match(Class);
				setState(525);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Identifier) {
					{
					setState(524);
					match(Identifier);
					}
				}

				setState(527);
				match(LeftBrace);
				setState(531);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << Identifier) | (1L << Int) | (1L << Void) | (1L << Bool))) != 0)) {
					{
					{
					setState(528);
					classBody();
					}
					}
					setState(533);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(534);
				match(RightBrace);
				}
				break;
			case 2:
				_localctx = new ClassBodyNoneContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(535);
				match(Class);
				setState(536);
				match(Identifier);
				}
				break;
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

	public static class ClassBodyContext extends ParserRuleContext {
		public VariableDeclarationContext variableDeclaration() {
			return getRuleContext(VariableDeclarationContext.class,0);
		}
		public FunctionDeclarationContext functionDeclaration() {
			return getRuleContext(FunctionDeclarationContext.class,0);
		}
		public ClassBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterClassBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitClassBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitClassBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassBodyContext classBody() throws RecognitionException {
		ClassBodyContext _localctx = new ClassBodyContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_classBody);
		try {
			setState(541);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,66,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(539);
				variableDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(540);
				functionDeclaration();
				}
				break;
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 15:
			return postfixExpression_sempred((PostfixExpressionContext)_localctx, predIndex);
		case 23:
			return type_sempred((TypeContext)_localctx, predIndex);
		case 26:
			return directDeclarator_sempred((DirectDeclaratorContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean postfixExpression_sempred(PostfixExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 5);
		case 1:
			return precpred(_ctx, 4);
		case 2:
			return precpred(_ctx, 3);
		case 3:
			return precpred(_ctx, 2);
		case 4:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean type_sempred(TypeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean directDeclarator_sempred(DirectDeclaratorContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3@\u0222\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\3\2\7\2N\n\2\f\2\16\2Q\13\2\3\2\3"+
		"\2\3\3\3\3\3\3\3\3\5\3Y\n\3\3\4\3\4\3\4\7\4^\n\4\f\4\16\4a\13\4\3\5\3"+
		"\5\3\5\7\5f\n\5\f\5\16\5i\13\5\3\6\3\6\3\6\7\6n\n\6\f\6\16\6q\13\6\3\7"+
		"\3\7\3\7\7\7v\n\7\f\7\16\7y\13\7\3\b\3\b\3\b\7\b~\n\b\f\b\16\b\u0081\13"+
		"\b\3\t\3\t\3\t\7\t\u0086\n\t\f\t\16\t\u0089\13\t\3\t\3\t\3\t\7\t\u008e"+
		"\n\t\f\t\16\t\u0091\13\t\5\t\u0093\n\t\3\n\3\n\3\n\7\n\u0098\n\n\f\n\16"+
		"\n\u009b\13\n\3\n\3\n\3\n\7\n\u00a0\n\n\f\n\16\n\u00a3\13\n\3\n\3\n\3"+
		"\n\7\n\u00a8\n\n\f\n\16\n\u00ab\13\n\3\n\3\n\3\n\7\n\u00b0\n\n\f\n\16"+
		"\n\u00b3\13\n\5\n\u00b5\n\n\3\13\3\13\3\13\7\13\u00ba\n\13\f\13\16\13"+
		"\u00bd\13\13\3\13\3\13\3\13\7\13\u00c2\n\13\f\13\16\13\u00c5\13\13\5\13"+
		"\u00c7\n\13\3\f\3\f\3\f\7\f\u00cc\n\f\f\f\16\f\u00cf\13\f\3\f\3\f\3\f"+
		"\7\f\u00d4\n\f\f\f\16\f\u00d7\13\f\5\f\u00d9\n\f\3\r\3\r\3\r\7\r\u00de"+
		"\n\r\f\r\16\r\u00e1\13\r\3\r\3\r\3\r\7\r\u00e6\n\r\f\r\16\r\u00e9\13\r"+
		"\3\r\3\r\3\r\7\r\u00ee\n\r\f\r\16\r\u00f1\13\r\5\r\u00f3\n\r\3\16\3\16"+
		"\5\16\u00f7\n\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u0101\n"+
		"\17\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\7\21\u0119\n\21\f\21\16\21"+
		"\u011c\13\21\3\22\3\22\3\22\3\22\5\22\u0122\n\22\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u012f\n\23\3\24\3\24\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\5\25\u0139\n\25\3\26\3\26\3\26\3\26\7\26\u013f\n"+
		"\26\f\26\16\26\u0142\13\26\3\26\3\26\3\26\3\26\3\26\5\26\u0149\n\26\3"+
		"\27\3\27\3\27\3\27\3\27\5\27\u0150\n\27\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\6\30\u0158\n\30\r\30\16\30\u0159\3\30\3\30\6\30\u015e\n\30\r\30\16\30"+
		"\u015f\3\30\3\30\3\30\3\30\6\30\u0166\n\30\r\30\16\30\u0167\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\6\30\u0170\n\30\r\30\16\30\u0171\3\30\3\30\7\30\u0176"+
		"\n\30\f\30\16\30\u0179\13\30\3\30\3\30\3\30\3\30\5\30\u017f\n\30\5\30"+
		"\u0181\n\30\3\31\3\31\3\31\3\31\3\31\3\31\7\31\u0189\n\31\f\31\16\31\u018c"+
		"\13\31\3\32\3\32\3\32\3\32\3\32\5\32\u0193\n\32\3\33\3\33\3\34\3\34\3"+
		"\34\3\34\3\34\3\34\5\34\u019d\n\34\3\34\7\34\u01a0\n\34\f\34\16\34\u01a3"+
		"\13\34\3\35\5\35\u01a6\n\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3"+
		"\35\5\35\u01b1\n\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\5\35\u01c5\n\35\3\35\5\35\u01c8"+
		"\n\35\3\36\3\36\3\36\7\36\u01cd\n\36\f\36\16\36\u01d0\13\36\3\36\3\36"+
		"\3\37\3\37\3\37\5\37\u01d7\n\37\3\37\3\37\5\37\u01db\n\37\3\37\5\37\u01de"+
		"\n\37\3\37\3\37\5\37\u01e2\n\37\3\37\3\37\5\37\u01e6\n\37\5\37\u01e8\n"+
		"\37\3 \3 \3 \3 \7 \u01ee\n \f \16 \u01f1\13 \3 \5 \u01f4\n \3!\5!\u01f7"+
		"\n!\3!\3!\3!\3\"\3\"\3\"\5\"\u01ff\n\"\3\"\3\"\3#\3#\3#\7#\u0206\n#\f"+
		"#\16#\u0209\13#\3$\3$\3$\3%\3%\5%\u0210\n%\3%\3%\7%\u0214\n%\f%\16%\u0217"+
		"\13%\3%\3%\3%\5%\u021c\n%\3&\3&\5&\u0220\n&\3&\2\5 \60\66\'\2\4\6\b\n"+
		"\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJ\2\3\5\2)"+
		")++\65\66\2\u025a\2O\3\2\2\2\4X\3\2\2\2\6Z\3\2\2\2\bb\3\2\2\2\nj\3\2\2"+
		"\2\fr\3\2\2\2\16z\3\2\2\2\20\u0092\3\2\2\2\22\u00b4\3\2\2\2\24\u00c6\3"+
		"\2\2\2\26\u00d8\3\2\2\2\30\u00f2\3\2\2\2\32\u00f6\3\2\2\2\34\u0100\3\2"+
		"\2\2\36\u0102\3\2\2\2 \u0104\3\2\2\2\"\u0121\3\2\2\2$\u012e\3\2\2\2&\u0130"+
		"\3\2\2\2(\u0138\3\2\2\2*\u0148\3\2\2\2,\u014f\3\2\2\2.\u0180\3\2\2\2\60"+
		"\u0182\3\2\2\2\62\u0192\3\2\2\2\64\u0194\3\2\2\2\66\u0196\3\2\2\28\u01c7"+
		"\3\2\2\2:\u01c9\3\2\2\2<\u01e7\3\2\2\2>\u01f3\3\2\2\2@\u01f6\3\2\2\2B"+
		"\u01fb\3\2\2\2D\u0202\3\2\2\2F\u020a\3\2\2\2H\u021b\3\2\2\2J\u021f\3\2"+
		"\2\2LN\5\4\3\2ML\3\2\2\2NQ\3\2\2\2OM\3\2\2\2OP\3\2\2\2PR\3\2\2\2QO\3\2"+
		"\2\2RS\7\2\2\3S\3\3\2\2\2TY\5@!\2UY\5H%\2VY\5*\26\2WY\79\2\2XT\3\2\2\2"+
		"XU\3\2\2\2XV\3\2\2\2XW\3\2\2\2Y\5\3\2\2\2Z_\5\b\5\2[\\\7\63\2\2\\^\5\b"+
		"\5\2][\3\2\2\2^a\3\2\2\2_]\3\2\2\2_`\3\2\2\2`\7\3\2\2\2a_\3\2\2\2bg\5"+
		"\n\6\2cd\7\62\2\2df\5\n\6\2ec\3\2\2\2fi\3\2\2\2ge\3\2\2\2gh\3\2\2\2h\t"+
		"\3\2\2\2ig\3\2\2\2jo\5\f\7\2kl\7\61\2\2ln\5\f\7\2mk\3\2\2\2nq\3\2\2\2"+
		"om\3\2\2\2op\3\2\2\2p\13\3\2\2\2qo\3\2\2\2rw\5\16\b\2st\7\64\2\2tv\5\16"+
		"\b\2us\3\2\2\2vy\3\2\2\2wu\3\2\2\2wx\3\2\2\2x\r\3\2\2\2yw\3\2\2\2z\177"+
		"\5\20\t\2{|\7\60\2\2|~\5\20\t\2}{\3\2\2\2~\u0081\3\2\2\2\177}\3\2\2\2"+
		"\177\u0080\3\2\2\2\u0080\17\3\2\2\2\u0081\177\3\2\2\2\u0082\u0087\5\22"+
		"\n\2\u0083\u0084\7<\2\2\u0084\u0086\5\22\n\2\u0085\u0083\3\2\2\2\u0086"+
		"\u0089\3\2\2\2\u0087\u0085\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u0093\3\2"+
		"\2\2\u0089\u0087\3\2\2\2\u008a\u008f\5\22\n\2\u008b\u008c\7=\2\2\u008c"+
		"\u008e\5\22\n\2\u008d\u008b\3\2\2\2\u008e\u0091\3\2\2\2\u008f\u008d\3"+
		"\2\2\2\u008f\u0090\3\2\2\2\u0090\u0093\3\2\2\2\u0091\u008f\3\2\2\2\u0092"+
		"\u0082\3\2\2\2\u0092\u008a\3\2\2\2\u0093\21\3\2\2\2\u0094\u0099\5\24\13"+
		"\2\u0095\u0096\7#\2\2\u0096\u0098\5\24\13\2\u0097\u0095\3\2\2\2\u0098"+
		"\u009b\3\2\2\2\u0099\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u00b5\3\2"+
		"\2\2\u009b\u0099\3\2\2\2\u009c\u00a1\5\24\13\2\u009d\u009e\7%\2\2\u009e"+
		"\u00a0\5\24\13\2\u009f\u009d\3\2\2\2\u00a0\u00a3\3\2\2\2\u00a1\u009f\3"+
		"\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00b5\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a4"+
		"\u00a9\5\24\13\2\u00a5\u00a6\7$\2\2\u00a6\u00a8\5\24\13\2\u00a7\u00a5"+
		"\3\2\2\2\u00a8\u00ab\3\2\2\2\u00a9\u00a7\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa"+
		"\u00b5\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ac\u00b1\5\24\13\2\u00ad\u00ae\7"+
		"&\2\2\u00ae\u00b0\5\24\13\2\u00af\u00ad\3\2\2\2\u00b0\u00b3\3\2\2\2\u00b1"+
		"\u00af\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b5\3\2\2\2\u00b3\u00b1\3\2"+
		"\2\2\u00b4\u0094\3\2\2\2\u00b4\u009c\3\2\2\2\u00b4\u00a4\3\2\2\2\u00b4"+
		"\u00ac\3\2\2\2\u00b5\23\3\2\2\2\u00b6\u00bb\5\26\f\2\u00b7\u00b8\7(\2"+
		"\2\u00b8\u00ba\5\26\f\2\u00b9\u00b7\3\2\2\2\u00ba\u00bd\3\2\2\2\u00bb"+
		"\u00b9\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\u00c7\3\2\2\2\u00bd\u00bb\3\2"+
		"\2\2\u00be\u00c3\5\26\f\2\u00bf\u00c0\7\'\2\2\u00c0\u00c2\5\26\f\2\u00c1"+
		"\u00bf\3\2\2\2\u00c2\u00c5\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c3\u00c4\3\2"+
		"\2\2\u00c4\u00c7\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c6\u00b6\3\2\2\2\u00c6"+
		"\u00be\3\2\2\2\u00c7\25\3\2\2\2\u00c8\u00cd\5\30\r\2\u00c9\u00ca\7)\2"+
		"\2\u00ca\u00cc\5\30\r\2\u00cb\u00c9\3\2\2\2\u00cc\u00cf\3\2\2\2\u00cd"+
		"\u00cb\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce\u00d9\3\2\2\2\u00cf\u00cd\3\2"+
		"\2\2\u00d0\u00d5\5\30\r\2\u00d1\u00d2\7+\2\2\u00d2\u00d4\5\30\r\2\u00d3"+
		"\u00d1\3\2\2\2\u00d4\u00d7\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d5\u00d6\3\2"+
		"\2\2\u00d6\u00d9\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d8\u00c8\3\2\2\2\u00d8"+
		"\u00d0\3\2\2\2\u00d9\27\3\2\2\2\u00da\u00df\5\32\16\2\u00db\u00dc\7-\2"+
		"\2\u00dc\u00de\5\32\16\2\u00dd\u00db\3\2\2\2\u00de\u00e1\3\2\2\2\u00df"+
		"\u00dd\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0\u00f3\3\2\2\2\u00e1\u00df\3\2"+
		"\2\2\u00e2\u00e7\5\32\16\2\u00e3\u00e4\7.\2\2\u00e4\u00e6\5\32\16\2\u00e5"+
		"\u00e3\3\2\2\2\u00e6\u00e9\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e7\u00e8\3\2"+
		"\2\2\u00e8\u00f3\3\2\2\2\u00e9\u00e7\3\2\2\2\u00ea\u00ef\5\32\16\2\u00eb"+
		"\u00ec\7/\2\2\u00ec\u00ee\5\32\16\2\u00ed\u00eb\3\2\2\2\u00ee\u00f1\3"+
		"\2\2\2\u00ef\u00ed\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\u00f3\3\2\2\2\u00f1"+
		"\u00ef\3\2\2\2\u00f2\u00da\3\2\2\2\u00f2\u00e2\3\2\2\2\u00f2\u00ea\3\2"+
		"\2\2\u00f3\31\3\2\2\2\u00f4\u00f7\5\34\17\2\u00f5\u00f7\7\n\2\2\u00f6"+
		"\u00f4\3\2\2\2\u00f6\u00f5\3\2\2\2\u00f7\33\3\2\2\2\u00f8\u00f9\7*\2\2"+
		"\u00f9\u0101\5\34\17\2\u00fa\u00fb\7,\2\2\u00fb\u0101\5\34\17\2\u00fc"+
		"\u00fd\5\36\20\2\u00fd\u00fe\5\32\16\2\u00fe\u0101\3\2\2\2\u00ff\u0101"+
		"\5 \21\2\u0100\u00f8\3\2\2\2\u0100\u00fa\3\2\2\2\u0100\u00fc\3\2\2\2\u0100"+
		"\u00ff\3\2\2\2\u0101\35\3\2\2\2\u0102\u0103\t\2\2\2\u0103\37\3\2\2\2\u0104"+
		"\u0105\b\21\1\2\u0105\u0106\5$\23\2\u0106\u011a\3\2\2\2\u0107\u0108\f"+
		"\7\2\2\u0108\u0119\7*\2\2\u0109\u010a\f\6\2\2\u010a\u0119\7,\2\2\u010b"+
		"\u010c\f\5\2\2\u010c\u010d\7\37\2\2\u010d\u010e\5(\25\2\u010e\u010f\7"+
		" \2\2\u010f\u0119\3\2\2\2\u0110\u0111\f\4\2\2\u0111\u0112\7?\2\2\u0112"+
		"\u0119\7\b\2\2\u0113\u0114\f\3\2\2\u0114\u0115\7\35\2\2\u0115\u0116\5"+
		"\"\22\2\u0116\u0117\7\36\2\2\u0117\u0119\3\2\2\2\u0118\u0107\3\2\2\2\u0118"+
		"\u0109\3\2\2\2\u0118\u010b\3\2\2\2\u0118\u0110\3\2\2\2\u0118\u0113\3\2"+
		"\2\2\u0119\u011c\3\2\2\2\u011a\u0118\3\2\2\2\u011a\u011b\3\2\2\2\u011b"+
		"!\3\2\2\2\u011c\u011a\3\2\2\2\u011d\u011e\5(\25\2\u011e\u011f\7:\2\2\u011f"+
		"\u0120\5(\25\2\u0120\u0122\3\2\2\2\u0121\u011d\3\2\2\2\u0121\u0122\3\2"+
		"\2\2\u0122#\3\2\2\2\u0123\u012f\7\3\2\2\u0124\u012f\7\4\2\2\u0125\u012f"+
		"\7\5\2\2\u0126\u012f\7\6\2\2\u0127\u012f\7\b\2\2\u0128\u012f\7\13\2\2"+
		"\u0129\u012f\7\t\2\2\u012a\u012b\7\35\2\2\u012b\u012c\5(\25\2\u012c\u012d"+
		"\7\36\2\2\u012d\u012f\3\2\2\2\u012e\u0123\3\2\2\2\u012e\u0124\3\2\2\2"+
		"\u012e\u0125\3\2\2\2\u012e\u0126\3\2\2\2\u012e\u0127\3\2\2\2\u012e\u0128"+
		"\3\2\2\2\u012e\u0129\3\2\2\2\u012e\u012a\3\2\2\2\u012f%\3\2\2\2\u0130"+
		"\u0131\5\6\4\2\u0131\'\3\2\2\2\u0132\u0139\5.\30\2\u0133\u0139\5&\24\2"+
		"\u0134\u0135\5\34\17\2\u0135\u0136\7;\2\2\u0136\u0137\5(\25\2\u0137\u0139"+
		"\3\2\2\2\u0138\u0132\3\2\2\2\u0138\u0133\3\2\2\2\u0138\u0134\3\2\2\2\u0139"+
		")\3\2\2\2\u013a\u013b\5\60\31\2\u013b\u0140\5,\27\2\u013c\u013d\7:\2\2"+
		"\u013d\u013f\5,\27\2\u013e\u013c\3\2\2\2\u013f\u0142\3\2\2\2\u0140\u013e"+
		"\3\2\2\2\u0140\u0141\3\2\2\2\u0141\u0143\3\2\2\2\u0142\u0140\3\2\2\2\u0143"+
		"\u0144\79\2\2\u0144\u0149\3\2\2\2\u0145\u0146\5\60\31\2\u0146\u0147\7"+
		"9\2\2\u0147\u0149\3\2\2\2\u0148\u013a\3\2\2\2\u0148\u0145\3\2\2\2\u0149"+
		"+\3\2\2\2\u014a\u0150\5\66\34\2\u014b\u014c\5\66\34\2\u014c\u014d\7;\2"+
		"\2\u014d\u014e\5(\25\2\u014e\u0150\3\2\2\2\u014f\u014a\3\2\2\2\u014f\u014b"+
		"\3\2\2\2\u0150-\3\2\2\2\u0151\u0152\7@\2\2\u0152\u0157\5\62\32\2\u0153"+
		"\u0154\7\37\2\2\u0154\u0155\5(\25\2\u0155\u0156\7 \2\2\u0156\u0158\3\2"+
		"\2\2\u0157\u0153\3\2\2\2\u0158\u0159\3\2\2\2\u0159\u0157\3\2\2\2\u0159"+
		"\u015a\3\2\2\2\u015a\u015d\3\2\2\2\u015b\u015c\7\37\2\2\u015c\u015e\7"+
		" \2\2\u015d\u015b\3\2\2\2\u015e\u015f\3\2\2\2\u015f\u015d\3\2\2\2\u015f"+
		"\u0160\3\2\2\2\u0160\u0165\3\2\2\2\u0161\u0162\7\37\2\2\u0162\u0163\5"+
		"(\25\2\u0163\u0164\7 \2\2\u0164\u0166\3\2\2\2\u0165\u0161\3\2\2\2\u0166"+
		"\u0167\3\2\2\2\u0167\u0165\3\2\2\2\u0167\u0168\3\2\2\2\u0168\u0181\3\2"+
		"\2\2\u0169\u016a\7@\2\2\u016a\u016f\5\62\32\2\u016b\u016c\7\37\2\2\u016c"+
		"\u016d\5(\25\2\u016d\u016e\7 \2\2\u016e\u0170\3\2\2\2\u016f\u016b\3\2"+
		"\2\2\u0170\u0171\3\2\2\2\u0171\u016f\3\2\2\2\u0171\u0172\3\2\2\2\u0172"+
		"\u0177\3\2\2\2\u0173\u0174\7\37\2\2\u0174\u0176\7 \2\2\u0175\u0173\3\2"+
		"\2\2\u0176\u0179\3\2\2\2\u0177\u0175\3\2\2\2\u0177\u0178\3\2\2\2\u0178"+
		"\u0181\3\2\2\2\u0179\u0177\3\2\2\2\u017a\u017b\7@\2\2\u017b\u017e\5\62"+
		"\32\2\u017c\u017d\7\35\2\2\u017d\u017f\7\36\2\2\u017e\u017c\3\2\2\2\u017e"+
		"\u017f\3\2\2\2\u017f\u0181\3\2\2\2\u0180\u0151\3\2\2\2\u0180\u0169\3\2"+
		"\2\2\u0180\u017a\3\2\2\2\u0181/\3\2\2\2\u0182\u0183\b\31\1\2\u0183\u0184"+
		"\5\62\32\2\u0184\u018a\3\2\2\2\u0185\u0186\f\3\2\2\u0186\u0187\7\37\2"+
		"\2\u0187\u0189\7 \2\2\u0188\u0185\3\2\2\2\u0189\u018c\3\2\2\2\u018a\u0188"+
		"\3\2\2\2\u018a\u018b\3\2\2\2\u018b\61\3\2\2\2\u018c\u018a\3\2\2\2\u018d"+
		"\u0193\7\32\2\2\u018e\u0193\7\26\2\2\u018f\u0193\7\7\2\2\u0190\u0193\7"+
		"\34\2\2\u0191\u0193\5\64\33\2\u0192\u018d\3\2\2\2\u0192\u018e\3\2\2\2"+
		"\u0192\u018f\3\2\2\2\u0192\u0190\3\2\2\2\u0192\u0191\3\2\2\2\u0193\63"+
		"\3\2\2\2\u0194\u0195\7\b\2\2\u0195\65\3\2\2\2\u0196\u0197\b\34\1\2\u0197"+
		"\u0198\7\b\2\2\u0198\u01a1\3\2\2\2\u0199\u019a\f\3\2\2\u019a\u019c\7\35"+
		"\2\2\u019b\u019d\5D#\2\u019c\u019b\3\2\2\2\u019c\u019d\3\2\2\2\u019d\u019e"+
		"\3\2\2\2\u019e\u01a0\7\36\2\2\u019f\u0199\3\2\2\2\u01a0\u01a3\3\2\2\2"+
		"\u01a1\u019f\3\2\2\2\u01a1\u01a2\3\2\2\2\u01a2\67\3\2\2\2\u01a3\u01a1"+
		"\3\2\2\2\u01a4\u01a6\5(\25\2\u01a5\u01a4\3\2\2\2\u01a5\u01a6\3\2\2\2\u01a6"+
		"\u01a7\3\2\2\2\u01a7\u01c8\79\2\2\u01a8\u01c8\5:\36\2\u01a9\u01aa\7\25"+
		"\2\2\u01aa\u01ab\7\35\2\2\u01ab\u01ac\5(\25\2\u01ac\u01ad\7\36\2\2\u01ad"+
		"\u01b0\58\35\2\u01ae\u01af\7\23\2\2\u01af\u01b1\58\35\2\u01b0\u01ae\3"+
		"\2\2\2\u01b0\u01b1\3\2\2\2\u01b1\u01c8\3\2\2\2\u01b2\u01b3\7\33\2\2\u01b3"+
		"\u01b4\7\35\2\2\u01b4\u01b5\5(\25\2\u01b5\u01b6\7\36\2\2\u01b6\u01b7\5"+
		"8\35\2\u01b7\u01c8\3\2\2\2\u01b8\u01b9\7\24\2\2\u01b9\u01ba\7\35\2\2\u01ba"+
		"\u01bb\5<\37\2\u01bb\u01bc\7\36\2\2\u01bc\u01bd\58\35\2\u01bd\u01c8\3"+
		"\2\2\2\u01be\u01bf\7\21\2\2\u01bf\u01c8\79\2\2\u01c0\u01c1\7\20\2\2\u01c1"+
		"\u01c8\79\2\2\u01c2\u01c4\7\30\2\2\u01c3\u01c5\5(\25\2\u01c4\u01c3\3\2"+
		"\2\2\u01c4\u01c5\3\2\2\2\u01c5\u01c6\3\2\2\2\u01c6\u01c8\79\2\2\u01c7"+
		"\u01a5\3\2\2\2\u01c7\u01a8\3\2\2\2\u01c7\u01a9\3\2\2\2\u01c7\u01b2\3\2"+
		"\2\2\u01c7\u01b8\3\2\2\2\u01c7\u01be\3\2\2\2\u01c7\u01c0\3\2\2\2\u01c7"+
		"\u01c2\3\2\2\2\u01c89\3\2\2\2\u01c9\u01ce\7!\2\2\u01ca\u01cd\58\35\2\u01cb"+
		"\u01cd\5*\26\2\u01cc\u01ca\3\2\2\2\u01cc\u01cb\3\2\2\2\u01cd\u01d0\3\2"+
		"\2\2\u01ce\u01cc\3\2\2\2\u01ce\u01cf\3\2\2\2\u01cf\u01d1\3\2\2\2\u01d0"+
		"\u01ce\3\2\2\2\u01d1\u01d2\7\"\2\2\u01d2;\3\2\2\2\u01d3\u01d4\5> \2\u01d4"+
		"\u01d6\79\2\2\u01d5\u01d7\5(\25\2\u01d6\u01d5\3\2\2\2\u01d6\u01d7\3\2"+
		"\2\2\u01d7\u01d8\3\2\2\2\u01d8\u01da\79\2\2\u01d9\u01db\5(\25\2\u01da"+
		"\u01d9\3\2\2\2\u01da\u01db\3\2\2\2\u01db\u01e8\3\2\2\2\u01dc\u01de\5("+
		"\25\2\u01dd\u01dc\3\2\2\2\u01dd\u01de\3\2\2\2\u01de\u01df\3\2\2\2\u01df"+
		"\u01e1\79\2\2\u01e0\u01e2\5(\25\2\u01e1\u01e0\3\2\2\2\u01e1\u01e2\3\2"+
		"\2\2\u01e2\u01e3\3\2\2\2\u01e3\u01e5\79\2\2\u01e4\u01e6\5(\25\2\u01e5"+
		"\u01e4\3\2\2\2\u01e5\u01e6\3\2\2\2\u01e6\u01e8\3\2\2\2\u01e7\u01d3\3\2"+
		"\2\2\u01e7\u01dd\3\2\2\2\u01e8=\3\2\2\2\u01e9\u01ea\5\60\31\2\u01ea\u01ef"+
		"\5,\27\2\u01eb\u01ec\7:\2\2\u01ec\u01ee\5,\27\2\u01ed\u01eb\3\2\2\2\u01ee"+
		"\u01f1\3\2\2\2\u01ef\u01ed\3\2\2\2\u01ef\u01f0\3\2\2\2\u01f0\u01f4\3\2"+
		"\2\2\u01f1\u01ef\3\2\2\2\u01f2\u01f4\5\60\31\2\u01f3\u01e9\3\2\2\2\u01f3"+
		"\u01f2\3\2\2\2\u01f4?\3\2\2\2\u01f5\u01f7\5\60\31\2\u01f6\u01f5\3\2\2"+
		"\2\u01f6\u01f7\3\2\2\2\u01f7\u01f8\3\2\2\2\u01f8\u01f9\5B\"\2\u01f9\u01fa"+
		"\5:\36\2\u01faA\3\2\2\2\u01fb\u01fc\5\64\33\2\u01fc\u01fe\7\35\2\2\u01fd"+
		"\u01ff\5D#\2\u01fe\u01fd\3\2\2\2\u01fe\u01ff\3\2\2\2\u01ff\u0200\3\2\2"+
		"\2\u0200\u0201\7\36\2\2\u0201C\3\2\2\2\u0202\u0207\5F$\2\u0203\u0204\7"+
		":\2\2\u0204\u0206\5F$\2\u0205\u0203\3\2\2\2\u0206\u0209\3\2\2\2\u0207"+
		"\u0205\3\2\2\2\u0207\u0208\3\2\2\2\u0208E\3\2\2\2\u0209\u0207\3\2\2\2"+
		"\u020a\u020b\5\60\31\2\u020b\u020c\7\b\2\2\u020cG\3\2\2\2\u020d\u020f"+
		"\7\31\2\2\u020e\u0210\7\b\2\2\u020f\u020e\3\2\2\2\u020f\u0210\3\2\2\2"+
		"\u0210\u0211\3\2\2\2\u0211\u0215\7!\2\2\u0212\u0214\5J&\2\u0213\u0212"+
		"\3\2\2\2\u0214\u0217\3\2\2\2\u0215\u0213\3\2\2\2\u0215\u0216\3\2\2\2\u0216"+
		"\u0218\3\2\2\2\u0217\u0215\3\2\2\2\u0218\u021c\7\"\2\2\u0219\u021a\7\31"+
		"\2\2\u021a\u021c\7\b\2\2\u021b\u020d\3\2\2\2\u021b\u0219\3\2\2\2\u021c"+
		"I\3\2\2\2\u021d\u0220\5*\26\2\u021e\u0220\5@!\2\u021f\u021d\3\2\2\2\u021f"+
		"\u021e\3\2\2\2\u0220K\3\2\2\2EOX_gow\177\u0087\u008f\u0092\u0099\u00a1"+
		"\u00a9\u00b1\u00b4\u00bb\u00c3\u00c6\u00cd\u00d5\u00d8\u00df\u00e7\u00ef"+
		"\u00f2\u00f6\u0100\u0118\u011a\u0121\u012e\u0138\u0140\u0148\u014f\u0159"+
		"\u015f\u0167\u0171\u0177\u017e\u0180\u018a\u0192\u019c\u01a1\u01a5\u01b0"+
		"\u01c4\u01c7\u01cc\u01ce\u01d6\u01da\u01dd\u01e1\u01e5\u01e7\u01ef\u01f3"+
		"\u01f6\u01fe\u0207\u020f\u0215\u021b\u021f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}