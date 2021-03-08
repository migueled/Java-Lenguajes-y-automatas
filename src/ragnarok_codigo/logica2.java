/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ragnarok_codigo;

import java.util.StringTokenizer;
import javax.swing.table.DefaultTableModel;

public class logica2 {

    public static final String Eliminar_comentarios = "\\[\\{(\\s|.)*\\}\\]";
    public static final String Variable = "[a-zA-Z]*";
    public static final String Entero = "([0-9])*"; //"\\d[\\d]*(.?\\d+)?"; 
    public static final String Decimal = "([0-9]*[.][0-9]*)";//"\\d+(,\\d+)?";
    public static final String Separador = "\t\n\r\b\f+-*/:=;\"{}()[]<>|& ";
    public static final String palabras = "|programa|inicio|verdadero|falso|entero|decimal|texto|boleano|si|sino|no|leer|imprimirln|imprimir|para|mientras|hacer|arreglo|cambios|caso|defecto|romper|";
    String token_almacenador = "", token_analizado = "";
    int numero_almacenador = 0, fila = 0;

    public String Eliminar_comentarios(String variableA) {
        variableA = variableA.replaceAll(Eliminar_comentarios, "");
        variableA = variableA.replaceAll("\n", "");
        return variableA;
    }//no modificar elimina los comentarios

    public StringTokenizer obtener_tokens(String variableA, StringTokenizer token) {
        token = new StringTokenizer(variableA, Separador, true);
        return token;
    }//obtiene los tokens no modificar

    public String almacenar(DefaultTableModel modelo, int filas) {
        fila = filas;
        return imprimir(token_almacenador, numero_almacenador, modelo);
    }//almacena la variable si el token anterior es un + o un -

    public String token(StringTokenizer token, DefaultTableModel modelo, int filas) {
        String tokn = "", tkn2 = "";
        int x = 0;
        int y = 0;
        fila = filas;
        tokn = token.nextToken();
        if (tokn.matches("|\\s|")) {
            return "nulo";
        } else {
            tkn2 = tokn;
            while (x < 100) {
                x = transicion(x, y, tokn);
                //codigo nuevo
                if (x == 1 || x == 2) {
                    y = x;
                    String temporal = token.nextToken();
                    int x2 = 0;
                    x2 = transicion(x2, 0, temporal);
                    if (x2 == 210 || x2 == 211 || x2 == 212 || x2 == 213) {
                        x = x2;
                        if (tokn.equals("+")) {
                            x2 = 101;
                        } else if (tokn.equals("-")) {
                            x2 = 102;
                        }
                        token_almacenador = temporal;
                        numero_almacenador = x;
                        return imprimir(tkn2, x2, modelo);

                    } else {
                        tkn2 += temporal;
                        x = transicion(0, y, temporal);
                    }

                }
                //termina codigo nuevo
                if (x < 100) {
                    tokn = token.nextToken();
                    tkn2 += tokn;
                    y = x;
                }
            }
        }
        return imprimir(tkn2, x, modelo);
    }//recive el lexema y devuelve que token es 

