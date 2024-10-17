import compilerTools.Token;

%%
%class Lexer
%type Token
%line
%column
%{
    private Token token(String lexeme, String lexicalComp, int line, int column){
        return new Token(lexeme, lexicalComp, line+1, column+1);
    }
%}

/* Definiciones básicas */
TerminadorDeLinea = \r|\n|\r\n
EspacioEnBlanco = {TerminadorDeLinea} | [ \t\f]
Letra = [A-Za-z_]
Digito = [0-9]

/* Palabras reservadas de Java */

abstract = "abstract"
assert = "assert"
boolean = "boolean"
break = "break"
byte = "byte"
case = "case"
catch = "catch"
char = "char"
class = "class"
const = "const"
continue = "continue"
default = "default"
do = "do"
double = "double"
else = "else"
enum = "enum"
extends = "extends"
false = "false"
final = "final"
finally = "finally"
float = "float"
for = "for"
goto = "goto"
if = "if"
implements = "implements"
import = "import"
instanceof = "instanceof"
int = "int"
interface = "interface"
long = "long"
native = "native"
new = "new"
null = "null"
package = "package"
private = "private"
protected = "protected"
public = "public"
return = "return"
short = "short"
static = "static"
strictfp = "strictfp"
super = "super"
switch = "switch"
synchronized = "synchronized"
this = "this"
throw = "throw"
throws = "throws"
transient = "transient"
true = "true"
try = "try"
void = "void"
volatile = "volatile"
while = "while"

PalabraReservada = {abstract} | {assert} | {boolean} | {break} | {byte} | {case} | {catch} | {char} | {class} |
                   {const} | {continue} | {default} | {do} | {double} | {else} | {enum} | {extends} | {false} |
                   {final} | {finally} | {float} | {for} | {goto} | {if} | {implements} | {import} | {instanceof} |
                   {int} | {interface} | {long} | {native} | {new} | {null} | {package} | {private} | {protected} |
                   {public} | {return} | {short} | {static} | {strictfp} | {super} | {switch} | {synchronized} |
                   {this} | {throw} | {throws} | {transient} | {true} | {try} | {void} | {volatile} | {while}

/* Identificador */
Identificador = {Letra}({Letra}|{Digito})*

/* Número */
Numero = [0-9]+(\.[0-9]+)?([eE][-+]?[0-9]+)?

/* Operadores */
suma = "+"
resta = "-"
multiplicacion = "*"
division = "/"
modulo = "%"
incremento = "++"
decremento = "--"
OperadorAritmetico = {suma} | {resta} | {multiplicacion} | {division} | {modulo} | {incremento} | {decremento}
igual = "=="
diferente = "!="
menor = "<"
menorIgual = "<="
mayor = ">"
mayorIgual = ">="
OperadorRelacional = {igual} | {diferente} | {menor} | {menorIgual} | {mayor} | {mayorIgual}
andLogico = "&&"
orLogico = "||"
notIgual = "!="
OperadorLogico = {andLogico} | {orLogico} | {notIgual}
asignacionSimple = "="
asignacionSuma = "+="
asignacionResta = "-="
asignacionMultiplicacion = "*="
asignacionDivision = "/="
asignacionModulo = "%="
OperadorAsignacion = {asignacionSimple} | {asignacionSuma} | {asignacionResta} | {asignacionMultiplicacion} | {asignacionDivision} | {asignacionModulo}


/* Comentarios */
ComentarioLinea = "//"[^\\n]*
ComentarioMultilinea = "/\\*([^*]|(\\*+[^/]))*\\*+/"

/* Delimitadores */
puntoComa = ";"
coma = ","
punto = "."
parentesisApertura = "("
parentesisCierre = ")"
llaveApertura = "{"
llaveCierre = "}"
corcheteApertura = "["
corcheteCierre = "]"

Delimitador = {puntoComa} | {coma} | {punto} | {parentesisApertura} | {parentesisCierre} | {llaveApertura} | {llaveCierre} | {corcheteApertura} | {corcheteCierre}


%%

/* Espacios en blanco y comentarios */
{EspacioEnBlanco} { /* Ignorar */ }
{ComentarioLinea}  { /* Ignorar comentarios de una línea */ }
{ComentarioMultilinea} { /* Ignorar comentarios de múltiples líneas */ }

