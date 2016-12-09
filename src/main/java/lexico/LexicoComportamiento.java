package lexico;

import java.util.ArrayList;

import mx.ipn.escon.afn.calculadora.model.Lexico;

public interface LexicoComportamiento {
	
	//llena la colecciones de lexemas que detectará el analilador lexico
	public void setLexemas(ArrayList<String> lexema);

	//obtiene una lista de tokens que admite el analizador lexico
	public ArrayList<Integer> getTokens();
	
	//regresa la coleccion de tokens que admite el analizador
	public ArrayList<String> getLexemas();

	//inicializa la coleccion de tokens que acepta el analizador lexico
	public void setTokens(ArrayList<Integer> token);
	
	//regresa el siguiente token en la pila
	public int getToken();
	
	//regresa el lexema actual en la pila
	public String getLexema();
	
	//regresa en la pila una posicion
	public void regresarToken();
	
	//obtiene el estado actual del analizador lexico
	public Lexico getEdo();
	
	//establece el estado del analizador lexico
	public void setEdo(Lexico lexic);
}
