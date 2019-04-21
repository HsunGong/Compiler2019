package mxcompiler.ir.instruction;

import java.util.List;

import mxcompiler.error.CompileError;
import mxcompiler.ir.IRVisitor;
import mxcompiler.ir.register.RegValue;
import mxcompiler.utils.Dump;


public class Funcall extends Quad {
    private Function func;
    private List<RegValue> args;
    private RegValue dst;

    public Funcall(BasicBlock parent, Function func, List<RegValue> args, RegValue dst) {
        super(parent);
        this.func = func;
        if (args == null)
            throw new CompileError("Funcall args should be empty not null");
        this.args = args;
        this.dst = dst;

        // reloadUsedRegistersRegValues
    }

    public Function getFunc() {
        return func;
    }

    public List<RegValue> getArgs() {
        return args;
    }

    public RegValue getDst() {
        return dst;
    }

    // @Override
    // public IRFunctionCall copyRename(Map<Object, Object> renameMap) {
    // List<RegValue> copyArgs = new ArrayList<>();
    // for (RegValue arg : args) {
    // copyArgs.add((RegValue) renameMap.getOrDefault(arg, arg));
    // }
    // return new IRFunctionCall(
    // (BasicBlock) renameMap.getOrDefault(getParentBB(), getParentBB()),
    // func,
    // copyArgs,
    // (VirtualRegister) renameMap.getOrDefault(dest, dest)
    // );
    // }

    
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }

    public void _dump(Dump d) {
        d.println("unary");
    }
}