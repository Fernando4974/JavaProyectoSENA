package model;




import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Date; // Importación correcta para java.sql.Date
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.ConexionBD;
import model.IPersonaDAO;
import model.Persona;

/**
 *
 * @author Fertch
 */
public class  PersonaDAO implements IPersonaDAO {
     
      
       
      
    @Override
    public int guardar(Persona persona, String signoZodiacal) throws SQLException {
    
        int id=0;
        String sql = "INSERT INTO personas (nombre, fecha_nacimiento, signo_zodiacal) VALUES (?, ?, ?)";
        Connection conn = null;
        PreparedStatement stmt = null;
       // ResultSet rs = null;

        try {
            conn = ConexionBD.conectar();
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, persona.getNombre());
            // Convierte LocalDate a java.sql.Date para el PreparedStatement
            stmt.setDate(2, Date.valueOf(persona.getFechaNacimiento())); // getFechaNacimiento()
            stmt.setString(3, signoZodiacal);

            stmt.executeUpdate();
            System.out.println("Persona " + persona.getNombre() + " guardada con éxito.");
            //if(rs.next()){
              //  id= rs.getInt(1);
            
            //};
        } finally {
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        }
        return id;
    }
    
    
    
    @Override
    public Persona obtenerPorId(int id)throws SQLException{
     Persona persona =null;
     String sql = "SELECT id, nombre, fecha_nacimiento, signo_zodiacal FROM personas WHERE id = ?";
   
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
     
    try{
       conn = ConexionBD.conectar();
       stmt = conn.prepareStatement(sql);
       stmt.setInt(1, id);
       rs = stmt.executeQuery();
       
       if (rs.next()) {
           persona= new Persona();
           persona.setId(rs.getInt("id"));
           persona.setNombre(rs.getString("nombre"));
           //fecha nacimiento
           Date date= rs.getDate("fecha_nacimiento");
           LocalDate dateParceado = date.toLocalDate();
           persona.setFechaNacimiento(dateParceado);
       }
    } finally {
        if (rs != null) rs.close();
        if (stmt != null) stmt.close();
        if (conn != null) conn.close();
    }
    return persona;
    }
    @Override 
    public List<Persona> obtenerTodosSoloIdNombre() throws SQLException{
     List<Persona> personas = new ArrayList<Persona>();
     String sql = "SELECT id , nombre FROM personas";
     Connection conn = null;
     ResultSet rs= null;
     PreparedStatement stmt =null;
     
     try{
     
         conn= ConexionBD.conectar();
         stmt= conn.prepareStatement(sql);
         rs= stmt.executeQuery();
         
         while(rs.next()){
         
         Persona persona = new Persona();
         persona.setId(rs.getInt("id"));
         persona.setNombre(rs.getString("nombre"));
         personas.add(persona);
         
         
         }
         
     }
     finally{
     if(conn!=null){conn.close();}
     if(rs!=null){rs.close();}
     if(stmt!=null){stmt.close();}
     
     }
     
     return personas;
    }

    @Override
    public List<Persona> obtenerTodos() throws SQLException {
        
    
        List<Persona> personas = new ArrayList<Persona>();
    
        String sql = "SELECT id, nombre, fecha_nacimiento, signo_zodiacal FROM personas";
        Connection conn= null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try{
        
            conn= ConexionBD.conectar();
            stmt = conn.prepareStatement(sql);
            rs= stmt.executeQuery();
          
            while(rs.next()){
            
            Persona persona = new Persona();
            persona.setId(rs.getInt("id"));
            persona.setNombre(rs.getNString("nombre"));
            persona.setFechaNacimiento(rs.getDate("fecha_nacimiento").toLocalDate());
            persona.setSignoZodiacal(rs.getString("signo_zodiacal"));
            
            personas.add(persona);
                
}
                
                  
        
            
        }finally{
        
         if(rs!=null)rs.close();
         if(conn!=null) conn.close();
         if(stmt!= null) stmt.close();

}
                    
               return personas;     
        }

        @Override
        public void actualizar(Persona persona, String signoZodiacal) throws SQLException {

        String sql= "UPDATE personas SET nombre = ?, fecha_nacimiento = ?, signo_zodiacal = ? WHERE id = ?";
        Connection conn = null;
        PreparedStatement stmt= null;
        
        
        try{
        
        conn = ConexionBD.conectar();
        
        stmt=conn.prepareStatement(sql);
       
       
        
       
            stmt.setString(1, persona.getNombre());
            // Convierte LocalDate a java.sql.Date para el PreparedStatement
            stmt.setDate(2, Date.valueOf(persona.getFechaNacimiento()));
            stmt.setString(3, signoZodiacal);
            stmt.setInt(4, persona.getId());

            stmt.executeUpdate();
            System.out.println("Persona " + persona.getNombre() + " actualizada con éxito.");
        }
        finally{

        if(conn!=null){conn.close();
        if(stmt!= null){stmt.close();}

}

        }
        }

 

   

    @Override
    public void eliminar(int id) throws SQLException {
        Connection conn=null;
        PreparedStatement stmt=null;
        String sql= "Delete from personas where id=?;";
        try {
            conn = ConexionBD.conectar();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Persona con ID " + id + " eliminada con éxito.");
            } else {
                System.out.println("No se encontró persona con ID " + id + " para eliminar.");
            }

        } finally {
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        }
        }
    
    }

