package mxcompiler.ir;

import java.util.*;

import mxcompiler.ast.statement.StmtNode;
import mxcompiler.ir.instruction.BasicBlock;
import mxcompiler.ir.instruction.Function;
import mxcompiler.ir.register.StaticData;
import mxcompiler.ir.register.StaticString;
// import mxcompiler.utils.scope.Scope;
import mxcompiler.utils.scope.Scope.BuiltIn;


public class Root {
    public boolean hasDivShiftInst = false;
    public int maxNumFuncArgs = 3;
    // public PhysicalRegister preg0, preg1;

    public Root() {
        initBuiltInFunc();
    }

    private Map<String, Function> builtInFuncs = new HashMap<>();
    // region builtinFun

    private void addFunc(String name, String label) {
        Function func;
        func = new Function(name, label);
        // func.getUsedPhysicalGeneralRegs().addAll(NASMRegisterSet.generalRegs);
        builtInFuncs.put(func.getName(), func);
    }

    // domin = "."
    static public final String BUILTIN_STRING_LENGTH_FUNC_NAME = BuiltIn.STRING.toString() + ".length";
    static public final String BUILTIN_ARRAY_SIZE_FUNC_NAME = BuiltIn.ARRAY.toString() + ".size";

    public void initBuiltInFunc() {
        addFunc("print", "_Z5_printPc");
        addFunc("println", "_Z7_printlnPc");
        addFunc("printInt", "_Z8_printInti");
        addFunc("printlnInt", "_Z10_printlnInti");
        addFunc("getString", "_Z9_getStringv");
        addFunc("getInt", "_Z6_getIntv");
        addFunc("toString", "_Z8_toStringi");

        addFunc(BuiltIn.STRING.toString() + ".substring", "_Z27_string_substringPcii");
        addFunc(BuiltIn.STRING.toString() + ".parseInt", "_Z26_string_parseIntPc");
        addFunc(BuiltIn.STRING.toString() + ".ord", "_Z21_string_ordPci");

        addFunc(BuiltIn.STRING.toString() + ".concat", "__builtin_string_concat");
        addFunc(BuiltIn.STRING.toString() + ".equal", "__builtin_string_equal");
        addFunc(BuiltIn.STRING.toString() + ".inequal", "__builtin_string_inequal");
        addFunc(BuiltIn.STRING.toString() + ".less", "__builtin_string_less");
        addFunc(BuiltIn.STRING.toString() + ".less_equal", "__builtin_string_less_equal");
    }

    public Map<String, Function> getBuiltInFunc() {
        return funcs;
    }

    public Function getBuiltInFunc(String name) {
        return builtInFuncs.get(name);
    }
    // endregion

    private Map<String, Function> funcs = new HashMap<>();
    // region funcs

    public Map<String, Function> getFunc() {
        return funcs;
    }

    // or called addFunc
    public void putFunc(Function func) {
        funcs.put(func.getName(), func);
    }

    public void delFunc(String name) {
        funcs.remove(name);
    }

    public Function getFunc(String name) {
        return funcs.get(name);
    }
    // endregion

    private Map<String, StaticString> staticStrs = new HashMap<>(); // Map<String, StaticString>
    private List<StaticData> staticDataList = new ArrayList<>();
    // region static

    public Map<String, StaticString> getStaticStr() {
        return staticStrs;
    }

    public void putStaticStr(StaticString str) {
        staticStrs.put(str.getVal(), str);
    }

    public StaticString getStaticStr(String name) {
        return staticStrs.get(name);
    }

    public void putStaticData(StaticData data) {
        staticDataList.add(data);
    }

    public List<StaticData> getStaticDataList() {
        return staticDataList;
    }
    // endregion

    public Map<StmtNode, ForRecord> forRecMap = new HashMap<>();

    public static class ForRecord {
        public BasicBlock cond, step, body, after;
        public boolean proccessed = false;

        public ForRecord(BasicBlock cond, BasicBlock step, BasicBlock body, BasicBlock after) {
            this.cond = cond;
            this.step = step;
            this.body = body;
            this.after = after;
        }
    }

    // public void updateCalleeSet() {}

    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}