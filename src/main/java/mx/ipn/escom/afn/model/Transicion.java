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
//Clase transicion
    public class Transicion {

        private char simbolo;
        private Estado EdoDestino=null;

        public Transicion(char simbolo,Estado EdoDestino) {
            this.simbolo = simbolo;
            this.EdoDestino=EdoDestino;
        }
        
        
        public char getSimbolo() {
            return simbolo;
        }

        public Estado getDestino() {
            return EdoDestino;
        }

        public void setSimbolo(char simbolo) {
            this.simbolo = simbolo;
        }

        public void setDestino(Estado EdoDestino) {
            this.EdoDestino = EdoDestino;
        }
        
        
    }
