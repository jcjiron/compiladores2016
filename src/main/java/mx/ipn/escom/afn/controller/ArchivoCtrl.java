package mx.ipn.escom.afn.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;

import com.opensymphony.xwork2.ActionSupport;

import mx.ipn.escom.afn.model.AFN;
import mx.ipn.escom.afn.model.SintacticoAFN;
import mx.ipn.escom.afn.util.Archivo;
import mx.ipn.escom.afn.util.FileUtil;
import mx.ipn.escom.afn.util.NombreObjetosSesion;
import mx.ipn.escom.afn.util.SessionManager;

/**
 * @author pared
 *
 */
@Namespace("/thompson")
public class ArchivoCtrl extends ActionSupport {

	private Archivo archivo;
	
	ServletContext context;
	
	private String nombreFotoPerfil;
	
	private String cadena;
	private AFN f;
	private List<String> listToken;
	
	public String index(){
		SessionManager.set("2", NombreObjetosSesion.ACTION);
		return "index";
	}
	
	public String editNew(){
		
		return "editNew";
	}
	
	public void validateCreate() {
		
		if (archivo.getFileUploadFileName() == null || archivo.getFileUploadFileName().isEmpty()) {
			System.err.println("EStoy en el if");
			addFieldError("archivo.fileUpload", "Seleccione un archivo");
		}

		if (archivo.getFileUploadFileName() != null) {
			byte[] bFile = new byte[(int) archivo.getFileUpload().length()];
			try {
				if (FileUtil.sizeFile(archivo.getFileUpload(), FileUtil.MB_5)
						|| !FileUtil.validarFormato(archivo.getFileUploadFileName(), new String[] { FileUtil.TXT })) {
					System.err.println("aqui2");
					addFieldError("fileUpload", "error foto");
				} else {
					System.err.println("aqui");
					nombreFotoPerfil = (String) SessionManager.get(NombreObjetosSesion.ARCHIVO);
					FileInputStream fileInputStream = new FileInputStream(archivo.getFileUpload());
					fileInputStream.read(bFile);
					fileInputStream.close();
					context = ServletActionContext.getServletContext();

					FileUtil.borrarTemporalWebapp(context.getRealPath("/"), nombreFotoPerfil);
					nombreFotoPerfil = FileUtil.guardarPhotoGroupTemp(archivo.getFileUpload(), context.getRealPath("/"),
							archivo.getFileUploadFileName());
					SessionManager.set(nombreFotoPerfil, NombreObjetosSesion.ARCHIVO);


				}
			} catch (IOException e) {

			}
		} else {
			if (nombreFotoPerfil.isEmpty() || nombreFotoPerfil == null) {
				addFieldError("fileUpload", getText("MSG2"));
				nombreFotoPerfil = (String) SessionManager.get(NombreObjetosSesion.ARCHIVO);
			}
		}

		System.err.println(hasActionErrors() + " " + hasFieldErrors());
		Set<String> keys = getFieldErrors().keySet();
		for (String k : keys) {
			System.err.println("->" + k + ": " + getFieldErrors().get(k));
		}

		
	}
	
	public String create() {
		SintacticoAFN sintactico=new SintacticoAFN();
		

		if (nombreFotoPerfil != null && !nombreFotoPerfil.isEmpty()) {
			context = ServletActionContext.getServletContext();
			String path="src/main/webapp/resources/images/material/";
			path+=FileUtil.guardarPhotoGroup(context.getRealPath("/"), nombreFotoPerfil);
			System.err.println(path);
			if(sintactico.cargarArchivo(path)){
		    	  f=sintactico.unionEspecial();
		    	 SessionManager.set(f, NombreObjetosSesion.AFN);
		         
		     }else{
		    	 System.out.println("Hubo un error en las expresiones del archivo");
		     }
		}
		
		
		
		
		return "validarCadena";
	}

	public String validarCadena() {
		System.err.println(cadena);
		  f = (AFN) SessionManager.get(NombreObjetosSesion.AFN);
		// String cadena="ababcdefcdghijij";
         f.validarCadena(cadena);
         
         listToken = new ArrayList<>();
         
            for(int t:f.getToken()){
            	System.out.println(t);
            	Integer num = t;
            	listToken.add(num.toString());
            }
            
            
		return "validacion";
	}
	
	public Archivo getArchivo() {
		return archivo;
	}

	public void setArchivo(Archivo archivo) {
		this.archivo = archivo;
	}

	public String getNombreFotoPerfil() {
		return nombreFotoPerfil;
	}

	public void setNombreFotoPerfil(String nombreFotoPerfil) {
		this.nombreFotoPerfil = nombreFotoPerfil;
	}

	public String getCadena() {
		return cadena;
	}

	public void setCadena(String cadena) {
		this.cadena = cadena;
	}

	public AFN getF() {
		return f;
	}

	public void setF(AFN f) {
		this.f = f;
	}

	public List<String> getListToken() {
		return listToken;
	}

	public void setListToken(List<String> listToken) {
		this.listToken = listToken;
	}

	
	
	
}
