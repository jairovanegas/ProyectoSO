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
public class RegistroDato {
    //Direccion del registro de datos
    int direccion;
    //Valor del registro de datos
    int valor;

    public int getDireccion() {
        return direccion;
    }

    public void setDireccion(int direccion) {
        this.direccion = direccion;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public RegistroDato(int direccion, int valor) {
        this.direccion = direccion;
        this.valor = valor;
    }
    
    public String toString() {
        return Util.toHexa(direccion) + " " + Util.toHexa(valor);
    }
}
