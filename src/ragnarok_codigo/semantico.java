package ragnarok_codigo;

import java.util.StringTokenizer;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import ragnarok_codigo.calculadora.principalCF;
import static ragnarok_codigo.logica2.Separador;

public class semantico {

    cuadruplas cua = new cuadruplas();

    public int tabla_de_simbolos(String array[], DefaultTableModel modelo, int columnas) {
        String tipo = array[0];
        String nombre = array[1];

        for (int i = 0; i < columnas; i++) {
            for (int j = 0; j < 3; j++) {
                if (array[1].equals(modelo.getValueAt(i, 1).toString())) {
                    JOptionPane.showMessageDialog(null, "Error " + nombre + " ya a sido declarada", "Error", JOptionPane.ERROR_MESSAGE);
                    return 1;
                }
            }
        }
        try {
            modelo.addRow(new Object[columnas]);
            modelo.setValueAt(tipo, columnas, 0);
            modelo.setValueAt(nombre, columnas, 1);
            modelo.setValueAt(null, columnas, 2);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al generar la cuadrupla", "Error", JOptionPane.ERROR_MESSAGE);
            return 1;
        }
        return 0;
    }

    public int asignacion(String variable, String valor_de_variable, DefaultTableModel modelo, int columnas, DefaultTableModel cuadrupla) {//i son columnas
        String tipo_var = "";
        for (int i = 0; i < columnas; i++) {
            if (variable.equals(modelo.getValueAt(i, 1).toString())) {
                tipo_var = modelo.getValueAt(i, 0).toString();
                if (tipo_var.equals("entero")) {
                    if (valor_de_variable.matches("[0-9]*")) {
                        modelo.setValueAt(valor_de_variable, i, 2);
                        return cua.cudrupla_asignacion_sin_var(cuadrupla, valor_de_variable, variable);
                    } else {
                        principalCF cf = new principalCF();
                        String resultado = cf.resultado_calculadora(valor_de_variable, "entero");
                        if (resultado.matches("[0-9]*")) {
                            modelo.setValueAt(resultado, i, 2);
                            return cua.cudrupla_asignacion_sin_var(cuadrupla, valor_de_variable, variable);
                        }
                    }
                } //acabo asignacion de enteros   
                else if (tipo_var.equals("decimal")) {//&& valor_de_variable.matches("[0-9]*.[0-9]*")
                    if (valor_de_variable.matches("[0-9]*.[0-9]*")) {
                        modelo.setValueAt(valor_de_variable, i, 2);
                        return cua.cudrupla_asignacion_sin_var(cuadrupla, valor_de_variable, variable);
                    } else {
                        principalCF cf = new principalCF();
                        String resultado = cf.resultado_calculadora(valor_de_variable, "decimal");
                        if (resultado.matches("[0-9]*.[0-9]*")) {
                            modelo.setValueAt(resultado, i, 2);
                            return cua.cudrupla_asignacion_sin_var(cuadrupla, valor_de_variable, variable);
                        }
                    }
                    return 0;
                } else if (tipo_var.equals("texto") && valor_de_variable.matches("\\\"(\\s|.)*\\\"")) { //&& valor_de_variable.equals("cadena")
                    modelo.setValueAt(valor_de_variable, i, 2);
                    return cua.cudrupla_asignacion_sin_var(cuadrupla, valor_de_variable, variable);
                }
            }
        }

        JOptionPane.showMessageDialog(null, "Error en " + variable, "Error Asignacion", JOptionPane.ERROR_MESSAGE);

        return 1;
    }

