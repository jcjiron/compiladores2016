/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.afn.model;

import java.util.ArrayList;

/**
 *
 * @author juancarlos
 */
public class ColeccionEstados {
    private ArrayList<Estado> I;
    private boolean aceptacion;
    private Integer id;
    private char alpha;

    public void setAlpha(char alpha) {
        this.alpha = alpha;
    }

    public char getAlpha() {
        return alpha;
    }

  
    
    
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ArrayList<Estado> getI() {
        return I;
    }

    public boolean isAceptacion() {
        return aceptacion;
    }

    public void setI(ArrayList<Estado> I) {
        this.I = I;
    }

    public void setAceptacion() {
        this.aceptacion = true;
    }
    
    public ColeccionEstados(){
        I=new ArrayList<Estado>();
        aceptacion=false;
    }
    
    
}
