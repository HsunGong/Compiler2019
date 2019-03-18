package mxcompiler.entity.scope;

import java.util.ArrayList;
import java.util.List;

import mxcompiler.entity.Entity;
import mxcompiler.exception.*;

abstract public class Scope {
    // have to be LocalScope due to the tree type
    public List<LocalScope> children; 
    protected Scope parent;

    
    public Scope(Scope parent) {
        // this.toplevel = toplevel;
        this.parent = parent;
        children = new ArrayList<LocalScope>();
    }
    
    public void addChild(LocalScope s) { children.add(s); }
    public Scope getParent() { return this.parent; }
    
    // private boolean toplevel;
    public boolean isToplevel() { return (parent == null); }
    abstract public ToplevelScope toplevel();
    
    // k - v, k is varName, v is entity
    abstract public void put(String k, Entity v) throws SemanticException; 
    abstract public Entity get(String k) throws SemanticException; // DeclNode or called Entity
}