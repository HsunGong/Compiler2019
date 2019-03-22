package mxcompiler.ast.expression;


import mxcompiler.ast.Location;
import mxcompiler.ast.ASTDump;
/** Maybe for Nullliteral?? */
public class NullExprNode extends ExprNode {
			@Override
	public void _dump(ASTDump d) {
				d.printf("<NullExprNode> %s\n", location.toString());

	}
	public NullExprNode(Location location) {
		super(location);
	}
}