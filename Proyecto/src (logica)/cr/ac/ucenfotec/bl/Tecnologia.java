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
public class Tecnologia extends Base {
    
    
    
    public Tecnologia(){
        nombre = "";
        codigo = "";
    }

    /**
     * Metodo constructo Tecnologia
     * @param nombre
     * @param codigo 
     */
    public Tecnologia(String nombre, String codigo) {
        super(nombre, codigo);
    }
    
   
    /**
     * Metodo constructo Tecnologia
     * @param nombre 
     */
    public Tecnologia(String nombre) {
        super(nombre);
    }
  
    /**
     * Metodo que retorna el nombre de la tecnologia
     * @return Retorna el nombre de la tecnologia
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo que le agrega un nombre a la tecnologia
     * @param nombre Nombre Tecnologia
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo que retorna el codigo de la tecnologia
     * @return Retorna el codigo de la tecnologia
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Metodo que le agrega un codigo a la tecnologia
     * @param codigo Codigo Tecnologia
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Metodo que retorna los datos de la tecnologia en String
     * @return Retorna los datos de de la tecnologia en String
     */
    @Override
    public String toString() {
        return nombre;
    }
    
    
}
