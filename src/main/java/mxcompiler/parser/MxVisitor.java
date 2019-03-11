// Generated from /home/xun/Documents/mxc/src/main/java/mxcompiler/parser/grammar/Mx.g4 by ANTLR 4.7.2
package mxcompiler.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MxParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MxVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MxParser#primaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryExpression(MxParser.PrimaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code declarationSpecifier_array}
	 * labeled alternative in {@link MxParser#declarationSpecifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarationSpecifier_array(MxParser.DeclarationSpecifier_arrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code declarationSpecifier_type}
	 * labeled alternative in {@link MxParser#declarationSpecifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarationSpecifier_type(MxParser.DeclarationSpecifier_typeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code postfixExpression_inc}
	 * labeled alternative in {@link MxParser#postfixExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfixExpression_inc(MxParser.PostfixExpression_incContext ctx);
	/**
	 * Visit a parse tree produced by the {@code postfixExpression_func}
	 * labeled alternative in {@link MxParser#postfixExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfixExpression_func(MxParser.PostfixExpression_funcContext ctx);
	/**
	 * Visit a parse tree produced by the {@code postfixExpression_class}
	 * labeled alternative in {@link MxParser#postfixExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfixExpression_class(MxParser.PostfixExpression_classContext ctx);
	/**
	 * Visit a parse tree produced by the {@code postfixExpression_primary}
	 * labeled alternative in {@link MxParser#postfixExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfixExpression_primary(MxParser.PostfixExpression_primaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code postfixExpression_dec}
	 * labeled alternative in {@link MxParser#postfixExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfixExpression_dec(MxParser.PostfixExpression_decContext ctx);
	/**
	 * Visit a parse tree produced by the {@code postfixExpression_array}
	 * labeled alternative in {@link MxParser#postfixExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfixExpression_array(MxParser.PostfixExpression_arrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code argumentExpressionList_single}
	 * labeled alternative in {@link MxParser#argumentExpressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentExpressionList_single(MxParser.ArgumentExpressionList_singleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code argumentExpressionList_multi}
	 * labeled alternative in {@link MxParser#argumentExpressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentExpressionList_multi(MxParser.ArgumentExpressionList_multiContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unaryExpression_postfix}
	 * labeled alternative in {@link MxParser#unaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpression_postfix(MxParser.UnaryExpression_postfixContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unaryExpression_prefix_inc}
	 * labeled alternative in {@link MxParser#unaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpression_prefix_inc(MxParser.UnaryExpression_prefix_incContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unaryExpression_prefix_dec}
	 * labeled alternative in {@link MxParser#unaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpression_prefix_dec(MxParser.UnaryExpression_prefix_decContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unaryExpression_prefix}
	 * labeled alternative in {@link MxParser#unaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpression_prefix(MxParser.UnaryExpression_prefixContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#unaryOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryOperator(MxParser.UnaryOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#castExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCastExpression(MxParser.CastExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multiplicativeExpression_unary}
	 * labeled alternative in {@link MxParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicativeExpression_unary(MxParser.MultiplicativeExpression_unaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multiplicativeExpression_mod}
	 * labeled alternative in {@link MxParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicativeExpression_mod(MxParser.MultiplicativeExpression_modContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multiplicativeExpression_div}
	 * labeled alternative in {@link MxParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicativeExpression_div(MxParser.MultiplicativeExpression_divContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multiplicativeExpression_mul}
	 * labeled alternative in {@link MxParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicativeExpression_mul(MxParser.MultiplicativeExpression_mulContext ctx);
	/**
	 * Visit a parse tree produced by the {@code additiveExpression_sub}
	 * labeled alternative in {@link MxParser#additiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveExpression_sub(MxParser.AdditiveExpression_subContext ctx);
	/**
	 * Visit a parse tree produced by the {@code additiveExpression_add}
	 * labeled alternative in {@link MxParser#additiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveExpression_add(MxParser.AdditiveExpression_addContext ctx);
	/**
	 * Visit a parse tree produced by the {@code additiveExpression_unary}
	 * labeled alternative in {@link MxParser#additiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveExpression_unary(MxParser.AdditiveExpression_unaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code shiftExpression_shr}
	 * labeled alternative in {@link MxParser#shiftExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShiftExpression_shr(MxParser.ShiftExpression_shrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code shiftExpression_unary}
	 * labeled alternative in {@link MxParser#shiftExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShiftExpression_unary(MxParser.ShiftExpression_unaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code shiftExpression_shl}
	 * labeled alternative in {@link MxParser#shiftExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShiftExpression_shl(MxParser.ShiftExpression_shlContext ctx);
	/**
	 * Visit a parse tree produced by the {@code relationalExpression_ge}
	 * labeled alternative in {@link MxParser#relationalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalExpression_ge(MxParser.RelationalExpression_geContext ctx);
	/**
	 * Visit a parse tree produced by the {@code relationalExpression_unary}
	 * labeled alternative in {@link MxParser#relationalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalExpression_unary(MxParser.RelationalExpression_unaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code relationalExpression_geq}
	 * labeled alternative in {@link MxParser#relationalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalExpression_geq(MxParser.RelationalExpression_geqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code relationalExpression_le}
	 * labeled alternative in {@link MxParser#relationalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalExpression_le(MxParser.RelationalExpression_leContext ctx);
	/**
	 * Visit a parse tree produced by the {@code relationalExpression_leq}
	 * labeled alternative in {@link MxParser#relationalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalExpression_leq(MxParser.RelationalExpression_leqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code equalityExpression_unary}
	 * labeled alternative in {@link MxParser#equalityExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityExpression_unary(MxParser.EqualityExpression_unaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code equalityExpression_equal}
	 * labeled alternative in {@link MxParser#equalityExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityExpression_equal(MxParser.EqualityExpression_equalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code equalityExpression_inequal}
	 * labeled alternative in {@link MxParser#equalityExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityExpression_inequal(MxParser.EqualityExpression_inequalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code andExpression_unary}
	 * labeled alternative in {@link MxParser#andExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpression_unary(MxParser.AndExpression_unaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code andExpression_binary}
	 * labeled alternative in {@link MxParser#andExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpression_binary(MxParser.AndExpression_binaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exclusiveOrExpression_unary}
	 * labeled alternative in {@link MxParser#exclusiveOrExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExclusiveOrExpression_unary(MxParser.ExclusiveOrExpression_unaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exclusiveOrExpression_binary}
	 * labeled alternative in {@link MxParser#exclusiveOrExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExclusiveOrExpression_binary(MxParser.ExclusiveOrExpression_binaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code inclusiveOrExpression_binary}
	 * labeled alternative in {@link MxParser#inclusiveOrExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInclusiveOrExpression_binary(MxParser.InclusiveOrExpression_binaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code inclusiveOrExpression_unary}
	 * labeled alternative in {@link MxParser#inclusiveOrExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInclusiveOrExpression_unary(MxParser.InclusiveOrExpression_unaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code logicalAndExpression_unary}
	 * labeled alternative in {@link MxParser#logicalAndExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalAndExpression_unary(MxParser.LogicalAndExpression_unaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code logicalAndExpression_binary}
	 * labeled alternative in {@link MxParser#logicalAndExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalAndExpression_binary(MxParser.LogicalAndExpression_binaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code logicalOrExpression_binary}
	 * labeled alternative in {@link MxParser#logicalOrExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalOrExpression_binary(MxParser.LogicalOrExpression_binaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code logicalOrExpression_unary}
	 * labeled alternative in {@link MxParser#logicalOrExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalOrExpression_unary(MxParser.LogicalOrExpression_unaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(MxParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code declaration_init}
	 * labeled alternative in {@link MxParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration_init(MxParser.Declaration_initContext ctx);
	/**
	 * Visit a parse tree produced by the {@code declaration_none}
	 * labeled alternative in {@link MxParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration_none(MxParser.Declaration_noneContext ctx);
	/**
	 * Visit a parse tree produced by the {@code initDeclaratorList_single}
	 * labeled alternative in {@link MxParser#initDeclaratorList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitDeclaratorList_single(MxParser.InitDeclaratorList_singleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code initDeclaratorList_multi}
	 * labeled alternative in {@link MxParser#initDeclaratorList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitDeclaratorList_multi(MxParser.InitDeclaratorList_multiContext ctx);
	/**
	 * Visit a parse tree produced by the {@code initDeclarator_none}
	 * labeled alternative in {@link MxParser#initDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitDeclarator_none(MxParser.InitDeclarator_noneContext ctx);
	/**
	 * Visit a parse tree produced by the {@code initDeclarator_init}
	 * labeled alternative in {@link MxParser#initDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitDeclarator_init(MxParser.InitDeclarator_initContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#typeSpecifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeSpecifier(MxParser.TypeSpecifierContext ctx);
	/**
	 * Visit a parse tree produced by the {@code newDeclarator_error}
	 * labeled alternative in {@link MxParser#newDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewDeclarator_error(MxParser.NewDeclarator_errorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code newDeclarator_array}
	 * labeled alternative in {@link MxParser#newDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewDeclarator_array(MxParser.NewDeclarator_arrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code newDeclarator_nonarray}
	 * labeled alternative in {@link MxParser#newDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewDeclarator_nonarray(MxParser.NewDeclarator_nonarrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code directDeclarator_Identifier}
	 * labeled alternative in {@link MxParser#directDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDirectDeclarator_Identifier(MxParser.DirectDeclarator_IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by the {@code directDeclarator_with_parameterList}
	 * labeled alternative in {@link MxParser#directDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDirectDeclarator_with_parameterList(MxParser.DirectDeclarator_with_parameterListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code directDeclarator_recycle}
	 * labeled alternative in {@link MxParser#directDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDirectDeclarator_recycle(MxParser.DirectDeclarator_recycleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parameterList_multi}
	 * labeled alternative in {@link MxParser#parameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterList_multi(MxParser.ParameterList_multiContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parameterList_single}
	 * labeled alternative in {@link MxParser#parameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterList_single(MxParser.ParameterList_singleContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#parameterDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterDeclaration(MxParser.ParameterDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#typedefName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypedefName(MxParser.TypedefNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(MxParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#compoundStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompoundStatement(MxParser.CompoundStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#blockItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockItem(MxParser.BlockItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#expressionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionStatement(MxParser.ExpressionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#selectionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectionStatement(MxParser.SelectionStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code iterationStatement_while}
	 * labeled alternative in {@link MxParser#iterationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIterationStatement_while(MxParser.IterationStatement_whileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code iterationStatement_for}
	 * labeled alternative in {@link MxParser#iterationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIterationStatement_for(MxParser.IterationStatement_forContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forCondition_init}
	 * labeled alternative in {@link MxParser#forCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForCondition_init(MxParser.ForCondition_initContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forCondition_none}
	 * labeled alternative in {@link MxParser#forCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForCondition_none(MxParser.ForCondition_noneContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forDeclaration_init}
	 * labeled alternative in {@link MxParser#forDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForDeclaration_init(MxParser.ForDeclaration_initContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forDeclaration_none}
	 * labeled alternative in {@link MxParser#forDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForDeclaration_none(MxParser.ForDeclaration_noneContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#forExprEnd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForExprEnd(MxParser.ForExprEndContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#forExprUpdate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForExprUpdate(MxParser.ForExprUpdateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code jumpStatement_continue}
	 * labeled alternative in {@link MxParser#jumpStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJumpStatement_continue(MxParser.JumpStatement_continueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code jumpStatement_break}
	 * labeled alternative in {@link MxParser#jumpStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJumpStatement_break(MxParser.JumpStatement_breakContext ctx);
	/**
	 * Visit a parse tree produced by the {@code jumpStatement_return}
	 * labeled alternative in {@link MxParser#jumpStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJumpStatement_return(MxParser.JumpStatement_returnContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(MxParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#programDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgramDeclaration(MxParser.ProgramDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#functionDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDefinition(MxParser.FunctionDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code classDeclaration_decl}
	 * labeled alternative in {@link MxParser#classDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclaration_decl(MxParser.ClassDeclaration_declContext ctx);
	/**
	 * Visit a parse tree produced by the {@code classDeclaration_none}
	 * labeled alternative in {@link MxParser#classDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclaration_none(MxParser.ClassDeclaration_noneContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#classDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclaration(MxParser.ClassDeclarationContext ctx);
}