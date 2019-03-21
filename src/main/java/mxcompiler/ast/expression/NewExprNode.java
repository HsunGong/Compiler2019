package mxcompiler.ast.expression;

import java.util.List;


import mxcompiler.ast.TypeNode;
import mxcompiler.ast.Location;
/** for creator */
public class NewExprNode extends ExprNode {

    private TypeNode newType;
    private List<ExprNode> dims;
    private int num; // for dimension-number

    public NewExprNode(TypeNode newType, List<ExprNode> dims, int num, Location location) {
		super(location);
        this.newType = newType;
		this.dims = dims;
		this.num = num;
    }

    public TypeNode getNewType() {
        return newType;
    }

    public List<ExprNode> getDims() {
        return dims;
	}
	
	public int getNum() { return num; }

} 