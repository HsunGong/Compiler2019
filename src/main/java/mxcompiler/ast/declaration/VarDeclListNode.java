package mxcompiler.ast.declaration;

import java.util.List;

import mxcompiler.ast.Dump;
import mxcompiler.ast.Node;

/**
 * Current No use for AST maybe can transfer all List<varNode> into this class
 * 
 * @see can not add later, have to add outside
 */
public class VarDeclListNode extends Node {
	@Override
	public void _dump(Dump d) {
		d.print("List Nodes");
	}

	private List<VarDeclNode> varList;

	public VarDeclListNode(List<VarDeclNode> list) {
		this.varList = list;
	}

	public List<VarDeclNode> getList() {
		return varList;
	}

	public void add(VarDeclNode n) {
		varList.add(n);
	}
}