package mxcompiler.ir.instruction;
import mxcompiler.ir.IRVisitor;

abstract public class JumpQuad extends Quad {
    public JumpQuad(BasicBlock parent) {
        super(parent);
    }
}