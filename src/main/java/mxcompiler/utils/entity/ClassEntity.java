package mxcompiler.utils.entity;

import mxcompiler.ast.declaration.*;
import mxcompiler.exception.SemanticException;
import mxcompiler.type.ClassType;
import mxcompiler.type.Type;
import mxcompiler.utils.scope.*;

public class ClassEntity extends Entity {
	private LocalScope scope;
	// FIX: what is this ? seems no use(after searching)
	// public int memorySize;

	public ClassEntity(String name, Type type, Scope parentScope) {
		super(name, type);
		// FIX: to specifiy is class scope or not
		this.scope = new LocalScope(parentScope);
	}

	public ClassEntity(ClassDeclNode node, Scope parentScope) {
		super(node.getName(), new ClassType(node.getName()));

		this.scope = new LocalScope(parentScope);

		for (FuncDeclNode func : node.getFunc()) {
			try {
				scope.put(
					func.getName(), 
					new FuncEntity(func, node.getName())
				);
			} catch (SemanticException e) {
				throw new Error("Symbol name" + func.getName() + "is already defined");
			}
		}
	}

	public Scope getScope() {
		return scope;
	}
}