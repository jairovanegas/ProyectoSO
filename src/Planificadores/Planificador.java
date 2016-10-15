/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Planificadores;

import CPU.Procesador;
import CPU.Proceso;

/**
 *
 * @author Todesser
 */
public interface Planificador {
    public Proceso seleccionar(Procesador cpu);
    public void avanzarTick(Procesador cpu);
}
