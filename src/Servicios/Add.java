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
public class Add extends Instruccion{
    
    public Add(String identificador, long argumento, long codigo) {
        super(identificador, argumento, codigo);
    }

    @Override
    public void ejecutar(Map<String, Long> registros, Map<Long, EspacioDeMemoria> memoriaRam, List<String> traza) {
        long adr = (long)memoriaRam.get(registros.get("DB") + argumento).obtener();
        long ac = registros.get("AC");
        if(ac+adr<0){
            registros.put("PSW", (long)1);
        }
        registros.put("AC", ac+adr);
        traza.add(0,"ADD: "+ adr + " to " + ac);
        registros.put("PC", registros.get("PC")+1);
    }
    
}
