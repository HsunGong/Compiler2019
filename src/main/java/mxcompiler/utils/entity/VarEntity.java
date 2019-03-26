package mxcompiler.utils.entity;

import mxcompiler.ast.declaration.VarDeclNode;
import mxcompiler.exception.CompileError;
import mxcompiler.type.Type;
import mxcompiler.type.VarType;
import mxcompiler.utils.Dump;

public class VarEntity extends Entity {
	// private IRRegister irRegister;
	// private boolean unUsed = false;

	// FIX: what is offset for?
	// FIX: what is member for?
	// FIX: why private, I change into public
	// public int offset;
	private boolean isMember = false;
	private String className;
	public boolean isGlobal = false;

	public VarEntity(String name, Type type) {
		super(name, type);
		if ((type instanceof VarType))
			throw new CompileError("VarType still alive");
	}

	public VarEntity(String name, Type type, String className) {
		super(name, type);
		if ((type instanceof VarType))
			throw new CompileError("VarType still alive");

		isMember = true;
		this.className = className;
	}

	public VarEntity(VarDeclNode node) {
		super(node.getName(), node.getType().getType());
	}

	public VarEntity(VarDeclNode node, String className) {
		super(node.getName(), node.getType().getType());

		isMember = true;
		this.className = className;
	}

	public void _dump(Dump d) {
		d.printf("<Var Entity>:  name: %s, Type: %s\n", name, type.toString());
		d.printf(" isMember: %b, ClassName: %s\n", isMember, className);
		d.printf(" isGlobal: %b\n", isGlobal);
	}

	public void setClassName(String className) {
		if (this.className != null)
			throw new Error("repeat define ClassName");
		this.className = className;
	}
}