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

/* Palabras clave de Java */
PalabraClave = "abstract"|"assert"|"boolean"|"break"|"byte"|"case"|"catch"|"char"|"class"|
               "const"|"continue"|"default"|"do"|"double"|"else"|"enum"|"extends"|"false"|
               "final"|"finally"|"float"|"for"|"goto"|"if"|"implements"|"import"|"instanceof"|
               "int"|"interface"|"long"|"native"|"new"|"null"|"package"|"private"|"protected"|
               "public"|"return"|"short"|"static"|"strictfp"|"super"|"switch"|"synchronized"|
               "this"|"throw"|"throws"|"transient"|"true"|"try"|"void"|"volatile"|"while"

/* Identificador */
Identificador = {Letra}({Letra}|{Digito})*

/* Número */
Numero = [0-9]+(\.[0-9]+)?([eE][-+]?[0-9]+)?

/* Operadores */
OperadorAritmetico = "+"|"-"|"*"|"/"|"%"|"++"|"--"
OperadorRelacional = "=="|"!="|"<"|"<="|">"|">="
OperadorLogico = "&&"|"||"|"!"
OperadorAsignacion = "="|"+="|"-="|"*="|"/="|"%="

/* Comentarios */
ComentarioLinea = "//"[^\\n]*
ComentarioMultilinea = "/\\*([^*]|(\\*+[^/]))*\\*+/"

/* Delimitadores */
Delimitador = ";"|","|"."|"(" | ")" | "{" | "}" | "[" | "]"

%%

/* Espacios en blanco y comentarios */
{EspacioEnBlanco} { /* Ignorar */ }
{ComentarioLinea}  { /* Ignorar comentarios de una línea */ }
{ComentarioMultilinea} { /* Ignorar comentarios de múltiples líneas */ }

/* Palabras clave */
{PalabraClave} { return token(yytext(), "PALABRA_CLAVE", yyline, yycolumn); }

/* Identificadores */
{Identificador} { return token(yytext(), "IDENTIFICADOR", yyline, yycolumn); }

/* Números */
{Numero} { return token(yytext(), "NUMERO", yyline, yycolumn); }

/* Operadores */
{OperadorAritmetico} { return token(yytext(), "OPERADOR_ARITMETICO", yyline, yycolumn); }
{OperadorRelacional} { return token(yytext(), "OPERADOR_RELACIONAL", yyline, yycolumn); }
{OperadorLogico} { return token(yytext(), "OPERADOR_LOGICO", yyline, yycolumn); }
{OperadorAsignacion} { return token(yytext(), "OPERADOR_ASIGNACION", yyline, yycolumn); }

/* Delimitadores */
{Delimitador} { return token(yytext(), "DELIMITADOR", yyline, yycolumn); }

/* Errores */
. { return token(yytext(), "ERROR", yyline, yycolumn); }
