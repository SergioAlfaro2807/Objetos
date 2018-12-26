/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucenfotec.bl;

import java.time.LocalDate;
import java.util.ArrayList;
import javafx.collections.ObservableList;

/**
 *
 * @author Dell
 */
public class Proyecto extends Base {


    private String descripcion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private ObservableList<Tecnologia> tecnologias;
    private ArrayList<Actividad> actividades;
    private Usuario miavatar;
    private String tipo;
    private String asociado;
    private ClienteFisico clienteFisico;
    private ClienteJuridico clienteJuridico;
    private Bitacora bitacora;
    
    
    
    public Proyecto(){
        
        nombre = "";
        codigo = "";
        descripcion = "";
        fechaInicio = LocalDate.now();
        fechaFin = LocalDate.now();
      
      
        
        
    }

    /**
     * Metodo contructor Proyecto
     * @param descripcion
     * @param fechaInicio
     * @param fechaFin
     * @param tipo
     * @param asociado
     * @param bitacora
     * @param nombre
     * @param codigo 
     */
    public Proyecto(String descripcion, LocalDate fechaInicio, LocalDate fechaFin, String tipo, String asociado, Bitacora bitacora, String nombre, String codigo) {
        super(nombre, codigo);
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.tipo = tipo;
        this.asociado = asociado;
        this.bitacora = bitacora;
    }

  
    /**
     * Metodo contructor Proyecto
     * @param descripcion
     * @param fechaInicio
     * @param fechaFin
     * @param tecnologias
     * @param actividades
     * @param tipo
     * @param clienteJuridico
     * @param bitacora
     * @param nombre
     * @param codigo 
     */
    public Proyecto(String descripcion, LocalDate fechaInicio, LocalDate fechaFin, ObservableList<Tecnologia> tecnologias, ArrayList<Actividad> actividades, String tipo, ClienteJuridico clienteJuridico, Bitacora bitacora, String nombre, String codigo) {
        super(nombre, codigo);
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.tecnologias = tecnologias;
        this.actividades = actividades;
        this.tipo = tipo;
        this.clienteJuridico = clienteJuridico;
        this.bitacora = bitacora;
    }

    /**
     * Metodo contructor Proyecto
     * @param nombre
     * @param codigo 
     */
    public Proyecto(String nombre, String codigo) {
        super(nombre, codigo);
    }

   
    /**
     * Metodo contructor Proyecto
     * @param descripcion
     * @param fechaInicio
     * @param fechaFin
     * @param tecnologias
     * @param actividades
     * @param tipo
     * @param clienteJuridico
     * @param bitacora 
     */
    public Proyecto(String descripcion, LocalDate fechaInicio, LocalDate fechaFin, ObservableList<Tecnologia> tecnologias, ArrayList<Actividad> actividades, String tipo, ClienteJuridico clienteJuridico, Bitacora bitacora) {
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.tecnologias = tecnologias;
        this.actividades = actividades;
        this.tipo = tipo;
        this.clienteJuridico = clienteJuridico;
        this.bitacora = bitacora;
    }
       
    /**
     * Metodo contructor Proyecto
     * @param tecnologias 
     */
    public Proyecto(ObservableList<Tecnologia> tecnologias) {
        this.tecnologias = tecnologias;
    }

    /**
     * Metodo contructor Proyecto
     * @param descripcion
     * @param fechaInicio
     * @param fechaFin
     * @param tecnologias
     * @param actividades
     * @param miavatar
     * @param tipo
     * @param nombre
     * @param codigo 
     */
    public Proyecto(String descripcion, LocalDate fechaInicio, LocalDate fechaFin, ObservableList<Tecnologia> tecnologias, ArrayList<Actividad> actividades, Usuario miavatar, String tipo, String nombre, String codigo) {
        super(nombre, codigo);
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.tecnologias = tecnologias;
        this.actividades = actividades;
        this.miavatar = miavatar;
        this.tipo = tipo;
    }

