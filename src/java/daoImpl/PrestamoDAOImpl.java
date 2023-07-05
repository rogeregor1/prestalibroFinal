/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daoImpl;

import config.Conexion;
import dao.PrestamoDAO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import modelo.Ejemplar;
import modelo.Prestamo;
import modelo.Usuario;

/**
 *
 * @author familiahurtado
 */
public class PrestamoDAOImpl implements PrestamoDAO{
    String urlConexion = "jdbc:mysql://localhost:3306/prestalibro";
    String usu = "root";
    String pas = "12345678";
    Connection cn = Conexion.getConnection(usu, pas, urlConexion);
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    EjemplarDAOImpl ejemplarDAO = new EjemplarDAOImpl();
    UsuarioDAOImpl usuarioDAO = new UsuarioDAOImpl();

    
    @Override
    public List listadoPrestamos() {
    List<Prestamo> lstPrestamos = new ArrayList();
        try {
            String sql = "SELECT * FROM prestamos";
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                int prestamo_id = rs.getInt(1);
                int ejemplar_id = rs.getInt(2);
                Ejemplar ejemplar = ejemplarDAO.buscarXid(ejemplar_id);
                int usuario_id = rs.getInt(3);
                Usuario usuario = usuarioDAO.buscarXid(usuario_id);
                
                
                Date fechaInicio = rs.getDate(4);
                Date fechaTermino = rs.getDate(5);
                String estado = rs.getString(6);
                
                
                Prestamo prestamo = new Prestamo(prestamo_id, ejemplar, usuario, fechaInicio, fechaTermino, estado);
                
                lstPrestamos.add(prestamo);

            }

        } catch (Exception e) {

        }
        return lstPrestamos;}

    @Override
    public String Agregar(Prestamo prestamo) {
     String mensaje = "";
        try {
            String sql = "{Call sp_agregarPrestamo(?, ?, ?, ?)}";
            CallableStatement cstm = cn.prepareCall(sql);
            
            cstm.registerOutParameter(1, Types.VARCHAR);
            cstm.setInt(2, prestamo.getEjemplar().getEjemplar_id());
            cstm.setInt(3, prestamo.getUsuario().getId());
            cstm.setDate(4, prestamo.getFechaTermino());
            cstm.executeUpdate();
            mensaje = cstm.getString(1);

        } catch (Exception e) {
            mensaje = e.toString();
        }
        return mensaje;
    }

    @Override
    public String Eliminar(int codigo) {
     String mensaje = "";
        try {
            String sql = "DELETE FROM prestamos WHERE prestamo_id=?";
            ps = cn.prepareStatement(sql);
            ps.setInt(1, codigo);
            ps.executeUpdate();

            mensaje = "ELIMINADO";
        } catch (Exception e) {
            mensaje = e.toString();
        }
        return mensaje;
    }

}
