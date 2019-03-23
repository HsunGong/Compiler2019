package mxcompiler.utils.scope;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import mxcompiler.utils.entity.Entity;
import mxcompiler.exception.*;

abstract public class Scope {
	/** naive tree Node of Scope */
    protected List<LocalScope> children; 
	protected Scope parent;
    public Scope(Scope parent) {
        this.parent = parent;
        children = new ArrayList<LocalScope>();
    }
	public void addChild(LocalScope s) { children.add(s); }
	public Scope getParent() { return this.parent; }

	public boolean isToplevel() { return (parent == null); }
	abstract public ToplevelScope toplevel();
	

	// variables (for var, class, func, ...)
	// staticVar is included in entities
	// key is maybe : var, func, class; 
	protected Map<String, Entity> entities;
    abstract public void put(String k, Entity v) throws SemanticException; 
	abstract public Entity get(String k) throws SemanticException; // DeclNode or called Entity
	
	// FIX: update ??
	// FIX: assert have key
	// FIX: check - get/put/contain
}