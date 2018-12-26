/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucenfotec.dl;

import cr.ac.ucenfotec.connectivity.Conector;
import cr.ac.ucenfotec.bl.Usuario;
import java.sql.ResultSet;

/**
 *
 * @author Dell
 */
public class MultiUsuario {

    public MultiUsuario() {

    }
    /**
     * Metodo que registra un nuevo usuario a la base de datos
     * @param nombre Nombre usuario
     * @param primerApellido Primer apellido usuario
     * @param segundoApellido Segudno apellido usuario
     * @param correo Correo usuario
     * @param cedula Identificacion usuario
     * @param genero Genero usuario
     * @param avatar Avatar usuario
     * @param contrasenna Contrasenna usuario
     * @return Retorna un usuario con todos los nuevos datos
     * @throws Exception 
     */
    public Usuario crearUsuario(String nombre, String primerApellido, String segundoApellido, String correo, String cedula, String genero, String avatar, String contrasenna) throws Exception {
        Usuario miusuario = null;
        String query;

        query = "Execute [dbo].[sp_registrar_usuario] '" + cedula + "','" + nombre + "','" + primerApellido + "','" + segundoApellido + "','" + correo + "','" + genero + "','" + avatar + "','" + contrasenna + "'";

       
        try {
            Conector.getConector().ejecutarSQL(query);
            miusuario = new Usuario(nombre, primerApellido, segundoApellido, correo, cedula, genero, avatar, contrasenna);
        } catch (Exception e) {
            throw e;
        }
        return miusuario;
    }

    /**
     * Metodo para modificar la contrasenna del usuario
     * @param contrasennaVieja Contrasenna vieja
     * @param contrasennaNueva Contrasenna nueva
     * @return Retorna la contrasenna nueva
     * @throws Exception 
     */
    public Usuario modificarContrasenna(String contrasennaVieja, String contrasennaNueva) throws Exception {
        Usuario miusuario = null;
        String query;

        query = "Execute [dbo].[sp_modificar_contrasenna]   '" + contrasennaVieja + "','" + contrasennaNueva + "'";

   
        try {
            Conector.getConector().ejecutarSQL(query);
            miusuario = new Usuario(contrasennaNueva);
        } catch (Exception e) {
            throw e;
        }
        return miusuario;
    }

    /**
     * Metodo que modifica la contrasenna por medio de un correo 
     * @param contrasennaNueva Contrasenna nueva
     * @param correo Correo usuario
     * @return Retorna la nueva contrasenna
     * @throws Exception 
     */
    public Usuario modificarContrasennaCorreo(String contrasennaNueva, String correo) throws Exception {
        Usuario miusuario = null;
        String query;

        query = "Execute [dbo].[sp_modificar_contrasenna_correo] '" + contrasennaNueva + "','" + correo + "'";

        try {
            Conector.getConector().ejecutarSQL(query);
            miusuario = new Usuario(contrasennaNueva);
        } catch (Exception e) {
            throw e;
        }
        return miusuario;
    }

    /**
     * Metodo que buscar entre todos los usuario una identficacion igual a la recibia
     * @param identificacion Identificacion a buscar
     * @return Retorna un usuario con la identficacion
     * @throws Exception 
     */
    public Usuario buscarUsuario(String identificacion) throws Exception {
        Usuario miusuario = null;
        boolean buscar = true;
        ResultSet existe;
        String query;
        query = "SELECT identificacion, primer_nombre, correo, avatar FROM Usuario WHERE identificacion = '" + identificacion + "'";

        try {
            existe = Conector.getConector().ejecutarSQL(query, buscar);

            while (existe.next()) {

                String identificacionUsuario = existe.getString("identificacion");
                String primernombreUsuario = existe.getString("primer_nombre");
                String correo = existe.getString("correo");
                String avatar = existe.getString("avatar");

                miusuario = new Usuario(primernombreUsuario, correo, identificacionUsuario, avatar);

            }

        } catch (Exception e) {
            throw e;
        }

        return miusuario;
    }

