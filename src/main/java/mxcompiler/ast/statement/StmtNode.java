package mxcompiler.ast.statement;

import mxcompiler.ast.Location;
import mxcompiler.ast.Node;

abstract public class StmtNode extends Node {
	public StmtNode(Location location) {
		super(location);
	}
	// location
}