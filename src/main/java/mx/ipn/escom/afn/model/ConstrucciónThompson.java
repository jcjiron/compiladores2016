/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.afn.model;

import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 *
 * @author juancarlos
 */
public class ConstrucciónThompson {
    private AFN f1;
    private AFN f2;

    private EvalPostfija evaluador;
    private ArrayList expresionOrdenada;
    
    public ConstrucciónThompson(){
        String expresion=JOptionPane.showInputDialog("Introduce la expresion Regular");
        evaluador=new EvalPostfija(expresion);
        expresionOrdenada=evaluador.ordenarExpresion();
    }

    public AFN getF1() {
        return f1;
    }

    public AFN getF2() {
        return f2;
    }


    public void setF1(AFN f1) {
        this.f1 = f1;
    }

    public void setF2(AFN f2) {
        this.f2 = f2;
    }



}