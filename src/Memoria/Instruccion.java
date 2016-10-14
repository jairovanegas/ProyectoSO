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
public class Instruccion extends EspacioDeMemoria{
    protected String identificador;
    protected int direccion;

    @Override
    public Object obtener() {
        return identificador;
    }
    
}