    public String imprimir(String tkn2, int x, DefaultTableModel modelo) {
        String almacenar = "";
        token_analizado = tkn2;
        modelo.addRow(new Object[fila]);
        switch (x) {
            case 101:
                modelo.setValueAt("SIMBOLO SUMA[+]", fila, 0);
                modelo.setValueAt(tkn2, fila, 1);
                almacenar = "+";
                break;
            case 102:
                modelo.setValueAt("SIMBOLO RESTA[-]", fila, 0);
                modelo.setValueAt(tkn2, fila, 1);
                almacenar = "-";
                break;
            case 103:
                modelo.setValueAt("SIMBOLO MULTIPLICACION[*]", fila, 0);
                modelo.setValueAt(tkn2, fila, 1);
                almacenar = "*";
                break;
            case 104:
                modelo.setValueAt("SIMBOLO DIVISION[/]", fila, 0);
                modelo.setValueAt(tkn2, fila, 1);
                almacenar = "/";
                break;
            case 105:
                modelo.setValueAt("SIMBOLO POTENCIA[^]", fila, 0);
                modelo.setValueAt(tkn2, fila, 1);
                almacenar = "^";
                break;
            case 106:
                modelo.setValueAt("SIMBOLO ASIGNACION [:=]", fila, 0);
                modelo.setValueAt(tkn2, fila, 1);
                almacenar = ":=";
                break;
            case 110:
                modelo.setValueAt("SIMBOLO IGUALDAD [==]", fila, 0);
                modelo.setValueAt(tkn2, fila, 1);
                almacenar = "==";
                break;
            case 111:
                modelo.setValueAt("SIMBOLO MAYOR IGUAL [>=]", fila, 0);
                modelo.setValueAt(tkn2, fila, 1);
                almacenar = ">=";
                break;
            case 112:
                modelo.setValueAt("SIMBOLO MENOR IGUAL[<=]", fila, 0);
                modelo.setValueAt(tkn2, fila, 1);
                almacenar = "<=";
                break;
            case 113:
                modelo.setValueAt("SIMBOLO MAYOR [>>]", fila, 0);
                modelo.setValueAt(tkn2, fila, 1);
                almacenar = ">>";
                break;
            case 114:
                modelo.setValueAt("SIMBOLO MENOR[<<]", fila, 0);
                modelo.setValueAt(tkn2, fila, 1);
                almacenar = "<<";
                break;
            case 115:
                modelo.setValueAt("SIMBOLO DIFERENTE[!=]", fila, 0);
                modelo.setValueAt(tkn2, fila, 1);
                almacenar = "!=";
                break;
            case 120:
                modelo.setValueAt("OPERADOR_UNITARIO [++]", fila, 0);
                modelo.setValueAt(tkn2, fila, 1);
                almacenar = "++";
                break;
            case 121:
                modelo.setValueAt("OPERADOR_UNITARIO [--]", fila, 0);
                modelo.setValueAt(tkn2, fila, 1);
                almacenar = "--";
                break;
            case 130:
                modelo.setValueAt("PARENTESIS A[(]", fila, 0);
                modelo.setValueAt(tkn2, fila, 1);
                almacenar = "(";
                break;
            case 131:
                modelo.setValueAt("PARENTESIS C[)]", fila, 0);
                modelo.setValueAt(tkn2, fila, 1);
                almacenar = ")";
                break;
            case 132:
                modelo.setValueAt("CORCHETES A[[]", fila, 0);
                modelo.setValueAt(tkn2, fila, 1);
                almacenar = "[";
                break;
            case 133:
                modelo.setValueAt("CORCHETES C[]]", fila, 0);
                modelo.setValueAt(tkn2, fila, 1);
                almacenar = "]";
                break;
            case 134:
                modelo.setValueAt("LLAVE A[{]", fila, 0);
                modelo.setValueAt(tkn2, fila, 1);
                almacenar = "{";
                break;
            case 135:
                modelo.setValueAt("LLAVE C[}]", fila, 0);
                modelo.setValueAt(tkn2, fila, 1);
                almacenar = "}";
                break;
            case 140:
                modelo.setValueAt("OR[||]", fila, 0);
                modelo.setValueAt(tkn2, fila, 1);
                almacenar = "||";
                break;
            case 141:
                modelo.setValueAt("AND[&&]", fila, 0);
                modelo.setValueAt(tkn2, fila, 1);
                almacenar = "&&";
                break;
            case 142:
                modelo.setValueAt("NEGACION[<>]", fila, 0);
                modelo.setValueAt(tkn2, fila, 1);
                almacenar = "<>";
                break;
            case 150:
                modelo.setValueAt("MODULO[%]", fila, 0);
                modelo.setValueAt(tkn2, fila, 1);
                almacenar = "%";
                break;
            case 160:
                modelo.setValueAt("PUNTO COMA [;]", fila, 0);
                modelo.setValueAt(tkn2, fila, 1);
                almacenar = ";";
                break;
            case 201:
                modelo.setValueAt("PALABRA PROGRAMA", fila, 0);
                modelo.setValueAt(tkn2, fila, 1);
                almacenar = "programa";
                break;
            case 202:
                modelo.setValueAt("PALABRA INICIO", fila, 0);
                modelo.setValueAt(tkn2, fila, 1);
                almacenar = "inicio";
                break;
            case 203:
                modelo.setValueAt("PALABRA VERDADERO", fila, 0);
                modelo.setValueAt(tkn2, fila, 1);
                almacenar = "verdadero";
                break;
            case 204:
                modelo.setValueAt("PALABRA FALSO", fila, 0);
                modelo.setValueAt(tkn2, fila, 1);
                almacenar = "falso";
                break;
            case 205:
                modelo.setValueAt("PALABRA ENTERO", fila, 0);
                modelo.setValueAt(tkn2, fila, 1);
                almacenar = "entero";
                break;
            case 206:
                modelo.setValueAt("PALABRA DECIMAL", fila, 0);
                modelo.setValueAt(tkn2, fila, 1);
                almacenar = "decimal";
                break;
            case 207:
                modelo.setValueAt("PALABRA TEXTO", fila, 0);
                modelo.setValueAt(tkn2, fila, 1);
                almacenar = "texto";
                break;
            case 208:
                modelo.setValueAt("PALABRA BOLEANO", fila, 0);
                modelo.setValueAt(tkn2, fila, 1);
                almacenar = "boleano";
                break;
            case 210:
                modelo.setValueAt("NUMERO DECIMAL", fila, 0);
                modelo.setValueAt(tkn2, fila, 1);
                almacenar = "numero_decimal";
                break;
            case 211:
                modelo.setValueAt("NUMERO ENTERO", fila, 0);
                modelo.setValueAt(tkn2, fila, 1);
                almacenar = "numero_entero";
                break;
            case 212:
                modelo.setValueAt("CADENA", fila, 0);
                modelo.setValueAt(tkn2, fila, 1);
                almacenar = "cadena";
                break;
            case 213:
                modelo.setValueAt("VARIABLE", fila, 0);
                modelo.setValueAt(tkn2, fila, 1);
                almacenar = "variable";
                break;
            case 214:
                modelo.setValueAt("ECS SI", fila, 0);
                modelo.setValueAt(tkn2, fila, 1);
                almacenar = "si";
                break;
            case 215:
                modelo.setValueAt("ECS NO", fila, 0);
                modelo.setValueAt(tkn2, fila, 1);
                almacenar = "no";
                break;
            case 216:
                modelo.setValueAt("ECS SINO", fila, 0);
                modelo.setValueAt(tkn2, fila, 1);
                almacenar = "sino";
                break;
            case 217:
                modelo.setValueAt("IMPRIMIR MSG", fila, 0);
                modelo.setValueAt(tkn2, fila, 1);
                almacenar = "imprimir";
                break;
            case 218:
                modelo.setValueAt("IMPRIMIR MSG SALTO", fila, 0);
                modelo.setValueAt(tkn2, fila, 1);
                almacenar = "imprimirln";
                break;
            case 219:
                modelo.setValueAt("ERC PARA", fila, 0);
                modelo.setValueAt(tkn2, fila, 1);
                almacenar = "para";
                break;
            case 220:
                modelo.setValueAt("ERC MIENTRAS", fila, 0);
                modelo.setValueAt(tkn2, fila, 1);
                almacenar = "mientras";
                break;
            case 221:
                modelo.setValueAt("PALABRA CAMBIOS", fila, 0);
                modelo.setValueAt(tkn2, fila, 1);
                almacenar = "cambios";
                break;
            case 222:
                modelo.setValueAt("PALABRA CASO\t\t", fila, 0);
                modelo.setValueAt(tkn2, fila, 1);
                almacenar = "caso";
                break;
                case 223:
                modelo.setValueAt("PALABRA ROMPER\t\t", fila, 0);
                modelo.setValueAt(tkn2, fila, 1);
                almacenar = "romper";
                break;
            case 226:
                modelo.setValueAt("PALABRA DEFECTO\t\t", fila, 0);
                modelo.setValueAt(tkn2, fila, 1);
                almacenar = "defecto";
                break;
            default:
                modelo.setValueAt("ERROR", fila, 0);
                modelo.setValueAt(tkn2, fila, 1);
                almacenar = "otro";
        }
        return almacenar;
    }//agrega los tokens a la tabla de tokens

