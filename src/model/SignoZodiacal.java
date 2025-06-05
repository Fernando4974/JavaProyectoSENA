// model/SignoZodiacal.java
package model;

import java.time.LocalDate;



public class SignoZodiacal {
   
    public String calcularSigno(LocalDate fecha) {
        int dia = fecha.getDayOfMonth();
        int mes = fecha.getMonthValue();

        return switch (mes) {
            case 1 -> (dia < 20) ? "Capricornio" : "Acuario";
            case 2 -> (dia < 19) ? "Acuario" : "Piscis";
            case 3 -> (dia < 21) ? "Piscis" : "Aries";
            case 4 -> (dia < 20) ? "Aries" : "Tauro";
            case 5 -> (dia < 21) ? "Tauro" : "Géminis";
            case 6 -> (dia < 21) ? "Géminis" : "Cáncer";
            case 7 -> (dia < 23) ? "Cáncer" : "Leo";
            case 8 -> (dia < 23) ? "Leo" : "Virgo";
            case 9 -> (dia < 23) ? "Virgo" : "Libra";
            case 10 -> (dia < 23) ? "Libra" : "Escorpio";
            case 11 -> (dia < 22) ? "Escorpio" : "Sagitario";
            case 12 -> (dia < 22) ? "Sagitario" : "Capricornio";
            default -> "Desconocido";
        };
    }

     
}