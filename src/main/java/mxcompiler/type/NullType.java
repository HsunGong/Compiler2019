package mxcompiler.type;

/** FIX: may change ASTBuilder
 * Specailly for class construct function 
 */
public class NullType extends Type {
    public NullType() {
		super(Type.InnerType.NULL);
    }
}