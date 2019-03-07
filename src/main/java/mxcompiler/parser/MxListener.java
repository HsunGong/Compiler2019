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
	 * Enter a parse tree produced by {@link MxParser#build}.
	 * @param ctx the parse tree
	 */
	void enterBuild(MxParser.BuildContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#build}.
	 * @param ctx the parse tree
	 */
	void exitBuild(MxParser.BuildContext ctx);
}