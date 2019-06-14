
package basejdbc;

import java.util.Iterator;
import javax.swing.JOptionPane;
/** 
    * Clase donde de ejecuta el programa
    * Es la subclase de BaseJDBC 
    * @author Celso
    * @version 11/6/2019
    */
public class Aplicacion extends BaseJDBC{
   String resp;
    /**
     * Método en el que a través de los métodos creados anteriormente
     * en la subclase, las mostramos al usuario con JOptionPane las
     * posibilidades y resultados de estos
     */
    public void aplicacion(){
         try{
  String[] carreras = {
            "Crear la tabla",
            "Borrar la tabla",
            "Insertar",
            "Borrar",
            "Consultar",
            "Modificar",
            "Terminar"
        };
  
       do{           
        resp = (String) JOptionPane.showInputDialog(null, "Seleccione una operación", "Menu Principal", JOptionPane.DEFAULT_OPTION, null, carreras, carreras[0]);
        //System.out.println(resp); Era para pruebas          
        
        switch(resp){
            
            case "Crear la tabla":
                crearTabla();
                System.out.println(crearTabla()+"Tabla creada");
                break;
                
            case "Borrar la tabla":
                borrarTabla();
                System.out.println(crearTabla()+"Tabla Borrada");
                break;
                    
            case "Insertar":
                try{
                int co1=Integer.parseInt(JOptionPane.showInputDialog(null,"Inserte el valor de la columna 1(Un Int)","Nuevo Registro",0));
                String co2=JOptionPane.showInputDialog(null,"Inserte el valor de la columna 2(Un String)","Nuevo Registro",0);
                String co3=JOptionPane.showInputDialog(null,"Inserte el valor de la columna 3(String)","NUevo Registro",0);
                System.out.println(insertar(co1,co2,co3)+"Registros registrados");
                }
                catch(java.lang.NumberFormatException e){
                        System.out.println("Por favor meta un valor válido \n"+e);
                        }
                fin();
                break;
                
            case "Borrar":
                try{
                int borrador=Integer.parseInt((String) JOptionPane.showInputDialog(null,"Inserte el valor de la columna 1(Un Int)","Nuevo Registro",0,null,null,null));
                System.out.println(borrar(borrador)+" registros eliminados");}
                catch(java.lang.NumberFormatException e){
                        System.out.println("Por favor meta el valor válido(Un número entero) \n"+e);
                        }
                fin();
                break;
                
            case "Consultar":
                try{
                Iterator qwe= consultar().iterator();
                int a=1;
                while(qwe.hasNext()){
	        Object elemento = qwe.next();
	        System.out.print(elemento+" / \n");
                a++;
                }int r=a/3;
                    System.out.println("La tabla contiene "+r+" filas actualmente");
                }
                catch(java.lang.NullPointerException e){
                    System.out.println("Un elemento (Iterador/ArrayList) está nulo "+e);
                }
                fin();
                break;
                
            
            case "Modificar":
                try{
                int col1=Integer.parseInt((String) JOptionPane.showInputDialog(null,"Inserte el valor de la columna 1(Un Int)","Variación Registro",0,null,null,null));
                String col2=JOptionPane.showInputDialog(null,"Inserte el valor de la columna 2(Un String)","Variación Registro",0);
                String col3=JOptionPane.showInputDialog(null,"Inserte el valor de la columna 3(String)","Variación Registro",0);
                int val = Integer.parseInt(JOptionPane.showInputDialog(null,"Inserte el valor de la columna 1(int)","Registro a modificar tendrá: "+col1+" "+col2+" "+col3,0));
                System.out.println(modificar(col1,col2,col3,val)+"Registros modificados");}
                 catch(java.lang.NullPointerException r){
                    System.out.println("Error:"+r);
                }
                catch(java.lang.NumberFormatException e){
                System.out.println("Por favor meta un valor válido \n"+e);}               
                fin();
                break;
                
            case "Terminar":
                fin();
                System.out.println("Hasta luego");
                break;
        }
        
        }while(!"Terminar".equals(resp));
    }catch(java.lang.NullPointerException t){
             System.out.println("Chao");
    }
    }
    /**
     * @param args Método principal donde se ejecuta el programa
     */
    public static void main(String[] args) {
       Aplicacion a= new Aplicacion();
       a.aplicacion();

    
    }
}
