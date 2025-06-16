/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;
import java.time.LocalDate;
import java.util.Scanner;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fertch
 */
public class InputUtils {
    
    Scanner sc = new Scanner(System.in);
    
    public boolean Salida(){
    boolean salida= false;
    System.out.println("Desea Volver a menu de opciones S/N");
    String r= sc.nextLine(); 
    
    if(r.toLowerCase().equals("s")){salida=true;}
    return salida;
    }
    
        public String ObtenerNombre()throws SQLException {
    
          System.out.println("Ingrese el Nombre de su amigo   ");
                String nameString = sc.nextLine();
    return nameString;
    }
     public LocalDate ObtenerFecha()throws SQLException{
    
       System.out.println("Ingrese la fecha de nacimiento (YYYY-MM-DD) ");
               String dateString = sc.nextLine();
               LocalDate date = LocalDate.parse(dateString);
               
               
    return date;
    }
     public Boolean preguntaConoceIdCase(String opcion){
         String res="";
         Boolean respuesta=false;
       
         
            System.out.print("Conoce el id del Contacto que desea " +opcion+" S/N ");
              res= sc.nextLine();
              
              if(res.equalsIgnoreCase("s")){
                  respuesta=true;
              }
         
     return respuesta;
     }
     
     public int preguntaIngreseIdCase(String opcion){
     
       int  respuesta=0;
       
         System.out.print("Ingrese el id del Contacto que desea " +opcion+ " : ");
              respuesta= Integer.parseInt(sc.nextLine());
             
       
     
     return respuesta;
     }
     
     public Boolean confirmacion(){
   
         Boolean r = false;
         System.out.print("Seguro que Desea Eliminar este registro S/N  ");
         String respuesta = sc.nextLine();
         
         if(!respuesta.isEmpty()){
             
             if(respuesta.equalsIgnoreCase("S"))
                r = true;
         }
         
              
     return r;
     }
     public List<String> datosActualizar(){
     
         List<String> listaDatosActualizar= new ArrayList();
         
            System.out.println("Ingrese El nuevo nombre");
            listaDatosActualizar.add(sc.nextLine());
       
            listaDatosActualizar.add(sc.nextLine());
         
     return listaDatosActualizar;
     }
     public List<String> datosParaPdf(){
     List<String> ListaDedatosParaPdf= new ArrayList<String>();
     
     System.out.println("Ingrese la Fecha de la Reunion  ");
     ListaDedatosParaPdf.add(sc.nextLine());
     System.out.println("Ingrese la Hora de la Reunion  ");
     ListaDedatosParaPdf.add(sc.nextLine());
     System.out.println("Ingrese El lugar de la Reunion  ");
     ListaDedatosParaPdf.add(sc.nextLine());
     System.out.println("Detalles : ");
     ListaDedatosParaPdf.add(sc.nextLine());
     
     return ListaDedatosParaPdf;
     
     }
             
}
