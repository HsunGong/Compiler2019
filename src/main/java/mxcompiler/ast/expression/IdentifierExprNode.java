package mxcompiler.ast.expression;

import mxcompiler.ast.Dump;

/** For variable identifier in primary expr */
public class IdentifierExprNode extends ExprNode {
    @Override
    public void _dump(Dump d) { d.print("identifier expr"); }
    
    private String identifier;
    private boolean needMemOp = false;
    private boolean checked = false;
    // private VarEntity varEntity = null;

    public IdentifierExprNode(String identifier) {
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