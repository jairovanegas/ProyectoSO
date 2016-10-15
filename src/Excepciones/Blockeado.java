/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excepciones;

/**
 *
 * @author Todesser
 */
public class Blockeado extends Exception{

    private long ticks;
    
    public Blockeado(long ticks) {
        this.ticks = ticks;
    }

    public long getTicks() {
        return ticks;
    }
    
}
