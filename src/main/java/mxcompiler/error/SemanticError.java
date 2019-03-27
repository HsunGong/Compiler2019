package mxcompiler.error;

public class SemanticError extends Error {
	public SemanticError(){}
	public SemanticError(String msg){
		super(msg);
	}
}