// controller/Controlador.java
package controller;

import model.*;
import util.PDFGenerator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import view.*;
import java.util.Scanner;
import util.InputUtils;

public class Controlador {
    InputUtils inputs= new InputUtils();
    Menu objMenu = new Menu();
    Scanner sc= new Scanner(System.in);
    
 
    public void ControlCentral(int opcion){
    
        switch(opcion){
        
            case 1:
                objMenu.Encabezado(opcion);
                System.out.println("Not Developed case 1");
                break;
            case 2:
                objMenu.Encabezado(opcion);
                 System.out.println("Not Developed case 2");
                break;
            case 3: 
                objMenu.Encabezado(opcion);
                 System.out.println("Not Developed case 3");
                break;
            case 4:
                objMenu.Encabezado(opcion);
                 System.out.println("Not Developed case 4");
                break;
            case 5:
                
                do{
                objMenu.Encabezado(opcion);
               this.procesarPersona(inputs.ObtenerNombre(),inputs.ObtenerFecha());
               
                 System.out.println("Not Developed");
               
                }while(!inputs.Salida());
                 break;
            default:
                 System.out.println("Default");
                break;
        
        
        }
    
    }
    
    
    public void procesarPersona(String nombre, LocalDate fechaNacimiento) {
        Persona persona = new Persona(nombre, fechaNacimiento);
        SignoZodiacal signoZodiacal = new SignoZodiacal();
        String signo = signoZodiacal.calcularSigno(fechaNacimiento);

        // Guardar en base de datos
        try (Connection conn = ConexionBD.conectar()) {
            String sql = "INSERT INTO personas (nombre, fecha_nacimiento, signo_zodiacal) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, persona.getNombre());
            ps.setDate(2, java.sql.Date.valueOf(persona.getFechaNacimiento()));
            ps.setString(3, signo);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error al guardar en la base de datos: " + e.getMessage());
        }

        // Generar PDF
        PDFGenerator.generarPDF(persona.getNombre(), fechaNacimiento.toString(), signo);
    }
}