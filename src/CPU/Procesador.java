/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CPU;

import Data.InstruccionData;
import Data.MemoriaData;
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
import java.io.PrintWriter;
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
    private long quantum;

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
        if(activo==null){
            activo=nuevo;
        }else{
            listos.add(nuevo);
        }
        
    }
    
    public void tick(){
        activo = planificador.seleccionar(this);
        try {
            if(activo!=null){
                ((Instruccion)memoriaRam.get(activo.getContexto().get("PC")+activo.getContexto().get("IB"))).ejecutar(activo.getContexto(), memoriaRam, traza);
                activo.disminuirInsRestantes();
            }else{
                new Nop(null, 0, 0).ejecutar(null, null, traza);
            }
        } catch (FinDeProceso ex) {
            activo.setEstado("Finalizado");
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
    
    public List<InstruccionData> getInsData(Proceso proceso) {
        List<InstruccionData> retorno = new ArrayList<>();
        if (proceso != null) {
            long insInicio = proceso.getContexto().get("IB");
            long insFinal = insInicio + proceso.getiLong() - 1;
            while (insInicio <= insFinal) {
                long direccion = insInicio;
                Instruccion ins = (Instruccion) memoriaRam.get(insInicio);
                if (ins != null) {
                    retorno.add(new InstruccionData(direccion, ins.getCodigo(), ins.getArgumento(), ins.getIdentificador()));
                }
                insInicio++;
            }
        }
        return retorno;
    }
    
    public List<MemoriaData> getMemData(Proceso proceso){
        List<MemoriaData> retorno = new ArrayList<>();
        if(proceso==null){
            return retorno;
        }
        long memInicio = proceso.getContexto().get("DB");
        long memFinal = proceso.getContexto().get("SP");        
        while(memInicio<=memFinal){
            long direccion = memInicio;
            Dato mem = (Dato)memoriaRam.get(memInicio);
            if(mem!=null){
                retorno.add(new MemoriaData(direccion, mem.getDato()));
            }
            memInicio++;
        }
        return retorno;
    }
    
    public List<MemoriaData> getPilData(Proceso proceso){
        List<MemoriaData> retorno = new ArrayList<>();
        if(proceso==null){
            return retorno;
        }
        long memInicio = proceso.getContexto().get("SP");
        long memFinal = memInicio + proceso.getdLong()-1;
        while(memInicio<=memFinal){
            long direccion = memInicio;
            Dato mem = (Dato)memoriaRam.get(memInicio);            
            if(mem!=null){
                retorno.add(new MemoriaData(direccion, mem.getDato()));
            }
            memInicio++;
        }
        return retorno;
    }
    
    public void seleccionarPlan(int x){
        switch(x){
            case 1:
                planificador = new FiFo();
                break;
            case 2:
                //Aqui tienes que poner la instancia de cada tipo de planificador.
                //Aqui tambien tienes que pedir la informacion faltante para cada cosa.
                //como por ejemplo si se necesita un quantum, o que ingrese las prioridades de los procesos y todo eso.
                break;
            case 3:
                //Aqui tienes que poner la instancia de cada tipo de planificador.
                break;
            case 4:
                //Aqui tienes que poner la instancia de cada tipo de planificador.
                break;
            case 5:
                //Aqui tienes que poner la instancia de cada tipo de planificador.
                break;
            case 6:
                //Aqui tienes que poner la instancia de cada tipo de planificador.
                break;
        }
    }
    
    public void imprimirResumen(File salida) throws FileNotFoundException{
        PrintWriter escritor = new PrintWriter(salida);
        escritor.println("Estadisticas de ejecucion:");
        escritor.println();
        for(Proceso proc: terminados){
            escritor.println("Proceso: " + proc.getNombre());
            escritor.println("Estado: " + proc.getEstado());
            escritor.println("Tiempo en espera: " + proc.getTiempoEspera());
            escritor.println("Tiempo de respuesta: " + proc.getTiempoRespuesta());
            escritor.println();
        }
        escritor.close();
    }

    public long getQuantum() {
        return quantum;
    }

    public void setQuantum(long quantum) {
        this.quantum = quantum;
    }
}
