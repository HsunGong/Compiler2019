package mxcompiler.utils.scope;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import mxcompiler.utils.Dump;
import mxcompiler.utils.entity.Entity;
import mxcompiler.error.*;

import mxcompiler.utils.Tool;


abstract public class Scope {
	/**
	 * reserved name of class FIX: maybe also builtIn Func?
	 */
	public enum BuiltIn {
		// acc, array is not a class type
		ARRAY(Tool.ARRAY), STRING(Tool.STRING), THIS(Tool.THIS), DOMAIN(Tool.DOMAIN);

		private String label;

		private BuiltIn(String label) {
			this.label = label;
		}

		public String toString() {
			return label;
		}

		public String toDomain() {
			return label + DOMAIN.toString();
		}

		private static final HashMap<String, BuiltIn> keyMap = new HashMap<String, BuiltIn>();
		static {
			for (BuiltIn op : BuiltIn.values()) {
				keyMap.put(op.label, op);
			}
		}

		public static BuiltIn get(String key) {
			return keyMap.get(key);
		}
	}

	/** naive tree Node of Scope */
	protected List<LocalScope> children;
	protected Scope parent;

	public Scope(Scope parent) {
		this.parent = parent;
		children = new ArrayList<LocalScope>();
	}

	public void addChild(LocalScope s) {
		children.add(s);
	}

	public Scope getParent() {
		return this.parent;
	}

	public boolean isToplevel() {
		return (parent == null);
	}

	abstract public ToplevelScope toplevel();

	// variables (for var, class, func, ...)
	// staticVar is included in entities
	// key is maybe : var, func, class;
	protected Map<String, Entity> entities;

	abstract public void put(String k, Entity v) throws SemanticError;
	
	/**  
	 * no throw for get, if not exist, return null
	 */
	abstract public Entity get(String k) throws SemanticError; 

	/**
	 * no throw for get, if not exist, return null
	 */
	abstract public Entity getVarFun(String k, String domain) throws SemanticError;
	
	public final void _dump(Dump d) {
		d.printf("Scope: isTop: %b\n", isToplevel());
		for (Entry<String, Entity> e : entities.entrySet()) {
			e.getValue()._dump(d);
		}
		// FIX: what is children to specify which function is their
		// father?
		for (Scope s : this.children) {
			// d.addTab();
			d.print(">>>> child");
			s._dump(d);
			// d.delTab();
		}
	}
}