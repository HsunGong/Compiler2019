package mxcompiler.ast.statement;

import java.util.ArrayList;
import java.util.List;

import mxcompiler.ast.Dump;
import mxcompiler.ast.declaration.VarDeclListNode;
import mxcompiler.ast.declaration.VarDeclNode;
import mxcompiler.entity.scope.LocalScope;

public class BlockStmtNode extends StmtNode {
    @Override
    public void _dump(Dump d) { d.print("block stmt"); }
    
	private List<StmtNode> stmts;
	private List<VarDeclNode> varList;
    private LocalScope scope;
    // private List<Node> vars;

    // FIX: whether put vars here or not
    public BlockStmtNode (List<StmtNode> stmts, List<VarDeclNode> varList) {
        if(stmts == null) this.stmts = new ArrayList<StmtNode>();
		else this.stmts = stmts;

		if(varList == null) this.varList = new ArrayList<VarDeclNode>();
        else this.varList = varList;
    }

	public BlockStmtNode (List<StmtNode> stmts, VarDeclListNode varList) {
		this(stmts, varList.getList());
	}

    public void setScope(LocalScope scope) { this.scope = scope; }
    public LocalScope getScope() { return scope; }

    public void addStmt(StmtNode stmt) { stmts.add(stmt); }
	public List<StmtNode> getStmts() { return stmts; }
	public List<VarDeclNode> getVarList() { return varList; }

    // public List<Node> getVars() { return vars; }
}