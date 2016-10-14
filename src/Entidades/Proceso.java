/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.Queue;
import java.util.Stack;
import java.util.Vector;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author GamerGarage
 */
public class Proceso {
    //Ruta donde se encuentra el archivo que creo el proceso
    File rutaArchivo;
    //Vector de instrucciones
    Vector<Instruccion> instrucciones;
    //Pila de registros para las llamadas a funciones
    List <RegistroDato> pila;
    //Vector de registros iniciales que carga el proceso
    Map<String,Registro> registros;
    //Vector de registros de memoria del proceso
    Vector<RegistroDato> memoria;
    //Contador para las instrucciones SLEEP
    int sleeper;

    public File getRutaArchivo() {
        return rutaArchivo;
    }

    public void setRutaArchivo(File rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    public Vector<Instruccion> getInstrucciones() {
        return instrucciones;
    }

    public void setInstrucciones(Vector<Instruccion> instrucciones) {
        this.instrucciones = instrucciones;
    }

    public List<RegistroDato> getPila() {
        return pila;
    }

    public void setPila(Stack<RegistroDato> pila) {
        this.pila = pila;
    }

    public Map<String,Registro> getRegistros() {
        return registros;
    }

    public void setRegistros(Map<String,Registro> registros) {
        this.registros = registros;
    }

    public Vector<RegistroDato> getMemoria() {
        return memoria;
    }

    public void setMemoria(Vector<RegistroDato> memoria) {
        this.memoria = memoria;
    }

    public Proceso(File Instrucciones, File Entorno) {
        sleeper = 0;
        this.rutaArchivo = Instrucciones;
        instrucciones = new Vector<>();
        registros = new HashMap<>();
        registros.put("PC", new Registro("PC",0));
        registros.put("AC", new Registro("AC", 0));
        registros.put("IR", new Registro("IR", 0));
        registros.put("IB", new Registro("IB", 30));
        registros.put("DB", new Registro("DB", 200));
        registros.put("SP", new Registro("SP", 300));
        registros.put("PSW", new Registro("PSW", 0));
        memoria = new Vector<>();
        pila = new Stack<>();
        try {
            Scanner lectorIns = new Scanner(Instrucciones);
            int i=0;
            while(lectorIns.hasNext()){
                String ins = lectorIns.next();
                Instruccion nuevaIns = new Instruccion(registros.get("IB").getValor() + i, Integer.parseInt(ins.substring(0, 1), 16), Integer.parseInt(ins.substring(1), 16));
                instrucciones.add(nuevaIns);
                i++;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Proceso.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Scanner lectorEnt = new Scanner(Entorno);
            int i=0;
            while(lectorEnt.hasNext()){
                String ent = lectorEnt.next();
                RegistroDato nuevoEnt = new RegistroDato(registros.get("DB").getValor() + i, Integer.parseInt(ent,16));
                i++;
                memoria.add(nuevoEnt);
            }
                
        } catch (FileNotFoundException e) {
        }
    }    
    
    @Override
    public String toString() {
        return rutaArchivo.getName();
    }
    
    public String tick(){
        Instruccion insActiva = instrucciones.elementAt(registros.get("PC").getValor());        
        if(sleeper>0){
            sleeper--;
            return "SLEEPING";
        }
        String resumen = "";
        Registro pc = registros.get("PC");
        Registro ac = registros.get("AC");
        Registro psw = registros.get("PSW");
        Registro sp = registros.get("SP");
        RegistroDato mem;
        switch(insActiva.getTipo()){
            case 0:
                //no hace nada.
                resumen = "INACTIVITY";
                pc.setValor(pc.getValor()+1);
                break;
            case 1:
                ac = registros.get("AC");
                mem = memoria.elementAt(insActiva.getAdr());
                ac.setValor(mem.getValor());
                resumen = "LOADING " + Util.toHexa(mem.getValor()) + " to AC";
                pc.setValor(pc.getValor()+1);
                break;
            case 2:                
                ac = registros.get("AC");
                mem = memoria.elementAt(insActiva.getAdr());
                ac.setValor(mem.getValor());
                resumen = "MOVING " + ac.getValor() + " to AC";
                pc.setValor(pc.getValor()+1);
                break;
            case 3:
                psw = registros.get("PSW");
                if(psw.getValor()==0){
                    resumen = "JUMPING to " + insActiva.getAdr();
                    pc.setValor(insActiva.getAdr());                    
                }else{
                    resumen = "NOT JUMPING";
                    pc.setValor(pc.getValor()+1);
                }
                break;
            case 4:
                try {
                    ac = registros.get("AC");
                    int valAntiguo = ac.getValor();
                    mem = memoria.elementAt(insActiva.getAdr());
                    psw = registros.get("PSW");
                    if (ac.getValor() + mem.getValor() < 0) {
                        psw.setValor(1);
                        ac.setValor(ac.getValor() + mem.getValor());
                        ac.setValor(ac.getValor() * (-1));
                    } else {
                        psw.setValor(0);
                        ac.setValor(ac.getValor() + mem.getValor());
                    }
                    resumen = "ADDING " + Util.toHexa(mem.getValor()) + " to " + Util.toHexa(valAntiguo) + " in AC";
                    pc.setValor(pc.getValor() + 1);
                } catch (IndexOutOfBoundsException e) {
                    pc.setValor(pc.getValor() + 1);
                    return "MEMORY ADDRESS INACCESIBLE";                    
                }
                break;
            case 5:
                psw = registros.get("PSW");
                if(psw.getValor()==0){
                    psw.setValor(1);
                }else{
                    psw.setValor(0);
                }
                resumen = "AC changed its sign";
                pc.setValor(pc.getValor()+1);
                break;
            case 8:
                pila.add(new RegistroDato(registros.get("SP").getValor(), pc.getValor()));
                registros.get("SP").setValor(registros.get("SP").getValor()-1);
                resumen = "JUMPING to " + Util.toHexa(pila.get(0).getValor());
                pc.setValor(insActiva.getAdr());
                break;
            case 9:
                pc.setValor(pila.remove(0).getValor()+1);
                registros.get("SP").setValor(registros.get("SP").getValor()+1);
                resumen = "RETURNING to " + Util.toHexa(pc.getValor());
                break;
            case 10:
                sleeper = insActiva.getAdr();
                resumen = "SLEEPING for " + insActiva.getAdr() + " ticks";
                pc.setValor(pc.getValor()+1);
                break;
            case 11:
                pila.add(0, new RegistroDato(sp.getValor(), ac.getValor()));
                sp.setValor(sp.getValor()-1);
                pc.setValor(pc.getValor()+1);
                resumen = "PUSHING " + Util.toHexa(ac.getValor()) + " from AC to stack";
                break;
            case 12:
                ac.setValor(pila.remove(0).getValor());
                sp.setValor(sp.getValor()+1);
                pc.setValor(pc.getValor()+1);
                resumen = "POPING " + Util.toHexa(ac.getValor()) + " from stack to AC";
                break;
            case 15:
                registros.get("PSW").setValor(-1);
                resumen = "PROGRAM FINISHED";
                break;
        }
        return resumen;
    }
    
}


