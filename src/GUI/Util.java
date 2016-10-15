/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author Jairo
 */
public class Util {
    public static int toInt(String hexa){
        return Integer.parseInt(hexa.substring(2),16);
    }
    public static String toHexa(int entero){
        String retorno = "0x";
        return retorno.concat(Integer.toHexString(entero));
    }
    public static String toHexa(String hexa){
        String retorno = "0x";
        return retorno.concat(hexa);
    }
    public static String wichCommand(int tipo){
        String retorno = "";
        switch (tipo) {
            case 0:
                retorno = "NOP";
                break;
            case 1:
                retorno = "LOAD";
                break;
            case 2:
                retorno = "MOVE";
                break;
            case 3:
                retorno = "JNN";
                break;
            case 4:
                retorno = "ADD";
                break;
            case 5:
                retorno = "CSGN";
                break;
            case 8:
                retorno = "CALL";
                break;
            case 9:
                retorno = "RET";
                break;
            case 10:
                retorno = "SLEEP";
                break;
            case 11:
                retorno = "PUSH";
                break;
            case 12:
                retorno = "POP";
                break;
            case 15:
                retorno = "END";
                break;
        }
        return retorno;
    }
}
