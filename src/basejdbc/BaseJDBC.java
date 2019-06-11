package basejdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseJDBC {
public static boolean crearTabla() {
    Connection conn = null;
    String url = null;
    Statement st;
    ResultSet rs;
     boolean execute = false;
        try {
       
            // db parameters
            url = "jdbc:sqlite:C:\\Users\\Juan\\PycharmProjects\\Base\\primera clase.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            
            System.out.println("Connection to SQLite has been established.");
            
        st=conn.createStatement();
        st.executeUpdate("CREATE TABLE IF NOT EXISTS TABLA (columna1 int,columna2 varchar,columna3 varchar)");
           
        } 
         catch (SQLException ex) {
            Logger.getLogger(BaseJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
//            
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
//    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        crearTabla();
    }
    
}
