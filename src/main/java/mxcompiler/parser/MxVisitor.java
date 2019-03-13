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
	 * Visit a parse tree produced by {@link MxParser#compilation_unit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompilation_unit(MxParser.Compilation_unitContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#translation_unit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTranslation_unit(MxParser.Translation_unitContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#primaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryExpression(MxParser.PrimaryExpressionContext ctx);
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
	 * Visit a parse tree produced by {@link MxParser#logical_or_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogical_or_expression(MxParser.Logical_or_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#logical_and_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogical_and_expression(MxParser.Logical_and_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#binary_or_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinary_or_expression(MxParser.Binary_or_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#binary_nor_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinary_nor_expression(MxParser.Binary_nor_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#binary_and_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinary_and_expression(MxParser.Binary_and_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#equal_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqual_expression(MxParser.Equal_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#compare_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompare_expression(MxParser.Compare_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#shift_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShift_expression(MxParser.Shift_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#add_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdd_expression(MxParser.Add_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#multi_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulti_expression(MxParser.Multi_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#expression10}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression10(MxParser.Expression10Context ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(MxParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code declaration_init}
	 * labeled alternative in {@link MxParser#variable_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration_init(MxParser.Declaration_initContext ctx);
	/**
	 * Visit a parse tree produced by the {@code declaration_none}
	 * labeled alternative in {@link MxParser#variable_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration_none(MxParser.Declaration_noneContext ctx);
	/**
	 * Visit a parse tree produced by the {@code variable_declarator_none}
	 * labeled alternative in {@link MxParser#variable_declarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable_declarator_none(MxParser.Variable_declarator_noneContext ctx);
	/**
	 * Visit a parse tree produced by the {@code variable_declarator_init}
	 * labeled alternative in {@link MxParser#variable_declarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable_declarator_init(MxParser.Variable_declarator_initContext ctx);
	/**
	 * Visit a parse tree produced by the {@code new_expression_error}
	 * labeled alternative in {@link MxParser#new_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNew_expression_error(MxParser.New_expression_errorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code new_expression_array}
	 * labeled alternative in {@link MxParser#new_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNew_expression_array(MxParser.New_expression_arrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code new_expression_nonarray}
	 * labeled alternative in {@link MxParser#new_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNew_expression_nonarray(MxParser.New_expression_nonarrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code type_array}
	 * labeled alternative in {@link MxParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_array(MxParser.Type_arrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code type_type}
	 * labeled alternative in {@link MxParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_type(MxParser.Type_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#type_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_name(MxParser.Type_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#typedef_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypedef_name(MxParser.Typedef_nameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code direct_declarator_Identifier}
	 * labeled alternative in {@link MxParser#direct_declarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDirect_declarator_Identifier(MxParser.Direct_declarator_IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by the {@code direct_declarator_with_parameterList}
	 * labeled alternative in {@link MxParser#direct_declarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDirect_declarator_with_parameterList(MxParser.Direct_declarator_with_parameterListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expr_statement}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_statement(MxParser.Expr_statementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code block_statement}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock_statement(MxParser.Block_statementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code switch_statement}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitch_statement(MxParser.Switch_statementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code iteration_statement_while}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIteration_statement_while(MxParser.Iteration_statement_whileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code iteration_statement_for}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIteration_statement_for(MxParser.Iteration_statement_forContext ctx);
	/**
	 * Visit a parse tree produced by the {@code jump_statement_continue}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJump_statement_continue(MxParser.Jump_statement_continueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code jump_statement_break}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJump_statement_break(MxParser.Jump_statement_breakContext ctx);
	/**
	 * Visit a parse tree produced by the {@code jump_statement_return}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJump_statement_return(MxParser.Jump_statement_returnContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(MxParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forCondition_init}
	 * labeled alternative in {@link MxParser#for_condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForCondition_init(MxParser.ForCondition_initContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forCondition_none}
	 * labeled alternative in {@link MxParser#for_condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForCondition_none(MxParser.ForCondition_noneContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#function_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_declaration(MxParser.Function_declarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#function_declarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_declarator(MxParser.Function_declaratorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parameterList_multi}
	 * labeled alternative in {@link MxParser#parameter_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterList_multi(MxParser.ParameterList_multiContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#parameter_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter_declaration(MxParser.Parameter_declarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code class_body_decl}
	 * labeled alternative in {@link MxParser#class_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClass_body_decl(MxParser.Class_body_declContext ctx);
	/**
	 * Visit a parse tree produced by the {@code class_body_none}
	 * labeled alternative in {@link MxParser#class_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClass_body_none(MxParser.Class_body_noneContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#class_body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClass_body(MxParser.Class_bodyContext ctx);
}