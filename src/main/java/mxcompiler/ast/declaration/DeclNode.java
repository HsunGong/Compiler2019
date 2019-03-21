package mxcompiler.ast.declaration;


import mxcompiler.ast.*;

/** Normally seen as declare node 
 * FIX: however, in opinion, it should be put in entity
 * with entity
*/
abstract public class DeclNode extends Node {
    protected String name;

    public DeclNode(String name) { this.name = name; }

    // get name FIX: set name??
    public String getName() { return name; }

}