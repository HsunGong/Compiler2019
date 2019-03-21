package mxcompiler.ast.expression;

import mxcompiler.ast.Node;
import mxcompiler.type.Type;
import mxcompiler.ast.Location;
abstract public class ExprNode extends Node{
    protected Type type;
	// regvalue, basicblock, addrOffset
	public ExprNode(Location location) {
		super(location);}
    
    public void setType(Type t) { this.type = t; }
    public Type getType() { return type; }
    public boolean isEqual(Type rhs) { return rhs == this.type; }
    
    // protected boolean isLeftValue;
    // public void setIsLeftValue(boolean s) { this.isLeftValue = s; }
    // public boolean isLeftValue() { return isLeftValue; } 
    public boolean isLeftValue() { return false; }
}