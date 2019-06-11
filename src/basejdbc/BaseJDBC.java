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
      * @return Conn 
      * retorna la conexion creada con la base de datos
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
        st.executeUpdate("CREATE TABLE IF NOT EXISTS TABLA (columna1 int PRIMARY KEY,columna2 varchar UNIQUE,columna3 varchar UNIQUE)");
           
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
    
    /**
      * Método que inserta valores en la tabla
      * @param co Reciba la conexion creada en crearTabla()
      * @param columna1 Valor numérico para ingresar en la tabla
      * @param columna2 Cadena de texto para ingresar en la tabla
      * @param columna3 Cadena de texto para lo mismo
      */
    public static int insertar(Connection co,int columna1,String columna2,String columna3){
        int a = 0;
        try {
            Statement st = co.createStatement();
            st.executeUpdate("INSERT INTO TABLA VALUES("+columna1+",'"+columna2+"','"+columna3+"')");
        } catch(org.sqlite.SQLiteException error){
            System.out.println("Problema entre valores, asegúrese de que son correctos \no tiene posibilidad para ello\n"+error);
        }
        catch (SQLException ex) {
            Logger.getLogger(BaseJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        a++;
        return a;
    }
    
     /**
      * Método que elimina valores de la tabla
      * @param co Reciba la conexion creada en crearTabla()
      * @param columna1 Valor numérico para buscar el registro a borrar
      */
    public static void borrar(Connection co,int columna1){
        try {
            Statement st = co.createStatement();
            st.executeUpdate("DELETE FROM TABLA WHERE columna1="+columna1+"");
        } catch (SQLException ex) {
            System.out.println("Lo siento, problema con la sentencia sql\n"+ex);
        }
        
    }
    
    
  
    /**
     * @param args Método principal por los que pasan el resto
     */
    public static void main(String[] args) {
        crearTabla();
      //insertar(crearTabla(),2,"Celos","Pito");
      //Sborrar(crearTabla(),2);
    }
    
}
