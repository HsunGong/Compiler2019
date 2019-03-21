package mxcompiler.ast.expression;

import java.util.ArrayList;
import java.util.List;

import mxcompiler.ast.Dump;


/** Also for class method */
public class FuncallExprNode extends ExprNode {
    @Override
    public void _dump(Dump d) { d.print("fun call expr"); }

    private ExprNode expr;
    private List<ExprNode> params;
    // UGLY: funcEntity ?

    public FuncallExprNode(ExprNode e, List<ExprNode> params) {
        this.expr = e;
        if(params == null) this.params = new ArrayList<ExprNode>();
        else this.params = params;
    }

    public ExprNode getExpr() { return expr; }
    public List<ExprNode> getparams() { return params; }
}