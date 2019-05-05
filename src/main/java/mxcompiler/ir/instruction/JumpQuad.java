package mxcompiler.ir.instruction;

/** abstract calss for {@link Jump}, {@link CJump}, {@link Return} */
abstract public class JumpQuad extends Quad {
    public JumpQuad(BasicBlock parent) {
        super(parent);
    }
}