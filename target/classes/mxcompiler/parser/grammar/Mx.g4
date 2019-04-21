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
	;

/* ------------------- Declaration ---------------- */

// variable
variableDeclaration
	: type variableDeclaratorList ';'
	;
variableDeclaratorList
	: variableDeclarator (',' variableDeclarator)*
	;

variableDeclarator
	: Identifier ('=' expression)?
	;

type
	: type '[' ']'	# arrayType
	| typeName		# nonarrayType
	;

typeName
	: Int
	| Bool
	| String
	| Identifier
	;

// function
functionDeclaration
	: typeReturn? Identifier '(' paramDeclarationList? ')' block
	;

paramDeclarationList
	: paramDeclaration (',' paramDeclaration)*
	;

paramDeclaration
	: type Identifier
	;

typeReturn
	: type
	| Void
	;

// class
classDeclaration
	: Class Identifier '{' classBody* '}'
	;

classBody
	: functionDeclaration
	| variableDeclaration
	;



/* ------------------------------ Statement ------------------------- */
statement
	: block												# blockStmt
	| expression ';'									# exprStmt
	| If '(' expression ')' statement (Else statement)?	# ifStmt
	| While '(' expression ')' statement				# whileStmt
	| For '(' init = forDeclaration ';' cond = expression? ';' incr = expression? ')'
		statement # forInitStmt
	| For '(' init = expression? ';' cond = expression? ';' incr = expression? ')'
		statement				# forNoneStmt
	| Continue ';'				# continueStmt
	| Break ';'					# breakStmt
	| Return expression? ';'	# returnStmt
	| ';'						# blankStmt
	;


// only support 1-type decl with decl-init
forDeclaration // 479
	: type variableDeclaratorList
	;

block
	: '{' blockBody* '}'
	;

blockBody
	: statement
	| variableDeclaration
	;

/* ------------------------------ expression -------------------------------- */
expression
	: primaryExpression								# primaryExpr
	| expression op = ('++' | '--')					# suffixExpr
	| expression '.' Identifier						# memberExpr // under lhs
	| arr = expression '[' index = expression ']'	# arefExpr // under lhs
	| expression '(' paramList? ')'					# funcallExpr
	// prefix unary
	| <assoc = right> op = ('++' | '--') expression	# prefixExpr
	| <assoc = right> op = ('+' | '-') expression	# prefixExpr
	| <assoc = right> op = ('!' | '~') expression	# prefixExpr
	| <assoc = right> New creator					# newExpr
	// suffix
	| expression op = ('*' | '/' | '%') expression	# binaryExpr
	| expression op = ('+' | '-') expression		# binaryExpr
	// shift
	| expression op = ('<<' | '>>') expression # binaryExpr
	// compare
	| expression op = ('<' | '>') expression	# binaryExpr
	| expression op = ('<=' | '>=') expression	# binaryExpr
	| expression op = ('==' | '!=') expression	# binaryExpr
	// bitwise
	| expression op = '&' expression	# binaryExpr
	| expression op = '^' expression	# binaryExpr
	| expression op = '|' expression	# binaryExpr
	// logical
	| <assoc = right> expression op = '&&' expression	# binaryExpr
	| <assoc = right> expression op = '||' expression	# binaryExpr
	// assign
	| <assoc = right> expression op = '=' expression # assignExpr
	;

paramList
	: expression (',' expression)*
	;

primaryExpression
	: This
	| literal
	| Identifier
	| '(' expression ')' // used for () operator as sub-expr
	;

literal
	: IntLiteral
	| StringLiteral
	| Null
	| (True | False)
	;


creator
	: typeName ('[' expression ']')+ ('[' ']')+ (
		'[' expression ']'
	)+											# errorCreator
	| typeName ('[' expression ']')+ ('[' ']')*	# arrayCreator
	| typeName ('(' ')')?						# nonArrayCreator
	;
