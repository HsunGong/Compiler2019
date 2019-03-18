package mxcompiler.ast.expression;

import java.util.ArrayList;
import java.util.List;

import mxcompiler.ast.Dump;


/** Also for class method */
public class FuncallExprNode extends ExprNode {
    @Override
    public void _dump(Dump d) { d.print("fun call expr"); }

    private ExprNode expr;
    private List<ExprNode> args;
    // FIX: funcEntity ?

    public FuncallExprNode(ExprNode e, List<ExprNode> args) {
        this.expr = e;
        if(args == null) this.args = new ArrayList<ExprNode>();
        else this.args = args;
    }

    public ExprNode getExpr() { return expr; }
    public List<ExprNode> getArgs() { return args; }
}