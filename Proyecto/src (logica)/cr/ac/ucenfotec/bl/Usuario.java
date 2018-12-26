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
public class Usuario {
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private String correo;
    private String cedula;
    private String genero;
    private String avatar;
    private String contrasenna;

    public Usuario(){
        nombre = "";
        primerApellido = "";
        segundoApellido = "";
        correo = "";
        cedula = "";
      
        
    }


    /**
     * Metodo constructor usuario
     * @param cedula 
     */
    public Usuario(String cedula) {
        this.cedula = cedula;
    }

    /**
     * Metodo constructor usuario
     * @param avatar
     * @param contrasenna 
     */
    public Usuario(String avatar, String contrasenna) {
        this.avatar = avatar;
        this.contrasenna = contrasenna;
    }
    
    
    /**
     * Metodo constructor usuario
     * @param nombre
     * @param primerApellido
     * @param segundoApellido
     * @param correo
     * @param cedula
     * @param genero
     * @param avatar
     * @param contrasenna 
     */
    public Usuario(String nombre, String primerApellido, String segundoApellido, String correo, String cedula, String genero, String avatar, String contrasenna) {
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.correo = correo;
        this.cedula = cedula;
        this.genero = genero;
        this.avatar = avatar;
        this.contrasenna = contrasenna;
    }

    /**
     * Metodo constructor usuario
     * @param nombre
     * @param correo
     * @param cedula
     * @param avatar 
     */
    public Usuario(String nombre, String correo, String cedula, String avatar) {
        this.nombre = nombre;
        this.correo = correo;
        this.cedula = cedula;
        this.avatar = avatar;
    }
    
    
    
     /**
     * Metodo que retorna el nombre del usuario
     * @return Retorna el nombre del usuario
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo que le agrega un nombre exacta al usuario
     * @param nombre Nombre Usuario
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

     /**
     * Metodo que retorna el primer apellido del usuario
     * @return Retorna el primer apellido del usuario
     */
    public String getPrimerApellido() {
        return primerApellido;
    }

    /**
     * Metodo que le agrega un primer apellido al usuario
     * @param primerApellido Primer Apellido Usuario
     */
    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    /**
     * Metodo que retorna el segundo apellido del usuario
     * @return Retorna el segundo apellido del usuario
     */
    public String getSegundoApellido() {
        return segundoApellido;
    }

    /**
     * Metodo que le agrega un Segundo apellido al usuario
     * @param segundoApellido Segundo apellido Usuario
     */
    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    /**
     * Metodo que retorna el correo del usuario
     * @return Retorna el correo del usuario
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Metodo que le agrega un correo al usuario
     * @param correo Correo Usuario
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Metodo que retorna la cedula del usuario
     * @return Retorna la cedula del usuario
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * Metodo que le agrega una cedula al usuario
     * @param cedula Cedula Usuario
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    /**
     * Metodo que retorna el genero del usuario
     * @return Retorna el genero del usuario
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Metodo que le agrega un genero al usuario
     * @param genero Genero Usuario
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

     /**
     * Metodo que retorna el avatar del usuario
     * @return Retorna el avatar del usuario
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * Metodo que le agrega un avatar al usuario
     * @param avatar Avatar Usuario
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

     /**
     * Metodo que retorna la contrasenna del usuario
     * @return Retorna la contrasenna del usuario
     */
    public String getContrasenna() {
        return contrasenna;
    }

    /**
     * Metodo que le agrega una contrasenna al usuario
     * @param contrasenna Contrasenna Usuario
     */
    public void setContrasenna(String contrasenna) {
        this.contrasenna = contrasenna;
    }

     /**
     * Metodo que retorna los datos del usuario en String
     * @return Retorna los datos de del usuario en String
     */
    @Override
    public String toString() {
        return "Usuario{" + "nombre=" + nombre + ", primerApellido=" + primerApellido + ", segundoApellido=" + segundoApellido + ", correo=" + correo + ", cedula=" + cedula + ", genero=" + genero + ", avatar=" + avatar + '}';
    }
    
    
    
}
