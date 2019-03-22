package mxcompiler.ast.expression;

import java.util.ArrayList;
import java.util.List;


import mxcompiler.ast.Location;
import mxcompiler.ast.ASTDump;
/** Also for class method */
public class FuncallExprNode extends ExprNode {
		@Override
	public void _dump(ASTDump d) {
		d.printf("<FuncallExprNode> %s\n", location.toString());
	}
    private ExprNode expr;
    private List<ExprNode> params;
    // UGLY: funcEntity ?

    public FuncallExprNode(ExprNode e, List<ExprNode> params, Location location) {
		super(location);
        this.expr = e;
        if(params == null) this.params = new ArrayList<ExprNode>();
        else this.params = params;
    }

    public ExprNode getExpr() { return expr; }
    public List<ExprNode> getParam() { return params; }
}