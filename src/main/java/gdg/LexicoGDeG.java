package gdg;

import java.util.ArrayList;
import java.util.HashMap;

import lexico.LexicoComportamiento;
import mx.ipn.escon.afn.calculadora.model.Lexico;



public class LexicoGDeG implements LexicoComportamiento{
	
	public static final String SEPARADOR=",";
	public static final String EMPTY="";
	
	private ArrayList<String> lexemas;
	private ArrayList<Integer> tokens;
	private int indice;
	private String exp;
	
	private HashMap<String,Integer> terminales;
	private HashMap<String,Integer> noTerminales;
	
	public LexicoGDeG(String cadTerminales,String cadNoTerminales, String exp){
		terminales=new HashMap<String,Integer>();
		noTerminales=new HashMap<String,Integer>();
		lexemas=new ArrayList<String>();
		tokens=new ArrayList<Integer>();
		this.exp=exp;
		indice=-1;
		
		String[] aux=cadTerminales.split(SEPARADOR); 
		int i;
		
		for(i=0;i<aux.length;i++){
			terminales.put(aux[i],i);
		}
		
		String[] aux2=cadNoTerminales.split(SEPARADOR); 
		
		for(int e=0;e<aux2.length;e++,i++){
			noTerminales.put(aux2[e],i);
		}
		
		separarNoTerminales();
	}
	
	private void separarNoTerminales(){
		String aux=EMPTY;
		
		for(int i=0;i<exp.length();i++){
			aux+=exp.charAt(i);
			
			if(terminales.containsKey(aux)){
				tokens.add(terminales.get(aux));
				lexemas.add(aux);
				aux=EMPTY;
			}else if(noTerminales.containsKey(aux)){
				tokens.add(noTerminales.get(aux));
				lexemas.add(aux);
				aux=EMPTY;
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

	@Override
	public Lexico getEdo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setEdo(Lexico lexic) {
		// TODO Auto-generated method stub
		
	}
	
	public HashMap<String,Integer> getTerminales(){
		return terminales;
	}
	
	public HashMap<String,Integer> getNoTerminales(){
		return noTerminales;
	}



}
