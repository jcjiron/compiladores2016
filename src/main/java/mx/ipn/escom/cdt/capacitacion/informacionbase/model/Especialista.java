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

/**
 * @author rubik
 *
 */
@Entity
@Table(name="tib03_especialista")
public class Especialista implements Model{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_persona")
	private Integer idPersona;
	@Column(name="id_cuenta")
	private Integer idCuenta;
	@Column(name="nb_persona")
	private String	nombre;
	@Column(name="tx_primer_apellido")
	private String primerApellido;
	@Column(name="tx_segundo_apellido")
	private String segundoApellido;
	
	@OneToOne
	@JoinColumn(name="id_cuenta", referencedColumnName="id_cuenta", insertable=false, updatable=false)
	private Cuenta cuenta;

	public Integer getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
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

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	@Override
	public String toString() {
		return "Especialista [idPersona=" + idPersona + ", idCuenta=" + idCuenta + ", nombre=" + nombre
				+ ", primerApellido=" + primerApellido + ", segundoApellido=" + segundoApellido + ", cuenta="
				+ cuenta + "]";
	}
}
