/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ragnarok_codigo;

import java.util.StringTokenizer;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MiguelEd
 */
public class sintactico2 {

    //LENGUAJE RAGNAROK EXTENSION . MULTIVERSO
    //---------------------sintactico
    String insertar_asig_tabla[] = new String[2];//en la posicion 0 se guarda tipo de var en la  pos 1 se guarda la variable y asi poderlo almacenar en la tabla de simbolos
    String valor1 = "", operacion = "", valor2 = "";//suma los tokens almacenados eje 5+6
    StringTokenizer tokens = null;//sirve para obtener los tokens de la cadena
    String token = "";//se guarda el tipo de token ejemplo variable cadena palabra
    //----------------------lexico
    logica2 lg = new logica2();
    DefaultTableModel tabla_tokens;//sirve para mostrar los tokens de la cadena en una tabla
    int faltan = 0;
    int obtener = 0;//se ocupa cuando el token anterior fue + para poder hacer 5+6
    int filas = 0;//numero de filas de la tabla de tokens
    //---------------------semantico
    semantico sm = new semantico();
    DefaultTableModel tabla_sim;
    DefaultTableModel tabla_cuadruplas;
    int filas_cuadruplas = 0;
    int filas_tb_simbolos = 0;//cantidad de filas de la tabla

    public int obtener_tokens_lexico(String token, DefaultTableModel tabla, DefaultTableModel tabla_simbolos, DefaultTableModel cuadrupla) {
        tabla_tokens = tabla;
        tabla_sim = tabla_simbolos;
        tabla_cuadruplas = cuadrupla;

        token = lg.Eliminar_comentarios(token);//se eliminaran los comentarios en el string
        tokens = lg.obtener_tokens(token, tokens);// se manda el tokenizar y la cadena y para obtener el tokenizer a utilizar
        if (ProgMV() == 0) {//comienzo del sintactico
            JOptionPane.showMessageDialog(null, "No se encontraron errores en el codigo", "Sin Errores", JOptionPane.INFORMATION_MESSAGE);
            return 0;
        } else {
            JOptionPane.showMessageDialog(null, "Se encontraron Errores en la sintaxis", "Error", JOptionPane.ERROR_MESSAGE);
            return 1;
        }
    }

    public String A_token() {//se obtendran el token que el sintactico analizara
        int limite = 0;
        String token = "";
        String lexema = "";
        while (tokens.hasMoreTokens() && limite < 1) {
            if (obtener == 0) {//para cuando se a suma 
                token = lg.token(tokens, tabla_tokens, filas);
            } else {
                token = lg.almacenar(tabla_tokens, filas);//si fue suma obtiene un token almacenado
                obtener = 0;
            }
            if (token.equals("+") || token.equals("-")) {//extra para poder ir al metodo donde se guarda un valor
                obtener = 1;
            }
            limite = 1;
            if (token.equals("nulo")) {//si obtiene un nulo, nulo== /s 
                limite = 0;
            }
        }
        filas++;
        return token;//regresa el token ejemplo "hola" regresa texto
    }

    public int ProgMV() {
        token = A_token();
        if (token.equals("programa")) {
            token = A_token();
            if (token.equals("cadena")) {
                token = A_token();
                if (token.equals("{")) {//se queda con el token ; y no sigue al sig token            
                    if (cuerpo() == 0) {
                        token = A_token();
                        if (token.equals("}")) {
                            sm.fin(tabla_cuadruplas);
                            return 0;
                        }
                    }
                }
            }
        }
        return 1;
    }

    public int cuerpo() {
        token = A_token();
        if (token.equals("inicio")) {
            token = A_token();
            if (token.equals("{")) {//se queda en el token inicio seguido de {                
                token = A_token();
                if (Instrucciones() == 0) {
                    if (token.equals("}")) {
                        return 0;
                    }
                }
            }
        }
        return 1;
    }//listo
    int evaluar = 1;
    int error = 0;

