/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Memoria;

import Excepciones.Blockeado;
import Excepciones.FinDeProceso;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Todesser
 */
public class Instruccion extends EspacioDeMemoria{
    protected String identificador;
    protected long argumento;
    protected long codigo;

    public String getIdentificador() {
        return identificador;
    }

    public long getArgumento() {
        return argumento;
    }

    public long getCodigo() {
        return codigo;
    }

    public Instruccion(String identificador, long argumento, long codigo) {
        this.identificador = identificador;
        this.argumento = argumento;
    }    
    
    @Override
    public Object obtener() {
        return this;
    }
    
    /**
     *
     * @param registros
     * @param memoriaRam, List<String> traza
     * @param traza
     */
    public void ejecutar(Map<String, Long> registros, Map<Long, EspacioDeMemoria> memoriaRam, List<String> traza) throws FinDeProceso, Blockeado{
        
    }

    @Override
    public String toString() {
        return "Instruccion{" + "identificador=" + identificador + ", argumento=" + argumento + ", codigo=" + codigo + '}';
    }
    
}
