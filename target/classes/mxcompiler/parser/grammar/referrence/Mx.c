
Break : 'break';
Continue : 'continue';
Else : 'else';
For : 'for';
If : 'if';
Int : 'int';
String : 'string';
Return : 'return';
Void : 'void';
While : 'while';
Class : 'class';
New : 'new';
True : 'true';
False : 'false';
Null : 'null';
Bool : 'bool';

LeftParen : '(';
RightParen : ')';
LeftBracket : '[';
RightBracket : ']';
LeftBrace : '{';
RightBrace : '}';

Less : '<';
LessEqual : '<=';
Greater : '>';
GreaterEqual : '>=';
LeftShift : '<<';
RightShift : '>>';

Plus : '+';
PlusPlus : '++';
Minus : '-';
MinusMinus : '--';
Star : '*';
Div : '/';
Mod : '%';

And : '&';
Or : '|';
AndAnd : '&&';
OrOr : '||';
Caret : '^';
Not : '!';
Tilde : '~';

Colon : ':';
Semi : ';';
Comma : ',';

Assign : '=';

Equal : '==';
NotEqual : '!=';

Dot : '.';

Identifier // 622
    :   Nondigitnon
        (   Nondigit
        |   Digit
        )*
    ;

fragment
Nondigitnon
    :   [a-zA-Z]
    ;

fragment
Nondigit // 637
    :   [a-zA-Z_]
    ;

fragment
Digit // 642
    :   [0-9]
    ;

Constant // 657
    :   IntegerConstant
    ;

fragment
IntegerConstant // 665
    :   NonzeroDigit Digit*
    ;

fragment
NonzeroDigit // 698
    :   [1-9]
    ;

DigitSequence // 770
    :   Digit+
    ;

fragment
CChar
    :   ~['\\\r\n]
    |   EscapeSequence
    ;

fragment
EscapeSequence // 816
    :   '\\' ['"?abfnrtv\\]
    ;

StringLiteral // 836
    :   '"' SCharSequence? '"'
    ;

fragment
SCharSequence // 847
    :   SChar+
    ;

fragment
SChar // 851
    :   ~["\\\r\n]
    |   EscapeSequence
    |   '\\\n'  
    |   '\\\r\n' 
    ;

Whitespace
    :   [ \t]+
        -> skip
    ;

Newline
    :   (   '\r' '\n'?
        |   '\n'
        )
        -> skip
    ;

BlockComment
    :   '/*' .*? '*/'
        -> skip
    ;

LineComment
    :   '//' ~[\r\n]*
        -> skip
    ;


