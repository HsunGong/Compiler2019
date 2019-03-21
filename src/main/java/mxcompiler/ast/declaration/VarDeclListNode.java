package mxcompiler.ast.declaration;

import java.util.List;


import mxcompiler.ast.Node;
import mxcompiler.ast.Location;
/**
 * Current No use for AST maybe can transfer all List<varNode> into this class
 * 
 * @see can not add later, have to add outside
 */
public class VarDeclListNode extends Node {


	private List<VarDeclNode> varList;

	public VarDeclListNode(List<VarDeclNode> list, Location location) {
		super(location);
		this.varList = list;
	}

	public List<VarDeclNode> getList() {
		return varList;
	}

	public void add(VarDeclNode n) {
		varList.add(n);
	}
}