    public int Instrucciones() {//listo
        if (error == 1) {
            return 1;
        }
        if (token != "}") {
            evaluar++;
            if (instruccion() == 1) {
                error = 1;
                return 1;
            }
            if (error != 1) {
                Instrucciones();
            } else {
                error = 1;
                return 1;
            }
        }
        return error;
    }

    public int instruccion() {//declaración|Si|mientras|para|hacer|leer|imprimir|imprimirln|hacer|arreglo|asignacion
        if (declaracion() != 0) {//listo solo falta postfija
            return 1;
        }
        if (asignacion() != 0) {//solo falta postfija
            return 1;
        }
        if (imprimirMsg() != 0) {//listo
            return 1;
        }
        if (ECS_si() != 0) {//listo
            return 1;
        }
        if (ERC_mientras() != 0) {//lit
            return 0;
        }

        return 0;
    }

    public int declaracion() {
        if (tipo_var() == 0) {
            insertar_asig_tabla[0] = lg.token_almacenado();
            token = A_token();
            if (token.equals("variable")) {
                insertar_asig_tabla[1] = lg.token_almacenado();
                token = A_token();
                if (token.equals(";")) {
                    token = A_token();
                    if (sm.tabla_de_simbolos(insertar_asig_tabla, tabla_sim, filas_tb_simbolos) == 0) {
                        filas_tb_simbolos++;
                        return 0;
                    } else {
                        return 1;
                    }
                }
            }
            error = 1;
            return 1;
        }
        return 0;
    }//listo
    String variable_asignacion = "";
    String incluye_variable = "no";

    public int asignacion() {
        if (token.equals("variable")) {//revisa si el token es un texto numeroe numerod si es regresa 0 y si es cero lee el sig texto para saber si es ; :=
            variable_asignacion = lg.token_almacenado();
            token = A_token();
            if (token.equals(":=")) {
                valor1 = "";
                valor2 = "";
                operacion = "";
                incluye_variable = "no";
                que_valor = 0;
                if (expresion() == 0) {//aqui modifique
                    if (token.equals(";")) {
                        token = A_token();
                        if (incluye_variable.equals("no")) {
                            String suma_de_tokens = valor1 + operacion + valor2;
                            return sm.asignacion(variable_asignacion, suma_de_tokens, tabla_sim, filas_tb_simbolos, tabla_cuadruplas);
                        } else {
                            return sm.asignacion_con_variablr(variable_asignacion, valor1, operacion, valor2, tabla_sim, tabla_cuadruplas, filas_tb_simbolos);
                        }
                    }
                }
            }
            error = 1;
            return 1;
        }
        return 0;
    }//no mood

    public int expresion() {//Contenido | contenido operador expresión           
        if (valores() == 0) {
            if (operadores() == 0) {
                return valores();
            } else {
                return 0;
            }
        }
        return 1;
    }//no mod
    int que_valor = 0;

    public int valores() {
        token = A_token();
        if (que_valor == 0) {//valor1
            valor1 = lg.token_almacenado();
            que_valor = 1;
        } else {//valor2
            valor2 = lg.token_almacenado();
            que_valor = 0;
        }

        if (token.equals("variable") || token.equals("numero_decimal") || token.equals("numero_entero") || token.equals("cadena")) {
            if (token.equals("variable")) {
                incluye_variable = "si";
                token = A_token();
                return 0;
            }
            if (token.equals("numero_decimal") || token.equals("numero_entero") || token.equals("cadena")) {
                token = A_token();
                return 0;
            }
        }
        return 1;
    }

    public int imprimirMsg() {
        if (token.equals("imprimir")) {
            token = A_token();
            if (token.equals("(")) {
                que_valor = 0;
                valor1 = "";
                valor2 = "";
                operacion = "";
                incluye_variable = "no";
                if (valores() == 0) {
                    if (token.equals(")")) {
                        token = A_token();
                        if (token.equals(";")) {
                            token = A_token();
                            if (incluye_variable.equals("no")) {
                                return sm.imprimir_sin_var(tabla_cuadruplas, valor1);
                            } else {
                                return sm.imprimir_variable(valor1, tabla_sim, tabla_cuadruplas);
                            }

                        }
                    }
                }
            }
            error = 1;
            return 1;
        }
        return 0;
    }//falta impresion de variable

