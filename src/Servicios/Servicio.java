/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

/**
 *
 * @author Todesser
 */
public class Servicio {
    
    private String identificador;
    private int direccion;
    
    abstract void ejecutar(Map<String,Registro>, Map<int, int>);
}
