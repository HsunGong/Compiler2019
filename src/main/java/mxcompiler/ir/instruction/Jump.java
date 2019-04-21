package mxcompiler.ir.instruction;

import mxcompiler.ir.IRVisitor;
import mxcompiler.utils.Dump;


public class Jump extends JumpQuad {
    public BasicBlock target; // reference is fine to change value

    public Jump(BasicBlock parent, BasicBlock target) {
        super(parent);
        this.target = target;
    }

    public BasicBlock getTarget() {
        return target;
    }

    // @Override
    // public IRJump copyRename(Map<Object, Object> renameMap) {
    // return new IRJump(
    // (BasicBlock) renameMap.getOrDefault(getParentBB(), getParentBB()),
    // (BasicBlock) renameMap.getOrDefault(targetBB, targetBB)
    // );
    // }

    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }

    public void _dump(Dump d) {
        d.println("NO-Cond jump");
    }
}