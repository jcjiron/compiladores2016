package gdg;

import java.util.ArrayList;
import java.util.HashSet;

public class Gramatica {

	public static final String SEPARADOR_REGLAS=";";
	public static final String SALTO_DE_LINEA="\n";
	public static final String COMA=",";
	public static final String OR="@";
	public static final String FLECHA="->";
	public static final String ESPACIO=" ";
	public static final String EMPTY="";
	public static final String EPSILON="e";
	
	public static final int CERO=0;
	public static final String FIN_DE_LINEA = "$";
	
	private ArrayList<Production> productions; 
	private ArrayList<String> terminales;
	private ArrayList<String> noTerminales;
	private String exp;
	private Production start;
	
	//================================
	//================================
	//Variables de la tabla LR0
	private HashSet<Element> elementos;
	
	//================================
	//================================
	
	
	public Gramatica(String exp, String cadTerminales,String cadNoTerminales){
		productions=new ArrayList<Production>();
		terminales=new ArrayList<String>();
		noTerminales=new ArrayList<String>();
		this.exp=exp;
		
		elementos=null;
		
		String[] aux=cadTerminales.split(COMA);
		for(String terminal:aux){
			terminales.add(terminal);
		}
		
		String[] aux2=cadNoTerminales.split(COMA);
		for(String noTerminal:aux2){
			noTerminales.add(noTerminal);
		}
		
		separarReglas();
	}
	
	private void separarReglas(){
		String[] reglas=exp.split(SEPARADOR_REGLAS);
		
		for(String regla:reglas){
			//System.out.println(regla);
			String[] lados=regla.split(FLECHA);
			
			//System.out.println(lados[0]+COMA+lados[1]);
			String[] ladosDerechos=lados[1].split(OR);
			for(String ladoDerecho:ladosDerechos){
				//System.out.println("LadoD: "+ladoDerecho);
				String[] l=ladoDerecho.split(COMA);
				/*for(int i=0;i<l.length;i++){
					System.out.print(l[i]+" ");
				}*/
				//System.out.println("");
				productions.add(new Production(lados[0],l));
			}
		}
	}
	
	public ArrayList<String> first(String l){
		ArrayList<String> C=new ArrayList<String>();
		
		if(terminales.contains(l)||l.equals(EPSILON)){
			C.add(l);
			return C;
		}
		
		ArrayList<String> D=new ArrayList<String>();
		for(Production p: productions){
			String vnt=p.getLeft().getCad();
			
			if(vnt.equals(l)){
				String alpha0=p.getRight().getCad()[CERO];
				ArrayList<String> aux=first(alpha0);
				
				for(String auxCad:aux){
					if(!D.contains(auxCad)){
						D.add(auxCad);
					}
				}
			}
		}
		
		//D.remove(EPSILON);
		
		return D;
	}
	
	public ArrayList<String> first(Right r){
		ArrayList<String> C=new ArrayList<String>();
		String[] l=r.getCad();
		if(terminales.contains(l[CERO])||l[CERO].equals(EPSILON)){
			C.add(l[0]);
			return C;
		}
		
		ArrayList<String> D=new ArrayList<String>();
		for(Production p: productions){
			String vnt=p.getLeft().getCad();
			
			if(vnt.equals(l[0])){
				String alpha0=p.getRight().getCad()[CERO];
				ArrayList<String> aux=first(alpha0);
				
				for(String auxCad:aux){
					if(!D.contains(auxCad)){
						D.add(auxCad);
					}
				}
			}
		}
		
		//D.remove(EPSILON);
		
		return D;
	}
	
	public ArrayList<String> follow(String A){
		ArrayList<String> D =new ArrayList<String>();
		String e=productions.get(CERO).getLeft().getCad();
		if(e.equals(A)){
			D.add(FIN_DE_LINEA);
		}
		for(Production p:productions){
			String[] array=p.getRight().getCad();
			for(int i=0;i<array.length;i++){
				if(A.equals(array[i])){
					//System.out.println("Regla: "+p.toString()+"\t"+i);
					if(i>0&&i<array.length-1){
						//Regla B-> xAb
						//System.out.println("Regla: "+p.toString()+"\t"+i);
						ArrayList<String>T=first(array[i+1]);
						if(T.contains(EPSILON)){
							T.remove(EPSILON);
							for(String s:T){
								if(!D.contains(s))
									D.add(s);
							}
							for(String s:follow(array[i+1])){
								if(!D.contains(s))
									D.add(s);
							}
							
						}else{// si no contiene epsilon
							for(String s:first(array[i+1])){
								if(!D.contains(s))
									D.add(s);
							}
						}
					}else if(i==array.length-1){
						if(!array[i].equals(p.getLeft().getCad())){
						for(String s:follow(p.getLeft().getCad())){
							if(!D.contains(s))
								D.add(s);
						}
						}
					}
				}
			}
		}

		
		return D;
		
	}
	
	public void imprimirReglas(){
		
		for(int i=0;i<productions.size();i++){
			System.out.println(i+":"+productions.get(i).toString());
		}
	}
	
	public ArrayList<Production> getProductions() {
		return productions;
	}

	public void setProductions(ArrayList<Production> productions) {
		this.productions = productions;
	}

	public ArrayList<String> getTerminales() {
		return terminales;
	}

	public void setTerminales(ArrayList<String> terminales) {
		this.terminales = terminales;
	}

	public ArrayList<String> getNoTerminales() {
		return noTerminales;
	}

	public void setNoTerminales(ArrayList<String> noTerminales) {
		this.noTerminales = noTerminales;
	}

	public String getExp() {
		return exp;
	}

	public void setExp(String exp) {
		this.exp = exp;
	}

	public HashSet<Element> getElementos() {
		return elementos;
	}

	public void setElementos(HashSet<Element> elementos) {
		this.elementos = elementos;
	}

}
