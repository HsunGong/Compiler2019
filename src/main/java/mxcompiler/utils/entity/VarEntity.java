package mxcompiler.utils.entity;

import mxcompiler.ast.declaration.VarDeclNode;
import mxcompiler.type.Type;

public class VarEntity extends Entity {
	// private IRRegister irRegister;
	// private boolean unUsed = false;

	// FIX: what is offset for?
	// FIX: what is member for?
	// FIX: why private, I change into public
	public int offset;
	private boolean isMember = false;
	private String className;
	public boolean isGlobal = false;

	public VarEntity(String name, Type type) {
		super(name, type);
	}

	public VarEntity(String name, Type type, String className) {
		super(name, type);
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
}