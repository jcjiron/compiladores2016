package mx.ipn.escom.afn.util;

/**
 * Encargada de proporcionar valores númericos en tiempo de ejecución
 * 
 * @author Jorge Álvarez
 * @version 1.0 "Oct 4, 2015"
 */
public enum Numeros {
	UNO_NEGATIVO(-1), CERO(0), UNO(1), DOS(2), TRES(3), CUATRO(4), CINCO(5), SEIS(
			6), SIETE(7), OCHO(8), NUEVE(9), DIEZ(10), ONCE(11), DOCE(12), TRECE(
			13), CATORCE(14), QUINCE(15), TREINTA_UNO(31), CINCUENTA(50), CIEN(
			100), CIENTO_UNO(101), MIL(1000), SESENTA(60), SESSION(3600000);

	private int valor;

	private Numeros(int valor) {
		this.valor = valor;
	}

	/**
	 * Obtiene el valor del atributo valor.
	 * 
	 * @return valor
	 */
	public int getValor() {
		return valor;
	}

	/**
	 * Obtiene el valor del atributo valor.
	 * 
	 * @return valor
	 */
	public float getFlotante() {
		return (float) valor;
	}

	/**
	 * Establece el valor del atributo valor.
	 *
	 * @param valor
	 */
	public void setValor(int valor) {
		this.valor = valor;
	}

	public Integer getValorInteger() {
		return new Integer(this.valor);
	}

	public Double getValorDouble() {
		return new Double(this.valor);
	}
}