/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucenfotec.bl;

/**
 *
 * @author Dell
 */
public class Base {
    protected String nombre;
    protected String codigo;

    /**
     * Metodo constructor Base
     * @param nombre
     * @param codigo 
     */
    public Base(String nombre, String codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
    }
    
    
    
    
    /**
     * Metodo constructor Base
     * @param nombre 
     */
    public Base(String nombre) {
        this.nombre = nombre;
    }
    
    public Base(){
        nombre = "";
        codigo = "";
    }
    
     /**
     * Metodo que retorna el nombre de la base
     * @return Retorna el nombre de la base
     */
    public String getNombre() {
        return nombre;
    }
    
     /**
     * Metodo que le agrega un nombre a la base
     * @param nombre Nombre base
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo que retorna el codigo de la base
     * @return Retorna el codigo de la base
     */
    public String getCodigo() {
        return codigo;
    }

      
     /**
     * Metodo que le agrega un codigo a la base
     * @param codigo Codigo base
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

   /**
     * Metodo que retorna los datos de la base en String
     * @return Retorna los datos de la base en String
     */
    @Override
    public String toString() {
        return "Base{" + "nombre=" + nombre + ", codigo=" + codigo + '}';
    }
    
}
