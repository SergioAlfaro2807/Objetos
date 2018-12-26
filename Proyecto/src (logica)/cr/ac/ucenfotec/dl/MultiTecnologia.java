/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucenfotec.dl;

import cr.ac.ucenfotec.connectivity.Conector;
import cr.ac.ucenfotec.bl.Tecnologia;
import java.sql.ResultSet;
import java.util.ArrayList;
import javafx.collections.ObservableList;

/**
 *
 * @author Dell
 */
public class MultiTecnologia {

    public MultiTecnologia() {

    }

    /**
     * Metodo que registra una nueva tecnologia la base de datos
     * @param nombre Nombre tecnologia
     * @param codigoTecnologia Codigo tecnologia
     * @return Retorna la nueva tecnologia
     * @throws Exception 
     */
    public Tecnologia registrarTecnologia(String nombre, String codigoTecnologia) throws Exception {
        Tecnologia mitecnologia = null;

        String query;

        query = "Execute [dbo].[sp_registrar_tecnologia] '" + codigoTecnologia + "','" + nombre + "'";

        try {
            Conector.getConector().ejecutarSQL(query);
            mitecnologia = new Tecnologia(nombre, codigoTecnologia);
        } catch (Exception e) {
            throw e;
        }
        return mitecnologia;

    }

    /**
     * Metodo que registra la tecnologia asociada al proyecto
     * @param tecnologia Tecnologia
     * @param codigo Codigo proyecto
     * @return Retorna una tecnologia con los datos de la tecnolgia registrada
     * @throws Exception 
     */
    public Tecnologia registrarTecnologiaxProyecto(ArrayList<Tecnologia> tecnologia, String codigo) throws Exception {
        Tecnologia mitecnologia = null;

        String query;

        for (int i = 0; i < tecnologia.size(); i++) {

            query = "Execute [dbo].[sp_registrar_ProyectoxTecnologia] '" + codigo + "','" + tecnologia.get(i).getCodigo() + "'";

            try {
                Conector.getConector().ejecutarSQL(query);
                mitecnologia = new Tecnologia(tecnologia.get(i).getNombre(), tecnologia.get(i).getCodigo());
            } catch (Exception e) {
                throw e;
            }

        }

        return mitecnologia;

    }

    /**
     * Metodo que elimina las tecnologias sociadas a un proyecto
     * @param codigoProyecto Codigo proyecto
     * @return Retorna la tecnologia eliminada
     * @throws Exception 
     */
    public Tecnologia eliminarTecnologiaProyecto(String codigoProyecto) throws Exception {
        Tecnologia mitecnologia = null;
        String query;
        query = "Delete from ProyectoxTecnologia WHERE codigoProyecto = '" + codigoProyecto + "'";

        try {
            Conector.getConector().ejecutarSQL(query);
            mitecnologia = new Tecnologia(codigoProyecto);
        } catch (Exception e) {
            throw e;
        }

        return mitecnologia;
    }

    /**
     * Metodo que actualiza una tecnologia en la base de datos
     * @param nombre Nombre tecnologia
     * @param codigoTecnologia Codigo tecnologia Nuevo
     * @param codigoModificar Codigo tecnologia Viejo
     * @return Retorna la tecnologia actualizada
     * @throws Exception 
     */
    public Tecnologia modificarTecnologia(String nombre, String codigoTecnologia, String codigoModificar) throws Exception {
        Tecnologia mitecnologia = null;

        String query;

        query = "Execute [dbo].[sp_modificar_tecnologia] '" + nombre + "','" + codigoTecnologia + "','" + codigoModificar + "'";

        try {
            Conector.getConector().ejecutarSQL(query);
            mitecnologia = new Tecnologia(nombre, codigoTecnologia);
        } catch (Exception e) {
            throw e;
        }
        return mitecnologia;

    }

    /**
     * Metodo que elimina una tecnologia de la base de datos
     * @param nombre Nombre tecnologia
     * @param codigoTecnologia Codigo tecnologia
     * @return Retorna la tecnologia eliminada
     * @throws Exception 
     */
    public Tecnologia eliminarTecnologia(String nombre, String codigoTecnologia) throws Exception {
        Tecnologia mitecnologia = null;

        String query;

        query = "Execute [dbo].[sp_eliminar_tecnologia] '" + nombre + "','" + codigoTecnologia + "'";

        try {
            Conector.getConector().ejecutarSQL(query);
            mitecnologia = new Tecnologia(nombre, codigoTecnologia);
        } catch (Exception e) {
            throw e;
        }
        return mitecnologia;

    }

    /**
     * Metodo que buscar entre todas las tecnologias un codigo igual al recibido
     * @param codigo Codigo a buscar
     * @return Retorna una tecnologia con el codigo encontrado
     * @throws Exception 
     */
    public Tecnologia buscarTecnologia(String codigo) throws Exception {
        Tecnologia mitecnologia = null;
        boolean buscar = true;
        ResultSet existe;
        String query;
        query = "SELECT nombre, codigo FROM Tecnologia WHERE codigo = '" + codigo + "'";

        try {
            existe = Conector.getConector().ejecutarSQL(query, buscar);

            while (existe.next()) {

                String nombre = existe.getString("nombre");
                String codigoTecnologia = existe.getString("codigo");

                mitecnologia = new Tecnologia(nombre, codigoTecnologia);

            }

        } catch (Exception e) {
            throw e;
        }

        return mitecnologia;
    }

    /**
     * Metodo que selecciona todas las tecnologias en la base de datos
     * @param listaTecnologia lista de tecnologias vacio
     * @return Retorna una lista de todas las tecnologias en la base de datos
     * @throws Exception 
     */
    public ObservableList llenarTecnologia(ObservableList listaTecnologia) throws Exception {
        Tecnologia mitecnologia = null;
        boolean buscar = true;
        ResultSet existe;
        String query;
        query = "SELECT nombre, codigo FROM Tecnologia";

        try {
            existe = Conector.getConector().ejecutarSQL(query, buscar);

            while (existe.next()) {

                String nombre = existe.getString("nombre");
                String codigoTecnologia = existe.getString("codigo");

                listaTecnologia.add(new Tecnologia(nombre, codigoTecnologia));

            }

        } catch (Exception e) {
            throw e;
        }

        return listaTecnologia;
    }

     /**
     * Metodo que selecciona todas las tecnologias en la base de datos
     * @param lista lista de tecnologias vacio
     * @return Retorna una lista de todas las tecnologias en la base de datos
     * @throws Exception 
     */
    public ObservableList<Tecnologia> buscarTecnologias(ObservableList<Tecnologia> lista) throws Exception {
        Tecnologia mitecnologia = null;
        boolean buscar = true;
        ResultSet existe;
        String query;
        query = "SELECT nombre, codigo FROM Tecnologia";

        try {
            existe = Conector.getConector().ejecutarSQL(query, buscar);

            while (existe.next()) {

                String nombre = existe.getString("nombre");
                String codigo = existe.getString("codigo");

                mitecnologia = new Tecnologia(nombre, codigo);

                lista.add(mitecnologia);
            }

        } catch (Exception e) {
            throw e;
        }

        return lista;
    }

}
