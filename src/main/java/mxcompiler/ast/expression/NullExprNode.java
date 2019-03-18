package mxcompiler.ast.expression;

import mxcompiler.ast.Dump;

public class NullExprNode extends ExprNode {
    @Override
    public void _dump(Dump d) { d.print("Null expr");}
}