package mxcompiler.ir.instruction;

/** abstract calss for Jump, CJump, Return */
abstract public class JumpQuad extends Quad {
    public JumpQuad(BasicBlock parent) {
        super(parent);
    }
}