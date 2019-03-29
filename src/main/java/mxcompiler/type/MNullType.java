package mxcompiler.type;

/**
 * UGLY: MNullType to specify from NullType(which may be returnType) MNull means
 * "null", but Null means ""
 */
public class MNullType extends Type {
  public MNullType() {
    super(Type.InnerType.NULL);
  }
}