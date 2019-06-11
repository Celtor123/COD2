package basejdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * declaracion de la clase BaseJDBC
 * @author Celso
 * @version 11/6/2019
 */
public class BaseJDBC {
 
    public static Statement conexion(){
        Statement st = null;
        try {
            Connection conn = null;
            String url = null;
            
            /**
             * @param conn
             * @param url
             *
             */       
            url = "jdbc:sqlite:primera clase.db";   
            conn = DriverManager.getConnection(url);
            st=conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(BaseJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return st;
    }
     /**
      * Método que crea la tabla
      * @return Conn 
      * retorna la conexion creada con la base de datos
      */
    public static void crearTabla() {
        try {
            /**declaracion de atributos
             *
             */
            
          
            conexion().executeUpdate("CREATE TABLE IF NOT EXISTS TABLA (columna1 int ,columna2 varchar,columna3 varchar)");
        } catch (SQLException ex) {
            Logger.getLogger(BaseJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
         
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
 
    
    /**
      * Método que inserta valores en la tabla
      * @param co Reciba la conexion creada en crearTabla()
      * @param columna1 Valor numérico para ingresar en la tabla
      * @param columna2 Cadena de texto para ingresar en la tabla
      * @param columna3 Cadena de texto para lo mismo
     * @return 
      */
    public static int insertar(int columna1,String columna2,String columna3){
        int rs = 0;
        try {
         
            rs = conexion().executeUpdate("INSERT INTO TABLA VALUES("+columna1+",'"+columna2+"','"+columna3+"')");
            System.out.println(rs);
        } catch(org.sqlite.SQLiteException error){
            System.out.println("Problema entre valores, asegúrese de que son correctos \no tiene posibilidad para ello\n"+error);
        }
        catch (SQLException ex) {
            Logger.getLogger(BaseJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }       
      return rs;
    }
    
     /**
      * Método que elimina valores de la tabla
      * @param co Reciba la conexion creada en crearTabla()
      * @param columna1 Valor numérico para buscar el registro a borrar
      */
    public static int borrar(int columna1){
        int rs = 0;
        try {
           
            rs = conexion().executeUpdate("DELETE FROM TABLA WHERE columna1="+columna1+"");
        } catch (SQLException ex) {
            System.out.println("Lo siento, problema con la sentencia sql\n"+ex);
        }
        System.out.println(rs);
        return rs;
    }
    
    public int modificar(int valor1,String valor2,String valor3){
        int rs = 0;
        try {
           
            rs = conexion().executeUpdate("UPDATE TABLA SET columna1= 'Alfred Schmidt',columna2=''WHERE columna1 ="+valor1+" and columna2='"+valor2+"' and columna3='"+valor3+"'");
        } catch (SQLException ex) {
            System.out.println("Lo siento, problema con la sentencia sql\n"+ex);
        }
        return rs;
    }
    
    
  
    /**
     * @param args Método principal por los que pasan el resto
     */
    public static void main(String[] args) {
       crearTabla();
       //insertar(4,"aasd","sewfs");
       borrar(2);
    }
    
}
