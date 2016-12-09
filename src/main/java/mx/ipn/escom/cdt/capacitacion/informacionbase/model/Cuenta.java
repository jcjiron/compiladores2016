package mx.ipn.escom.cdt.capacitacion.informacionbase.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import mx.ipn.escom.cdt.util.model.Model;

@Entity
@Table(name = "tib01_cuenta")
public class Cuenta implements Model {
	/**
	 * Identificador único de la cuenta
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cuenta")
	private Integer idCuenta;

	/**
	 * Correo electrónico con base en el cual se ingresará al sistema
	 */
	@Column(name = "tx_correo")
	private String correo;

	/**
	 * Contraseña de acceso a la cuenta
	 */
	@Column(name = "tx_password")
	private String password;

	public Integer getIdCuenta() {
		return idCuenta;
	}

	public void setIdCuenta(Integer idCuenta) {
		this.idCuenta = idCuenta;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Cuenta [idCuenta=" + idCuenta + ", correo=" + correo + ", password=" + password + "]";
	}
}
