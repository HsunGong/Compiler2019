package mxcompiler.ast.expression.lhs;

import mxcompiler.ast.expression.ExprNode;
import mxcompiler.ast.*;

/**
 * Lhs can be assign with value Without auto type transfer, no originType is
 * needed
 */
abstract public class LhsExprNode extends ExprNode {
	@Override
	public boolean isLeftValue() {
		return true;
	}
	// isLoadable, isAssignable, allocSize() ...

	public LhsExprNode(Location location) {
		super(location);
	}
}