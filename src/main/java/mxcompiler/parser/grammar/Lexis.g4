lexer grammar Lexis;

Identifier
	:	IdentifierNondigit
		(	IdentifierNondigit
		|	Digit
		)*
	;

fragment IdentifierNondigit
	:	Nondigit
	|	UniversalCharacterName
	;

fragment Nondigit
	: [a-zA-Z_]
	;

fragment Digit
	: [0-9]
	;

fragment UniversalCharacterName
	:	'\\u' HexQuad
	|	'\\U' HexQuad HexQuad
	;

// FIX
fragment HexQuad
	: HexadecimalDigit HexadecimalDigit HexadecimalDigit HexadecimalDigit
	;

Constant
	:	IntegerConstant
	|	StringConstant // FIX
	;


// FIX
fragment IntegerConstant
	: DecimalConstant IntegerSuffix?
	| OctalConstant IntegerSuffix?
	| HexadecimalConstant IntegerSuffix?
	| BinaryConstant
	;

	//@Deprecated

fragment BinaryConstant
	:	'0' [bB] [0-1]+
	;
		//@Deprecated

fragment HexadecimalConstant
	:	'0' [xX] [0-9a-fA-F]+
	;
	//@Deprecated
	fragment OctalConstant
	:	'0' [0-7]*
	;

	fragment DecimalConstant
	:	[1-9] Digit*
	;

	//@Deprecated
	fragment IntegerSuffix
	:	[uU] [lL]?
	|	[uU] ('ll' | 'LL')
	|	[Ll] [uU]?
	|	('ll' | 'LL') [uU]?
	;

	fragment StringConstant
	:	'"' Char '"'
	;

	fragment Char
	:	~['\r\n\\]
	|	EscapeSequence
	;

	fragment EscapeSequence
	:

















Break : 'break' ;
Continue : 'continue' ;
Default : 'default' ;
Else : 'else' ;
For : 'for' ;
If : 'if' ;
Int : 'int' ;
Long : 'long' ;
Return : 'return' ;
Class : 'class' ;
Void : 'void' ;
While : 'while' ;

Bool : '_Bool' ;
Noreturn : '_Noreturn' ;

LeftParen : '(' ;
RightParen : ')' ;
LeftBracket : '[' ;
RightBracket : ']' ;
LeftBrace : '{' ;
RightBrace : '}' ;

Less : '<' ;
LessEqual : '<=' ;
Greater : '>' ;
GreaterEqual : '>=' ;
LeftShift : '<<' ;
RightShift : '>>' ;

Plus : '+' ;
PlusPlus : '++' ;
Minus : '-' ;
MinusMinus : '--' ;
Star : '*' ;
Div : '/' ;
Mod : '%' ;

And : '&' ;
Or : '|' ;
AndAnd : '&&' ;
OrOr : '||' ;
Caret : '^' ;
Not : '!' ;
Tilde : '~' ;

Question : '?' ;
Colon : ':' ;
Semi : ';' ;
Comma : ',' ;

Assign : '=' ;
Equal : '==' ;
NotEqual : '!=' ;

Arrow : '->' ;
Dot : '.' ;
Ellipsis : '...' ;

