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
Texto=\"[^\"]*\"
Caracter='([^\\'\\n])'
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
string = "String"
system = "System"
out = "out"
print = "print"
println = "println"
PalabraReservada = {abstract} | {assert} | {boolean} | {break} | {byte} | {case} | {catch} | {char} | {class} |
                   {const} | {continue} | {default} | {do} | {double} | {else} | {enum} | {extends} | {false} |
                   {final} | {finally} | {float} | {for} | {goto} | {if} | {implements} | {import} | {instanceof} |
                   {int} | {interface} | {long} | {native} | {new} | {null} | {package} | {private} | {protected} |
                   {public} | {return} | {short} | {static} | {strictfp} | {super} | {switch} | {synchronized} |
                   {this} | {throw} | {throws} | {transient} | {true} | {try} | {void} | {volatile} | {while} | {string}

/* Identificador */
Identificador = {Letra}({Letra}|{Digito})*

/* Número */
Numero ="-"?[0-9]+
NumeroF="-"?[0-9]+(\.[0-9]+)
/* Operadores */
suma = "+"
resta = "-"
multiplicacion = "*"
division = "/"
modulo = "%"
incremento = "++"
decremento = "--"
 OperadorAritmetico = suma | resta | multiplicacion | division | modulo
igual = "=="
menor = "<"
menorIgual = "<="
mayor = ">"
mayorIgual = ">="
notIgual = "!="
OperadorRelacional = {igual} | {notIgual} | {menor} | {menorIgual} | {mayor} | {mayorIgual}
andLogico = "&&"
orLogico = "||"

OperadorLogico = {andLogico} | {orLogico}
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
{abstract}    { return token(yytext(), "ABSTRACT", yyline, yycolumn); }
{assert}      { return token(yytext(), "ASSERT", yyline, yycolumn); }
{boolean}     { return token(yytext(), "BOOLEAN", yyline, yycolumn); }
{break}       { return token(yytext(), "BREAK", yyline, yycolumn); }
{byte}        { return token(yytext(), "BYTE", yyline, yycolumn); }
{case}        { return token(yytext(), "CASE", yyline, yycolumn); }
{catch}       { return token(yytext(), "CATCH", yyline, yycolumn); }
{char}        { return token(yytext(), "CHAR", yyline, yycolumn); }
{class}       { return token(yytext(), "CLASS", yyline, yycolumn); }
{const}       { return token(yytext(), "CONST", yyline, yycolumn); }
{continue}    { return token(yytext(), "CONTINUE", yyline, yycolumn); }
{default}     { return token(yytext(), "DEFAULT", yyline, yycolumn); }
{do}          { return token(yytext(), "DO", yyline, yycolumn); }
{double}      { return token(yytext(), "DOUBLE", yyline, yycolumn); }
{else}        { return token(yytext(), "ELSE", yyline, yycolumn); }
{enum}        { return token(yytext(), "ENUM", yyline, yycolumn); }
{extends}     { return token(yytext(), "EXTENDS", yyline, yycolumn); }
{false}       { return token(yytext(), "FALSE", yyline, yycolumn); }
{final}       { return token(yytext(), "FINAL", yyline, yycolumn); }
{finally}     { return token(yytext(), "FINALLY", yyline, yycolumn); }
{float}       { return token(yytext(), "FLOAT", yyline, yycolumn); }
{for}         { return token(yytext(), "FOR", yyline, yycolumn); }
{goto}        { return token(yytext(), "GOTO", yyline, yycolumn); }
{if}          { return token(yytext(), "IF", yyline, yycolumn); }
{implements}  { return token(yytext(), "IMPLEMENTS", yyline, yycolumn); }
{import}      { return token(yytext(), "IMPORT", yyline, yycolumn); }
{instanceof}  { return token(yytext(), "INSTANCEOF", yyline, yycolumn); }
{int}         { return token(yytext(), "INT", yyline, yycolumn); }
{interface}   { return token(yytext(), "INTERFACE", yyline, yycolumn); }
{long}        { return token(yytext(), "LONG", yyline, yycolumn); }
{native}      { return token(yytext(), "NATIVE", yyline, yycolumn); }
{new}         { return token(yytext(), "NEW", yyline, yycolumn); }
{null}        { return token(yytext(), "NULL", yyline, yycolumn); }
{package}     { return token(yytext(), "PACKAGE", yyline, yycolumn); }
{private}     { return token(yytext(), "PRIVATE", yyline, yycolumn); }
{protected}   { return token(yytext(), "PROTECTED", yyline, yycolumn); }
{public}      { return token(yytext(), "PUBLIC", yyline, yycolumn); }
{return}      { return token(yytext(), "RETURN", yyline, yycolumn); }
{short}       { return token(yytext(), "SHORT", yyline, yycolumn); }
{static}      { return token(yytext(), "STATIC", yyline, yycolumn); }
{strictfp}    { return token(yytext(), "STRICTFP", yyline, yycolumn); }
{string}    { return token(yytext(), "STRING", yyline, yycolumn); }
{super}       { return token(yytext(), "SUPER", yyline, yycolumn); }
{switch}      { return token(yytext(), "SWITCH", yyline, yycolumn); }
{synchronized} { return token(yytext(), "SYNCHRONIZED", yyline, yycolumn); }
{this}        { return token(yytext(), "THIS", yyline, yycolumn); }
{throw}       { return token(yytext(), "THROW", yyline, yycolumn); }
{throws}      { return token(yytext(), "THROWS", yyline, yycolumn); }
{transient}   { return token(yytext(), "TRANSIENT", yyline, yycolumn); }
{true}        { return token(yytext(), "TRUE", yyline, yycolumn); }
{try}         { return token(yytext(), "TRY", yyline, yycolumn); }
{void}        { return token(yytext(), "VOID", yyline, yycolumn); }
{volatile}    { return token(yytext(), "VOLATILE", yyline, yycolumn); }
{while}       { return token(yytext(), "WHILE", yyline, yycolumn); }
{system}       { return token(yytext(), "SYSTEM", yyline, yycolumn); }
{out}       { return token(yytext(), "OUT", yyline, yycolumn); }
{println}       { return token(yytext(), "PRINTLN", yyline, yycolumn); }
{print}       { return token(yytext(), "PRINT", yyline, yycolumn); }

