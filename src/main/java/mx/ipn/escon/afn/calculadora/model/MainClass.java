/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escon.afn.calculadora.model;

/**
 *
 * @author juancarlos
 */
public class MainClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	String expr="(4+2*(4-6/5)*5/6-96*5/(4/8*8))";
    	/*System.out.println("hola");
    	
    	LexicoCalculadora lexic=new LexicoCalculadora(expr);
    	lexic.separarNoTerminales();
    	
    	for(int i=0;i<lexic.getTokens().size();i++){
    		System.out.println(lexic.getTokens().get(i)+":"+lexic.getLexemas().get(i));
    	}*/
    	
    	SintacticoCalculadora sintac=new SintacticoCalculadora(expr);
    	
    	MiFloat f=new MiFloat();
    	System.out.println(sintac.sintac(f));
    	System.out.println(f.getF());
        
    	
    	
    	
    }
}
