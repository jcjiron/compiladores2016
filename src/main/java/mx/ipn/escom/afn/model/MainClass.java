/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.afn.model;

/**
 *
 * @author juancarlos
 */
public class MainClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     SintacticoAFN sintactico=new SintacticoAFN();
     String archivo="reglas.txt";

     
     if(sintactico.cargarArchivo(archivo)){
    	 AFN f=sintactico.unionEspecial();
         String cadena="ababcdefcdghijij";
         f.validarCadenaAux(cadena);
         System.out.println("=======================");
            for(int i=0;i<f.getToken().size();i++){
            	String expresionRgular=f.getExpresionReg().get(i);
            	int token=f.getToken().get(i);
            	String simboloReconocido=f.getSimboloGramatica().get(i);
            	System.out.println(token+":"+expresionRgular+":"+simboloReconocido);
            }
     }else{
    	 System.out.println("Hubo un error en las expresiones del archivo");
     }
     
    }
}