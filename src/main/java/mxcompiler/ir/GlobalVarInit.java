package mxcompiler.ir;

import mxcompiler.ast.expression.ExprNode;
import mxcompiler.utils.Dump;


/** gloabl var = staticvar (+ init) */
public class GlobalVarInit {
    private String name;
    private ExprNode init;

    public GlobalVarInit(String name, ExprNode init) {
        this.name = name;
        this.init = init;
    }

    public String getName() {
        return name;
    }

    public ExprNode getExpr() {
        return init;
    }

    public void _dump(Dump d) {
        d.println("Global var");
    }
}