package mxcompiler.ast.declaration;

import java.util.ArrayList;
import java.util.List;

import mxcompiler.ast.*;

/**
 * Current No use for AST maybe can transfer all List<varNode> into this class
 * 
 * @see can not add later, have to add outside VI: List can be null
 */
public class VarDeclListNode extends Node {
	@Override
	public void _dump(ASTDump d) {
		for (VarDeclNode decl : varList) {
			decl._dump(d);
		}
	}

	private List<VarDeclNode> varList;

	public VarDeclListNode(List<VarDeclNode> list, Location location) {
		super(location);
		this.varList = (list != null) ? list : new ArrayList<VarDeclNode>();
	}

	public List<VarDeclNode> getList() {
		return varList;
	}

	public void add(VarDeclNode n) {
		varList.add(n);
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}
}