package mx.ipn.escom.cdt.capacitacion.proyecto.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import mx.ipn.escom.cdt.util.model.Model;

@Entity
@Table(name="proyecto")
public class Proyecto implements Model, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -650764287416638333L;

	/**
	 * Identificador unico autogenerado de la empresa
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_proyecto")
	private Integer idProyecto;
	
	@Column(name="nb_proyecto")
	private String nombre;
	
	public Proyecto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Proyecto(Integer idProyecto, String nombre) {
		super();
		this.idProyecto = idProyecto;
		this.nombre = nombre;
	}

	public Integer getIdProyecto() {
		return idProyecto;
	}

	public void setIdProyecto(Integer idProyecto) {
		this.idProyecto = idProyecto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Proyecto [idProyecto=" + idProyecto + ", nombre=" + nombre + "]";
	}
	
	
}