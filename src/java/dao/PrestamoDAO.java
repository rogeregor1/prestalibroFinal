/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import modelo.Prestamo;

/**
 *
 * @author familiahurtado
 */
public interface PrestamoDAO {
    public List listadoPrestamos();
    public String Agregar(Prestamo prestamo);
    public String Eliminar(int codigo);
}
