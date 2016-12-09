package mx.ipn.escom.ll1.controller;

import org.apache.struts2.convention.annotation.Namespace;

import com.opensymphony.xwork2.ActionSupport;

import ll1.LL1;
import mx.ipn.escom.afn.util.NombreObjetosSesion;
import mx.ipn.escom.afn.util.SessionManager;


@Namespace("/compiladores")
public class Ll1Ctrl extends ActionSupport{

	private String vt;
	
	private String vnt;
	
	private String reglas;
	
	private LL1 ll1;
	
	public String index() {
		
		 SessionManager.set("2", NombreObjetosSesion.ACTION);
		 
		 
		return "index";
	}
	
	public String create(){
		vt = vt+",e";//se le agrega el e
		System.err.println(vt+"  "+vnt+"  "+reglas);
		
		 ll1=new LL1( vt,  vnt, reglas);
		ll1.imprimirTablaLL1();
		
		String cadena="28+5*(16-9)";
		ll1.validarCadena(cadena);
		return "ll1";
	}

	public String getVt() {
		return vt;
	}

	public void setVt(String vt) {
		this.vt = vt;
	}

	public String getVnt() {
		return vnt;
	}

	public void setVnt(String vnt) {
		this.vnt = vnt;
	}

	public String getReglas() {
		return reglas;
	}

	public void setReglas(String reglas) {
		this.reglas = reglas;
	}

	public LL1 getLl1() {
		return ll1;
	}

	public void setLl1(LL1 ll1) {
		this.ll1 = ll1;
	}
	
	
	
}