/**
    
    package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date; // Necesario para trabajar con java.sql.Date
import java.time.LocalDate; // Necesario para trabajar con java.time.LocalDate
import java.util.ArrayList;
import java.util.List;

/**
 
  @author Fertch
 
public class PersonaDAO implements IPersonaDAO {

    @Override
    public void guardar(Persona persona, String signoZodiacal) throws SQLException {
        // La consulta ahora inserta 'fecha_nacimiento' en lugar de 'edad'
        String sql = "INSERT INTO personas (nombre, fecha_nacimiento, signo_zodiacal) VALUES (?, ?, ?)";
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = ConexionBD.conectar();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, persona.getNombre());
            // Convierte LocalDate a java.sql.Date para el PreparedStatement
            stmt.setDate(2, Date.valueOf(persona.getFechaNacimiento())); // getFechaNacimiento()
            stmt.setString(3, signoZodiacal);

            stmt.executeUpdate();
            System.out.println("Persona " + persona.getNombre() + " guardada con éxito.");

        } finally {
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        }
    }

    @Override
    public Persona obtenerPorId(int id) throws SQLException {
        Persona persona = null;
        // La consulta selecciona 'fecha_nacimiento' en lugar de 'edad'
        String sql = "SELECT id, nombre, fecha_nacimiento, signo_zodiacal FROM personas WHERE id = ?";

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConexionBD.conectar();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                persona = new Persona();
                persona.setId(rs.getInt("id"));
                persona.setNombre(rs.getString("nombre"));
                // Obtiene java.sql.Date y lo convierte a LocalDate
                persona.setFechaNacimiento(rs.getDate("fecha_nacimiento").toLocalDate());
                // La edad se calculará automáticamente en el setter de fechaNacimiento de Persona
                persona.setSignoZodiacal(rs.getString("signo_zodiacal"));
            }
        } finally {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        }
        return persona;
    }

    @Override
    public List<Persona> obtenerTodos() throws SQLException {
        List<Persona> personas = new ArrayList<>();
        // La consulta selecciona 'fecha_nacimiento' en lugar de 'edad'
        String sql = "SELECT id, nombre, fecha_nacimiento, signo_zodiacal FROM personas";

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConexionBD.conectar();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Persona persona = new Persona();
                persona.setId(rs.getInt("id"));
                persona.setNombre(rs.getString("nombre"));
                // Obtiene java.sql.Date y lo convierte a LocalDate
                persona.setFechaNacimiento(rs.getDate("fecha_nacimiento").toLocalDate());
                // La edad se calculará automáticamente en el setter de fechaNacimiento de Persona
                persona.setSignoZodiacal(rs.getString("signo_zodiacal"));
                personas.add(persona);
            }
        } finally {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        }
        return personas;
    }

    @Override
    public void actualizar(Persona persona, String signoZodiacal) throws SQLException {
        // La consulta actualiza 'fecha_nacimiento' en lugar de 'edad'
        String sql = "UPDATE personas SET nombre = ?, fecha_nacimiento = ?, signo_zodiacal = ? WHERE id = ?";
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = ConexionBD.conectar();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, persona.getNombre());
            // Convierte LocalDate a java.sql.Date para el PreparedStatement
            stmt.setDate(2, Date.valueOf(persona.getFechaNacimiento()));
            stmt.setString(3, signoZodiacal);
            stmt.setInt(4, persona.getId());

            stmt.executeUpdate();
            System.out.println("Persona " + persona.getNombre() + " actualizada con éxito.");

        } finally {
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        }
    }

    @Override
    public void eliminar(int id) throws SQLException {
        String sql = "DELETE FROM personas WHERE id = ?";
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = ConexionBD.conectar();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Persona con ID " + id + " eliminada con éxito.");
            } else {
                System.out.println("No se encontró persona con ID " + id + " para eliminar.");
            }

        } finally {
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        }
    }
}
 **/