    public int asignacion_con_variablr(String variable, String valor1, String operacion, String valor2, DefaultTableModel modelo, DefaultTableModel cuadruplas, int columnas) {//i son columnas
        String tipo_var = "";
        String cadena = valor1 + operacion + valor2;
        for (int i = 0; i < columnas; i++) {
            if (variable.equals(modelo.getValueAt(i, 1).toString())) {
                tipo_var = modelo.getValueAt(i, 0).toString();
                if (tipo_var.equals("entero")) {
                    if (valor1.matches("[0-9]*") && valor2.matches("[a-zA-Z]*")) {
                        if (devolver_valor(valor2, modelo, columnas, "entero") == 0) {
                            modelo.setValueAt(cadena, i, 2);
                            return cua.cuadrupla_asignacion_var(cuadruplas, operacion, valor1, valor2, variable);
                        }
                    } else if (valor2.matches("[0-9*]") && valor1.matches("[a-zA-Z]*")) {
                        if (devolver_valor(valor1, modelo, columnas, "entero") == 0) {
                            modelo.setValueAt(cadena, i, 2);
                            return cua.cuadrupla_asignacion_var(cuadruplas, operacion, valor1, valor2, variable);
                        }
                    } else if (valor1.matches("[a-zA-Z]*") && valor2.matches("[a-zA-Z]*")) {
                        if (devolver_valor(valor1, modelo, columnas, "entero") == 0) {
                            if (devolver_valor(valor2, modelo, columnas, "entero") == 0) {
                                modelo.setValueAt(cadena, i, 2);
                                return cua.cuadrupla_asignacion_var(cuadruplas, operacion, valor1, valor2, variable);
                            }
                        }
                    }
                } else if (tipo_var.equals("decimal")) {
                    if (valor1.matches("[0-9]*.[0-9]*") && valor2.matches("[a-zA-Z]*")) {
                        if (devolver_valor(valor2, modelo, columnas, "decimal") == 0) {
                            modelo.setValueAt(cadena, i, 2);
                            return cua.cuadrupla_asignacion_var(cuadruplas, operacion, valor1, valor2, variable);
                        }
                    } else if (valor2.matches("[0-9]*.[0-9]*") && valor1.matches("[a-zA-Z]*")) {
                        if (devolver_valor(valor1, modelo, columnas, "decimal") == 0) {
                            modelo.setValueAt(cadena, i, 2);
                            return cua.cuadrupla_asignacion_var(cuadruplas, operacion, valor1, valor2, variable);
                        }
                    } else if (valor1.matches("[a-zA-Z]*") && valor2.matches("[a-zA-Z]*")) {
                        if (devolver_valor(valor1, modelo, columnas, "decimal") == 0) {
                            if (devolver_valor(valor2, modelo, columnas, "decimal") == 0) {
                                modelo.setValueAt(cadena, i, 2);
                                return cua.cuadrupla_asignacion_var(cuadruplas, operacion, valor1, valor2, variable);
                            }
                        }
                    }
                } else if (tipo_var.equals("texto")) {
                }
            }
        }
        JOptionPane.showMessageDialog(null, "Error en " + variable, "Error Asignacion", JOptionPane.ERROR_MESSAGE);
        return 1;
    }

    public int devolver_valor(String variable, DefaultTableModel modelo, int columnas, String variable_tipo) {
        try {
            String tipo = "";
            for (int i = 0; i < columnas; i++) {
                if (variable.equals(modelo.getValueAt(i, 1).toString())) {
                    if (modelo.getValueAt(i, 0).equals(variable_tipo) && modelo.getValueAt(i, 2) != null) {
                        return 0;
                    }
                }
            }
        } catch (Exception ex) {

        }
        JOptionPane.showMessageDialog(null, "Error en " + variable , "Error", JOptionPane.ERROR_MESSAGE);
        return 1;
    }

    public int imprimir_variable(String evaluar, DefaultTableModel modelo, DefaultTableModel cuadruplas) {
        int filas = modelo.getRowCount();
        for (int i = 0; i < filas; i++) {
            if (evaluar.equals(modelo.getValueAt(i, 1))) {
                if (modelo.getValueAt(i, 2) != null) {
                    if (modelo.getValueAt(i, 2).toString().matches("[0-9]*") || modelo.getValueAt(i, 2).toString().matches("[0-9]*.[0.9]*") || modelo.getValueAt(i, 2).toString().matches("\\\"(\\s|.)*\\\"")) {
                        return cua.cuadrupla_imprimir(cuadruplas, modelo.getValueAt(i, 2).toString());
                    }
                    return cua.cuadrupla_imprimir(cuadruplas, evaluar);
                }
            }
        }
        JOptionPane.showMessageDialog(null, "Error al imprimir" + evaluar, "Error", JOptionPane.ERROR_MESSAGE);
        return 1;
    }

    public int evaluar_condicion(String valor1, String valor2, String operador, DefaultTableModel cuadrupla) {
        System.out.print(valor1 + valor2 + operador + " cond sin va");
        if (valor1.matches("[0-9]*") && valor2.matches("[0-9]*")) {
            return cua.cuadrupla_condicion_sim(cuadrupla, operador, valor1, valor2);
        } else if (valor1.matches("[0-9]*.[0-9]*") && valor2.matches("[0-9]*.[0-9]*")) {
            return cua.cuadrupla_condicion_sim(cuadrupla, operador, valor1, valor2);
        } else if (valor1.matches("\\\"(\\s|.)*\\\"") && valor2.matches("\\\"(\\s|.)*\\\"") && operador.matches("==")) {
            return cua.cuadrupla_condicion_sim(cuadrupla, operador, valor1, valor2);
        }
        JOptionPane.showMessageDialog(null, "Error en condicion", "Error", JOptionPane.ERROR_MESSAGE);
        return 1;
    }//listo 

