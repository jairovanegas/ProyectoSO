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
            registros.put("PC", registros.get("DB")+argumento);
            traza.add("JUMPING to "+registros.get("PC"));
        }else{
            traza.add("not JUMPING to "+registros.get("PC")); 
        }
    }
    
}