/* Identificadores */
{Identificador} { return token(yytext(), "IDENTIFICADOR", yyline, yycolumn); }

/* Números */
{Numero} { return token(yytext(), "NUMERO", yyline, yycolumn); }
{NumeroF} { return token(yytext(), "NUMERODECIMAL", yyline, yycolumn); }
/* Operadores */
{suma}            { return token(yytext(), "SUMA", yyline, yycolumn); }
{resta}           { return token(yytext(), "RESTA", yyline, yycolumn); }
{multiplicacion}  { return token(yytext(), "MULTIPLICACION", yyline, yycolumn); }
{division}        { return token(yytext(), "DIVISION", yyline, yycolumn); }
{modulo}          { return token(yytext(), "MODULO", yyline, yycolumn); }
{incremento}      { return token(yytext(), "INCREMENTO", yyline, yycolumn); }
{decremento}      { return token(yytext(), "DECREMENTO", yyline, yycolumn); }

{OperadorAritmetico} { return token(yytext(), "OPERADORARITMETICO", yyline, yycolumn); }

{igual}        { return token(yytext(), "IGUAL", yyline, yycolumn); }
{notIgual}    { return token(yytext(), "NOTIGUAL", yyline, yycolumn); }
{menor}        { return token(yytext(), "MENOR", yyline, yycolumn); }
{menorIgual}   { return token(yytext(), "MENORIGUAL", yyline, yycolumn); }
{mayor}        { return token(yytext(), "MAYOR", yyline, yycolumn); }
{mayorIgual}   { return token(yytext(), "MAYORIGUAL", yyline, yycolumn); }

{OperadorRelacional} { return token(yytext(), "OPERADORRELACIONAL", yyline, yycolumn); }

{andLogico}    { return token(yytext(), "AND", yyline, yycolumn); }
{orLogico}     { return token(yytext(), "OR", yyline, yycolumn); }


{OperadorLogico} { return token(yytext(), "OPERADORLOGICO", yyline, yycolumn); }

{asignacionSimple}          { return token(yytext(), "ASIGNACIONSIMPLE", yyline, yycolumn); }
{asignacionSuma}            { return token(yytext(), "ASIGNACIONSUMA", yyline, yycolumn); }
{asignacionResta}           { return token(yytext(), "ASIGNACIONRESTA", yyline, yycolumn); }
{asignacionMultiplicacion}   { return token(yytext(), "ASIGNACIONMULTIPLICACION", yyline, yycolumn); }
{asignacionDivision}        { return token(yytext(), "ASIGNACIONDIVISION", yyline, yycolumn); }
{asignacionModulo}          { return token(yytext(), "ASIGNACIONMODULO", yyline, yycolumn); }

{OperadorAsignacion} { return token(yytext(), "OPERADORASIGNACION", yyline, yycolumn); }

/* Delimitadores */
{puntoComa}          { return token(yytext(), "PUNTOCOMA", yyline, yycolumn); }
{coma}               { return token(yytext(), "COMA", yyline, yycolumn); }
{punto}              { return token(yytext(), "PUNTO", yyline, yycolumn); }
{parentesisApertura} { return token(yytext(), "PARENTESISAPERTURA", yyline, yycolumn); }
{parentesisCierre}   { return token(yytext(), "PARENTESISCIERRE", yyline, yycolumn); }
{llaveApertura}      { return token(yytext(), "LLAVEAPERTURA", yyline, yycolumn); }
{llaveCierre}        { return token(yytext(), "LLAVECIERRE", yyline, yycolumn); }
{corcheteApertura}   { return token(yytext(), "CORCHETEAPERTURA", yyline, yycolumn); }
{corcheteCierre}     { return token(yytext(), "CORCHETECIERRE", yyline, yycolumn); }

{Delimitador} { return token(yytext(), "DELIMITADOR", yyline, yycolumn); }

{Texto} { return token(yytext(), "TEXTO", yyline, yycolumn); }
{Caracter} { return token(yytext(), "CARACTER", yyline, yycolumn); }
/* Errores */
. { return token(yytext(), "ERROR", yyline, yycolumn); }
