package mxcompiler.entity.scope;

import java.util.LinkedHashMap;
import java.util.Map;

import mxcompiler.entity.Entity;
import mxcompiler.exception.SemanticException;

public class LocalScope extends Scope {
    // public Map<String, Node> Variables;
    
    // a little different from entities
    // rather say variables or declarations
    public Map<String, Entity> entities;

    public LocalScope(Scope parent) {
        super(parent);
        parent.addChild(this);
        entities = new LinkedHashMap<String, Entity>();
    }

    @Override
    public ToplevelScope toplevel() { return parent.toplevel(); }

    /** get entity for current level */
    public Entity getCur(String k) { return entities.get(k); }
    
    @Override
    public Entity get(String k) throws SemanticException{
        Entity v = entities.get(k);
        if (v == null) { // cycle
            return this.parent.get(k);
        }
        return v;
    }

    /** may have same name in different scopes */
    @Override
    public void put(String k, Entity v) throws SemanticException{
        Entity check = entities.get(k);
        if (check != null) {
            throw new SemanticException();
        }
        entities.put(k, v);
    }
}