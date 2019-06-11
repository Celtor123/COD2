
package basejdbc;

import javax.swing.JOptionPane;

public class Aplicacion extends BaseJDBC{
   
    public void aplicacion(){
         
  String[] carreras = {
            "Crear la tabla",
            "Insertar",
            "Borrar",
            "Consultar",
            "Modificar",
        };
       
        String resp = (String) JOptionPane.showInputDialog(null, "Seleccione una operación", "Menu Principal", JOptionPane.DEFAULT_OPTION, null, carreras, carreras[0]);
        System.out.println(resp);
        switch(resp){
            case "Crear la tabla":
                crearTabla();
                break;
            case "Insertar":
                insertar(2,"AS","WER");
                break;
            case "Borrar":
                borrar(2);
                break;
            case "Consultar":
                
                break;
            case "Modificar":
                String a[];
                int col1=Integer.parseInt((String) JOptionPane.showInputDialog(null,"Inserte el valor de la columna 1(Un Int)","Variación Registro",0,null,null,null));
                String col2=JOptionPane.showInputDialog(null,"Inserte el valor de la columna 2(Un String)","Variación Registro",0);
                String col3=JOptionPane.showInputDialog(null,"Inserte el valor de la columna 3(String)","Variación Registro",0);
                String val = JOptionPane.showInputDialog(null,"Inserte el valor de la columna 1(int)","Registro a modificar",0);
                System.out.println(modificar(col1,col2,col3,val)+"Registros modificados");
                break;
        }
    }
    
    public static void main(String[] args) {
       Aplicacion a= new Aplicacion();
       a.aplicacion();
    
    }
}
