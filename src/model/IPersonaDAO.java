/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model;

import model.Persona;
import java.sql.SQLException;
import java.util.List;


/**
 *
 * @author Fertch
 */
public interface IPersonaDAO {
    //metodo guarda nueva personona en bd
    void guardar(Persona persona , String signoZodiacal)throws SQLException;
    //meotodo obetener persona po id}
    Persona obtenerPorId(int id)throws SQLException; 
    //metodo obetener todos
    List<Persona> obtenerTodos() throws SQLException;
    //metodo actualizar
    void actualizar(Persona persona, String signoZodiacal)throws SQLException;
    //metodo elimniar persona
    void eliminar(int id)throws SQLException;
    
    
}
