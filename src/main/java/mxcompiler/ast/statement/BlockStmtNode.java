package mxcompiler.ast.statement;

import java.util.ArrayList;
import java.util.List;

import mxcompiler.ast.declaration.VarDeclListNode;
import mxcompiler.ast.declaration.VarDeclNode;
import mxcompiler.utils.scope.LocalScope;
import mxcompiler.ast.*;

public class BlockStmtNode extends StmtNode {
	@Override
	public void _dump(ASTDump d) {
		d.printf("<BlockStmtNode> %s\n", location.toString());
	}

	private List<StmtNode> stmts;
	private List<VarDeclNode> varList;
	private LocalScope scope;

	public BlockStmtNode(List<StmtNode> stmts, List<VarDeclNode> varList, Location location) {
		super(location);
		
		this.stmts = (stmts != null) ? stmts : new ArrayList<StmtNode>();

		this.varList = (varList != null) ? varList : new ArrayList<VarDeclNode>();

		scope = null;
	}

	public BlockStmtNode(List<StmtNode> stmts, VarDeclListNode varList, Location location) {
		this(stmts, varList.getList(), location);
	}

	public void setScope(LocalScope scope) {
		this.scope = scope;
	}

	public LocalScope getScope() {
		return scope;
	}

	public void addStmt(StmtNode stmt) {
		stmts.add(stmt);
	}

	public List<StmtNode> getStmts() {
		return stmts;
	}

	public List<VarDeclNode> getVar() {
		return varList;
	}

	// public List<Node> getVars() { return vars; }
	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}
}