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
import javafx.collections.ObservableList;

/**
 *
 * @author Dell
 */
public class MultiClienteJuridico {

    public MultiClienteJuridico() {

    }

    /**
     * Metodo para registrar un cliente juridico en la base de datos
     *
     * @param cedula Cedula cliente
     * @param micontacto Contacto cliente
     * @param primerNombre Primer nombre cliente
     * @param provincia Provincia cliente
     * @param canton Canton cliente
     * @param distrito Distrito cliente
     * @param direccionExacta Direccion exacta cliente
     * @param telefono Telefono cliente
     * @return Retorna un cliente con sus respectivos datos
     * @throws Exception
     */
    public ClienteJuridico registrarClienteJuridico(String cedula, Contacto micontacto, String primerNombre, String provincia, String canton, String distrito, String direccionExacta, String telefono) throws Exception {
        ClienteJuridico miclienteJuridico = null;
        String identificacionContacto = micontacto.getCedula();
        String query;

        query = "Execute [dbo].[sp_registrar_cliente_juridico] '" + cedula + "','" + identificacionContacto + "','" + primerNombre + "','" + provincia + "','" + canton + "','" + distrito + "','" + direccionExacta + "','" + telefono + "'";

        try {
            Conector.getConector().ejecutarSQL(query);
            miclienteJuridico = new ClienteJuridico(cedula, micontacto, primerNombre, provincia, canton, distrito, direccionExacta, telefono);
        } catch (Exception e) {
            throw e;
        }
        return miclienteJuridico;

    }

    /**
     * Metodo para actualizar un cliente juridico en la base de datos
     * @param cedula Cedula cliente
     * @param micontacto Contacto cliente
     * @param primerNombre Primer nombre cliente
     * @param provincia Provincia cliente
     * @param canton Canton cliente
     * @param distrito Distrito cliente
     * @param direccionExacta Direccion exacta cliente
     * @param telefono Telefono cliente
     * @param buscarIdentificacion Identifacion del cliente a modificar
     * @return
     * @throws Exception 
     */
    public ClienteJuridico modificarClienteJuridico(String cedula, Contacto micontacto, String primerNombre, String provincia, String canton, String distrito, String direccionExacta, String telefono, String buscarIdentificacion) throws Exception {
        ClienteJuridico miclienteJuridico = null;
        String identificacionContacto = micontacto.getCedula();
        String query;

        query = "Execute [dbo].[sp_modificar_cliente_juridico] '" + cedula + "','" + identificacionContacto + "','" + primerNombre + "','" + provincia + "','" + canton + "','" + distrito + "','" + direccionExacta + "','" + telefono + "','" + buscarIdentificacion + "'";

        try {
            Conector.getConector().ejecutarSQL(query);
            miclienteJuridico = new ClienteJuridico(cedula, micontacto, primerNombre, provincia, canton, distrito, direccionExacta, telefono);
        } catch (Exception e) {
            throw e;
        }
        return miclienteJuridico;

    }

    
    /**
     * Metodo que busca entre todos los cliente juridicos si existe un telefono igual 
     * @param telefono telefono buscar
     * @return retorno retorna un cliente juridico si lo encuentra
     * @throws Exception 
     */
    public ClienteJuridico buscarClienteJuridicoTelefono(String telefono) throws Exception {
        ClienteJuridico miclienteJuridico = null;
        boolean buscar = true;
        ResultSet existe;
        String query;
        query = "SELECT telefono FROM ClienteJuridico WHERE telefono = '" + telefono + "'";

        try {
            existe = Conector.getConector().ejecutarSQL(query, buscar);

            while (existe.next()) {

                String correoCliente = existe.getString("telefono");

                miclienteJuridico = new ClienteJuridico(correoCliente);

            }

        } catch (Exception e) {
            throw e;
        }

        return miclienteJuridico;
    }
    
    /**
     * Metodo que buscar entre todos los clientes juridico que tengan esa identificacion
     * @param identificacion
     * @return retorna un cliente juridico si encutra la identificacion
     * @throws Exception 
     */
    public ClienteJuridico buscarClienteJuridicoIdentificacion(String identificacion) throws Exception {
        ClienteJuridico miclienteJuridico = null;
        boolean buscar = true;
        ResultSet existe;
        String query;
        query = "SELECT identificacion FROM ClienteJuridico WHERE identificacion = '" + identificacion + "'";

        try {
            existe = Conector.getConector().ejecutarSQL(query, buscar);

            while (existe.next()) {

                String identificaion = existe.getString("identificacion");

                miclienteJuridico = new ClienteJuridico(identificaion);

            }

        } catch (Exception e) {
            throw e;
        }

        return miclienteJuridico;
    }

    /**
     * Metodo que buscar todos los clientes juridicos de la base de datos y los mete en una lista 
     * @param lista lista vacia de clientes juridicos
     * @return retorna la lista con todos los clientes juridicos de la base de datos
     * @throws Exception 
     */
    public ObservableList<ClienteJuridico> buscarClientesJuridicos(ObservableList<ClienteJuridico> lista) throws Exception {
        ClienteJuridico miclienteJuridico = null;
        boolean buscar = true;
        ResultSet existe;
        String query;
        query = "SELECT nombre, identificacion, telefono, provincia, canton, distrito, direccion_exacta, contacto FROM ClienteJuridico";

        try {
            existe = Conector.getConector().ejecutarSQL(query, buscar);

            while (existe.next()) {

                String nombre = existe.getString("nombre");
                String identificacion = existe.getString("identificacion");
                String telefono = existe.getString("telefono");
                String provincia = existe.getString("provincia");
                String canton = existe.getString("canton");
                String distrito = existe.getString("distrito");
                String direccionExacta = existe.getString("direccion_exacta");

                Contacto contacto = new Contacto(existe.getString("contacto"));

                miclienteJuridico = new ClienteJuridico(identificacion, contacto, nombre, provincia, canton, distrito, direccionExacta, telefono);
                System.out.println(miclienteJuridico.toString());
                lista.add(miclienteJuridico);
            }

        } catch (Exception e) {
            throw e;
        }

        return lista;
    }

    /**
     * Metodo para eliminar un cliente juridico de la base datos
     * @param miclienteJuridicoEliminar Cliente juridico para eliminar
     * @return retorna el cliente juridico eliminado
     * @throws Exception 
     */
    public ClienteJuridico eliminarClienteJuridico(ClienteJuridico miclienteJuridicoEliminar) throws Exception {
        ClienteJuridico miclienteJuridico = null;
        String query;
        String cedula = miclienteJuridicoEliminar.getCedula();

        query = "Execute [dbo].[sp_eliminar_cliente_juridico] '" + cedula + "'";

        try {

            Conector.getConector().ejecutarSQL(query);
            miclienteJuridico = new ClienteJuridico(cedula);
        } catch (Exception e) {
            throw e;
        }
        return miclienteJuridico;

    }

}
