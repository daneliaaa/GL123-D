package semestral.dbconx.Services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import semestral.dbconx.Models.Registro;

public class RegistroDB {
    Connection _cn;

    public RegistroDB(){
        _cn = new Conexion().openDb();
    }

    public List<Registro> obtenerRegistros(){
        try {
            Statement stmt = _cn.createStatement();
            String query = "SELECT * FROM registro";
      
            List<Registro> registros = new ArrayList<>();
            ResultSet result = stmt.executeQuery(query);
            while (result.next()) {
                Registro registro = new Registro(
                    result.getString("correo"),
                    result.getString("nombre"),
                    result.getString("contraseña")
                );
  
      
              registros.add(registro);
            }
      
            result.close();
            stmt.close();
            return registros;
      
          } catch (Exception e) {
            int x = 1;
          }
          return null;
    }

    public int GuardarRegistro(Registro registro) {
       int resultado = 0;
      try{
          Statement stmt = _cn.createStatement();
          String query = "Call InsRegistro('"
            + registro.getCorreo() + "','"
            + registro.getNombre() + "','"
            + registro.getContraseña() + "')";

            resultado = stmt.executeUpdate(query);

            return resultado;
       } catch (Exception e) {
        int x = 1;
       }
       return resultado;
      }

    public int ActualizarRegistros(Registro registro) {
        int resultado = 0;
        try {
          Statement stm = _cn.createStatement();
          String query = "Call ActualizarRegistro("
          + registro.getCorreo() + "','"
          + registro.getNombre() + "','"
          + registro.getContraseña() + "')";
    
          resultado = stm.executeUpdate(query);
    
          return resultado;
        } catch (Exception e) {
          int x = 1;
        }
        return resultado;
      }

    public int EliminarRegistro(int correo) {
        int resultado = 0;
        try {
          Statement stmt = _cn.createStatement();
          String query = "Call EliminarRegistro(" + correo + ")";
    
          return stmt.executeUpdate(query);
    
        } catch (Exception e) {
          int x = 1;
        }
        return resultado;
      }
}
