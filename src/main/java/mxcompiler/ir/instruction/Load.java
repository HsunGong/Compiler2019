package mxcompiler.ir.instruction;

import mxcompiler.ir.IRVisitor;
import mxcompiler.ir.register.RegValue;
import mxcompiler.ir.register.StaticData;
import mxcompiler.utils.Dump;


public class Load extends Quad {
    private RegValue dst; // Register
    private int size;
    private boolean isStaticData, isLoadAddr;
    public RegValue addr;
    public int offset;

    public Load(BasicBlock parent, RegValue destion, int size, RegValue addr, int addrOffset) {
        super(parent);
        if (size == 0)
            System.err.println("oh bad size 0");

        this.dst = destion;
        this.addr = addr;
        this.offset = addrOffset;
        this.size = size;
        this.isStaticData = false;
        // reloadUsedRegistersRegValues();
    }

    public Load(BasicBlock parent, RegValue destion, int size, StaticData addr, boolean isLoadAddr) {
        this(parent, destion, size, addr, 0);

        this.isStaticData = true;
        this.isLoadAddr = isLoadAddr;
    }

    public RegValue getDst() {
        return dst;
    }

    public int getSize() {
        return size;
    }

    public boolean isStaticData() {
        return isStaticData;
    }

    // @Override
    // public IRLoad copyRename(Map<Object, Object> renameMap) {
    // if (isStaticData) {
    // return new IRLoad(
    // (BasicBlock) renameMap.getOrDefault(getParentBB(), getParentBB()),
    // (IRRegister) renameMap.getOrDefault(dest, dest),
    // size,
    // (StaticData) renameMap.getOrDefault(addr, addr),
    // isLoadAddr
    // );
    // } else {
    // return new IRLoad(
    // (BasicBlock) renameMap.getOrDefault(getParentBB(), getParentBB()),
    // (IRRegister) renameMap.getOrDefault(dest, dest),
    // size,
    // (RegValue) renameMap.getOrDefault(addr, addr),
    // addrOffset
    // );
    // }
    // }

    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }

    public void _dump(Dump d) {
        d.println("Load");
    }
}
