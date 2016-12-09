package mx.ipn.escom.cdt.capacitacion.informacionbase.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import mx.ipn.escom.cdt.util.model.Model;

@Entity
@Table(name="tib04_especialista_empresa")
public class EspecialistaEmpresa implements Model{
	
	@EmbeddedId
	private EspecialistaEmpresaId id;
	
	@Column(name="id_empresa", insertable=false, updatable=false)
	private Integer idEmpresa;
	@Column(name="id_persona", insertable=false, updatable=false)
	private Integer idPersona;
	
	@ManyToOne
	@JoinColumn(name="id_empresa", referencedColumnName="id_empresa", insertable=false, updatable=false)
	private Empresa empresa;
	
	@ManyToOne
	@JoinColumn(name="id_persona", referencedColumnName="id_persona", insertable=false, updatable=false)
	private Especialista especialista;
	
	public EspecialistaEmpresa() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EspecialistaEmpresa(EspecialistaEmpresaId id, Integer idEmpresa, Integer idPersona, Empresa empresa,
			Especialista especialista) {
		super();
		this.id = id;
		this.idEmpresa = idEmpresa;
		this.idPersona = idPersona;
		this.empresa = empresa;
		this.especialista = especialista;
	}
	
	public EspecialistaEmpresaId getId() {
		return id;
	}
	public void setId(EspecialistaEmpresaId id) {
		this.id = id;
	}
	public Integer getIdEmpresa() {
		return idEmpresa;
	}
	public void setIdEmpresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	public Integer getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	public Especialista getEspecialista() {
		return especialista;
	}
	public void setEspecialista(Especialista especialista) {
		this.especialista = especialista;
	}

	@Override
	public String toString() {
		return "EspecialistaEmpresa [id=" + id + ", idEmpresa=" + idEmpresa + ", idPersona=" + idPersona + ", empresa="
				+ empresa + ", especialista=" + especialista + "]";
	}
	
}
