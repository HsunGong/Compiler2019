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
	| postfixExpression		# unaryExpressionPostfix
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
	: This
	| True
	| False
	| Null
	| Identifier
	| StringLiteral
	| IntegerLiteral
	| '(' expression ')'
	;


expression
	: newExpression
	| logicalOrExpression
	| unaryExpression '=' expression //rhsExpr
	// | unaryExpression opassignOp expression // += /= ...
	// | DigitSequence  // FIX: what the hell is this?
	;

// optim with expression

newExpression /* new operation
	FIX : is LeftBracket LeftParen needed??? */
	: 'new' typeName ('[' expression ']')+ ('[' ']')+ (
		'[' expression ']'
	)+ # newExpressionError
	| 'new' typeName ('[' expression ']')+ (
		LeftBracket ']'
	)*							# newExpressionArray
	| 'new' typeName ('(' ')')?	# newExpressionNonarray
	;


/** ------------------- statements ---------- */
// FIX: whether 'if' or If; so as For While...
statement
	: block				# blockStatement
	| expression ';'	# exprStatement // contain ';'
	| If '(' expression ')' thenStmt = statement (
		Else elseStmt = statement
	)?										# ifStatement
	| While '(' expression ')' statement	# whileStatement
	| For '(' forCondition ')' statement	# forStatement
	| Return expression? ';'				# returnStatement
	| Continue ';'							# continueStatement
	| Break ';'								# breakStatement
	| ';'									# blankStmt
	;

block
	: '{' blockContent* '}' // FIX: stmt and vardecl
	;

blockContent
	: statement
	| variableDeclaration
	;

// FIX: x=expression
forCondition
	: init? ';' cond = expression? ';' step = expression?
	;

init														// FIX: only support 1-declaration
	: type (variableDeclarator (',' variableDeclarator)*)?	# forInitDecl
	| expression											# forInitExpr
	;


/** -------------- Declarations --------------- */

/** variable declaration */
variableDeclaration /* define variables, may have no names;
	may have mutiply names; may have init values */
	: type variableDeclarator (',' variableDeclarator)* ';'	# varDeclarationInit
	| type ';'												# varDeclarationNone // only type no name
	;														// FIX: needed??

variableDeclarator // declare some of variables names and some has init values
	: directDeclarator ('=' expression)?
	;

type /* like int or int[]
	used for init */
	: typeName		# typeNonarray
	| type '[' ']'	# typeArray
	;

typeName
	: Int
	| String
	| Bool
	| Identifier // self define name
	;

typeFuncName
	: 'void'
	| typeName
	;

directDeclarator /* FIX: when to use recycle??
	all of the declarator names 
	and some are functions
	and ?? */
	: Identifier // # directDeclaratorIdentifier
	// | directDeclarator '(' parameterList? ')'	# directDeclaratorWithParameterList
	// | '(' directDeclarator ')'					# directDeclaratorRecycle 
	;

/** function declaration */
functionDeclaration
	: typeFuncName? Identifier '(' parameterList? ')' block
	;

parameterList
	: parameterDeclaration (',' parameterDeclaration)*
	;

// no init-expr
parameterDeclaration
	: type Identifier
	;

/** class declaration */
classDeclaration
	: 'class' Identifier '{' classBody* '}'
	// | 'class' Identifier						# classBodyNone // FIX: what the hell??
	;

classBody
	: variableDeclaration
	| functionDeclaration
	;


