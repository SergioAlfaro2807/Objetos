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
public class ClienteJuridico extends Cliente {
    private String cedula;
    private Contacto micontacto;
  private String telefono;
  
   
    
    
    public ClienteJuridico(){
        primerNombre = "";
        cedula = "";
        provincia = "";
        canton = "";
        distrito = "";
        direccionExacta = "";
       
    }

    /**
     * Metodo constructor cliente juridico
     * @param cedula
     * @param telefono
     * @param primerNombre
     * @param provincia
     * @param canton
     * @param distrito
     * @param direccionExacta 
     */
    public ClienteJuridico(String cedula, String telefono, String primerNombre, String provincia, String canton, String distrito, String direccionExacta) {
        super(primerNombre, provincia, canton, distrito, direccionExacta);
        this.cedula = cedula;
        this.telefono = telefono;
    }

    /**
     * Metodo constructor cliente juridico
     * @param cedula
     * @param micontacto
     * @param primerNombre
     * @param provincia
     * @param canton
     * @param distrito
     * @param direccionExacta
     * @param telefono 
     */
    public ClienteJuridico(String cedula, Contacto micontacto, String primerNombre, String provincia, String canton, String distrito, String direccionExacta, String telefono) {
        super(primerNombre, provincia, canton, distrito, direccionExacta);
        this.cedula = cedula;
        this.micontacto = micontacto;
        this.telefono = telefono;
    }
    
    
    
    
    
    /**
     * Metodo constructor Cliente juridico
     * @param cedula 
     */
    public ClienteJuridico(String cedula) {
        this.cedula = cedula;
    }

    /**
     * Metodo que retorna el telefono del cliente juridico
     * @return Retorna el telefono del cliente juridico
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Metodo que le agrega un telefono al cliente juridico
     * @param telefono Telefono Cliente juridico
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

 

    
    /**
     * Metodo que retorna el nombre del cliente juridico
     * @return Retorna el nombre del cliente juridico
     */
    public String getNombre() {
        return primerNombre;
    }

    /**
     * Metodo que le agrega un nombre al cliente juridico
     * @param nombre Nombre Cliente juridico
     */
    public void setNombre(String nombre) {
        this.primerNombre = nombre;
    }

    /**
     * Metodo que retorna la cedula del cliente juridico
     * @return Retorna la cedula del cliente juridico
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * Metodo que le agrega una cedula al cliente juridico
     * @param cedula Cedula Cliente juridico
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    /**
     * Metodo que retorna la provincia del cliente juridico
     * @return Retorna la provincia del cliente juridico
     */
    public String getProvincia() {
        return provincia;
    }

    /**
     * Metodo que retorna el contacto del cliente juridico
     * @return Retorna el contacto del cliente juridico
     */
    public Contacto getMicontacto() {
        return micontacto;
    }

    /**
     * Metodo que le agrega un contacto al cliente juridico
     * @param micontacto contacto Cliente juridico
     */
    public void setMicontacto(Contacto micontacto) {
        this.micontacto = micontacto;
    }

    /**
     * Metodo que le agrega una provincia al cliente juridico
     * @param provincia Provincia Cliente juridico
     */
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    /**
     * Metodo que retorna el canton del cliente juridico
     * @return Retorna el canton del cliente juridico
     */
    public String getCanton() {
        return canton;
    }

    /**
     * Metodo que le agrega un canton al cliente juridico
     * @param canton Canton Cliente juridico
     */
    public void setCanton(String canton) {
        this.canton = canton;
    }

    /**
     * Metodo que retorna el distrito del cliente juridico
     * @return Retorna el distrito del cliente juridico
     */
    public String getDistrito() {
        return distrito;
    }

    /**
     * Metodo que le agrega un distrito al cliente juridico
     * @param distrito Distrito Cliente juridico
     */
    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    /**
     * Metodo que retorna la direccion exacta del cliente juridico
     * @return Retorna la direccion exacta del cliente juridico
     */
    public String getDireccion() {
        return direccionExacta;
    }

    /**
     * Metodo que le agrega una direccion al cliente juridico
     * @param direccion Direccion Cliente juridico
     */
    public void setDireccion(String direccion) {
        this.direccionExacta = direccion;
    }


     /**
     * Metodo que retorna los datos del cliente juridico en String
     * @return Retorna los datos de del cliente juridico en String
     */
    @Override
    public String toString() {
        return primerNombre + " " + cedula;
           }

  
    
}
