package mxcompiler.ir.instruction;

import mxcompiler.error.CompileError;
import mxcompiler.ir.IRVisitor;
import mxcompiler.ir.register.RegValue;
import mxcompiler.ir.register.Register;
import mxcompiler.utils.Dump;


/** alloc memory */
public class HeapAlloc extends Quad {
    private RegValue dst;
    private RegValue allocSize;

    public HeapAlloc(BasicBlock parent, RegValue destion, RegValue allocSize) {
        super(parent);
        // TOOD: copy to 
        if (!(destion instanceof Register))
            throw new CompileError("Error with register");
        this.dst = destion;
        this.allocSize = allocSize;
        // reloadUsedRegistersRegValues
    }

    public RegValue getDst() {
        return dst;
    }

    public RegValue getAllocSize() {
        return allocSize;
    }

    // @Override
    // public IRHeapAlloc copyRename(Map<Object, Object> renameMap) {
    //     return new IRHeapAlloc((BasicBlock) renameMap.getOrDefault(getParentBB(), getParentBB()),
    //             (IRRegister) renameMap.getOrDefault(dest, dest),
    //             (RegValue) renameMap.getOrDefault(allocSize, allocSize));
    // }

    public void _dump(Dump d) {
        d.println("alloc mme");
    }

    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}