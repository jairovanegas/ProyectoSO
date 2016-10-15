/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CPU;

import Data.InstruccionData;
import Data.MemoriaData;
import Data.PilaData;
import Excepciones.Blockeado;
import Excepciones.FinDeProceso;
import Memoria.Dato;
import Memoria.EspacioDeMemoria;
import Memoria.Instruccion;
import Planificadores.FiFo;
import Planificadores.Planificador;
import Servicios.Nop;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Todesser
 */
public class Procesador {
    private Proceso activo;
    private Planificador planificador;
    private List<Proceso> listos;
    private List<Proceso> bloqueados;
    private List<Proceso> terminados;
    private List<String> traza;
    private Map<Long, EspacioDeMemoria> memoriaRam;
    private long ib;
    private long db;

    public Procesador() {
        activo = null;
        planificador = new FiFo();
        listos = new ArrayList<>();
        bloqueados = new ArrayList<>();
        terminados = new ArrayList<>();
        traza = new ArrayList<>();
        memoriaRam = new HashMap<>();
        ib = 0;
        db = 4000;
    }
       
    public void nuevoProceso(File instrucciones, File datos) throws FileNotFoundException{
        Proceso nuevo = new Proceso(instrucciones, datos, memoriaRam, ib, db);
        ib += nuevo.getiLong();
        db += nuevo.getdLong();
        listos.add(nuevo);
    }
    
    public void tick(){
        activo = planificador.seleccionar(this);
        try {
            if(activo!=null){
                ((Instruccion)memoriaRam.get(activo.getContexto().get("PC")+activo.getContexto().get("IB"))).ejecutar(activo.getContexto(), memoriaRam, traza);
            }else{
                new Nop(null, 0, 0).ejecutar(null, null, traza);
            }
        } catch (FinDeProceso ex) {
            terminados.add(activo);
            activo = null;
        } catch (Blockeado ex) {
            activo.setBloqueoRestante(ex.getTicks());
            bloqueados.add(activo);
            activo = null;
        }
    }

    public Proceso getActivo() {
        return activo;
    }

    public void setActivo(Proceso activo) {
        this.activo = activo;
    }

    public List<Proceso> getListos() {
        return listos;
    }

    public void setListos(List<Proceso> listos) {
        this.listos = listos;
    }

    public List<Proceso> getBloqueados() {
        return bloqueados;
    }

    public void setBloqueados(List<Proceso> bloqueados) {
        this.bloqueados = bloqueados;
    }

    public List<Proceso> getTerminados() {
        return terminados;
    }

    public void setTerminados(List<Proceso> terminados) {
        this.terminados = terminados;
    }

    public List<String> getTraza() {
        return traza;
    }

    public void setTraza(List<String> traza) {
        this.traza = traza;
    }

    public Map<Long, EspacioDeMemoria> getMemoriaRam() {
        return memoriaRam;
    }

    public void setMemoriaRam(Map<Long, EspacioDeMemoria> memoriaRam) {
        this.memoriaRam = memoriaRam;
    }

    public long getIb() {
        return ib;
    }

    public void setIb(long ib) {
        this.ib = ib;
    }

    public long getDb() {
        return db;
    }

    public void setDb(long db) {
        this.db = db;
    }

    public Planificador getPlanificador() {
        return planificador;
    }

    public void setPlanificador(Planificador planificador) {
        this.planificador = planificador;
    }
    
    public List<String> getNombresProcesos(){
        List<String> nombres = new ArrayList<>();
        for(Proceso proceso: listos){
            nombres.add(proceso.getNombre());
        }
        for (Proceso proceso: bloqueados) {
            nombres.add(proceso.getNombre());
        }
        for (Proceso proceso: terminados) {
            nombres.add(proceso.getNombre());
        }
        Collections.sort(nombres);
        return nombres;
    }
    
    public List<InstruccionData> getInsData(Proceso proceso){
        long insInicio = proceso.getContexto().get("IB");
        long insFinal = proceso.getiLong()-1;
        List<InstruccionData> retorno = new ArrayList<>();
        while(insInicio<=insFinal){
            long direccion = insInicio;
            Instruccion ins = (Instruccion)memoriaRam.get(insInicio);
            if(ins!=null){
                retorno.add(new InstruccionData(direccion, ins.getCodigo(), ins.getArgumento(), ins.getIdentificador()));
            }
        }
        return retorno;
    }
    
    public List<MemoriaData> getMemData(Proceso proceso){
        long memInicio = proceso.getContexto().get("DB");
        long memFinal = proceso.getdLong()-1;
        List<MemoriaData> retorno = new ArrayList<>();
        while(memInicio<=memFinal){
            long direccion = memInicio;
            Dato mem = (Dato)memoriaRam.get(memInicio);
            if(mem!=null){
                retorno.add(new MemoriaData(direccion, mem.getDato()));
            }
        }
        return retorno;
    }
    
    public List<MemoriaData> getPilData(Proceso proceso){
        long memInicio = proceso.getContexto().get("SP");
        long memFinal = proceso.getdLong()-1;
        List<MemoriaData> retorno = new ArrayList<>();
        while(memInicio<=memFinal){
            long direccion = memInicio;
            Dato mem = (Dato)memoriaRam.get(memInicio);
            if(mem!=null){
                retorno.add(new MemoriaData(direccion, mem.getDato()));
            }
        }
        return retorno;
    }
    
}
