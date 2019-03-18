package mxcompiler.ast.expression;

import mxcompiler.ast.Dump;

/** for class */
public class ThisExprNode extends ExprNode {
    @Override
    public void _dump(Dump d) { d.print("this expr"); }

}