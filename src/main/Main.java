package main;


import controller.Controlador;
import view.Menu;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
   
    
    public static void main(String[] args)throws SQLException {
        
        Menu objMenu = new Menu();
        objMenu.Inicio();
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        
        Controlador control= new Controlador();
        //control.Procesos();
        do{ 
        objMenu.Procesos();
        int opcion = sc.nextInt();
        System.out.print("\033[H\033[2J");
        control.ControlCentral(opcion);
        
      
       }while(!objMenu.SalidaMenu());
        
       
       // System.out.print("Ingrese su nombre: ");
        //String nombre = sc.nextLine();

        //System.out.print("Ingrese su fecha de nacimiento (YYYY-MM-DD): ");
        //String fechaStr = sc.nextLine();
        //LocalDate fechaNacimiento = LocalDate.parse(fechaStr);

        //Controlador controlador = new Controlador();
        //controlador.procesarPersona(nombre, fechaNacimiento);
        
    }
}