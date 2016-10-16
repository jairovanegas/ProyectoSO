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
public class Jnn extends Instruccion{
    
    public Jnn(String identificador, long argumento, long codigo) {
        super(identificador, argumento, codigo);
    }

    @Override
    public void ejecutar(Map<String, Long> registros, Map<Long, EspacioDeMemoria> memoriaRam, List<String> traza) {
        long psw = registros.get("PSW");
        if(psw==0){
            registros.put("PC", argumento);
            traza.add(0,"JNN: jumping to "+registros.get("PC"));
        }else{
            traza.add(0,"JNN: not jumping to "+registros.get("PC")); 
        }
    }
    
}
