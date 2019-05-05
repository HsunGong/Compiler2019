package mxcompiler.ir.register;

import mxcompiler.ir.IRVisitor;
import mxcompiler.utils.Dump;

/** global Vars */
public class StaticVar extends StaticData {
    public StaticVar(String name, int size) {
        super(name, size);
    }

    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }

    public void _dump(Dump d) {
        d.println("static string");
    }
}