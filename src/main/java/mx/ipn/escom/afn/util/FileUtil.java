package mx.ipn.escom.afn.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Clase de utileria que permitirá gestionar el manejo de archivos
 * 
 * @author
 * @version 1.0 "Sep 28, 2015"
 */
public class FileUtil {

	/**
	 * Nombre del archivo properties donde se va a leer la ruta de archivos
	 */
	private static final String PROPS_FILENAME = "global.properties";

	/**
	 * Ruta en el que serán almacenados los archivos
	 */
	private static String rutaDestinoPhotoGroup;
	/**
	 * Ruta en el que serán almacenados los archivos
	 */
	private static String rutaDestinoAgremet;
	
	/**
	 * Ruta en el que serán almacenados los archivos
	 */
	private static String rutaDestinoPhotoAddress;

	/**
	 * Ruta en donde se almacenarán los archivos temporales
	 */
	private static String rutaTemporal;

	/**
	 * Ruta temporal en donde se almacenarán los archivos temporales en la
	 * aplicacón
	 */
	private static String rutaTemporalWebapp;

	/**
	 * Ruta en donde se alamcenarán las fotos de perfil
	 */
	// private static String rutaArchivo;

	/**
	 * Elemento en donde se almacenarán las propiedades necesarias para el
	 * manejo de archivos
	 */
	private static Properties props;

	/**
	 * Instancia que permitirá escribir dentro del log de la aplicación
	 */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(FileUtil.class);

	/**
	 * Mensaje de error prodicido al no poder copiar un archivo
	 */
	private static final String ERROR_COPIA_ARCHIVO = "Error al copiar archivo";

	/**
	 * 1 KB
	 */
	public static final long KB_1 = 1024L;
	/**
	 * 1 KB
	 */
	public static final long KB_100 = 102400L;

	/**
	 * 2 KB
	 */
	public static final long KB_2 = 2048L;

	/**
	 * 1 MB
	 */
	public static final long MB_1 = 1048576L;

	/**
	 * 2 MB
	 */
	public static final long MB_2 = 2097152L;/**
	 * 2 MB
	 */
	public static final long MB_5 = 5242880L;
	

	/**
	 * Formato TXT
	 */
	public static final String TXT = "TXT";

	/**
	 * Formato PDF
	 */
	public static final String PDF = "PDF";

	/**
	 * Formato PNG
	 */
	public static final String PNG = "PNG";

	/**
	 * Formato JPG
	 */
	public static final String JPG = "JPG";

	/**
	 * Formato JPEG
	 */
	public static final String JPEG = "JPEG";

