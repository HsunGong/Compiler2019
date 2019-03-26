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

	@Override
	public Entity getVarFun(String k, String domain) throws SemanticException {
		Entity v = (entities.get(k) != null) ? entities.get(k) : entities.get(domain + k);
		if (v == null) { // cycle
			return this.parent.getVarFun(k, domain);
		}
		return v;
	}

	/** may have same name in different scopes */
	@Override
	public void put(String k, Entity v) throws SemanticException {
		Entity check = entities.get(k); // or getCur
		// FIX: what if a class New var ? is varType or ClassType?
		// && (check.getType() == v.getType())
		if (check != null) {
			throw new SemanticException("already have " + k);
		}
		entities.put(k, v);
	}
}