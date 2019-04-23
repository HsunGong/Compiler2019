package mxcompiler.ir.instruction;

import mxcompiler.ir.IRVisitor;
import mxcompiler.ir.register.RegValue;
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

    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }

    public void _dump(Dump d) {
        d.println("Move");
    }
}
