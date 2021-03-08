/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ragnarok_codigo;

import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author fefe
 */
public class cod_intermedio {

    public int cod(DefaultTableModel cuadruplas) {

        FileWriter archivo = null;
        PrintWriter p = null;
        
        
        
        
        try {
            archivo = new FileWriter("archivo.asm");
            p = new PrintWriter(archivo);
            //pw.print("; Código ensamblador\"" + ragnarok + "\"");
            p.println();

            p.println("este es un ejemplo%include 'functions.asm' \n"
                    + "SECTION .data \n");

            //  System.out.println(cuadruplas.getValueAt(0, 1).toString());
            String segunda = "SECTION .bss\n"
                    + "sinput: resb 255\n" + "\n"
                    + "dummy: resb 2\n" + "\n"
                    + "SECTION .text\n"
                    + "global _start   \n"
                    + "_start:\n";
            String tercera = "";
           String almacena ="";
            String imprimir_msg = "";
            System.out.println("");
            String cuadrupla = "";
            
           String Pila[] = new String[10];
            
            for (int i = 0; i < cuadruplas.getRowCount(); i++) {
                if (cuadruplas.getValueAt(i, 1) != null) {
                    cuadrupla = cuadruplas.getValueAt(i, 1).toString(); 
                        
                        switch (cuadrupla) {                                                        
                            case ":=":
                                tercera += ("mov eax, " + cuadruplas.getValueAt(i, 2) + "\n");                                
                                Pila[i]=(cuadruplas.getValueAt(i, 2).toString());
                                
                                break;
                            case "+":
                                tercera += ("mov eax, " + cuadruplas.getValueAt(i, 2) + "\n");
                                tercera += ("mov ebx, " + cuadruplas.getValueAt(i, 3) + "\n");
                                tercera += ("add eax,ebx \n");
                                break;
                            case "-":
                                tercera += ("mov eax, " + cuadruplas.getValueAt(i, 2) + "\n");
                                tercera += ("mov ebx, " + cuadruplas.getValueAt(i, 3) + "\n");
                                tercera += ("sub eax,ebx \n");
                                break;
                            case "/":
                                tercera += ("mov eax, " + cuadruplas.getValueAt(i, 2) + "\n");
                                tercera += ("mov ebx, " + cuadruplas.getValueAt(i, 3) + "\n");
                                tercera += ("div eax,ebx \n");
                                break;
                            case "*":
                                tercera += ("mov eax, " + cuadruplas.getValueAt(i, 2) + "\n");
                                tercera += ("mov ebx, " + cuadruplas.getValueAt(i, 3) + "\n");
                                tercera += ("mul eax,ebx");
                                break;
                            case "--":
                                tercera += ("dec eax \n");
                                break;
                            case "++":
                                tercera += ("inc eax \n");
                                break;
                            case "==":
                                tercera+="cuadrupla"+cuadruplas.getValueAt(i, 0)+":\n";
                                tercera += ("cmp eax,ebx \n");
                                tercera += ("ja falso \n");
                                break;
                            case "imprimir":
                                imprimir_msg += cuadruplas.getValueAt(i, 4).toString() + " db " + cuadruplas.getValueAt(i, 2).toString() + ",0h";
                                tercera += ("mov eax, " + cuadruplas.getValueAt(i, 4) + "\n");
                                tercera += ("call sprintLF \n");
                                break;

                            case "<<":
                                tercera+="cuadrupla"+cuadruplas.getValueAt(i, 0)+":\n";
                                tercera += ("mov eax," + cuadruplas.getValueAt(i, 2) + "\n");
                                tercera += ("mov ebx, " + cuadruplas.getValueAt(i, 3) + "\n");
                                tercera += ("cmp eax,ebx \n");
                                
                                //tercera += ("menor:\n");
                                break;
                            case ">>":
                                tercera+="cuadrupla"+cuadruplas.getValueAt(i, 0)+":\n";
                                tercera += ("mov eax, " + cuadruplas.getValueAt(i, 2) + "\n");
                                tercera += ("mov ebx, " + cuadruplas.getValueAt(i, 3) + "\n");
                                tercera += ("cmp ebx,eax \n");
                                //tercera += ("mayor: \n");
                                break;
                            case "<=":
                                tercera+="cuadrupla"+cuadruplas.getValueAt(i, 0)+":\n";
                                tercera += ("mov eax, " + cuadruplas.getValueAt(i, 2) + "\n");
                                tercera += ("mov ebx, " + cuadruplas.getValueAt(i, 3) + "\n");
                                tercera += ("cmp ebx,eax \n");
                                
                                break;
                             case ">=":
                                 tercera+="cuadrupla"+cuadruplas.getValueAt(i, 0)+":\n";
                                tercera += ("mov eax, " + cuadruplas.getValueAt(i, 2) + "\n");
                                tercera += ("mov ebx, " + cuadruplas.getValueAt(i, 3) + "\n");
                                tercera += ("cmp ebx,eax \n");
                                
                                break;    
                            case "ir":
                                tercera += ("jmp cuadrupla"+ cuadruplas.getValueAt(i, 2)+"\n");
                                break;

                            default:
                                System.out.println("no entro la cuadrupla");
                        }
                    }

                }
            
            tercera += ("call quit");
            //p.println("mov eax, 1\n" +"int 0x80");
            p.println(imprimir_msg +"\n");
            p.print(segunda);
            p.println(tercera);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != archivo) {
                    archivo.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        return 1;
    }
}
