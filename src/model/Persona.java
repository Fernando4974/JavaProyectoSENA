package model;

import java.time.LocalDate;
import java.time.Period; // Necesario para calcular la edad

public class Persona {

    private int id; // Nuevo campo: ID de la persona
    private String nombre;
    private int edad; // Nuevo campo: edad de la persona
    private LocalDate fechaNacimiento;
    private String signoZodiacal; // Nuevo campo: signo zodiacal

    // Constructor sin argumentos (necesario para instanciar desde ResultSet en DAO)
    public Persona() {
    }

    // Constructor que incluye todos los campos (útil para crear objetos completos)
    public Persona(String nombre, int edad, LocalDate fechaNacimiento, String signoZodiacal) {
        //this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.fechaNacimiento = fechaNacimiento;
        this.signoZodiacal = signoZodiacal;
    }

    // Constructor original que puedes mantener o modificar si quieres
    public Persona(String nombre, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = calcularEdad(fechaNacimiento); // Calcula la edad automáticamente
        // this.signoZodiacal = calcularSignoZodiacal(fechaNacimiento); // Puedes añadir lógica para calcularlo aquí
    }

    // --- Getters ---
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getSignoZodiacal() {
        return signoZodiacal;
    }

    // --- Setters (necesarios para el DAO) ---
    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
        this.edad = calcularEdad(fechaNacimiento); // Recalcula la edad si la fecha de nacimiento cambia
    }

    public void setSignoZodiacal(String signoZodiacal) {
        this.signoZodiacal = signoZodiacal;
    }

    // Método auxiliar para calcular la edad (puedes implementarlo si lo necesitas)
    private int calcularEdad(LocalDate fechaNacimiento) {
        if (fechaNacimiento == null) {
            return 0; // O manejar el error de otra manera
        }
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }
    
    // Puedes añadir un método similar para calcular el signo zodiacal basado en la fechaNacimiento
    // private String calcularSignoZodiacal(LocalDate fechaNacimiento) { ... }
}