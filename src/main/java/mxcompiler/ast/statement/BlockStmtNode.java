package mxcompiler.ast.statement;

import java.util.ArrayList;
import java.util.List;


import mxcompiler.ast.declaration.VarDeclListNode;
import mxcompiler.ast.declaration.VarDeclNode;
import mxcompiler.entity.scope.LocalScope;
import mxcompiler.ast.Location;import mxcompiler.ast.ASTDump;
public class BlockStmtNode extends StmtNode {
			@Override
	public void _dump(ASTDump d) {
		d.printf("<BlockStmtNode> %s\n", location.toString());
	}
	private List<StmtNode> stmts;
	private List<VarDeclNode> varList;
    private LocalScope scope;

    public BlockStmtNode (List<StmtNode> stmts, List<VarDeclNode> varList, Location location) {
		super(location);
        if(stmts == null) this.stmts = new ArrayList<StmtNode>();
		else this.stmts = stmts;

		if(varList == null) this.varList = new ArrayList<VarDeclNode>();
        else this.varList = varList;
    }

	public BlockStmtNode (List<StmtNode> stmts, VarDeclListNode varList, Location location) {
		this(stmts, varList.getList(), location);
	}

    public void setScope(LocalScope scope) { this.scope = scope; }
    public LocalScope getScope() { return scope; }

    public void addStmt(StmtNode stmt) { stmts.add(stmt); }
	public List<StmtNode> getStmts() { return stmts; }
	public List<VarDeclNode> getVar() { return varList; }

    // public List<Node> getVars() { return vars; }
}