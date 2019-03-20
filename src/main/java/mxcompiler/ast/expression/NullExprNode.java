package mxcompiler.ast.expression;

import mxcompiler.ast.Dump;

/** Maybe for Nullliteral?? */
public class NullExprNode extends ExprNode {
    @Override
    public void _dump(Dump d) { d.print("Null expr");}
}