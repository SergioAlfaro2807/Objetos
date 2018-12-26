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
public class Cliente {
  protected String primerNombre;
  protected String provincia;
  protected String canton;
  protected String distrito;
  protected String direccionExacta;
  
  
  public Cliente(){
      primerNombre = "";
      provincia = "";
      canton = "";
      distrito = "";
      direccionExacta = "";
  }

  /**
   * Metodo constructor Cliente
   * @param primerNombre
   * @param provincia
   * @param canton
   * @param distrito
   * @param direccionExacta 
   */
    public Cliente(String primerNombre, String provincia, String canton, String distrito, String direccionExacta) {
        this.primerNombre = primerNombre;
        this.provincia = provincia;
        this.canton = canton;
        this.distrito = distrito;
        this.direccionExacta = direccionExacta;
    }

    
   /**
     * Metodo que retorna el primerNombre del cliente
     * @return Retorna el primerNombre del cliente
     */  
    public String getPrimerNombre() {
        return primerNombre;
    }

        
     /**
     * Metodo que le agrega una acitividad al cliente
     * @param primerNombre Primer nombre Cliente
     */
    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

     /**
     * Metodo que retorna la provincia del cliente
     * @return Retorna la provincia del cliente
     */
    public String getProvincia() {
        return provincia;
    }

        
     /**
     * Metodo que le agrega una provincia al cliente
     * @param provincia Provincia Cliente
     */
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

     /**
     * Metodo que retorna el canton del cliente
     * @return Retorna el canton del cliente
     */
    public String getCanton() {
        return canton;
    }

        
     /**
     * Metodo que le agrega un canton al cliente
     * @param canton Canton Cliente
     */
    public void setCanton(String canton) {
        this.canton = canton;
    }

     /**
     * Metodo que retorna el distrito de la base
     * @return Retorna el distrito del cliente
     */
    public String getDistrito() {
        return distrito;
    }

        
     /**
     * Metodo que le agrega un distrito al cliente
     * @param distrito Distrito Cliente
     */
    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

     /**
     * Metodo que retorna la direccion exacta del cliente
     * @return Retorna la direccion exacta del cliente
     */
    public String getDireccionExacta() {
        return direccionExacta;
    }

        
     /**
     * Metodo que le agrega una direccion exacta al cliente
     * @param direccionExacta Direccion exacta Cliente
     */
    public void setDireccionExacta(String direccionExacta) {
        this.direccionExacta = direccionExacta;
    }

    
      /**
     * Metodo que retorna los datos del cliente en String
     * @return Retorna los datos de del cliente en String
     */
    @Override
    public String toString() {
        return "Cliente{" + "primerNombre=" + primerNombre + ", provincia=" + provincia + ", canton=" + canton + ", distrito=" + distrito + ", direccionExacta=" + direccionExacta + '}';
    }

   
  
  
}
