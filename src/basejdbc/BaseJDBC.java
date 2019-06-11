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
 //declaracion de atributos
    static Connection conn = null;
    static String url = null;
    static Statement st;
    static ResultSet rs;
  
     /**
      * Método que crea la tabla
      * @return 
      */
    public static boolean crearTabla() {
   
    /**
    * @param conn,url,st,rs    
    *
    */
     boolean execute = false;
        try {
       
            // db parameters
            url = "jdbc:sqlite:C:\\Users\\Juan\\PycharmProjects\\Base\\primera clase.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            
            
        st=conn.createStatement();
        st.executeUpdate("CREATE TABLE IF NOT EXISTS TABLA (columna1 int,columna2 varchar,columna3 varchar)");
           
        } 
         catch (SQLException ex) {
            Logger.getLogger(BaseJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
  
    System.out.println(execute);
        return execute;
}
  
    /**
     * @param args Método principal por los que pasan el resto
     */
    public static void main(String[] args) {
        crearTabla();
    }
    
}
