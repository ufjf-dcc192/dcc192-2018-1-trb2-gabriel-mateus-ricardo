package controlBD;

import java.sql.Connection;
import java.sql.DriverManager;

public class BdConnection {
    public static Connection instancia = null;
    public static Connection getConnection() throws Exception
    {
        if(instancia == null)
        {
            String driverURL = "jdbc:derby://localhost:1527/dcc192-trabalho2-2018-1";
            instancia = DriverManager.getConnection(driverURL, "usuario", "senha");
            return instancia;
        }
        else
        {
            return instancia;
        }
    }
}
