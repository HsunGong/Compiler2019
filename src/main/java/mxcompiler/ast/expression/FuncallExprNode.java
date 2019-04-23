package mxcompiler.ast.expression;

import java.util.ArrayList;
import java.util.List;

import mxcompiler.ast.*;
import mxcompiler.utils.entity.FuncEntity;


/** Also for class method */
public class FuncallExprNode extends ExprNode {
	@Override
	public void _dump(ASTDump d) {
		d.printf("<FuncallExprNode> %s\n", location.toString());
	}

	private ExprNode expr;
	private List<ExprNode> params;

	// resolver
	public FuncEntity funcEntity;

	public FuncallExprNode(ExprNode e, List<ExprNode> params, Location location) {
		super(location);
		this.expr = e;
		if (params == null)
			this.params = new ArrayList<ExprNode>();
		else
			this.params = params;
	}

	public ExprNode getExpr() {
		return expr;
	}

	public List<ExprNode> getParam() {
		return params;
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}
}