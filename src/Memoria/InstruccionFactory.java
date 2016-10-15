/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Memoria;

import Servicios.*;

/**
 *
 * @author Todesser
 */
public class InstruccionFactory {
    public static Instruccion crear(long id, long argumento){
        switch((int)id){
            case 0:
                return new Nop("NOP", argumento, 0);
            case 1:
                return new Load("LOAD", argumento, 1);
            case 2:                
                return new Move("MOVE", argumento, 2);
            case 3:
                return new Jnn("JNN", argumento, 3);
            case 4:
                return new Add("ADD", argumento, 4);
            case 5:
                return new Csgn("CSGN", argumento, 5);
            case 8:
                return new Call("CALL", argumento, 8);
            case 9:
                return new Ret("RET", argumento, 9);
            case 10:
                return new Sleep("SLEEP", argumento, 10);
            case 11:
                return new Push("PUSH", argumento, 11);
            case 12:
                return new Pop("POP", argumento, 12);
            case 15:
                return new End("END", argumento, 15);
        }
        return new Nop("NOP", argumento, 0);
    }
}
