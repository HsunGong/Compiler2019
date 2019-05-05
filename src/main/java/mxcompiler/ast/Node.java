package mxcompiler.ast;

import mxcompiler.utils.Dump;

/**
 * A {@code Node} is the abstract Abstract Syntax Tree abstract Node
 * <p>
 * Rewrite from top to down
 * <p>
 * The {@linkplain mxcompiler.ast.ASTNode} is root Node
 * <p>
 * AST dump is realized in {@linkplain mxcompiler.main.ASTDump}
 * 
 * @author Xun
 * @since 1.0
 */

abstract public class Node {
	public Node(Location location) {
		this.location = location;
	}

	protected Location location;

	public final Location getLocation() {
		return location;
	}

	// abstract void visit(ASTVisitor visitor);

	abstract public void _dump(Dump d);

	abstract public void accept(ASTVisitor visitor);
}