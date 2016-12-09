package mx.ipn.escom.cdt.capacitacion.proyecto.controller;

import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import mx.ipn.escom.cdt.capacitacion.informacionbase.model.Empresa;
import mx.ipn.escom.cdt.capacitacion.proyecto.bs.ProyectoBs;
import mx.ipn.escom.cdt.capacitacion.proyecto.model.EmpresaProyecto;
import mx.ipn.escom.cdt.capacitacion.proyecto.model.Proyecto;
import mx.ipn.escom.cdt.capacitacion.proyecto.model.TipoRelacion;
import mx.ipn.escom.cdt.util.bs.GenericSearchBs;


@Namespace("/proyecto")
@Results({
	@Result(name = "indexEmpresa", type = "redirectAction", params = { "actionName", "../informacion-base/gestionar-empresa" }) })
public class GestionarProyectoCtrl extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 800779678741252363L;
	
	private Proyecto model;
	private Integer idSel;
	private List<TipoRelacion> listTipoRelaciones;
	@Autowired
	private GenericSearchBs genericSearchBs;
	private EmpresaProyecto empresaProyecto;
	private Empresa empresa;
	private TipoRelacion tipoRelacion;
	@Autowired
	private ProyectoBs proyectoBs;
	
	public String index(){
		return "index";
	}
	
	public String editNew(){
		System.err.println(idSel);
		listTipoRelaciones = genericSearchBs.findAll(TipoRelacion.class);
		return "editNew";
	}
	
	public String create(){
		System.err.println(model);
		empresaProyecto.setIdEmpresa(idSel);
		proyectoBs.guardar(empresaProyecto, model);
		return "indexEmpresa";
	}

	public Proyecto getModel() {
		return model;
	}

	public void setModel(Proyecto model) {
		this.model = model;
	}

	public Integer getIdSel() {
		return idSel;
	}

	public void setIdSel(Integer idSel) {
		this.idSel = idSel;
	}

	public List<TipoRelacion> getListTipoRelaciones() {
		return listTipoRelaciones;
	}

	public void setListTipoRelaciones(List<TipoRelacion> listTipoRelaciones) {
		this.listTipoRelaciones = listTipoRelaciones;
	}

	public EmpresaProyecto getEmpresaProyecto() {
		return empresaProyecto;
	}

	public void setEmpresaProyecto(EmpresaProyecto empresaProyecto) {
		this.empresaProyecto = empresaProyecto;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public TipoRelacion getTipoRelacion() {
		return tipoRelacion;
	}

	public void setTipoRelacion(TipoRelacion tipoRelacion) {
		this.tipoRelacion = tipoRelacion;
	}
}
