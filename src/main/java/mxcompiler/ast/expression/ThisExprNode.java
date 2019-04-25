package mxcompiler.ast.expression;

import mxcompiler.ast.*;


/**
 * for class and Primary Expr
 * 
 * <pre>
 * {@code 
 * this = x;
 * this.mem = y;
 * }
 * </pre>
 */
public class ThisExprNode extends ExprNode {
	@Override
	public void _dump(ASTDump d) {
		d.printf("<ThisExprNode> %s\n", location.toString());

	}

	public ThisExprNode(Location location) {
		super(location);
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}
}