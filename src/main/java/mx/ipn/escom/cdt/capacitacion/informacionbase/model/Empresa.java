package mx.ipn.escom.cdt.capacitacion.informacionbase.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import mx.ipn.escom.cdt.util.model.Model;

@Entity
@Table(name="tib02_empresa")
public class Empresa implements Model{
	
	/**
	 * Identificador unico autogenerado de la empresa
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_empresa")
	private Integer idEmpresa;
	
	/**
	 * Identtificador de la @link{Cuenta} asociado a la @link{Empresa}
	 */
	@Column(name="id_cuenta")
	private Integer idCuenta;
	
	/**
	 * Razon social de la empresa
	 */
	@Column(name="nb_empresa")
	private String nombre;
	
	/**
	 * 
	 */
	@OneToOne
	@JoinColumn(name="id_cuenta", referencedColumnName="id_cuenta", insertable=false, updatable=false)
	private Cuenta cuenta;

	public Integer getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public Integer getIdCuenta() {
		return idCuenta;
	}

	public void setIdCuenta(Integer idCuenta) {
		this.idCuenta = idCuenta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	@Override
	public String toString() {
		return "Empresa [idEmpresa=" + idEmpresa + ", idCuenta=" + idCuenta + ", nombre=" + nombre + ", cuenta="
				+ cuenta + "]";
	}
}
