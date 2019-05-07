package mxcompiler.ir.register;

import mxcompiler.ir.IRVisitor;
import mxcompiler.utils.Dump;

public class StaticString extends StaticData {
    private String val;

    public StaticString(String value) {
        super("static_string", RegSize);
        this.val = value;
    }

    public String getValue() {
        return val;
    }

    public String accept(IRVisitor visitor) {
        return visitor.visit(this);
    }

    public void _dump(Dump d) {
        d.println("static string");
    }
}