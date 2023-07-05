/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daoImpl;

import config.Conexion;
import dao.UsuarioDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Usuario;

/**
 *
 * @author familiahurtado
 */
public class UsuarioDAOImpl implements UsuarioDAO {

    String urlConexion = "jdbc:mysql://localhost:3306/prestalibro";
    String usu = "root";
    String pas = "12345678";
    Connection cn = Conexion.getConnection(usu, pas, urlConexion);

    @Override
    public Usuario buscarXid(int Uid) {
        Usuario usuario = null;
        try {
            String sql = "SELECT * FROM usuarios WHERE usuario_id=?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, Uid);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                String nombre = rs.getString(2);
                String estado = rs.getString(3);

                usuario = new Usuario(id, nombre, estado);
            }

        } catch (Exception e) {

        }
        return usuario;
    }

    @Override
    public List listadoUsuarios() {
        List<Usuario> lstUsuarios = new ArrayList<>();
        String SQL = "SELECT * FROM usuarios";
        try {

            PreparedStatement ps = cn.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                String nombre = rs.getString(2);
                String estado = rs.getString(3);

                Usuario usuario = new Usuario(id, nombre, estado);
                lstUsuarios.add(usuario);

            }
        } catch (Exception e) {

        }
        return lstUsuarios;
    }

    @Override
    public List ListadoUsuarioDisponibles() {
        List<Usuario> lstUsuarioDisp = new ArrayList<>();
        try {
            String sql = "SELECT * FROM usuarios WHERE Estado = 'OK'";
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
    
            while (rs.next()) {
                int id = rs.getInt(1);
                String nombre = rs.getString(2);

                Usuario usuario = new Usuario(id, nombre);
                lstUsuarioDisp.add(usuario);
            }
        } catch (Exception e) {

        }
        return lstUsuarioDisp;
    }

    @Override
    public String Agregar(Usuario usuario) {
     
        String mensaje = "";
        try{
        String sql = "INSERT INTO usuarios VALUES(null, ?, ?)";
        
        PreparedStatement ps = cn.prepareStatement(sql);
        
        ps.setString(1, usuario.getNombre());
        ps.setString(2, usuario.getEstado());
        ps.executeUpdate();
        
        mensaje = "AGREGADO";
        }catch(Exception e){
            mensaje = e.toString();
        }
        return mensaje;
    }

}
