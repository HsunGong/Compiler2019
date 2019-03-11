// Generated from /home/xun/Documents/mxc/src/main/java/mxcompiler/parser/grammar/Mx.g4 by ANTLR 4.7.2
package mxcompiler.parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MxParser}.
 */
public interface MxListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MxParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryExpression(MxParser.PrimaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryExpression(MxParser.PrimaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code declarationSpecifier_array}
	 * labeled alternative in {@link MxParser#declarationSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterDeclarationSpecifier_array(MxParser.DeclarationSpecifier_arrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code declarationSpecifier_array}
	 * labeled alternative in {@link MxParser#declarationSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitDeclarationSpecifier_array(MxParser.DeclarationSpecifier_arrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code declarationSpecifier_type}
	 * labeled alternative in {@link MxParser#declarationSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterDeclarationSpecifier_type(MxParser.DeclarationSpecifier_typeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code declarationSpecifier_type}
	 * labeled alternative in {@link MxParser#declarationSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitDeclarationSpecifier_type(MxParser.DeclarationSpecifier_typeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code postfixExpression_inc}
	 * labeled alternative in {@link MxParser#postfixExpression}.
	 * @param ctx the parse tree
	 */
	void enterPostfixExpression_inc(MxParser.PostfixExpression_incContext ctx);
	/**
	 * Exit a parse tree produced by the {@code postfixExpression_inc}
	 * labeled alternative in {@link MxParser#postfixExpression}.
	 * @param ctx the parse tree
	 */
	void exitPostfixExpression_inc(MxParser.PostfixExpression_incContext ctx);
	/**
	 * Enter a parse tree produced by the {@code postfixExpression_func}
	 * labeled alternative in {@link MxParser#postfixExpression}.
	 * @param ctx the parse tree
	 */
	void enterPostfixExpression_func(MxParser.PostfixExpression_funcContext ctx);
	/**
	 * Exit a parse tree produced by the {@code postfixExpression_func}
	 * labeled alternative in {@link MxParser#postfixExpression}.
	 * @param ctx the parse tree
	 */
	void exitPostfixExpression_func(MxParser.PostfixExpression_funcContext ctx);
	/**
	 * Enter a parse tree produced by the {@code postfixExpression_class}
	 * labeled alternative in {@link MxParser#postfixExpression}.
	 * @param ctx the parse tree
	 */
	void enterPostfixExpression_class(MxParser.PostfixExpression_classContext ctx);
	/**
	 * Exit a parse tree produced by the {@code postfixExpression_class}
	 * labeled alternative in {@link MxParser#postfixExpression}.
	 * @param ctx the parse tree
	 */
	void exitPostfixExpression_class(MxParser.PostfixExpression_classContext ctx);
	/**
	 * Enter a parse tree produced by the {@code postfixExpression_primary}
	 * labeled alternative in {@link MxParser#postfixExpression}.
	 * @param ctx the parse tree
	 */
	void enterPostfixExpression_primary(MxParser.PostfixExpression_primaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code postfixExpression_primary}
	 * labeled alternative in {@link MxParser#postfixExpression}.
	 * @param ctx the parse tree
	 */
	void exitPostfixExpression_primary(MxParser.PostfixExpression_primaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code postfixExpression_dec}
	 * labeled alternative in {@link MxParser#postfixExpression}.
	 * @param ctx the parse tree
	 */
	void enterPostfixExpression_dec(MxParser.PostfixExpression_decContext ctx);
	/**
	 * Exit a parse tree produced by the {@code postfixExpression_dec}
	 * labeled alternative in {@link MxParser#postfixExpression}.
	 * @param ctx the parse tree
	 */
	void exitPostfixExpression_dec(MxParser.PostfixExpression_decContext ctx);
	/**
	 * Enter a parse tree produced by the {@code postfixExpression_array}
	 * labeled alternative in {@link MxParser#postfixExpression}.
	 * @param ctx the parse tree
	 */
	void enterPostfixExpression_array(MxParser.PostfixExpression_arrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code postfixExpression_array}
	 * labeled alternative in {@link MxParser#postfixExpression}.
	 * @param ctx the parse tree
	 */
	void exitPostfixExpression_array(MxParser.PostfixExpression_arrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code argumentExpressionList_single}
	 * labeled alternative in {@link MxParser#argumentExpressionList}.
	 * @param ctx the parse tree
	 */
	void enterArgumentExpressionList_single(MxParser.ArgumentExpressionList_singleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code argumentExpressionList_single}
	 * labeled alternative in {@link MxParser#argumentExpressionList}.
	 * @param ctx the parse tree
	 */
	void exitArgumentExpressionList_single(MxParser.ArgumentExpressionList_singleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code argumentExpressionList_multi}
	 * labeled alternative in {@link MxParser#argumentExpressionList}.
	 * @param ctx the parse tree
	 */
	void enterArgumentExpressionList_multi(MxParser.ArgumentExpressionList_multiContext ctx);
	/**
	 * Exit a parse tree produced by the {@code argumentExpressionList_multi}
	 * labeled alternative in {@link MxParser#argumentExpressionList}.
	 * @param ctx the parse tree
	 */
	void exitArgumentExpressionList_multi(MxParser.ArgumentExpressionList_multiContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryExpression_postfix}
	 * labeled alternative in {@link MxParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpression_postfix(MxParser.UnaryExpression_postfixContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryExpression_postfix}
	 * labeled alternative in {@link MxParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpression_postfix(MxParser.UnaryExpression_postfixContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryExpression_prefix_inc}
	 * labeled alternative in {@link MxParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpression_prefix_inc(MxParser.UnaryExpression_prefix_incContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryExpression_prefix_inc}
	 * labeled alternative in {@link MxParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpression_prefix_inc(MxParser.UnaryExpression_prefix_incContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryExpression_prefix_dec}
	 * labeled alternative in {@link MxParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpression_prefix_dec(MxParser.UnaryExpression_prefix_decContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryExpression_prefix_dec}
	 * labeled alternative in {@link MxParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpression_prefix_dec(MxParser.UnaryExpression_prefix_decContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryExpression_prefix}
	 * labeled alternative in {@link MxParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpression_prefix(MxParser.UnaryExpression_prefixContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryExpression_prefix}
	 * labeled alternative in {@link MxParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpression_prefix(MxParser.UnaryExpression_prefixContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#unaryOperator}.
	 * @param ctx the parse tree
	 */
	void enterUnaryOperator(MxParser.UnaryOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#unaryOperator}.
	 * @param ctx the parse tree
	 */
	void exitUnaryOperator(MxParser.UnaryOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#castExpression}.
	 * @param ctx the parse tree
	 */
	void enterCastExpression(MxParser.CastExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#castExpression}.
	 * @param ctx the parse tree
	 */
	void exitCastExpression(MxParser.CastExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multiplicativeExpression_unary}
	 * labeled alternative in {@link MxParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativeExpression_unary(MxParser.MultiplicativeExpression_unaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multiplicativeExpression_unary}
	 * labeled alternative in {@link MxParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativeExpression_unary(MxParser.MultiplicativeExpression_unaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multiplicativeExpression_mod}
	 * labeled alternative in {@link MxParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativeExpression_mod(MxParser.MultiplicativeExpression_modContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multiplicativeExpression_mod}
	 * labeled alternative in {@link MxParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativeExpression_mod(MxParser.MultiplicativeExpression_modContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multiplicativeExpression_div}
	 * labeled alternative in {@link MxParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativeExpression_div(MxParser.MultiplicativeExpression_divContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multiplicativeExpression_div}
	 * labeled alternative in {@link MxParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativeExpression_div(MxParser.MultiplicativeExpression_divContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multiplicativeExpression_mul}
	 * labeled alternative in {@link MxParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativeExpression_mul(MxParser.MultiplicativeExpression_mulContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multiplicativeExpression_mul}
	 * labeled alternative in {@link MxParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativeExpression_mul(MxParser.MultiplicativeExpression_mulContext ctx);
	/**
	 * Enter a parse tree produced by the {@code additiveExpression_sub}
	 * labeled alternative in {@link MxParser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpression_sub(MxParser.AdditiveExpression_subContext ctx);
	/**
	 * Exit a parse tree produced by the {@code additiveExpression_sub}
	 * labeled alternative in {@link MxParser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpression_sub(MxParser.AdditiveExpression_subContext ctx);
	/**
	 * Enter a parse tree produced by the {@code additiveExpression_add}
	 * labeled alternative in {@link MxParser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpression_add(MxParser.AdditiveExpression_addContext ctx);
	/**
	 * Exit a parse tree produced by the {@code additiveExpression_add}
	 * labeled alternative in {@link MxParser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpression_add(MxParser.AdditiveExpression_addContext ctx);
	/**
	 * Enter a parse tree produced by the {@code additiveExpression_unary}
	 * labeled alternative in {@link MxParser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpression_unary(MxParser.AdditiveExpression_unaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code additiveExpression_unary}
	 * labeled alternative in {@link MxParser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpression_unary(MxParser.AdditiveExpression_unaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code shiftExpression_shr}
	 * labeled alternative in {@link MxParser#shiftExpression}.
	 * @param ctx the parse tree
	 */
	void enterShiftExpression_shr(MxParser.ShiftExpression_shrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code shiftExpression_shr}
	 * labeled alternative in {@link MxParser#shiftExpression}.
	 * @param ctx the parse tree
	 */
	void exitShiftExpression_shr(MxParser.ShiftExpression_shrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code shiftExpression_unary}
	 * labeled alternative in {@link MxParser#shiftExpression}.
	 * @param ctx the parse tree
	 */
	void enterShiftExpression_unary(MxParser.ShiftExpression_unaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code shiftExpression_unary}
	 * labeled alternative in {@link MxParser#shiftExpression}.
	 * @param ctx the parse tree
	 */
	void exitShiftExpression_unary(MxParser.ShiftExpression_unaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code shiftExpression_shl}
	 * labeled alternative in {@link MxParser#shiftExpression}.
	 * @param ctx the parse tree
	 */
	void enterShiftExpression_shl(MxParser.ShiftExpression_shlContext ctx);
	/**
	 * Exit a parse tree produced by the {@code shiftExpression_shl}
	 * labeled alternative in {@link MxParser#shiftExpression}.
	 * @param ctx the parse tree
	 */
	void exitShiftExpression_shl(MxParser.ShiftExpression_shlContext ctx);
	/**
	 * Enter a parse tree produced by the {@code relationalExpression_ge}
	 * labeled alternative in {@link MxParser#relationalExpression}.
	 * @param ctx the parse tree
	 */
	void enterRelationalExpression_ge(MxParser.RelationalExpression_geContext ctx);
	/**
	 * Exit a parse tree produced by the {@code relationalExpression_ge}
	 * labeled alternative in {@link MxParser#relationalExpression}.
	 * @param ctx the parse tree
	 */
	void exitRelationalExpression_ge(MxParser.RelationalExpression_geContext ctx);
	/**
	 * Enter a parse tree produced by the {@code relationalExpression_unary}
	 * labeled alternative in {@link MxParser#relationalExpression}.
	 * @param ctx the parse tree
	 */
	void enterRelationalExpression_unary(MxParser.RelationalExpression_unaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code relationalExpression_unary}
	 * labeled alternative in {@link MxParser#relationalExpression}.
	 * @param ctx the parse tree
	 */
	void exitRelationalExpression_unary(MxParser.RelationalExpression_unaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code relationalExpression_geq}
	 * labeled alternative in {@link MxParser#relationalExpression}.
	 * @param ctx the parse tree
	 */
	void enterRelationalExpression_geq(MxParser.RelationalExpression_geqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code relationalExpression_geq}
	 * labeled alternative in {@link MxParser#relationalExpression}.
	 * @param ctx the parse tree
	 */
	void exitRelationalExpression_geq(MxParser.RelationalExpression_geqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code relationalExpression_le}
	 * labeled alternative in {@link MxParser#relationalExpression}.
	 * @param ctx the parse tree
	 */
	void enterRelationalExpression_le(MxParser.RelationalExpression_leContext ctx);
	/**
	 * Exit a parse tree produced by the {@code relationalExpression_le}
	 * labeled alternative in {@link MxParser#relationalExpression}.
	 * @param ctx the parse tree
	 */
	void exitRelationalExpression_le(MxParser.RelationalExpression_leContext ctx);
	/**
	 * Enter a parse tree produced by the {@code relationalExpression_leq}
	 * labeled alternative in {@link MxParser#relationalExpression}.
	 * @param ctx the parse tree
	 */
	void enterRelationalExpression_leq(MxParser.RelationalExpression_leqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code relationalExpression_leq}
	 * labeled alternative in {@link MxParser#relationalExpression}.
	 * @param ctx the parse tree
	 */
	void exitRelationalExpression_leq(MxParser.RelationalExpression_leqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code equalityExpression_unary}
	 * labeled alternative in {@link MxParser#equalityExpression}.
	 * @param ctx the parse tree
	 */
	void enterEqualityExpression_unary(MxParser.EqualityExpression_unaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code equalityExpression_unary}
	 * labeled alternative in {@link MxParser#equalityExpression}.
	 * @param ctx the parse tree
	 */
	void exitEqualityExpression_unary(MxParser.EqualityExpression_unaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code equalityExpression_equal}
	 * labeled alternative in {@link MxParser#equalityExpression}.
	 * @param ctx the parse tree
	 */
	void enterEqualityExpression_equal(MxParser.EqualityExpression_equalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code equalityExpression_equal}
	 * labeled alternative in {@link MxParser#equalityExpression}.
	 * @param ctx the parse tree
	 */
	void exitEqualityExpression_equal(MxParser.EqualityExpression_equalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code equalityExpression_inequal}
	 * labeled alternative in {@link MxParser#equalityExpression}.
	 * @param ctx the parse tree
	 */
	void enterEqualityExpression_inequal(MxParser.EqualityExpression_inequalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code equalityExpression_inequal}
	 * labeled alternative in {@link MxParser#equalityExpression}.
	 * @param ctx the parse tree
	 */
	void exitEqualityExpression_inequal(MxParser.EqualityExpression_inequalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andExpression_unary}
	 * labeled alternative in {@link MxParser#andExpression}.
	 * @param ctx the parse tree
	 */
	void enterAndExpression_unary(MxParser.AndExpression_unaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andExpression_unary}
	 * labeled alternative in {@link MxParser#andExpression}.
	 * @param ctx the parse tree
	 */
	void exitAndExpression_unary(MxParser.AndExpression_unaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andExpression_binary}
	 * labeled alternative in {@link MxParser#andExpression}.
	 * @param ctx the parse tree
	 */
	void enterAndExpression_binary(MxParser.AndExpression_binaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andExpression_binary}
	 * labeled alternative in {@link MxParser#andExpression}.
	 * @param ctx the parse tree
	 */
	void exitAndExpression_binary(MxParser.AndExpression_binaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exclusiveOrExpression_unary}
	 * labeled alternative in {@link MxParser#exclusiveOrExpression}.
	 * @param ctx the parse tree
	 */
	void enterExclusiveOrExpression_unary(MxParser.ExclusiveOrExpression_unaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exclusiveOrExpression_unary}
	 * labeled alternative in {@link MxParser#exclusiveOrExpression}.
	 * @param ctx the parse tree
	 */
	void exitExclusiveOrExpression_unary(MxParser.ExclusiveOrExpression_unaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exclusiveOrExpression_binary}
	 * labeled alternative in {@link MxParser#exclusiveOrExpression}.
	 * @param ctx the parse tree
	 */
	void enterExclusiveOrExpression_binary(MxParser.ExclusiveOrExpression_binaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exclusiveOrExpression_binary}
	 * labeled alternative in {@link MxParser#exclusiveOrExpression}.
	 * @param ctx the parse tree
	 */
	void exitExclusiveOrExpression_binary(MxParser.ExclusiveOrExpression_binaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code inclusiveOrExpression_binary}
	 * labeled alternative in {@link MxParser#inclusiveOrExpression}.
	 * @param ctx the parse tree
	 */
	void enterInclusiveOrExpression_binary(MxParser.InclusiveOrExpression_binaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code inclusiveOrExpression_binary}
	 * labeled alternative in {@link MxParser#inclusiveOrExpression}.
	 * @param ctx the parse tree
	 */
	void exitInclusiveOrExpression_binary(MxParser.InclusiveOrExpression_binaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code inclusiveOrExpression_unary}
	 * labeled alternative in {@link MxParser#inclusiveOrExpression}.
	 * @param ctx the parse tree
	 */
	void enterInclusiveOrExpression_unary(MxParser.InclusiveOrExpression_unaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code inclusiveOrExpression_unary}
	 * labeled alternative in {@link MxParser#inclusiveOrExpression}.
	 * @param ctx the parse tree
	 */
	void exitInclusiveOrExpression_unary(MxParser.InclusiveOrExpression_unaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code logicalAndExpression_unary}
	 * labeled alternative in {@link MxParser#logicalAndExpression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalAndExpression_unary(MxParser.LogicalAndExpression_unaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logicalAndExpression_unary}
	 * labeled alternative in {@link MxParser#logicalAndExpression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalAndExpression_unary(MxParser.LogicalAndExpression_unaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code logicalAndExpression_binary}
	 * labeled alternative in {@link MxParser#logicalAndExpression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalAndExpression_binary(MxParser.LogicalAndExpression_binaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logicalAndExpression_binary}
	 * labeled alternative in {@link MxParser#logicalAndExpression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalAndExpression_binary(MxParser.LogicalAndExpression_binaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code logicalOrExpression_binary}
	 * labeled alternative in {@link MxParser#logicalOrExpression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalOrExpression_binary(MxParser.LogicalOrExpression_binaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logicalOrExpression_binary}
	 * labeled alternative in {@link MxParser#logicalOrExpression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalOrExpression_binary(MxParser.LogicalOrExpression_binaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code logicalOrExpression_unary}
	 * labeled alternative in {@link MxParser#logicalOrExpression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalOrExpression_unary(MxParser.LogicalOrExpression_unaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logicalOrExpression_unary}
	 * labeled alternative in {@link MxParser#logicalOrExpression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalOrExpression_unary(MxParser.LogicalOrExpression_unaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(MxParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(MxParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code declaration_init}
	 * labeled alternative in {@link MxParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration_init(MxParser.Declaration_initContext ctx);
	/**
	 * Exit a parse tree produced by the {@code declaration_init}
	 * labeled alternative in {@link MxParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration_init(MxParser.Declaration_initContext ctx);
	/**
	 * Enter a parse tree produced by the {@code declaration_none}
	 * labeled alternative in {@link MxParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration_none(MxParser.Declaration_noneContext ctx);
	/**
	 * Exit a parse tree produced by the {@code declaration_none}
	 * labeled alternative in {@link MxParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration_none(MxParser.Declaration_noneContext ctx);
	/**
	 * Enter a parse tree produced by the {@code initDeclaratorList_single}
	 * labeled alternative in {@link MxParser#initDeclaratorList}.
	 * @param ctx the parse tree
	 */
	void enterInitDeclaratorList_single(MxParser.InitDeclaratorList_singleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code initDeclaratorList_single}
	 * labeled alternative in {@link MxParser#initDeclaratorList}.
	 * @param ctx the parse tree
	 */
	void exitInitDeclaratorList_single(MxParser.InitDeclaratorList_singleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code initDeclaratorList_multi}
	 * labeled alternative in {@link MxParser#initDeclaratorList}.
	 * @param ctx the parse tree
	 */
	void enterInitDeclaratorList_multi(MxParser.InitDeclaratorList_multiContext ctx);
	/**
	 * Exit a parse tree produced by the {@code initDeclaratorList_multi}
	 * labeled alternative in {@link MxParser#initDeclaratorList}.
	 * @param ctx the parse tree
	 */
	void exitInitDeclaratorList_multi(MxParser.InitDeclaratorList_multiContext ctx);
	/**
	 * Enter a parse tree produced by the {@code initDeclarator_none}
	 * labeled alternative in {@link MxParser#initDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterInitDeclarator_none(MxParser.InitDeclarator_noneContext ctx);
	/**
	 * Exit a parse tree produced by the {@code initDeclarator_none}
	 * labeled alternative in {@link MxParser#initDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitInitDeclarator_none(MxParser.InitDeclarator_noneContext ctx);
	/**
	 * Enter a parse tree produced by the {@code initDeclarator_init}
	 * labeled alternative in {@link MxParser#initDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterInitDeclarator_init(MxParser.InitDeclarator_initContext ctx);
	/**
	 * Exit a parse tree produced by the {@code initDeclarator_init}
	 * labeled alternative in {@link MxParser#initDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitInitDeclarator_init(MxParser.InitDeclarator_initContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#typeSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterTypeSpecifier(MxParser.TypeSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#typeSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitTypeSpecifier(MxParser.TypeSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code newDeclarator_error}
	 * labeled alternative in {@link MxParser#newDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterNewDeclarator_error(MxParser.NewDeclarator_errorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newDeclarator_error}
	 * labeled alternative in {@link MxParser#newDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitNewDeclarator_error(MxParser.NewDeclarator_errorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code newDeclarator_array}
	 * labeled alternative in {@link MxParser#newDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterNewDeclarator_array(MxParser.NewDeclarator_arrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newDeclarator_array}
	 * labeled alternative in {@link MxParser#newDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitNewDeclarator_array(MxParser.NewDeclarator_arrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code newDeclarator_nonarray}
	 * labeled alternative in {@link MxParser#newDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterNewDeclarator_nonarray(MxParser.NewDeclarator_nonarrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newDeclarator_nonarray}
	 * labeled alternative in {@link MxParser#newDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitNewDeclarator_nonarray(MxParser.NewDeclarator_nonarrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code directDeclarator_Identifier}
	 * labeled alternative in {@link MxParser#directDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterDirectDeclarator_Identifier(MxParser.DirectDeclarator_IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by the {@code directDeclarator_Identifier}
	 * labeled alternative in {@link MxParser#directDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitDirectDeclarator_Identifier(MxParser.DirectDeclarator_IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code directDeclarator_with_parameterList}
	 * labeled alternative in {@link MxParser#directDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterDirectDeclarator_with_parameterList(MxParser.DirectDeclarator_with_parameterListContext ctx);
	/**
	 * Exit a parse tree produced by the {@code directDeclarator_with_parameterList}
	 * labeled alternative in {@link MxParser#directDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitDirectDeclarator_with_parameterList(MxParser.DirectDeclarator_with_parameterListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code directDeclarator_recycle}
	 * labeled alternative in {@link MxParser#directDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterDirectDeclarator_recycle(MxParser.DirectDeclarator_recycleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code directDeclarator_recycle}
	 * labeled alternative in {@link MxParser#directDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitDirectDeclarator_recycle(MxParser.DirectDeclarator_recycleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parameterList_multi}
	 * labeled alternative in {@link MxParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void enterParameterList_multi(MxParser.ParameterList_multiContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parameterList_multi}
	 * labeled alternative in {@link MxParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void exitParameterList_multi(MxParser.ParameterList_multiContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parameterList_single}
	 * labeled alternative in {@link MxParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void enterParameterList_single(MxParser.ParameterList_singleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parameterList_single}
	 * labeled alternative in {@link MxParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void exitParameterList_single(MxParser.ParameterList_singleContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#parameterDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterParameterDeclaration(MxParser.ParameterDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#parameterDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitParameterDeclaration(MxParser.ParameterDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#typedefName}.
	 * @param ctx the parse tree
	 */
	void enterTypedefName(MxParser.TypedefNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#typedefName}.
	 * @param ctx the parse tree
	 */
	void exitTypedefName(MxParser.TypedefNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(MxParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(MxParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#compoundStatement}.
	 * @param ctx the parse tree
	 */
	void enterCompoundStatement(MxParser.CompoundStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#compoundStatement}.
	 * @param ctx the parse tree
	 */
	void exitCompoundStatement(MxParser.CompoundStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#blockItem}.
	 * @param ctx the parse tree
	 */
	void enterBlockItem(MxParser.BlockItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#blockItem}.
	 * @param ctx the parse tree
	 */
	void exitBlockItem(MxParser.BlockItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void enterExpressionStatement(MxParser.ExpressionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void exitExpressionStatement(MxParser.ExpressionStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#selectionStatement}.
	 * @param ctx the parse tree
	 */
	void enterSelectionStatement(MxParser.SelectionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#selectionStatement}.
	 * @param ctx the parse tree
	 */
	void exitSelectionStatement(MxParser.SelectionStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code iterationStatement_while}
	 * labeled alternative in {@link MxParser#iterationStatement}.
	 * @param ctx the parse tree
	 */
	void enterIterationStatement_while(MxParser.IterationStatement_whileContext ctx);
	/**
	 * Exit a parse tree produced by the {@code iterationStatement_while}
	 * labeled alternative in {@link MxParser#iterationStatement}.
	 * @param ctx the parse tree
	 */
	void exitIterationStatement_while(MxParser.IterationStatement_whileContext ctx);
	/**
	 * Enter a parse tree produced by the {@code iterationStatement_for}
	 * labeled alternative in {@link MxParser#iterationStatement}.
	 * @param ctx the parse tree
	 */
	void enterIterationStatement_for(MxParser.IterationStatement_forContext ctx);
	/**
	 * Exit a parse tree produced by the {@code iterationStatement_for}
	 * labeled alternative in {@link MxParser#iterationStatement}.
	 * @param ctx the parse tree
	 */
	void exitIterationStatement_for(MxParser.IterationStatement_forContext ctx);
	/**
	 * Enter a parse tree produced by the {@code forCondition_init}
	 * labeled alternative in {@link MxParser#forCondition}.
	 * @param ctx the parse tree
	 */
	void enterForCondition_init(MxParser.ForCondition_initContext ctx);
	/**
	 * Exit a parse tree produced by the {@code forCondition_init}
	 * labeled alternative in {@link MxParser#forCondition}.
	 * @param ctx the parse tree
	 */
	void exitForCondition_init(MxParser.ForCondition_initContext ctx);
	/**
	 * Enter a parse tree produced by the {@code forCondition_none}
	 * labeled alternative in {@link MxParser#forCondition}.
	 * @param ctx the parse tree
	 */
	void enterForCondition_none(MxParser.ForCondition_noneContext ctx);
	/**
	 * Exit a parse tree produced by the {@code forCondition_none}
	 * labeled alternative in {@link MxParser#forCondition}.
	 * @param ctx the parse tree
	 */
	void exitForCondition_none(MxParser.ForCondition_noneContext ctx);
	/**
	 * Enter a parse tree produced by the {@code forDeclaration_init}
	 * labeled alternative in {@link MxParser#forDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterForDeclaration_init(MxParser.ForDeclaration_initContext ctx);
	/**
	 * Exit a parse tree produced by the {@code forDeclaration_init}
	 * labeled alternative in {@link MxParser#forDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitForDeclaration_init(MxParser.ForDeclaration_initContext ctx);
	/**
	 * Enter a parse tree produced by the {@code forDeclaration_none}
	 * labeled alternative in {@link MxParser#forDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterForDeclaration_none(MxParser.ForDeclaration_noneContext ctx);
	/**
	 * Exit a parse tree produced by the {@code forDeclaration_none}
	 * labeled alternative in {@link MxParser#forDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitForDeclaration_none(MxParser.ForDeclaration_noneContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#forExprEnd}.
	 * @param ctx the parse tree
	 */
	void enterForExprEnd(MxParser.ForExprEndContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#forExprEnd}.
	 * @param ctx the parse tree
	 */
	void exitForExprEnd(MxParser.ForExprEndContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#forExprUpdate}.
	 * @param ctx the parse tree
	 */
	void enterForExprUpdate(MxParser.ForExprUpdateContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#forExprUpdate}.
	 * @param ctx the parse tree
	 */
	void exitForExprUpdate(MxParser.ForExprUpdateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code jumpStatement_continue}
	 * labeled alternative in {@link MxParser#jumpStatement}.
	 * @param ctx the parse tree
	 */
	void enterJumpStatement_continue(MxParser.JumpStatement_continueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code jumpStatement_continue}
	 * labeled alternative in {@link MxParser#jumpStatement}.
	 * @param ctx the parse tree
	 */
	void exitJumpStatement_continue(MxParser.JumpStatement_continueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code jumpStatement_break}
	 * labeled alternative in {@link MxParser#jumpStatement}.
	 * @param ctx the parse tree
	 */
	void enterJumpStatement_break(MxParser.JumpStatement_breakContext ctx);
	/**
	 * Exit a parse tree produced by the {@code jumpStatement_break}
	 * labeled alternative in {@link MxParser#jumpStatement}.
	 * @param ctx the parse tree
	 */
	void exitJumpStatement_break(MxParser.JumpStatement_breakContext ctx);
	/**
	 * Enter a parse tree produced by the {@code jumpStatement_return}
	 * labeled alternative in {@link MxParser#jumpStatement}.
	 * @param ctx the parse tree
	 */
	void enterJumpStatement_return(MxParser.JumpStatement_returnContext ctx);
	/**
	 * Exit a parse tree produced by the {@code jumpStatement_return}
	 * labeled alternative in {@link MxParser#jumpStatement}.
	 * @param ctx the parse tree
	 */
	void exitJumpStatement_return(MxParser.JumpStatement_returnContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(MxParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(MxParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#programDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterProgramDeclaration(MxParser.ProgramDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#programDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitProgramDeclaration(MxParser.ProgramDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#functionDefinition}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDefinition(MxParser.FunctionDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#functionDefinition}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDefinition(MxParser.FunctionDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code classDeclaration_decl}
	 * labeled alternative in {@link MxParser#classDefinition}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclaration_decl(MxParser.ClassDeclaration_declContext ctx);
	/**
	 * Exit a parse tree produced by the {@code classDeclaration_decl}
	 * labeled alternative in {@link MxParser#classDefinition}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclaration_decl(MxParser.ClassDeclaration_declContext ctx);
	/**
	 * Enter a parse tree produced by the {@code classDeclaration_none}
	 * labeled alternative in {@link MxParser#classDefinition}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclaration_none(MxParser.ClassDeclaration_noneContext ctx);
	/**
	 * Exit a parse tree produced by the {@code classDeclaration_none}
	 * labeled alternative in {@link MxParser#classDefinition}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclaration_none(MxParser.ClassDeclaration_noneContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclaration(MxParser.ClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclaration(MxParser.ClassDeclarationContext ctx);
}