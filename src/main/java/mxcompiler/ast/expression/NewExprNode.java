package mxcompiler.ast.expression;

import java.util.List;

import mxcompiler.ast.Dump;
import mxcompiler.ast.TypeNode;

/** for creator */
public class NewExprNode extends ExprNode {
    @Override
    public void _dump(Dump d) { d.print("new expr"); }
    
    private TypeNode newType;
    private List<ExprNode> dims;
    // private int numDim; // for dimension

    public NewExprNode(TypeNode newType, List<ExprNode> dims) {
        this.newType = newType;
        this.dims = dims;
    }

    public TypeNode getNewType() {
        return newType;
    }

    public List<ExprNode> getDims() {
        return dims;
    }

} 