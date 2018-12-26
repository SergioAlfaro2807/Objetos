/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucenfotec.dl;

import cr.ac.ucenfotec.connectivity.Conector;
import cr.ac.ucenfotec.bl.Actividad;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import javafx.collections.ObservableList;

/**
 *
 * @author Dell
 */
public class MultiActividad {

    /**
     * Este metodo buscar todas las actividades que pertenecen a una bitacora
     * @param lista lista vacia de actividades
     * @param nombreBitacora bitacora asociada
     * @return retorna todas las actividades encontradas
     * @throws Exception 
     */
    public ObservableList<Actividad> buscarActividades(ObservableList<Actividad> lista, String nombreBitacora) throws Exception {
        Actividad miactividad = null;
        boolean buscar = true;
        ResultSet existe;
        String query;

        query = "SELECT codigo, nombre, fecha_inicio, hora_inicio, fecha_fin, hora_fin, bitacora, descripcion FROM Actividad WHERE bitacora = '" + nombreBitacora + "'";

        try {
            existe = Conector.getConector().ejecutarSQL(query, buscar);

            while (existe.next()) {

                String nombre = existe.getString("nombre");
                String fecha_inicio = existe.getString("fecha_inicio");
                String hora_inicio = existe.getString("hora_inicio");
                String fecha_fin = existe.getString("fecha_fin");
                String hora_fin = existe.getString("hora_fin");
                String codigo = existe.getString("codigo");
                String descripcion = existe.getString("descripcion");
                System.out.println(fecha_inicio);
                if (fecha_inicio == null) {
                    fecha_inicio = "No se ha iniciado";
                    fecha_fin = "No se ha iniciado";
                    hora_inicio = "No se ha iniciado";
                    hora_fin = "No se ha iniciado";
                }
                if (fecha_fin == null) {

                    fecha_fin = "No se ha terminado";
                    hora_fin = "No se ha terminado";

                }

                miactividad = new Actividad(descripcion, fecha_inicio, hora_inicio, fecha_fin, hora_fin, nombre, codigo);
                lista.add(miactividad);

            }

        } catch (Exception e) {
            throw e;
        }

        return lista;
    }

    /**
     * Este metodo recibe todos los parametros de la actividad sin fecha para ser registrados en la base de datos
     * @param nombre Nombre actividad
     * @param codigo Codigo Actividad
     * @param descripcion Descripcion Actividad
     * @param bitacora Bitacora Actividad
     * @return retorna una actividad con sus datos
     * @throws Exception 
     */
    public Actividad registrarActividadSinFecha(String nombre, String codigo, String descripcion, String bitacora) throws Exception {
        Actividad miactividad = null;
        String query;

        query = "Execute [dbo].[registrar_actividad_sinFecha] '" + codigo + "','" + nombre + "','" + bitacora + "','" + descripcion + "'";

        try {
            Conector.getConector().ejecutarSQL(query);
            miactividad = new Actividad(descripcion, nombre, codigo);
        } catch (Exception e) {
            throw e;
        }
        return miactividad;
    }

    
    /**
     * Metodo para registrar la actividad de forma manual en la base de datos
     * @param nombre Nombre actividad
     * @param codigo Codigo actividad
     * @param descripcion Descripcion actividad
     * @param bitacora Bitacora actividad
     * @param fechainicio Fecha inicio actividad
     * @param horainicio Hora fin actividad
     * @param fechafin Fecha fin actividad
     * @param horafin Hora fin actividad
     * @return retorna una actividad con sus respectivos datos
     * @throws Exception 
     */
    public Actividad registrarActividadManual(String nombre, String codigo, String descripcion, String bitacora, LocalDate fechainicio, LocalTime horainicio, LocalDate fechafin, LocalTime horafin) throws Exception {
        Actividad miactividad = null;
        String query;

        query = "Execute [dbo].[sp_registrar_actividad_manual] '" + codigo + "','" + nombre + "','" + bitacora + "','" + descripcion + "','" + fechainicio + "','" + horainicio + "','" + fechafin + "','" + horafin + "'";

        try {
            Conector.getConector().ejecutarSQL(query);
            miactividad = new Actividad(descripcion, nombre, codigo);
        } catch (Exception e) {
            throw e;
        }
        return miactividad;
    }

    /**
     * Metodo que recibe los datos para actualizar una actividad e iniciarla en la base de datos
     * @param codigoActividad
     * @param fechainicio
     * @param horafin
     * @return
     * @throws Exception 
     */
    public Actividad iniciarActividad(String codigoActividad, LocalDate fechainicio, LocalTime horafin) throws Exception {
        Actividad miactividad = null;
        String query;

        query = "Execute [dbo].[sp_iniciar_actividad] '" + codigoActividad + "','" + fechainicio + "','" + horafin + "'";

        try {
            Conector.getConector().ejecutarSQL(query);
            miactividad = new Actividad(codigoActividad);
        } catch (Exception e) {
            throw e;
        }
        return miactividad;
    }

    /**
     * Metodo para finalizar una actividad y actualizar sus datos en la base de datos
     * @param codigoActividad Codigo de la actividad que sera actualizada
     * @param fechafin Fecha de finalizacion de la actividad
     * @param horafin Hora de finalizacion de la activdad
     * @return retorna una actividad con sus respectivos datos
     * @throws Exception 
     */
    public Actividad terminarActividad(String codigoActividad, LocalDate fechafin, LocalTime horafin) throws Exception {
        Actividad miactividad = null;
        String query;

        query = "Execute [dbo].[sp_terminar_actividad] '" + codigoActividad + "','" + fechafin + "','" + horafin + "'";

        try {
            Conector.getConector().ejecutarSQL(query);
            miactividad = new Actividad(codigoActividad);
        } catch (Exception e) {
            throw e;
        }
        return miactividad;
    }

    /**
     * Metodo que buscar una actividad por su codigo en la base de datos
     * @param codigo Codigo a buscar
     * @return retorna una Actividad si encuentra el codigo
     * @throws Exception 
     */
    public Actividad buscarActividad(String codigo) throws Exception {
        Actividad miactividad = null;
        boolean buscar = true;
        ResultSet existe;
        String query;
        query = "SELECT codigo FROM Actividad WHERE codigo = '" + codigo + "'";

        try {
            existe = Conector.getConector().ejecutarSQL(query, buscar);

            while (existe.next()) {

                String codigoActividad = existe.getString("codigo");

                miactividad = new Actividad(codigoActividad);

            }

        } catch (Exception e) {
            throw e;
        }

        return miactividad;
    }

}
