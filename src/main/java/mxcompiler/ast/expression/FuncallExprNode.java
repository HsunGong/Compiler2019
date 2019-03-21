package mxcompiler.ast.expression;

import java.util.ArrayList;
import java.util.List;


import mxcompiler.ast.Location;

/** Also for class method */
public class FuncallExprNode extends ExprNode {
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