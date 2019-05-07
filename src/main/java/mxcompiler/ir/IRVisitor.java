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
    
    public String visit(IntImm node);
    public String visit(PhysicalRegister node);
    public String visit(Register node);
    public String visit(RegValue node);
    public String visit(StackSlot node);
    public String visit(StaticData node);
    public String visit(StaticString node);
    public String visit(StaticVar node);
    public String visit(VirtualRegister node);
}