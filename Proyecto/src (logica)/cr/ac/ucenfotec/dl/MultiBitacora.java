/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucenfotec.dl;

import cr.ac.ucenfotec.connectivity.Conector;
import cr.ac.ucenfotec.bl.Bitacora;

/**
 *
 * @author Dell
 */
public class MultiBitacora {

    public MultiBitacora() {

    }

    /**
     * Este metodo registra una nueva bitacora en la base de datos
     *
     * @param mibitacora Nueva bitacora
     * @return retorna la nueva bitacora
     * @throws Exception
     */
    public Bitacora registrarBitacora(Bitacora mibitacora) throws Exception {
        Bitacora mibitacoraNueva = null;
        String nombre = mibitacora.getNombre();

        String query;

        query = "Execute [dbo].[sp_registrar_bitacora] '" + nombre + "'";

        try {
            Conector.getConector().ejecutarSQL(query);
            mibitacoraNueva = new Bitacora(nombre);
        } catch (Exception e) {
            throw e;
        }
        return mibitacoraNueva;

    }

    /**
     * Este metodo actualiza una bitacora en la base de datos
     * @param bitacoraVieja bitacora para actualizar
     * @param bitacoraNueva nuevos datos
     * @return retorna la nueva bitacora
     * @throws Exception 
     */
    public Bitacora modificarBitacora(String bitacoraVieja, String bitacoraNueva) throws Exception {
        Bitacora mibitacoraNueva = null;

        String query;

        query = "Update Bitacora set nombre = '" + bitacoraNueva + "' where nombre = '" + bitacoraVieja + "'";

        try {
            Conector.getConector().ejecutarSQL(query);
            mibitacoraNueva = new Bitacora(bitacoraNueva);
        } catch (Exception e) {
            throw e;
        }
        return mibitacoraNueva;

    }

    /**
     * Este metodo recibe una bitacora y la elimina de la base de datos
     * @param bitacora Bitacora que sera eliminada
     * @return bitacora con sus respectivos datos
     * @throws Exception 
     */
    public Bitacora eliminarBitacora(String bitacora) throws Exception {
        Bitacora mibitacoraNueva = null;

        String query;

        query = "Delete from Bitacora where nombre = '" + bitacora + "'";

        try {
            Conector.getConector().ejecutarSQL(query);
            mibitacoraNueva = new Bitacora(bitacora);
        } catch (Exception e) {
            throw e;
        }
        return mibitacoraNueva;

    }

}
