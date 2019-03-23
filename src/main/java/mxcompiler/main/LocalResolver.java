package mxcompiler.main;

import java.util.LinkedList;
import mxcompiler.utils.scope.*;

public class LocalResolver {
	/** means can not change LinkedList's type */
	private final LinkedList<Scope> scopeStack;
	// private int isInLoop = 0;
	// private ClassTypeNode currentClass;
	// private FuncTypeNode currentFunc;
	// private static ToplevelScope toplevelScope;

	public LocalResolver() {
		scopeStack = new LinkedList<Scope>();
	}

	
	

}