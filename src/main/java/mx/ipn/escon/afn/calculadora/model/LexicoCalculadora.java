package mx.ipn.escon.afn.calculadora.model;

import java.util.ArrayList;
import java.util.HashMap;

public class LexicoCalculadora implements ConstantesCalc{

	public static final String EMPTY="";


	private HashMap<Character,Integer> coleccionTokenLexema;

	private ArrayList<Integer> tokens;
	private ArrayList<String> lexemas;
	private String exp;
	private int indice;
	
	public LexicoCalculadora(){

		
		tokens=new ArrayList<Integer>();
		lexemas=new ArrayList<String>();
		exp="";
		indice=-1;
		
		coleccionTokenLexema=new HashMap<Character,Integer>();
		
		coleccionTokenLexema.put(SUMA, TOKEN_SUMA);
		coleccionTokenLexema.put(RESTA, TOKEN_RESTA);
		coleccionTokenLexema.put(MULTIPLICACION, TOKEN_MULTIPLICACION);
		coleccionTokenLexema.put(DIVISION, TOKEN_DIVISION);
		coleccionTokenLexema.put(PARENTESIS_DER, TOKEN_PARENTESIS_DER);
		coleccionTokenLexema.put(PARENTESIS_IZQ, TOKEN_PARENTESIS_IZQ);
		coleccionTokenLexema.put(POTENCIA, TOKEN_POTENCIA);
	}
	
	public LexicoCalculadora(String exp){
		tokens=new ArrayList<Integer>();
		lexemas=new ArrayList<String>();
		exp+='$';
		this.exp=exp;
		indice=-1;
		
		coleccionTokenLexema=new HashMap<Character,Integer>();
		
		coleccionTokenLexema.put(SUMA, TOKEN_SUMA);
		coleccionTokenLexema.put(RESTA, TOKEN_RESTA);
		coleccionTokenLexema.put(MULTIPLICACION, TOKEN_MULTIPLICACION);
		coleccionTokenLexema.put(DIVISION, TOKEN_DIVISION);
		coleccionTokenLexema.put(PARENTESIS_DER, TOKEN_PARENTESIS_DER);
		coleccionTokenLexema.put(PARENTESIS_IZQ, TOKEN_PARENTESIS_IZQ);
		coleccionTokenLexema.put(POTENCIA, TOKEN_POTENCIA);
		coleccionTokenLexema.put(FIN, TOKEN_FIN);

	}
	
	public void separarNoTerminales(){
		String aux=EMPTY;
		for(int i=0;i<exp.length();i++){
			Character car=exp.charAt(i);
			
			if(!coleccionTokenLexema.containsKey(car)){
				aux+=car;
			}else{
				if(!aux.equals(EMPTY)){
					tokens.add(TOKEN_NUM);
					lexemas.add(aux);
					
					tokens.add(coleccionTokenLexema.get(car));
					lexemas.add(EMPTY+car);
					
					aux=EMPTY;
				}else{
					tokens.add(coleccionTokenLexema.get(car));
					lexemas.add(EMPTY+car);
				}
			}
		}
	}
	
	public int getToken(){
		return tokens.get(++indice);
	}
	
	public String getLexema(){
		return lexemas.get(indice);
	}
	
	public void regresarToken(){
		indice--;
	}

	
	public void setExp(String exp){
		this.exp=exp;
	}
	
	public String getExp(){
		return exp;
	}
	
	public ArrayList<Integer> getTokens() {
		return tokens;
	}

	public void setTokens(ArrayList<Integer> tokens) {
		this.tokens = tokens;
	}

	public ArrayList<String> getLexemas() {
		return lexemas;
	}

	public void setLexemas(ArrayList<String> lexemas) {
		this.lexemas = lexemas;
	}
	
	
}
