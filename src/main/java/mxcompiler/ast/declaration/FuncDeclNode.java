package mxcompiler.ast.declaration;

import java.util.ArrayList;
import java.util.List;

import mxcompiler.ast.*;
import mxcompiler.ast.statement.BlockStmtNode;
import mxcompiler.type.NullType;
import mxcompiler.ast.Location;
import mxcompiler.ast.ASTDump;

public class FuncDeclNode extends DeclNode {
	@Override
	public void _dump(ASTDump d) {
		d.printf("<FuncDeclNode> %s\n", location.toString());
		d.printf(" name: %s\n", getName());
		d.printf(" isContruct: %b\n", isConstruct());
	}

	private boolean isConstruct;
	private TypeNode returnType;
	private List<VarDeclNode> varList;
	private BlockStmtNode body; // or stmts???
	// private list<stmts> ir; // TODO for IR
	// public int cntregister;
	// private BasciBlock start, over;

	public FuncDeclNode(String name, TypeNode returnType, VarDeclListNode varList, BlockStmtNode body,
			Location location) {
		this(name, returnType, varList.getList(), body, location);
	}

	/**
	 * List can not add later
	 */
	public FuncDeclNode(String name, TypeNode returnType, List<VarDeclNode> varList, BlockStmtNode body,
			Location location) {
		super(name, location);

		this.returnType = returnType;
		if (returnType == null)
			throw new Error("function set returnType Error");
		if (returnType.getType() instanceof NullType)
			this.isConstruct = true;
		else
			this.isConstruct = false;

		if (varList != null)
			this.varList = varList;
		else
			this.varList = new ArrayList<VarDeclNode>();
		this.body = body;
	}

	public boolean isConstruct() {
		return isConstruct;
	}

	public TypeNode getReturnType() {
		return returnType;
	}

	public List<VarDeclNode> getVar() {
		return varList;
	}

	public BlockStmtNode getBody() {
		return body;
	}

	// public void addVar(VarDeclNode v) { varList.add(v); }

}