    /**
     * Metodo contructor Proyecto
     * @param descripcion
     * @param fechaInicio
     * @param miavatar
     * @param tipo
     * @param bitacora
     * @param nombre
     * @param codigo 
     */
    public Proyecto(String descripcion, LocalDate fechaInicio, Usuario miavatar, String tipo, Bitacora bitacora, String nombre, String codigo) {
        super(nombre, codigo);
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.miavatar = miavatar;
        this.tipo = tipo;
        this.bitacora = bitacora;
    }
    
    /**
     * Metodo contructor Proyecto
     * @param descripcion
     * @param fechaInicio
     * @param clienteJuridico
     * @param tipo
     * @param bitacora
     * @param nombre
     * @param codigo 
     */
    
     public Proyecto(String descripcion, LocalDate fechaInicio, ClienteJuridico clienteJuridico, String tipo, Bitacora bitacora, String nombre, String codigo) {
        super(nombre, codigo);
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.clienteJuridico = clienteJuridico;
        this.tipo = tipo;
        this.bitacora = bitacora;
    }
     
     /**
      * 
      * @param descripcion
      * @param fechaInicio
      * @param clienteFisico
      * @param tipo
      * @param bitacora
      * @param nombre
      * @param codigo 
      */
      public Proyecto(String descripcion, LocalDate fechaInicio, ClienteFisico clienteFisico, String tipo, Bitacora bitacora, String nombre, String codigo) {
        super(nombre, codigo);
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.clienteFisico = clienteFisico;
        this.tipo = tipo;
        this.bitacora = bitacora;
    }
    
    /**
     * Metodo contructor Proyecto
     * @param descripcion
     * @param fechaInicio
     * @param fechaFin
     * @param tecnologias
     * @param actividades
     * @param miavatar
     * @param tipo 
     */
    public Proyecto(String descripcion, LocalDate fechaInicio, LocalDate fechaFin, ObservableList<Tecnologia> tecnologias, ArrayList<Actividad> actividades, Usuario miavatar, String tipo) {
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.tecnologias = tecnologias;
        this.actividades = actividades;
        this.miavatar = miavatar;
        this.tipo = tipo;
    }
    
    
    /**
     * Metodo contructor Proyecto
     * @param descripcion
     * @param fechaInicio
     * @param fechaFin
     * @param tecnologias
     * @param actividades
     * @param miavatar
     * @param tipo
     * @param clienteFisico
     * @param clienteJuridico
     * @param bitacora
     * @param nombre
     * @param codigo 
     */
    public Proyecto(String descripcion, LocalDate fechaInicio, LocalDate fechaFin, ObservableList<Tecnologia> tecnologias, ArrayList<Actividad> actividades, Usuario miavatar, String tipo, ClienteFisico clienteFisico, ClienteJuridico clienteJuridico, Bitacora bitacora, String nombre, String codigo) {
        super(nombre, codigo);
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.tecnologias = tecnologias;
        this.actividades = actividades;
        this.miavatar = miavatar;
        this.tipo = tipo;
        this.clienteFisico = clienteFisico;
        this.clienteJuridico = clienteJuridico;
        this.bitacora = bitacora;
    }
    
    /**
     * Metodo contructor Proyecto
     * @param descripcion
     * @param fechaInicio
     * @param fechaFin
     * @param tecnologias
     * @param actividades
     * @param miavatar
     * @param tipo
     * @param clienteFisico
     * @param clienteJuridico
     * @param bitacora 
     */
    public Proyecto(String descripcion, LocalDate fechaInicio, LocalDate fechaFin, ObservableList<Tecnologia> tecnologias, ArrayList<Actividad> actividades, Usuario miavatar, String tipo, ClienteFisico clienteFisico, ClienteJuridico clienteJuridico, Bitacora bitacora) {
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.tecnologias = tecnologias;
        this.actividades = actividades;
        this.miavatar = miavatar;
        this.tipo = tipo;
        this.clienteFisico = clienteFisico;
        this.clienteJuridico = clienteJuridico;
        this.bitacora = bitacora;
    }

   
    /**
     * Metodo contructor Proyecto
     * @param descripcion
     * @param fechaInicio
     * @param fechaFin
     * @param tecnologias
     * @param actividades
     * @param tipo
     * @param clienteFisico
     * @param nombre
     * @param codigo 
     */
    public Proyecto(String descripcion, LocalDate fechaInicio, LocalDate fechaFin, ObservableList<Tecnologia> tecnologias, ArrayList<Actividad> actividades, String tipo, ClienteFisico clienteFisico, String nombre, String codigo) {
        super(nombre, codigo);
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.tecnologias = tecnologias;
        this.actividades = actividades;
        this.tipo = tipo;
        this.clienteFisico = clienteFisico;
       
    }

