/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucenfotec.dl;

import cr.ac.ucenfotec.connectivity.Conector;
import cr.ac.ucenfotec.bl.Bitacora;
import cr.ac.ucenfotec.bl.ClienteFisico;
import cr.ac.ucenfotec.bl.ClienteJuridico;
import cr.ac.ucenfotec.bl.Proyecto;
import cr.ac.ucenfotec.bl.Tecnologia;
import cr.ac.ucenfotec.bl.Usuario;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import javafx.collections.ObservableList;

/**
 *
 * @author Dell
 */
public class MultiProyecto {

    public MultiProyecto() {

    }

    /**
     * Metodo que registra un proyecto academico a la base de datos
     *
     * @param descripcion Descripcion proyecto
     * @param fechaInicio Fecha inicio proyecto
     * @param miavatar Asociado proyecto
     * @param tipo Tipo proyecto
     * @param mibitacora Bitacora proyecto
     * @param nombre Nombre proyecto
     * @param codigo Codigo proyecto
     * @return Retorna un proyecto con todos los nuevos datos
     * @throws Exception
     */
    public Proyecto registrarProyectoUsuario(String descripcion, LocalDate fechaInicio, Usuario miavatar, String tipo, Bitacora mibitacora, String nombre, String codigo) throws Exception {
        Proyecto miproyecto = null;

        String query;

        query = "Execute [dbo].[sp_registrar_proyecto] '" + codigo + "','" + nombre + "','" + mibitacora.getCodigo() + "','" + descripcion + "','" + tipo + "','" + miavatar.getCedula() + "','" + fechaInicio + "', null";

        try {
            Conector.getConector().ejecutarSQL(query);
            miproyecto = new Proyecto(descripcion, fechaInicio, miavatar, tipo, mibitacora, nombre, codigo);
        } catch (Exception e) {
            throw e;
        }
        return miproyecto;

    }

    /**
     * Metodo que registra un proyecto comercial juridico a la base de datos
     * @param descripcion Descripcion proyecto
     * @param fechaInicio Fecha inicio proyecto
     * @param juridico Asociado proyecto
     * @param tipo Tipo proyecto
     * @param mibitacora Bitacora proyecto
     * @param nombre Nombre proyecto
     * @param codigo Codigo proyecto
    * @return Retorna un proyecto con todos los nuevos datos
     * @throws Exception
     */
    public Proyecto registrarProyectoClienteJuridico(String descripcion, LocalDate fechaInicio, ClienteJuridico juridico, String tipo, Bitacora mibitacora, String nombre, String codigo) throws Exception {
        Proyecto miproyecto = null;

        String query;

        query = "Execute [dbo].[sp_registrar_proyecto] '" + codigo + "','" + nombre + "','" + mibitacora.getCodigo() + "','" + descripcion + "','" + tipo + "','" + juridico.getCedula() + "','" + fechaInicio + "', null";

        try {
            Conector.getConector().ejecutarSQL(query);
            miproyecto = new Proyecto(descripcion, fechaInicio, juridico, tipo, mibitacora, nombre, codigo);
        } catch (Exception e) {
            throw e;
        }
        return miproyecto;

    }

    /**
     * Metodo que registra un proyecto comercial fisico a la base de datos
     * @param descripcion Descripcion proyecto
     * @param fechaInicio Fecha inicio proyecto
     * @param fisico Asociado proyecto
     * @param tipo Tipo proyecto
     * @param mibitacora Bitacora proyecto
     * @param nombre Nombre proyecto
     * @param codigo Codigo proyecto
    * @return Retorna un proyecto con todos los nuevos datos
     * @return
     * @throws Exception 
     */
    public Proyecto registrarProyectoClienteFisico(String descripcion, LocalDate fechaInicio, ClienteFisico fisico, String tipo, Bitacora mibitacora, String nombre, String codigo) throws Exception {
        Proyecto miproyecto = null;

        String query;

        query = "Execute [dbo].[sp_registrar_proyecto] '" + codigo + "','" + nombre + "','" + mibitacora.getCodigo() + "','" + descripcion + "','" + tipo + "','" + fisico.getCorreo() + "','" + fechaInicio + "', null";

        try {
            Conector.getConector().ejecutarSQL(query);
            miproyecto = new Proyecto(descripcion, fechaInicio, fisico, tipo, mibitacora, nombre, codigo);
        } catch (Exception e) {
            throw e;
        }
        return miproyecto;

    }

    /**
     * Metodo que modificar las tecnologias asociadas a un proyecto
     * @param nombre Nombre tecnologia
     * @param codigoTecnologia Codigo tecnologia vieja
     * @param codigoModificar Codigo tecnologia nueva
     * @return retorna la nueva tecnologia
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
     * Metodo para eliminar un proyecto de la base de datos
     * @param codigoProyecto Proyecto eliminar
     * @return Retorna el proyecto eliminado
     * @throws Exception 
     */
    public Proyecto eliminarProyecto(String codigoProyecto) throws Exception {
        Proyecto miproyecto = null;

        String query;

        query = "Execute [dbo].[sp_eliminar_proyecto] '" + codigoProyecto + "'";

        try {
            Conector.getConector().ejecutarSQL(query);
            miproyecto = new Proyecto(codigoProyecto);
        } catch (Exception e) {
            throw e;
        }
        return miproyecto;

    }

