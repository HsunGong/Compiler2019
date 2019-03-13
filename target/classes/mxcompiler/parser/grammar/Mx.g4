grammar Mx
	;

import Lexis
	;

compilationUnit
	: translationUnit* EOF
	;

translationUnit
	: functionDeclaration
	| classDeclaration
	| variableDeclaration
	| ';'
	;

// FIX: left recursive --> * replace with left recursive
/* logicalOrExpression
	: logicalAndExpression							# logicalOrExpressionUnary
	| logicalOrExpression ('||' logicalAndExpression	# logicalOrExpressionBinary
	; */


logicalOrExpression // expression9
	: logicalAndExpression ('||' logicalAndExpression)*
	;
logicalAndExpression
	: binaryOrExpression ('&&' binaryOrExpression)*
	;
binaryOrExpression
	: binaryNorExpression ('|' binaryNorExpression)*
	;
binaryNorExpression
	: binaryAndExpression ('^' binaryAndExpression)*
	;
binaryAndExpression
	: equalExpression ('&' equalExpression)*
	;
equalExpression // FIX: needed to tag == or != or unary??
	: compareExpression ('==' compareExpression)*
	| compareExpression ('!=' compareExpression)*
	;
compareExpression
	: shiftExpression ('<' shiftExpression)*
	| shiftExpression ('>' shiftExpression)*
	| shiftExpression ('<=' shiftExpression)*
	| shiftExpression ('>=' shiftExpression)*
	;
shiftExpression
	: addExpression ('>>' addExpression)*
	| addExpression ('<<' addExpression)*
	;
addExpression
	: multiExpression ('+' multiExpression)*
	| multiExpression ('-' multiExpression)*
	;
multiExpression
	: term ('*' term)*
	| term ('/' term)*
	| term ('%' term)*
	;

term
	: unaryExpression
	| DigitSequence // a number
	// | '(' typeName ')' term // forced cast change
	;


unaryExpression /* seems not like an expression
	but here regard as an expression*/
	: '++' unaryExpression	# unaryExpressionPrefixInc
	| '--' unaryExpression	# unaryExpressionPrefixDec
	| unaryOperator term	# unaryExpressionPrefix // FIX: double unaryOperator??
	| postfixExpression	# unaryExpressionPostfix
	;

unaryOperator
	: '+'
	| '-'
	| '!'
	| '~'
	;


postfixExpression /* FIX: different between left:(x)* and left:left + x
	FIX: needed to tag??
	non-terminal symbol -> postfix
	terminal symbol(may) -> primary */
	: primaryExpression
	| postfixExpression '++'
	| postfixExpression '--'
	| postfixExpression '[' expression ']'
	| postfixExpression '.' Identifier
	| postfixExpression '(' args ')'
	;


args // FIX: does Single or Mutli matters??
	: (expression (',' expression))?
	;

primaryExpression
	: 'this'
	| 'true'
	| 'false'
	| 'null'
	| Identifier
	| StringLiteral
	| IntegerLiteral
	| '(' expression ')'
	;


expression10
	: logicalOrExpression (
		'?' expression ':' expression10
	)?
	;

expression
	: newExpression
	| expression10
	| unaryExpression '=' expression //rhsExpr
	// | unaryExpression opassignOp expression // += /= ...
	// | DigitSequence  // FIX: what the hell is this?
	;


variableDeclaration /* define variables, may have no names;
	may have mutiply names; may have init values */
	: type variableDeclarator (',' variableDeclarator)* ';'	# declarationInit
	| type ';'													# declarationNone // only type no name
	;


variableDeclarator						// declare some of variables names and some has init values
	: directDeclarator					# variableDeclaratorNone
	| directDeclarator '=' expression	# variableDeclaratorInit
	;


newExpression /* new operation
	FIX : is LeftBracket LeftParen needed??? */
	: 'new' typeName ('[' expression ']')+ ('[' ']')+ (
		'[' expression ']'
	)+ # newExpressionError
	| 'new' typeName ('[' expression ']')+ (
		LeftBracket ']'
	)*									# newExpressionArray
	| 'new' typeName (LeftParen ')')?	# newExpressionNonarray
	;


type /* like int or int[]
	used for init */
	: typeName		# typeType
	| type '[' ']'	# typeArray
	;


typeName // FIX: include function type!!!
	: 'void'
	| 'int'
	| 'string'
	| 'bool'
	| typedefName
	;


typedefName // only for self define type!!!!
	: Identifier
	;


directDeclarator /* FIX: when to use recycle??
	all of the declarator names 
	and some are functions
	and ?? */
	: Identifier								# directDeclaratorIdentifier
	| directDeclarator '(' parameterList? ')'	# directDeclaratorWithParameterList
	// | '(' directDeclarator ')'					# directDeclaratorRecycle 
	;



statement													// FIX: whether 'if' or If; so as For While...
	: expression? ';'										# exprStatement // contain ';'
	| block													# blockStatement
	| If '(' expression ')' statement ('else' statement)?	# switchStatement
	| While '(' expression ')' statement					# iterationStatementWhile
	| For '(' forCondition ')' statement					# iterationStatementFor
	| 'continue' ';'										# jumpStatementContinue
	| 'break' ';'											# jumpStatementBreak
	| 'return' expression? ';'								# jumpStatementReturn
	;

block
	: '{' (statement | variableDeclaration)* '}'
	;


forCondition											// FIX: update?? end??
	: forDeclaration ';' expression? ';' expression?	# forConditionInit
	| expression? ';' expression? ';' expression?		# forConditionNone
	;

forDeclaration												// FIX: only support 1-declaration
	: type variableDeclarator (',' variableDeclarator)*	# declarationInit
	| type													# declarationNone // only type no name
	;

functionDeclaration
	: type? functionDeclarator block
	;

functionDeclarator
	: typedefName '(' parameterList? ')'
	;
parameterList
	: parameterDeclaration (',' parameterDeclaration)* # parameterListMulti
	;

parameterDeclaration
	: type Identifier
	;


classDeclaration
	: 'class' Identifier? '{' classBody* '}'	# classBodyDecl
	| 'class' Identifier						# classBodyNone // FIX: what the hell??
	;

classBody
	: variableDeclaration
	| functionDeclaration
	;