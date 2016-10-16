/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CPU;

import Memoria.Dato;
import Memoria.EspacioDeMemoria;
import Memoria.Instruccion;
import Memoria.InstruccionFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Todesser
 */
public class Proceso {
    private String nombre;
    private Map<String, Long> contexto;
    private long quantum;
    private long bloqueoRestante;
    private long prioridad;
    private long iLong;
    private long dLong;
    private long tiempoEspera;
    private long tiempoRespuesta;
    private String estado;
    private long insRestantes;

    public Proceso(File instrucciones, File datos, Map<Long, EspacioDeMemoria> memoriaRam, long ib, long db) throws FileNotFoundException {
        nombre = instrucciones.getName();
        quantum = 0;
        bloqueoRestante = 0;
        prioridad = 0;
        tiempoEspera = 0;
        tiempoRespuesta = 0;
        contexto = new HashMap<>();
        contexto.put("PC", (long)0);
        contexto.put("AC", (long)0);
        contexto.put("IR", (long)0);
        contexto.put("IB", ib);
        contexto.put("DB", db);
        contexto.put("PSW", (long)0);
        try {
            Scanner lectorIns = new Scanner(instrucciones);
            int i=0;
            while(lectorIns.hasNext()){
                String ins = lectorIns.next();
                Instruccion nuevaIns = InstruccionFactory.crear(Long.parseLong(ins.substring(0, 1), 16), Long.parseLong(ins.substring(1), 16));
                memoriaRam.put(ib + i, nuevaIns);
                i++;
            }
            iLong = i;
            insRestantes = iLong;
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException();
        }
        try {
            Scanner lectorEnt = new Scanner(datos);
            int i=0;
            while(lectorEnt.hasNext()){
                String ent = lectorEnt.next();
                memoriaRam.put(db + i, new Dato(Long.parseLong(ent,16)));
                i++;
            }
            dLong = i+100;
            contexto.put("SP", (long)db+i+100);
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException();
        }
    }

    public Map<String, Long> getContexto() {
        return contexto;
    }

    public void setContexto(Map<String, Long> contexto) {
        this.contexto = contexto;
    }

    public long getQuantum() {
        return quantum;
    }

    public void setQuantum(long quantum) {
        this.quantum = quantum;
    }

    public long getBloqueoRestante() {
        return bloqueoRestante;
    }

    public void setBloqueoRestante(long bloqueoRestante) {
        this.bloqueoRestante = bloqueoRestante;
    }

    public long getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(long prioridad) {
        this.prioridad = prioridad;
    }

    public long getiLong() {
        return iLong;
    }

    public void setiLong(long iLong) {
        this.iLong = iLong;
    }

    public long getdLong() {
        return dLong;
    }

    public void setdLong(long dLong) {
        this.dLong = dLong;
    }   

    public long getTiempoEspera() {
        return tiempoEspera;
    }

    public void setTiempoEspera(long tiempoEspera) {
        this.tiempoEspera = tiempoEspera;
    }

    public long getTiempoRespuesta() {
        return tiempoRespuesta;
    }

    public void setTiempoRespuesta(long tiempoRespuesta) {
        this.tiempoRespuesta = tiempoRespuesta;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public void aumentarEspera(){
        tiempoEspera+=1;
    }
    
    public void aumentarRespuesta(){
        tiempoRespuesta+=1;
    }
    
    public void disminuirBloqueo(){
        bloqueoRestante -= 1;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void disminuirInsRestantes(){
        insRestantes -= 1;
    }
    
    public long getInsRestantes(){
        return insRestantes;
    }
    
    public void aumentarQuantum(){
        quantum+=1;
    }
}
