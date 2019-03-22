package mxcompiler.ast.expression;

import java.util.List;


import mxcompiler.ast.TypeNode;
import mxcompiler.ast.Location;import mxcompiler.ast.ASTDump;
/** for creator */
public class NewExprNode extends ExprNode {
			@Override
	public void _dump(ASTDump d) {
		d.printf("<NewExprNode> %s\n", location.toString());
		d.printf(" numDim: %d\n", num);
	}

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