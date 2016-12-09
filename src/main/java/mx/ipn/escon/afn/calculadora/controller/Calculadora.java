package mx.ipn.escon.afn.calculadora.controller;

import org.apache.struts2.convention.annotation.Namespace;

import com.opensymphony.xwork2.ActionSupport;

import mx.ipn.escon.afn.calculadora.model.MiFloat;
import mx.ipn.escon.afn.calculadora.model.SintacticoCalculadora;

@Namespace("/thompson")
public class Calculadora extends ActionSupport {

	private String cadena;
	private float resultado;
	private boolean valida;

	public String index() {

		return "index";
	}

	public String calcular() {
		SintacticoCalculadora sintac = new SintacticoCalculadora(cadena);

		MiFloat f = new MiFloat();
		valida=sintac.sintac(f);
		resultado= f.getF();
		return "calcular";
	}

	public String getCadena() {
		return cadena;
	}

	public void setCadena(String cadena) {
		this.cadena = cadena;
	}

	public float getResultado() {
		return resultado;
	}

	public void setResultado(float resultado) {
		this.resultado = resultado;
	}

	public boolean isValida() {
		return valida;
	}

	public void setValida(boolean valida) {
		this.valida = valida;
	}

	

}
