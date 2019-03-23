package mxcompiler.utils.entity;

import mxcompiler.ast.declaration.FuncDeclNode;
import mxcompiler.ast.declaration.VarDeclNode;
import mxcompiler.type.FuncType;
import mxcompiler.type.Type;

import java.util.ArrayList;
import java.util.List;

public class FuncEntity extends Entity {
	private boolean isConstruct = false;
	public Type returnType;
	// function is a scope!!! FIX: from local resolver
	// harm to build scope tree
	public List<VarEntity> params = new ArrayList<VarEntity>();;

	public String className = "";
	public boolean isMember = false;

	// what is the diff between ???
	public boolean isBuiltIn = false;// if true -> outInfluence is true
	// public boolean outInfluence = false; //FIX: seems no use

	public FuncEntity(String name, Type type) {
		super(name, type);
	}

	public FuncEntity(FuncDeclNode node) {
		super(node.getName(), new FuncType(node.getName()));

		for (VarDeclNode para : node.getVar()) {
			params.add(new VarEntity(para));
		}

		if (node.getReturnType() == null)
			throw new Error("set function error");
		else
			returnType = node.getReturnType().getType();
		isConstruct = node.isConstruct();
	}
	

	FuncEntity(FuncDeclNode node, String className) {
		super(node.getName(), new FuncType(node.getName()));

		for (VarDeclNode para : node.getVar()) {
			params.add(new VarEntity(para));
		}

		if (node.getReturnType() == null)
			throw new Error("set function error");
		else
			returnType = node.getReturnType().getType();
		isConstruct = node.isConstruct();

		// FIX: to add a lead Node: parameters.add(new VarEntity(Scope.THIS_PARA_NAME,
		// new ClassType(className)));
		isMember = true;
		this.className = className;
		for (VarDeclNode paraDecl : node.getVar()) {
			params.add(new VarEntity(paraDecl, className));
		}

		if (node.getReturnType() == null)
			throw new Error("set function error");
		else
			returnType = node.getReturnType().getType();
		isConstruct = node.isConstruct();
	}

	public boolean isConstruct() {
		return isConstruct;
	}

}