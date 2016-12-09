package mx.ipn.escom.cdt.capacitacion.proyecto.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import mx.ipn.escom.cdt.capacitacion.informacionbase.model.EspecialistaEmpresa;

@Entity
@Table(name = "recurso_proyecto")
public class RecursoProyecto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3431723772127868393L;

	@EmbeddedId
	private RecursoProyectoId id;

	@Column(name = "id_persona", insertable = false, updatable = false)
	private Integer idPersona;
	@Column(name = "id_empresa", insertable = false, updatable = false)
	private Integer idEmpresa;
	@Column(name = "id_proyecto", insertable = false, updatable = false)
	private Integer idProyecto;

	@ManyToOne
	@JoinColumns({@JoinColumn(name="id_proyecto", referencedColumnName="id_proyecto", insertable=false, updatable=false),
		@JoinColumn(name="id_empresa", referencedColumnName="id_empresa", insertable=false, updatable=false)})
	private EmpresaProyecto empresaProyecto;
	
	@ManyToOne
	@JoinColumns({@JoinColumn(name="id_persona", referencedColumnName="id_persona", insertable=false, updatable=false)})
	private EspecialistaEmpresa especialistaEmpresa;

	public RecursoProyecto(RecursoProyectoId id, Integer idPersona, Integer idEmpresa, Integer idProyecto,
			EmpresaProyecto empresaProyecto, EspecialistaEmpresa especialistaEmpresa) {
		super();
		this.id = id;
		this.idPersona = idPersona;
		this.idEmpresa = idEmpresa;
		this.idProyecto = idProyecto;
		this.empresaProyecto = empresaProyecto;
		this.especialistaEmpresa = especialistaEmpresa;
	}

	public RecursoProyectoId getId() {
		return id;
	}

	public void setId(RecursoProyectoId id) {
		this.id = id;
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
