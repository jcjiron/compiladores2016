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
     System.out.println(sintactico.cargarArchivo(archivo));
     
     AFN f=sintactico.unionEspecial();
     String cadena="ababcdefcdghijij";
     f.validarCadena(cadena);
     
        for(int t:f.getToken()){
        	System.out.println(t);
        }
    }
}