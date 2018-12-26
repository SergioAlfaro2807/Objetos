/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucenfotec.bl;

import java.util.Objects;

/**
 *
 * @author Dell
 */
public class ClienteFisico extends Cliente {
    private String primerApellido;
    private String segundoApellido;
    private String correo;
    private String telefono;

    
    public ClienteFisico(){
        primerNombre = "";
        primerApellido = "";
        segundoApellido = "";
        provincia = "";
        canton = "";
        distrito = "";
        direccionExacta = "";
        correo = "";
        
    }

    /**
     * Metodo constructor Cliente Fisico
     * @param primerApellido
     * @param segundoApellido
     * @param correo
     * @param telefono
     * @param provincia
     * @param canton
     * @param distrito
     * @param direccionExacta
     * @param primerNombre 
     */
    public ClienteFisico(String primerApellido, String segundoApellido, String correo, String telefono, String provincia, String canton, String distrito, String direccionExacta, String primerNombre) {
        super(primerNombre, provincia, canton, distrito, direccionExacta);
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.correo = correo;
        this.telefono = telefono;
    }

    /**
     * Metodo constructor Cliente fisico
     * @param correo 
     */
    public ClienteFisico(String correo) {
        this.correo = correo;
    }

    /**
     * Metodo constructor Cliente fisico
     * @param correo
     * @param telefono 
     */
    public ClienteFisico(String correo, String telefono) {
        this.correo = correo;
        this.telefono = telefono;
    }
    
    
    /**
     * Metodo que retorna el primer nombre del cliente fisico
     * @return Retorna el primer nombre del cliente fisico
     */
    public String getNombre() {
        return primerNombre;
    }
    
    /**
     * Metodo que le agrega un nombre al cliente fisico
     * @param nombre nombre Cliente fisico
     */
    public void setNombre(String nombre) {
        this.primerNombre = nombre;
    }

    /**
     * Metodo que retorna el primer apellido del cliente fisico
     * @return Retorna el primer apellido del cliente fisico
     */
    public String getPrimerApellido() {
        return primerApellido;
    }
    
    /**
     * Metodo que le agrega el primer apellido al cliente fisico
     * @param primerApellido Primer apellido Cliente fisico
     */
    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    /**
     * Metodo que retorna el segundo apellido del cliente fisico
     * @return Retorna el segundo apellido del cliente fisico
     */
    public String getSegundoApellido() {
        return segundoApellido;
    }

    /**
     * Metodo que le agrega el segundo apellido al cliente fisico
     * @param segundoApellido Segundo apellido Cliente fisico
     */
    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    /**
     * Metodo que retorna la provincia del cliente fisico
     * @return Retorna la provincia del cliente fisico
     */
    public String getProvincia() {
        return provincia;
    }

    /**
     * Metodo que retorna el primer nombre del cliente fisico
     * @return Retorna el primer nombre del cliente fisico
     */
    public String getPrimerNombre() {
        return primerNombre;
    }

    /**
     * Metodo que le agrega un primer nombre al cliente fisico
     * @param primerNombre Primer Nombre Cliente fisico
     */
    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    /**
     * Metodo que retorna la direccion exacta del cliente fisico
     * @return Retorna la direccion exacta del cliente fisico
     */
    public String getDireccionExacta() {
        return direccionExacta;
    }

    /**
     * Metodo que le agrega una direccion exacta al cliente fisico
     * @param direccionExacta DIreccion exacta Cliente fisico
     */
    public void setDireccionExacta(String direccionExacta) {
        this.direccionExacta = direccionExacta;
    }

    /**
     * Metodo que le agrega una provincia al cliente fisico
     * @param provincia Provincia Cliente fisico
     */
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    /**
     * Metodo que retorna el canton del cliente fisico
     * @return Retorna el canton del cliente fisico
     */
    public String getCanton() {
        return canton;
    }

    /**
     * Metodo que le agrega un canton al cliente fisico
     * @param canton Canton Cliente fisico
     */
    public void setCanton(String canton) {
        this.canton = canton;
    }

    /**
     * Metodo que retorna el distrito del cliente fisico
     * @return Retorna el distrito del cliente fisico
     */
    public String getDistrito() {
        return distrito;
    }

    /**
     * Metodo que le agrega un distrito al cliente fisico
     * @param distrito Distrito Cliente fisico
     */
    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    /**
     * Metodo que retorna la direccion exacta del cliente fisico
     * @return Retorna la direccion exacta del cliente fisico
     */
    public String getDireccion() {
        return direccionExacta;
    }

    /**
     * Metodo que le agrega una direccion al cliente fisico
     * @param direccion Direccion Cliente fisico
     */
    public void setDireccion(String direccion) {
        this.direccionExacta = direccion;
    }

     /**
     * Metodo que retorna el correo del cliente fisico
     * @return Retorna el correo del cliente fisico
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Metodo que le agrega un correo al cliente fisico
     * @param correo Correo Cliente fisico
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Metodo que retorna el telefono del cliente fisico
     * @return Retorna el telefono del cliente fisico
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Metodo que le agrega un telefono al cliente fisico
     * @param telefono Telefono Cliente fisico
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ClienteFisico other = (ClienteFisico) obj;
        if (!Objects.equals(this.correo, other.correo)) {
            return false;
        }
        if (!Objects.equals(this.telefono, other.telefono)) {
            return false;
        }
        return true;
    }

   
    
     /**
     * Metodo que retorna los datos del cliente fisico en String
     * @return Retorna los datos de del cliente fisico en String
     */
    public String toString() {
        return primerNombre + " " + primerApellido;
    }
    
}
