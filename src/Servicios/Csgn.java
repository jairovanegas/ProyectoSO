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
public class Csgn extends Instruccion{
    
    public Csgn(String identificador, long argumento, long codigo) {
        super(identificador, argumento, codigo);
    }

    @Override
    public void ejecutar(Map<String, Long> registros, Map<Long, EspacioDeMemoria> memoriaRam, List<String> traza) {
        long psw = registros.get("PSW");
        if(psw==1){
            registros.put("PSW", (long)0);
        }else{
            registros.put("PSW", (long)1);
        }
        registros.put("PC", registros.get("PC") + 1);
        traza.add(0,"CSGN: PSW inverted");
    }
    
}
