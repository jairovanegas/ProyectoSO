/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Excepciones.Blockeado;
import Memoria.EspacioDeMemoria;
import Memoria.Instruccion;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Todesser
 */
public class Sleep extends Instruccion{
    
    public Sleep(String identificador, long argumento, long codigo) {
        super(identificador, argumento, codigo);
    }

    @Override
    public void ejecutar(Map<String, Long> registros, Map<Long, EspacioDeMemoria> memoriaRam, List<String> traza)throws Blockeado{
        traza.add(0,"SLEEP: sleeping for " + argumento + " ticks");
        registros.put("PC", registros.get("PC")+1);
        throw new Blockeado(argumento);
    }
    
}
