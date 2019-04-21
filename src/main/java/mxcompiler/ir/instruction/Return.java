package mxcompiler.ir.instruction;

import mxcompiler.ir.IRVisitor;
import mxcompiler.ir.register.RegValue;
import mxcompiler.utils.Dump;

public class Return extends JumpQuad {
    private RegValue val;

    public Return(BasicBlock parent, RegValue value) {
        super(parent);
        this.val = value;
        // reloadUsedRegistersRegValues
    }

    public RegValue getReturnVal() { return val;}


    // @Override
    // public IRReturn copyRename(Map<Object, Object> renameMap) {
    //     return new IRReturn(
    //             (BasicBlock) renameMap.getOrDefault(getParentBB(), getParentBB()),
    //             (RegValue) renameMap.getOrDefault(retValue, retValue)
    //     );
    // }



    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
    public void _dump(Dump d) { d.println("return");}
}