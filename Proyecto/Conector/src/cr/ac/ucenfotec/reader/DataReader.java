package cr.ac.ucenfotec.reader;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.*;

/**
 * Clase que permite la solicitud de información
 * para la conexión con la base de datos.
 *
 * @author  Pablo Bonilla G.
 * @author  Daniel José Herrera P.
 * @version 1.0
 * @since   2018-11-20
 */

public class DataReader {
    private static final File DATABASE_DATA = new File("src/DBData.json");
    private static JsonParser jsonParser = new JsonParser();

    public DataReader() {}

    /**
     * Método que extrae el valor del archivo JSON
     * por medio de una palabra clave determinada.
     *
     * @param key Palabra clave utilizada en el archivo JSON.
     * @return Valor JSON de la palabra clave.
     */
    public String getDBData(String key) {
        JsonElement jsonData;
        Object obj;
        JsonObject jsonObj;
        String data = "";
        try {
            obj = jsonParser.parse(new FileReader(DATABASE_DATA));
            jsonObj = (JsonObject) obj;
            jsonData = jsonObj.get(key);
            data = jsonData.getAsString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return data;
    }

    /**
     * @return Valor del "driver".
     */
    public String getDriver() {
        return getDBData("driver");
    }

    /**
     * @return Valor del "server".
     */
    public String getServer() {
        return getDBData("server");
    }

    /**
     * @return Valor de "database".
     */
    public String getDatabase() {
        return getDBData("database");
    }

    /**
     * @return Valor del "user".
     */
    public String getUser() {
        return getDBData("user");
    }

    /**
     * @return Valor de "password".
     */
    public String getPassword() {
        return getDBData("password");
    }
}