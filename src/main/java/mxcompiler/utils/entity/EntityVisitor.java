package mxcompiler.utils.entity;

public interface EntityVisitor {
	public void visit(Entity entity);
	public void visit(ClassEntity entity);
	public void visit(FuncEntity entity);
	public void visit(VarEntity entity);
}