/* Palabras reservadas */
{abstract}    { return token(yytext(), "PALABRA_RESERVADA:ABSTRACT", yyline, yycolumn); }
{assert}      { return token(yytext(), "PALABRA_RESERVADA:ASSERT", yyline, yycolumn); }
{boolean}     { return token(yytext(), "PALABRA_RESERVADA:BOOLEAN", yyline, yycolumn); }
{break}       { return token(yytext(), "PALABRA_RESERVADA:BREAK", yyline, yycolumn); }
{byte}        { return token(yytext(), "PALABRA_RESERVADA:BYTE", yyline, yycolumn); }
{case}        { return token(yytext(), "PALABRA_RESERVADA:CASE", yyline, yycolumn); }
{catch}       { return token(yytext(), "PALABRA_RESERVADA:CATCH", yyline, yycolumn); }
{char}        { return token(yytext(), "PALABRA_RESERVADA:CHAR", yyline, yycolumn); }
{class}       { return token(yytext(), "PALABRA_RESERVADA:CLASS", yyline, yycolumn); }
{const}       { return token(yytext(), "PALABRA_RESERVADA:CONST", yyline, yycolumn); }
{continue}    { return token(yytext(), "PALABRA_RESERVADA:CONTINUE", yyline, yycolumn); }
{default}     { return token(yytext(), "PALABRA_RESERVADA:DEFAULT", yyline, yycolumn); }
{do}          { return token(yytext(), "PALABRA_RESERVADA:DO", yyline, yycolumn); }
{double}      { return token(yytext(), "PALABRA_RESERVADA:DOUBLE", yyline, yycolumn); }
{else}        { return token(yytext(), "PALABRA_RESERVADA:ELSE", yyline, yycolumn); }
{enum}        { return token(yytext(), "PALABRA_RESERVADA:ENUM", yyline, yycolumn); }
{extends}     { return token(yytext(), "PALABRA_RESERVADA:EXTENDS", yyline, yycolumn); }
{false}       { return token(yytext(), "PALABRA_RESERVADA:FALSE", yyline, yycolumn); }
{final}       { return token(yytext(), "PALABRA_RESERVADA:FINAL", yyline, yycolumn); }
{finally}     { return token(yytext(), "PALABRA_RESERVADA:FINALLY", yyline, yycolumn); }
{float}       { return token(yytext(), "PALABRA_RESERVADA:FLOAT", yyline, yycolumn); }
{for}         { return token(yytext(), "PALABRA_RESERVADA:FOR", yyline, yycolumn); }
{goto}        { return token(yytext(), "PALABRA_RESERVADA:GOTO", yyline, yycolumn); }
{if}          { return token(yytext(), "PALABRA_RESERVADA:IF", yyline, yycolumn); }
{implements}  { return token(yytext(), "PALABRA_RESERVADA:IMPLEMENTS", yyline, yycolumn); }
{import}      { return token(yytext(), "PALABRA_RESERVADA:IMPORT", yyline, yycolumn); }
{instanceof}  { return token(yytext(), "PALABRA_RESERVADA:INSTANCEOF", yyline, yycolumn); }
{int}         { return token(yytext(), "PALABRA_RESERVADA:INT", yyline, yycolumn); }
{interface}   { return token(yytext(), "PALABRA_RESERVADA:INTERFACE", yyline, yycolumn); }
{long}        { return token(yytext(), "PALABRA_RESERVADA:LONG", yyline, yycolumn); }
{native}      { return token(yytext(), "PALABRA_RESERVADA:NATIVE", yyline, yycolumn); }
{new}         { return token(yytext(), "PALABRA_RESERVADA:NEW", yyline, yycolumn); }
{null}        { return token(yytext(), "PALABRA_RESERVADA:NULL", yyline, yycolumn); }
{package}     { return token(yytext(), "PALABRA_RESERVADA:PACKAGE", yyline, yycolumn); }
{private}     { return token(yytext(), "PALABRA_RESERVADA:PRIVATE", yyline, yycolumn); }
{protected}   { return token(yytext(), "PALABRA_RESERVADA:PROTECTED", yyline, yycolumn); }
{public}      { return token(yytext(), "PALABRA_RESERVADA:PUBLIC", yyline, yycolumn); }
{return}      { return token(yytext(), "PALABRA_RESERVADA:RETURN", yyline, yycolumn); }
{short}       { return token(yytext(), "PALABRA_RESERVADA:SHORT", yyline, yycolumn); }
{static}      { return token(yytext(), "PALABRA_RESERVADA:STATIC", yyline, yycolumn); }
{strictfp}    { return token(yytext(), "PALABRA_RESERVADA:STRICTFP", yyline, yycolumn); }
{super}       { return token(yytext(), "PALABRA_RESERVADA:SUPER", yyline, yycolumn); }
{switch}      { return token(yytext(), "PALABRA_RESERVADA:SWITCH", yyline, yycolumn); }
{synchronized} { return token(yytext(), "PALABRA_RESERVADA:SYNCHRONIZED", yyline, yycolumn); }
{this}        { return token(yytext(), "PALABRA_RESERVADA:THIS", yyline, yycolumn); }
{throw}       { return token(yytext(), "PALABRA_RESERVADA:THROW", yyline, yycolumn); }
{throws}      { return token(yytext(), "PALABRA_RESERVADA:THROWS", yyline, yycolumn); }
{transient}   { return token(yytext(), "PALABRA_RESERVADA:TRANSIENT", yyline, yycolumn); }
{true}        { return token(yytext(), "PALABRA_RESERVADA:TRUE", yyline, yycolumn); }
{try}         { return token(yytext(), "PALABRA_RESERVADA:TRY", yyline, yycolumn); }
{void}        { return token(yytext(), "PALABRA_RESERVADA:VOID", yyline, yycolumn); }
{volatile}    { return token(yytext(), "PALABRA_RESERVADA:VOLATILE", yyline, yycolumn); }
{while}       { return token(yytext(), "PALABRA_RESERVADA:WHILE", yyline, yycolumn); }
/* Identificadores */
{Identificador} { return token(yytext(), "IDENTIFICADOR", yyline, yycolumn); }

