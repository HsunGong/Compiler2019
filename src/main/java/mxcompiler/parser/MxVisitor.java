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
	 * Visit a parse tree produced by {@link MxParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(MxParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#build}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBuild(MxParser.BuildContext ctx);
}