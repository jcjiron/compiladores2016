package mx.ipn.escom.ll1.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;

import com.opensymphony.xwork2.ActionSupport;

import ll1.LL1;
import mx.ipn.escom.afn.util.NombreObjetosSesion;
import mx.ipn.escom.afn.util.SessionManager;

@Namespace("/compiladores")
public class Ll1Ctrl extends ActionSupport {

	private String vt;

	private String vnt;

	private String reglas;

	private String regla;

	private LL1 ll1;

	private List<String> listReglas;
	
	

	public String index() {

		SessionManager.set("2", NombreObjetosSesion.ACTION);
		listReglas = (List<String>) SessionManager.get(NombreObjetosSesion.LISTA_REGLAS);
		if (listReglas == null) {
			listReglas = new ArrayList<>();
		}
		SessionManager.set(listReglas, NombreObjetosSesion.LISTA_REGLAS);
		return "index";
	}

	public String create() {
		vt = vt + ",e";// se le agrega el e
		reglas = new String();
		listReglas = (List<String>) SessionManager.get(NombreObjetosSesion.LISTA_REGLAS);
		for (String regla : listReglas) {
			reglas = reglas + regla;
		}

		System.err.println(vt + "  " + vnt + "  " + reglas);

		ll1 = new LL1(vt, vnt, reglas);
		ll1.imprimirTablaLL1();

		
		String cadena = "28+5*(16-9)";
		ll1.validarCadena(cadena);
		return "ll1";
	}

	public String agregarRegla() {
		listReglas = (List<String>) SessionManager.get(NombreObjetosSesion.LISTA_REGLAS);
		if (listReglas == null) {
			listReglas = new ArrayList<>();
		} else {
			listReglas.add(regla);
		}
		SessionManager.set(listReglas, NombreObjetosSesion.LISTA_REGLAS);
		return "agregarRegla";
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

	public List<String> getListReglas() {
		return listReglas;
	}

	public void setListReglas(List<String> listReglas) {
		this.listReglas = listReglas;
	}

	public String getRegla() {
		return regla;
	}

	public void setRegla(String regla) {
		this.regla = regla;
	}

	
	
}
