package cr.ac.ucenfotec.connectivity;

import cr.ac.ucenfotec.reader.DataReader;

/**
 * Clase que permite la inicialización de
 * una única conexión a la base de datos
 * mediante un "driver" y credenciales.
 *
 * @author  Pablo Bonilla G.
 * @author  Daniel José Herrera P.
 * @version 1.0
 * @since   2018-11-20
 */

public class Conector {
    private static DataReader dataReader = new DataReader();
	private static AccesoBD conectorBD = null;

    /**
     * @return AccessoDB Objeto creado para interactuar con la base de datos.
     * @see {@link cr.ac.ucenfotec.connectivity.AccesoBD}
     */
	public static AccesoBD getConector() {
		if (conectorBD == null){
		    conectorBD = new AccesoBD(dataReader.getDriver(), "jdbc:sqlserver://" + dataReader.getServer() + ";databaseName=" + dataReader.getDatabase() + ";user=" + dataReader.getUser() + ";password=" + dataReader.getPassword());
		}
		return conectorBD;
	}
}