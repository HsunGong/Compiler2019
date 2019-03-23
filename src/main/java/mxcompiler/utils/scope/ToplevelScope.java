package mxcompiler.utils.scope;

import java.util.LinkedHashMap;
import java.util.Map;

import mxcompiler.utils.entity.Entity;
import mxcompiler.exception.SemanticException;

public class ToplevelScope extends Scope {
    public ToplevelScope() {
        super(null);
        entities = new LinkedHashMap<String, Entity>();
    }

    @Override
    public ToplevelScope toplevel() {
        return this;
    }

    @Override
    public Entity get(String k) throws SemanticException{
        Entity v = entities.get(k);
        if (v == null) { // error
            throw new SemanticException("not found "+k);
        }
        return v;
    }

    // better say define nor declare
    @Override
    public void put(String k, Entity v) throws SemanticException{
        Entity check = entities.get(k);
        if (check != null) {
            throw new SemanticException("already have "+k);
        }
        entities.put(k, v);
    }
}