	/**
	 * Abre el archivo properties para leer las rutas necesarias para el manejo
	 * de archivos
	 */
	private static void init() {
		props = new Properties();
		InputStream input = null;
		try {
			input = Thread.currentThread().getContextClassLoader()
					.getResourceAsStream(PROPS_FILENAME);
			props.load(input);
		} catch (IOException ex) {
			
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					
				}
			}
		}
		rutaDestinoPhotoGroup = props.getProperty("ruta.destino.photoGroup");
		rutaTemporal = props.getProperty("ruta.temporal.archivo");
		rutaTemporalWebapp = props.getProperty("ruta.temportal.archivo.webapp");
		rutaDestinoAgremet= props.getProperty("ruta.destino.Agremet");
		rutaDestinoPhotoAddress= props.getProperty("ruta.destino.photoAddress");
	}

	/**
	 * Crea una copia del archivo en la ruta especificada para guardar archivos
	 * 
	 * @param fileUploadFileName
	 * 
	 * @return ruta donde se guardó el archivo
	 * @throws IOException
	 */
	public static String guardarArchivo(File file, String path, String fileName)
			throws IOException {
		String rutaArchivo = path + fileName;
		File fileDestino = new File(rutaArchivo);
		Integer i = Numeros.UNO.getValor();
		String nombreArchivo = fileDestino.getName().substring(0,
				fileDestino.getName().lastIndexOf("."));
		String extension = FilenameUtils.getExtension(fileDestino.getName());
		String nameFile = nombreArchivo + "." + extension;
		while (fileDestino.exists()) {
			nameFile = nombreArchivo + "(" + i + ")." + extension;
			rutaArchivo = path + nameFile;
			fileDestino = new File(rutaArchivo);
			i++;
		}
		try {
			FileUtils.copyFile(file, fileDestino);
		} catch (IOException e) {
			LOGGER.error(ERROR_COPIA_ARCHIVO, e);
			throw e;
		}
		return nameFile;
	}

	/**
	 * Método que crear una copia de un archivo temporal en la ruta
	 * 
	 * @param {@link Archivo} archivo: Es el archivo que contiene el archivo que
	 *        se va a guardar
	 * @return {@link String} cadena con el nombre del archivo que se guarda
	 */
	public static String guardarPhotoGroup(String path, String fileName) {
		init();
		File temp, nuevo;
		try {
			nuevo = new File(path + rutaDestinoPhotoGroup+"/" + fileName);
			temp = FileUtils
					.getFile(path + rutaTemporalWebapp + "/" + fileName);
			FileUtils.copyFile(temp, nuevo);
			temp.delete();
			return nuevo.getName();
		} catch (IOException e) {
			LOGGER.error(ERROR_COPIA_ARCHIVO, e);
			return null;
		}
	}

	/**
	 * Método que crear una copia de la foto de Group en la ruta temporal de la
	 * aplicación
	 * 
	 * @param {@link Archivo} archivo: Es el archivo que contiene el archivo que
	 *        se va a guardar
	 * @return {@link String} cadena con el nombre del archivo que se guarda
	 */
	public static String guardarPhotoGroupTemp(File archivo, String ruta,
			String nameFile) {
		init();
		
		String prefix = "Minuta";
		String suffix = "." + FilenameUtils.getExtension(nameFile);
		File temp;
		try {
			File path = new File(ruta + rutaTemporalWebapp + "/");
			System.err.println(path);
			if (!path.exists()) {
				path.mkdir();
			}
			temp = File.createTempFile(prefix, suffix, path);
			FileUtils.copyFile(archivo, temp);
			System.err.println(temp);
			return temp.getName();
		} catch (IOException e) {
			LOGGER.error(ERROR_COPIA_ARCHIVO, e);
			return null;
		}
	}
	/**
	 * Método que crear una copia de un archivo temporal en la ruta
	 * 
	 * @param {@link Archivo} archivo: Es el archivo que contiene el archivo que
	 *        se va a guardar
	 * @return {@link String} cadena con el nombre del archivo que se guarda
	 */
	public static String guardarAgremet(String path, String fileName) {
		init();
		File temp, nuevo;
		try {
			nuevo = new File(path + rutaDestinoAgremet+"/" + fileName);
			System.err.println(nuevo.getAbsolutePath());
			temp = FileUtils
					.getFile(path + rutaTemporalWebapp + "/" + fileName);
			System.err.println(temp.getAbsolutePath());
			FileUtils.copyFile(temp, nuevo);
			temp.delete();
			return nuevo.getName();
		} catch (IOException e) {
			LOGGER.error(ERROR_COPIA_ARCHIVO, e);
			return null;
		}
	}

	/**
	 * Método que crear una copia de la foto de Group en la ruta temporal de la
	 * aplicación
	 * 
	 * @param {@link Archivo} archivo: Es el archivo que contiene el archivo que
	 *        se va a guardar
	 * @return {@link String} cadena con el nombre del archivo que se guarda
	 */
	public static String guardarAgrementTemp(File archivo, String ruta,
			String nameFile) {
		init();
		String prefix = "Agrement";
		String suffix = "." + FilenameUtils.getExtension(nameFile);
		File temp;
		try {
			File path = new File(ruta + rutaTemporalWebapp + "/");
			if (!path.exists()) {
				path.mkdir();
			}
			temp = File.createTempFile(prefix, suffix, path);
			FileUtils.copyFile(archivo, temp);
			return temp.getName();
		} catch (IOException e) {
			LOGGER.error(ERROR_COPIA_ARCHIVO, e);
			return null;
		}
	}
	/**
	 * Método que crear una copia de un archivo temporal en la ruta
	 * 
	 * @param {@link Archivo} archivo: Es el archivo que contiene el archivo que
	 *        se va a guardar
	 * @return {@link String} cadena con el nombre del archivo que se guarda
	 */
	public static String guardarPhotoAddress(String path, String fileName) {
		init();
		File temp, nuevo;
		try {
			nuevo = new File(path + rutaDestinoPhotoAddress+"/" + fileName);
			System.err.println(nuevo.getAbsolutePath());
			temp = FileUtils
					.getFile(path + rutaTemporalWebapp + "/" + fileName);
			System.err.println(temp.getAbsolutePath());
			FileUtils.copyFile(temp, nuevo);
			temp.delete();
			return nuevo.getName();
		} catch (IOException e) {
			LOGGER.error(ERROR_COPIA_ARCHIVO, e);
			return null;
		}
	}

	/**
	 * Método que crear una copia de la foto de Group en la ruta temporal de la
	 * aplicación
	 * 
	 * @param {@link Archivo} archivo: Es el archivo que contiene el archivo que
	 *        se va a guardar
	 * @return {@link String} cadena con el nombre del archivo que se guarda
	 */
	public static String guardarPhotoAddresstTemp(File archivo, String ruta,
			String nameFile) {
		init();
		String prefix = "photoAddress";
		String suffix = "." + FilenameUtils.getExtension(nameFile);
		File temp;
		try {
			File path = new File(ruta + rutaTemporalWebapp + "/");
			if (!path.exists()) {
				path.mkdir();
			}
			temp = File.createTempFile(prefix, suffix, path);
			FileUtils.copyFile(archivo, temp);
			return temp.getName();
		} catch (IOException e) {
			LOGGER.error(ERROR_COPIA_ARCHIVO, e);
			return null;
		}
	}
	/**
	 * Borra el file
	 * 
	 * @param archivo
	 *            : con el file y la ruta a borrar
	 */
	public static void borrarArchivo(String archivo) {
		init();
		System.err.println(rutaTemporalWebapp + "/" + archivo);
		File fileTemporal = new File(rutaTemporalWebapp + "/" + archivo);
		System.err.println(fileTemporal.getName());
		fileTemporal.delete();

	}

	/**
	 * Borra el file que se guardo de forma temporal
	 * 
	 * @param archivo
	 *            : con el file y la ruta a borrar
	 */
	public static void borrarTemporalWebapp(String ruta, String nombre) {
		init();
		File fileTemporal = new File(ruta + rutaTemporalWebapp + "/" + nombre);
		fileTemporal.delete();
	}

	/**
	 * Borra el file que se guardo de forma temporal
	 * 
	 * @param archivo
	 *            : con el file y la ruta a borrar
	 */
	public static void borrarFoto(String ruta, String nombre) {
		init();
		File fileTemporal = new File(ruta + "/" + nombre);
		fileTemporal.delete();
	}

	/**
	 * Verifica que el tamaño del archivo sea menor al especificado
	 * 
	 * @param archivo
	 * @param size
	 * @return true en caso de que el tamaño del archivo sea mayor al
	 *         especificado, false en caso contrario
	 */
	public static Boolean sizeFile(File archivo, Long size) {
		return archivo.length() > size;
	}

	/**
	 * Valida el formato del archivo
	 * 
	 * @return true si el formato se encuentra dentro de la lista de formátos
	 *         válidos false en caso contrario o si el objeto formato es nulo
	 */
	public static Boolean validarFormato(String nameFile, String[] formatos) {
		if (formatos == null) {
			return false;
		}
		for (String formato : formatos) {
			if (formato.equalsIgnoreCase(FilenameUtils.getExtension(nameFile))) {
				return true;
			}
		}
		return false;
	}

	public static Properties getPropertiesFile(String fileName) {
		props = new Properties();
		InputStream input = null;
		try {
			input = Thread.currentThread().getContextClassLoader()
					.getResourceAsStream(fileName);
			props.load(input);
		} catch (IOException ex) {
			
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					
				}
			}
		}
		return props;
	}

	

	/**
	 * @return the rutaDestinoAgremet
	 */
	public static String getRutaDestinoAgremet() {
		return rutaDestinoAgremet;
	}

	/**
	 * @param rutaDestinoAgremet the rutaDestinoAgremet to set
	 */
	public static void setRutaDestinoAgremet(String rutaDestinoAgremet) {
		FileUtil.rutaDestinoAgremet = rutaDestinoAgremet;
	}

	/**
	 * @return the rutaDestinoPhotoAddress
	 */
	public static String getRutaDestinoPhotoAddress() {
		return rutaDestinoPhotoAddress;
	}

	/**
	 * @param rutaDestinoPhotoAddress the rutaDestinoPhotoAddress to set
	 */
	public static void setRutaDestinoPhotoAddress(String rutaDestinoPhotoAddress) {
		FileUtil.rutaDestinoPhotoAddress = rutaDestinoPhotoAddress;
	}

	/**
	 * @return the rutaDestinoPhotoGroup
	 */
	public static String getRutaDestinoPhotoGroup() {
		return rutaDestinoPhotoGroup;
	}

	/**
	 * @param rutaDestinoPhotoGroup the rutaDestinoPhotoGroup to set
	 */
	public static void setRutaDestinoPhotoGroup(String rutaDestinoPhotoGroup) {
		FileUtil.rutaDestinoPhotoGroup = rutaDestinoPhotoGroup;
	}

	/**
	 * @return the rutaTemporalWebapp
	 */
	public static String getRutaTemporalWebapp() {
		return rutaTemporalWebapp;
	}

	/**
	 * @param rutaTemporalWebapp the rutaTemporalWebapp to set
	 */
	public static void setRutaTemporalWebapp(String rutaTemporalWebapp) {
		FileUtil.rutaTemporalWebapp = rutaTemporalWebapp;
	}

	/**
	 * @return the rutaTemporal
	 */
	public static String getRutaTemporal() {
		return rutaTemporal;
	}

	/**
	 * @param rutaTemporal
	 *            the rutaTemporal to set
	 */
	public static void setRutaTemporal(String rutaTemporal) {
		FileUtil.rutaTemporal = rutaTemporal;
	}
}
