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
	 * Visit a parse tree produced by {@link MxParser#variableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaration(MxParser.VariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#variableDeclaratorList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaratorList(MxParser.VariableDeclaratorListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#variableDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclarator(MxParser.VariableDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayType}
	 * labeled alternative in {@link MxParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayType(MxParser.ArrayTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nonarrayType}
	 * labeled alternative in {@link MxParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNonarrayType(MxParser.NonarrayTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#typeName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeName(MxParser.TypeNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#functionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclaration(MxParser.FunctionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#paramDeclarationList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamDeclarationList(MxParser.ParamDeclarationListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#paramDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamDeclaration(MxParser.ParamDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#typeReturn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeReturn(MxParser.TypeReturnContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#classDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclaration(MxParser.ClassDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#classBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassBody(MxParser.ClassBodyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code blockStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStmt(MxParser.BlockStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprStmt(MxParser.ExprStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStmt(MxParser.IfStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code whileStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStmt(MxParser.WhileStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forInitStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForInitStmt(MxParser.ForInitStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forNoneStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForNoneStmt(MxParser.ForNoneStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code continueStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinueStmt(MxParser.ContinueStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code breakStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakStmt(MxParser.BreakStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code returnStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStmt(MxParser.ReturnStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code blankStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlankStmt(MxParser.BlankStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#forDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForDeclaration(MxParser.ForDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(MxParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#blockBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockBody(MxParser.BlockBodyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code newExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewExpr(MxParser.NewExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code prefixExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixExpr(MxParser.PrefixExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryExpr(MxParser.PrimaryExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funcallExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncallExpr(MxParser.FuncallExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code suffixExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuffixExpr(MxParser.SuffixExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code memberExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemberExpr(MxParser.MemberExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arefExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArefExpr(MxParser.ArefExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binaryExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryExpr(MxParser.BinaryExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignExpr(MxParser.AssignExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#paramList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamList(MxParser.ParamListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#primaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryExpression(MxParser.PrimaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(MxParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code errorCreator}
	 * labeled alternative in {@link MxParser#creator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitErrorCreator(MxParser.ErrorCreatorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayCreator}
	 * labeled alternative in {@link MxParser#creator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayCreator(MxParser.ArrayCreatorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nonArrayCreator}
	 * labeled alternative in {@link MxParser#creator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNonArrayCreator(MxParser.NonArrayCreatorContext ctx);
}