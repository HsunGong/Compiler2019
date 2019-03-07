grammar LMx;

primaryExpression // 3
    :   'this'
    |   'true'
    |   'false'
    |   'null'
    |   Identifier
    |   Constant
    |   StringLiteral
    |   '(' expression ')'
    ;

declarationSpecifier // 16
    :   typeSpecifier                   #declarationSpecifier_type
    |   declarationSpecifier '[' ']'    #declarationSpecifier_array
    ;

postfixExpression // 28
    :   primaryExpression                                   #postfixExpression_primary
    |   postfixExpression '[' expression ']'                #postfixExpression_array
    |   postfixExpression '(' argumentExpressionList? ')'   #postfixExpression_func
    |   postfixExpression '.' Identifier                    #postfixExpression_class
    |   postfixExpression '++'                              #postfixExpression_inc
    |   postfixExpression '--'                              #postfixExpression_dec
    ;

argumentExpressionList // 42
    :   expression                                          #argumentExpressionList_single
    |   argumentExpressionList ',' expression               #argumentExpressionList_multi
    ;

unaryExpression // 47
    :   postfixExpression               #unaryExpression_postfix
    |   '++' unaryExpression            #unaryExpression_prefix_inc
    |   '--' unaryExpression            #unaryExpression_prefix_dec
    |   unaryOperator castExpression    #unaryExpression_prefix
    ;

unaryOperator // 58
    :   '+' | '-' | '~' | '!'
    ;

castExpression // 62
    :   unaryExpression
    |   DigitSequence
    ;

multiplicativeExpression // 69
    :   castExpression                                      #multiplicativeExpression_unary
    |   multiplicativeExpression '*' castExpression         #multiplicativeExpression_mul
    |   multiplicativeExpression '/' castExpression         #multiplicativeExpression_div
    |   multiplicativeExpression '%' castExpression         #multiplicativeExpression_mod
    ;

additiveExpression // 76
    :   multiplicativeExpression                            #additiveExpression_unary                    
    |   additiveExpression '+' multiplicativeExpression     #additiveExpression_add         
    |   additiveExpression '-' multiplicativeExpression     #additiveExpression_sub           
    ;

shiftExpression // 82
    :   additiveExpression                                  #shiftExpression_unary
    |   shiftExpression '<<' additiveExpression             #shiftExpression_shl
    |   shiftExpression '>>' additiveExpression             #shiftExpression_shr
    ;

relationalExpression // 88
    :   shiftExpression                                     #relationalExpression_unary
    |   relationalExpression '<' shiftExpression            #relationalExpression_le
    |   relationalExpression '>' shiftExpression            #relationalExpression_ge
    |   relationalExpression '<=' shiftExpression           #relationalExpression_leq
    |   relationalExpression '>=' shiftExpression           #relationalExpression_geq
    ;

equalityExpression // 96
    :   relationalExpression                                #equalityExpression_unary
    |   equalityExpression '==' relationalExpression        #equalityExpression_equal
    |   equalityExpression '!=' relationalExpression        #equalityExpression_inequal
    ;

andExpression // 102
    :   equalityExpression                                  #andExpression_unary
    |   andExpression '&' equalityExpression                #andExpression_binary
    ;

exclusiveOrExpression // 107
    :   andExpression                                       #exclusiveOrExpression_unary
    |   exclusiveOrExpression '^' andExpression             #exclusiveOrExpression_binary
    ;

inclusiveOrExpression // 112
    :   exclusiveOrExpression                               #inclusiveOrExpression_unary
    |   inclusiveOrExpression '|' exclusiveOrExpression     #inclusiveOrExpression_binary
    ;

logicalAndExpression // 117
    :   inclusiveOrExpression                               #logicalAndExpression_unary
    |   logicalAndExpression '&&' inclusiveOrExpression     #logicalAndExpression_binary
    ;

logicalOrExpression // 122
    :   logicalAndExpression                                #logicalOrExpression_unary
    |   logicalOrExpression '||' logicalAndExpression       #logicalOrExpression_binary
    ;

expression // 141
    :   newDeclarator
    |   logicalOrExpression
    |   unaryExpression '=' expression
    |   DigitSequence
    ;

declaration // 150
    :   declarationSpecifier initDeclaratorList ';'     #declaration_init
	| 	declarationSpecifier ';'                        #declaration_none
    ;

initDeclaratorList // 172
    :   initDeclarator                                  #initDeclaratorList_single
    |   initDeclaratorList ',' initDeclarator           #initDeclaratorList_multi
    ;

initDeclarator // 177
    :   directDeclarator                                #initDeclarator_none
    |   directDeclarator '=' expression                 #initDeclarator_init
    ;

typeSpecifier // 191
    :   ('void'
    |   'int'
    |   'string'
    |   'bool')
    |   typedefName
    ; 

newDeclarator // 
    :   'new' typeSpecifier ('[' expression ']')+ ('[' ']')+ ('[' expression ']')+      #newDeclarator_error
    |   'new' typeSpecifier ('[' expression ']')+ ( LeftBracket ']')*                   #newDeclarator_array
    |   'new' typeSpecifier ( LeftParen ')' )?                                          #newDeclarator_nonarray
    ; 

directDeclarator // 299
    :   Identifier                                  #directDeclarator_Identifier
    |   '(' directDeclarator ')'                    #directDeclarator_recycle
    |   directDeclarator '(' parameterList? ')'     #directDeclarator_with_parameterList
    ;

parameterList // 355
    :   parameterDeclaration                        #parameterList_single
    |   parameterList ',' parameterDeclaration      #parameterList_multi
    ;

parameterDeclaration // 360
    :   declarationSpecifier directDeclarator
    ;

statement // 426
    :   compoundStatement
    |   expressionStatement
    |   selectionStatement
    |   iterationStatement
    |   jumpStatement
    ;

compoundStatement // 442
    :   '{' blockItem* '}'
    ;

blockItem // 451
    :   statement
    |   declaration
    ;

expressionStatement // 456
    :   expression? ';'
    ;

selectionStatement // 460
    :   'if' '(' expression ')' statement ('else' statement)?
    ;

iterationStatement // 465
    :   While '(' expression ')' statement              #iterationStatement_while
    |   For '(' forCondition ')' statement              #iterationStatement_for
    ;

forCondition // 474
	:   forDeclaration ';' forExprEnd? ';' forExprUpdate?    #forCondition_init
	|   expression? ';' forExprEnd? ';' forExprUpdate?       #forCondition_none
	;

forDeclaration // 479
    :   declarationSpecifier initDeclaratorList         #forDeclaration_init
	| 	declarationSpecifier                            #forDeclaration_none
    ;

forExprEnd
    :   expression
    ;

forExprUpdate
    :   expression
    ;

jumpStatement // 489
    :   'continue' ';'                  #jumpStatement_continue
    |   'break' ';'                     #jumpStatement_break
    |   'return' expression? ';'        #jumpStatement_return
    ;

// program // 497
//     :   programDeclaration* EOF
//     ;

// programDeclaration // 506
//     :   functionDefinition
//     |   classDefinition
//     |   declaration
//     |   ';'
//     ;

functionDefinition // 512
    :   declarationSpecifier? directDeclarator compoundStatement
    ;

classDefinition // 
    :   'class' Identifier? '{' classDeclaration* '}'           #classDeclaration_decl
    |   'class' Identifier                                      #classDeclaration_none
    ;

classDeclaration // 
    :   declaration
    |   functionDefinition
    ;

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

