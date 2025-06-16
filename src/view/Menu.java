/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.Menu to edit this template
 */
package view;

import java.util.Scanner;

/**
 *
 * @author Fertch
 */
public class Menu {
    
        public String[][] opciones = {
        {"1","Agregar Contacto"},
        {"2","Editar Contacto"},
        {"3","Ver Lista de Contactos"},
        {"4","Eliminar Contacto"},
        {"5","Generar Cita en formato PDF"}
             
    };

    public static void Inicio() {
           
  

        System.out.println("----------------------------------------------------------------------------");
        System.out.println("------------------------- Ejercicios Propuestos en C# ----------------------");
        System.out.println("---------------------------------- Por: ------------------------------------");
        System.out.println("---------------------------- Fernando Villarreal ---------------------------");
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("-------------------------------- Docente: ----------------------------------");
        System.out.println("------------------------------ Luis Fernando -------------------------------");
        System.out.println("-------------------------------- SENA 2025 ---------------------------------");
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("                ____     ________     ____     ____      ________            ");
        System.out.println("              |    |   /         \\   |    |   |    |   /         \\  ");
        System.out.println("              |    |  /   _____   \\  |    |   |    |  /    ____   \\ ");
        System.out.println("              |    |  |   |   |   |  |    |   |    |  |   |    |  |  ");
        System.out.println("              |    |  |   -----   |  |    |   |    |  |    ----   |  ");
        System.out.println("       ___    |    |  |           |  |    |   |    |  |           |  ");
        System.out.println("      |   |   |    |  |    ___    |  |    |   |    |  |    ___    |");
        System.out.println("      |   |   |    |  |    | |    |  |    |   |    |  |    | |    |");
        System.out.println("      |    \\_/    /   |    | |    |  \\    \\ _/    /   |    | |    | ");
        System.out.println("      \\          /    |    | |    |   \\          /    |    | |    |");
        System.out.println("        \\_______/     |____| |____|    \\________/     |____| |____|");
        System.out.println("                                                               ©Fertch         ");
        System.out.println("");
        System.out.println("                             Presiona Enter para iniciar...");

    }

    public boolean SalidaMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Cerrar el Sistema / Iniciar = S/N");
        //  var entrada = Integer.parseInt(sc.nextLine());
        var entrada = sc.nextLine();
        if (entrada != null) {

            entrada = entrada.toUpperCase();

            if (entrada.toLowerCase().equals("s")) {

                return true;
            } else {

                return false;

            }
        }
        return false;

    }
  
    public void MostrarMenuOpciones(){
    
  
     for(int i=0; i<5; i++){
     
         System.out.println("----------------- Marque "+this.opciones[i][0]+" para "+ this.opciones[i][1]+" "
                 + ""
                 + "---");
     }
    }
       public void Procesos(){
       // Scanner sc = new Scanner(System.in);
        Menu objMenu = new Menu();
        objMenu.MostrarMenuOpciones();
        //int opcion= Integer.parseInt(sc.nextLine());
    //return opcion;
    }
       
       public void Encabezado(int opcion){
       opcion--;
       System.out.println("----------------------------------------------\n"+
                          "-------------- "+this.opciones[opcion][1]+" -------------\n"+
                          "----------------------------------------------");
                           
       }
}