    /**
     * Metodo que busca los datos de un usuario por medio de su contrasenna
     * @param contrasenna Contrasenna usuario
     * @return Retorna un usuario con todos sus datos
     * @throws Exception 
     */
    public Usuario buscarUsuarioLogeado(String contrasenna) throws Exception {
        Usuario miusuario = null;
        boolean buscar = true;
        ResultSet existe;
        String query;
        query = "SELECT identificacion, primer_nombre, primer_apellido, segundo_apellido, correo, genero, avatar, contrasenna FROM Usuario WHERE contrasenna = '" + contrasenna + "'";

        try {
            existe = Conector.getConector().ejecutarSQL(query, buscar);

            while (existe.next()) {

                String identificacionUsuario = existe.getString("identificacion");
                String primer_nombre = existe.getString("primer_nombre");
                String primer_apellido = existe.getString("primer_apellido");
                String segundo_apellido = existe.getString("segundo_apellido");
                String correo = existe.getString("correo");
                String genero = existe.getString("genero");
                String avatar = existe.getString("avatar");
                String contrasennaUsuario = existe.getString("contrasenna");

                miusuario = new Usuario(primer_nombre, primer_apellido, segundo_apellido, correo, identificacionUsuario, genero, avatar, contrasennaUsuario);

            }

        } catch (Exception e) {
            throw e;
        }

        return miusuario;
    }

    /**
     * Metodo que buscar entre todos los usuario un correo igual al recibido
     * @param correo Correo usuario
     * @return Retorna un usuario con el correo encontrado
     * @throws Exception 
     */
    public Usuario buscarCorreo(String correo) throws Exception {
        Usuario miusuario = null;
        boolean buscar = true;
        ResultSet existe;
        String query;
        query = "SELECT correo FROM Usuario WHERE correo = '" + correo + "'";

        try {
            existe = Conector.getConector().ejecutarSQL(query, buscar);

            while (existe.next()) {

                String correoUsuario = existe.getString("correo");

                miusuario = new Usuario(correoUsuario);

            }

        } catch (Exception e) {
            throw e;
        }

        return miusuario;
    }

     /**
     * Metodo que buscar entre todos los usuario un avatar igual al recibido
     * @param avatar Avatar usuario
     * @return Retorna un usuario con el avatar encontrado
     * @throws Exception 
     */
    public Usuario buscarAvatar(String avatar) throws Exception {
        Usuario miusuario = null;
        boolean buscar = true;
        ResultSet existe;
        String query;
        query = "SELECT avatar FROM Usuario WHERE avatar = '" + avatar + "'";

        try {
            existe = Conector.getConector().ejecutarSQL(query, buscar);

            while (existe.next()) {

                String avatarUsuario = existe.getString("avatar");

                miusuario = new Usuario(avatarUsuario);

            }

        } catch (Exception e) {
            throw e;
        }

        return miusuario;
    }

     /**
     * Metodo que buscar entre todos los usuario un correo y contrasenna igual al recibido
     * @param correo Correo usuario
     * @param contrasenna Contrasenna usuario
     * @return Retorna un usuario con el correo y la contrasenna encontrada
     * @throws Exception 
     */
    public Usuario buscarUsuarioExistente(String correo, String contrasenna) throws Exception {
        Usuario miusuario = null;
        boolean buscar = true;
        ResultSet existe;
        String query;
        query = "SELECT correo, contrasenna FROM Usuario WHERE correo = '" + correo + "' and contrasenna = '" + contrasenna + "'";

        try {
            existe = Conector.getConector().ejecutarSQL(query, buscar);

            while (existe.next()) {

                String avatarUsuario = existe.getString("correo");
                String contrasennaUsuario = existe.getString("contrasenna");

                miusuario = new Usuario(avatarUsuario, contrasennaUsuario);

            }

        } catch (Exception e) {
            throw e;
        }

        return miusuario;
    }
}
