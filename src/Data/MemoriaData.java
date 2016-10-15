/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author Todesser
 */
public class MemoriaData {
    private long direccion;
    private long valor;

    public long getDireccion() {
        return direccion;
    }

    public void setDireccion(long direccion) {
        this.direccion = direccion;
    }

    public long getValor() {
        return valor;
    }

    public void setValor(long valor) {
        this.valor = valor;
    }

    public MemoriaData(long direccion, long valor) {
        this.direccion = direccion;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "MemoriaData{" + "direccion=" + direccion + ", valor=" + valor + '}';
    }
    
}
