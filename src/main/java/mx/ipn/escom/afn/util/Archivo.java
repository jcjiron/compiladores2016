package mx.ipn.escom.afn.util;

import java.io.File;
import java.io.Serializable;

import javax.persistence.Transient;

import mx.ipn.escom.cdt.util.model.Model;;

/**
 * Representa un archivo y contiene lo necesario para tratarse como talﬁ
 * 
 * @author Jorge Álvarez
 * @version 1.0 "Sep 28, 2015"
 */

public class Archivo implements Serializable, Model {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2778629277334743838L;

	/**
	 * Atributo transient que contiene al archivo que se adjunta al anexo
	 */
	@Transient
	private File fileUpload;

	/**
	 * Atributo transient que guarda el nombre del archivo que se adjunta
	 */
	@Transient
	private String fileUploadFileName;

	/**
	 * Atributo transient que guarda el tipo de formato del archivo que se
	 * adjunta
	 */
	@Transient
	private String fileUploadContentType;

	/**
	 * Atributo transient que indica si un anexo se va a actualizar en el
	 * servidor
	 */
	@Transient
	private Boolean forUpdate;

	/**
	 * Atributo transient que guarda la ruta del aarchivo temporal que se va a
	 * copiar
	 */
	@Transient
	private String urlTemporal;

	/**
	 * Constructor sin parámetros
	 */
	public Archivo() {
		super();
	}

	
	

	/**
	 * Obtiene el valor del atributo fileUpload.
	 * 
	 * @return fileUpload
	 */
	public File getFileUpload() {
		return fileUpload;
	}

	/**
	 * Establece el valor del atributo fileUpload.
	 *
	 * @param fileUpload
	 */
	public void setFileUpload(File fileUpload) {
		this.fileUpload = fileUpload;
	}

	/**
	 * Obtiene el valor del atributo fileUploadFileName.
	 * 
	 * @return fileUploadFileName
	 */
	public String getFileUploadFileName() {
		return fileUploadFileName;
	}

	/**
	 * Establece el valor del atributo fileUploadFileName.
	 *
	 * @param fileUploadFileName
	 */
	public void setFileUploadFileName(String fileUploadFileName) {
		this.fileUploadFileName = fileUploadFileName;
	}

	/**
	 * Obtiene el valor del atributo fileUploadContentType.
	 * 
	 * @return fileUploadContentType
	 */
	public String getFileUploadContentType() {
		return fileUploadContentType;
	}

	/**
	 * Establece el valor del atributo fileUploadContentType.
	 *
	 * @param fileUploadContentType
	 */
	public void setFileUploadContentType(String fileUploadContentType) {
		this.fileUploadContentType = fileUploadContentType;
	}

	/**
	 * Obtiene el valor del atributo forUpdate.
	 * 
	 * @return forUpdate
	 */
	public Boolean getForUpdate() {
		return forUpdate;
	}

	/**
	 * Establece el valor del atributo forUpdate.
	 *
	 * @param forUpdate
	 */
	public void setForUpdate(Boolean forUpdate) {
		this.forUpdate = forUpdate;
	}

	/**
	 * Obtiene el valor del atributo urlTemporal.
	 * 
	 * @return urlTemporal
	 */
	public String getUrlTemporal() {
		return urlTemporal;
	}

	/**
	 * Establece el valor del atributo urlTemporal.
	 *
	 * @param urlTemporal
	 */
	public void setUrlTemporal(String urlTemporal) {
		this.urlTemporal = urlTemporal;
	}




	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Archivo [fileUpload=" + fileUpload + ", fileUploadFileName="
				+ fileUploadFileName + ", fileUploadContentType="
				+ fileUploadContentType + ", forUpdate=" + forUpdate
				+ ", urlTemporal=" + urlTemporal + "]";
	}

	

	
}
