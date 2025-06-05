// model/ConexionBD.java
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    public static Connection conectar() {
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/zodiaco_db?useSSL=false&allowPublicKeyRetrieval=true", "root", "admin");
            return cn;
        } catch (SQLException e) {
            System.out.println("Error de conexion local: " + e.getMessage()); // Usa .getMessage() para un error más limpio
            e.printStackTrace(); // Imprime el stack trace completo para depuración
        }
        return null;
    }
}