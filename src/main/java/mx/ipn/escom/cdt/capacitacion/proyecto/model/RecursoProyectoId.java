package mx.ipn.escom.cdt.capacitacion.proyecto.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RecursoProyectoId implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3742164354490404877L;
	@Column(name="id_persona")
	private Integer idPersona;
	@Column(name="id_empresa")
	private Integer idEmpresa;
	@Column(name="id_proyecto")
	private Integer idProyecto;
	
	public RecursoProyectoId(Integer idPersona, Integer idEmpresa, Integer idProyecto) {
		super();
		this.idPersona = idPersona;
		this.idEmpresa = idEmpresa;
		this.idProyecto = idProyecto;
	}
	
	public Integer getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
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
