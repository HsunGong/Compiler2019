package mxcompiler.ast;

import java.io.PrintStream;

import org.antlr.v4.runtime.ParserRuleContext;

/**
 * A {@code Node} is the abstract Abstract Syntax Tree abstract Node
 * <p>
 * Rewrite from top to down
 * <p>
 * The {@linkplain mxcompiler.ast.ASTNode} is root Node
 * <p>
 *  AST dump is realized in {@linkplain mxcompiler.ast.ASTDump} 
 * @author Xun
 * @since 1.0
 */

abstract public class Node {
	public Node(Location location) {
		this.location = location;
	}

	protected Location location;

	// abstract void visit(ASTVisitor visitor);

	abstract public void _dump(ASTDump d);
}