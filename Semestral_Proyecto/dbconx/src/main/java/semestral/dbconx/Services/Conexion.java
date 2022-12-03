package semestral.dbconx.Services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public Connection openDb() {
        try {
          Class.forName("org.mariadb.jdbc.Driver");
          return DriverManager.getConnection("jdbc:mariadb://localhost:3306/juegos_olimpicos","root","");
        } catch (SQLException e) {
          int x = 1;
        } catch (ClassNotFoundException cnfex) {
          int x = 1;
        }
        return null;
      }
}
