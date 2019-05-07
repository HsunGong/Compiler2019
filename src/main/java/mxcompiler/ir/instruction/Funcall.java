package mxcompiler.ir.instruction;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import mxcompiler.error.CompileError;
import mxcompiler.ir.IRVisitor;
import mxcompiler.ir.register.RegValue;
import mxcompiler.ir.register.Register;
import mxcompiler.ir.register.VirtualRegister;
import mxcompiler.utils.Dump;


public class Funcall extends Quad {
    private Function func;
    private List<RegValue> args;
    private RegValue dst;

    public Funcall(BasicBlock parent, Function func, List<RegValue> args, RegValue destion) {
        super(parent);
        this.func = func;
        if (args == null)
            throw new CompileError("Funcall args should be empty not null");
        if (destion != null && !(destion instanceof Register))
            throw new CompileError("error destion of funcall");
        this.args = args;
        this.dst = destion;

        reloadUsedRegs();
    }

    public Function getFunc() {
        return func;
    }

    public List<RegValue> getArgs() {
        return args;
    }

    public Register getDst() {
        return (Register) dst;
    }

    /** {@inheritDoc} */
    @Override
    public Funcall copyRename(Map<Object, Object> renameMap) {
        List<RegValue> copyArgs = new ArrayList<>();
        for (RegValue arg : args) {
            copyArgs.add((RegValue) renameMap.getOrDefault(arg, arg));
        }
        return new Funcall((BasicBlock) renameMap.getOrDefault(parent, parent), func, copyArgs,
                (VirtualRegister) renameMap.getOrDefault(dst, dst));
    }

    /** {@inheritDoc} */
    @Override
    public void reloadUsedRegs() {
        usedRegisters.clear();
        usedRegValues.clear();
        for (RegValue arg : args) {
            if (arg instanceof Register)
                usedRegisters.add((Register) arg);
            usedRegValues.add(arg);
        }
    }

    /** {@inheritDoc} */
    @Override
    public void setUsedRegisters(Map<Register, Register> renameMap) {
        for (int i = 0; i < args.size(); ++i) {
            if (args.get(i) instanceof Register) {
                args.set(i, renameMap.get((Register) args.get(i)));
            }
        }
        reloadUsedRegs();
    }

    /** {@inheritDoc} */
    @Override
    public Register getDefinedRegister() {
        return (Register) dst;
    }

    /** {@inheritDoc} */
    @Override
    public void setDefinedRegister(Register vreg) {
        dst = vreg;
    }

    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }

    public void _dump(Dump d) {
        d.println("unary");
    }
}