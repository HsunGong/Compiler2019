package mxcompiler.ir;

import mxcompiler.ir.instruction.*;
import mxcompiler.ir.register.*;

public interface IRVisitor {
    public void visit(GlobalVarInit node);
    public void visit(Root node);

    public void visit(BasicBlock node);
    public void visit(Quad node);
    public void visit(Function node);
    public void visit(Bin node);
    public void visit(CJump node);
    public void visit(Cmp node);
    public void visit(Funcall node);
    public void visit(HeapAlloc node);
    public void visit(Jump node);
    public void visit(JumpQuad node);
    public void visit(Load node);
    public void visit(MemQuad node);
    public void visit(Move node);
    public void visit(Pop node);
    public void visit(Push node);
    public void visit(Return node);
    public void visit(Store node);
    public void visit(Uni node);
    
    public void visit(IntImm node);
    public void visit(PhysicalRegister node);
    public void visit(Register node);
    public void visit(RegValue node);
    public void visit(StackSlot node);
    public void visit(StaticData node);
    public void visit(StaticString node);
    public void visit(StaticVar node);
    public void visit(VirtualRegister node);
}