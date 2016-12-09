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
public class Estado {

    private String id;
    private ArrayList<Transicion> trans;
    private boolean visitado=false;

    public boolean isVisitado() {
		return visitado;
	}

	public void setVisitado(boolean visitado) {
		this.visitado = visitado;
	}

	public void setTrans(ArrayList<Transicion> trans) {
        this.trans = trans;
    }

    public ArrayList<Transicion> getTrans() {
        return trans;
    }

    public Estado(String id) {
        this.id = id;
        trans = new ArrayList<>();
    }
    
    public Estado(String id,ArrayList<Transicion> t ){
        this.id=id;
        this.trans=t;
    }

    public void addTransicion(char simbolo,Estado e) {
        trans.add(new Transicion(simbolo,e));
    }
    
    public String getId(){
        return id;
    }
    

    
    public Estado getEstado(){
        return new Estado(getId(),getTrans());
    }
}
