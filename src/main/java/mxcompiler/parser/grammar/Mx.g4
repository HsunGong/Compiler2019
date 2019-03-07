grammar Mx
	;

import Lexis
	;

compilation_unit
	: translate_unit* EOF
	;

translate_unit
	: function_declaration
	| class_declaration
	| variable_declaration
	| ';' // FIX: how to find a 'main function
	;

variable_declaration // declaration
	: type init_declaration_list ';'
	| type ';' //FIX ???
	;

type // also seen as declarationSpecifier
	: type '[' ']'
	| type '[' IntegerLiteral ']'
	// | type '(' param_typeref () ')'	//FIX: function-iter
	| type_name // also typeSpecifier
	;

type_name // also typeSpecifier
	: Void
	| Int
	| String
	| Bool
	| type_new = Identifier // FIX: ALL right, how to check out?? Also typedefName
	;
// type_new
// 	: 
// 	;

init_declaration_list // variable name and declaration
	: init_declarator (',' init_declarator)*
	;

init_declarator								// each one
	: direct_declarator ('=' expression)?	// initvalue
	;
direct_declarator
	: Identifier				// variable name or so
	| '(' direct_declarator ')'	// FIX: what the hell
	// | direct_declarator '(' parameter_list? ')'	// FIX: the function??
	;


function_declaration
	: type? function_declarator block // ? for construct function
	;

function_declarator
	: direct_declarator '(' parameter_list? ')'
	;
parameter_list
	: parameter_declaration (',' parameter_declaration)*
	;
parameter_declaration
	: type direct_declarator
	;


block
	: '{' (statement | variable_declaration)* '}'
	;

statement
	:
	| ';' // especially added so to be mentioned
	| expression ';'
	| block // FIX ??
	| if_statement
	| while_statement
	| for_statement
	| break_statement
	| continue_statement
	| return_statement
	;

expression				// FIX: may have declaration if 'for' stmt has
	: new_declarator	// TODO: herited from java
	| expression10 // DigitString??
	| term '=' expression
	;

// FIX: needed to change '[' into leftbracket ???
new_declarator
	: New type_name ('[' expression ']')+ ('[' ']')* // array
	| New type_name ('[' expression ']')+ ('[' ']')* (
		'[' expression ']'
	)+							//error array type
	| New type_name ('(' ')')	// simple var
	;

expression10
	: logical_or_expression ('?' expression ':' expression10)?
	;
logical_or_expression
	: logical_and_expression ('||' logical_or_expression)*
	;
logical_and_expression
	: bit_or_expression ('&&' logical_and_expression)*
	;
bit_or_expression
	: bit_nor_expression ('|' bit_or_expression)*
	;
bit_nor_expression
	: bit_and_expression ('^' bit_nor_expression)*
	;
bit_and_expression
	: relational_expression ('&' bit_and_expression)*
	;
relational_expression
	: shift_expression ('>' relational_expression)*
	| shift_expression ('>=' relational_expression)*
	| shift_expression ('<' relational_expression)*
	| shift_expression ('<=' relational_expression)*
	| shift_expression ('==' relational_expression)*
	| shift_expression ('!=' relational_expression)*
	;
shift_expression
	: additive_expression ('>>' shift_expression)*
	| additive_expression ('<<' shift_expression)*
	;
additive_expression
	: multiplicative_expression ('+' additive_expression)*
	| multiplicative_expression ('-' additive_expression)*
	;
multiplicative_expression
	: term ('*' multiplicative_expression)*
	| term ('/' multiplicative_expression)*
	| term ('%' multiplicative_expression)*
	;
term // cast_expression
	: '(' type ')' term
	| IntegerLiteral // FIX ??? where should be put and why? seen as DigitSequence
	| unary
	;

unary
	: ('++' | '--') unary
	| ('+' | '-' | '!' | '~') term
	// | Sizeof '(' type ')'
	// | Sizeof unary
	| postfix
	;

postfix
	: primary (
		'++'
		| '--'
		| '.' type_name // Identifier
		// | '->' type_name
		| '[' expression ']'
		| '(' arguments_list? ')'
	) // FIX: mutiply postfix ???
	;
arguments_list
	: expression (',' expression)*
	;
primary
	: 'this'
	| 'null'
	| 'true'
	| 'false'
	| Identifier
	| IntegerLiteral
	| StringLiteral
	| '(' expression ')'
	;


if_statement
	: If '(' expression ')' statement (Else statement)?
	;
while_statement
	: While '(' expression ')' statement
	;
for_statement
	: For '(' expression? ';' expression? ';' expression? ';' ')' statement
	;
break_statement
	: Break ';'
	;
continue_statement
	: Continue ';'
	;
return_statement
	: Return expression? ';'
	;

// TODO class
class_declaration
	: 'class' Identifier? '{' class_body* '}'
	| 'class' Identifier
	;

class_body // 
	: variable_declaration
	| function_declaration
	;



