package mxcompiler.ir.instruction;

import java.util.Map;

import mxcompiler.ir.IRVisitor;
import mxcompiler.ir.register.RegValue;
import mxcompiler.ir.register.Register;
import mxcompiler.utils.Dump;


public class Move extends Quad {
    private RegValue dst; // lhs
    private RegValue rhs;

    public Move(BasicBlock parent, RegValue destion, RegValue rhs) {
        super(parent);
        this.dst = destion;
        this.rhs = rhs;
    }

    public RegValue getDst() {
        return dst;
    }

    private RegValue getLhs() {
        return dst;
    }

    public RegValue getRhs() {
        return rhs;
    }

    @Override
    public Move copyRename(Map<Object, Object> renameMap) {
        return new Move((BasicBlock) renameMap.getOrDefault(parent, parent),
                (Register) renameMap.getOrDefault(dst, dst),
                (RegValue) renameMap.getOrDefault(rhs, rhs));
    }

    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }

    public void _dump(Dump d) {
        d.println("Move");
    }
}
