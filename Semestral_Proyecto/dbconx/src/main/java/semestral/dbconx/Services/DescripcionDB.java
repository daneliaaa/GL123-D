package semestral.dbconx.Services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import semestral.dbconx.Models.Descripcion;

public class DescripcionDB {
    Connection _cn;

    public DescripcionDB(){
        _cn = new Conexion().openDb();
    }

    public List<Descripcion> obtenerDescripcion(){
        try {
            Statement stmt = _cn.createStatement();
            String query = "SELECT * FROM descripcion";
      
            List<Descripcion> descripcionx = new ArrayList<>();
            ResultSet result = stmt.executeQuery(query);
            while (result.next()) {
                Descripcion descrip = new Descripcion(
                  result.getInt("cod_desc"),
                  result.getString("titulo"),
                  result.getString("imagen") ,
                  result.getString("descripcion")

                );
      
              descripcionx.add(descrip);
            }
      
            result.close();
            stmt.close();
            return descripcionx;
      
          } catch (Exception e) {
            int x = 1;
          }
          return null;
    }

    public int GuardarDescripcion(Descripcion descripcion) {
       int resultado = 0;
      try{
          Statement stmt = _cn.createStatement();
          String query = "Call InsDescripcion('"
            + descripcion.getTitulo() + "','"
            + descripcion.getImagen() + "','"
            + descripcion.getDescripcion() +"')";

            resultado = stmt.executeUpdate(query);

            return resultado;
       } catch (Exception e) {
        int x = 1;
       }
       return resultado;
      }

    public int ActualizarDescripcion(Descripcion descripcion) {
        int resultado = 0;
        try {
          Statement stm = _cn.createStatement();
          String query = "Call ActualizarDescripcion("
          + descripcion.getCod_desc() + ",'"
          + descripcion.getTitulo() + "',"
          + descripcion.getImagen() + "','"
          + descripcion.getDescripcion() + "')";
    
          resultado = stm.executeUpdate(query);
    
          return resultado;
        } catch (Exception e) {
          int x = 1;
        }
        return resultado;
      }

    public int EliminarDescripcion(int cod_desc) {
        int resultado = 0;
        try {
          Statement stmt = _cn.createStatement();
          String query = "Call EliminarDescripcion(" + cod_desc + ")";
  
          return stmt.executeUpdate(query);
    
        } catch (Exception e) {
          int x = 1;
        }
        return resultado;
      }
}
