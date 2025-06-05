/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;
import java.time.LocalDate;
import java.util.Scanner;
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
    
        public String ObtenerNombre(){
    
          System.out.println("Ingrese el Nombre de su amigo");
                String nameString = sc.nextLine();
    return nameString;
    }
     public LocalDate ObtenerFecha(){
    
       System.out.println("Ingrese la fecha de nacimiento (YYYY-MM-DD)");
               String dateString = sc.nextLine();
               LocalDate date = LocalDate.parse(dateString);
               
    return date;
    }
}
