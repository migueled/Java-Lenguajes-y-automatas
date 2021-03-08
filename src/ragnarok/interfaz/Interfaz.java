package ragnarok.interfaz;

import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.UndoManager;
import ragnarok_codigo.cod_intermedio;
import ragnarok_codigo.sintactico2;

public class Interfaz extends javax.swing.JFrame {

    private String titol_aux = "", path_titol = "";
    DefaultTableModel modelo;
    private boolean sortir = false;
    DefaultTableModel modelo_simbolos;
    DefaultTableModel cuadruplas;
    JFileChooser j = new JFileChooser();
    int cont = 0;
    String ruta = "";

    Stack<String> pila2 = new Stack<String>();

    public String Pila[] = new String[10];
    public static int cima;

    public Interfaz() {

        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem4 = new javax.swing.JMenuItem();
        panel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        Lineas = new javax.swing.JEditorPane();
        area_texto = new javax.swing.JEditorPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_tokens = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_simbolo = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btn_analizar = new javax.swing.JButton();
        btn_limpiar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        nuevo = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        jMenuItem3 = new javax.swing.JMenuItem();
        guarda_archivo = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        deshacer = new javax.swing.JMenuItem();
        rehacer = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        cortar = new javax.swing.JMenuItem();
        copiar = new javax.swing.JMenuItem();
        pegar = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        selec_todo = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenu3 = new javax.swing.JMenu();
        manual = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        creditos = new javax.swing.JMenuItem();

        jMenuItem4.setText("jMenuItem4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ragnarok");

        panel1.setBackground(new java.awt.Color(102, 255, 255));

        jTabbedPane1.setBackground(new java.awt.Color(241, 240, 240));

        Lineas.setEditable(false);
        Lineas.setText("1");
        Lineas.setOpaque(false);

        area_texto.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        area_texto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                area_textoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                area_textoKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(Lineas, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(area_texto, javax.swing.GroupLayout.DEFAULT_SIZE, 645, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Lineas, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                    .addComponent(area_texto))
                .addGap(0, 0, 0))
        );

