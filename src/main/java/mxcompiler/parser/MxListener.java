// Generated from /home/xun/Documents/mxc/src/main/java/mxcompiler/parser/grammar/Mx.g4 by ANTLR 4.7.2
package mxcompiler.parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MxParser}.
 */
public interface MxListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MxParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(MxParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(MxParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(MxParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(MxParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#typeDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterTypeDeclaration(MxParser.TypeDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#typeDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitTypeDeclaration(MxParser.TypeDeclarationContext ctx);
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
	 * Enter a parse tree produced by {@link MxParser#x}.
	 * @param ctx the parse tree
	 */
	void enterX(MxParser.XContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#x}.
	 * @param ctx the parse tree
	 */
	void exitX(MxParser.XContext ctx);
}