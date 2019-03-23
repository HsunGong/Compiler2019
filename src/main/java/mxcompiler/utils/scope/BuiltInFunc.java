package mxcompiler.utils.scope;

public enum BuiltInFunc{
	Array_Size("array.size"),
	Print("print"),
	Println("println"),
	GetString("getString"),
	GetInt("getInt"),
	ToString("toString"),
	String_Length("length"),
	String_Substring("substring"),
	String_ParseInt("parseInt"),
	String_Ord("ord");

	private String label;
	private BuiltInFunc(String label) {
		this.label = label;
	}

	public String toString() {
		return label;
	}
}