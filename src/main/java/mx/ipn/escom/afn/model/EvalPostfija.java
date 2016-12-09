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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EvalPostfija {
	private ArrayList alfabeto;
    private ArrayList pOperadores;
    private String pEntrada;
    private Map<String, Integer> prescendencia;

    public EvalPostfija(String expr) {
       
        
        pEntrada = expr;
        pOperadores = new ArrayList();
        prescendencia = new HashMap<String, Integer>();

        //agregando operadores
        prescendencia.put("(", 11);//siempre la prioridad más alta
        prescendencia.put("*", 9);
        prescendencia.put("+", 9);
        prescendencia.put("?", 9);
        prescendencia.put("&", 8);
        prescendencia.put("|", 7);
        prescendencia.put(")", 0);//simpre la prioridad más baja
        
        for(int i=0;i<expr.length();i++){
            if(!prescendencia.containsKey(""+expr.charAt(i))){
            	alfabeto.add(expr.charAt(i));
            }
        }
    }

    public ArrayList ordenarExpresion() {
        String aux = "";
        ArrayList pila = new ArrayList();
        for (int i = 0; i < pEntrada.length(); i++) {
            // si es un elemento se agrega a la pila
            if (!prescendencia.containsKey("" + pEntrada.charAt(i))) {
                pila.add(pEntrada.charAt(i));
            } else//si la pila esta vacia
            if (pOperadores.isEmpty()) {
                pOperadores.add(pEntrada.charAt(i));
            } else//si el operador de a cadena es mayor que el que esta en la pila
            if (prescendencia.get("" + pOperadores.get(pOperadores.size() - 1)) < prescendencia.get("" + pEntrada.charAt(i))) {
                pOperadores.add(pEntrada.charAt(i));
                //si el operador de a cadena es igual que el que esta en la pila, se agrega a la pila
            } else if (prescendencia.get("" + pOperadores.get(pOperadores.size() - 1)) == prescendencia.get("" + pEntrada.charAt(i))) {
                aux = "" + pOperadores.remove(pOperadores.size() - 1);
                if (!aux.equals("(") && !aux.equals(")")) {
                    pila.add(aux);
                }
                pOperadores.add(pEntrada.charAt(i));
            } else {
                //si el operador de a cadena es menor que el que esta en la pila se vacia la pila
                while (!pOperadores.isEmpty()) {
                    aux = "" + pOperadores.remove(pOperadores.size() - 1);
                    if (!aux.equals("(") && !aux.equals(")")) {
                        pila.add(aux);
                    }
                }
                pOperadores.add(pEntrada.charAt(i));
            }
        }
        while (!pOperadores.isEmpty()) {
            aux = "" + pOperadores.remove(pOperadores.size() - 1);
            if (!aux.equals("(") && !aux.equals(")")) {
                pila.add(aux);
            }
        }
        return pila;
    }

    public ArrayList getAlfabeto (String expresion) {
		
    	
    	return pOperadores;
		
	}
}
