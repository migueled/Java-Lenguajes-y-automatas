package ragnarok_codigo;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class cuadruplas {

    int fila = 0;
    int msg1 = 0;
    //temporal 2 para guardar las posiciones y 2 para gaurdar valores

    int temporal_posicion_falso = 0;//guarda la posicion de la cuadrupla
    int falso_tem = 0;//t0 t1 t2
    int temp = 0;//t0 t1 t2
    int temporal_posicion_Cuadrupla_ir = 0;
    int temporal_cuadrupla_condicion = 0;

    public int cuadrupla_asignacion_var(DefaultTableModel cuadrupla, String simbolo, String val1, String val2, String variable_Asig) {
        try {
            cuadrupla.addRow(new Object[fila]);
            cuadrupla.setValueAt(fila, fila, 0);
            cuadrupla.setValueAt(simbolo, fila, 1);
            cuadrupla.setValueAt(val1, fila, 2);
            cuadrupla.setValueAt(val2, fila, 3);
            cuadrupla.setValueAt(variable_Asig, fila, 4);
            fila++;
            return 0;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al generar la cuadrupla", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return 1;
    }

    public int cuadrupla_condicion_sim(DefaultTableModel cuadrupla, String simbolo, String val1, String val2) {
        try {
            cuadrupla.addRow(new Object[fila]);
            cuadrupla.setValueAt(fila, fila, 0);
            cuadrupla.setValueAt(simbolo, fila, 1);
            cuadrupla.setValueAt(val1, fila, 2);
            cuadrupla.setValueAt(val2, fila, 3);
            cuadrupla.setValueAt("T" + temp, fila, 4);
            temporal_cuadrupla_condicion = fila;
            fila++;
            //-----cudrupla falso
            cuadrupla.addRow(new Object[fila]);
            cuadrupla.setValueAt(fila, fila, 0);
            cuadrupla.setValueAt("falso", fila, 1);
            cuadrupla.setValueAt(null, fila, 2);
            cuadrupla.setValueAt(null, fila, 3);
            cuadrupla.setValueAt("T" + temp, fila, 4);
            temporal_posicion_falso = fila;//nos permite saber donde esta la cuadrupla
            falso_tem = temp;
            fila++;
            temp++;
            return 0;
        } catch (Exception ex) {
            
        }
        return 1;
    }

    public int cuadrupla_imprimir(DefaultTableModel cuadrupla, String valor) {
        try {
            cuadrupla.addRow(new Object[fila]);
            cuadrupla.setValueAt(fila, fila, 0);
            cuadrupla.setValueAt("imprimir", fila, 1);
            cuadrupla.setValueAt(valor, fila, 2);
            cuadrupla.setValueAt(null, fila, 3);
            cuadrupla.setValueAt("msg" + msg1, fila, 4);
            fila++;
            msg1++;
            return 0;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al generar la cuadrupla", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return 1;
    }

    public int cudrupla_asignacion_sin_var(DefaultTableModel cuadrupla, String valor, String variable) {
        try {
            cuadrupla.addRow(new Object[fila]);
            cuadrupla.setValueAt(fila, fila, 0);
            cuadrupla.setValueAt(":=", fila, 1);
            cuadrupla.setValueAt(valor, fila, 2);
            cuadrupla.setValueAt(null, fila, 3);
            cuadrupla.setValueAt(variable, fila, 4);
            fila++;
            return 0;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al generar la cuadrupla", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return 1;
    }

    public int cudrupla_faslo_ir(DefaultTableModel cuadrupla) {
        try {
            cuadrupla.setValueAt(fila, temporal_posicion_falso, 2);
            return 0;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al generar la cuadrupla", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return 1;
    }

    public void fin(DefaultTableModel cuadrupla) {
        try {
            cuadrupla.addRow(new Object[fila]);
            cuadrupla.setValueAt(fila, fila, 0);
            cuadrupla.setValueAt(null, fila, 1);
            cuadrupla.setValueAt(null, fila, 2);
            cuadrupla.setValueAt(null, fila, 3);
            cuadrupla.setValueAt(null, fila, 4);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al generar la cuadrupla", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public int cuadrupla_ir(DefaultTableModel cuadrupla) {
        try {
            temporal_posicion_Cuadrupla_ir = fila;
            cuadrupla.addRow(new Object[fila]);
            cuadrupla.setValueAt(fila, fila, 0);
            cuadrupla.setValueAt("ir", fila, 1);
            cuadrupla.setValueAt(null, fila, 2);
            cuadrupla.setValueAt(null, fila, 3);
            cuadrupla.setValueAt(null, fila, 4);
            fila++;
            return 0;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al generar la cuadrupla", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return 1;
    }

    public int posicion_ir(DefaultTableModel cuadrupla) {
        try {
            cuadrupla.setValueAt(fila, temporal_posicion_Cuadrupla_ir, 2);
            System.out.println("devolvio o" + temporal_posicion_Cuadrupla_ir + fila);
            return 0;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al generar la cuadrupla", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return 1;
    }

    public int ir_mientras(DefaultTableModel cuadrupla) {
        try {
            temporal_posicion_Cuadrupla_ir = fila;
            cuadrupla.addRow(new Object[fila]);
            cuadrupla.setValueAt(fila, fila, 0);
            cuadrupla.setValueAt("ir", fila, 1);
            cuadrupla.setValueAt(temporal_cuadrupla_condicion, fila, 2);
            cuadrupla.setValueAt(null, fila, 3);
            cuadrupla.setValueAt(null, fila, 4);
            fila++;
            return 0;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al generar la cuadrupla", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return 1;

    }

}
