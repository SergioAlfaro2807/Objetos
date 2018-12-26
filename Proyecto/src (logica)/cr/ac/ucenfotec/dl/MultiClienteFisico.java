/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucenfotec.dl;

import cr.ac.ucenfotec.connectivity.Conector;
import cr.ac.ucenfotec.bl.ClienteFisico;
import cr.ac.ucenfotec.bl.Usuario;
import java.sql.ResultSet;
import javafx.collections.ObservableList;

/**
 *
 * @author Dell
 */
public class MultiClienteFisico {

    public MultiClienteFisico() {

    }

    /**
     * Este metodo registrar un cliente fisico en la base de datos
     * @param primerApellido Primer apellido cliente
     * @param segundoApellido Segundo apellido cliente
     * @param correo Correo cliente
     * @param telefono Telefono cliente
     * @param provincia Provincia cliente
     * @param canton Canton cliente
     * @param distrito Distrito cliente
     * @param direccionExacta Direcion exacta cliente
     * @param primerNombre Primer nombre cliente
     * @return retorna un cliente con todos sus datos
     * @throws Exception 
     */
    public ClienteFisico crearClienteFisico(String primerApellido, String segundoApellido, String correo, String telefono, String provincia, String canton, String distrito, String direccionExacta, String primerNombre) throws Exception {
        ClienteFisico miclienteFisico = null;
        String query;

        query = "Execute [dbo].[sp_registrar_cliente_fisico] '" + primerNombre + "','" + primerApellido + "','" + segundoApellido + "','" + correo + "','" + telefono + "','" + provincia + "','" + canton + "','" + distrito + "','" + direccionExacta + "'";

        try {

            Conector.getConector().ejecutarSQL(query);
            miclienteFisico = new ClienteFisico(primerApellido, segundoApellido, correo, telefono, provincia, canton, distrito, direccionExacta, primerNombre);
        } catch (Exception e) {
            throw e;
        }
        return miclienteFisico;

    }

    /**
     * Metodo para elimiar un cliente fisico de la base de datos
     * @param miclienteFisicoEliminar Cliente fisico eliminar
     * @return retorna el cliente eliminado
     * @throws Exception 
     */
    public ClienteFisico eliminarClienteFisico(ClienteFisico miclienteFisicoEliminar) throws Exception {
        ClienteFisico miclienteFisico = null;
        String query;
        String correo = miclienteFisicoEliminar.getCorreo();

        query = "Execute [dbo].[sp_eliminar_cliente_fisico] '" + correo + "'";

        try {

            Conector.getConector().ejecutarSQL(query);
            miclienteFisico = new ClienteFisico(correo);
        } catch (Exception e) {
            throw e;
        }
        return miclienteFisico;

    }

    /**
     * Metodo para actualizar un cliente fisico de la base de datos
     * @param primerApellido Primer apellido cliente
     * @param segundoApellido Segundo apellido cliente
     * @param correo Correo cliente
     * @param telefono Telefono cliente
     * @param provincia Provincia cliente
     * @param canton Canton cliente
     * @param distrito Distrito cliente
     * @param direccionExacta Direcion exacta cliente
     * @param primerNombre Primer nombre cliente
     * @param correoCambiar Correo cliente
     * @return retorna el cliente actualizado
     * @throws Exception 
     */
    public ClienteFisico modificarClienteFisico(String primerApellido, String segundoApellido, String correo, String telefono, String provincia, String canton, String distrito, String direccionExacta, String primerNombre, String correoCambiar) throws Exception {
        ClienteFisico miclienteFisico = null;
        String query;

        query = "Execute [dbo].[sp_modificar_cliente_fisico] '" + primerNombre + "','" + primerApellido + "','" + segundoApellido + "','" + correo + "','" + telefono + "','" + provincia + "','" + canton + "','" + distrito + "','" + direccionExacta + "','" + correoCambiar + "'";

        try {

            Conector.getConector().ejecutarSQL(query);
            miclienteFisico = new ClienteFisico(correo);
        } catch (Exception e) {
            throw e;
        }
        return miclienteFisico;

    }

    /**
     * Metodo que buscar un correo que coincida en la base de datos de todos los clientes fisicos
     * @param correo Correo a buscar
     * @return retorna un cliente fisico si encuenta el correo
     * @throws Exception 
     */
    public ClienteFisico buscarClienteFisico(String correo) throws Exception {
        ClienteFisico miclienteFisico = null;
        boolean buscar = true;
        ResultSet existe;
        String query;
        query = "SELECT correo FROM ClienteFisico WHERE correo = '" + correo + "'";

        try {
            existe = Conector.getConector().ejecutarSQL(query, buscar);

            while (existe.next()) {

                String correoCliente = existe.getString("correo");

                miclienteFisico = new ClienteFisico(correoCliente);

            }

        } catch (Exception e) {
            throw e;
        }

        return miclienteFisico;
    }

    /**
     * Metodo que buscar un telefono que coincida en la base de datos de todos los clientes fisicos
     * @param telefono
     * @return retorna un cliente fisico si encuenta el telefono
     * @throws Exception 
     */
    public ClienteFisico buscarClienteFisicoTelefono(String telefono) throws Exception {
        ClienteFisico miclienteFisico = null;
        boolean buscar = true;
        ResultSet existe;
        String query;
        query = "SELECT telefono FROM ClienteFisico WHERE telefono = '" + telefono + "'";

        try {
            existe = Conector.getConector().ejecutarSQL(query, buscar);

            while (existe.next()) {

                String correoCliente = existe.getString("telefono");

                miclienteFisico = new ClienteFisico(correoCliente);

            }

        } catch (Exception e) {
            throw e;
        }

        return miclienteFisico;
    }

    /**
     * Metodo que buscar todos los clientes fisicos registrados en la base de datos
     * @param lista lista vacia
     * @return retorna la lista pero con los datos de los clietnes registrados en la base de datos
     * @throws Exception 
     */
    public ObservableList<ClienteFisico> buscarClientesFisicos(ObservableList<ClienteFisico> lista) throws Exception {
        ClienteFisico miclienteFisico = null;
        boolean buscar = true;
        ResultSet existe;
        String query;
        query = "SELECT primer_nombre, primer_apellido, segundo_apellido, correo, telefono, provincia, canton, distrito, direccion_exacta FROM ClienteFisico";

        try {
            existe = Conector.getConector().ejecutarSQL(query, buscar);

            while (existe.next()) {

                String primerApellido = existe.getString("primer_apellido");
                String segundoApellido = existe.getString("segundo_apellido");
                String correo = existe.getString("correo");
                String telefono = existe.getString("telefono");
                String provincia = existe.getString("provincia");
                String canton = existe.getString("canton");
                String distrito = existe.getString("distrito");
                String direccionExacta = existe.getString("direccion_exacta");
                String primerNombre = existe.getString("primer_nombre");

                miclienteFisico = new ClienteFisico(primerApellido, segundoApellido, correo, telefono, provincia, canton, distrito, direccionExacta, primerNombre);
                lista.add(miclienteFisico);
            }

        } catch (Exception e) {
            throw e;
        }

        return lista;
    }

}
