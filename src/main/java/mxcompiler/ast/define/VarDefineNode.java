package mxcompiler.ast.define;

import mxcompiler.ast.*;
import mxcompiler.ast.expression.ExprNode;
import mxcompiler.type.Type;

public class VarDefineNode extends DefineNode{
    @Override
    public void _dump(Dump d) { d.print("Var define"); }

    private Type type;
    private ExprNode init;
    // public int offset; // FIX: what is this?
    // public IntValue intvalue; // TODO: for IR
    // public Location location; // TODO: for debugging


    // or maybe init Location, intvalue, offset
    public VarDefineNode(String name, ExprNode init, 
                            Type vartype) {
        super(name);
        this.type = vartype;
        this.init = init;
    }

    public Type getType() { return type; }
    public ExprNode getInit() { return init; }
}