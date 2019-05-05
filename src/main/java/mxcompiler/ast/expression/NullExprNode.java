package mxcompiler.ast.expression;

import mxcompiler.ast.*;
import mxcompiler.utils.Dump;

/** Maybe for Nullliteral?? */
public class NullExprNode extends ExprNode {
	@Override
	public void _dump(Dump d) {
		d.printf("<NullExprNode> %s\n", location.toString());

	}

	public NullExprNode(Location location) {
		super(location);
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}
}