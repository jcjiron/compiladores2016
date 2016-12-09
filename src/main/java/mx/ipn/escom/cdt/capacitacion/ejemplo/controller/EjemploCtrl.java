package mx.ipn.escom.cdt.capacitacion.ejemplo.controller;

import org.apache.struts2.convention.annotation.Namespace;

import com.opensymphony.xwork2.ActionSupport;

@Namespace("/ejemplo")
public class EjemploCtrl extends ActionSupport {

	/**
	 * 
	 */
	String idSel;

	private static final long serialVersionUID = 1L;

	public String index() {
		return "index";
	}

	public String show() {
		return "show";
	}

	public String getIdSel() {
		return idSel;
	}

	public void setIdSel(String idSel) {
		System.err.println(idSel);
		this.idSel = idSel;
	}
}
