package mxcompiler.utils.scope;

import java.util.LinkedHashMap;
import java.util.Map;

import mxcompiler.utils.entity.Entity;
import mxcompiler.error.SemanticError;


public class ToplevelScope extends Scope {
	public ToplevelScope() {
		super(null);
		entities = new LinkedHashMap<String, Entity>();
	}

	@Override
	public ToplevelScope toplevel() {
		return this;
	}

	/** {@inheritDoc} */
	@Override
	public Entity get(String k) throws SemanticError {
		Entity v = entities.get(k);
		// if (v == null) { // error
		// throw new SemanticError("not found " + k);
		// }
		return v;
	}

	@Override
	public Entity getVarFun(String k, String domain) throws SemanticError {
		Entity v = entities.get(k);
		if (v == null) { // error
			throw new SemanticError("not found " + k);
		}
		return v;
	}

	/** {@inheritDoc} */
	@Override
	public void put(String k, Entity v) throws SemanticError {
		Entity check = entities.get(k);
		if (check != null) {
			throw new SemanticError("already have " + k);
		}
		entities.put(k, v);
	}
}