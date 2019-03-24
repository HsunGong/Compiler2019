package mxcompiler.utils.entity;

import mxcompiler.ast.declaration.FuncDeclNode;
import mxcompiler.ast.declaration.VarDeclNode;
import mxcompiler.type.FuncType;
import mxcompiler.type.Type;

import java.util.ArrayList;
import java.util.List;

/**
 * returnType is NullType if construct!
 * no entity cause, func has body of block(which has a scope) // harm to build
 * scope tree function is a scope!!! 
 * FIX: from local resolver
 */
public class FuncEntity extends Entity {
	// private boolean isConstruct = false;
	private Type returnType;
	public List<VarEntity> params = new ArrayList<VarEntity>();;

	public String className = "";
	public boolean isMember = false;

	// what is the diff between ???
	public boolean isBuiltIn = false;// if true -> outInfluence is true
	// public boolean outInfluence = false; //FIX: seems no use

	public FuncEntity(String name, Type type, Type returnType) {
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
		// isConstruct = node.isConstruct();
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
		// isConstruct = node.isConstruct();

		// FIX: to add a lead Node: parameters.add(new VarEntity(Scope.THIS_PARA_NAME,
		// new ClassType(className)));
		isMember = true;
		this.className = className;
	}

	public boolean isConstruct() {
		return (returnType.getInnerType() == Type.InnerType.NULL);
	}

	public Type getReturnType() { return returnType; }
}