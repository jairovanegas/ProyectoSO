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
public class Move extends Instruccion{
    
    public Move(String identificador, long argumento, long codigo) {
        super(identificador, argumento, codigo);
    }

    @Override
    public void ejecutar(Map<String, Long> registros, Map<Long, EspacioDeMemoria> memoriaRam, List<String> traza) {
        memoriaRam.put(registros.get("DB") + argumento, new Dato(registros.get("AC")));
        traza.add(0,"MOVE: AC moved to " + registros.get("DB") + argumento);
        registros.put("PC", registros.get("PC")+1);
    }
    
}
