/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ragnarok_codigo.calculadora;

import java.util.Scanner;

public class principalCF {

    public String resultado_calculadora(String expreAr, String regresar) {
        listaSimNor exArit = new listaSimNor();
        String preparado = exArit.preparaCadena(expreAr);
        exArit.llenaLista(preparado);
        //exArit.mostrar();
        boolean a = exArit.valida();//valida la operación retorna un dato booleano
        //String k=exArit.enviaKaesimo(5);//45+98+7
        //exArit.mostrar();
        String res = exArit.resolver(a);
        if (regresar.equals("entero")) {
            int resultado = (int) Double.parseDouble(res);
            res = resultado + "";
        } else if (regresar.equals("decimal")) {
            double resultado_decimal = Double.parseDouble(res);
            res = resultado_decimal + "";
        }

        return res;
    }
}
