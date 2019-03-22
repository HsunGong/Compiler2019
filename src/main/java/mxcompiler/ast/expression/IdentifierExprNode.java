package mxcompiler.ast.expression;


import mxcompiler.ast.*;
/** For variable identifier in primary expr 
 * Or maybe called nameExprNode is better?
*/
public class IdentifierExprNode extends ExprNode {
		@Override
	public void _dump(ASTDump d) {
				d.printf("<IdentifierExprNode> %s\n", location.toString());
		d.printf("identifier: %s\n", getIdentifier());
	}

    private String identifier;
    private boolean needMemOp = false;
    private boolean checked = false;
    // private VarEntity varEntity = null;

    public IdentifierExprNode(String identifier, Location location) {
		super(location);
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    } 

    public void setNeedMemOp(boolean needMemOp) {
        this.needMemOp = needMemOp;
    }

    public boolean isNeedMemOp() {
        return needMemOp;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
	}
		@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}
}