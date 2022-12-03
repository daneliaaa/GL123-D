package semestral.dbconx.Services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import semestral.dbconx.Models.Acerca;

public class AcercaDB {
    Connection _cn;

    public AcercaDB(){
        _cn = new Conexion().openDb();
    }

    public List<Acerca> obtenerAcerca(){
        try {
            Statement stmt = _cn.createStatement();
            String query = "SELECT * FROM acerca";
      
            List<Acerca> acercax = new ArrayList<>();
            ResultSet result = stmt.executeQuery(query);
            while (result.next()) {
                Acerca acer = new Acerca(
                  result.getInt("cod_acer"),
                  result.getString("imagen"),
                  result.getString("acerca")
                );
      
              acercax.add(acer);
            }
      
            result.close();
            stmt.close();
            return acercax;
      
          } catch (Exception e) {
            int x = 1;
          }
          return null;
    }

    public int GuardarAcerca(Acerca acerca) {
       int resultado = 0;
      try{
          Statement stmt = _cn.createStatement();
          String query = "Call InsAcerca('"
          + acerca.getImagen() + "','"
          + acerca.getAcerca() + "')";
      

            resultado = stmt.executeUpdate(query);

            return resultado;
       } catch (Exception e) {
        int x = 1;
       }
       return resultado;
      }

    public int ActualizarAcerca(Acerca acerca) {
        int resultado = 0;
        try {
          Statement stm = _cn.createStatement();
          String query = "Call ActualizarAcerca("
          + acerca.getCod_acer() + ",'"
          + acerca.getImagen() + "','"
          + acerca.getAcerca() + "')";
    
          resultado = stm.executeUpdate(query);
    
          return resultado;
        } catch (Exception e) {
          int x = 1;
        }
        return resultado;
      }

    public int EliminarAcerca(int cod_acer) {
        int resultado = 0;
        try {
          Statement stmt = _cn.createStatement();
          String query = "Call EliminarAcerca(" + cod_acer + ")";
  
          return stmt.executeUpdate(query);
    
        } catch (Exception e) {
          int x = 1;
        }
        return resultado;
      }
}
