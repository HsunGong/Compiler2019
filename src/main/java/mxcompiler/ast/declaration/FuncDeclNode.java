package mxcompiler.ast.declaration;


import java.util.ArrayList;
import java.util.List;

import mxcompiler.ast.*;
import mxcompiler.ast.statement.BlockStmtNode;
import mxcompiler.type.Type;

public class FuncDeclNode extends DeclNode{
    @Override
    public void _dump(Dump d) { d.print("Var Decl"); }

    private boolean isConstruct;
    private TypeNode returnType;
    private List<VarDeclNode> varList;
    private BlockStmtNode body; // or stmts???
    // private list<stmts> ir; // TODO for IR
    // public int cntregister;
    // private BasciBlock start, over;
    
    public FuncDeclNode(String name, TypeNode returnType, 
            VarDeclListNode varList, BlockStmtNode body) {
        this(name, returnType, varList.getList(), body);
	}
	
    /**
     * List can not add later
     */
    public FuncDeclNode(String name, TypeNode returnType, 
            List<VarDeclNode> varList, BlockStmtNode body) {
        super(name);

        this.returnType = returnType;
        if(returnType == null) this.isConstruct = true;
        else this.isConstruct = false;

        if(varList != null) this.varList = varList;
        else this.varList = new ArrayList<VarDeclNode>();
        this.body = body;
    }

    public boolean isConstruct() { return isConstruct; }
    public TypeNode getReturnType() { return returnType; }
    public List<VarDeclNode> getVar() { return varList; }
    public BlockStmtNode getBody() { return body; }

    // public void addVar(VarDeclNode v) { varList.add(v); }






}