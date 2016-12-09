package mx.ipn.escom.afn.model;

import java.util.ArrayList;
import java.util.HashMap;

public class LexicoAFN implements ConstantesAFN{

	
	private ArrayList<Character> lexema;
	private ArrayList<Integer> token;
	private String expr;
	private HashMap<Character,Integer> coleccionLexemasTokens;
	
	int indice;

	
	public LexicoAFN(String expr){
		//le concatemanos el fin de cadena
		expr+='$';
				
		this.expr=expr;
		
		
		
		lexema=new ArrayList<Character>();
		token=new ArrayList<Integer>();
		indice=-1;
		
		
		coleccionLexemasTokens=new HashMap<Character,Integer>();
		
		coleccionLexemasTokens.put(CONCATENACION, TOKEN_CONCATENACION);
		coleccionLexemasTokens.put(OR, TOKEN_OR);
		coleccionLexemasTokens.put(CERRADURA_KLEENE, TOKEN_KLEENE);
		coleccionLexemasTokens.put(CERRADURA_POSITIVA, TOKEN_POSITIVO);
		coleccionLexemasTokens.put(OPCIONAL, TOKEN_OPCIONAL);
		coleccionLexemasTokens.put(PARENTESIS_DERECHO, TOKEN_DERECHO);
		coleccionLexemasTokens.put(PARENTESIS_IZQUIERDO, TOKEN_IZQUIERDO);
		coleccionLexemasTokens.put(FIN,TOKEN_FIN);
		
		for(int i=0;i<expr.length();i++){
			Character key=expr.charAt(i);
			if(coleccionLexemasTokens.containsKey(key)){
				token.add(coleccionLexemasTokens.get(key));
				lexema.add(key);
			}else{
				token.add(TOKEN_SIMBOLO);
				lexema.add(key);
			}
		}
	}
	
	public LexicoAFN(ArrayList<Character> l,ArrayList<Integer> t){
		lexema=l;
		token=t;
	}
	
	public ArrayList<Character> getLexemas() {
		return lexema;
	}

	public void setLexemas(ArrayList<Character> lexema) {
		this.lexema = lexema;
	}

	public ArrayList<Integer> getTokens() {
		return token;
	}

	public void setTokens(ArrayList<Integer> token) {
		this.token = token;
	}
	
	public int getToken(){
		indice++;
		int tok=token.get(indice);
		return tok;
	}
	
	public Character getLexema(){
		Character car=lexema.get(indice);
		return car;
	}
	
	public void regresarToken(){
		indice--;
	}
	
}
