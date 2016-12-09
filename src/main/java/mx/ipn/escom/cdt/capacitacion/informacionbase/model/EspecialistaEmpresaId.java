package mx.ipn.escom.cdt.capacitacion.informacionbase.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EspecialistaEmpresaId implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6615146332923491939L;
	
	@Column(name="id_persona")
	private Integer idPersona;
	@Column(name="id_empresa")
	private Integer idEmpresa;
	
	public EspecialistaEmpresaId(Integer idPersona, Integer idEmpresa) {
		super();
		this.idPersona = idPersona;
		this.idEmpresa = idEmpresa;
	}
	
	public EspecialistaEmpresaId() {
		super();
		// TODO Auto-generated constructor stub
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

	@Override
	public String toString() {
		return "EspecialistaEmpresaId [idPersona=" + idPersona + ", idEmpresa=" + idEmpresa + "]";
	}
}
