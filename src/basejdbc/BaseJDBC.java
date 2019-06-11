package basejdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * declaracion de la clase BAseJDBC
 * @author Celso
 * @version 11/6/2019
 */
public class BaseJDBC {
 
  
     /**
      * Método que crea la tabla
      * @return 
      */
    public static Connection crearTabla() {
     /**declaracion de atributos
      * 
      */
    Connection conn = null;
    String url = null;
    Statement st = null;
    ResultSet rs;
    /**
    * @param conn,url,st,rs    
    *
    */
    
        try {
            url = "jdbc:sqlite:primera clase.db";            
            conn = DriverManager.getConnection(url);         
        st=conn.createStatement();
        st.executeUpdate("CREATE TABLE IF NOT EXISTS TABLA (columna1 int PRIMARY KEY,columna2 varchar,columna3 varchar)");
           
        } 
         catch (SQLException ex) {
            Logger.getLogger(BaseJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
          
//        finally {
//            try {
//                if (conn != null) {
//                    conn.close();
//                    st.close();
//                }
//            } catch (SQLException ex) {
//                System.out.println("Error de creación de la tabla (TABLA)"+ex.getMessage());
//            }
//        }
   return conn;   
    }
    
    public static void insertar(Connection co,int columna1,String columna2,String columna3){
        try {
            Statement st = co.createStatement();
            st.executeUpdate("INSERT INTO TABLA VALUES("+columna1+",'"+columna2+"','"+columna3+"')");
        } catch (SQLException ex) {
            Logger.getLogger(BaseJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
  
    /**
     * @param args Método principal por los que pasan el resto
     */
    public static void main(String[] args) {
        crearTabla();
       insertar(crearTabla(),2,"Hola","Celso");
    }
    
}
