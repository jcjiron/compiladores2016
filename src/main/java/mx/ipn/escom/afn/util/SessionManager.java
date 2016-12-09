package mx.ipn.escom.afn.util;

import com.opensymphony.xwork2.ActionContext;

public class SessionManager {
	/**
	 * M??todo proxy que regresa el objeto que se encuentra en la sesi??n con la
	 * llave especificada en nombre.
	 * 
	 * @param nombre
	 *            llave del objeto
	 * @return objeto que se obtuvo de la sesi??n
	 */
	public static Object get(String nombre) {
		return ActionContext.getContext().getSession().get(nombre);
	}

	/**
	 * M??todo proxy que sube un objeto a la sesi??n con culla llave se especifica
	 * en nombre
	 * 
	 * @param o
	 *            objeto a subir a la sesi??n
	 * @param nombre
	 *            llave del objeto
	 * @return objeto que se agreg?? a la sesi??n
	 */
	public static Object set(Object o, String nombre) {
		return ActionContext.getContext().getSession().put(nombre,o);
	}

	/**
	 * M??todo proxy que limpia la sesi??n.
	 */
	public static void clear() {
		ActionContext.getContext().getSession().clear();
	}

	/**
	 * M??todo proxy que elimina un objeto de la sesi??n cuya llave se especifica
	 * en nombre
	 * 
	 * @param nombre
	 *            llave del objeto
	 * @return objeto que se elimin?? de la sesi??n
	 */
	public static Object delete(String nombre) {
		return ActionContext.getContext().getSession().remove(nombre);
	}

	/**
	 * M??todo proxy que verifica si la sesi??n est?? limpia
	 * 
	 * @return false si la sesi??n no est?? limpia
	 */
	public boolean isEmpty() {
		return ActionContext.getContext().getSession().isEmpty();
	}
}
