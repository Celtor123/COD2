package basejdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * declaracion de la clase BaseJDBC
 * @author Celso
 * @version 11/6/2019
 */
public class BaseJDBC {
 
    public Statement conexion(){
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
    public int crearTabla() {
        int st=0;
        try {
            /**declaracion de atributos
             *
             */
           //st=conexion().executeUpdate("drop table TABLA");
           st = conexion().executeUpdate("CREATE TABLE IF NOT EXISTS TABLA (columna1 int ,columna2 varchar(15),columna3 varchar(16))");
        } catch (SQLException ex) {
            System.out.println("Error a la hora de crear la tabla"+ex);
        }
        return st;         
    }
    
    
     public void fin(){
        try {
            conexion().close();
            conexion().getConnection().close();
        } catch (SQLException ex) {
            System.out.println("Error al cerrar la conexion"+ex);
        }
          
     }
     public ArrayList consultar(){
       ArrayList a = null;
        try {
            ResultSet rs;
            rs=conexion().executeQuery("SELECT * FROM TABLA");
            a= new ArrayList();
            while(rs.next()){
            a.add(rs.getInt("columna1"));
            a.add(rs.getString("columna2"));
            a.add(rs.getString("columna3"));
            }
            
            
        } catch (SQLException ex) {
            System.out.println("Error al consultar la tabla\n"+ex);
        }
              
        return a;       
         
     }
 
    
    /**
      * Método que inserta valores en la tabla
      * @param columna1 Valor numérico para ingresar en la tabla
      * @param columna2 Cadena de texto para ingresar en la tabla
      * @param columna3 Cadena de texto para lo mismo
     * @return 
      */
    public int insertar(int columna1,String columna2,String columna3){
        int rs = 0;
        try {         
            rs = conexion().executeUpdate("INSERT INTO TABLA VALUES("+columna1+",'"+columna2+"','"+columna3+"')");           
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
      * @param columna1 Valor numérico para buscar el registro a borrar
      */
    public int borrar(int columna1){
        int rs = 0;
        try {
           
            rs = conexion().executeUpdate("DELETE FROM TABLA WHERE columna1="+columna1+"");
        } catch (SQLException ex) {
            System.out.println("Lo siento, problema con la sentencia sql\n"+ex);
        }
        System.out.println(rs);
        return rs;
    }
    
    
     /**
      * Método que modifica los valores de la tabla
      * @param valor1 Valor numérico para dar el nuevo valor
      * @param valor2 Cadena de texto para dar nuevo valor
      * @param valor3 Cadena de texto para dar nuevo valor
      * @param fin1 Número que perteneze al registro que se quiere modificar
     * @return 
      */
    public int modificar(int valor1,String valor2,String valor3,int fin1){
        int rs = 0;       
        try {           
            rs = conexion().executeUpdate("UPDATE TABLA SET columna1 ="+valor1 +",columna2 ='"+valor2+"', columna3 = '"+valor3+"' WHERE columna1 ="+fin1);
        } catch (SQLException ex) {
            System.out.println("Lo siento, problema con la sentencia sql\n"+ex);
        }
        return rs;
    }   
}
