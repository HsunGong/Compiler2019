package mxcompiler.ast.expression.lhs;

import mxcompiler.ast.expression.ExprNode;
import mxcompiler.ast.*;


/**
 * This is the array index node -- subscript
 * <p>
 * Get cur-arrray or value
 */
public class ArefExprNode extends LhsExprNode {
	@Override
	public void _dump(ASTDump d) {
		d.printf("<ArrayrefExprNode> %s:\n", location.toString());
	}

	private ExprNode expr;
	private ExprNode index;

	public ArefExprNode(ExprNode expr, ExprNode index, Location location) {
		super(location);
		this.expr = expr;
		this.index = index;
	}

	public ExprNode getExpr() {
		return expr;
	}

	public ExprNode getIndex() {
		return index;
	}

	// public int getDim() { return dims; }
	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}
}