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
        AFN f1=new AFN('a');
        AFN f2=new AFN('b');
        AFN f3=new AFN('c');
        AFN f4=new AFN('a');
        
        f1.concatenacion(f2);
        f1.concatenacion(f3);
        f1.concatenacion(f4);
        
        f1.setIdLexema(20);
 
        AFN f5=new AFN('a');
        AFN f6=new AFN('c');
        AFN f7=new AFN('c');
        AFN f8=new AFN('a');
        
        f5.concatenacion(f6);
        f5.concatenacion(f7);
        f5.concatenacion(f8);

        f5.cerraduraKleene();
        f5.setIdLexema(11);
        
        f1.unionEspecial(f5);
       
        
        System.out.println(f1.validarCadena("abcaaccaaccaabcaabcaaccaabca"));
        
        for(int k:f1.getToken()){
        	System.out.println("Token:" +k);
        }
        
    }
}