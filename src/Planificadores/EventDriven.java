/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Planificadores;

import CPU.Procesador;
import CPU.Proceso;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Todesser
 */
public class EventDriven implements Planificador{

    @Override
    public Proceso seleccionar(Procesador cpu) {
        Collections.sort(cpu.getListos(), new Comparator<Proceso>() {
            @Override
            public int compare(Proceso t, Proceso t1) {
                if(t.getPrioridad()==t1.getPrioridad()){
                    return 0;
                }else{
                    if(t.getPrioridad()<t1.getPrioridad()){
                        return 1;
                    }else{
                        return -1;
                    }
                }
            }
        });
        Proceso nuActivo;
        if(cpu.getActivo()==null){
             if(cpu.getListos().size()>0){
                 nuActivo = cpu.getListos().remove(0);
             }else{
                 nuActivo = null;
             }
        }else{
            if (cpu.getListos().size() > 0) {
                if (cpu.getActivo().getInsRestantes() > cpu.getListos().get(0).getInsRestantes()) {
                    cpu.getListos().add(cpu.getActivo());
                    nuActivo = cpu.getListos().remove(0);
                } else {
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
