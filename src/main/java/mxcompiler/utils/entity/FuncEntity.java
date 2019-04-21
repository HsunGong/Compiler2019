package mxcompiler.utils.entity;

import mxcompiler.ast.declaration.FuncDeclNode;
import mxcompiler.ast.declaration.VarDeclNode;
import mxcompiler.ast.statement.BlockStmtNode;
import mxcompiler.error.CompileError;
import mxcompiler.utils.type.ClassType;
import mxcompiler.utils.type.FuncType;
import mxcompiler.utils.type.NullType;
import mxcompiler.utils.type.Type;
import mxcompiler.utils.Dump;
import mxcompiler.utils.scope.Scope;

import java.util.ArrayList;
import java.util.List;

/**
 * returnType is NullType if construct! no entity cause, func has body of
 * block(which has a scope) // harm to build scope tree function is a scope!!!
 * FIX: from local resolver
 */
public class FuncEntity extends Entity {
	private Type returnType;
	public List<VarEntity> params = new ArrayList<VarEntity>();;

	public String className = "";
	// public boolean isMember = false; // useless

	public boolean isBuiltIn = false;// if true -> outInfluence is true

	public FuncEntity(String name, Type type, Type returnType) {
		super(name, type);
		this.returnType = returnType;
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

	public FuncEntity(FuncDeclNode node, String className) {
		super(node.getName(), new FuncType(node.getName()));

		// attentino: the order matters, __this should be first
		params.add(new VarEntity(Scope.BuiltIn.THIS.toString(), new ClassType(className)));

		for (VarDeclNode para : node.getVar()) {
			params.add(new VarEntity(para));
		}

		if (node.getReturnType() == null)
			throw new Error("set function error");
		else
			returnType = node.getReturnType().getType();
			
		// isConstruct = node.isConstruct();
		// isMember = true;
		if (className == "") throw new CompileError("Need className");
		this.className = className;
	}

	public boolean isConstruct() {
		return (returnType instanceof NullType);
	}

	public Type getReturnType() {
		return returnType;
	}

	public boolean isMember() { return className != ""; }

	public void _dump(Dump d) {
		d.printf("<Func Entity>:  name: %s, Type: %s\n", name, type.toString());
		d.printf(" returnType: %s, isBuiltIn: %b\n", returnType.toString(), isBuiltIn);
		d.printf(" isMember: %b, ClassName: %s\n", isMember(), className);
		d.println(" params:");
		d.addTab();
		if (!params.isEmpty())
			for (VarEntity e : params)
				e._dump(d);
		else
			d.println("null");
		d.delTab();
	}
}