    public int operadores() {
        if (sim_div_mul_pot() == 0 || sim_mas_menos() == 0) {
            operacion = lg.token_almacenado();
            return 0;
        }
        return 1;
    }

    public int ECS_si() {
        if (token.equals("si")) {
            token = A_token();
            if (token.equals("(")) {
                valor1 = "";
                valor2 = "";
                operacion = "";
                incluye_variable = "no";
                que_valor = 0;
                if (condicion() == 0) {
                    if (token.equals(")")) {
                        token = A_token();
                        if (token.equals("{")) {
                            token = A_token();
                            if (Instrucciones() == 0) {
                                if (token.equals("}")) {
                                    token = A_token();
                                    return otro();
                                }

                            }
                        }
                    }
                }
            }
            error = 1;
            return 1;
        }
        return 0;
    }

    public int otro() {
        int resultado_no = ECS_no();
        if (resultado_no != 0) {
            return 1;
        }
        return 0;
    }

    public int ECS_no() {
        if (token.equals("no")) {
            token = A_token();
            if (token.equals("{") && sm.condicion_si_encontro_no(tabla_cuadruplas) == 0 && sm.condicion_ir(tabla_cuadruplas) == 0) {
                token = A_token();
                if (Instrucciones() == 0) {
                    if (token.equals("}")) {
                        token = A_token();
                        return sm.acabo_no(tabla_cuadruplas);
                    }
                }
            }
            return 1;
        }
        return sm.condicion_ir(tabla_cuadruplas);
    }

    public int ERC_mientras() {
        if (token.equals("mientras")) {
            valor1 = "";
            valor2 = "";
            operacion = "";
            incluye_variable = "no";
            que_valor = 0;
            token = A_token();
            if (token.equals("(")) {
                if (condicion() == 0) {
                    if (token.equals(")")) {
                        token = A_token();
                        if (token.equals("{")) {
                            token = A_token();
                            if (Instrucciones() == 0) {
                                if (token.equals("}") && sm.condicion_ir_mientras(tabla_cuadruplas) == 0) {
                                    token = A_token();
                                    return sm.condicion_ir(tabla_cuadruplas);
                                }
                            }
                        }
                    }
                }
            }
            error = 1;
            return 1;
        }
        return 0;
    }

    public int condicion() {//solo para hacer 4<9
        if (valores() == 0) {
            if (operador_relacional() == 0) {
                if (valores() == 0) {
                    if (incluye_variable.equals("no")) {
                        return sm.evaluar_condicion(valor1, valor2, operacion, tabla_cuadruplas);
                    } else {
                        return sm.condicion_variable(valor1, valor2, operacion, tabla_sim, tabla_cuadruplas);
                    }
                }
            }
        }
        return 1;
    }

    public int operador_relacional() {
        if (token.equals("<<") || token.equals(">>") || token.equals("==") || token.equals(">=") || token.equals("<=")) {
            operacion = lg.token_almacenado();
            return 0;
        }
        return 1;
    }

    //----------------------------------------------------------------------FINALES---------------------------------------------------------------------
    public int tipo_var() {
        int regresar = 1;
        switch (token) {
            case "entero":
                regresar = 0;
                break;
            case "decimal":
                regresar = 0;
                break;
            case "texto":
                regresar = 0;
                break;
            case "boleano":
                regresar = 0;
                break;
        }
        return regresar;
    }//listo no modificar 1=error caso 0=aceptado

    public int sim_mas_menos() {
        int regresar = 1;
        switch (token) {
            case "+":
                regresar = 0;
                break;
            case "-":
                regresar = 0;
                break;
        }
        return regresar;
    }//1 error 0 aceptado

    public int sim_div_mul_pot() {//1 error 0 aceptado
        int regresar = 1;
        switch (token) {
            case "*":
                regresar = 0;
                break;
            case "/":
                regresar = 0;
                break;
        }
        return regresar;
    }

}
