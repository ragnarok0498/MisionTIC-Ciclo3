
package ciencia.experimentosDAL;
import java.sql.*;

public class conexionAdministrador {
    
    String strConexionDB = "jdbc:sqlite:C:/Users/Yoraima Rincon/Desktop/Proyecto 9Ciclo3/ciencia.db"; // variable para conectar con la base de datos
    Connection conn = null ;
    
public conexionAdministrador(){
      try {
      Class.forName("org.sqlite.JDBC");
      conn = DriverManager.getConnection(strConexionDB);
      System.out.println("Conexion Establecida");
      }
      catch(Exception e){
          System.out.println("Error en la conexion" + e);
     }
    }
public int ejecutarSentenciasSQL (String strSentenciaSQL){
      try {
          PreparedStatement pstm = conn.prepareStatement(strSentenciaSQL);
          pstm.execute();
          return 1;
      }
      catch(Exception e){
          System.out.println(e);
          return 0;
      }
   
  }    
    public ResultSet consultarRegistros(String strSentenciaSQL){
        try {
        PreparedStatement pstm = conn.prepareStatement(strSentenciaSQL);
        ResultSet respuesta = pstm.executeQuery();
        return respuesta;
        
        }
      
        catch(Exception e){
                System.out.println(e);
                return null;
        }
  }
}