    public int condicion_variable(String valor1, String valor2, String operador, DefaultTableModel modelo, DefaultTableModel cuadruplas) {
        if (valor1.matches("[a-zA-Z]*") && valor2.matches("\\\"(\\s|.)*\\\"") && operador.equals("==")) {
            System.out.println("1");
            if (devolver_valor(valor1, modelo, modelo.getRowCount(), "texto") == 0) {
                return cua.cuadrupla_condicion_sim(cuadruplas, operador, valor1, valor2);
            }else{JOptionPane.showMessageDialog(null, "Error en condicion", "Error", JOptionPane.ERROR_MESSAGE);return 1;}
        }//------------------variable
        if (valor1.matches("[a-zA-Z]*") && valor2.matches("[a-zA-Z]*")) {
            System.out.println("2");
            if (dos_variables_condicion(valor1, valor2, operador, modelo) == 0) {
                return cua.cuadrupla_condicion_sim(cuadruplas, operador, valor1, valor2);
            }else{JOptionPane.showMessageDialog(null, "Error en condicion", "Error", JOptionPane.ERROR_MESSAGE);return 1;}
        }
        //variable con numero entero
        if (valor1.matches("[0-9]*") && valor2.matches("[a-zA-Z]*")) {
            System.out.println("3");
            if (devolver_valor(valor2, modelo, modelo.getRowCount(), "entero") == 0) {
                return cua.cuadrupla_condicion_sim(cuadruplas, operador, valor1, valor2);
            }else{JOptionPane.showMessageDialog(null, "Error en condicion", "Error", JOptionPane.ERROR_MESSAGE);return 1;}
        }
        if (valor1.matches("[a-zA-Z]*") && valor2.matches("[0-9]*")) {
            System.out.println("4");
            if (devolver_valor(valor1, modelo, modelo.getRowCount(), "entero") == 0) {
                return cua.cuadrupla_condicion_sim(cuadruplas, operador, valor1, valor2);
            }else{JOptionPane.showMessageDialog(null, "Error en condicion", "Error", JOptionPane.ERROR_MESSAGE);return 1;}

        } //------------------decimales
        if (valor1.matches("[0-9]*.[0-9]*") && valor2.matches("[a-zA-Z]*")) {
            System.out.println("5");
            if (devolver_valor(valor2, modelo, modelo.getRowCount(), "decimal") == 0) {
                return cua.cuadrupla_condicion_sim(cuadruplas, operador, valor1, valor2);
            }else{JOptionPane.showMessageDialog(null, "Error en condicion", "Error", JOptionPane.ERROR_MESSAGE);return 1;}

        }
        if (valor1.matches("[a-zA-Z]*") && valor2.matches("[0-9]*.[0-9]*")) {
            System.out.println("6");
            if (devolver_valor(valor1, modelo, modelo.getRowCount(), "decimal") == 0) {
                return cua.cuadrupla_condicion_sim(cuadruplas, operador, valor1, valor2);
            }else{JOptionPane.showMessageDialog(null, "Error en condicion", "Error", JOptionPane.ERROR_MESSAGE);return 1;}
        } //-----------------cadena
        if (valor1.matches("\\\"(\\s|.)*\\\"") && valor2.matches("[a-zA-Z]*") && operador.equals("==")) {
            System.out.println("7");
            if (devolver_valor(valor2, modelo, modelo.getRowCount(), "texto") == 0) {
                return cua.cuadrupla_condicion_sim(cuadruplas, operador, valor1, valor2);
            }else{JOptionPane.showMessageDialog(null, "Error en condicion", "Error", JOptionPane.ERROR_MESSAGE);return 1;}
        }
        JOptionPane.showMessageDialog(null, "Error en condicion", "Error", JOptionPane.ERROR_MESSAGE);
        return 1;
    }

    public int dos_variables_condicion(String valor1, String valor2, String operador, DefaultTableModel modelo) {
        String tipo1 = "";
        String tipo2 = "";
        for (int i = 0; i < modelo.getRowCount(); i++) {
            if (valor1.equals(modelo.getValueAt(i, 1)) && modelo.getValueAt(i, 2) != null) {
                tipo1 = modelo.getValueAt(i, 0).toString();
            }
        }
        for (int i = 0; i < modelo.getRowCount(); i++) {
            if (valor2.equals(modelo.getValueAt(i, 1)) && modelo.getValueAt(i, 2) != null) {
                tipo2 = modelo.getValueAt(i, 0).toString();
            }
        }
        if (tipo1.equals(tipo2)) {
            System.out.println("ento a igual");
            if (tipo1.equals("entero") || tipo1.equals("decimal")) {
                return 0;
            } else if (tipo1.equals("texto") && operador.equals("==")) {
                return 0;
            }
        }
        return 1;
    }

    public int imprimir_sin_var(DefaultTableModel tabla_cuadruplas, String valor1) {
        return cua.cuadrupla_imprimir(tabla_cuadruplas, valor1);
    }

    public int condicion_ir(DefaultTableModel cuadruplas) {
        return cua.cudrupla_faslo_ir(cuadruplas);
    }

    public void fin(DefaultTableModel cuadrupla) {
        cua.fin(cuadrupla);
    }

    public int condicion_si_encontro_no(DefaultTableModel cuadruplas) {
        return cua.cuadrupla_ir(cuadruplas);
    }

    public int acabo_no(DefaultTableModel cuadrupla) {
        try {
            return cua.posicion_ir(cuadrupla);
        } catch (Exception ex) {
        }
        return 1;
    }

    public int condicion_ir_mientras(DefaultTableModel cuadrupla) {
        try {
            return cua.ir_mientras(cuadrupla);
        } catch (Exception ex) {
        }
        return 1;
    }

}
