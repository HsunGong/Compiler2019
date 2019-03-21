package mxcompiler.ast.expression;


import mxcompiler.ast.Location;
/** For variable identifier in primary expr */
public class IdentifierExprNode extends ExprNode {

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
}