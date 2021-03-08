/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ragnarok_codigo.calculadora;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;
public class Leer
{
   public String datoStr()
   {
      String sdato = "";
      try
      {
       BufferedReader bf;
       bf=new BufferedReader(new InputStreamReader(System.in));
       sdato=bf.readLine();
      }
      catch(IOException e)
      {
	     JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);
      }
      return sdato;
   }
   public int datoInt()
   {
	  int idato=0; 
      try
      { BufferedReader bf;
        bf=new BufferedReader(new InputStreamReader(System.in));
        idato=Integer.parseInt(bf.readLine());
      }
      catch(IOException e)
      {
	   JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);
      }
      return idato;
   }
   public float datoFloat()
   {
	   float fdato=0; 
	      try
	      { BufferedReader bf;
	        bf=new BufferedReader(new InputStreamReader(System.in));
	        fdato=Long.parseLong(bf.readLine());
	      }
	      catch(IOException e)
	      {
		    JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);
	      }
	      return fdato;
   }   
}
