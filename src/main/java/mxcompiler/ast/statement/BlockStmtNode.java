package mxcompiler.ast.statement;

import java.util.ArrayList;
import java.util.List;

import mxcompiler.utils.scope.LocalScope;
import mxcompiler.ast.*;
import mxcompiler.utils.Dump;

public class BlockStmtNode extends StmtNode {
	@Override
	public void _dump(Dump d) {
		d.printf("<BlockStmtNode> %s\n", location.toString());
	}

	// private List<StmtNode> stmts;
	private List<Node> stmtsAndDecls;
	private LocalScope scope;

	public BlockStmtNode(List<Node> all, Location location) {
		super(location);
		
		// this.stmts = (stmts != null) ? stmts : new ArrayList<StmtNode>();

		this.stmtsAndDecls = (all != null) ? all : new ArrayList<Node>();

		scope = null;
	}

	public void setScope(LocalScope scope) {
		this.scope = scope;
	}

	public LocalScope getScope() {
		return scope;
	}

	public void addStmt(Node stmt) {
		// stmts.add(stmt);
		stmtsAndDecls.add(stmt);
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