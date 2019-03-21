package mxcompiler.entity.scope;

import java.util.LinkedHashMap;
import java.util.Map;

import mxcompiler.entity.Entity;
import mxcompiler.exception.SemanticException;

public class ToplevelScope extends Scope {
	// FIX: DeclNode is alse Entity
	public Map<String, Entity> entities; 
    // public List<DeclNode> staticVariables;

    public ToplevelScope() {
        super(null);
        entities = new LinkedHashMap<String, Entity>();
        // staticVariables = null;
    }

    @Override
    public ToplevelScope toplevel() {
        return this;
    }

    @Override
    public Entity get(String k) throws SemanticException{
        Entity v = entities.get(k);
        if (v == null) { // error
            throw new SemanticException();
        }
        return v;
    }

    // better say define nor declare
    @Override
    public void put(String k, Entity v) throws SemanticException{
        Entity check = entities.get(k);
        if (check != null) {
            throw new SemanticException();
        }
        entities.put(k, v);
    }
}