/* Números */
{Numero} { return token(yytext(), "NUMERO", yyline, yycolumn); }

/* Operadores */
{suma}            { return token(yytext(), "OPERADOR_ARITMETICO:SUMA", yyline, yycolumn); }
{resta}           { return token(yytext(), "OPERADOR_ARITMETICO:RESTA", yyline, yycolumn); }
{multiplicacion}  { return token(yytext(), "OPERADOR_ARITMETICO:MULTIPLICACION", yyline, yycolumn); }
{division}        { return token(yytext(), "OPERADOR_ARITMETICO:DIVISION", yyline, yycolumn); }
{modulo}          { return token(yytext(), "OPERADOR_ARITMETICO:MODULO", yyline, yycolumn); }
{incremento}      { return token(yytext(), "OPERADOR_ARITMETICO:INCREMENTO", yyline, yycolumn); }
{decremento}      { return token(yytext(), "OPERADOR_ARITMETICO:DECREMENTO", yyline, yycolumn); }

{OperadorAritmetico} { return token(yytext(), "OPERADOR_ARITMETICO", yyline, yycolumn); }

{igual}        { return token(yytext(), "OPERADOR_RELACIONAL:IGUAL", yyline, yycolumn); }
{diferente}    { return token(yytext(), "OPERADOR_RELACIONAL:DIFERENTE", yyline, yycolumn); }
{menor}        { return token(yytext(), "OPERADOR_RELACIONAL:MENOR", yyline, yycolumn); }
{menorIgual}   { return token(yytext(), "OPERADOR_RELACIONAL:MENOR_IGUAL", yyline, yycolumn); }
{mayor}        { return token(yytext(), "OPERADOR_RELACIONAL:MAYOR", yyline, yycolumn); }
{mayorIgual}   { return token(yytext(), "OPERADOR_RELACIONAL:MAYOR_IGUAL", yyline, yycolumn); }

{OperadorRelacional} { return token(yytext(), "OPERADOR_RELACIONAL", yyline, yycolumn); }

{andLogico}    { return token(yytext(), "OPERADOR_LOGICO:AND", yyline, yycolumn); }
{orLogico}     { return token(yytext(), "OPERADOR_LOGICO:OR", yyline, yycolumn); }
{notIgual}     { return token(yytext(), "OPERADOR_LOGICO:NOT_IGUAL", yyline, yycolumn); }

{OperadorLogico} { return token(yytext(), "OPERADOR_LOGICO", yyline, yycolumn); }

{asignacionSimple}          { return token(yytext(), "OPERADOR_ASIGNACION:ASIGNACION_SIMPLE", yyline, yycolumn); }
{asignacionSuma}            { return token(yytext(), "OPERADOR_ASIGNACION:ASIGNACION_SUMA", yyline, yycolumn); }
{asignacionResta}           { return token(yytext(), "OPERADOR_ASIGNACION:ASIGNACION_RESTA", yyline, yycolumn); }
{asignacionMultiplicacion}   { return token(yytext(), "OPERADOR_ASIGNACION:ASIGNACION_MULTIPLICACION", yyline, yycolumn); }
{asignacionDivision}        { return token(yytext(), "OPERADOR_ASIGNACION:ASIGNACION_DIVISION", yyline, yycolumn); }
{asignacionModulo}          { return token(yytext(), "OPERADOR_ASIGNACION:ASIGNACION_MODULO", yyline, yycolumn); }

{OperadorAsignacion} { return token(yytext(), "OPERADOR_ASIGNACION", yyline, yycolumn); }

/* Delimitadores */
{puntoComa}          { return token(yytext(), "DELIMITADOR:PUNTO_COMA", yyline, yycolumn); }
{coma}               { return token(yytext(), "DELIMITADOR:COMA", yyline, yycolumn); }
{punto}              { return token(yytext(), "DELIMITADOR:PUNTO", yyline, yycolumn); }
{parentesisApertura} { return token(yytext(), "DELIMITADOR:PARENTESIS_APERTURA", yyline, yycolumn); }
{parentesisCierre}   { return token(yytext(), "DELIMITADOR:PARENTESIS_CIERRE", yyline, yycolumn); }
{llaveApertura}      { return token(yytext(), "DELIMITADOR:LLAVE_APERTURA", yyline, yycolumn); }
{llaveCierre}        { return token(yytext(), "DELIMITADOR:LLAVE_CIERRE", yyline, yycolumn); }
{corcheteApertura}   { return token(yytext(), "DELIMITADOR:CORCHETE_APERTURA", yyline, yycolumn); }
{corcheteCierre}     { return token(yytext(), "DELIMITADOR:CORCHETE_CIERRE", yyline, yycolumn); }

{Delimitador} { return token(yytext(), "DELIMITADOR", yyline, yycolumn); }

/* Errores */
. { return token(yytext(), "ERROR", yyline, yycolumn); }
