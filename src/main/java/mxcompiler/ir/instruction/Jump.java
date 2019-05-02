package mxcompiler.ir.instruction;

import java.util.Map;

import mxcompiler.ir.IRVisitor;
import mxcompiler.utils.Dump;


public class Jump extends JumpQuad {
    private BasicBlock target; // reference is fine to change value

    public Jump(BasicBlock parent, BasicBlock target) {
        super(parent);
        this.target = target;
        reloadUsedRegs();
    }

    public BasicBlock getTarget() {
        return target;
    }

    public void setTarget(BasicBlock bb) {
        this.target = bb;
    }

    @Override
    public Jump copyRename(Map<Object, Object> renameMap) {
        return new Jump((BasicBlock) renameMap.getOrDefault(parent, parent),
                (BasicBlock) renameMap.getOrDefault(target, target));
    }

    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }

    public void _dump(Dump d) {
        d.println("NO-Cond jump");
    }
}