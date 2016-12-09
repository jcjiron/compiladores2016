package mx.ipn.escom.cdt.capacitacion.informacionbase.controller;

import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import mx.ipn.escom.cdt.capacitacion.informacionbase.bs.EspecialistaBs;
import mx.ipn.escom.cdt.capacitacion.informacionbase.model.Cuenta;
import mx.ipn.escom.cdt.capacitacion.informacionbase.model.Empresa;
import mx.ipn.escom.cdt.capacitacion.informacionbase.model.Especialista;
import mx.ipn.escom.cdt.util.bs.GenericSearchBs;

@Namespace("/informacion-base")
public class GestionaEspecialistaCtrl extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5106679306226251035L;
	
	@Autowired
	private GenericSearchBs genericSearchBs;
	@Autowired
	private EspecialistaBs especialistaBs;
	private Integer idSel;
	private List<Especialista> listEspecialistas;
	private Empresa model;
	private Cuenta cuenta;
	
	public String index(){
		listEspecialistas = genericSearchBs.findAll(Especialista.class);
		return "index";
	}

	public String edit(){
		return "edit";
	}
	public String editNew(){
		return "editNew";
	}

	public String show(){
		return "show";
	}

	public String update(){
		return "index";
	}

	public String create(){
		return "index";
	}

	public String destroy(){
		return "index";
	}

	public Integer getIdSel() {
		return idSel;
	}

	public void setIdSel(Integer idSel) {
		this.idSel = idSel;
	}

	public List<Especialista> getListEspecialistas() {
		return listEspecialistas;
	}

	public void setListEspecialistas(List<Especialista> listEspecialistas) {
		this.listEspecialistas = listEspecialistas;
	}

	public Empresa getModel() {
		return model;
	}

	public void setModel(Empresa model) {
		this.model = model;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}
}
