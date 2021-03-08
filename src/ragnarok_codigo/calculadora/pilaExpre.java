/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ragnarok_codigo.calculadora;

import javax.swing.JOptionPane;

public class pilaExpre {
	private int n, cima;
	private String [] datos;
	public pilaExpre() {
		// TODO Auto-generated constructor stub
		n=100;
		cima=-1;
		datos=new String[n];
	}
	public boolean esvacia(){
		boolean x= cima==-1 ?true:false;
		return x;
	}
	public boolean esllena(){
		boolean x= cima==n-1 ?true:false;
		return x;
	}
	public void insertar(String x){
		if(esllena()){
			JOptionPane.showMessageDialog(null, "pila llena", "Error", JOptionPane.ERROR_MESSAGE);
		}
		else {
			cima++;
			datos [cima]=x;
			//System.out.println("dato entrante "+datos);
		}
	}
	public String eliminar() {
		String x="";
		if(esvacia()){
			//System.out.println("pila vacia");
		}
		else{
			x=datos[cima];
			cima--;
		}
		return x;
	}
	public void vaciar(pilaExpre x){
		while(!x.esvacia()){
			insertar(x.eliminar());
		}
	}

	public void mostrar(){
		String x;
		pilaExpre aux=new pilaExpre();
		while (!esvacia()){
			x=eliminar();
			aux.insertar(x);
		}
		vaciar(aux);
	}
	public int cantDatos(){
		return cima;
	}
}
