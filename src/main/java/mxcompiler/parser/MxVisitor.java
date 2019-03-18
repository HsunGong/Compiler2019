// Generated from /home/xun/Documents/mxc/src/main/java/mxcompiler/parser/grammar/Mx.g4 by ANTLR 4.7.2
package mxcompiler.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MxParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MxVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MxParser#compilationUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompilationUnit(MxParser.CompilationUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#translationUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTranslationUnit(MxParser.TranslationUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#logicalOrExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalOrExpression(MxParser.LogicalOrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#logicalAndExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalAndExpression(MxParser.LogicalAndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#binaryOrExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryOrExpression(MxParser.BinaryOrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#binaryNorExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryNorExpression(MxParser.BinaryNorExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#binaryAndExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryAndExpression(MxParser.BinaryAndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#equalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualExpression(MxParser.EqualExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#compareExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompareExpression(MxParser.CompareExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#shiftExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShiftExpression(MxParser.ShiftExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#addExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddExpression(MxParser.AddExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#multiExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiExpression(MxParser.MultiExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(MxParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unaryExpressionPrefixInc}
	 * labeled alternative in {@link MxParser#unaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpressionPrefixInc(MxParser.UnaryExpressionPrefixIncContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unaryExpressionPrefixDec}
	 * labeled alternative in {@link MxParser#unaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpressionPrefixDec(MxParser.UnaryExpressionPrefixDecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unaryExpressionPrefix}
	 * labeled alternative in {@link MxParser#unaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpressionPrefix(MxParser.UnaryExpressionPrefixContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unaryExpressionPostfix}
	 * labeled alternative in {@link MxParser#unaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpressionPostfix(MxParser.UnaryExpressionPostfixContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#unaryOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryOperator(MxParser.UnaryOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#postfixExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfixExpression(MxParser.PostfixExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#args}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgs(MxParser.ArgsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#primaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryExpression(MxParser.PrimaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#expression10}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression10(MxParser.Expression10Context ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(MxParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varDeclarationInit}
	 * labeled alternative in {@link MxParser#variableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDeclarationInit(MxParser.VarDeclarationInitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varDeclarationNone}
	 * labeled alternative in {@link MxParser#variableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDeclarationNone(MxParser.VarDeclarationNoneContext ctx);
	/**
	 * Visit a parse tree produced by the {@code variableDeclaratorNone}
	 * labeled alternative in {@link MxParser#variableDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaratorNone(MxParser.VariableDeclaratorNoneContext ctx);
	/**
	 * Visit a parse tree produced by the {@code variableDeclaratorInit}
	 * labeled alternative in {@link MxParser#variableDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaratorInit(MxParser.VariableDeclaratorInitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code newExpressionError}
	 * labeled alternative in {@link MxParser#newExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewExpressionError(MxParser.NewExpressionErrorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code newExpressionArray}
	 * labeled alternative in {@link MxParser#newExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewExpressionArray(MxParser.NewExpressionArrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code newExpressionNonarray}
	 * labeled alternative in {@link MxParser#newExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewExpressionNonarray(MxParser.NewExpressionNonarrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code typeArray}
	 * labeled alternative in {@link MxParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeArray(MxParser.TypeArrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code typeType}
	 * labeled alternative in {@link MxParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeType(MxParser.TypeTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#typeName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeName(MxParser.TypeNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#typedefName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypedefName(MxParser.TypedefNameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code directDeclaratorIdentifier}
	 * labeled alternative in {@link MxParser#directDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDirectDeclaratorIdentifier(MxParser.DirectDeclaratorIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by the {@code directDeclaratorWithParameterList}
	 * labeled alternative in {@link MxParser#directDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDirectDeclaratorWithParameterList(MxParser.DirectDeclaratorWithParameterListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprStatement}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprStatement(MxParser.ExprStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code blockStatement}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStatement(MxParser.BlockStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code switchStatement}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchStatement(MxParser.SwitchStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code iterationStatementWhile}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIterationStatementWhile(MxParser.IterationStatementWhileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code iterationStatementFor}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIterationStatementFor(MxParser.IterationStatementForContext ctx);
	/**
	 * Visit a parse tree produced by the {@code jumpStatementContinue}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJumpStatementContinue(MxParser.JumpStatementContinueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code jumpStatementBreak}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJumpStatementBreak(MxParser.JumpStatementBreakContext ctx);
	/**
	 * Visit a parse tree produced by the {@code jumpStatementReturn}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJumpStatementReturn(MxParser.JumpStatementReturnContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(MxParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forConditionInit}
	 * labeled alternative in {@link MxParser#forCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForConditionInit(MxParser.ForConditionInitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forConditionNone}
	 * labeled alternative in {@link MxParser#forCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForConditionNone(MxParser.ForConditionNoneContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forDeclarationInit}
	 * labeled alternative in {@link MxParser#forDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForDeclarationInit(MxParser.ForDeclarationInitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forDeclarationNone}
	 * labeled alternative in {@link MxParser#forDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForDeclarationNone(MxParser.ForDeclarationNoneContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#functionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclaration(MxParser.FunctionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#functionDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclarator(MxParser.FunctionDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parameterListMulti}
	 * labeled alternative in {@link MxParser#parameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterListMulti(MxParser.ParameterListMultiContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#parameterDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterDeclaration(MxParser.ParameterDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code classBodyDecl}
	 * labeled alternative in {@link MxParser#classDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassBodyDecl(MxParser.ClassBodyDeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code classBodyNone}
	 * labeled alternative in {@link MxParser#classDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassBodyNone(MxParser.ClassBodyNoneContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#classBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassBody(MxParser.ClassBodyContext ctx);
}