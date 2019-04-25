package mxcompiler.ast.expression.lhs;

import mxcompiler.ast.expression.ExprNode;
import mxcompiler.ast.*;


/**
 * Lhs can be assign with value Without auto type transfer,
 * <p>
 * no originType is needed
 * <p>
 * Lhs contain Aref(Array), Member(Class),
 * String(Default-Class)??
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