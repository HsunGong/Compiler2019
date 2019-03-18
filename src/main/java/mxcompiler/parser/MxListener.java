// Generated from /home/xun/Documents/mxc/src/main/java/mxcompiler/parser/grammar/Mx.g4 by ANTLR 4.7.2
package mxcompiler.parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MxParser}.
 */
public interface MxListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MxParser#compilationUnit}.
	 * @param ctx the parse tree
	 */
	void enterCompilationUnit(MxParser.CompilationUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#compilationUnit}.
	 * @param ctx the parse tree
	 */
	void exitCompilationUnit(MxParser.CompilationUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#translationUnit}.
	 * @param ctx the parse tree
	 */
	void enterTranslationUnit(MxParser.TranslationUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#translationUnit}.
	 * @param ctx the parse tree
	 */
	void exitTranslationUnit(MxParser.TranslationUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#logicalOrExpression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalOrExpression(MxParser.LogicalOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#logicalOrExpression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalOrExpression(MxParser.LogicalOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#logicalAndExpression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalAndExpression(MxParser.LogicalAndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#logicalAndExpression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalAndExpression(MxParser.LogicalAndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#binaryOrExpression}.
	 * @param ctx the parse tree
	 */
	void enterBinaryOrExpression(MxParser.BinaryOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#binaryOrExpression}.
	 * @param ctx the parse tree
	 */
	void exitBinaryOrExpression(MxParser.BinaryOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#binaryNorExpression}.
	 * @param ctx the parse tree
	 */
	void enterBinaryNorExpression(MxParser.BinaryNorExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#binaryNorExpression}.
	 * @param ctx the parse tree
	 */
	void exitBinaryNorExpression(MxParser.BinaryNorExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#binaryAndExpression}.
	 * @param ctx the parse tree
	 */
	void enterBinaryAndExpression(MxParser.BinaryAndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#binaryAndExpression}.
	 * @param ctx the parse tree
	 */
	void exitBinaryAndExpression(MxParser.BinaryAndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#equalExpression}.
	 * @param ctx the parse tree
	 */
	void enterEqualExpression(MxParser.EqualExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#equalExpression}.
	 * @param ctx the parse tree
	 */
	void exitEqualExpression(MxParser.EqualExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#compareExpression}.
	 * @param ctx the parse tree
	 */
	void enterCompareExpression(MxParser.CompareExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#compareExpression}.
	 * @param ctx the parse tree
	 */
	void exitCompareExpression(MxParser.CompareExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#shiftExpression}.
	 * @param ctx the parse tree
	 */
	void enterShiftExpression(MxParser.ShiftExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#shiftExpression}.
	 * @param ctx the parse tree
	 */
	void exitShiftExpression(MxParser.ShiftExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#addExpression}.
	 * @param ctx the parse tree
	 */
	void enterAddExpression(MxParser.AddExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#addExpression}.
	 * @param ctx the parse tree
	 */
	void exitAddExpression(MxParser.AddExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#multiExpression}.
	 * @param ctx the parse tree
	 */
	void enterMultiExpression(MxParser.MultiExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#multiExpression}.
	 * @param ctx the parse tree
	 */
	void exitMultiExpression(MxParser.MultiExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(MxParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(MxParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryExpressionPrefixInc}
	 * labeled alternative in {@link MxParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpressionPrefixInc(MxParser.UnaryExpressionPrefixIncContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryExpressionPrefixInc}
	 * labeled alternative in {@link MxParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpressionPrefixInc(MxParser.UnaryExpressionPrefixIncContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryExpressionPrefixDec}
	 * labeled alternative in {@link MxParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpressionPrefixDec(MxParser.UnaryExpressionPrefixDecContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryExpressionPrefixDec}
	 * labeled alternative in {@link MxParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpressionPrefixDec(MxParser.UnaryExpressionPrefixDecContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryExpressionPrefix}
	 * labeled alternative in {@link MxParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpressionPrefix(MxParser.UnaryExpressionPrefixContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryExpressionPrefix}
	 * labeled alternative in {@link MxParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpressionPrefix(MxParser.UnaryExpressionPrefixContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryExpressionPostfix}
	 * labeled alternative in {@link MxParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpressionPostfix(MxParser.UnaryExpressionPostfixContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryExpressionPostfix}
	 * labeled alternative in {@link MxParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpressionPostfix(MxParser.UnaryExpressionPostfixContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#unaryOperator}.
	 * @param ctx the parse tree
	 */
	void enterUnaryOperator(MxParser.UnaryOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#unaryOperator}.
	 * @param ctx the parse tree
	 */
	void exitUnaryOperator(MxParser.UnaryOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#postfixExpression}.
	 * @param ctx the parse tree
	 */
	void enterPostfixExpression(MxParser.PostfixExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#postfixExpression}.
	 * @param ctx the parse tree
	 */
	void exitPostfixExpression(MxParser.PostfixExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#args}.
	 * @param ctx the parse tree
	 */
	void enterArgs(MxParser.ArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#args}.
	 * @param ctx the parse tree
	 */
	void exitArgs(MxParser.ArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryExpression(MxParser.PrimaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryExpression(MxParser.PrimaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#expression10}.
	 * @param ctx the parse tree
	 */
	void enterExpression10(MxParser.Expression10Context ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#expression10}.
	 * @param ctx the parse tree
	 */
	void exitExpression10(MxParser.Expression10Context ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(MxParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(MxParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varDeclarationInit}
	 * labeled alternative in {@link MxParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVarDeclarationInit(MxParser.VarDeclarationInitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varDeclarationInit}
	 * labeled alternative in {@link MxParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVarDeclarationInit(MxParser.VarDeclarationInitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varDeclarationNone}
	 * labeled alternative in {@link MxParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVarDeclarationNone(MxParser.VarDeclarationNoneContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varDeclarationNone}
	 * labeled alternative in {@link MxParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVarDeclarationNone(MxParser.VarDeclarationNoneContext ctx);
	/**
	 * Enter a parse tree produced by the {@code variableDeclaratorNone}
	 * labeled alternative in {@link MxParser#variableDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaratorNone(MxParser.VariableDeclaratorNoneContext ctx);
	/**
	 * Exit a parse tree produced by the {@code variableDeclaratorNone}
	 * labeled alternative in {@link MxParser#variableDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaratorNone(MxParser.VariableDeclaratorNoneContext ctx);
	/**
	 * Enter a parse tree produced by the {@code variableDeclaratorInit}
	 * labeled alternative in {@link MxParser#variableDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaratorInit(MxParser.VariableDeclaratorInitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code variableDeclaratorInit}
	 * labeled alternative in {@link MxParser#variableDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaratorInit(MxParser.VariableDeclaratorInitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code newExpressionError}
	 * labeled alternative in {@link MxParser#newExpression}.
	 * @param ctx the parse tree
	 */
	void enterNewExpressionError(MxParser.NewExpressionErrorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newExpressionError}
	 * labeled alternative in {@link MxParser#newExpression}.
	 * @param ctx the parse tree
	 */
	void exitNewExpressionError(MxParser.NewExpressionErrorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code newExpressionArray}
	 * labeled alternative in {@link MxParser#newExpression}.
	 * @param ctx the parse tree
	 */
	void enterNewExpressionArray(MxParser.NewExpressionArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newExpressionArray}
	 * labeled alternative in {@link MxParser#newExpression}.
	 * @param ctx the parse tree
	 */
	void exitNewExpressionArray(MxParser.NewExpressionArrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code newExpressionNonarray}
	 * labeled alternative in {@link MxParser#newExpression}.
	 * @param ctx the parse tree
	 */
	void enterNewExpressionNonarray(MxParser.NewExpressionNonarrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newExpressionNonarray}
	 * labeled alternative in {@link MxParser#newExpression}.
	 * @param ctx the parse tree
	 */
	void exitNewExpressionNonarray(MxParser.NewExpressionNonarrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code typeArray}
	 * labeled alternative in {@link MxParser#type}.
	 * @param ctx the parse tree
	 */
	void enterTypeArray(MxParser.TypeArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code typeArray}
	 * labeled alternative in {@link MxParser#type}.
	 * @param ctx the parse tree
	 */
	void exitTypeArray(MxParser.TypeArrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code typeType}
	 * labeled alternative in {@link MxParser#type}.
	 * @param ctx the parse tree
	 */
	void enterTypeType(MxParser.TypeTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code typeType}
	 * labeled alternative in {@link MxParser#type}.
	 * @param ctx the parse tree
	 */
	void exitTypeType(MxParser.TypeTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#typeName}.
	 * @param ctx the parse tree
	 */
	void enterTypeName(MxParser.TypeNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#typeName}.
	 * @param ctx the parse tree
	 */
	void exitTypeName(MxParser.TypeNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#typedefName}.
	 * @param ctx the parse tree
	 */
	void enterTypedefName(MxParser.TypedefNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#typedefName}.
	 * @param ctx the parse tree
	 */
	void exitTypedefName(MxParser.TypedefNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code directDeclaratorIdentifier}
	 * labeled alternative in {@link MxParser#directDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterDirectDeclaratorIdentifier(MxParser.DirectDeclaratorIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by the {@code directDeclaratorIdentifier}
	 * labeled alternative in {@link MxParser#directDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitDirectDeclaratorIdentifier(MxParser.DirectDeclaratorIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code directDeclaratorWithParameterList}
	 * labeled alternative in {@link MxParser#directDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterDirectDeclaratorWithParameterList(MxParser.DirectDeclaratorWithParameterListContext ctx);
	/**
	 * Exit a parse tree produced by the {@code directDeclaratorWithParameterList}
	 * labeled alternative in {@link MxParser#directDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitDirectDeclaratorWithParameterList(MxParser.DirectDeclaratorWithParameterListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprStatement}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterExprStatement(MxParser.ExprStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprStatement}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitExprStatement(MxParser.ExprStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code blockStatement}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterBlockStatement(MxParser.BlockStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code blockStatement}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitBlockStatement(MxParser.BlockStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code switchStatement}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterSwitchStatement(MxParser.SwitchStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code switchStatement}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitSwitchStatement(MxParser.SwitchStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code iterationStatementWhile}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterIterationStatementWhile(MxParser.IterationStatementWhileContext ctx);
	/**
	 * Exit a parse tree produced by the {@code iterationStatementWhile}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitIterationStatementWhile(MxParser.IterationStatementWhileContext ctx);
	/**
	 * Enter a parse tree produced by the {@code iterationStatementFor}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterIterationStatementFor(MxParser.IterationStatementForContext ctx);
	/**
	 * Exit a parse tree produced by the {@code iterationStatementFor}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitIterationStatementFor(MxParser.IterationStatementForContext ctx);
	/**
	 * Enter a parse tree produced by the {@code jumpStatementContinue}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterJumpStatementContinue(MxParser.JumpStatementContinueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code jumpStatementContinue}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitJumpStatementContinue(MxParser.JumpStatementContinueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code jumpStatementBreak}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterJumpStatementBreak(MxParser.JumpStatementBreakContext ctx);
	/**
	 * Exit a parse tree produced by the {@code jumpStatementBreak}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitJumpStatementBreak(MxParser.JumpStatementBreakContext ctx);
	/**
	 * Enter a parse tree produced by the {@code jumpStatementReturn}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterJumpStatementReturn(MxParser.JumpStatementReturnContext ctx);
	/**
	 * Exit a parse tree produced by the {@code jumpStatementReturn}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitJumpStatementReturn(MxParser.JumpStatementReturnContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(MxParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(MxParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code forConditionInit}
	 * labeled alternative in {@link MxParser#forCondition}.
	 * @param ctx the parse tree
	 */
	void enterForConditionInit(MxParser.ForConditionInitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code forConditionInit}
	 * labeled alternative in {@link MxParser#forCondition}.
	 * @param ctx the parse tree
	 */
	void exitForConditionInit(MxParser.ForConditionInitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code forConditionNone}
	 * labeled alternative in {@link MxParser#forCondition}.
	 * @param ctx the parse tree
	 */
	void enterForConditionNone(MxParser.ForConditionNoneContext ctx);
	/**
	 * Exit a parse tree produced by the {@code forConditionNone}
	 * labeled alternative in {@link MxParser#forCondition}.
	 * @param ctx the parse tree
	 */
	void exitForConditionNone(MxParser.ForConditionNoneContext ctx);
	/**
	 * Enter a parse tree produced by the {@code forDeclarationInit}
	 * labeled alternative in {@link MxParser#forDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterForDeclarationInit(MxParser.ForDeclarationInitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code forDeclarationInit}
	 * labeled alternative in {@link MxParser#forDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitForDeclarationInit(MxParser.ForDeclarationInitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code forDeclarationNone}
	 * labeled alternative in {@link MxParser#forDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterForDeclarationNone(MxParser.ForDeclarationNoneContext ctx);
	/**
	 * Exit a parse tree produced by the {@code forDeclarationNone}
	 * labeled alternative in {@link MxParser#forDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitForDeclarationNone(MxParser.ForDeclarationNoneContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDeclaration(MxParser.FunctionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDeclaration(MxParser.FunctionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#functionDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDeclarator(MxParser.FunctionDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#functionDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDeclarator(MxParser.FunctionDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parameterListMulti}
	 * labeled alternative in {@link MxParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void enterParameterListMulti(MxParser.ParameterListMultiContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parameterListMulti}
	 * labeled alternative in {@link MxParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void exitParameterListMulti(MxParser.ParameterListMultiContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#parameterDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterParameterDeclaration(MxParser.ParameterDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#parameterDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitParameterDeclaration(MxParser.ParameterDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code classBodyDecl}
	 * labeled alternative in {@link MxParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassBodyDecl(MxParser.ClassBodyDeclContext ctx);
	/**
	 * Exit a parse tree produced by the {@code classBodyDecl}
	 * labeled alternative in {@link MxParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassBodyDecl(MxParser.ClassBodyDeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code classBodyNone}
	 * labeled alternative in {@link MxParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassBodyNone(MxParser.ClassBodyNoneContext ctx);
	/**
	 * Exit a parse tree produced by the {@code classBodyNone}
	 * labeled alternative in {@link MxParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassBodyNone(MxParser.ClassBodyNoneContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#classBody}.
	 * @param ctx the parse tree
	 */
	void enterClassBody(MxParser.ClassBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#classBody}.
	 * @param ctx the parse tree
	 */
	void exitClassBody(MxParser.ClassBodyContext ctx);
}