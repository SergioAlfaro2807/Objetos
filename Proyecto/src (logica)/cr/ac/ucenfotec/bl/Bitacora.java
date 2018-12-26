/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucenfotec.bl;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Dell
 */
public class Bitacora {
    private String nombre;
    private String codigo;
  private Actividad actividad;



  
  /**
   * Metodo constructor Bitacora
   * @param nombre 
   */
    public Bitacora(String nombre) {
        this.nombre = nombre;
    }

    
    /**
     * Metodo constructor Bitacora
     * @param nombre
     * @param codigo 
     */
    public Bitacora(String nombre, String codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
    }

     /**
     * Metodo que retorna el codigo de la base
     * @return Retorna el codigo de la base
     */
    public String getNombre() {
        return nombre;
    }
    
     /**
     * Metodo que le agrega un nombre a la Bitacora
     * @param nombre Nodigo Bitacora
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
     * Metodo que le agrega un codigo a la Bitacora
     * @param codigo Codigo Bitacora
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    
    
    
 /**
     * Metodo que retorna el codigo de la base
     * @return Retorna el codigo de la base
     */
    public Actividad getActividad() {
        return actividad;
    }

       
     /**
     * Metodo que le agrega una acitividad a la Bitacora
     * @param actividad Actividad Bitacora
     */
    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

      /**
     * Metodo que retorna los datos de la Bitacora en String
     * @return Retorna los datos de la Bitacora en String
     */
    @Override
    public String toString() {
        return "Bitacora{" + "nombre=" + nombre + ", codigo=" + codigo + ", actividad=" + actividad + '}';
    }


 
   
}