        jTabbedPane1.addTab("Codigo", jPanel1);

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        tabla_tokens.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        tabla_tokens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Lexema", "Token"
            }
        ));
        jScrollPane1.setViewportView(tabla_tokens);

        tabla_simbolo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tipo", "Variable", "Valor"
            }
        ));
        jScrollPane2.setViewportView(tabla_simbolo);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );

        jTabbedPane1.addTab("Tablas", jPanel2);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "numero cuadrupla", "simbolo", "valor1", "valor 2", "temporal"
            }
        ));
        jScrollPane4.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 652, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Cuadruplas", jPanel3);

        btn_analizar.setText("Analizar");
        btn_analizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_analizarActionPerformed(evt);
            }
        });

        btn_limpiar.setText("Limpiar");
        btn_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(btn_analizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jTabbedPane1))
                .addGap(15, 15, 15))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_analizar)
                    .addComponent(btn_limpiar))
                .addGap(15, 15, 15))
        );

        jMenu1.setText("Archivo");
        jMenu1.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N

        nuevo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        nuevo.setText("Nueva ventana");
        nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoActionPerformed(evt);
            }
        });
        jMenu1.add(nuevo);
        jMenu1.add(jSeparator5);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Abrir");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        guarda_archivo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        guarda_archivo.setText("Guardar");
        guarda_archivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guarda_archivoActionPerformed(evt);
            }
        });
        jMenu1.add(guarda_archivo);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMenuItem2.setText("Guardar como");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);
        jMenu1.add(jSeparator4);

        jMenuItem1.setText("Salir");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edición");

        deshacer.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        deshacer.setText("Deshacer");
        deshacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deshacerActionPerformed(evt);
            }
        });
        jMenu2.add(deshacer);

        rehacer.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_MASK));
        rehacer.setText("Rehacer");
        rehacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rehacerActionPerformed(evt);
            }
        });
        jMenu2.add(rehacer);
        jMenu2.add(jSeparator6);

        cortar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        cortar.setText("Cortar");
        cortar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cortarActionPerformed(evt);
            }
        });
        jMenu2.add(cortar);

        copiar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        copiar.setText("Copiar");
        copiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copiarActionPerformed(evt);
            }
        });
        jMenu2.add(copiar);

        pegar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        pegar.setText("Pegar");
        pegar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pegarActionPerformed(evt);
            }
        });
        jMenu2.add(pegar);
        jMenu2.add(jSeparator1);

        selec_todo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        selec_todo.setText("Seleccionar todo");
        selec_todo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selec_todoActionPerformed(evt);
            }
        });
        jMenu2.add(selec_todo);
        jMenu2.add(jSeparator3);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Ayuda");

        manual.setText("Manual de usuario");
        manual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manualActionPerformed(evt);
            }
        });
        jMenu3.add(manual);
        jMenu3.add(jSeparator2);

        creditos.setText("Creditos");
        creditos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creditosActionPerformed(evt);
            }
        });
        jMenu3.add(creditos);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        Guardar();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void area_textoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_area_textoKeyReleased
        StringTokenizer st = new StringTokenizer(area_texto.getText(), "\n", true);
        String txt = "", token;
        cont = 1;

        while (st.hasMoreTokens()) {
            token = st.nextToken();
            if ("\n".equals(token)) {
                cont++;
            }
        }

        for (int i = 1; i <= cont; i++) {
            txt += i + "\n";
        }
        Lineas.setText(txt);
    }//GEN-LAST:event_area_textoKeyReleased

    private void area_textoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_area_textoKeyPressed
        agregar_pila();
        StringTokenizer st = new StringTokenizer(area_texto.getText(), "\n", true);
        String txt = "", token;
        cont = 1;

        while (st.hasMoreTokens()) {
            token = st.nextToken();
            if ("\n".equals(token)) {
                cont++;
            }
        }

        for (int i = 1; i <= cont; i++) {
            txt += i + "\n";
        }
        Lineas.setText(txt);
    }//GEN-LAST:event_area_textoKeyPressed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        area_texto.setText(abrirArchivo());

    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void btn_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiarActionPerformed
        area_texto.setText("");
        Lineas.setText("1");

        int limpiar = tabla_tokens.getRowCount();
        try {
            for (int i = limpiar - 1; i >= 0; i--) {
                modelo.removeRow(i);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);
        }
        //-------limpiar tabla de simbolos
        int limpiar_simbolos = tabla_simbolo.getRowCount();
        try {
            for (int i = limpiar_simbolos - 1; i >= 0; i--) {
                modelo_simbolos.removeRow(i);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);
        }
        int limpiar_cuadruplas = jTable1.getRowCount();
        try {
            for (int i = limpiar_cuadruplas- 1; i >= 0; i--) {
                cuadruplas.removeRow(i);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_limpiarActionPerformed

    private void btn_analizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_analizarActionPerformed
        //-----------limpiar tabla de tokens
        int limpiar = tabla_tokens.getRowCount();
        try {
            for (int i = limpiar - 1; i >= 0; i--) {
                modelo.removeRow(i);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);
        }
        //-------limpiar tabla de simbolos
        int limpiar_simbolos = tabla_simbolo.getRowCount();
        try {
            for (int i = limpiar_simbolos - 1; i >= 0; i--) {
                modelo_simbolos.removeRow(i);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);
        }
        //----limpiar cuadruplas
        //-------limpiar tabla de simbolos
        int limpiar_cuadruplas = jTable1.getRowCount();
        try {
            for (int i = limpiar_cuadruplas - 1; i >= 0; i--) {
                cuadruplas.removeRow(i);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);
        }
        //obtener tablas   
        modelo_simbolos = (DefaultTableModel) this.tabla_simbolo.getModel();
        modelo = (DefaultTableModel) this.tabla_tokens.getModel();
        cuadruplas = (DefaultTableModel) this.jTable1.getModel();
        //analizar codigo     
        String almacenar = "";
        sintactico2 lg = new sintactico2();
        try {
            if (lg.obtener_tokens_lexico(area_texto.getText(), modelo, modelo_simbolos, cuadruplas) == 0) {
                cod_intermedio inter = new cod_intermedio();
                inter.cod(cuadruplas);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error en el codigo", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btn_analizarActionPerformed

    private void guarda_archivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guarda_archivoActionPerformed

        String guardar_texto = "";
        //buscas el archivo C:\\Users\\fefe\\Desktop\\demo.txt
        //demo.txt ""
        File guarda = new File(ruta);

        try {
            FileWriter save = new FileWriter(guarda);
            save.write(guardar_texto);
            save.close();

            save = new FileWriter(guarda);
            guardar_texto = area_texto.getText();
            save.write(guardar_texto);
            save.close();
            JOptionPane.showMessageDialog(rootPane, "guardado");
        } catch (IOException ex) {
            Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
        }

        //C:\\Users\\fefe\\Desktop\\demo.txt eescribes guardar
        //cerrar archivo

    }//GEN-LAST:event_guarda_archivoActionPerformed

    private void copiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copiarActionPerformed
        // TODO add your handling code here:
        area_texto.copy();
    }//GEN-LAST:event_copiarActionPerformed

    private void cortarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cortarActionPerformed
        // TODO add your handling code here:
        area_texto.cut();
    }//GEN-LAST:event_cortarActionPerformed

    private void pegarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pegarActionPerformed
        // TODO add your handling code here:
        area_texto.paste();
    }//GEN-LAST:event_pegarActionPerformed

    private void selec_todoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selec_todoActionPerformed
        // TODO add your handling code here:
        area_texto.selectAll();
    }//GEN-LAST:event_selec_todoActionPerformed

    private void nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoActionPerformed
        // TODO add your handling code here:
        //nueva
        if (area_texto.getText().compareTo("") != 0) {
            optionGuardar(false);
        }
        titol_aux = "";
        path_titol = "";
        // canviarTitol();
    }//GEN-LAST:event_nuevoActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed
    int tope = 0;
    int tope2 = 0;
    private void rehacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rehacerActionPerformed
        System.out.println("rehacer " + tope + tope2 + " " + area_texto.getText());
        {
            if (tope == tope2) {
                Pila[tope] = area_texto.getText();
            }
            if (tope < tope2) {// >>>
                tope++;
                area_texto.setText(Pila[tope]);
            } else {
                JOptionPane.showMessageDialog(null, "error");
            }
        }


    }//GEN-LAST:event_rehacerActionPerformed

    private void deshacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deshacerActionPerformed
        System.out.println("deshacer " + tope + tope2 + " " + area_texto.getText());
        if (tope == tope2) {
            Pila[tope] = area_texto.getText();
        }
        if (tope > 0) {//<<<
            area_texto.setText(Pila[tope - 1]);
            tope--;
        } else if (tope == 0) {
            area_texto.setText(Pila[tope]);
        } else {
            JOptionPane.showMessageDialog(null, "error");
        }
    }//GEN-LAST:event_deshacerActionPerformed

    private void creditosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creditosActionPerformed
        
        Acerca acr = new Acerca();
        acr.setLocationRelativeTo(null);
       //this.setVisible(false);
        acr.setVisible(true);
        acr.setResizable(false);
        
    }//GEN-LAST:event_creditosActionPerformed

    private void manualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manualActionPerformed
        // TODO add your handling code here:
        try{
            File path = new File("manual/manual de usuario.pdf");
            Desktop.getDesktop().open(path);
        } catch (IOException ex) {
         }catch(IllegalArgumentException argumentException){        
    }        
    }//GEN-LAST:event_manualActionPerformed
    public void agregar_pila() {
        System.out.println(tope + " " + tope2);
        if (tope >= 0 && tope < 9) {
            Pila[tope] = area_texto.getText();
            tope++;
            if (tope <= 9 && tope2 <= 9) {
                tope2++;
            }
        } else if (tope == 9) {
            for (int i = 0; i < 10; i++) {
                if (tope != 9) {
                    Pila[i] = Pila[i + 1];
                }
                if (tope == 9) {
                    Pila[i] = area_texto.getText();
                }
            }
        }
    }

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }

    public void Guardar() {
        try {
            j = new JFileChooser();

            j.setFileSelectionMode(JFileChooser.FILES_ONLY);
            FileNameExtensionFilter filtroTxt = new FileNameExtensionFilter("Archivo Ragnarok", ".multiverso");
            j.setFileFilter(filtroTxt);            
            j.setFileHidingEnabled(false);
            System.out.println("title       "+this.getTitle());
            int fin = this.getTitle().lastIndexOf('.');
            if (fin == -1) {
                fin = this.getTitle().length();
            }
            j.setSelectedFile(new File(this.getTitle().substring(0, fin)));
            int select = j.showSaveDialog(this);
            File guarda = j.getSelectedFile();
            System.out.println("file2       "+guarda);
            if (select == JFileChooser.APPROVE_OPTION) {
                if (guarda != null) {
                    FileWriter save = new FileWriter(guarda + ".multiverso");
                    save.write(area_texto.getText());
                    save.close();
                    JOptionPane.showMessageDialog(null, "Se ha guardado el archivo", "Información", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Su archivo no se ha guardado", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JEditorPane Lineas;
    private javax.swing.JEditorPane area_texto;
    private javax.swing.JButton btn_analizar;
    private javax.swing.JButton btn_limpiar;
    private javax.swing.JMenuItem copiar;
    private javax.swing.JMenuItem cortar;
    private javax.swing.JMenuItem creditos;
    private javax.swing.JMenuItem deshacer;
    private javax.swing.JMenuItem guarda_archivo;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JMenuItem manual;
    private javax.swing.JMenuItem nuevo;
    private javax.swing.JPanel panel1;
    private javax.swing.JMenuItem pegar;
    private javax.swing.JMenuItem rehacer;
    private javax.swing.JMenuItem selec_todo;
    private javax.swing.JTable tabla_simbolo;
    private javax.swing.JTable tabla_tokens;
    // End of variables declaration//GEN-END:variables

    private void optionGuardar(boolean automatic) {
        int result = 0;
        if ((!automatic) && (!sortir)) {
            Object[] options = {"Guardar", "No Guardar", "Cancelar"};
            result = JOptionPane.showOptionDialog(this, "¿Desea Guardar los cambios hechos a " + titol_aux + "?", "Bloc de Notas", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        }
        switch (result) {
            case 0:
                String fitxer = "";
                if (automatic) {
                    fitxer = path_titol + titol_aux;
                } else {
                    fitxer = selectFile("Guardar", "Guardar");
                }
                boolean escriure = true;
                if (fitxer.compareTo("") != 0) {
                    if (!automatic) {
                        File fitxerAux = new File(fitxer);
                        if (fitxerAux.isFile()) {
                            escriure = sobreEscriure(fitxer.substring(fitxer.lastIndexOf("\\") + 1));
                        }
                    }
                    if (escriure) {
                        FileWriter fichero = null;
                        try {
                            int posBack = -1, aux = 0;
                            String fitxerBack = "";

                            fichero = new FileWriter(fitxer);
                            fichero.write(area_texto.getText().replaceAll("\n", "\r\n"));
                            fichero.close();

                            aux = fitxer.lastIndexOf("\\");
                            if (aux != -1) {
                                posBack = aux;
                            }
                            fitxerBack = fitxer.substring(posBack + 1);
                            path_titol = fitxer.substring(0, posBack + 1);
                            titol_aux = fitxerBack;
                        } catch (IOException ex) {
                            Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    } else {
                        optionGuardar(automatic);
                    }
                }
                break;
            case 1:
                area_texto.setText("");
                break;
            case 2:
                break;
            default:
                break;
        }
    }

    private boolean sobreEscriure(String fichero) {
        Object[] options = {"Si", "No"};
        int result = JOptionPane.showOptionDialog(this, "El fichero " + fichero + " ya existe, desea guardar los cambios hechos?", "Bloc de Notas", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        if (result == 0) {
            return true;
        } else {
            return false;
        }
    }

    private String selectFile(String capsalera, String boto) {
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setDialogTitle(capsalera);
        jFileChooser.setApproveButtonText(boto);
        int retorn = jFileChooser.showOpenDialog(this);
        if (retorn == JFileChooser.APPROVE_OPTION) {
            return jFileChooser.getSelectedFile().toString();
        } else {
            return "";
        }
    }

    protected String abrirArchivo() {
        // Almacena el contenido del archivo
        String contenidoTXT = "";
        // Crear un objeto de tipo JFileChooser
        JFileChooser jfc = new JFileChooser();

        jfc.setFileFilter(new FileNameExtensionFilter("Archivo *.multiverso", "MULTIVERSO"));

        // Abrir la ventana
        int seleccion = jfc.showOpenDialog(this);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File abrir = jfc.getSelectedFile();

            setTitle(abrir.getName());

            ruta = abrir + "";
            if (abrir != null) {
                FileReader leerArchivo = null;
                try {
                    leerArchivo = new FileReader(abrir);
                    BufferedReader br = new BufferedReader(leerArchivo);
                    String linea = "";
                    while ((linea = br.readLine()) != null) {
                        contenidoTXT = contenidoTXT + "\n" + linea;
                    }

                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "No se encuentra el "
                            + "archivo especificado",
                            "Manejo de archivos",
                            JOptionPane.ERROR_MESSAGE);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error al leer el archivo.",
                            "Lectura de archivos",
                            JOptionPane.ERROR_MESSAGE);
                }

            }
        }
        return contenidoTXT;
    }

    class FiltroArchivo extends FileFilter {

        @Override
        public boolean accept(File f) {
            if (f.getPath().endsWith(".multiverso")) {
                return true;
            } else if (f.isDirectory()) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public String getDescription() {
            return "Archivo *.multiverso";
        }

    }
}
