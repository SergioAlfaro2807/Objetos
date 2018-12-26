package cr.ac.ucenfotec.connectivity;

/**
 * Clase cuya función es la interacción y acceso
 * a la base de datos utilizando la librería de JDBC
 * (Java Database Connectivity).
 *
 * @author  Pablo Bonilla G.
 * @author  Daniel José Herrera P.
 * @version 1.0
 * @since   2018-11-20
 */

import java.sql.*;

public class AccesoBD{
	private Connection conn = null;
	private Statement st;

    public AccesoBD(String driver, String conexion) {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(conexion);
            st = conn.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

	public void ejecutarSQL(String sentencia) throws SQLException {
        st.execute(sentencia);
    }

	public ResultSet ejecutarSQL(String sentencia, boolean retorno) throws SQLException {
	    ResultSet rs;
	    rs = st.executeQuery(sentencia);
        return rs;
    }

	public void iniciarTransaccion() throws SQLException{
		conn.setAutoCommit(false);
	}

	public void terminarTransaccion() throws SQLException{
		conn.setAutoCommit(true);
	}

	public void aceptarTransaccion() throws SQLException{
		conn.commit();
	}

	public void deshacerTransaccion() throws SQLException{
		conn.rollback();	
	}

    public void cerrarConexion() throws SQLException {
        conn.close();
	}				
}