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
public class Contacto {
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private String cedula;
    private String telefono;
    private String correo;

    public Contacto(){
        nombre = "";
        primerApellido = "";
        segundoApellido = "";
        cedula = "";
        correo = "";
    }
    
    /**
     * Metodo constructor Contacto
     * @param nombre
     * @param primerApellido
     * @param segundoApellido
     * @param cedula
     * @param telefono
     * @param correo 
     */
    public Contacto(String nombre, String primerApellido, String segundoApellido, String cedula, String telefono, String correo) {
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.cedula = cedula;
        this.telefono = telefono;
        this.correo = correo;
    }

    /**
     * Metodo constructor Contacto
     * @param cedula 
     */
    
    public Contacto(String cedula) {
        this.cedula = cedula;
    }

    /**
     * Metodo que retorna el nombre del contacto
     * @return Retorna el nombre del contacto
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo que le agrega un nombre al contacto
     * @param nombre Nombre Contacto
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo que retorna el primer apellido del contacto
     * @return Retorna el primer apellido del contacto
     */
    public String getPrimerApellido() {
        return primerApellido;
    }

    /**
     * Metodo que le agrega un primer apellido al contacto
     * @param primerApellido Primer apellido Contacto
     */
    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    /**
     * Metodo que retorna el segundo apellido del contacto
     * @return Retorna el segundo apellido del contacto
     */
    public String getSegundoApellido() {
        return segundoApellido;
    }

    /**
     * Metodo que le agrega un segundo apellido al contacto
     * @param segundoApellido Segundo apellido Contacto
     */
    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    /**
     * Metodo que retorna la cedula del contacto
     * @return Retorna la cedula del contacto
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * Metodo que le agrega un cedula al contacto
     * @param cedula Cedula Contacto
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    /**
     * Metodo que retorna el telefono del contacto
     * @return Retorna el telefono del contacto
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Metodo que le agrega un telefono al contacto
     * @param telefono Telefono Contacto
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Metodo que retorna el correo del contacto
     * @return Retorna el correo del contacto
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Metodo que le agrega un correo al contacto
     * @param correo Correo Contacto
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

     /**
     * Metodo que retorna los datos del contacto en String
     * @return Retorna los datos de del contacto en String
     */
    @Override
    public String toString() {
        return "Contacto{" + "nombre=" + nombre + ", primerApellido=" + primerApellido + ", segundoApellido=" + segundoApellido + ", cedula=" + cedula + ", telefono=" + telefono + ", correo=" + correo + '}';
    }
    
    
    
}
