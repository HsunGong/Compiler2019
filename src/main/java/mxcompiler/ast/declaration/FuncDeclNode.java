package mxcompiler.ast.declaration;

import java.util.ArrayList;
import java.util.List;

import mxcompiler.ast.statement.BlockStmtNode;
import mxcompiler.type.NullType;
import mxcompiler.type.Type;
import mxcompiler.ast.*;;

/** no need to judge if return type is null
 * no need to judge if return type is construct
 * cause, returnType is NullType; if construct
 */
public class FuncDeclNode extends DeclNode {
	@Override
	public void _dump(ASTDump d) {
		d.printf("<FuncDeclNode> %s\n", location.toString());
		d.printf(" name: %s\n", getName());
		d.printf(" hasReturn: %b\n", hasReturn());
	}

	// private boolean isConstruct;
	private TypeNode returnType;
	private List<VarDeclNode> paramList;
	private BlockStmtNode body; // or stmts???
	// private list<stmts> ir; // TODO for IR
	// public int cntregister;
	// private BasciBlock start, over;

	public FuncDeclNode(String name, TypeNode returnType, VarDeclListNode varList, BlockStmtNode body,
			Location location) {
		// NOTE: varList is null, fixed outside
		// this(name, returnType,(varList != null) ? varList.getList(): null, body,
		// location);
		this(name, returnType, varList.getList(), body, location);
	}

	/**
	 * List can not add later
	 */
	public FuncDeclNode(String name, TypeNode returnType, List<VarDeclNode> params, BlockStmtNode body,
			Location location) {
		super(name, location);

		this.returnType = returnType;
		if (returnType == null)
			throw new Error("function set returnType Error");
		// if (returnType.getType() instanceof NullType)
		// 	this.isConstruct = true;
		// else
		// 	this.isConstruct = false;

		if (params != null)
			this.paramList = params;
		else
			this.paramList = new ArrayList<VarDeclNode>();
		this.body = body;
	}

	public boolean hasReturn() {
		return returnType.getType().getInnerType() != Type.InnerType.NULL;
	}

	public TypeNode getReturnType() {
		return returnType;
	}

	public List<VarDeclNode> getVar() {
		return paramList;
	}

	public BlockStmtNode getBody() {
		return body;
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}
}