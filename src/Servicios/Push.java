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
public class Push extends Instruccion{
    
    public Push(String identificador, long argumento, long codigo) {
        super(identificador, argumento, codigo);
    }

    @Override
    public void ejecutar(Map<String, Long> registros, Map<Long, EspacioDeMemoria> memoriaRam, List<String> traza) {
        memoriaRam.put(registros.get("SP")+registros.get("DB"), new Dato(registros.get("AC")));
        registros.put("SP", registros.get("SP")-1);
        registros.put("PC", registros.get("PC")+1);
    }
    
}
