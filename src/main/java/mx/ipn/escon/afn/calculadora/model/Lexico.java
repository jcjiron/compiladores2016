package mx.ipn.escon.afn.calculadora.model;

import java.util.ArrayList;

public class Lexico {

	private ArrayList<String> lexema;
	private ArrayList<Integer> token;
	private int indice;
	

	
	public Lexico(ArrayList<String> lexema, ArrayList<Integer> token){
		this.lexema=lexema;
		this.token=token;
		indice=0;
		
	}
	
	public void setLexemas(ArrayList<String> lexema) {
		this.lexema = lexema;
	}

	public ArrayList<Integer> getTokens() {
		return token;
	}
	
	public ArrayList<String> getLexemas(){
		return lexema;
	}

	public void setTokens(ArrayList<Integer> token) {
		this.token = token;
	}
	
	public int getToken(){
		int tok=token.get(indice);
		indice++;
		return tok;
	}
	
	public String getLexema(){
		String cad=lexema.get(indice);
		return cad;
	}
	
	public void regresarToken(){
		indice--;
	}
	
	
	public Lexico getEdo(){
		 ArrayList<String> l=new ArrayList<>();
		 ArrayList<Integer> t=new ArrayList<>();
		 
		 l=getLexemas();
		 t=getTokens();
		 
		 return new Lexico(l,t);
	}
	
	public void setEdo(Lexico lexic){
		setLexemas(lexic.getLexemas());
		setTokens(lexic.getTokens());
	}
}
