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
@Table(name="tipo_relacion")
public class TipoRelacion implements Model, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7415215985771147483L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tipo")
	private Integer idTipo;
	
	@Column(name="nb_tipo")
	private String nombre;
	
	public TipoRelacion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(Integer idTipo) {
		this.idTipo = idTipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "TipoRelacion [idTipo=" + idTipo + ", nombre=" + nombre + "]";
	}
}
