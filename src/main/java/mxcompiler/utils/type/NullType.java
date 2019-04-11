package mxcompiler.utils.type;

/** UGLY: may change in {@link mxcompiler.main.ASTBuilder} visitLiteral
 * Specailly for class construct function 
 * NOTE: may use it in ScopeScanner and functionEntity
 */
public class NullType extends Type {
    public NullType() {
		super(Type.InnerType.NULL);
    }
}