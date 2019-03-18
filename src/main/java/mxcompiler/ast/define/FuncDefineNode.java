package mxcompiler.ast.define;

import java.util.ArrayList;
import java.util.List;

import mxcompiler.ast.*;
import mxcompiler.ast.statement.BlockStmtNode;
import mxcompiler.type.Type;

public class FuncDefineNode extends DefineNode{
    @Override
    public void _dump(Dump d) { d.print("Var define"); }

    private boolean isConstruct;
    private Type returnType;
    private List<VarDefineNode> varList;
    private BlockStmtNode body; // or stmts???
    // private list<stmts> ir; // TODO for IR
    // public int cntregister;
    // private BasciBlock start, over;
    
    
    /**
     * List can be null, and add later
     */
    public FuncDefineNode(String name, Type returnType, 
            List<VarDefineNode> varList, BlockStmtNode body) {
        super(name);

        this.returnType = returnType;
        if(returnType == null) this.isConstruct = true;
        else this.isConstruct = false;

        if(varList != null) this.varList = varList;
        else this.varList = new ArrayList<VarDefineNode>();
        this.body = body;
    }

    public boolean isConstruct() { return isConstruct; }
    public Type getReturnType() { return returnType; }
    public List<VarDefineNode> getVar() { return varList; }
    public BlockStmtNode getBody() { return body; }

    public void addVar(VarDefineNode v) { varList.add(v); }






}