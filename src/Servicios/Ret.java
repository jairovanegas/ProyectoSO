/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Memoria.EspacioDeMemoria;
import Memoria.Instruccion;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Todesser
 */
public class Ret extends Instruccion{
    
    public Ret(String identificador, long argumento, long codigo) {
        super(identificador, argumento, codigo);
    }

    @Override
    public void ejecutar(Map<String, Long> registros, Map<Long, EspacioDeMemoria> memoriaRam, List<String> traza) {
        registros.put("PC", (long)memoriaRam.get(registros.get("SP")+1).obtener());
        memoriaRam.remove(registros.get("SP")+1);
        registros.put("SP", registros.get("SP")+1);
        registros.put("PC", registros.get("PC")+1);
        traza.add("RET:");
    }
    
}
