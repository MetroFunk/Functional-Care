grammar FunctionalCare;

func
	: (mainFunc | def | cons)* EOF
	;

mainFunc
	: LPAREN 'main' LPAREN RPAREN call RPAREN;

call
	: LPAREN expr RPAREN
	;

cons:
	LPAREN 'const' ID returnFunct call RPAREN;

def
	: LPAREN 'def' LPAREN nombreFuncion LPAREN params RPAREN returnFunct RPAREN call RPAREN;

nombreFuncion
	:ID;

params
	:(param(',')?)*;

param
	: ID':'datatypes
	;

args
	: (atom|call)
	;

returnFunct:
	| 'int'
	| 'bool'
	| 'null'
	| 'parInt'
	| 'parBool'
	| 'funcion'
	;

expr
	: operatorsdos args args
	| operatorsuno args
	| operatorstres args args args
	| parfuntions1 args
	| parfuntions2 args args
	| funcionUsuario (args)*
	;

funcionUsuario
	: ID;

atom
	: atomnum |atomid | atombool| atomnull
	;

atomnum: NUMBER;
atomid: ID;
atombool: BOOL;
atomnull: 'null';

parfuntions1: (parintfunc1 | parboolfunc1) ;

parfuntions2: (parintfunc2 | parboolfunc2) ;

datatypes : (DATATYPEINT | DATATYPEBOOL | DATATYPENULL | DATATYPEPARINT | DATATYPEPARBOOL| DATATYPEFUNC);

DATATYPEINT:'int';
DATATYPEBOOL:'bool';
DATATYPENULL:'null';
DATATYPEPARINT:'parInt';
DATATYPEPARBOOL:'parBool';
DATATYPEFUNC:'funcion';

BOOL
    : 'true'
    | 'false'
    ;

ID
	: ('a'..'z'|'A'..'Z'|'_')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*
	;

NUMBER
	: ('-')? (DIGIT)+
	;

operatorsdos
	: (intop | logicoparity2 | relationalop);

operatorsuno
	: logicoparity1;

operatorstres
	: logicoparity3;

intop: ('+' | '-' | '*' | '/' | '%') ;

relationalop:('<' | '>' | '<=' | '>=' | '==' | '!=');

logicoparity2:('and' | 'or');

logicoparity1: 'not';

logicoparity3: 'if';

parintfunc2
	: 'crearParInt'
	| 'appendParInt';

parintfunc1
	: 'firstParInt'
	| 'lastParInt';

parboolfunc2
	: 'crearParBool'
	| 'appendParBool';

parboolfunc1
	: 'firstParBool'
	| 'lastParBool';

WS
	: ( ' '
	| '\t'
	| '\r'
	| '\n'
	)
	-> skip
	;

COMMENTS
	: '~'(.)*?'~'
	-> skip
	;

LPAREN : '(';
RPAREN : ')';

fragment
DIGIT
	: ('0'..'9')
	;
