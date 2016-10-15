/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Memoria.Dato;
import Memoria.EspacioDeMemoria;
import Memoria.Instruccion;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Todesser
 */
public class Call extends Instruccion{
    
    public Call(String identificador, long argumento, long codigo) {
        super(identificador, argumento, codigo);
    }

    @Override
    public void ejecutar(Map<String, Long> registros, Map<Long, EspacioDeMemoria> memoriaRam, List<String> traza) {
        long pc = registros.get("PC");
        long pcNuevo = argumento;
        memoriaRam.put(registros.get("SP"), new Dato(pc));
        registros.put("PC", pcNuevo);
        registros.put("SP", registros.get("SP")-1);
        traza.add("CALL: JUMPING from " + pc + " to " +pcNuevo);
    }    
}
