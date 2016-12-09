package mx.ipn.escom.cdt.capacitacion.proyecto.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EmpresaProyectoId implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4015403721586092490L;

	@Column(name="id_empresa")
	private Integer idEmpresa;
	
	@Column(name="id_proyecto")
	private Integer idProyecto;

	public EmpresaProyectoId() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmpresaProyectoId(Integer idEmpresa, Integer idProyecto) {
		super();
		this.idEmpresa = idEmpresa;
		this.idProyecto = idProyecto;
	}

	public Integer getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public Integer getIdProyecto() {
		return idProyecto;
	}

	public void setIdProyecto(Integer idProyecto) {
		this.idProyecto = idProyecto;
	}
}
