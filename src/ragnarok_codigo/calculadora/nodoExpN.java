/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ragnarok_codigo.calculadora;


public class nodoExpN {
	String num;
	nodoExpN sig;
	public nodoExpN() {
		// TODO Auto-generated constructor stub
		sig=null;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String it) {
		num = it;
	}
	public nodoExpN getSig() {
		return sig;
	}
	public void setSig(nodoExpN it) {
		sig = it;
	}
	
}
