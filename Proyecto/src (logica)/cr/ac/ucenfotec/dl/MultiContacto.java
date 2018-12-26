/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucenfotec.dl;

import cr.ac.ucenfotec.connectivity.Conector;
import cr.ac.ucenfotec.bl.ClienteJuridico;
import cr.ac.ucenfotec.bl.Contacto;
import java.sql.ResultSet;

/**
 *
 * @author Dell
 */
public class MultiContacto {

    public MultiContacto() {

    }
    
    /**
     * Metodo que registra un nuevo contacto a la base de datos
     * @param nombre Nombre contacto
     * @param primerApellido Primer apellido contacto
     * @param segundoApellido Segundo apellido contacto
     * @param cedula Identificacion contacto 
     * @param telefono telefono contacto
     * @param correo Correo contacto
     * @return Retorna un contacto con los nuevos datos
     * @throws Exception 
     */
    public Contacto registrarContacto(String nombre, String primerApellido, String segundoApellido, String cedula, String telefono, String correo) throws Exception {
        Contacto micontacto = null;

        String query;

        query = "Execute [dbo].[sp_registrar_contacto] '" + nombre + "','" + primerApellido + "','" + segundoApellido + "','" + cedula + "','" + telefono + "','" + correo + "'";

        try {
            Conector.getConector().ejecutarSQL(query);
            micontacto = new Contacto(nombre, primerApellido, segundoApellido, cedula, telefono, correo);
        } catch (Exception e) {
            throw e;
        }
        return micontacto;

    }

    /**
     * Metodo que actualiza un contacto en la base de datos
     * @param nombre Nombre contacto
     * @param primerApellido Primer apellido contacto
     * @param segundoApellido Segundo apellido contacto
     * @param cedula Identificacion contacto 
     * @param telefono telefono contacto
     * @param correo Correo contacto
     * @param identificacionBuscar Identificacion del contacto a modificar
     * @return retorna el contacto modificado
     * @throws Exception 
     */
    public Contacto modificarContacto(String nombre, String primerApellido, String segundoApellido, String cedula, String telefono, String correo, String identificacionBuscar) throws Exception {
        Contacto micontacto = null;

        String query;

        query = "Execute [dbo].[sp_modificar_contacto] '" + nombre + "','" + primerApellido + "','" + segundoApellido + "','" + cedula + "','" + telefono + "','" + correo + "','" + identificacionBuscar + "'";

        try {
            Conector.getConector().ejecutarSQL(query);
            micontacto = new Contacto(nombre, primerApellido, segundoApellido, cedula, telefono, correo);
        } catch (Exception e) {
            throw e;
        }
        return micontacto;

    }

    /**
     * Metodo que buscar entre todos lo contactos un identficacion que sea igual a la recibida
     * @param identificacion Identificacion a buscar
     * @return retorna un Contacto que tiene esa identificacion
     * @throws Exception 
     */
    public Contacto buscarContacto(String identificacion) throws Exception {
        Contacto micontacto = null;
        boolean buscar = true;
        ResultSet existe;
        String query;
        query = "SELECT primer_nombre, primer_apellido, segundo_apellido, identificacion, telefono, correo FROM Contacto WHERE identificacion = '" + identificacion + "'";

        try {
            existe = Conector.getConector().ejecutarSQL(query, buscar);

            while (existe.next()) {

                String primerNombre = existe.getString("primer_nombre");
                String primerApellido = existe.getString("primer_apellido");
                String segundoApellido = existe.getString("segundo_apellido");
                String identificacionContacto = existe.getString("identificacion");
                String telefono = existe.getString("telefono");
                String correo = existe.getString("correo");
                micontacto = new Contacto(primerNombre, primerApellido, segundoApellido, identificacionContacto, telefono, correo);

            }

        } catch (Exception e) {
            throw e;
        }

        return micontacto;
    }
    
    /**
     * 
     * @param identificacion
     * @return
     * @throws Exception 
     */
    public Contacto buscarContactoIdentificacion(String identificacion) throws Exception {
        Contacto micontacto = null;
        boolean buscar = true;
        ResultSet existe;
        String query;
        query = "SELECT identificacion FROM Contacto WHERE identificacion = '" + identificacion + "'";

        try {
            existe = Conector.getConector().ejecutarSQL(query, buscar);

            while (existe.next()) {

                String contacto = existe.getString("identificacion");

                micontacto = new Contacto(contacto);

            }

        } catch (Exception e) {
            throw e;
        }

        return micontacto;
    }

    /**
     * Metodo que buscar los correo de todos los contactos que sea igual al recibido
     * @param correo Correo a buscar
     * @return Retorna un correo que sea igual al recibido
     * @throws Exception 
     */
    public Contacto buscarContactoCorreo(String correo) throws Exception {
        Contacto micontacto = null;
        boolean buscar = true;
        ResultSet existe;
        String query;
        query = "SELECT correo FROM Contacto WHERE correo = '" + correo + "'";

        try {
            existe = Conector.getConector().ejecutarSQL(query, buscar);

            while (existe.next()) {

                String contacto = existe.getString("correo");

                micontacto = new Contacto(contacto);

            }

        } catch (Exception e) {
            throw e;
        }

        return micontacto;
    }

    /**
     * Metodo que buscar entre todos los telefonos de los contactos que sea igual al recibido
     * @param telefono Telefono a buscar
     * @return retorna un contacto con el telefono encontrado
     * @throws Exception 
     */
    public Contacto buscarContactoTelefono(String telefono) throws Exception {
        Contacto micontacto = null;
        boolean buscar = true;
        ResultSet existe;
        String query;
        query = "SELECT telefono FROM Contacto WHERE telefono = '" + telefono + "'";

        try {
            existe = Conector.getConector().ejecutarSQL(query, buscar);

            while (existe.next()) {

                String contacto = existe.getString("telefono");

                micontacto = new Contacto(contacto);

            }

        } catch (Exception e) {
            throw e;
        }

        return micontacto;
    }

    /**
     * Metodo para eliminar un contacto
     * @param identificacion Identificacion del contacto a eliminar
     * @return retorna el contacto eliminado
     * @throws Exception 
     */
    public Contacto eliminarContacto(String identificacion) throws Exception {
        Contacto micontacto = null;
        String query;

        query = "Execute [dbo].[sp_eliminar_contacto] '" + identificacion + "'";

        try {

            Conector.getConector().ejecutarSQL(query);
            micontacto = new Contacto(identificacion);
        } catch (Exception e) {
            throw e;
        }
        return micontacto;

    }

}
