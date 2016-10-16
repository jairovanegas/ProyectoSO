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
public class Load extends Instruccion{
    
    public Load(String identificador, long argumento, long codigo) {
        super(identificador, argumento, codigo);
    }

    @Override
    public void ejecutar(Map<String, Long> registros, Map<Long, EspacioDeMemoria> memoriaRam, List<String> traza) {
        registros.put("AC", (long)memoriaRam.get(registros.get("DB")+argumento).obtener());
        traza.add(0,"LOAD: load "+(long)memoriaRam.get(registros.get("DB")+argumento).obtener());
        registros.put("PC", registros.get("PC")+1);
    }
    
}
