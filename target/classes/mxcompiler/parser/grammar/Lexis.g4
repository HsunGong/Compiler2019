lexer grammar Lexis
	;

Identifier
	: Letter (
		(Letter | '_') // Nondigit
		| Digit
	)*
	;

fragment Letter //Nondigitnon
	: [a-zA-Z]
	;
fragment Digit
	: [0-9]
	;



// TODO: have octal, binary ... support
IntegerLiteral
	: DecimalConstant IntegerSuffix?
	;

fragment DecimalConstant
	: [1-9] Digit*
	;
DigitSequence
	: Digit+
	;
// @Deprecated
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
	| '\\\n'
	| '\\\r\n'
	| EscapeSequence
	;

fragment EscapeSequence
	: '\\' ['"?abfnrtv\\]
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
	: 'String'
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
