/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import modelo.Libro;

/**
 *
 * @author familiahurtado
 */
public interface LibroDAO {
    public Libro buscarXid(int id);
    public List ListadoLibroDisponibles();
    public String Agregar(Libro libro);
    public int eliminar(Libro libro);
    public List listadoLibros();
    public String ActualizarLibroDisponible(int codigo);
    public Libro encontrarLibro(int id);
}