    /**
     * Metodo contructor Proyecto
     * @param descripcion
     * @param fechaInicio
     * @param fechaFin
     * @param tecnologias
     * @param actividades
     * @param tipo
     * @param clienteJuridico
     * @param nombre
     * @param codigo 
     */
       public Proyecto(String descripcion, LocalDate fechaInicio, LocalDate fechaFin, ObservableList<Tecnologia> tecnologias, ArrayList<Actividad> actividades, String tipo, ClienteJuridico clienteJuridico, String nombre, String codigo) {
        super(nombre, codigo);
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.tecnologias = tecnologias;
        this.actividades = actividades;
        this.tipo = tipo;
        this.clienteJuridico = clienteJuridico;      
    }

      /**
       * Metodo contructor Proyecto
       * @param descripcion
       * @param fechaInicio
       * @param tecnologias
       * @param miavatar
       * @param tipo
       * @param bitacora
       * @param nombre
       * @param codigo 
       */
    public Proyecto(String descripcion, LocalDate fechaInicio, ObservableList<Tecnologia> tecnologias, Usuario miavatar, String tipo, Bitacora bitacora, String nombre, String codigo) {
        super(nombre, codigo);
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.tecnologias = tecnologias;
        this.miavatar = miavatar;
        this.tipo = tipo;
        this.bitacora = bitacora;
    }

    /**
     * Metodo contructor Proyecto
     * @param descripcion
     * @param fechaInicio
     * @param fechaFin
     * @param miavatar
     * @param tipo
     * @param bitacora
     * @param nombre
     * @param codigo 
     */

    public Proyecto(String descripcion, LocalDate fechaInicio, LocalDate fechaFin, Usuario miavatar, String tipo, Bitacora bitacora, String nombre, String codigo) {
        super(nombre, codigo);
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.miavatar = miavatar;
        this.tipo = tipo;
        this.bitacora = bitacora;
         }

    /**
     * Metodo contructor Proyecto
     * @param asociado 
     */
    public Proyecto(String asociado) {
        this.asociado = asociado;
    }
       
       
  
       
    /**
     * Metodo que retorna la bitacora del proyecto
     * @return Retorna la bitacora del proyecto
     */
    public Bitacora getBitacora() {
        return bitacora;
    }

    /**
     * Metodo que le agrega una bitacora al proyecto
     * @param bitacora Bitacora Proyecto
     */
    public void setBitacora(Bitacora bitacora) {
        this.bitacora = bitacora;
    }

   
   /**
     * Metodo que retorna el asociado del proyecto
     * @return Retorna el asociado del proyecto
     */
    public String getAsociado() {
        return asociado;
    }

    /**
     * Metodo que le agrega un asociado al proyecto
     * @param asociado Asociado Proyecto
     */
    public void setAsociado(String asociado) {
        this.asociado = asociado;
    }
    
    /**
     * Metodo que retorna el tipo del proyecto
     * @return Retorna el tipo del proyecto
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Metodo que le agrega un tipo al proyecto
     * @param tipo Tipo Proyecto
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Metodo que retorna el cliente fisico del proyecto
     * @return Retorna el cliente fisico del proyecto
     */
    public ClienteFisico getClienteFisico() {
        return clienteFisico;
    }