    public String token_almacenado() {
        return token_analizado;
    }//almacena el lexema

    public int transicion(int x, int y, String Cadena) {

        if (Cadena.matches(palabras) && y != 7) {
            return palabras_r(Cadena);
        } else if (Cadena.matches(Variable) && y != 7) {
            return 213;
        } else if (Cadena.matches(Entero) && y != 7) {//4
            return 211;
        } else if (Cadena.matches(Decimal) && y != 7) {//5.8
            return 210;
        } else {
            switch (Cadena) {
                case "+":
                    x = 0;
                    break;
                case "-":
                    x = 1;
                    break;
                case "*":
                    x = 2;
                    break;
                case "/":
                    x = 3;
                    break;
                case "^":
                    x = 4;
                    break;
                case ":":
                    x = 5;
                    break;
                case "=":
                    x = 6;
                    break;
                case ">":
                    x = 7;
                    break;
                case "<":
                    x = 8;
                    break;
                case "\"":
                    x = 9;
                    break;
                case "!":
                    x = 10;
                    break;
                case "|":
                    x = 11;
                    break;
                case "&":
                    x = 12;
                    break;
                case ";":
                    x = 13;
                    break;
                case "{":
                    x = 14;
                    break;
                case "}":
                    x = 15;
                    break;
                case "(":
                    x = 16;
                    break;
                case ")":
                    x = 17;
                    break;
                case "[":
                    x = 18;
                    break;
                case "]":
                    x = 19;
                    break;
                case "%":
                    x = 21;
                    break;
                default:
                    x = 20;
                    break;
            }
        }
        return matriz[y][x];
    }

