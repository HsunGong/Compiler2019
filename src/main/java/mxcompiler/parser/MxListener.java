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
	 * Enter a parse tree produced by {@link MxParser#topDefines}.
	 * @param ctx the parse tree
	 */
	void enterTopDefines(MxParser.TopDefinesContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#topDefines}.
	 * @param ctx the parse tree
	 */
	void exitTopDefines(MxParser.TopDefinesContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#functionDefinition}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDefinition(MxParser.FunctionDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#functionDefinition}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDefinition(MxParser.FunctionDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(MxParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(MxParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#typedef}.
	 * @param ctx the parse tree
	 */
	void enterTypedef(MxParser.TypedefContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#typedef}.
	 * @param ctx the parse tree
	 */
	void exitTypedef(MxParser.TypedefContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#params}.
	 * @param ctx the parse tree
	 */
	void enterParams(MxParser.ParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#params}.
	 * @param ctx the parse tree
	 */
	void exitParams(MxParser.ParamsContext ctx);
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
	 * Enter a parse tree produced by {@link MxParser#declarationSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterDeclarationSpecifier(MxParser.DeclarationSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#declarationSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitDeclarationSpecifier(MxParser.DeclarationSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#classDefinition}.
	 * @param ctx the parse tree
	 */
	void enterClassDefinition(MxParser.ClassDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#classDefinition}.
	 * @param ctx the parse tree
	 */
	void exitClassDefinition(MxParser.ClassDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#variableDefinition}.
	 * @param ctx the parse tree
	 */
	void enterVariableDefinition(MxParser.VariableDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#variableDefinition}.
	 * @param ctx the parse tree
	 */
	void exitVariableDefinition(MxParser.VariableDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#statements}.
	 * @param ctx the parse tree
	 */
	void enterStatements(MxParser.StatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#statements}.
	 * @param ctx the parse tree
	 */
	void exitStatements(MxParser.StatementsContext ctx);
}