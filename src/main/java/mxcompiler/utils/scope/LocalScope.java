package mxcompiler.utils.scope;

import java.util.LinkedHashMap;

import mxcompiler.utils.entity.Entity;
import mxcompiler.exception.SemanticException;

public class LocalScope extends Scope {
	// FIX: what if Scope of class??
	public LocalScope(Scope parent) {
		super(parent);
		parent.addChild(this);
		entities = new LinkedHashMap<String, Entity>();
	}

	@Override
	public ToplevelScope toplevel() {
		return parent.toplevel();
	}

	// a little different from entities
	// rather say variables or declarations
	/** get entity for current level */
	public Entity getCur(String k) throws SemanticException {
		Entity v = entities.get(k);
		if (v == null) { // error
			throw new SemanticException("not found " + k);
		}
		return v;
	}

	@Override
	public Entity get(String k) throws SemanticException {
		Entity v = entities.get(k);
		if (v == null) { // cycle
			return this.parent.get(k);
		}
		return v;
	}

	/** may have same name in different scopes */
	@Override
	public void put(String k, Entity v) throws SemanticException {
		Entity check = entities.get(k); // or getCur
		// FIX: what if a class New var ? is vatType or ClassType?
		if (check != null && (check.getType() == v.getType())) {
			throw new SemanticException("already have " + k);
		}
		entities.put(k, v);
	}
}