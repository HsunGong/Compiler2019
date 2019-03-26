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
	private List<Node> stmtsAndDecls;
	private LocalScope scope;

	public BlockStmtNode(List<StmtNode> stmts, List<Node> all, Location location) {
		super(location);
		
		this.stmts = (stmts != null) ? stmts : new ArrayList<StmtNode>();

		this.stmtsAndDecls = (all != null) ? all : new ArrayList<Node>();

		scope = null;
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

	public List<Node> getAll() {
		return stmtsAndDecls;
	}

	// public List<Node> getVars() { return vars; }
	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}
}