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
public class Registro {
    //Identificador del registro ej: PC    
    String identificador;
    //Valor del registro
    int valor;

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Registro(String identificador, int valor) {
        this.identificador = identificador;
        this.valor = valor;
    }
    
}