    /**
     * Metodo que buscar entre todos los proyectos un codigo igual al recibido
     * @param codigo Codigo a buscar
     * @return Retorna un proyecto con ese codigo
     * @throws Exception 
     */
    public Proyecto buscarProyecto(String codigo) throws Exception {
        Proyecto miproyecto = null;
        boolean buscar = true;
        ResultSet existe;
        String query;
        query = "SELECT nombre,codigo FROM Proyecto WHERE codigo = '" + codigo + "'";

        try {
            existe = Conector.getConector().ejecutarSQL(query, buscar);

            while (existe.next()) {

                String nombreProyecto = existe.getString("nombre");
                String codigoProyecto = existe.getString("codigo");

                miproyecto = new Proyecto(nombreProyecto, codigoProyecto);

            }

        } catch (Exception e) {
            throw e;
        }

        return miproyecto;
    }

    /**
     * Metodo que selecciona todas las tecnologias
     * @param lista tecnologias
     * @return retorna una lista con todas las tecnologias
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

    /**
     * Metodo que selecciona todos los proyectos de la base de datos
     * @param lista lista de proyectos vacia
     * @return Retorna una lista llena de los proyectos de la base de datos
     * @throws Exception 
     */
    public ObservableList<Proyecto> buscarProyectos(ObservableList<Proyecto> lista) throws Exception {
        Proyecto miproyecto = null;
        boolean buscar = true;
        LocalDate fechafi = null;
        LocalDate fechai = null;
        char tipoProyecto;
        ResultSet existe;
        String query;
        query = "Select codigo, nombre, bitacora, descripcion, tipo, asociado, fechaInicio, fechaFin from Proyecto";

        try {
            existe = Conector.getConector().ejecutarSQL(query, buscar);

            while (existe.next()) {

                String codigo = existe.getString("codigo");
                String nombre = existe.getString("nombre");
                String descripcion = existe.getString("descripcion");
                String bitacora = existe.getString("bitacora");
                String tipo = existe.getString("tipo");
                String asociado = existe.getString("asociado");
                String fechaInicio = existe.getString("fechaInicio");
                String fechaFin = existe.getString("fechaFin");

                Bitacora mibitacora = new Bitacora(bitacora);
                if (fechaFin == null) {

                    String[] fechaIni = fechaInicio.split("-");
                    fechai = LocalDate.of(Integer.parseInt(fechaIni[0]), Integer.parseInt(fechaIni[1]), Integer.parseInt(fechaIni[2]));
                    fechafi = fechai;

                } else {
                    String[] fechaIni = fechaInicio.split("-");
                    fechai = LocalDate.of(Integer.parseInt(fechaIni[0]), Integer.parseInt(fechaIni[1]), Integer.parseInt(fechaIni[2]));
                    String[] fechaFi = fechaFin.split("-");
                    fechafi = LocalDate.of(Integer.parseInt(fechaFi[0]), Integer.parseInt(fechaFi[1]), Integer.parseInt(fechaFi[2]));
                }

                miproyecto = new Proyecto(descripcion, fechai, fechafi, tipo, asociado, mibitacora, nombre, codigo);
                lista.add(miproyecto);

            }

        } catch (Exception e) {
            throw e;
        }

        return lista;
    }

    /**
     * Metodo que busca todas las tecnologias asociadas a un proyecto
     * @param lista Lista de tecnologias vacia
     * @param codigo Codigo de proyecto
     * @return Retorna una lista de las tecnologias asociadas a un proyecto
     * @throws Exception 
     */
    public ObservableList<Tecnologia> buscarTecnologiasProyecto(ObservableList<Tecnologia> lista, String codigo) throws Exception {
        Tecnologia mitecnologia = null;
        boolean buscar = true;
        ResultSet existe;
        String query;
        query = "Select T.codigo, T.nombre from Tecnologia as T inner join ProyectoxTecnologia as PT on PT.codigoTecnologia = T.codigo where PT.codigoProyecto = '" + codigo + "'";

        try {
            existe = Conector.getConector().ejecutarSQL(query, buscar);

            while (existe.next()) {

                String nombreTecnologia = existe.getString("nombre");
                String codigoTecnologia = existe.getString("codigo");
                mitecnologia = new Tecnologia(nombreTecnologia, codigoTecnologia);
                lista.add(mitecnologia);
            }

        } catch (Exception e) {
            throw e;
        }

        return lista;
    }
    /**
     * Metodo que elimina todas las tecnologias asocidas a un proyecto
     * @param listaVieja lista de tecnolgias a elimar
     * @param codigo Codigo de proyecto
     * @return Retorna las tecnologias eliminadas
     * @throws Exception 
     */
    public Tecnologia eliminarTecnologiaxProyecto(ArrayList<Tecnologia> listaVieja, String codigo) throws Exception {
        Tecnologia mitecnologia = null;

        String query;
        for (int i = 0; i < listaVieja.size(); i++) {

            query = "Execute [dbo].[sp_eliminar_ProyectoxTecnologia] '" + codigo + "','" + listaVieja.get(i).getCodigo() + "'";

            try {
                Conector.getConector().ejecutarSQL(query);
                mitecnologia = new Tecnologia(listaVieja.get(i).getCodigo());
            } catch (Exception e) {
                throw e;
            }

        }
        return mitecnologia;
    }

    /**
     * Metodo que actualiza un proyecto en la base de datos
     * @param descripcion Descripcion proyecto
     * @param nombre Nombre proyecto
     * @param codigo Codigo proyecto
     * @param codigoModificar Codigo a buscar
     * @return Retorna un proyecto con los nuevos datos
     * @throws Exception 
     */
    public Proyecto modificarProyecto(String descripcion, String nombre, String codigo, String codigoModificar) throws Exception {
        Proyecto miproyecto = null;

        String query;

        query = "Execute [dbo].[sp_modificar_proyecto] '" + descripcion + "','" + nombre + "','" + codigo + "','" + codigoModificar + "'";

        try {
            Conector.getConector().ejecutarSQL(query);
            miproyecto = new Proyecto(nombre, descripcion);
        } catch (Exception e) {
            throw e;
        }
        return miproyecto;

    }

}
