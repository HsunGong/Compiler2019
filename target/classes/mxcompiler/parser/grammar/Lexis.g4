lexer grammar Lexis
	;

/** ---------------------- lexer ----------- */

Break
	: 'break'
	;
Continue
	: 'continue'
	;
Default
	: 'default'
	;
Else
	: 'else'
	;
For
	: 'for'
	;
If
	: 'if'
	;
Int
	: 'int'
	;
String
	: 'string' // attention
	;
Return
	: 'return'
	;
Class
	: 'class'
	;
Void
	: 'void'
	;
While
	: 'while'
	;
Bool
	: 'bool'
	;


LeftParen
	: '('
	;
RightParen
	: ')'
	;
LeftBracket
	: '['
	;
RightBracket
	: ']'
	;
LeftBrace
	: '{'
	;
RightBrace
	: '}'
	;
Less
	: '<'
	;
LessEqual
	: '<='
	;
Greater
	: '>'
	;
GreaterEqual
	: '>='
	;
LeftShift
	: '<<'
	;
RightShift
	: '>>'
	;
Plus
	: '+'
	;
PlusPlus
	: '++'
	;
Minus
	: '-'
	;
MinusMinus
	: '--'
	;
Star
	: '*'
	;
Div
	: '/'
	;
Mod
	: '%'
	;
And
	: '&'
	;
Or
	: '|'
	;
AndAnd
	: '&&'
	;
OrOr
	: '||'
	;
Caret
	: '^'
	;
Not
	: '!'
	;
Tilde
	: '~'
	;
Question
	: '?'
	;
Colon
	: ':'
	;
Semi
	: ';'
	;
Comma
	: ','
	;
Assign
	: '='
	;
Equal
	: '=='
	;
NotEqual
	: '!='
	;
Arrow
	: '->'
	;
Dot
	: '.'
	;

New
	: 'new'
	;

This
	: 'this'
	;

True
	: 'true'
	;
False
	: 'false'
	;
Null
	: 'null'
	;



// TODO: have octal, binary ... support
IntLiteral
	: DecimalLiteral
	;

fragment DecimalLiteral
	: [1-9] Digit*
	| '0'
	;

// @Deprecated  DecimalLiteral IntegerSuffix?
fragment IntegerSuffix
	: [uU] [lL]?
	| [uU] ('ll' | 'LL')
	| [Ll] [uU]?
	| ('ll' | 'LL') [uU]?
	;


StringLiteral
	: '"' (SChar+)? '"'
	;

fragment SChar
	: ~["\r\n\\]
	// | '\\' ["n\\]
	| EscapeSequence
	;

// @Deprecated
fragment EscapeSequence
	: '\\' [bfnrt'"\\]
	;


Identifier
	: Letter (NonDigit | Digit)*
	;

fragment Letter //Nondigitnon
	: [a-zA-Z]
	;

fragment NonDigit
	: [a-zA-Z_]
	;

fragment Digit
	: [0-9]
	;


Whitespace
	: [ \t]+ -> skip
	;

Newline
	: ('\r' '\n'? | '\n') -> skip
	;

LineCommnet
	: '//' ~[\r\n]* -> skip
	;

// @Deprecated
BlockComment
	: '/*' .*? '*/' -> skip
	;
