package mxcompiler.ast.declaration;

import java.util.ArrayList;
import java.util.List;

import mxcompiler.ast.*;

public class ClassDefineNode extends DeclarationNode{
    @Override
    public void _dump(Dump d) { d.print("Class define"); }

    private List<VarDefineNode> varList;
    private List<FuncDefineNode> funcList;
    //  private IntValue intValue;
    // private LocalScope localScope;
    // public int size ; // ??

    // or maybe init Location, intvalue, offset
    /** forced to generate list from out of the construct function
     *  and list can be null, can add later
     */
    public ClassDefineNode(String name, 
        List<VarDefineNode> varList, List<FuncDefineNode> funcList) {
        super(name);
        
        if(varList != null ) this.varList = varList;
        else varList = new ArrayList<VarDefineNode>();
        if(funcList != null ) this.funcList = funcList;
        else funcList = new ArrayList<FuncDefineNode>();
    }

    // TODO : add varNode here????/???? or add at init place ??
    public void putVar(VarDefineNode var) { varList.add(var); }
    public void putFunc(FuncDefineNode func) { funcList.add(func); }
    
    public List<VarDefineNode> getVar() { return varList; }
    public List<FuncDefineNode> getFunc() { return funcList; }
}