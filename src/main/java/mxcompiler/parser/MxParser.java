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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, Identifier=7, IntegerLiteral=8, 
		StringLiteral=9, Whitespace=10, Newline=11, LineCommnet=12, BlockComment=13, 
		Break=14, Continue=15, Default=16, Else=17, For=18, If=19, Int=20, Long=21, 
		String=22, Return=23, Class=24, Void=25, While=26, Bool=27, Noreturn=28, 
		LeftParen=29, RightParen=30, LeftBracket=31, RightBracket=32, LeftBrace=33, 
		RightBrace=34, Less=35, LessEqual=36, Greater=37, GreaterEqual=38, LeftShift=39, 
		RightShift=40, Plus=41, PlusPlus=42, Minus=43, MinusMinus=44, Star=45, 
		Div=46, Mod=47, And=48, Or=49, AndAnd=50, OrOr=51, Caret=52, Not=53, Tilde=54, 
		Question=55, Colon=56, Semi=57, Comma=58, Assign=59, Equal=60, NotEqual=61, 
		Arrow=62, Dot=63, Ellipsis=64, New=65, DigitSequence=66;
	public static final int
		RULE_primaryExpression = 0, RULE_declarationSpecifier = 1, RULE_postfixExpression = 2, 
		RULE_argumentExpressionList = 3, RULE_unaryExpression = 4, RULE_unaryOperator = 5, 
		RULE_castExpression = 6, RULE_multiplicativeExpression = 7, RULE_additiveExpression = 8, 
		RULE_shiftExpression = 9, RULE_relationalExpression = 10, RULE_equalityExpression = 11, 
		RULE_andExpression = 12, RULE_exclusiveOrExpression = 13, RULE_inclusiveOrExpression = 14, 
		RULE_logicalAndExpression = 15, RULE_logicalOrExpression = 16, RULE_expression = 17, 
		RULE_declaration = 18, RULE_initDeclaratorList = 19, RULE_initDeclarator = 20, 
		RULE_typeSpecifier = 21, RULE_newDeclarator = 22, RULE_directDeclarator = 23, 
		RULE_parameterList = 24, RULE_parameterDeclaration = 25, RULE_typedefName = 26, 
		RULE_statement = 27, RULE_compoundStatement = 28, RULE_blockItem = 29, 
		RULE_expressionStatement = 30, RULE_selectionStatement = 31, RULE_iterationStatement = 32, 
		RULE_forCondition = 33, RULE_forDeclaration = 34, RULE_forExprEnd = 35, 
		RULE_forExprUpdate = 36, RULE_jumpStatement = 37, RULE_program = 38, RULE_programDeclaration = 39, 
		RULE_functionDefinition = 40, RULE_classDefinition = 41, RULE_classDeclaration = 42;
	private static String[] makeRuleNames() {
		return new String[] {
			"primaryExpression", "declarationSpecifier", "postfixExpression", "argumentExpressionList", 
			"unaryExpression", "unaryOperator", "castExpression", "multiplicativeExpression", 
			"additiveExpression", "shiftExpression", "relationalExpression", "equalityExpression", 
			"andExpression", "exclusiveOrExpression", "inclusiveOrExpression", "logicalAndExpression", 
			"logicalOrExpression", "expression", "declaration", "initDeclaratorList", 
			"initDeclarator", "typeSpecifier", "newDeclarator", "directDeclarator", 
			"parameterList", "parameterDeclaration", "typedefName", "statement", 
			"compoundStatement", "blockItem", "expressionStatement", "selectionStatement", 
			"iterationStatement", "forCondition", "forDeclaration", "forExprEnd", 
			"forExprUpdate", "jumpStatement", "program", "programDeclaration", "functionDefinition", 
			"classDefinition", "classDeclaration"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'this'", "'true'", "'false'", "'null'", "'string'", "'bool'", 
			null, null, null, null, null, null, null, "'break'", "'continue'", "'default'", 
			"'else'", "'for'", "'if'", "'int'", "'long'", "'String'", "'return'", 
			"'class'", "'void'", "'while'", "'_Bool'", "'_Noreturn'", "'('", "')'", 
			"'['", "']'", "'{'", "'}'", "'<'", "'<='", "'>'", "'>='", "'<<'", "'>>'", 
			"'+'", "'++'", "'-'", "'--'", "'*'", "'/'", "'%'", "'&'", "'|'", "'&&'", 
			"'||'", "'^'", "'!'", "'~'", "'?'", "':'", "';'", "','", "'='", "'=='", 
			"'!='", "'->'", "'.'", "'...'", "'new'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, "Identifier", "IntegerLiteral", 
			"StringLiteral", "Whitespace", "Newline", "LineCommnet", "BlockComment", 
			"Break", "Continue", "Default", "Else", "For", "If", "Int", "Long", "String", 
			"Return", "Class", "Void", "While", "Bool", "Noreturn", "LeftParen", 
			"RightParen", "LeftBracket", "RightBracket", "LeftBrace", "RightBrace", 
			"Less", "LessEqual", "Greater", "GreaterEqual", "LeftShift", "RightShift", 
			"Plus", "PlusPlus", "Minus", "MinusMinus", "Star", "Div", "Mod", "And", 
			"Or", "AndAnd", "OrOr", "Caret", "Not", "Tilde", "Question", "Colon", 
			"Semi", "Comma", "Assign", "Equal", "NotEqual", "Arrow", "Dot", "Ellipsis", 
			"New", "DigitSequence"
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

	public static class PrimaryExpressionContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(MxParser.Identifier, 0); }
		public TerminalNode IntegerLiteral() { return getToken(MxParser.IntegerLiteral, 0); }
		public TerminalNode StringLiteral() { return getToken(MxParser.StringLiteral, 0); }
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
		enterRule(_localctx, 0, RULE_primaryExpression);
		try {
			setState(97);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(86);
				match(T__0);
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(87);
				match(T__1);
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 3);
				{
				setState(88);
				match(T__2);
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 4);
				{
				setState(89);
				match(T__3);
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 5);
				{
				setState(90);
				match(Identifier);
				}
				break;
			case IntegerLiteral:
				enterOuterAlt(_localctx, 6);
				{
				setState(91);
				match(IntegerLiteral);
				}
				break;
			case StringLiteral:
				enterOuterAlt(_localctx, 7);
				{
				setState(92);
				match(StringLiteral);
				}
				break;
			case LeftParen:
				enterOuterAlt(_localctx, 8);
				{
				setState(93);
				match(LeftParen);
				setState(94);
				expression();
				setState(95);
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

	public static class DeclarationSpecifierContext extends ParserRuleContext {
		public DeclarationSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarationSpecifier; }
	 
		public DeclarationSpecifierContext() { }
		public void copyFrom(DeclarationSpecifierContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DeclarationSpecifier_arrayContext extends DeclarationSpecifierContext {
		public DeclarationSpecifierContext declarationSpecifier() {
			return getRuleContext(DeclarationSpecifierContext.class,0);
		}
		public TerminalNode LeftBracket() { return getToken(MxParser.LeftBracket, 0); }
		public TerminalNode RightBracket() { return getToken(MxParser.RightBracket, 0); }
		public DeclarationSpecifier_arrayContext(DeclarationSpecifierContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterDeclarationSpecifier_array(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitDeclarationSpecifier_array(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitDeclarationSpecifier_array(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DeclarationSpecifier_typeContext extends DeclarationSpecifierContext {
		public TypeSpecifierContext typeSpecifier() {
			return getRuleContext(TypeSpecifierContext.class,0);
		}
		public DeclarationSpecifier_typeContext(DeclarationSpecifierContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterDeclarationSpecifier_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitDeclarationSpecifier_type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitDeclarationSpecifier_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationSpecifierContext declarationSpecifier() throws RecognitionException {
		return declarationSpecifier(0);
	}

	private DeclarationSpecifierContext declarationSpecifier(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		DeclarationSpecifierContext _localctx = new DeclarationSpecifierContext(_ctx, _parentState);
		DeclarationSpecifierContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_declarationSpecifier, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new DeclarationSpecifier_typeContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(100);
			typeSpecifier();
			}
			_ctx.stop = _input.LT(-1);
			setState(107);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new DeclarationSpecifier_arrayContext(new DeclarationSpecifierContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_declarationSpecifier);
					setState(102);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(103);
					match(LeftBracket);
					setState(104);
					match(RightBracket);
					}
					} 
				}
				setState(109);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
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

	public static class PostfixExpressionContext extends ParserRuleContext {
		public PostfixExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfixExpression; }
	 
		public PostfixExpressionContext() { }
		public void copyFrom(PostfixExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PostfixExpression_incContext extends PostfixExpressionContext {
		public PostfixExpressionContext postfixExpression() {
			return getRuleContext(PostfixExpressionContext.class,0);
		}
		public TerminalNode PlusPlus() { return getToken(MxParser.PlusPlus, 0); }
		public PostfixExpression_incContext(PostfixExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterPostfixExpression_inc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitPostfixExpression_inc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitPostfixExpression_inc(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PostfixExpression_funcContext extends PostfixExpressionContext {
		public PostfixExpressionContext postfixExpression() {
			return getRuleContext(PostfixExpressionContext.class,0);
		}
		public TerminalNode LeftParen() { return getToken(MxParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(MxParser.RightParen, 0); }
		public ArgumentExpressionListContext argumentExpressionList() {
			return getRuleContext(ArgumentExpressionListContext.class,0);
		}
		public PostfixExpression_funcContext(PostfixExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterPostfixExpression_func(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitPostfixExpression_func(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitPostfixExpression_func(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PostfixExpression_classContext extends PostfixExpressionContext {
		public PostfixExpressionContext postfixExpression() {
			return getRuleContext(PostfixExpressionContext.class,0);
		}
		public TerminalNode Dot() { return getToken(MxParser.Dot, 0); }
		public TerminalNode Identifier() { return getToken(MxParser.Identifier, 0); }
		public PostfixExpression_classContext(PostfixExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterPostfixExpression_class(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitPostfixExpression_class(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitPostfixExpression_class(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PostfixExpression_primaryContext extends PostfixExpressionContext {
		public PrimaryExpressionContext primaryExpression() {
			return getRuleContext(PrimaryExpressionContext.class,0);
		}
		public PostfixExpression_primaryContext(PostfixExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterPostfixExpression_primary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitPostfixExpression_primary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitPostfixExpression_primary(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PostfixExpression_decContext extends PostfixExpressionContext {
		public PostfixExpressionContext postfixExpression() {
			return getRuleContext(PostfixExpressionContext.class,0);
		}
		public TerminalNode MinusMinus() { return getToken(MxParser.MinusMinus, 0); }
		public PostfixExpression_decContext(PostfixExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterPostfixExpression_dec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitPostfixExpression_dec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitPostfixExpression_dec(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PostfixExpression_arrayContext extends PostfixExpressionContext {
		public PostfixExpressionContext postfixExpression() {
			return getRuleContext(PostfixExpressionContext.class,0);
		}
		public TerminalNode LeftBracket() { return getToken(MxParser.LeftBracket, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RightBracket() { return getToken(MxParser.RightBracket, 0); }
		public PostfixExpression_arrayContext(PostfixExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterPostfixExpression_array(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitPostfixExpression_array(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitPostfixExpression_array(this);
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
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_postfixExpression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new PostfixExpression_primaryContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(111);
			primaryExpression();
			}
			_ctx.stop = _input.LT(-1);
			setState(133);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(131);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						_localctx = new PostfixExpression_arrayContext(new PostfixExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_postfixExpression);
						setState(113);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(114);
						match(LeftBracket);
						setState(115);
						expression();
						setState(116);
						match(RightBracket);
						}
						break;
					case 2:
						{
						_localctx = new PostfixExpression_funcContext(new PostfixExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_postfixExpression);
						setState(118);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(119);
						match(LeftParen);
						setState(121);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << Identifier) | (1L << IntegerLiteral) | (1L << StringLiteral) | (1L << LeftParen) | (1L << Plus) | (1L << PlusPlus) | (1L << Minus) | (1L << MinusMinus) | (1L << Not) | (1L << Tilde))) != 0) || _la==New || _la==DigitSequence) {
							{
							setState(120);
							argumentExpressionList(0);
							}
						}

						setState(123);
						match(RightParen);
						}
						break;
					case 3:
						{
						_localctx = new PostfixExpression_classContext(new PostfixExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_postfixExpression);
						setState(124);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(125);
						match(Dot);
						setState(126);
						match(Identifier);
						}
						break;
					case 4:
						{
						_localctx = new PostfixExpression_incContext(new PostfixExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_postfixExpression);
						setState(127);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(128);
						match(PlusPlus);
						}
						break;
					case 5:
						{
						_localctx = new PostfixExpression_decContext(new PostfixExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_postfixExpression);
						setState(129);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(130);
						match(MinusMinus);
						}
						break;
					}
					} 
				}
				setState(135);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
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

	public static class ArgumentExpressionListContext extends ParserRuleContext {
		public ArgumentExpressionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentExpressionList; }
	 
		public ArgumentExpressionListContext() { }
		public void copyFrom(ArgumentExpressionListContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ArgumentExpressionList_singleContext extends ArgumentExpressionListContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ArgumentExpressionList_singleContext(ArgumentExpressionListContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterArgumentExpressionList_single(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitArgumentExpressionList_single(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitArgumentExpressionList_single(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArgumentExpressionList_multiContext extends ArgumentExpressionListContext {
		public ArgumentExpressionListContext argumentExpressionList() {
			return getRuleContext(ArgumentExpressionListContext.class,0);
		}
		public TerminalNode Comma() { return getToken(MxParser.Comma, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ArgumentExpressionList_multiContext(ArgumentExpressionListContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterArgumentExpressionList_multi(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitArgumentExpressionList_multi(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitArgumentExpressionList_multi(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentExpressionListContext argumentExpressionList() throws RecognitionException {
		return argumentExpressionList(0);
	}

	private ArgumentExpressionListContext argumentExpressionList(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ArgumentExpressionListContext _localctx = new ArgumentExpressionListContext(_ctx, _parentState);
		ArgumentExpressionListContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_argumentExpressionList, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new ArgumentExpressionList_singleContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(137);
			expression();
			}
			_ctx.stop = _input.LT(-1);
			setState(144);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ArgumentExpressionList_multiContext(new ArgumentExpressionListContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_argumentExpressionList);
					setState(139);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(140);
					match(Comma);
					setState(141);
					expression();
					}
					} 
				}
				setState(146);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
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
	public static class UnaryExpression_postfixContext extends UnaryExpressionContext {
		public PostfixExpressionContext postfixExpression() {
			return getRuleContext(PostfixExpressionContext.class,0);
		}
		public UnaryExpression_postfixContext(UnaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterUnaryExpression_postfix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitUnaryExpression_postfix(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitUnaryExpression_postfix(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnaryExpression_prefix_decContext extends UnaryExpressionContext {
		public TerminalNode MinusMinus() { return getToken(MxParser.MinusMinus, 0); }
		public UnaryExpressionContext unaryExpression() {
			return getRuleContext(UnaryExpressionContext.class,0);
		}
		public UnaryExpression_prefix_decContext(UnaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterUnaryExpression_prefix_dec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitUnaryExpression_prefix_dec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitUnaryExpression_prefix_dec(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnaryExpression_prefix_incContext extends UnaryExpressionContext {
		public TerminalNode PlusPlus() { return getToken(MxParser.PlusPlus, 0); }
		public UnaryExpressionContext unaryExpression() {
			return getRuleContext(UnaryExpressionContext.class,0);
		}
		public UnaryExpression_prefix_incContext(UnaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterUnaryExpression_prefix_inc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitUnaryExpression_prefix_inc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitUnaryExpression_prefix_inc(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnaryExpression_prefixContext extends UnaryExpressionContext {
		public UnaryOperatorContext unaryOperator() {
			return getRuleContext(UnaryOperatorContext.class,0);
		}
		public CastExpressionContext castExpression() {
			return getRuleContext(CastExpressionContext.class,0);
		}
		public UnaryExpression_prefixContext(UnaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterUnaryExpression_prefix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitUnaryExpression_prefix(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitUnaryExpression_prefix(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryExpressionContext unaryExpression() throws RecognitionException {
		UnaryExpressionContext _localctx = new UnaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_unaryExpression);
		try {
			setState(155);
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
				_localctx = new UnaryExpression_postfixContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(147);
				postfixExpression(0);
				}
				break;
			case PlusPlus:
				_localctx = new UnaryExpression_prefix_incContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(148);
				match(PlusPlus);
				setState(149);
				unaryExpression();
				}
				break;
			case MinusMinus:
				_localctx = new UnaryExpression_prefix_decContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(150);
				match(MinusMinus);
				setState(151);
				unaryExpression();
				}
				break;
			case Plus:
			case Minus:
			case Not:
			case Tilde:
				_localctx = new UnaryExpression_prefixContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(152);
				unaryOperator();
				setState(153);
				castExpression();
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
		public TerminalNode Tilde() { return getToken(MxParser.Tilde, 0); }
		public TerminalNode Not() { return getToken(MxParser.Not, 0); }
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
		enterRule(_localctx, 10, RULE_unaryOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
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

	public static class CastExpressionContext extends ParserRuleContext {
		public UnaryExpressionContext unaryExpression() {
			return getRuleContext(UnaryExpressionContext.class,0);
		}
		public TerminalNode DigitSequence() { return getToken(MxParser.DigitSequence, 0); }
		public CastExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_castExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterCastExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitCastExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitCastExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CastExpressionContext castExpression() throws RecognitionException {
		CastExpressionContext _localctx = new CastExpressionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_castExpression);
		try {
			setState(161);
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
				setState(159);
				unaryExpression();
				}
				break;
			case DigitSequence:
				enterOuterAlt(_localctx, 2);
				{
				setState(160);
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

	public static class MultiplicativeExpressionContext extends ParserRuleContext {
		public MultiplicativeExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicativeExpression; }
	 
		public MultiplicativeExpressionContext() { }
		public void copyFrom(MultiplicativeExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MultiplicativeExpression_unaryContext extends MultiplicativeExpressionContext {
		public CastExpressionContext castExpression() {
			return getRuleContext(CastExpressionContext.class,0);
		}
		public MultiplicativeExpression_unaryContext(MultiplicativeExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterMultiplicativeExpression_unary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitMultiplicativeExpression_unary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitMultiplicativeExpression_unary(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MultiplicativeExpression_modContext extends MultiplicativeExpressionContext {
		public MultiplicativeExpressionContext multiplicativeExpression() {
			return getRuleContext(MultiplicativeExpressionContext.class,0);
		}
		public TerminalNode Mod() { return getToken(MxParser.Mod, 0); }
		public CastExpressionContext castExpression() {
			return getRuleContext(CastExpressionContext.class,0);
		}
		public MultiplicativeExpression_modContext(MultiplicativeExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterMultiplicativeExpression_mod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitMultiplicativeExpression_mod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitMultiplicativeExpression_mod(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MultiplicativeExpression_divContext extends MultiplicativeExpressionContext {
		public MultiplicativeExpressionContext multiplicativeExpression() {
			return getRuleContext(MultiplicativeExpressionContext.class,0);
		}
		public TerminalNode Div() { return getToken(MxParser.Div, 0); }
		public CastExpressionContext castExpression() {
			return getRuleContext(CastExpressionContext.class,0);
		}
		public MultiplicativeExpression_divContext(MultiplicativeExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterMultiplicativeExpression_div(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitMultiplicativeExpression_div(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitMultiplicativeExpression_div(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MultiplicativeExpression_mulContext extends MultiplicativeExpressionContext {
		public MultiplicativeExpressionContext multiplicativeExpression() {
			return getRuleContext(MultiplicativeExpressionContext.class,0);
		}
		public TerminalNode Star() { return getToken(MxParser.Star, 0); }
		public CastExpressionContext castExpression() {
			return getRuleContext(CastExpressionContext.class,0);
		}
		public MultiplicativeExpression_mulContext(MultiplicativeExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterMultiplicativeExpression_mul(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitMultiplicativeExpression_mul(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitMultiplicativeExpression_mul(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultiplicativeExpressionContext multiplicativeExpression() throws RecognitionException {
		return multiplicativeExpression(0);
	}

	private MultiplicativeExpressionContext multiplicativeExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		MultiplicativeExpressionContext _localctx = new MultiplicativeExpressionContext(_ctx, _parentState);
		MultiplicativeExpressionContext _prevctx = _localctx;
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_multiplicativeExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new MultiplicativeExpression_unaryContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(164);
			castExpression();
			}
			_ctx.stop = _input.LT(-1);
			setState(177);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(175);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
					case 1:
						{
						_localctx = new MultiplicativeExpression_mulContext(new MultiplicativeExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_multiplicativeExpression);
						setState(166);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(167);
						match(Star);
						setState(168);
						castExpression();
						}
						break;
					case 2:
						{
						_localctx = new MultiplicativeExpression_divContext(new MultiplicativeExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_multiplicativeExpression);
						setState(169);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(170);
						match(Div);
						setState(171);
						castExpression();
						}
						break;
					case 3:
						{
						_localctx = new MultiplicativeExpression_modContext(new MultiplicativeExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_multiplicativeExpression);
						setState(172);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(173);
						match(Mod);
						setState(174);
						castExpression();
						}
						break;
					}
					} 
				}
				setState(179);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
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

	public static class AdditiveExpressionContext extends ParserRuleContext {
		public AdditiveExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additiveExpression; }
	 
		public AdditiveExpressionContext() { }
		public void copyFrom(AdditiveExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AdditiveExpression_subContext extends AdditiveExpressionContext {
		public AdditiveExpressionContext additiveExpression() {
			return getRuleContext(AdditiveExpressionContext.class,0);
		}
		public TerminalNode Minus() { return getToken(MxParser.Minus, 0); }
		public MultiplicativeExpressionContext multiplicativeExpression() {
			return getRuleContext(MultiplicativeExpressionContext.class,0);
		}
		public AdditiveExpression_subContext(AdditiveExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterAdditiveExpression_sub(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitAdditiveExpression_sub(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitAdditiveExpression_sub(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AdditiveExpression_addContext extends AdditiveExpressionContext {
		public AdditiveExpressionContext additiveExpression() {
			return getRuleContext(AdditiveExpressionContext.class,0);
		}
		public TerminalNode Plus() { return getToken(MxParser.Plus, 0); }
		public MultiplicativeExpressionContext multiplicativeExpression() {
			return getRuleContext(MultiplicativeExpressionContext.class,0);
		}
		public AdditiveExpression_addContext(AdditiveExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterAdditiveExpression_add(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitAdditiveExpression_add(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitAdditiveExpression_add(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AdditiveExpression_unaryContext extends AdditiveExpressionContext {
		public MultiplicativeExpressionContext multiplicativeExpression() {
			return getRuleContext(MultiplicativeExpressionContext.class,0);
		}
		public AdditiveExpression_unaryContext(AdditiveExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterAdditiveExpression_unary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitAdditiveExpression_unary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitAdditiveExpression_unary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AdditiveExpressionContext additiveExpression() throws RecognitionException {
		return additiveExpression(0);
	}

	private AdditiveExpressionContext additiveExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AdditiveExpressionContext _localctx = new AdditiveExpressionContext(_ctx, _parentState);
		AdditiveExpressionContext _prevctx = _localctx;
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_additiveExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new AdditiveExpression_unaryContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(181);
			multiplicativeExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(191);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(189);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
					case 1:
						{
						_localctx = new AdditiveExpression_addContext(new AdditiveExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_additiveExpression);
						setState(183);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(184);
						match(Plus);
						setState(185);
						multiplicativeExpression(0);
						}
						break;
					case 2:
						{
						_localctx = new AdditiveExpression_subContext(new AdditiveExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_additiveExpression);
						setState(186);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(187);
						match(Minus);
						setState(188);
						multiplicativeExpression(0);
						}
						break;
					}
					} 
				}
				setState(193);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
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

	public static class ShiftExpressionContext extends ParserRuleContext {
		public ShiftExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shiftExpression; }
	 
		public ShiftExpressionContext() { }
		public void copyFrom(ShiftExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ShiftExpression_shrContext extends ShiftExpressionContext {
		public ShiftExpressionContext shiftExpression() {
			return getRuleContext(ShiftExpressionContext.class,0);
		}
		public TerminalNode RightShift() { return getToken(MxParser.RightShift, 0); }
		public AdditiveExpressionContext additiveExpression() {
			return getRuleContext(AdditiveExpressionContext.class,0);
		}
		public ShiftExpression_shrContext(ShiftExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterShiftExpression_shr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitShiftExpression_shr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitShiftExpression_shr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ShiftExpression_unaryContext extends ShiftExpressionContext {
		public AdditiveExpressionContext additiveExpression() {
			return getRuleContext(AdditiveExpressionContext.class,0);
		}
		public ShiftExpression_unaryContext(ShiftExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterShiftExpression_unary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitShiftExpression_unary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitShiftExpression_unary(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ShiftExpression_shlContext extends ShiftExpressionContext {
		public ShiftExpressionContext shiftExpression() {
			return getRuleContext(ShiftExpressionContext.class,0);
		}
		public TerminalNode LeftShift() { return getToken(MxParser.LeftShift, 0); }
		public AdditiveExpressionContext additiveExpression() {
			return getRuleContext(AdditiveExpressionContext.class,0);
		}
		public ShiftExpression_shlContext(ShiftExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterShiftExpression_shl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitShiftExpression_shl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitShiftExpression_shl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ShiftExpressionContext shiftExpression() throws RecognitionException {
		return shiftExpression(0);
	}

	private ShiftExpressionContext shiftExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ShiftExpressionContext _localctx = new ShiftExpressionContext(_ctx, _parentState);
		ShiftExpressionContext _prevctx = _localctx;
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_shiftExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new ShiftExpression_unaryContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(195);
			additiveExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(205);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(203);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
					case 1:
						{
						_localctx = new ShiftExpression_shlContext(new ShiftExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_shiftExpression);
						setState(197);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(198);
						match(LeftShift);
						setState(199);
						additiveExpression(0);
						}
						break;
					case 2:
						{
						_localctx = new ShiftExpression_shrContext(new ShiftExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_shiftExpression);
						setState(200);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(201);
						match(RightShift);
						setState(202);
						additiveExpression(0);
						}
						break;
					}
					} 
				}
				setState(207);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
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

	public static class RelationalExpressionContext extends ParserRuleContext {
		public RelationalExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationalExpression; }
	 
		public RelationalExpressionContext() { }
		public void copyFrom(RelationalExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class RelationalExpression_geContext extends RelationalExpressionContext {
		public RelationalExpressionContext relationalExpression() {
			return getRuleContext(RelationalExpressionContext.class,0);
		}
		public TerminalNode Greater() { return getToken(MxParser.Greater, 0); }
		public ShiftExpressionContext shiftExpression() {
			return getRuleContext(ShiftExpressionContext.class,0);
		}
		public RelationalExpression_geContext(RelationalExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterRelationalExpression_ge(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitRelationalExpression_ge(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitRelationalExpression_ge(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RelationalExpression_unaryContext extends RelationalExpressionContext {
		public ShiftExpressionContext shiftExpression() {
			return getRuleContext(ShiftExpressionContext.class,0);
		}
		public RelationalExpression_unaryContext(RelationalExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterRelationalExpression_unary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitRelationalExpression_unary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitRelationalExpression_unary(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RelationalExpression_geqContext extends RelationalExpressionContext {
		public RelationalExpressionContext relationalExpression() {
			return getRuleContext(RelationalExpressionContext.class,0);
		}
		public TerminalNode GreaterEqual() { return getToken(MxParser.GreaterEqual, 0); }
		public ShiftExpressionContext shiftExpression() {
			return getRuleContext(ShiftExpressionContext.class,0);
		}
		public RelationalExpression_geqContext(RelationalExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterRelationalExpression_geq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitRelationalExpression_geq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitRelationalExpression_geq(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RelationalExpression_leContext extends RelationalExpressionContext {
		public RelationalExpressionContext relationalExpression() {
			return getRuleContext(RelationalExpressionContext.class,0);
		}
		public TerminalNode Less() { return getToken(MxParser.Less, 0); }
		public ShiftExpressionContext shiftExpression() {
			return getRuleContext(ShiftExpressionContext.class,0);
		}
		public RelationalExpression_leContext(RelationalExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterRelationalExpression_le(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitRelationalExpression_le(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitRelationalExpression_le(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RelationalExpression_leqContext extends RelationalExpressionContext {
		public RelationalExpressionContext relationalExpression() {
			return getRuleContext(RelationalExpressionContext.class,0);
		}
		public TerminalNode LessEqual() { return getToken(MxParser.LessEqual, 0); }
		public ShiftExpressionContext shiftExpression() {
			return getRuleContext(ShiftExpressionContext.class,0);
		}
		public RelationalExpression_leqContext(RelationalExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterRelationalExpression_leq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitRelationalExpression_leq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitRelationalExpression_leq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelationalExpressionContext relationalExpression() throws RecognitionException {
		return relationalExpression(0);
	}

	private RelationalExpressionContext relationalExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		RelationalExpressionContext _localctx = new RelationalExpressionContext(_ctx, _parentState);
		RelationalExpressionContext _prevctx = _localctx;
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_relationalExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new RelationalExpression_unaryContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(209);
			shiftExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(225);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(223);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
					case 1:
						{
						_localctx = new RelationalExpression_leContext(new RelationalExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_relationalExpression);
						setState(211);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(212);
						match(Less);
						setState(213);
						shiftExpression(0);
						}
						break;
					case 2:
						{
						_localctx = new RelationalExpression_geContext(new RelationalExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_relationalExpression);
						setState(214);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(215);
						match(Greater);
						setState(216);
						shiftExpression(0);
						}
						break;
					case 3:
						{
						_localctx = new RelationalExpression_leqContext(new RelationalExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_relationalExpression);
						setState(217);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(218);
						match(LessEqual);
						setState(219);
						shiftExpression(0);
						}
						break;
					case 4:
						{
						_localctx = new RelationalExpression_geqContext(new RelationalExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_relationalExpression);
						setState(220);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(221);
						match(GreaterEqual);
						setState(222);
						shiftExpression(0);
						}
						break;
					}
					} 
				}
				setState(227);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
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

	public static class EqualityExpressionContext extends ParserRuleContext {
		public EqualityExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equalityExpression; }
	 
		public EqualityExpressionContext() { }
		public void copyFrom(EqualityExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class EqualityExpression_unaryContext extends EqualityExpressionContext {
		public RelationalExpressionContext relationalExpression() {
			return getRuleContext(RelationalExpressionContext.class,0);
		}
		public EqualityExpression_unaryContext(EqualityExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterEqualityExpression_unary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitEqualityExpression_unary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitEqualityExpression_unary(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EqualityExpression_equalContext extends EqualityExpressionContext {
		public EqualityExpressionContext equalityExpression() {
			return getRuleContext(EqualityExpressionContext.class,0);
		}
		public TerminalNode Equal() { return getToken(MxParser.Equal, 0); }
		public RelationalExpressionContext relationalExpression() {
			return getRuleContext(RelationalExpressionContext.class,0);
		}
		public EqualityExpression_equalContext(EqualityExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterEqualityExpression_equal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitEqualityExpression_equal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitEqualityExpression_equal(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EqualityExpression_inequalContext extends EqualityExpressionContext {
		public EqualityExpressionContext equalityExpression() {
			return getRuleContext(EqualityExpressionContext.class,0);
		}
		public TerminalNode NotEqual() { return getToken(MxParser.NotEqual, 0); }
		public RelationalExpressionContext relationalExpression() {
			return getRuleContext(RelationalExpressionContext.class,0);
		}
		public EqualityExpression_inequalContext(EqualityExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterEqualityExpression_inequal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitEqualityExpression_inequal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitEqualityExpression_inequal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EqualityExpressionContext equalityExpression() throws RecognitionException {
		return equalityExpression(0);
	}

	private EqualityExpressionContext equalityExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		EqualityExpressionContext _localctx = new EqualityExpressionContext(_ctx, _parentState);
		EqualityExpressionContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_equalityExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new EqualityExpression_unaryContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(229);
			relationalExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(239);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(237);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
					case 1:
						{
						_localctx = new EqualityExpression_equalContext(new EqualityExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_equalityExpression);
						setState(231);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(232);
						match(Equal);
						setState(233);
						relationalExpression(0);
						}
						break;
					case 2:
						{
						_localctx = new EqualityExpression_inequalContext(new EqualityExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_equalityExpression);
						setState(234);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(235);
						match(NotEqual);
						setState(236);
						relationalExpression(0);
						}
						break;
					}
					} 
				}
				setState(241);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
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

	public static class AndExpressionContext extends ParserRuleContext {
		public AndExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_andExpression; }
	 
		public AndExpressionContext() { }
		public void copyFrom(AndExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AndExpression_unaryContext extends AndExpressionContext {
		public EqualityExpressionContext equalityExpression() {
			return getRuleContext(EqualityExpressionContext.class,0);
		}
		public AndExpression_unaryContext(AndExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterAndExpression_unary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitAndExpression_unary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitAndExpression_unary(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AndExpression_binaryContext extends AndExpressionContext {
		public AndExpressionContext andExpression() {
			return getRuleContext(AndExpressionContext.class,0);
		}
		public TerminalNode And() { return getToken(MxParser.And, 0); }
		public EqualityExpressionContext equalityExpression() {
			return getRuleContext(EqualityExpressionContext.class,0);
		}
		public AndExpression_binaryContext(AndExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterAndExpression_binary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitAndExpression_binary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitAndExpression_binary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AndExpressionContext andExpression() throws RecognitionException {
		return andExpression(0);
	}

	private AndExpressionContext andExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AndExpressionContext _localctx = new AndExpressionContext(_ctx, _parentState);
		AndExpressionContext _prevctx = _localctx;
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_andExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new AndExpression_unaryContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(243);
			equalityExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(250);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new AndExpression_binaryContext(new AndExpressionContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_andExpression);
					setState(245);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(246);
					match(And);
					setState(247);
					equalityExpression(0);
					}
					} 
				}
				setState(252);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
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

	public static class ExclusiveOrExpressionContext extends ParserRuleContext {
		public ExclusiveOrExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exclusiveOrExpression; }
	 
		public ExclusiveOrExpressionContext() { }
		public void copyFrom(ExclusiveOrExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExclusiveOrExpression_unaryContext extends ExclusiveOrExpressionContext {
		public AndExpressionContext andExpression() {
			return getRuleContext(AndExpressionContext.class,0);
		}
		public ExclusiveOrExpression_unaryContext(ExclusiveOrExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterExclusiveOrExpression_unary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitExclusiveOrExpression_unary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitExclusiveOrExpression_unary(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExclusiveOrExpression_binaryContext extends ExclusiveOrExpressionContext {
		public ExclusiveOrExpressionContext exclusiveOrExpression() {
			return getRuleContext(ExclusiveOrExpressionContext.class,0);
		}
		public TerminalNode Caret() { return getToken(MxParser.Caret, 0); }
		public AndExpressionContext andExpression() {
			return getRuleContext(AndExpressionContext.class,0);
		}
		public ExclusiveOrExpression_binaryContext(ExclusiveOrExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterExclusiveOrExpression_binary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitExclusiveOrExpression_binary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitExclusiveOrExpression_binary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExclusiveOrExpressionContext exclusiveOrExpression() throws RecognitionException {
		return exclusiveOrExpression(0);
	}

	private ExclusiveOrExpressionContext exclusiveOrExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExclusiveOrExpressionContext _localctx = new ExclusiveOrExpressionContext(_ctx, _parentState);
		ExclusiveOrExpressionContext _prevctx = _localctx;
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_exclusiveOrExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new ExclusiveOrExpression_unaryContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(254);
			andExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(261);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExclusiveOrExpression_binaryContext(new ExclusiveOrExpressionContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_exclusiveOrExpression);
					setState(256);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(257);
					match(Caret);
					setState(258);
					andExpression(0);
					}
					} 
				}
				setState(263);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
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

	public static class InclusiveOrExpressionContext extends ParserRuleContext {
		public InclusiveOrExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inclusiveOrExpression; }
	 
		public InclusiveOrExpressionContext() { }
		public void copyFrom(InclusiveOrExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class InclusiveOrExpression_binaryContext extends InclusiveOrExpressionContext {
		public InclusiveOrExpressionContext inclusiveOrExpression() {
			return getRuleContext(InclusiveOrExpressionContext.class,0);
		}
		public TerminalNode Or() { return getToken(MxParser.Or, 0); }
		public ExclusiveOrExpressionContext exclusiveOrExpression() {
			return getRuleContext(ExclusiveOrExpressionContext.class,0);
		}
		public InclusiveOrExpression_binaryContext(InclusiveOrExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterInclusiveOrExpression_binary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitInclusiveOrExpression_binary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitInclusiveOrExpression_binary(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InclusiveOrExpression_unaryContext extends InclusiveOrExpressionContext {
		public ExclusiveOrExpressionContext exclusiveOrExpression() {
			return getRuleContext(ExclusiveOrExpressionContext.class,0);
		}
		public InclusiveOrExpression_unaryContext(InclusiveOrExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterInclusiveOrExpression_unary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitInclusiveOrExpression_unary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitInclusiveOrExpression_unary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InclusiveOrExpressionContext inclusiveOrExpression() throws RecognitionException {
		return inclusiveOrExpression(0);
	}

	private InclusiveOrExpressionContext inclusiveOrExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		InclusiveOrExpressionContext _localctx = new InclusiveOrExpressionContext(_ctx, _parentState);
		InclusiveOrExpressionContext _prevctx = _localctx;
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_inclusiveOrExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new InclusiveOrExpression_unaryContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(265);
			exclusiveOrExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(272);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new InclusiveOrExpression_binaryContext(new InclusiveOrExpressionContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_inclusiveOrExpression);
					setState(267);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(268);
					match(Or);
					setState(269);
					exclusiveOrExpression(0);
					}
					} 
				}
				setState(274);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
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

	public static class LogicalAndExpressionContext extends ParserRuleContext {
		public LogicalAndExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalAndExpression; }
	 
		public LogicalAndExpressionContext() { }
		public void copyFrom(LogicalAndExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class LogicalAndExpression_unaryContext extends LogicalAndExpressionContext {
		public InclusiveOrExpressionContext inclusiveOrExpression() {
			return getRuleContext(InclusiveOrExpressionContext.class,0);
		}
		public LogicalAndExpression_unaryContext(LogicalAndExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterLogicalAndExpression_unary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitLogicalAndExpression_unary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitLogicalAndExpression_unary(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LogicalAndExpression_binaryContext extends LogicalAndExpressionContext {
		public LogicalAndExpressionContext logicalAndExpression() {
			return getRuleContext(LogicalAndExpressionContext.class,0);
		}
		public TerminalNode AndAnd() { return getToken(MxParser.AndAnd, 0); }
		public InclusiveOrExpressionContext inclusiveOrExpression() {
			return getRuleContext(InclusiveOrExpressionContext.class,0);
		}
		public LogicalAndExpression_binaryContext(LogicalAndExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterLogicalAndExpression_binary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitLogicalAndExpression_binary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitLogicalAndExpression_binary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicalAndExpressionContext logicalAndExpression() throws RecognitionException {
		return logicalAndExpression(0);
	}

	private LogicalAndExpressionContext logicalAndExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LogicalAndExpressionContext _localctx = new LogicalAndExpressionContext(_ctx, _parentState);
		LogicalAndExpressionContext _prevctx = _localctx;
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_logicalAndExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new LogicalAndExpression_unaryContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(276);
			inclusiveOrExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(283);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LogicalAndExpression_binaryContext(new LogicalAndExpressionContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_logicalAndExpression);
					setState(278);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(279);
					match(AndAnd);
					setState(280);
					inclusiveOrExpression(0);
					}
					} 
				}
				setState(285);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
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

	public static class LogicalOrExpressionContext extends ParserRuleContext {
		public LogicalOrExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalOrExpression; }
	 
		public LogicalOrExpressionContext() { }
		public void copyFrom(LogicalOrExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class LogicalOrExpression_binaryContext extends LogicalOrExpressionContext {
		public LogicalOrExpressionContext logicalOrExpression() {
			return getRuleContext(LogicalOrExpressionContext.class,0);
		}
		public TerminalNode OrOr() { return getToken(MxParser.OrOr, 0); }
		public LogicalAndExpressionContext logicalAndExpression() {
			return getRuleContext(LogicalAndExpressionContext.class,0);
		}
		public LogicalOrExpression_binaryContext(LogicalOrExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterLogicalOrExpression_binary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitLogicalOrExpression_binary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitLogicalOrExpression_binary(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LogicalOrExpression_unaryContext extends LogicalOrExpressionContext {
		public LogicalAndExpressionContext logicalAndExpression() {
			return getRuleContext(LogicalAndExpressionContext.class,0);
		}
		public LogicalOrExpression_unaryContext(LogicalOrExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterLogicalOrExpression_unary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitLogicalOrExpression_unary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitLogicalOrExpression_unary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicalOrExpressionContext logicalOrExpression() throws RecognitionException {
		return logicalOrExpression(0);
	}

	private LogicalOrExpressionContext logicalOrExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LogicalOrExpressionContext _localctx = new LogicalOrExpressionContext(_ctx, _parentState);
		LogicalOrExpressionContext _prevctx = _localctx;
		int _startState = 32;
		enterRecursionRule(_localctx, 32, RULE_logicalOrExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new LogicalOrExpression_unaryContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(287);
			logicalAndExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(294);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LogicalOrExpression_binaryContext(new LogicalOrExpressionContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_logicalOrExpression);
					setState(289);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(290);
					match(OrOr);
					setState(291);
					logicalAndExpression(0);
					}
					} 
				}
				setState(296);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
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

	public static class ExpressionContext extends ParserRuleContext {
		public NewDeclaratorContext newDeclarator() {
			return getRuleContext(NewDeclaratorContext.class,0);
		}
		public LogicalOrExpressionContext logicalOrExpression() {
			return getRuleContext(LogicalOrExpressionContext.class,0);
		}
		public UnaryExpressionContext unaryExpression() {
			return getRuleContext(UnaryExpressionContext.class,0);
		}
		public TerminalNode Assign() { return getToken(MxParser.Assign, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode DigitSequence() { return getToken(MxParser.DigitSequence, 0); }
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
		enterRule(_localctx, 34, RULE_expression);
		try {
			setState(304);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(297);
				newDeclarator();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(298);
				logicalOrExpression(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(299);
				unaryExpression();
				setState(300);
				match(Assign);
				setState(301);
				expression();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(303);
				match(DigitSequence);
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

	public static class DeclarationContext extends ParserRuleContext {
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
	 
		public DeclarationContext() { }
		public void copyFrom(DeclarationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Declaration_initContext extends DeclarationContext {
		public DeclarationSpecifierContext declarationSpecifier() {
			return getRuleContext(DeclarationSpecifierContext.class,0);
		}
		public InitDeclaratorListContext initDeclaratorList() {
			return getRuleContext(InitDeclaratorListContext.class,0);
		}
		public TerminalNode Semi() { return getToken(MxParser.Semi, 0); }
		public Declaration_initContext(DeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterDeclaration_init(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitDeclaration_init(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitDeclaration_init(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Declaration_noneContext extends DeclarationContext {
		public DeclarationSpecifierContext declarationSpecifier() {
			return getRuleContext(DeclarationSpecifierContext.class,0);
		}
		public TerminalNode Semi() { return getToken(MxParser.Semi, 0); }
		public Declaration_noneContext(DeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterDeclaration_none(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitDeclaration_none(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitDeclaration_none(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_declaration);
		try {
			setState(313);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				_localctx = new Declaration_initContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(306);
				declarationSpecifier(0);
				setState(307);
				initDeclaratorList(0);
				setState(308);
				match(Semi);
				}
				break;
			case 2:
				_localctx = new Declaration_noneContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(310);
				declarationSpecifier(0);
				setState(311);
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

	public static class InitDeclaratorListContext extends ParserRuleContext {
		public InitDeclaratorListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initDeclaratorList; }
	 
		public InitDeclaratorListContext() { }
		public void copyFrom(InitDeclaratorListContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class InitDeclaratorList_singleContext extends InitDeclaratorListContext {
		public InitDeclaratorContext initDeclarator() {
			return getRuleContext(InitDeclaratorContext.class,0);
		}
		public InitDeclaratorList_singleContext(InitDeclaratorListContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterInitDeclaratorList_single(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitInitDeclaratorList_single(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitInitDeclaratorList_single(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InitDeclaratorList_multiContext extends InitDeclaratorListContext {
		public InitDeclaratorListContext initDeclaratorList() {
			return getRuleContext(InitDeclaratorListContext.class,0);
		}
		public TerminalNode Comma() { return getToken(MxParser.Comma, 0); }
		public InitDeclaratorContext initDeclarator() {
			return getRuleContext(InitDeclaratorContext.class,0);
		}
		public InitDeclaratorList_multiContext(InitDeclaratorListContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterInitDeclaratorList_multi(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitInitDeclaratorList_multi(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitInitDeclaratorList_multi(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitDeclaratorListContext initDeclaratorList() throws RecognitionException {
		return initDeclaratorList(0);
	}

	private InitDeclaratorListContext initDeclaratorList(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		InitDeclaratorListContext _localctx = new InitDeclaratorListContext(_ctx, _parentState);
		InitDeclaratorListContext _prevctx = _localctx;
		int _startState = 38;
		enterRecursionRule(_localctx, 38, RULE_initDeclaratorList, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new InitDeclaratorList_singleContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(316);
			initDeclarator();
			}
			_ctx.stop = _input.LT(-1);
			setState(323);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new InitDeclaratorList_multiContext(new InitDeclaratorListContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_initDeclaratorList);
					setState(318);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(319);
					match(Comma);
					setState(320);
					initDeclarator();
					}
					} 
				}
				setState(325);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
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

	public static class InitDeclaratorContext extends ParserRuleContext {
		public InitDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initDeclarator; }
	 
		public InitDeclaratorContext() { }
		public void copyFrom(InitDeclaratorContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class InitDeclarator_initContext extends InitDeclaratorContext {
		public DirectDeclaratorContext directDeclarator() {
			return getRuleContext(DirectDeclaratorContext.class,0);
		}
		public TerminalNode Assign() { return getToken(MxParser.Assign, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public InitDeclarator_initContext(InitDeclaratorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterInitDeclarator_init(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitInitDeclarator_init(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitInitDeclarator_init(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InitDeclarator_noneContext extends InitDeclaratorContext {
		public DirectDeclaratorContext directDeclarator() {
			return getRuleContext(DirectDeclaratorContext.class,0);
		}
		public InitDeclarator_noneContext(InitDeclaratorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterInitDeclarator_none(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitInitDeclarator_none(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitInitDeclarator_none(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitDeclaratorContext initDeclarator() throws RecognitionException {
		InitDeclaratorContext _localctx = new InitDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_initDeclarator);
		try {
			setState(331);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				_localctx = new InitDeclarator_noneContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(326);
				directDeclarator(0);
				}
				break;
			case 2:
				_localctx = new InitDeclarator_initContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(327);
				directDeclarator(0);
				setState(328);
				match(Assign);
				setState(329);
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

	public static class TypeSpecifierContext extends ParserRuleContext {
		public TerminalNode Void() { return getToken(MxParser.Void, 0); }
		public TerminalNode Int() { return getToken(MxParser.Int, 0); }
		public TypedefNameContext typedefName() {
			return getRuleContext(TypedefNameContext.class,0);
		}
		public TypeSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeSpecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterTypeSpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitTypeSpecifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitTypeSpecifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeSpecifierContext typeSpecifier() throws RecognitionException {
		TypeSpecifierContext _localctx = new TypeSpecifierContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_typeSpecifier);
		int _la;
		try {
			setState(335);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
			case T__5:
			case Int:
			case Void:
				enterOuterAlt(_localctx, 1);
				{
				setState(333);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << Int) | (1L << Void))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(334);
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

	public static class NewDeclaratorContext extends ParserRuleContext {
		public NewDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newDeclarator; }
	 
		public NewDeclaratorContext() { }
		public void copyFrom(NewDeclaratorContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NewDeclarator_nonarrayContext extends NewDeclaratorContext {
		public TerminalNode New() { return getToken(MxParser.New, 0); }
		public TypeSpecifierContext typeSpecifier() {
			return getRuleContext(TypeSpecifierContext.class,0);
		}
		public TerminalNode LeftParen() { return getToken(MxParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(MxParser.RightParen, 0); }
		public NewDeclarator_nonarrayContext(NewDeclaratorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterNewDeclarator_nonarray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitNewDeclarator_nonarray(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitNewDeclarator_nonarray(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NewDeclarator_errorContext extends NewDeclaratorContext {
		public TerminalNode New() { return getToken(MxParser.New, 0); }
		public TypeSpecifierContext typeSpecifier() {
			return getRuleContext(TypeSpecifierContext.class,0);
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
		public NewDeclarator_errorContext(NewDeclaratorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterNewDeclarator_error(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitNewDeclarator_error(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitNewDeclarator_error(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NewDeclarator_arrayContext extends NewDeclaratorContext {
		public TerminalNode New() { return getToken(MxParser.New, 0); }
		public TypeSpecifierContext typeSpecifier() {
			return getRuleContext(TypeSpecifierContext.class,0);
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
		public NewDeclarator_arrayContext(NewDeclaratorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterNewDeclarator_array(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitNewDeclarator_array(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitNewDeclarator_array(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NewDeclaratorContext newDeclarator() throws RecognitionException {
		NewDeclaratorContext _localctx = new NewDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_newDeclarator);
		try {
			int _alt;
			setState(384);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				_localctx = new NewDeclarator_errorContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(337);
				match(New);
				setState(338);
				typeSpecifier();
				setState(343); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(339);
						match(LeftBracket);
						setState(340);
						expression();
						setState(341);
						match(RightBracket);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(345); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(349); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(347);
						match(LeftBracket);
						setState(348);
						match(RightBracket);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(351); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(357); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(353);
						match(LeftBracket);
						setState(354);
						expression();
						setState(355);
						match(RightBracket);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(359); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 2:
				_localctx = new NewDeclarator_arrayContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(361);
				match(New);
				setState(362);
				typeSpecifier();
				setState(367); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(363);
						match(LeftBracket);
						setState(364);
						expression();
						setState(365);
						match(RightBracket);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(369); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(375);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(371);
						match(LeftBracket);
						setState(372);
						match(RightBracket);
						}
						} 
					}
					setState(377);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
				}
				}
				break;
			case 3:
				_localctx = new NewDeclarator_nonarrayContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(378);
				match(New);
				setState(379);
				typeSpecifier();
				setState(382);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
				case 1:
					{
					setState(380);
					match(LeftParen);
					setState(381);
					match(RightParen);
					}
					break;
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
	public static class DirectDeclarator_IdentifierContext extends DirectDeclaratorContext {
		public TerminalNode Identifier() { return getToken(MxParser.Identifier, 0); }
		public DirectDeclarator_IdentifierContext(DirectDeclaratorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterDirectDeclarator_Identifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitDirectDeclarator_Identifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitDirectDeclarator_Identifier(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DirectDeclarator_with_parameterListContext extends DirectDeclaratorContext {
		public DirectDeclaratorContext directDeclarator() {
			return getRuleContext(DirectDeclaratorContext.class,0);
		}
		public TerminalNode LeftParen() { return getToken(MxParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(MxParser.RightParen, 0); }
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public DirectDeclarator_with_parameterListContext(DirectDeclaratorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterDirectDeclarator_with_parameterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitDirectDeclarator_with_parameterList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitDirectDeclarator_with_parameterList(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DirectDeclarator_recycleContext extends DirectDeclaratorContext {
		public TerminalNode LeftParen() { return getToken(MxParser.LeftParen, 0); }
		public DirectDeclaratorContext directDeclarator() {
			return getRuleContext(DirectDeclaratorContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(MxParser.RightParen, 0); }
		public DirectDeclarator_recycleContext(DirectDeclaratorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterDirectDeclarator_recycle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitDirectDeclarator_recycle(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitDirectDeclarator_recycle(this);
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
		int _startState = 46;
		enterRecursionRule(_localctx, 46, RULE_directDeclarator, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(392);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Identifier:
				{
				_localctx = new DirectDeclarator_IdentifierContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(387);
				match(Identifier);
				}
				break;
			case LeftParen:
				{
				_localctx = new DirectDeclarator_recycleContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(388);
				match(LeftParen);
				setState(389);
				directDeclarator(0);
				setState(390);
				match(RightParen);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(402);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new DirectDeclarator_with_parameterListContext(new DirectDeclaratorContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_directDeclarator);
					setState(394);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(395);
					match(LeftParen);
					setState(397);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << Identifier) | (1L << Int) | (1L << Void))) != 0)) {
						{
						setState(396);
						parameterList(0);
						}
					}

					setState(399);
					match(RightParen);
					}
					} 
				}
				setState(404);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
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
	public static class ParameterList_multiContext extends ParameterListContext {
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public TerminalNode Comma() { return getToken(MxParser.Comma, 0); }
		public ParameterDeclarationContext parameterDeclaration() {
			return getRuleContext(ParameterDeclarationContext.class,0);
		}
		public ParameterList_multiContext(ParameterListContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterParameterList_multi(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitParameterList_multi(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitParameterList_multi(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParameterList_singleContext extends ParameterListContext {
		public ParameterDeclarationContext parameterDeclaration() {
			return getRuleContext(ParameterDeclarationContext.class,0);
		}
		public ParameterList_singleContext(ParameterListContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterParameterList_single(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitParameterList_single(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitParameterList_single(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterListContext parameterList() throws RecognitionException {
		return parameterList(0);
	}

	private ParameterListContext parameterList(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ParameterListContext _localctx = new ParameterListContext(_ctx, _parentState);
		ParameterListContext _prevctx = _localctx;
		int _startState = 48;
		enterRecursionRule(_localctx, 48, RULE_parameterList, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new ParameterList_singleContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(406);
			parameterDeclaration();
			}
			_ctx.stop = _input.LT(-1);
			setState(413);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ParameterList_multiContext(new ParameterListContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_parameterList);
					setState(408);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(409);
					match(Comma);
					setState(410);
					parameterDeclaration();
					}
					} 
				}
				setState(415);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
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

	public static class ParameterDeclarationContext extends ParserRuleContext {
		public DeclarationSpecifierContext declarationSpecifier() {
			return getRuleContext(DeclarationSpecifierContext.class,0);
		}
		public DirectDeclaratorContext directDeclarator() {
			return getRuleContext(DirectDeclaratorContext.class,0);
		}
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
		enterRule(_localctx, 50, RULE_parameterDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(416);
			declarationSpecifier(0);
			setState(417);
			directDeclarator(0);
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
		enterRule(_localctx, 52, RULE_typedefName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(419);
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

	public static class StatementContext extends ParserRuleContext {
		public CompoundStatementContext compoundStatement() {
			return getRuleContext(CompoundStatementContext.class,0);
		}
		public ExpressionStatementContext expressionStatement() {
			return getRuleContext(ExpressionStatementContext.class,0);
		}
		public SelectionStatementContext selectionStatement() {
			return getRuleContext(SelectionStatementContext.class,0);
		}
		public IterationStatementContext iterationStatement() {
			return getRuleContext(IterationStatementContext.class,0);
		}
		public JumpStatementContext jumpStatement() {
			return getRuleContext(JumpStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_statement);
		try {
			setState(426);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LeftBrace:
				enterOuterAlt(_localctx, 1);
				{
				setState(421);
				compoundStatement();
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
			case Plus:
			case PlusPlus:
			case Minus:
			case MinusMinus:
			case Not:
			case Tilde:
			case Semi:
			case New:
			case DigitSequence:
				enterOuterAlt(_localctx, 2);
				{
				setState(422);
				expressionStatement();
				}
				break;
			case If:
				enterOuterAlt(_localctx, 3);
				{
				setState(423);
				selectionStatement();
				}
				break;
			case For:
			case While:
				enterOuterAlt(_localctx, 4);
				{
				setState(424);
				iterationStatement();
				}
				break;
			case Break:
			case Continue:
			case Return:
				enterOuterAlt(_localctx, 5);
				{
				setState(425);
				jumpStatement();
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

	public static class CompoundStatementContext extends ParserRuleContext {
		public TerminalNode LeftBrace() { return getToken(MxParser.LeftBrace, 0); }
		public TerminalNode RightBrace() { return getToken(MxParser.RightBrace, 0); }
		public List<BlockItemContext> blockItem() {
			return getRuleContexts(BlockItemContext.class);
		}
		public BlockItemContext blockItem(int i) {
			return getRuleContext(BlockItemContext.class,i);
		}
		public CompoundStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compoundStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterCompoundStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitCompoundStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitCompoundStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompoundStatementContext compoundStatement() throws RecognitionException {
		CompoundStatementContext _localctx = new CompoundStatementContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_compoundStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(428);
			match(LeftBrace);
			setState(432);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << Identifier) | (1L << IntegerLiteral) | (1L << StringLiteral) | (1L << Break) | (1L << Continue) | (1L << For) | (1L << If) | (1L << Int) | (1L << Return) | (1L << Void) | (1L << While) | (1L << LeftParen) | (1L << LeftBrace) | (1L << Plus) | (1L << PlusPlus) | (1L << Minus) | (1L << MinusMinus) | (1L << Not) | (1L << Tilde) | (1L << Semi))) != 0) || _la==New || _la==DigitSequence) {
				{
				{
				setState(429);
				blockItem();
				}
				}
				setState(434);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(435);
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

	public static class BlockItemContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public BlockItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterBlockItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitBlockItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitBlockItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockItemContext blockItem() throws RecognitionException {
		BlockItemContext _localctx = new BlockItemContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_blockItem);
		try {
			setState(439);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(437);
				statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(438);
				declaration();
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

	public static class ExpressionStatementContext extends ParserRuleContext {
		public TerminalNode Semi() { return getToken(MxParser.Semi, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterExpressionStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitExpressionStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitExpressionStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionStatementContext expressionStatement() throws RecognitionException {
		ExpressionStatementContext _localctx = new ExpressionStatementContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_expressionStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(442);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << Identifier) | (1L << IntegerLiteral) | (1L << StringLiteral) | (1L << LeftParen) | (1L << Plus) | (1L << PlusPlus) | (1L << Minus) | (1L << MinusMinus) | (1L << Not) | (1L << Tilde))) != 0) || _la==New || _la==DigitSequence) {
				{
				setState(441);
				expression();
				}
			}

			setState(444);
			match(Semi);
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

	public static class SelectionStatementContext extends ParserRuleContext {
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
		public SelectionStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectionStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterSelectionStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitSelectionStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitSelectionStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectionStatementContext selectionStatement() throws RecognitionException {
		SelectionStatementContext _localctx = new SelectionStatementContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_selectionStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(446);
			match(If);
			setState(447);
			match(LeftParen);
			setState(448);
			expression();
			setState(449);
			match(RightParen);
			setState(450);
			statement();
			setState(453);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
			case 1:
				{
				setState(451);
				match(Else);
				setState(452);
				statement();
				}
				break;
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

	public static class IterationStatementContext extends ParserRuleContext {
		public IterationStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iterationStatement; }
	 
		public IterationStatementContext() { }
		public void copyFrom(IterationStatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IterationStatement_whileContext extends IterationStatementContext {
		public TerminalNode While() { return getToken(MxParser.While, 0); }
		public TerminalNode LeftParen() { return getToken(MxParser.LeftParen, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(MxParser.RightParen, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public IterationStatement_whileContext(IterationStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterIterationStatement_while(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitIterationStatement_while(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitIterationStatement_while(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IterationStatement_forContext extends IterationStatementContext {
		public TerminalNode For() { return getToken(MxParser.For, 0); }
		public TerminalNode LeftParen() { return getToken(MxParser.LeftParen, 0); }
		public ForConditionContext forCondition() {
			return getRuleContext(ForConditionContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(MxParser.RightParen, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public IterationStatement_forContext(IterationStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterIterationStatement_for(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitIterationStatement_for(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitIterationStatement_for(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IterationStatementContext iterationStatement() throws RecognitionException {
		IterationStatementContext _localctx = new IterationStatementContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_iterationStatement);
		try {
			setState(467);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case While:
				_localctx = new IterationStatement_whileContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(455);
				match(While);
				setState(456);
				match(LeftParen);
				setState(457);
				expression();
				setState(458);
				match(RightParen);
				setState(459);
				statement();
				}
				break;
			case For:
				_localctx = new IterationStatement_forContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(461);
				match(For);
				setState(462);
				match(LeftParen);
				setState(463);
				forCondition();
				setState(464);
				match(RightParen);
				setState(465);
				statement();
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
	public static class ForCondition_initContext extends ForConditionContext {
		public ForDeclarationContext forDeclaration() {
			return getRuleContext(ForDeclarationContext.class,0);
		}
		public List<TerminalNode> Semi() { return getTokens(MxParser.Semi); }
		public TerminalNode Semi(int i) {
			return getToken(MxParser.Semi, i);
		}
		public ForExprEndContext forExprEnd() {
			return getRuleContext(ForExprEndContext.class,0);
		}
		public ForExprUpdateContext forExprUpdate() {
			return getRuleContext(ForExprUpdateContext.class,0);
		}
		public ForCondition_initContext(ForConditionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterForCondition_init(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitForCondition_init(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitForCondition_init(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ForCondition_noneContext extends ForConditionContext {
		public List<TerminalNode> Semi() { return getTokens(MxParser.Semi); }
		public TerminalNode Semi(int i) {
			return getToken(MxParser.Semi, i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ForExprEndContext forExprEnd() {
			return getRuleContext(ForExprEndContext.class,0);
		}
		public ForExprUpdateContext forExprUpdate() {
			return getRuleContext(ForExprUpdateContext.class,0);
		}
		public ForCondition_noneContext(ForConditionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterForCondition_none(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitForCondition_none(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitForCondition_none(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForConditionContext forCondition() throws RecognitionException {
		ForConditionContext _localctx = new ForConditionContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_forCondition);
		int _la;
		try {
			setState(489);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
			case 1:
				_localctx = new ForCondition_initContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(469);
				forDeclaration();
				setState(470);
				match(Semi);
				setState(472);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << Identifier) | (1L << IntegerLiteral) | (1L << StringLiteral) | (1L << LeftParen) | (1L << Plus) | (1L << PlusPlus) | (1L << Minus) | (1L << MinusMinus) | (1L << Not) | (1L << Tilde))) != 0) || _la==New || _la==DigitSequence) {
					{
					setState(471);
					forExprEnd();
					}
				}

				setState(474);
				match(Semi);
				setState(476);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << Identifier) | (1L << IntegerLiteral) | (1L << StringLiteral) | (1L << LeftParen) | (1L << Plus) | (1L << PlusPlus) | (1L << Minus) | (1L << MinusMinus) | (1L << Not) | (1L << Tilde))) != 0) || _la==New || _la==DigitSequence) {
					{
					setState(475);
					forExprUpdate();
					}
				}

				}
				break;
			case 2:
				_localctx = new ForCondition_noneContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(479);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << Identifier) | (1L << IntegerLiteral) | (1L << StringLiteral) | (1L << LeftParen) | (1L << Plus) | (1L << PlusPlus) | (1L << Minus) | (1L << MinusMinus) | (1L << Not) | (1L << Tilde))) != 0) || _la==New || _la==DigitSequence) {
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
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << Identifier) | (1L << IntegerLiteral) | (1L << StringLiteral) | (1L << LeftParen) | (1L << Plus) | (1L << PlusPlus) | (1L << Minus) | (1L << MinusMinus) | (1L << Not) | (1L << Tilde))) != 0) || _la==New || _la==DigitSequence) {
					{
					setState(482);
					forExprEnd();
					}
				}

				setState(485);
				match(Semi);
				setState(487);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << Identifier) | (1L << IntegerLiteral) | (1L << StringLiteral) | (1L << LeftParen) | (1L << Plus) | (1L << PlusPlus) | (1L << Minus) | (1L << MinusMinus) | (1L << Not) | (1L << Tilde))) != 0) || _la==New || _la==DigitSequence) {
					{
					setState(486);
					forExprUpdate();
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
	public static class ForDeclaration_noneContext extends ForDeclarationContext {
		public DeclarationSpecifierContext declarationSpecifier() {
			return getRuleContext(DeclarationSpecifierContext.class,0);
		}
		public ForDeclaration_noneContext(ForDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterForDeclaration_none(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitForDeclaration_none(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitForDeclaration_none(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ForDeclaration_initContext extends ForDeclarationContext {
		public DeclarationSpecifierContext declarationSpecifier() {
			return getRuleContext(DeclarationSpecifierContext.class,0);
		}
		public InitDeclaratorListContext initDeclaratorList() {
			return getRuleContext(InitDeclaratorListContext.class,0);
		}
		public ForDeclaration_initContext(ForDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterForDeclaration_init(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitForDeclaration_init(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitForDeclaration_init(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForDeclarationContext forDeclaration() throws RecognitionException {
		ForDeclarationContext _localctx = new ForDeclarationContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_forDeclaration);
		try {
			setState(495);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
			case 1:
				_localctx = new ForDeclaration_initContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(491);
				declarationSpecifier(0);
				setState(492);
				initDeclaratorList(0);
				}
				break;
			case 2:
				_localctx = new ForDeclaration_noneContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(494);
				declarationSpecifier(0);
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

	public static class ForExprEndContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ForExprEndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forExprEnd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterForExprEnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitForExprEnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitForExprEnd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForExprEndContext forExprEnd() throws RecognitionException {
		ForExprEndContext _localctx = new ForExprEndContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_forExprEnd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(497);
			expression();
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

	public static class ForExprUpdateContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ForExprUpdateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forExprUpdate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterForExprUpdate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitForExprUpdate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitForExprUpdate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForExprUpdateContext forExprUpdate() throws RecognitionException {
		ForExprUpdateContext _localctx = new ForExprUpdateContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_forExprUpdate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(499);
			expression();
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

	public static class JumpStatementContext extends ParserRuleContext {
		public JumpStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jumpStatement; }
	 
		public JumpStatementContext() { }
		public void copyFrom(JumpStatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class JumpStatement_returnContext extends JumpStatementContext {
		public TerminalNode Return() { return getToken(MxParser.Return, 0); }
		public TerminalNode Semi() { return getToken(MxParser.Semi, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public JumpStatement_returnContext(JumpStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterJumpStatement_return(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitJumpStatement_return(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitJumpStatement_return(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class JumpStatement_continueContext extends JumpStatementContext {
		public TerminalNode Continue() { return getToken(MxParser.Continue, 0); }
		public TerminalNode Semi() { return getToken(MxParser.Semi, 0); }
		public JumpStatement_continueContext(JumpStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterJumpStatement_continue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitJumpStatement_continue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitJumpStatement_continue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class JumpStatement_breakContext extends JumpStatementContext {
		public TerminalNode Break() { return getToken(MxParser.Break, 0); }
		public TerminalNode Semi() { return getToken(MxParser.Semi, 0); }
		public JumpStatement_breakContext(JumpStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterJumpStatement_break(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitJumpStatement_break(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitJumpStatement_break(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JumpStatementContext jumpStatement() throws RecognitionException {
		JumpStatementContext _localctx = new JumpStatementContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_jumpStatement);
		int _la;
		try {
			setState(510);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Continue:
				_localctx = new JumpStatement_continueContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(501);
				match(Continue);
				setState(502);
				match(Semi);
				}
				break;
			case Break:
				_localctx = new JumpStatement_breakContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(503);
				match(Break);
				setState(504);
				match(Semi);
				}
				break;
			case Return:
				_localctx = new JumpStatement_returnContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(505);
				match(Return);
				setState(507);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << Identifier) | (1L << IntegerLiteral) | (1L << StringLiteral) | (1L << LeftParen) | (1L << Plus) | (1L << PlusPlus) | (1L << Minus) | (1L << MinusMinus) | (1L << Not) | (1L << Tilde))) != 0) || _la==New || _la==DigitSequence) {
					{
					setState(506);
					expression();
					}
				}

				setState(509);
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

	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(MxParser.EOF, 0); }
		public List<ProgramDeclarationContext> programDeclaration() {
			return getRuleContexts(ProgramDeclarationContext.class);
		}
		public ProgramDeclarationContext programDeclaration(int i) {
			return getRuleContext(ProgramDeclarationContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(515);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << Identifier) | (1L << Int) | (1L << Class) | (1L << Void) | (1L << LeftParen) | (1L << Semi))) != 0)) {
				{
				{
				setState(512);
				programDeclaration();
				}
				}
				setState(517);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(518);
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

	public static class ProgramDeclarationContext extends ParserRuleContext {
		public FunctionDefinitionContext functionDefinition() {
			return getRuleContext(FunctionDefinitionContext.class,0);
		}
		public ClassDefinitionContext classDefinition() {
			return getRuleContext(ClassDefinitionContext.class,0);
		}
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public TerminalNode Semi() { return getToken(MxParser.Semi, 0); }
		public ProgramDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterProgramDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitProgramDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitProgramDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramDeclarationContext programDeclaration() throws RecognitionException {
		ProgramDeclarationContext _localctx = new ProgramDeclarationContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_programDeclaration);
		try {
			setState(524);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,55,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(520);
				functionDefinition();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(521);
				classDefinition();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(522);
				declaration();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(523);
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

	public static class FunctionDefinitionContext extends ParserRuleContext {
		public DirectDeclaratorContext directDeclarator() {
			return getRuleContext(DirectDeclaratorContext.class,0);
		}
		public CompoundStatementContext compoundStatement() {
			return getRuleContext(CompoundStatementContext.class,0);
		}
		public DeclarationSpecifierContext declarationSpecifier() {
			return getRuleContext(DeclarationSpecifierContext.class,0);
		}
		public FunctionDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterFunctionDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitFunctionDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitFunctionDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDefinitionContext functionDefinition() throws RecognitionException {
		FunctionDefinitionContext _localctx = new FunctionDefinitionContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_functionDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(527);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,56,_ctx) ) {
			case 1:
				{
				setState(526);
				declarationSpecifier(0);
				}
				break;
			}
			setState(529);
			directDeclarator(0);
			setState(530);
			compoundStatement();
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

	public static class ClassDefinitionContext extends ParserRuleContext {
		public ClassDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDefinition; }
	 
		public ClassDefinitionContext() { }
		public void copyFrom(ClassDefinitionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ClassDeclaration_noneContext extends ClassDefinitionContext {
		public TerminalNode Class() { return getToken(MxParser.Class, 0); }
		public TerminalNode Identifier() { return getToken(MxParser.Identifier, 0); }
		public ClassDeclaration_noneContext(ClassDefinitionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterClassDeclaration_none(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitClassDeclaration_none(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitClassDeclaration_none(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ClassDeclaration_declContext extends ClassDefinitionContext {
		public TerminalNode Class() { return getToken(MxParser.Class, 0); }
		public TerminalNode LeftBrace() { return getToken(MxParser.LeftBrace, 0); }
		public TerminalNode RightBrace() { return getToken(MxParser.RightBrace, 0); }
		public TerminalNode Identifier() { return getToken(MxParser.Identifier, 0); }
		public List<ClassDeclarationContext> classDeclaration() {
			return getRuleContexts(ClassDeclarationContext.class);
		}
		public ClassDeclarationContext classDeclaration(int i) {
			return getRuleContext(ClassDeclarationContext.class,i);
		}
		public ClassDeclaration_declContext(ClassDefinitionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterClassDeclaration_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitClassDeclaration_decl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitClassDeclaration_decl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassDefinitionContext classDefinition() throws RecognitionException {
		ClassDefinitionContext _localctx = new ClassDefinitionContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_classDefinition);
		int _la;
		try {
			setState(546);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,59,_ctx) ) {
			case 1:
				_localctx = new ClassDeclaration_declContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(532);
				match(Class);
				setState(534);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Identifier) {
					{
					setState(533);
					match(Identifier);
					}
				}

				setState(536);
				match(LeftBrace);
				setState(540);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << Identifier) | (1L << Int) | (1L << Void) | (1L << LeftParen))) != 0)) {
					{
					{
					setState(537);
					classDeclaration();
					}
					}
					setState(542);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(543);
				match(RightBrace);
				}
				break;
			case 2:
				_localctx = new ClassDeclaration_noneContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(544);
				match(Class);
				setState(545);
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

	public static class ClassDeclarationContext extends ParserRuleContext {
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public FunctionDefinitionContext functionDefinition() {
			return getRuleContext(FunctionDefinitionContext.class,0);
		}
		public ClassDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterClassDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitClassDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitClassDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassDeclarationContext classDeclaration() throws RecognitionException {
		ClassDeclarationContext _localctx = new ClassDeclarationContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_classDeclaration);
		try {
			setState(550);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,60,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(548);
				declaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(549);
				functionDefinition();
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
		case 1:
			return declarationSpecifier_sempred((DeclarationSpecifierContext)_localctx, predIndex);
		case 2:
			return postfixExpression_sempred((PostfixExpressionContext)_localctx, predIndex);
		case 3:
			return argumentExpressionList_sempred((ArgumentExpressionListContext)_localctx, predIndex);
		case 7:
			return multiplicativeExpression_sempred((MultiplicativeExpressionContext)_localctx, predIndex);
		case 8:
			return additiveExpression_sempred((AdditiveExpressionContext)_localctx, predIndex);
		case 9:
			return shiftExpression_sempred((ShiftExpressionContext)_localctx, predIndex);
		case 10:
			return relationalExpression_sempred((RelationalExpressionContext)_localctx, predIndex);
		case 11:
			return equalityExpression_sempred((EqualityExpressionContext)_localctx, predIndex);
		case 12:
			return andExpression_sempred((AndExpressionContext)_localctx, predIndex);
		case 13:
			return exclusiveOrExpression_sempred((ExclusiveOrExpressionContext)_localctx, predIndex);
		case 14:
			return inclusiveOrExpression_sempred((InclusiveOrExpressionContext)_localctx, predIndex);
		case 15:
			return logicalAndExpression_sempred((LogicalAndExpressionContext)_localctx, predIndex);
		case 16:
			return logicalOrExpression_sempred((LogicalOrExpressionContext)_localctx, predIndex);
		case 19:
			return initDeclaratorList_sempred((InitDeclaratorListContext)_localctx, predIndex);
		case 23:
			return directDeclarator_sempred((DirectDeclaratorContext)_localctx, predIndex);
		case 24:
			return parameterList_sempred((ParameterListContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean declarationSpecifier_sempred(DeclarationSpecifierContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean postfixExpression_sempred(PostfixExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 5);
		case 2:
			return precpred(_ctx, 4);
		case 3:
			return precpred(_ctx, 3);
		case 4:
			return precpred(_ctx, 2);
		case 5:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean argumentExpressionList_sempred(ArgumentExpressionListContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean multiplicativeExpression_sempred(MultiplicativeExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 7:
			return precpred(_ctx, 3);
		case 8:
			return precpred(_ctx, 2);
		case 9:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean additiveExpression_sempred(AdditiveExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 10:
			return precpred(_ctx, 2);
		case 11:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean shiftExpression_sempred(ShiftExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 12:
			return precpred(_ctx, 2);
		case 13:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean relationalExpression_sempred(RelationalExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 14:
			return precpred(_ctx, 4);
		case 15:
			return precpred(_ctx, 3);
		case 16:
			return precpred(_ctx, 2);
		case 17:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean equalityExpression_sempred(EqualityExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 18:
			return precpred(_ctx, 2);
		case 19:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean andExpression_sempred(AndExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 20:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean exclusiveOrExpression_sempred(ExclusiveOrExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 21:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean inclusiveOrExpression_sempred(InclusiveOrExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 22:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean logicalAndExpression_sempred(LogicalAndExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 23:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean logicalOrExpression_sempred(LogicalOrExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 24:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean initDeclaratorList_sempred(InitDeclaratorListContext _localctx, int predIndex) {
		switch (predIndex) {
		case 25:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean directDeclarator_sempred(DirectDeclaratorContext _localctx, int predIndex) {
		switch (predIndex) {
		case 26:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean parameterList_sempred(ParameterListContext _localctx, int predIndex) {
		switch (predIndex) {
		case 27:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3D\u022b\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2d\n\2\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\7\3l\n\3\f\3\16\3o\13\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\5\4|\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4\u0086\n\4\f\4"+
		"\16\4\u0089\13\4\3\5\3\5\3\5\3\5\3\5\3\5\7\5\u0091\n\5\f\5\16\5\u0094"+
		"\13\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u009e\n\6\3\7\3\7\3\b\3\b\5"+
		"\b\u00a4\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u00b2"+
		"\n\t\f\t\16\t\u00b5\13\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u00c0"+
		"\n\n\f\n\16\n\u00c3\13\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\7\13\u00ce\n\13\f\13\16\13\u00d1\13\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u00e2\n\f\f\f\16\f\u00e5\13\f\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u00f0\n\r\f\r\16\r\u00f3\13\r\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\7\16\u00fb\n\16\f\16\16\16\u00fe\13\16\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\7\17\u0106\n\17\f\17\16\17\u0109\13\17\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\7\20\u0111\n\20\f\20\16\20\u0114\13\20\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\7\21\u011c\n\21\f\21\16\21\u011f\13\21\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\7\22\u0127\n\22\f\22\16\22\u012a\13\22\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u0133\n\23\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\5\24\u013c\n\24\3\25\3\25\3\25\3\25\3\25\3\25\7\25\u0144\n"+
		"\25\f\25\16\25\u0147\13\25\3\26\3\26\3\26\3\26\3\26\5\26\u014e\n\26\3"+
		"\27\3\27\5\27\u0152\n\27\3\30\3\30\3\30\3\30\3\30\3\30\6\30\u015a\n\30"+
		"\r\30\16\30\u015b\3\30\3\30\6\30\u0160\n\30\r\30\16\30\u0161\3\30\3\30"+
		"\3\30\3\30\6\30\u0168\n\30\r\30\16\30\u0169\3\30\3\30\3\30\3\30\3\30\3"+
		"\30\6\30\u0172\n\30\r\30\16\30\u0173\3\30\3\30\7\30\u0178\n\30\f\30\16"+
		"\30\u017b\13\30\3\30\3\30\3\30\3\30\5\30\u0181\n\30\5\30\u0183\n\30\3"+
		"\31\3\31\3\31\3\31\3\31\3\31\5\31\u018b\n\31\3\31\3\31\3\31\5\31\u0190"+
		"\n\31\3\31\7\31\u0193\n\31\f\31\16\31\u0196\13\31\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\7\32\u019e\n\32\f\32\16\32\u01a1\13\32\3\33\3\33\3\33\3\34"+
		"\3\34\3\35\3\35\3\35\3\35\3\35\5\35\u01ad\n\35\3\36\3\36\7\36\u01b1\n"+
		"\36\f\36\16\36\u01b4\13\36\3\36\3\36\3\37\3\37\5\37\u01ba\n\37\3 \5 \u01bd"+
		"\n \3 \3 \3!\3!\3!\3!\3!\3!\3!\5!\u01c8\n!\3\"\3\"\3\"\3\"\3\"\3\"\3\""+
		"\3\"\3\"\3\"\3\"\3\"\5\"\u01d6\n\"\3#\3#\3#\5#\u01db\n#\3#\3#\5#\u01df"+
		"\n#\3#\5#\u01e2\n#\3#\3#\5#\u01e6\n#\3#\3#\5#\u01ea\n#\5#\u01ec\n#\3$"+
		"\3$\3$\3$\5$\u01f2\n$\3%\3%\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'\5\'\u01fe\n"+
		"\'\3\'\5\'\u0201\n\'\3(\7(\u0204\n(\f(\16(\u0207\13(\3(\3(\3)\3)\3)\3"+
		")\5)\u020f\n)\3*\5*\u0212\n*\3*\3*\3*\3+\3+\5+\u0219\n+\3+\3+\7+\u021d"+
		"\n+\f+\16+\u0220\13+\3+\3+\3+\5+\u0225\n+\3,\3,\5,\u0229\n,\3,\2\22\4"+
		"\6\b\20\22\24\26\30\32\34\36 \"(\60\62-\2\4\6\b\n\f\16\20\22\24\26\30"+
		"\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTV\2\4\5\2++--\678\5\2\7\b"+
		"\26\26\33\33\2\u0253\2c\3\2\2\2\4e\3\2\2\2\6p\3\2\2\2\b\u008a\3\2\2\2"+
		"\n\u009d\3\2\2\2\f\u009f\3\2\2\2\16\u00a3\3\2\2\2\20\u00a5\3\2\2\2\22"+
		"\u00b6\3\2\2\2\24\u00c4\3\2\2\2\26\u00d2\3\2\2\2\30\u00e6\3\2\2\2\32\u00f4"+
		"\3\2\2\2\34\u00ff\3\2\2\2\36\u010a\3\2\2\2 \u0115\3\2\2\2\"\u0120\3\2"+
		"\2\2$\u0132\3\2\2\2&\u013b\3\2\2\2(\u013d\3\2\2\2*\u014d\3\2\2\2,\u0151"+
		"\3\2\2\2.\u0182\3\2\2\2\60\u018a\3\2\2\2\62\u0197\3\2\2\2\64\u01a2\3\2"+
		"\2\2\66\u01a5\3\2\2\28\u01ac\3\2\2\2:\u01ae\3\2\2\2<\u01b9\3\2\2\2>\u01bc"+
		"\3\2\2\2@\u01c0\3\2\2\2B\u01d5\3\2\2\2D\u01eb\3\2\2\2F\u01f1\3\2\2\2H"+
		"\u01f3\3\2\2\2J\u01f5\3\2\2\2L\u0200\3\2\2\2N\u0205\3\2\2\2P\u020e\3\2"+
		"\2\2R\u0211\3\2\2\2T\u0224\3\2\2\2V\u0228\3\2\2\2Xd\7\3\2\2Yd\7\4\2\2"+
		"Zd\7\5\2\2[d\7\6\2\2\\d\7\t\2\2]d\7\n\2\2^d\7\13\2\2_`\7\37\2\2`a\5$\23"+
		"\2ab\7 \2\2bd\3\2\2\2cX\3\2\2\2cY\3\2\2\2cZ\3\2\2\2c[\3\2\2\2c\\\3\2\2"+
		"\2c]\3\2\2\2c^\3\2\2\2c_\3\2\2\2d\3\3\2\2\2ef\b\3\1\2fg\5,\27\2gm\3\2"+
		"\2\2hi\f\3\2\2ij\7!\2\2jl\7\"\2\2kh\3\2\2\2lo\3\2\2\2mk\3\2\2\2mn\3\2"+
		"\2\2n\5\3\2\2\2om\3\2\2\2pq\b\4\1\2qr\5\2\2\2r\u0087\3\2\2\2st\f\7\2\2"+
		"tu\7!\2\2uv\5$\23\2vw\7\"\2\2w\u0086\3\2\2\2xy\f\6\2\2y{\7\37\2\2z|\5"+
		"\b\5\2{z\3\2\2\2{|\3\2\2\2|}\3\2\2\2}\u0086\7 \2\2~\177\f\5\2\2\177\u0080"+
		"\7A\2\2\u0080\u0086\7\t\2\2\u0081\u0082\f\4\2\2\u0082\u0086\7,\2\2\u0083"+
		"\u0084\f\3\2\2\u0084\u0086\7.\2\2\u0085s\3\2\2\2\u0085x\3\2\2\2\u0085"+
		"~\3\2\2\2\u0085\u0081\3\2\2\2\u0085\u0083\3\2\2\2\u0086\u0089\3\2\2\2"+
		"\u0087\u0085\3\2\2\2\u0087\u0088\3\2\2\2\u0088\7\3\2\2\2\u0089\u0087\3"+
		"\2\2\2\u008a\u008b\b\5\1\2\u008b\u008c\5$\23\2\u008c\u0092\3\2\2\2\u008d"+
		"\u008e\f\3\2\2\u008e\u008f\7<\2\2\u008f\u0091\5$\23\2\u0090\u008d\3\2"+
		"\2\2\u0091\u0094\3\2\2\2\u0092\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093"+
		"\t\3\2\2\2\u0094\u0092\3\2\2\2\u0095\u009e\5\6\4\2\u0096\u0097\7,\2\2"+
		"\u0097\u009e\5\n\6\2\u0098\u0099\7.\2\2\u0099\u009e\5\n\6\2\u009a\u009b"+
		"\5\f\7\2\u009b\u009c\5\16\b\2\u009c\u009e\3\2\2\2\u009d\u0095\3\2\2\2"+
		"\u009d\u0096\3\2\2\2\u009d\u0098\3\2\2\2\u009d\u009a\3\2\2\2\u009e\13"+
		"\3\2\2\2\u009f\u00a0\t\2\2\2\u00a0\r\3\2\2\2\u00a1\u00a4\5\n\6\2\u00a2"+
		"\u00a4\7D\2\2\u00a3\u00a1\3\2\2\2\u00a3\u00a2\3\2\2\2\u00a4\17\3\2\2\2"+
		"\u00a5\u00a6\b\t\1\2\u00a6\u00a7\5\16\b\2\u00a7\u00b3\3\2\2\2\u00a8\u00a9"+
		"\f\5\2\2\u00a9\u00aa\7/\2\2\u00aa\u00b2\5\16\b\2\u00ab\u00ac\f\4\2\2\u00ac"+
		"\u00ad\7\60\2\2\u00ad\u00b2\5\16\b\2\u00ae\u00af\f\3\2\2\u00af\u00b0\7"+
		"\61\2\2\u00b0\u00b2\5\16\b\2\u00b1\u00a8\3\2\2\2\u00b1\u00ab\3\2\2\2\u00b1"+
		"\u00ae\3\2\2\2\u00b2\u00b5\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b3\u00b4\3\2"+
		"\2\2\u00b4\21\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b6\u00b7\b\n\1\2\u00b7\u00b8"+
		"\5\20\t\2\u00b8\u00c1\3\2\2\2\u00b9\u00ba\f\4\2\2\u00ba\u00bb\7+\2\2\u00bb"+
		"\u00c0\5\20\t\2\u00bc\u00bd\f\3\2\2\u00bd\u00be\7-\2\2\u00be\u00c0\5\20"+
		"\t\2\u00bf\u00b9\3\2\2\2\u00bf\u00bc\3\2\2\2\u00c0\u00c3\3\2\2\2\u00c1"+
		"\u00bf\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\23\3\2\2\2\u00c3\u00c1\3\2\2"+
		"\2\u00c4\u00c5\b\13\1\2\u00c5\u00c6\5\22\n\2\u00c6\u00cf\3\2\2\2\u00c7"+
		"\u00c8\f\4\2\2\u00c8\u00c9\7)\2\2\u00c9\u00ce\5\22\n\2\u00ca\u00cb\f\3"+
		"\2\2\u00cb\u00cc\7*\2\2\u00cc\u00ce\5\22\n\2\u00cd\u00c7\3\2\2\2\u00cd"+
		"\u00ca\3\2\2\2\u00ce\u00d1\3\2\2\2\u00cf\u00cd\3\2\2\2\u00cf\u00d0\3\2"+
		"\2\2\u00d0\25\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d2\u00d3\b\f\1\2\u00d3\u00d4"+
		"\5\24\13\2\u00d4\u00e3\3\2\2\2\u00d5\u00d6\f\6\2\2\u00d6\u00d7\7%\2\2"+
		"\u00d7\u00e2\5\24\13\2\u00d8\u00d9\f\5\2\2\u00d9\u00da\7\'\2\2\u00da\u00e2"+
		"\5\24\13\2\u00db\u00dc\f\4\2\2\u00dc\u00dd\7&\2\2\u00dd\u00e2\5\24\13"+
		"\2\u00de\u00df\f\3\2\2\u00df\u00e0\7(\2\2\u00e0\u00e2\5\24\13\2\u00e1"+
		"\u00d5\3\2\2\2\u00e1\u00d8\3\2\2\2\u00e1\u00db\3\2\2\2\u00e1\u00de\3\2"+
		"\2\2\u00e2\u00e5\3\2\2\2\u00e3\u00e1\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4"+
		"\27\3\2\2\2\u00e5\u00e3\3\2\2\2\u00e6\u00e7\b\r\1\2\u00e7\u00e8\5\26\f"+
		"\2\u00e8\u00f1\3\2\2\2\u00e9\u00ea\f\4\2\2\u00ea\u00eb\7>\2\2\u00eb\u00f0"+
		"\5\26\f\2\u00ec\u00ed\f\3\2\2\u00ed\u00ee\7?\2\2\u00ee\u00f0\5\26\f\2"+
		"\u00ef\u00e9\3\2\2\2\u00ef\u00ec\3\2\2\2\u00f0\u00f3\3\2\2\2\u00f1\u00ef"+
		"\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2\31\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f4"+
		"\u00f5\b\16\1\2\u00f5\u00f6\5\30\r\2\u00f6\u00fc\3\2\2\2\u00f7\u00f8\f"+
		"\3\2\2\u00f8\u00f9\7\62\2\2\u00f9\u00fb\5\30\r\2\u00fa\u00f7\3\2\2\2\u00fb"+
		"\u00fe\3\2\2\2\u00fc\u00fa\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd\33\3\2\2"+
		"\2\u00fe\u00fc\3\2\2\2\u00ff\u0100\b\17\1\2\u0100\u0101\5\32\16\2\u0101"+
		"\u0107\3\2\2\2\u0102\u0103\f\3\2\2\u0103\u0104\7\66\2\2\u0104\u0106\5"+
		"\32\16\2\u0105\u0102\3\2\2\2\u0106\u0109\3\2\2\2\u0107\u0105\3\2\2\2\u0107"+
		"\u0108\3\2\2\2\u0108\35\3\2\2\2\u0109\u0107\3\2\2\2\u010a\u010b\b\20\1"+
		"\2\u010b\u010c\5\34\17\2\u010c\u0112\3\2\2\2\u010d\u010e\f\3\2\2\u010e"+
		"\u010f\7\63\2\2\u010f\u0111\5\34\17\2\u0110\u010d\3\2\2\2\u0111\u0114"+
		"\3\2\2\2\u0112\u0110\3\2\2\2\u0112\u0113\3\2\2\2\u0113\37\3\2\2\2\u0114"+
		"\u0112\3\2\2\2\u0115\u0116\b\21\1\2\u0116\u0117\5\36\20\2\u0117\u011d"+
		"\3\2\2\2\u0118\u0119\f\3\2\2\u0119\u011a\7\64\2\2\u011a\u011c\5\36\20"+
		"\2\u011b\u0118\3\2\2\2\u011c\u011f\3\2\2\2\u011d\u011b\3\2\2\2\u011d\u011e"+
		"\3\2\2\2\u011e!\3\2\2\2\u011f\u011d\3\2\2\2\u0120\u0121\b\22\1\2\u0121"+
		"\u0122\5 \21\2\u0122\u0128\3\2\2\2\u0123\u0124\f\3\2\2\u0124\u0125\7\65"+
		"\2\2\u0125\u0127\5 \21\2\u0126\u0123\3\2\2\2\u0127\u012a\3\2\2\2\u0128"+
		"\u0126\3\2\2\2\u0128\u0129\3\2\2\2\u0129#\3\2\2\2\u012a\u0128\3\2\2\2"+
		"\u012b\u0133\5.\30\2\u012c\u0133\5\"\22\2\u012d\u012e\5\n\6\2\u012e\u012f"+
		"\7=\2\2\u012f\u0130\5$\23\2\u0130\u0133\3\2\2\2\u0131\u0133\7D\2\2\u0132"+
		"\u012b\3\2\2\2\u0132\u012c\3\2\2\2\u0132\u012d\3\2\2\2\u0132\u0131\3\2"+
		"\2\2\u0133%\3\2\2\2\u0134\u0135\5\4\3\2\u0135\u0136\5(\25\2\u0136\u0137"+
		"\7;\2\2\u0137\u013c\3\2\2\2\u0138\u0139\5\4\3\2\u0139\u013a\7;\2\2\u013a"+
		"\u013c\3\2\2\2\u013b\u0134\3\2\2\2\u013b\u0138\3\2\2\2\u013c\'\3\2\2\2"+
		"\u013d\u013e\b\25\1\2\u013e\u013f\5*\26\2\u013f\u0145\3\2\2\2\u0140\u0141"+
		"\f\3\2\2\u0141\u0142\7<\2\2\u0142\u0144\5*\26\2\u0143\u0140\3\2\2\2\u0144"+
		"\u0147\3\2\2\2\u0145\u0143\3\2\2\2\u0145\u0146\3\2\2\2\u0146)\3\2\2\2"+
		"\u0147\u0145\3\2\2\2\u0148\u014e\5\60\31\2\u0149\u014a\5\60\31\2\u014a"+
		"\u014b\7=\2\2\u014b\u014c\5$\23\2\u014c\u014e\3\2\2\2\u014d\u0148\3\2"+
		"\2\2\u014d\u0149\3\2\2\2\u014e+\3\2\2\2\u014f\u0152\t\3\2\2\u0150\u0152"+
		"\5\66\34\2\u0151\u014f\3\2\2\2\u0151\u0150\3\2\2\2\u0152-\3\2\2\2\u0153"+
		"\u0154\7C\2\2\u0154\u0159\5,\27\2\u0155\u0156\7!\2\2\u0156\u0157\5$\23"+
		"\2\u0157\u0158\7\"\2\2\u0158\u015a\3\2\2\2\u0159\u0155\3\2\2\2\u015a\u015b"+
		"\3\2\2\2\u015b\u0159\3\2\2\2\u015b\u015c\3\2\2\2\u015c\u015f\3\2\2\2\u015d"+
		"\u015e\7!\2\2\u015e\u0160\7\"\2\2\u015f\u015d\3\2\2\2\u0160\u0161\3\2"+
		"\2\2\u0161\u015f\3\2\2\2\u0161\u0162\3\2\2\2\u0162\u0167\3\2\2\2\u0163"+
		"\u0164\7!\2\2\u0164\u0165\5$\23\2\u0165\u0166\7\"\2\2\u0166\u0168\3\2"+
		"\2\2\u0167\u0163\3\2\2\2\u0168\u0169\3\2\2\2\u0169\u0167\3\2\2\2\u0169"+
		"\u016a\3\2\2\2\u016a\u0183\3\2\2\2\u016b\u016c\7C\2\2\u016c\u0171\5,\27"+
		"\2\u016d\u016e\7!\2\2\u016e\u016f\5$\23\2\u016f\u0170\7\"\2\2\u0170\u0172"+
		"\3\2\2\2\u0171\u016d\3\2\2\2\u0172\u0173\3\2\2\2\u0173\u0171\3\2\2\2\u0173"+
		"\u0174\3\2\2\2\u0174\u0179\3\2\2\2\u0175\u0176\7!\2\2\u0176\u0178\7\""+
		"\2\2\u0177\u0175\3\2\2\2\u0178\u017b\3\2\2\2\u0179\u0177\3\2\2\2\u0179"+
		"\u017a\3\2\2\2\u017a\u0183\3\2\2\2\u017b\u0179\3\2\2\2\u017c\u017d\7C"+
		"\2\2\u017d\u0180\5,\27\2\u017e\u017f\7\37\2\2\u017f\u0181\7 \2\2\u0180"+
		"\u017e\3\2\2\2\u0180\u0181\3\2\2\2\u0181\u0183\3\2\2\2\u0182\u0153\3\2"+
		"\2\2\u0182\u016b\3\2\2\2\u0182\u017c\3\2\2\2\u0183/\3\2\2\2\u0184\u0185"+
		"\b\31\1\2\u0185\u018b\7\t\2\2\u0186\u0187\7\37\2\2\u0187\u0188\5\60\31"+
		"\2\u0188\u0189\7 \2\2\u0189\u018b\3\2\2\2\u018a\u0184\3\2\2\2\u018a\u0186"+
		"\3\2\2\2\u018b\u0194\3\2\2\2\u018c\u018d\f\3\2\2\u018d\u018f\7\37\2\2"+
		"\u018e\u0190\5\62\32\2\u018f\u018e\3\2\2\2\u018f\u0190\3\2\2\2\u0190\u0191"+
		"\3\2\2\2\u0191\u0193\7 \2\2\u0192\u018c\3\2\2\2\u0193\u0196\3\2\2\2\u0194"+
		"\u0192\3\2\2\2\u0194\u0195\3\2\2\2\u0195\61\3\2\2\2\u0196\u0194\3\2\2"+
		"\2\u0197\u0198\b\32\1\2\u0198\u0199\5\64\33\2\u0199\u019f\3\2\2\2\u019a"+
		"\u019b\f\3\2\2\u019b\u019c\7<\2\2\u019c\u019e\5\64\33\2\u019d\u019a\3"+
		"\2\2\2\u019e\u01a1\3\2\2\2\u019f\u019d\3\2\2\2\u019f\u01a0\3\2\2\2\u01a0"+
		"\63\3\2\2\2\u01a1\u019f\3\2\2\2\u01a2\u01a3\5\4\3\2\u01a3\u01a4\5\60\31"+
		"\2\u01a4\65\3\2\2\2\u01a5\u01a6\7\t\2\2\u01a6\67\3\2\2\2\u01a7\u01ad\5"+
		":\36\2\u01a8\u01ad\5> \2\u01a9\u01ad\5@!\2\u01aa\u01ad\5B\"\2\u01ab\u01ad"+
		"\5L\'\2\u01ac\u01a7\3\2\2\2\u01ac\u01a8\3\2\2\2\u01ac\u01a9\3\2\2\2\u01ac"+
		"\u01aa\3\2\2\2\u01ac\u01ab\3\2\2\2\u01ad9\3\2\2\2\u01ae\u01b2\7#\2\2\u01af"+
		"\u01b1\5<\37\2\u01b0\u01af\3\2\2\2\u01b1\u01b4\3\2\2\2\u01b2\u01b0\3\2"+
		"\2\2\u01b2\u01b3\3\2\2\2\u01b3\u01b5\3\2\2\2\u01b4\u01b2\3\2\2\2\u01b5"+
		"\u01b6\7$\2\2\u01b6;\3\2\2\2\u01b7\u01ba\58\35\2\u01b8\u01ba\5&\24\2\u01b9"+
		"\u01b7\3\2\2\2\u01b9\u01b8\3\2\2\2\u01ba=\3\2\2\2\u01bb\u01bd\5$\23\2"+
		"\u01bc\u01bb\3\2\2\2\u01bc\u01bd\3\2\2\2\u01bd\u01be\3\2\2\2\u01be\u01bf"+
		"\7;\2\2\u01bf?\3\2\2\2\u01c0\u01c1\7\25\2\2\u01c1\u01c2\7\37\2\2\u01c2"+
		"\u01c3\5$\23\2\u01c3\u01c4\7 \2\2\u01c4\u01c7\58\35\2\u01c5\u01c6\7\23"+
		"\2\2\u01c6\u01c8\58\35\2\u01c7\u01c5\3\2\2\2\u01c7\u01c8\3\2\2\2\u01c8"+
		"A\3\2\2\2\u01c9\u01ca\7\34\2\2\u01ca\u01cb\7\37\2\2\u01cb\u01cc\5$\23"+
		"\2\u01cc\u01cd\7 \2\2\u01cd\u01ce\58\35\2\u01ce\u01d6\3\2\2\2\u01cf\u01d0"+
		"\7\24\2\2\u01d0\u01d1\7\37\2\2\u01d1\u01d2\5D#\2\u01d2\u01d3\7 \2\2\u01d3"+
		"\u01d4\58\35\2\u01d4\u01d6\3\2\2\2\u01d5\u01c9\3\2\2\2\u01d5\u01cf\3\2"+
		"\2\2\u01d6C\3\2\2\2\u01d7\u01d8\5F$\2\u01d8\u01da\7;\2\2\u01d9\u01db\5"+
		"H%\2\u01da\u01d9\3\2\2\2\u01da\u01db\3\2\2\2\u01db\u01dc\3\2\2\2\u01dc"+
		"\u01de\7;\2\2\u01dd\u01df\5J&\2\u01de\u01dd\3\2\2\2\u01de\u01df\3\2\2"+
		"\2\u01df\u01ec\3\2\2\2\u01e0\u01e2\5$\23\2\u01e1\u01e0\3\2\2\2\u01e1\u01e2"+
		"\3\2\2\2\u01e2\u01e3\3\2\2\2\u01e3\u01e5\7;\2\2\u01e4\u01e6\5H%\2\u01e5"+
		"\u01e4\3\2\2\2\u01e5\u01e6\3\2\2\2\u01e6\u01e7\3\2\2\2\u01e7\u01e9\7;"+
		"\2\2\u01e8\u01ea\5J&\2\u01e9\u01e8\3\2\2\2\u01e9\u01ea\3\2\2\2\u01ea\u01ec"+
		"\3\2\2\2\u01eb\u01d7\3\2\2\2\u01eb\u01e1\3\2\2\2\u01ecE\3\2\2\2\u01ed"+
		"\u01ee\5\4\3\2\u01ee\u01ef\5(\25\2\u01ef\u01f2\3\2\2\2\u01f0\u01f2\5\4"+
		"\3\2\u01f1\u01ed\3\2\2\2\u01f1\u01f0\3\2\2\2\u01f2G\3\2\2\2\u01f3\u01f4"+
		"\5$\23\2\u01f4I\3\2\2\2\u01f5\u01f6\5$\23\2\u01f6K\3\2\2\2\u01f7\u01f8"+
		"\7\21\2\2\u01f8\u0201\7;\2\2\u01f9\u01fa\7\20\2\2\u01fa\u0201\7;\2\2\u01fb"+
		"\u01fd\7\31\2\2\u01fc\u01fe\5$\23\2\u01fd\u01fc\3\2\2\2\u01fd\u01fe\3"+
		"\2\2\2\u01fe\u01ff\3\2\2\2\u01ff\u0201\7;\2\2\u0200\u01f7\3\2\2\2\u0200"+
		"\u01f9\3\2\2\2\u0200\u01fb\3\2\2\2\u0201M\3\2\2\2\u0202\u0204\5P)\2\u0203"+
		"\u0202\3\2\2\2\u0204\u0207\3\2\2\2\u0205\u0203\3\2\2\2\u0205\u0206\3\2"+
		"\2\2\u0206\u0208\3\2\2\2\u0207\u0205\3\2\2\2\u0208\u0209\7\2\2\3\u0209"+
		"O\3\2\2\2\u020a\u020f\5R*\2\u020b\u020f\5T+\2\u020c\u020f\5&\24\2\u020d"+
		"\u020f\7;\2\2\u020e\u020a\3\2\2\2\u020e\u020b\3\2\2\2\u020e\u020c\3\2"+
		"\2\2\u020e\u020d\3\2\2\2\u020fQ\3\2\2\2\u0210\u0212\5\4\3\2\u0211\u0210"+
		"\3\2\2\2\u0211\u0212\3\2\2\2\u0212\u0213\3\2\2\2\u0213\u0214\5\60\31\2"+
		"\u0214\u0215\5:\36\2\u0215S\3\2\2\2\u0216\u0218\7\32\2\2\u0217\u0219\7"+
		"\t\2\2\u0218\u0217\3\2\2\2\u0218\u0219\3\2\2\2\u0219\u021a\3\2\2\2\u021a"+
		"\u021e\7#\2\2\u021b\u021d\5V,\2\u021c\u021b\3\2\2\2\u021d\u0220\3\2\2"+
		"\2\u021e\u021c\3\2\2\2\u021e\u021f\3\2\2\2\u021f\u0221\3\2\2\2\u0220\u021e"+
		"\3\2\2\2\u0221\u0225\7$\2\2\u0222\u0223\7\32\2\2\u0223\u0225\7\t\2\2\u0224"+
		"\u0216\3\2\2\2\u0224\u0222\3\2\2\2\u0225U\3\2\2\2\u0226\u0229\5&\24\2"+
		"\u0227\u0229\5R*\2\u0228\u0226\3\2\2\2\u0228\u0227\3\2\2\2\u0229W\3\2"+
		"\2\2?cm{\u0085\u0087\u0092\u009d\u00a3\u00b1\u00b3\u00bf\u00c1\u00cd\u00cf"+
		"\u00e1\u00e3\u00ef\u00f1\u00fc\u0107\u0112\u011d\u0128\u0132\u013b\u0145"+
		"\u014d\u0151\u015b\u0161\u0169\u0173\u0179\u0180\u0182\u018a\u018f\u0194"+
		"\u019f\u01ac\u01b2\u01b9\u01bc\u01c7\u01d5\u01da\u01de\u01e1\u01e5\u01e9"+
		"\u01eb\u01f1\u01fd\u0200\u0205\u020e\u0211\u0218\u021e\u0224\u0228";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}