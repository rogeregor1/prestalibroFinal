/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import modelo.Ejemplar;

/**
 *
 * @author familiahurtado
 */
public interface EjemplarDAO {
    public Ejemplar buscarXid(int Eid);
    public List ListadoEjemplarDisponibles();
    public String Agregar(Ejemplar ejemplar);
    public List ListadoEjemplares();
    public String ActualizarEjemplarDisponible(int codigo);
    public String Eliminar(int codigo);
}
