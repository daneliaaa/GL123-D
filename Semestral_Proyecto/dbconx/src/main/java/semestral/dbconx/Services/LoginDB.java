package semestral.dbconx.Services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import semestral.dbconx.Models.Login;

public class LoginDB {
    Connection _cn;

    public LoginDB(){
        _cn = new Conexion().openDb();
    }

    public List<Login> obtenerLogin(){
        try {
            Statement stmt = _cn.createStatement();
            String query = "SELECT * FROM login";
      
            List<Login> loginx = new ArrayList<>();
            ResultSet result = stmt.executeQuery(query);
            while (result.next()) {
                Login log = new Login(
                  result.getInt("cod_log"),
                  result.getString("correo"),
                  result.getString("contraseña")

                );
      
              loginx.add(log);
            }
      
            result.close();
            stmt.close();
            return loginx;
      
          } catch (Exception e) {
            int x = 1;
          }
          return null;
    }

    public int GuardarLogin(Login login) {
       int resultado = 0;
      try{
          Statement stmt = _cn.createStatement();
          String query = "Call InsLogin('"
            + login.getCorreo() + "','"
            + login.getContraseña() + "')";
      

            resultado = stmt.executeUpdate(query);

            return resultado;
       } catch (Exception e) {
        int x = 1;
       }
       return resultado;
      }

    public int ActualizarLogin(Login login) {
        int resultado = 0;
        try {
          Statement stm = _cn.createStatement();
          String query = "Call ActualizarLogin("
          + login.getCod_log() + ",'"
          + login.getCorreo() + "','"
          + login.getContraseña() + "')";
    
          resultado = stm.executeUpdate(query);
    
          return resultado;
        } catch (Exception e) {
          int x = 1;
        }
        return resultado;
      }

    public int EliminarLogin(int cod_log) {
        int resultado = 0;
        try {
          Statement stmt = _cn.createStatement();
          String query = "Call EliminarLogin(" + cod_log + ")";
  
          return stmt.executeUpdate(query);
    
        } catch (Exception e) {
          int x = 1;
        }
        return resultado;
      }
}
