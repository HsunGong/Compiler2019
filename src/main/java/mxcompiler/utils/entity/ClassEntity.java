package mxcompiler.utils.entity;

import mxcompiler.ast.declaration.*;
import mxcompiler.error.CompileError;
import mxcompiler.utils.type.ClassType;
import mxcompiler.utils.type.Type;
import mxcompiler.utils.Dump;
import mxcompiler.utils.scope.*;

public class ClassEntity extends Entity {
	private LocalScope scope;
	public int memSize; // remain size in memory

	public ClassEntity(String name, Type type, Scope parentScope) {
		super(name, type);
		if(!(type instanceof ClassType)) throw new CompileError("init class entity err");

		this.scope = new LocalScope(parentScope);
		memSize = 0;
	}

	public ClassEntity(ClassDeclNode node, Scope parentScope) {
		super(node.getName(), new ClassType(node.getName()));

		this.scope = new LocalScope(parentScope);
	}

	public String getDomain() {
		return this.name + Scope.BuiltIn.DOMAIN.toString();
	}

	public LocalScope getScope() {
		return scope;
	}

	public void _dump(Dump d) {
		d.printf("<Class Entity>:  name: %s, Type: %s\n", name, type.toString());
		d.printf(" offset:%d\n", memSize);
		d.addTab();
		scope._dump(d);
		d.delTab();
	}
}