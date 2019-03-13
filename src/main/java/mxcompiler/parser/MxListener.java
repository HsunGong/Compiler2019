// Generated from /home/xun/Documents/mxc/src/main/java/mxcompiler/parser/grammar/Mx.g4 by ANTLR 4.7.2
package mxcompiler.parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MxParser}.
 */
public interface MxListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MxParser#compilation_unit}.
	 * @param ctx the parse tree
	 */
	void enterCompilation_unit(MxParser.Compilation_unitContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#compilation_unit}.
	 * @param ctx the parse tree
	 */
	void exitCompilation_unit(MxParser.Compilation_unitContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#translation_unit}.
	 * @param ctx the parse tree
	 */
	void enterTranslation_unit(MxParser.Translation_unitContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#translation_unit}.
	 * @param ctx the parse tree
	 */
	void exitTranslation_unit(MxParser.Translation_unitContext ctx);
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
	 * Enter a parse tree produced by {@link MxParser#logical_or_expression}.
	 * @param ctx the parse tree
	 */
	void enterLogical_or_expression(MxParser.Logical_or_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#logical_or_expression}.
	 * @param ctx the parse tree
	 */
	void exitLogical_or_expression(MxParser.Logical_or_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#logical_and_expression}.
	 * @param ctx the parse tree
	 */
	void enterLogical_and_expression(MxParser.Logical_and_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#logical_and_expression}.
	 * @param ctx the parse tree
	 */
	void exitLogical_and_expression(MxParser.Logical_and_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#binary_or_expression}.
	 * @param ctx the parse tree
	 */
	void enterBinary_or_expression(MxParser.Binary_or_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#binary_or_expression}.
	 * @param ctx the parse tree
	 */
	void exitBinary_or_expression(MxParser.Binary_or_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#binary_nor_expression}.
	 * @param ctx the parse tree
	 */
	void enterBinary_nor_expression(MxParser.Binary_nor_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#binary_nor_expression}.
	 * @param ctx the parse tree
	 */
	void exitBinary_nor_expression(MxParser.Binary_nor_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#binary_and_expression}.
	 * @param ctx the parse tree
	 */
	void enterBinary_and_expression(MxParser.Binary_and_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#binary_and_expression}.
	 * @param ctx the parse tree
	 */
	void exitBinary_and_expression(MxParser.Binary_and_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#equal_expression}.
	 * @param ctx the parse tree
	 */
	void enterEqual_expression(MxParser.Equal_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#equal_expression}.
	 * @param ctx the parse tree
	 */
	void exitEqual_expression(MxParser.Equal_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#compare_expression}.
	 * @param ctx the parse tree
	 */
	void enterCompare_expression(MxParser.Compare_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#compare_expression}.
	 * @param ctx the parse tree
	 */
	void exitCompare_expression(MxParser.Compare_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#shift_expression}.
	 * @param ctx the parse tree
	 */
	void enterShift_expression(MxParser.Shift_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#shift_expression}.
	 * @param ctx the parse tree
	 */
	void exitShift_expression(MxParser.Shift_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#add_expression}.
	 * @param ctx the parse tree
	 */
	void enterAdd_expression(MxParser.Add_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#add_expression}.
	 * @param ctx the parse tree
	 */
	void exitAdd_expression(MxParser.Add_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#multi_expression}.
	 * @param ctx the parse tree
	 */
	void enterMulti_expression(MxParser.Multi_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#multi_expression}.
	 * @param ctx the parse tree
	 */
	void exitMulti_expression(MxParser.Multi_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#expression10}.
	 * @param ctx the parse tree
	 */
	void enterExpression10(MxParser.Expression10Context ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#expression10}.
	 * @param ctx the parse tree
	 */
	void exitExpression10(MxParser.Expression10Context ctx);
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
	 * labeled alternative in {@link MxParser#variable_declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration_init(MxParser.Declaration_initContext ctx);
	/**
	 * Exit a parse tree produced by the {@code declaration_init}
	 * labeled alternative in {@link MxParser#variable_declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration_init(MxParser.Declaration_initContext ctx);
	/**
	 * Enter a parse tree produced by the {@code declaration_none}
	 * labeled alternative in {@link MxParser#variable_declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration_none(MxParser.Declaration_noneContext ctx);
	/**
	 * Exit a parse tree produced by the {@code declaration_none}
	 * labeled alternative in {@link MxParser#variable_declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration_none(MxParser.Declaration_noneContext ctx);
	/**
	 * Enter a parse tree produced by the {@code variable_declarator_none}
	 * labeled alternative in {@link MxParser#variable_declarator}.
	 * @param ctx the parse tree
	 */
	void enterVariable_declarator_none(MxParser.Variable_declarator_noneContext ctx);
	/**
	 * Exit a parse tree produced by the {@code variable_declarator_none}
	 * labeled alternative in {@link MxParser#variable_declarator}.
	 * @param ctx the parse tree
	 */
	void exitVariable_declarator_none(MxParser.Variable_declarator_noneContext ctx);
	/**
	 * Enter a parse tree produced by the {@code variable_declarator_init}
	 * labeled alternative in {@link MxParser#variable_declarator}.
	 * @param ctx the parse tree
	 */
	void enterVariable_declarator_init(MxParser.Variable_declarator_initContext ctx);
	/**
	 * Exit a parse tree produced by the {@code variable_declarator_init}
	 * labeled alternative in {@link MxParser#variable_declarator}.
	 * @param ctx the parse tree
	 */
	void exitVariable_declarator_init(MxParser.Variable_declarator_initContext ctx);
	/**
	 * Enter a parse tree produced by the {@code new_expression_error}
	 * labeled alternative in {@link MxParser#new_expression}.
	 * @param ctx the parse tree
	 */
	void enterNew_expression_error(MxParser.New_expression_errorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code new_expression_error}
	 * labeled alternative in {@link MxParser#new_expression}.
	 * @param ctx the parse tree
	 */
	void exitNew_expression_error(MxParser.New_expression_errorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code new_expression_array}
	 * labeled alternative in {@link MxParser#new_expression}.
	 * @param ctx the parse tree
	 */
	void enterNew_expression_array(MxParser.New_expression_arrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code new_expression_array}
	 * labeled alternative in {@link MxParser#new_expression}.
	 * @param ctx the parse tree
	 */
	void exitNew_expression_array(MxParser.New_expression_arrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code new_expression_nonarray}
	 * labeled alternative in {@link MxParser#new_expression}.
	 * @param ctx the parse tree
	 */
	void enterNew_expression_nonarray(MxParser.New_expression_nonarrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code new_expression_nonarray}
	 * labeled alternative in {@link MxParser#new_expression}.
	 * @param ctx the parse tree
	 */
	void exitNew_expression_nonarray(MxParser.New_expression_nonarrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code type_array}
	 * labeled alternative in {@link MxParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType_array(MxParser.Type_arrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code type_array}
	 * labeled alternative in {@link MxParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType_array(MxParser.Type_arrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code type_type}
	 * labeled alternative in {@link MxParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType_type(MxParser.Type_typeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code type_type}
	 * labeled alternative in {@link MxParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType_type(MxParser.Type_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#type_name}.
	 * @param ctx the parse tree
	 */
	void enterType_name(MxParser.Type_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#type_name}.
	 * @param ctx the parse tree
	 */
	void exitType_name(MxParser.Type_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#typedef_name}.
	 * @param ctx the parse tree
	 */
	void enterTypedef_name(MxParser.Typedef_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#typedef_name}.
	 * @param ctx the parse tree
	 */
	void exitTypedef_name(MxParser.Typedef_nameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code direct_declarator_Identifier}
	 * labeled alternative in {@link MxParser#direct_declarator}.
	 * @param ctx the parse tree
	 */
	void enterDirect_declarator_Identifier(MxParser.Direct_declarator_IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by the {@code direct_declarator_Identifier}
	 * labeled alternative in {@link MxParser#direct_declarator}.
	 * @param ctx the parse tree
	 */
	void exitDirect_declarator_Identifier(MxParser.Direct_declarator_IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code direct_declarator_with_parameterList}
	 * labeled alternative in {@link MxParser#direct_declarator}.
	 * @param ctx the parse tree
	 */
	void enterDirect_declarator_with_parameterList(MxParser.Direct_declarator_with_parameterListContext ctx);
	/**
	 * Exit a parse tree produced by the {@code direct_declarator_with_parameterList}
	 * labeled alternative in {@link MxParser#direct_declarator}.
	 * @param ctx the parse tree
	 */
	void exitDirect_declarator_with_parameterList(MxParser.Direct_declarator_with_parameterListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expr_statement}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterExpr_statement(MxParser.Expr_statementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expr_statement}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitExpr_statement(MxParser.Expr_statementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code block_statement}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterBlock_statement(MxParser.Block_statementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code block_statement}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitBlock_statement(MxParser.Block_statementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code switch_statement}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterSwitch_statement(MxParser.Switch_statementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code switch_statement}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitSwitch_statement(MxParser.Switch_statementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code iteration_statement_while}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterIteration_statement_while(MxParser.Iteration_statement_whileContext ctx);
	/**
	 * Exit a parse tree produced by the {@code iteration_statement_while}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitIteration_statement_while(MxParser.Iteration_statement_whileContext ctx);
	/**
	 * Enter a parse tree produced by the {@code iteration_statement_for}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterIteration_statement_for(MxParser.Iteration_statement_forContext ctx);
	/**
	 * Exit a parse tree produced by the {@code iteration_statement_for}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitIteration_statement_for(MxParser.Iteration_statement_forContext ctx);
	/**
	 * Enter a parse tree produced by the {@code jump_statement_continue}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterJump_statement_continue(MxParser.Jump_statement_continueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code jump_statement_continue}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitJump_statement_continue(MxParser.Jump_statement_continueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code jump_statement_break}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterJump_statement_break(MxParser.Jump_statement_breakContext ctx);
	/**
	 * Exit a parse tree produced by the {@code jump_statement_break}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitJump_statement_break(MxParser.Jump_statement_breakContext ctx);
	/**
	 * Enter a parse tree produced by the {@code jump_statement_return}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterJump_statement_return(MxParser.Jump_statement_returnContext ctx);
	/**
	 * Exit a parse tree produced by the {@code jump_statement_return}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitJump_statement_return(MxParser.Jump_statement_returnContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(MxParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(MxParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code forCondition_init}
	 * labeled alternative in {@link MxParser#for_condition}.
	 * @param ctx the parse tree
	 */
	void enterForCondition_init(MxParser.ForCondition_initContext ctx);
	/**
	 * Exit a parse tree produced by the {@code forCondition_init}
	 * labeled alternative in {@link MxParser#for_condition}.
	 * @param ctx the parse tree
	 */
	void exitForCondition_init(MxParser.ForCondition_initContext ctx);
	/**
	 * Enter a parse tree produced by the {@code forCondition_none}
	 * labeled alternative in {@link MxParser#for_condition}.
	 * @param ctx the parse tree
	 */
	void enterForCondition_none(MxParser.ForCondition_noneContext ctx);
	/**
	 * Exit a parse tree produced by the {@code forCondition_none}
	 * labeled alternative in {@link MxParser#for_condition}.
	 * @param ctx the parse tree
	 */
	void exitForCondition_none(MxParser.ForCondition_noneContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#function_declaration}.
	 * @param ctx the parse tree
	 */
	void enterFunction_declaration(MxParser.Function_declarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#function_declaration}.
	 * @param ctx the parse tree
	 */
	void exitFunction_declaration(MxParser.Function_declarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#function_declarator}.
	 * @param ctx the parse tree
	 */
	void enterFunction_declarator(MxParser.Function_declaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#function_declarator}.
	 * @param ctx the parse tree
	 */
	void exitFunction_declarator(MxParser.Function_declaratorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parameterList_multi}
	 * labeled alternative in {@link MxParser#parameter_list}.
	 * @param ctx the parse tree
	 */
	void enterParameterList_multi(MxParser.ParameterList_multiContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parameterList_multi}
	 * labeled alternative in {@link MxParser#parameter_list}.
	 * @param ctx the parse tree
	 */
	void exitParameterList_multi(MxParser.ParameterList_multiContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#parameter_declaration}.
	 * @param ctx the parse tree
	 */
	void enterParameter_declaration(MxParser.Parameter_declarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#parameter_declaration}.
	 * @param ctx the parse tree
	 */
	void exitParameter_declaration(MxParser.Parameter_declarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code class_body_decl}
	 * labeled alternative in {@link MxParser#class_declaration}.
	 * @param ctx the parse tree
	 */
	void enterClass_body_decl(MxParser.Class_body_declContext ctx);
	/**
	 * Exit a parse tree produced by the {@code class_body_decl}
	 * labeled alternative in {@link MxParser#class_declaration}.
	 * @param ctx the parse tree
	 */
	void exitClass_body_decl(MxParser.Class_body_declContext ctx);
	/**
	 * Enter a parse tree produced by the {@code class_body_none}
	 * labeled alternative in {@link MxParser#class_declaration}.
	 * @param ctx the parse tree
	 */
	void enterClass_body_none(MxParser.Class_body_noneContext ctx);
	/**
	 * Exit a parse tree produced by the {@code class_body_none}
	 * labeled alternative in {@link MxParser#class_declaration}.
	 * @param ctx the parse tree
	 */
	void exitClass_body_none(MxParser.Class_body_noneContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#class_body}.
	 * @param ctx the parse tree
	 */
	void enterClass_body(MxParser.Class_bodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#class_body}.
	 * @param ctx the parse tree
	 */
	void exitClass_body(MxParser.Class_bodyContext ctx);
}