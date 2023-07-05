/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daoImpl;

import config.Conexion;
import dao.EjemplarDAO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import modelo.Ejemplar;
import modelo.Libro;

/**
 *
 * @author familiahurtado
 */
public class EjemplarDAOImpl implements EjemplarDAO {

    String urlConexion = "jdbc:mysql://localhost:3306/prestalibro";
    String usu = "root";
    String pas = "12345678";
    Connection cn = Conexion.getConnection(usu, pas, urlConexion);
    PreparedStatement ps = null;
    ResultSet rs = null;
    LibroDAOImpl libroDAO = new LibroDAOImpl();

    @Override
    public Ejemplar buscarXid(int Eid) {
        Ejemplar ejemplar = null;
        try {
            String sql = "SELECT * FROM ejemplares WHERE ejemplar_id=?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, Eid);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int ejemplar_id = rs.getInt(1);
                int libro_id = rs.getInt(2);
                Libro libro = libroDAO.buscarXid(libro_id);

                ejemplar = new Ejemplar(ejemplar_id, libro);
            }

        } catch (Exception e) {

        }
        return ejemplar;
    }

    @Override
    public List ListadoEjemplarDisponibles() {

        List<Ejemplar> lstEjemplarDisp = new ArrayList();
        try {
            String sql = "SELECT * FROM ejemplares WHERE Estado = 'DISPONIBLE'";
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int ejemplar_id = rs.getInt(1);
                int libro_id = rs.getInt(2);
                Libro libro = libroDAO.buscarXid(libro_id);

                Ejemplar ejemplar = new Ejemplar(ejemplar_id, libro);
                lstEjemplarDisp.add(ejemplar);
            }
        } catch (Exception e) {

        }
        return lstEjemplarDisp;
    }

    @Override
    public String Agregar(Ejemplar ejemplar) {
        String mensaje = "";
        try {
            String sql = "{Call sp_agregarEjemplar(?, ?, ?, ?)}";
            CallableStatement cstm = cn.prepareCall(sql);

            cstm.registerOutParameter(1, Types.VARCHAR);
            cstm.setInt(2, ejemplar.getLibro().getLibro_id());
            cstm.setInt(3, ejemplar.getInventory_in_stock());
            cstm.setString(4, ejemplar.getEstado());
            mensaje = cstm.getString(1);

        } catch (Exception e) {
            mensaje = e.toString();
        }
        return mensaje;
    }

    @Override
    public List ListadoEjemplares() {

        List<Ejemplar> lstEjemplares = new ArrayList<>();
        String SQL = "SELECT * FROM ejemplares";
        try {
            PreparedStatement ps = cn.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int ejemplar_id = rs.getInt(1);
                int libro_id = rs.getInt(2);
                Libro libro = libroDAO.buscarXid(libro_id);
                int inventory_in_stock = rs.getInt(3);
                String estado = rs.getString(4);

                Ejemplar ejemplar = new Ejemplar(ejemplar_id, libro, inventory_in_stock, estado);
                lstEjemplares.add(ejemplar);
            }
        } catch (Exception e) {

        }
        return lstEjemplares;
    }

    @Override
    public String ActualizarEjemplarDisponible(int codigoPrestamo) {

        String mensaje = "";
        try {
            String sql = "{Call sp_EjemplarAdisponible(?)}";
            CallableStatement cstm = cn.prepareCall(sql);
            cstm.setInt(1, codigoPrestamo);
            cstm.executeUpdate();
            mensaje = "Ejemplar Disponible";
        } catch (Exception e) {

        }
        return mensaje;
    }

    @Override
    public String Eliminar(int codigo) {
   
     String mensaje = "";
        try {
            String sql = "DELETE FROM ejemplares WHERE ejemplar_id=?";
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
