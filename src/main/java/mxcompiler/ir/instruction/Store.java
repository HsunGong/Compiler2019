package mxcompiler.ir.instruction;

import mxcompiler.ir.IRVisitor;
import mxcompiler.ir.register.RegValue;
import mxcompiler.ir.register.StaticData;
import mxcompiler.utils.Dump;


public class Store extends Quad {
    private RegValue value;
    private int size;
    private RegValue baseAddr;
    private int offset;
    private boolean isStaticData;

    public Store(BasicBlock parent, RegValue value, int size, RegValue baseAddr, int addrOffset) {
        super(parent);
        if (size == 0)
            System.err.println("bad size 0");

        this.value = value;
        this.baseAddr = baseAddr;
        this.offset = addrOffset;
        this.size = size;
        this.isStaticData = false;
        // reloadUsedRegistersRegValues();
    }

    public Store(BasicBlock parent, RegValue value, int size, StaticData addr) {
        this(parent, value, size, addr, 0);

        this.isStaticData = true;
    }

    public RegValue getValue() {
        return value;
    }

    public int getSize() {
        return size;
    }

    public boolean isStaticData() {
        return isStaticData;
    }

    // @Override
    // public IRStore copyRename(Map<Object, Object> renameMap) {
    //     if (isStaticData) {
    //         return new IRStore(
    //                 (BasicBlock) renameMap.getOrDefault(getParentBB(), getParentBB()),
    //                 (RegValue) renameMap.getOrDefault(value, value),
    //                 size,
    //                 (StaticData) renameMap.getOrDefault(addr, addr)
    //         );
    //     } else {
    //         return new IRStore(
    //                 (BasicBlock) renameMap.getOrDefault(getParentBB(), getParentBB()),
    //                 (RegValue) renameMap.getOrDefault(value, value),
    //                 size,
    //                 (RegValue) renameMap.getOrDefault(addr, addr),
    //                 addrOffset
    //         );
    //     }
    // }


    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }

    public void _dump(Dump d) {
        d.println("Store");
    }
}
