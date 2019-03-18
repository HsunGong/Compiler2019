package mxcompiler.ast;

import mxcompiler.type.Type;

/** This class {@code TypeNode} is important
 * cause, it connect astNodes with inbuild types
 * which details are in {@linkplain mxcompiler.type.Type }
 */
public class TypeNode extends Node {
    @Override
    public void _dump(Dump d) { d.print("type"); }
    
    protected Type type;
    // protected dim; // FIX:

    public TypeNode(Type type) {
        this.type = type;
    }

    public Type getType() { return type; }
    public void setType(Type t) throws Exception{
        if (type != null) {
            throw new Exception();
        }
        type = t;
    }
    public boolean isEqual(TypeNode rhs) { return rhs.type == this.type; }
    
}