    public int palabras_r(String token) {
        int regresar = 0;
        switch (token) {
            case "programa":
                regresar = 201;
                break;
            case "inicio":
                regresar = 202;
                break;
            case "verdadero":
                regresar = 203;
                break;
            case "falso":
                regresar = 204;
                break;
            case "entero":
                regresar = 205;
                break;
            case "decimal":
                regresar = 206;
                break;
            case "texto":
                regresar = 207;
                break;
            case "boleano":
                regresar = 208;
                break;
            case "si":
                regresar = 214;
                break;
            case "no":
                regresar = 215;
                break;
            case "sino":
                regresar = 216;
                break;
            case "imprimir":
                regresar = 217;
                break;
            case "imprimirln":
                regresar = 218;
                break;
            case "para":
                regresar = 219;
                break;
            case "mientras":
                regresar = 220;
                break;
            case "cambios":
                regresar = 221;
                break;
            case "caso":
                regresar = 222;
                break;
            case "romper":
                regresar = 223;
                break;
            case "defecto":
                regresar = 224;
                break;
            default:
                regresar = 144;
        }
        return regresar;
    }//listo regresa un valor dependiendo la palabra

    public static int matriz[][]
            = //+    -    *    /    ^    :    =    >    <   "    !    |    &     ;   {    }    (    )    [     ]     %     error     
            {{1, 2, 103, 104, 105, 3, 4, 5, 6, 7, 8, 9, 10, 160, 134, 135, 130, 131, 132, 133, 150, 144},//0
            {120, 144, 144, 144, 144, 144, 144, 144, 144, 144, 144, 144, 144, 144, 144, 144, 144, 144, 144, 144, 144, 144},//1
            {144, 121, 144, 144, 144, 144, 144, 144, 144, 144, 144, 144, 144, 144, 144, 144, 144, 144, 144, 144, 144, 144},//2
            {144, 144, 144, 144, 144, 144, 106, 144, 144, 144, 144, 144, 144, 144, 144, 144, 144, 144, 144, 144, 144, 144},//3
            {144, 144, 144, 144, 144, 144, 110, 144, 144, 144, 144, 144, 144, 144, 144, 144, 144, 144, 144, 144, 144, 144},//4
            {144, 144, 144, 144, 144, 144, 111, 113, 144, 144, 144, 144, 144, 144, 144, 144, 144, 144, 144, 144, 144, 144},//5
            {144, 144, 144, 144, 144, 144, 112, 142, 114, 144, 144, 144, 144, 144, 144, 144, 144, 144, 144, 144, 144, 144},//6       
            {7, 7, 7, 7, 7, 7, 7, 7, 7, 212, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7},//7
            {144, 144, 144, 144, 144, 144, 115, 144, 144, 144, 144, 144, 144, 144, 144, 144, 144, 144, 144, 144, 144, 144},//8
            {144, 144, 144, 144, 144, 144, 144, 144, 144, 144, 144, 140, 144, 144, 144, 144, 144, 144, 144, 144, 144, 144},//9
            {144, 144, 144, 144, 144, 144, 144, 144, 144, 144, 144, 144, 141, 144, 144, 144, 144, 144, 144, 144, 144, 144}};//10
}
