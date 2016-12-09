package ll1;

import java.util.ArrayList;

import gdg.Gramatica;
import gdg.Production;
import mx.ipn.escon.afn.calculadora.model.ConstantesCalc;
import mx.ipn.escon.afn.calculadora.model.LexicoCalculadora;

public class LL1 implements ConstantesCalc{

	private static final String ERROR_EN_TABLA_LL1 = "-1";
	private static final String POP="POP";
	private static final String ACCEPT="ACCEPT";
	
	private ArrayList<String> filas;
	private ArrayList<String> col;
	private ArrayList<String> terminales;
	private ArrayList<String> noTerminales;
	private String[][] ll1;
	private  Gramatica g;
	ArrayList<Production> productions;
	
	private ArrayList<String> pila;
	private ArrayList<String> lexemas;
	private ArrayList<Integer> tokens;
	private ArrayList<String> accion;
	
	public LL1(String vt, String vnt,String reglas){
		g=new Gramatica(reglas,vt,vnt);
		productions=g.getProductions();
		terminales=g.getTerminales();
		terminales.remove(g.EPSILON);
		
		noTerminales=g.getNoTerminales();
		filas=new ArrayList<String>();
		col=new ArrayList<String>();
		
		for(String s:terminales){
			if(!filas.contains(s)){
				filas.add(s);	
				col.add(s);
			}
		}
		
		for(String s:noTerminales){
			if(!filas.contains(s)){
				filas.add(s);	
			}
		}
		
		filas.add(Gramatica.FIN_DE_LINEA);
		col.add(Gramatica.FIN_DE_LINEA);
		ll1=new String[filas.size()][col.size()];
		
		for(int j=0;j<filas.size();j++){
			for(int k=0;k<col.size();k++){
				ll1[j][k]=ERROR_EN_TABLA_LL1;
			}
		}
		
		crearTablaLL1();
	}
	
	public void crearTablaLL1(){
		
		for(int i=0;i<productions.size();i++){
			ArrayList<String> first=g.first(productions.get(i).getRight());
			String izquierdo=productions.get(i).getLeft().getCad();
			String derecho=productions.get(i).getRight().toString();
			int f,c;
			for(int e=0;e<first.size();e++){
				if(!first.get(e).equals(g.EPSILON)){
					f=filas.indexOf(izquierdo);
					c=col.indexOf(first.get(e));
					ll1[f][c]=derecho+","+i;
					
				}else{
					ArrayList<String> follow=g.follow(izquierdo);
					for(int k=0;k<follow.size();k++){
						f=filas.indexOf(izquierdo);
						c=col.indexOf(follow.get(k));
						ll1[f][c]=g.EPSILON+","+i;
					}
					
				}
			}
		}
		
		for(int i=0;i<terminales.size();i++){
			String terminal=terminales.get(i);
			int indice=terminales.indexOf(terminal);
			ll1[indice][indice]=POP;
		}
		ll1[filas.indexOf(g.FIN_DE_LINEA)][col.indexOf(g.FIN_DE_LINEA)]=ACCEPT;
	}
	
	public void imprimirTablaLL1(){
		System.out.print("\t");
		for(String c:col){
			System.out.print(c+"\t");
		}
			
		System.out.println("");
		
		for(int i=0;i< filas.size();i++){
			System.out.print(filas.get(i)+"\t");
			for(int e=0;e<col.size();e++){
				System.out.print(ll1[i][e]+"\t");
			}
			System.out.println("");
		}
	}
	
	public boolean validarCadena(String cadena){
		LexicoCalculadora lexic=new LexicoCalculadora(cadena);
		lexemas=lexic.getLexemas();
		tokens=lexic.getTokens();
		pila=new ArrayList<String>();
		pila.add(g.FIN_DE_LINEA);
		pila.add(productions.get(0).getLeft().getCad());
		for(int l:tokens){
			//System.out.print(l+":"+);
		}
		
		
		
		return true;
	}

	public ArrayList<String> getFilas() {
		return filas;
	}

	public void setFilas(ArrayList<String> filas) {
		this.filas = filas;
	}

	public ArrayList<String> getCol() {
		return col;
	}

	public void setCol(ArrayList<String> col) {
		this.col = col;
	}

	public String[][] getLl1() {
		return ll1;
	}

	public void setLl1(String[][] ll1) {
		this.ll1 = ll1;
	}
	
	
}
