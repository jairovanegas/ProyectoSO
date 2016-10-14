/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author GamerGarage
 */
public class Instruccion {
    //direccion en memoria
    private int direccion;
    //Tipo de instruccion a ejecutar
    private int tipo;
    //Direccion sobre la que actua la instruccion
    private int adr;

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getDireccion() {
        return direccion;
    }

    public void setDireccion(int direccion) {
        this.direccion = direccion;
    }

    public Instruccion(int direccion, int tipo, int adr) {
        this.adr = adr;
        this.tipo = tipo;
        this.direccion = direccion;
    }

    public int getAdr() {
        return adr;
    }

    public void setAdr(int adr) {
        this.adr = adr;
    }
    
    

    @Override
    public String toString() {
        return Util.toHexa(tipo) + " " + Util.toHexa(direccion);
    }
    
    
}
