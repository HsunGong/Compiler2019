package mxcompiler.ast.expression.literal;

import mxcompiler.ast.expression.ExprNode;

import mxcompiler.ast.*;

public class StringLiteralExprNode extends ExprNode {
	@Override
	public void _dump(ASTDump d) {
		d.printf("<StringLiteralNode> %s\n", location.toString());
		d.printf(" value: %s\n", getValue());
	}

	private String value;

	public StringLiteralExprNode(String s, Location location) {
		super(location);
		this.value = solve(s);
	}

	/** used for solve escape sequence */ // ['"?abfnrtv\\]
	private String solve(String origin) {
		StringBuilder s = new StringBuilder();
		int len = origin.length();
		if (origin.charAt(0) != '\"' || origin.charAt(len-1) != '\"')
			throw new Error("no such escaped char");
		for (int i = 1; i < len-1; ++i) {
			if (i + 1 < origin.length() && origin.charAt(i) == '\\') {
				switch (origin.charAt(i + 1)) {
				case '\\':
					s.append('\\');
					break;
				case 'n':
					s.append('\n');
					break;
				case '\"':
					s.append('\"');
					break;
				case 't':
					s.append('\t');
					break;
				case 'b':
					s.append('\b');
					break;
				case 'f':
					s.append('\f');
					break;
				case 'r':
					s.append('\r');
					break;
				case '\'':
					s.append('\'');
					break;
				default:
					throw new Error("no such escaped char");
				}
				++i;
			} else {
				s.append(origin.charAt(i));
			}
		}
		return s.toString();
	}

	public String getValue() {
		return value;
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}
}