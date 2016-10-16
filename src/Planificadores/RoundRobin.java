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
public class RoundRobin implements Planificador{

    boolean procesoMasCorto(Proceso a, Proceso b){
        if(a.getInsRestantes()>b.getInsRestantes()){
            return false;
        }else{
            return true;
        }
    }
    
    @Override
    public Proceso seleccionar(Procesador cpu) {
        Collections.shuffle(cpu.getListos());
        Proceso nuActivo;
        if(cpu.getActivo()==null){
             nuActivo = cpu.getListos().remove(0);
        }else{
            if(cpu.getActivo().getQuantum()>=cpu.getQuantum()){
                cpu.getActivo().setQuantum(0);
                cpu.getListos().add(cpu.getActivo());
                nuActivo = cpu.getListos().remove(0);
            }else{
                nuActivo = cpu.getActivo();
            }
        }
        avanzarTick(cpu);
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
