package mxcompiler.ir;

import mxcompiler.utils.Dump;

/** A Quad-Instruction */

abstract public class Quad {
    abstract public void accept(IRVisitor visitor);
    abstract public void _dump(Dump d);
    
    // protected Set<Register> def = new HashSet<>();
    // protected Set<Register> use = new HashSet<>();
    // protected Set<Register> in = new HashSet<>();
    // protected Set<Register> out = new HashSet<>();
    
    // enum Opcode {}

    // Opcode op;
    // Quad s1;
    // Quad s2;

    // Quad pre, next;

}