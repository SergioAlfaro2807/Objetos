/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucenfotec.bl;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Clase de Objeto Actividad
 * @author Dell
 */
public class Actividad extends Base {
    private String descripcion;
       private String fechaInicio;
   private String horaInicio;
   private String fechaFin;
   private String horaFin;
   
  
    public Actividad(){
        nombre = "";
        codigo = "";
        descripcion = "";
    }
    /**
     * Metodo constructor de actividad
     * @param descripcion
     * @param nombre
     * @param codigo 
     */
    public Actividad(String descripcion, String nombre, String codigo) {
        super(nombre, codigo);
        this.descripcion = descripcion;
    }

    /**
     * Metodo constructor de actividad
     * @param descripcion
     * @param fechaInicio
     * @param horaInicio
     * @param fechaFin
     * @param horaFin
     * @param nombre
     * @param codigo 
     */
    public Actividad(String descripcion, String fechaInicio, String horaInicio, String fechaFin, String horaFin, String nombre, String codigo) {
        super(nombre, codigo);
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.horaInicio = horaInicio;
        this.fechaFin = fechaFin;
        this.horaFin = horaFin;
    }

    /**
     * Metodo construcctor de actividad
     * @param descripcion
     * @param fechaInicio
     * @param horaInicio
     * @param fechaFin
     * @param horaFin
     * @param nombre 
     */
    public Actividad(String descripcion, String fechaInicio, String horaInicio, String fechaFin, String horaFin, String nombre) {
        super(nombre);
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.horaInicio = horaInicio;
        this.fechaFin = fechaFin;
        this.horaFin = horaFin;
    }

    /**
     * Metodo constructor de actividad
     * @param descripcion
     * @param fechaInicio
     * @param horaInicio
     * @param fechaFin
     * @param horaFin 
     */
    public Actividad(String descripcion, String fechaInicio, String horaInicio, String fechaFin, String horaFin) {
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.horaInicio = horaInicio;
        this.fechaFin = fechaFin;
        this.horaFin = horaFin;
    }
    
    
    
    /**
     * Metodo constructor de actividad
     * @param nombre 
     */
    public Actividad(String nombre) {
        super(nombre);
    }
    
   
    /**
     * Metodo que retorna el nombre de la actividad
     * @return Retorna el nombre de la actividad
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo que le agrega un nombre a la actividad
     * @param nombre Nombre actividad
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

     /**
     * Metodo que retorna el codigo de la actividad
    * @return Retorna el codigo de la actividad
     */
    public String getCodigo() {
        return codigo;
    }

      /**
     * Metodo que le agrega un codigo a la actividad
     * @param codigo Codigo actividad
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

     /**
     * Metodo que retorna la descripcion de la actividad
     * @return Retorna la descripcion de la actividad
     */
    public String getDescripcion() {
        return descripcion;
    }

      /**
     * Metodo que le agrega una descripcion a la actividad
     * @param descripcion Descripcion actividad
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

     /**
     * Metodo que retorna la fecha de inicio de la actividad
     * @return Retorna la fecha de inicio de la actividad 
     */
    public String getFechaInicio() {
        return fechaInicio;
    }

      /**
     * Metodo que le agrega una fecha de inicio a la actividad
     * @param fechaInicio Fecha de inicio actividad
     */
    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

     /**
     * Metodo que retorna la hora de inicio de la actividad
     * @return Retorna la hora de inicio de la actividad
     */
    public String getHoraInicio() {
        return horaInicio;
    }

      /**
     * Metodo que le agrega una hora de inicio a la actividad
     * @param horaInicio Hora de inicio actividad
     */
    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

     /**
     * Metodo que retorna la fecha fin de la actividad
     * @return Retorna la fecha fin de la actividad 
     */
    public String getFechaFin() {
        return fechaFin;
    }

      /**
     * Metodo que le agrega una fecha fin a la actividad
     * @param fechaFin Fecha fin actividad
     */
    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

     /**
     * Metodo que retorna la hora fin de la actividad
     * @return Retorna la hora fin de la actividad 
     */
    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    /**
     * Metodo que retorna los datos de la activdad en String
     * @return Retorna los datos de la activdad en String
     */
    @Override
    public String toString() {
        return "Actividad{" + "descripcion=" + descripcion + ", fechaInicio=" + fechaInicio + ", horaInicio=" + horaInicio + ", fechaFin=" + fechaFin + ", horaFin=" + horaFin + '}';
    }


    
}
