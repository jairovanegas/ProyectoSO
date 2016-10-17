/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Planificadores;

import CPU.Procesador;
import CPU.Proceso;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Todesser
 */
public class RoundRobin implements Planificador{

    @Override
    public Proceso seleccionar(Procesador cpu) {
        Proceso nuActivo;
        if(cpu.getActivo()==null){
             if(cpu.getListos().size()>0){
                 nuActivo = cpu.getListos().remove(0);
             }else{
                 nuActivo = null;
             }
        }else{
            if(cpu.getActivo().getQuantum()>=cpu.getQuantum()){
                if (cpu.getListos().size() > 0) {
                    cpu.getActivo().setQuantum(0);
                    cpu.getListos().add(cpu.getActivo());
                    nuActivo = cpu.getListos().remove(0);
                }else{
                    cpu.getActivo().setQuantum(0);
                    nuActivo = cpu.getActivo();
                }
            }else{
                nuActivo = cpu.getActivo();
            }
        }
        return nuActivo;
    }

    @Override
    public void avanzarTick(Procesador cpu) {
        if(cpu.getActivo()!=null){
            cpu.getActivo().aumentarRespuesta();
            cpu.getActivo().aumentarQuantum();
        }
        for(Proceso proceso: cpu.getListos()){
            proceso.aumentarEspera();
            proceso.aumentarRespuesta();
        }
        List<Proceso> revividos = new ArrayList<>();
        for (Proceso proceso: cpu.getBloqueados()) {
            proceso.aumentarEspera();
            proceso.aumentarRespuesta();
            proceso.disminuirBloqueo();
            if(proceso.getBloqueoRestante()==0){
                revividos.add(proceso);
            }
        }
        for(Proceso revivido: revividos){
            cpu.getBloqueados().remove(revivido);
            cpu.getListos().add(revivido);
        }
    }
    
}
