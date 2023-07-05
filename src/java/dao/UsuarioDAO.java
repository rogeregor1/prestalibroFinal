/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import modelo.Usuario;

/**
 *
 * @author familiahurtado
 */
public interface UsuarioDAO {
    public Usuario buscarXid(int Uid);
    public List listadoUsuarios();
    public List ListadoUsuarioDisponibles();
    public String Agregar(Usuario usuario);
}
