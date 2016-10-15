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
public class InstruccionData {
    private long direccion;
    private long codigo;
    private long adr;
    private String descripcion;

    public long getDireccion() {
        return direccion;
    }

    public void setDireccion(long direccion) {
        this.direccion = direccion;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public long getAdr() {
        return adr;
    }

    public void setAdr(long adr) {
        this.adr = adr;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public InstruccionData(long direccion, long codigo, long adr, String descripcion) {
        this.direccion = direccion;
        this.codigo = codigo;
        this.adr = adr;
        this.descripcion = descripcion;
    }
    
}
