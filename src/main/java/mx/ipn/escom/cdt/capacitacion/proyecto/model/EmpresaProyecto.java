package mx.ipn.escom.cdt.capacitacion.proyecto.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import mx.ipn.escom.cdt.capacitacion.informacionbase.model.Empresa;
import mx.ipn.escom.cdt.util.model.Model;

@Entity
@Table(name="empresa_proyecto")
public class EmpresaProyecto implements Model, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1311964645892430258L;

	@EmbeddedId
	private EmpresaProyectoId empresaProyectoId;
	
	@Column(name="id_empresa", insertable = false, updatable=false)
	private Integer idEmpresa;
	
	@Column(name="id_proyecto", insertable = false, updatable=false)
	private Integer idProyecto;
	
	@Column(name="id_tipo")
	private Integer idTipo;
	
	@ManyToOne
	@JoinColumn(name="id_empresa", referencedColumnName="id_empresa", insertable=false, updatable=false)
	private Empresa empresa;
	
	@ManyToOne
	@JoinColumn(name="id_proyecto", referencedColumnName="id_proyecto", insertable=false, updatable=false)
	private Proyecto proyecto;
	
	@ManyToOne
	@JoinColumn(name="id_tipo", referencedColumnName="id_tipo", insertable=false, updatable=false)
	private TipoRelacion tipoRelacion;

	public EmpresaProyecto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmpresaProyecto(EmpresaProyectoId empresaProyectoId, Integer idEmpresa, Integer idProyecto, Empresa empresa,
			Proyecto proyecto, TipoRelacion tipoRelacion) {
		super();
		this.empresaProyectoId = empresaProyectoId;
		this.idEmpresa = idEmpresa;
		this.idProyecto = idProyecto;
		this.empresa = empresa;
		this.proyecto = proyecto;
		this.tipoRelacion = tipoRelacion;
	}

	public EmpresaProyectoId getEmpresaProyectoId() {
		return empresaProyectoId;
	}

	public void setEmpresaProyectoId(EmpresaProyectoId empresaProyectoId) {
		this.empresaProyectoId = empresaProyectoId;
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

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	public TipoRelacion getTipoRelacion() {
		return tipoRelacion;
	}

	public void setTipoRelacion(TipoRelacion tipoRelacion) {
		this.tipoRelacion = tipoRelacion;
	}
	
	public Integer getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(Integer idTipo) {
		this.idTipo = idTipo;
	}

	@Override
	public String toString() {
		return "EmpresaProyecto [empresaProyectoId=" + empresaProyectoId + ", idEmpresa=" + idEmpresa + ", idProyecto="
				+ idProyecto + ", idTipo=" + idTipo + ", empresa=" + empresa + ", proyecto=" + proyecto
				+ ", tipoRelacion=" + tipoRelacion + "]";
	}	
	
}
