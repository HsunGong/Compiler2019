package mxcompiler.ast.declaration;

import java.util.ArrayList;
import java.util.List;

import mxcompiler.ast.*;

public class ClassDeclNode extends DeclNode{
    @Override
    public void _dump(Dump d) { d.print("Class Decl"); }

    private List<VarDeclNode> varList;
    private List<FuncDeclNode> funcList;
    //  private IntValue intValue;
    // private LocalScope localScope;
    // public int size ; // ??

    // or maybe init Location, intvalue, offset
    /** forced to generate list from out of the construct function
     *  and list can be null, can add later
     */
    public ClassDeclNode(String name, 
        List<VarDeclNode> varList, List<FuncDeclNode> funcList) {
        super(name);
        
        if(varList != null ) this.varList = varList;
        else varList = new ArrayList<VarDeclNode>();
        if(funcList != null ) this.funcList = funcList;
        else funcList = new ArrayList<FuncDeclNode>();
    }

	public ClassDeclNode(String name, 
		VarDeclListNode varList, List<FuncDeclNode> funcList) {
		this(name, varList.getList(), funcList);
	}

    // TODO : add varNode here????/???? or add at init place ??
    public void putVar(VarDeclNode var) { varList.add(var); }
    public void putFunc(FuncDeclNode func) { funcList.add(func); }
    
    public List<VarDeclNode> getVar() { return varList; }
    public List<FuncDeclNode> getFunc() { return funcList; }
}