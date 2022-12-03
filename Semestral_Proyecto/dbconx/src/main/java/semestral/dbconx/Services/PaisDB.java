package semestral.dbconx.Services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import semestral.dbconx.Models.Paises;

public class PaisDB {
    Connection _cn;

    public PaisDB(){
        _cn = new Conexion().openDb();
    }

    public List<Paises> ObtenerPais(){
        try {
            Statement stmt = _cn.createStatement();
            String query = "SELECT * FROM paises";
      
            List<Paises> paises = new ArrayList<>();
            ResultSet result = stmt.executeQuery(query);
            while (result.next()) {
              Paises pais = new Paises(
                  result.getInt("codpais"),
                  result.getString("nombre"),
                  result.getInt("moro"),
                  result.getInt("mplata"),
                  result.getInt("mbronce"));
      
              paises.add(pais);
            }
      
            result.close();
            stmt.close();
            return paises;
      
          } catch (Exception e) {
            int x = 1;
          }
          return null;
    }

    public int GuardarPais(Paises paises) {
       int resultado = 0;
      try{
          Statement stm = _cn.createStatement();
          String query = "Call InsertarP('"
          + paises.getNombre() +"',"
          + paises.getMoro() +","
          + paises.getMplata() +","
          + paises.getMbronce() +")";

            resultado = stm.executeUpdate(query);

            return resultado;
       } catch (Exception e) {
        int x = 1;
       }
       return resultado;
      }

    public int ActualizarPaises(Paises pais) {
        int resultado = 0;
        try {
          Statement stm = _cn.createStatement();
          String query = "Call ActualizarPais("
          + pais.getCodpais() + ",'"
          + pais.getNombre() +"',"
          + pais.getMoro() +","
          + pais.getMplata() +","
          + pais.getMbronce() +")";
    
          resultado = stm.executeUpdate(query);
    
          return resultado;
        } catch (Exception e) {
          int x = 1;
        }
        return resultado;
      }

    public int EliminarPais(int codpais) {
        int resultado = 0;
        try {
          Statement stmt = _cn.createStatement();
          String query = "Call EliminarPais(" + codpais + ")";
    
          return stmt.executeUpdate(query);
    
        } catch (Exception e) {
          int x = 1;
        }
        return resultado;
      }
}
