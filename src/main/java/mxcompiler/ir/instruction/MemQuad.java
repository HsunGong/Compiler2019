package mxcompiler.ir.instruction;

/** abstract class for Load and Move */
abstract public class MemQuad extends Quad {
    public MemQuad(BasicBlock parent) {
        super(parent);
    }
}