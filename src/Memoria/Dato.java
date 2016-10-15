/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Memoria;

/**
 *
 * @author Todesser
 */
public class Dato extends EspacioDeMemoria{
    long dato;

    public Dato(long dato) {
        this.dato = dato;
    }
      
    @Override
    public Object obtener() {
        return dato;
    }

    public long getDato() {
        return dato;
    }    
}
