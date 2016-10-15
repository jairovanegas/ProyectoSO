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
public class FiFo implements Planificador{

    @Override
    public Proceso seleccionar(Procesador cpu) {
        if(cpu.getActivo()==null){
            if(cpu.getListos().size()>0){
                Proceso elegido = cpu.getListos().remove(0);
                elegido.setEstado("Activo");
                avanzarTick(cpu);
                return elegido;
            }else{
                avanzarTick(cpu);
                return null;
            }
        }else{
            avanzarTick(cpu);
            return cpu.getActivo();
        }
    }

    @Override
    public void avanzarTick(Procesador cpu) {
        for(Proceso proceso: cpu.getListos()){
            proceso.aumentarEspera();
            proceso.aumentarRespuesta();
        }
        for (Proceso proceso: cpu.getBloqueados()) {
            proceso.aumentarEspera();
            proceso.aumentarRespuesta();
            proceso.disminuirBloqueo();
            if(proceso.getBloqueoRestante()==0){
                cpu.getBloqueados().remove(proceso);
                cpu.getListos().add(proceso);
            }
        }
    }
    
}