    /**
     * Metodo que le agrega un clienteFisico al proyecto
     * @param clienteFisico Cliente Fisico Proyecto
     */
    public void setClienteFisico(ClienteFisico clienteFisico) {
        this.clienteFisico = clienteFisico;
    }

    /**
     * Metodo que retorna el cliente juridico del proyecto
     * @return Retorna el cliente juridico del proyecto
     */
    public ClienteJuridico getClienteJuridico() {
        return clienteJuridico;
    }

    /**
     * Metodo que le agrega un clienteJuridico al proyecto
     * @param clienteJuridico Cliente Juridico Proyecto
     */
    public void setClienteJuridico(ClienteJuridico clienteJuridico) {
        this.clienteJuridico = clienteJuridico;
    }
  
    /**
     * Metodo que retorna el nombre del proyecto
     * @return Retorna el nombre del proyecto
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo que le agrega un nombre al proyecto
     * @param nombre Nombre Proyecto
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo que retorna el codigo del proyecto
     * @return Retorna el codigo del proyecto
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Metodo que le agrega un codigo al proyecto
     * @param codigo Codigo Proyecto
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Metodo que retorna ls descripcion del proyecto
     * @return Retorna la descripcion del proyecto
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Metodo que le agrega una descripcion al proyecto
     * @param descripcion Descripcion Proyecto
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Metodo que retorna la fecha inicio del proyecto
     * @return Retorna la fecha inicio del proyecto
     */
    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    /**
     * Metodo que le agrega una fecha inicio al proyecto
     * @param fechaInicio Fecha inicio Proyecto
     */
    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * Metodo que retorna la fecha fin del proyecto
     * @return Retorna la fecha fin del proyecto
     */
    public LocalDate getFechaFin() {
        return fechaFin;
    }

    /**
     * Metodo que le agrega una fin inicio al proyecto
     * @param fechaFin Fecha fin Proyecto
     */
    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    /**
     * Metodo que retorna el avatar del proyecto
     * @return Retorna la avatar del proyecto
     */
    public Usuario getUsuario() {
        return miavatar;
    }

    /**
     * Metodo que le agrega un usuario al proyecto
     * @param usuario  Usuario Proyecto
     */
    public void setUsuario(Usuario usuario) {
        this.miavatar = usuario;
    }

    /**
     * Metodo que retorna las tecnologias del proyecto
     * @return Retorna las tecnologias del proyecto
     */
    public ObservableList<Tecnologia> getTecnologias() {
        return tecnologias;
    }

    /**
     * Metodo que le agrega unas tecnologias al proyecto
     * @param tecnologias Tecnologias inicio Proyecto
     */
    public void setTecnologias(ObservableList<Tecnologia> tecnologias) {
        this.tecnologias = tecnologias;
    }

    /**
     * Metodo que retorna las actividades del proyecto
     * @return Retorna las actividades del proyecto
     */
    public ArrayList<Actividad> getActividades() {
        return actividades;
    }

    /**
     * Metodo que le agrega unas actividades al proyecto
     * @param actividades Actividades inicio Proyecto
     */
    public void setActividades(ArrayList<Actividad> actividades) {
        this.actividades = actividades;
    }

    /**
     * Metodo que retorna el avatar del proyecto
     * @return Retorna el avatar del proyecto
     */
    public Usuario getMiavatar() {
        return miavatar;
    }

    /**
     * Metodo que le agrega un Avatar al proyecto
     * @param miavatar Avatar inicio Proyecto
     */
    public void setMiavatar(Usuario miavatar) {
        this.miavatar = miavatar;
    }

    /**
     * Metodo que retorna los datos del proyecto en String
     * @return Retorna los datos de del proyecto en String
     */
    public String toString() {
        
        return "Proyecto{" + "nombre=" + nombre + ", codigo=" + codigo + ", descripcion=" + descripcion + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", tecnologias=" + tecnologias + ", actividades=" + actividades + ", usuario=" + miavatar + '}';
    }
    
    
}
