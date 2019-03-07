grammar Mx
	;

import Lexis
	;

// start parser
start
	: topDefines EOF
	;

topDefines
	: functionDefinition
	| classDefinition
	| variableDefinition
	;


functionDefinition
	: (type | Void) Identifier '(' params ')' block
	;

type
	: typedef
	| type '[' IntegerLiteral ']'
	| type '[' ']'
	// FIX:cur no function-iter
	;

typedef
	: String
	| Int
	| Bool
	| Identifier // for class type Identifier
	;
params // have to be fixed
	: 
	| param (',' param)*
	;
param
	: type Identifier ('=' init)?
	;

block
	: '{' variableDefinitionList statements '}'
	;

variableDefinitionList :
	;

declarationSpecifier
	:
	;
classDefinition
	:
	;
variableDefinition
	:
	;



statements
	:
	;