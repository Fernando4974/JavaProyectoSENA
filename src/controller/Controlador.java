// controller/Controlador.java
package controller;

import model.*;
import util.PDFGenerator;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import view.*;
import java.util.Scanner;
import util.InputUtils;

public class Controlador {
    InputUtils inputs= new InputUtils();
    Menu objMenu = new Menu();
    Scanner sc= new Scanner(System.in);
    PersonaDAO ipersonaDAO = new PersonaDAO();
    SignoZodiacal signo= new SignoZodiacal();
 
    public void ControlCentral(int opcion)throws SQLException{
    
        switch(opcion){
        
            case 1://agregar amigo
                objMenu.Encabezado(opcion);
                System.out.println("Parcial Developed case 1 agregar amigo");
                procesarPersonaPrttp(inputs.ObtenerNombre(),inputs.ObtenerFecha());
                System.out.println("Contacto guardado con exito");
                break;
                
                
                
                
                
            case 2://editar
                objMenu.Encabezado(opcion);
                 System.out.println("Not Developed case 2 editar");
                break;
                
                
                
                
                
            case 3: //ver todos
                objMenu.Encabezado(opcion);
                 System.out.println("Not Developed case 3 ver todos");
                 
                 List<Persona> personasAll =ipersonaDAO.obtenerTodos();
                 for(int i=0; i < personasAll.size();i++){
                 System.out.println(personasAll.get(i).toString());
                 
                 System.out.println("Desea Generar PDF con todos sus Contactos S/N");
                 //funcion por programar
                 };
                 
                break;
                
                
                
                
            case 4://eliminar
                objMenu.Encabezado(opcion);
                 System.out.println("Parcial Developed case 4 eliminar");
                 
               if(!inputs.preguntaConoceIdCase("Eliminar")){
               
            
              List<Persona> personasSoloIdNombre = ipersonaDAO.obtenerTodosSoloIdNombre();
               for(int i = 0 ; i < personasSoloIdNombre.size() ; i++){
               Persona p = personasSoloIdNombre.get(i);
                  System.out.println( "ID: "+p.getId()+"  || Nombre: " +p.getNombre());
                  System.out.println( "---------------------");
               }}
               
                int idpersonaEliminar = inputs.preguntaIngreseIdCase("Eliminar");
                if(inputs.confirmacion()){
                ipersonaDAO.eliminar(idpersonaEliminar);
                }else{System.out.println("Accion Cancelada");}
               
               
                break;
                
                
                
                
                
            case 5://pdf (agendar cita ?)
                
                
                objMenu.Encabezado(opcion);
             
             if(!inputs.preguntaConoceIdCase("Generar Cita")){
             
             List<Persona> personass = ipersonaDAO.obtenerTodosSoloIdNombre();
             
             for(int i=0; i< personass.size();i++){
                Persona p = personass.get(i);
             System.out.println("ID : "+p.getId()+  "||| Nombre: "+p.getNombre());
              System.out.println("-----------------------------");
             }
             
             }
                 
                 int id = inputs.preguntaIngreseIdCase("Generar Cita");
                 Persona p =ipersonaDAO.obtenerPorId(id);
                 List<String>ListaDedatosParaPdf= inputs.datosParaPdf();
                 this.generarPdf(p, p.getFechaNacimiento(),signo.calcularSigno(p.getFechaNacimiento()),ListaDedatosParaPdf.get(0),ListaDedatosParaPdf.get(1),ListaDedatosParaPdf.get(2),ListaDedatosParaPdf.get(3) );
                 System.out.println("Ejecucion Completada pdf");
               
                
                 break;
            default:
                 System.out.println("Default");
                break;
        
        
        }
        
    
    }
    
    
//    public void procesarPersona(String nombre, LocalDate fechaNacimiento)throws SQLException {
//        Persona persona = new Persona(nombre, fechaNacimiento);
//        SignoZodiacal signoZodiacal = new SignoZodiacal();
//        String signo = signoZodiacal.calcularSigno(fechaNacimiento);
        
        

        // Guardar en base de datos
//        try (Connection conn = ConexionBD.conectar()) {
//            String sql = "INSERT INTO personas (nombre, fecha_nacimiento, signo_zodiacal) VALUES (?, ?, ?)";
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setString(1, persona.getNombre());
//            ps.setDate(2, java.sql.Date.valueOf(persona.getFechaNacimiento()));
//            ps.setString(3, signo);
//            ps.executeUpdate();
//        } catch (Exception e) {
//            System.err.println("Error al guardar en la base de datos: " + e.getMessage());
//        }

        // Generar PDF
//        PDFGenerator.generarPDF(persona.getNombre(), fechaNacimiento.toString(), signo);
 
    
    
//    }
       
    public int procesarPersonaPrttp(String nombre, LocalDate fechaNacimiento) throws SQLException {
        
        int id=0;
        Persona persona = new Persona(nombre, fechaNacimiento);
        SignoZodiacal signoZodiacal = new SignoZodiacal();
        String signo = signoZodiacal.calcularSigno(fechaNacimiento);
         ipersonaDAO.guardar(persona, signo);
         
        
        return id;
       
       
    
    
    }
    public void generarPdf(Persona persona, LocalDate fechaNacimiento,String signo, String fecha,String hora,String lugar,String detalles)throws SQLException{
    
     PDFGenerator.generarPDF(persona.getNombre(), fechaNacimiento.toString(), signo,fecha,hora,lugar,detalles);
 
     
    
    }
    

    
    };



