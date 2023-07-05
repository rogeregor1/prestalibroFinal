/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daoImpl;

import config.Conexion;
import config.EjecutaSQL;
import dao.LibroDAO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Autor;
import modelo.Category;
import modelo.Libro;

/**
 *
 * @author familiahurtado
 */
public class LibroDAOImpl implements LibroDAO {

    String urlConexion = "jdbc:mysql://localhost:3306/prestalibro";
    String usu = "root";
    String pas = "12345678";
    Connection cn = Conexion.getConnection(usu, pas, urlConexion);

    @Override
    public Libro buscarXid(int id) {
        Libro libro = null;
        try {
            String sql = "SELECT * FROM libros WHERE libro_id=?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int libro_id = rs.getInt(1);
                String titulo = rs.getString(2);

                libro = new Libro(libro_id, titulo);
            }

        } catch (Exception e) {

        }
        return libro;
    }

    @Override
    public List ListadoLibroDisponibles() {
        List<Libro> lstLibrosDisp = new ArrayList<>();
        //String sql = "SELECT * FROM libros WHERE Estado= 'DISPONIBLE'";
        String sql = "SELECT * FROM libros";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int libro_id = rs.getInt(1);
                String titulo = rs.getString(2);

                Libro libro = new Libro(libro_id, titulo);
                lstLibrosDisp.add(libro);
            }
        } catch (Exception e) {

        }
        return lstLibrosDisp;
    }

    @Override
    public String Agregar(Libro libro) {

        String mensaje = "";
        try {
            String sql = "INSERT INTO libros VALUES(null, ?, ?, ?)";

            PreparedStatement ps = cn.prepareStatement(sql);

            ps.setString(1, libro.getTitulo());
            ps.setString(2, libro.getIsbn());
            ps.setInt(3, libro.getCategoria_id());
            ps.executeUpdate();

            mensaje = "AGREGADO";
        } catch (Exception e) {
            mensaje = e.toString();
        }
        return mensaje;
    }

    @Override
    public int eliminar(Libro libro) {
        String SQL_DELETE = "DELETE FROM libros WHERE libro_id = ?";
        int rows = 0;
        try {
            PreparedStatement ps = cn.prepareStatement(SQL_DELETE);
            ps.setInt(1, libro.getLibro_id());
            rows = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        //elimino el objeto de la fila
        return rows;
    }

    @Override
    public List listadoLibros() {

        List<Libro> lstLibros = new ArrayList();
        String SQL = "SELECT * FROM libros";
        try {

            PreparedStatement ps = cn.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                List<Autor> listaAutores = new ArrayList();
                int libro_id = rs.getInt(1);
                String titulo = rs.getString(2);
                String isbn = rs.getString(3);
                int categoria_id = rs.getInt(4);
                Category category = buscarCatXid(categoria_id);

                String sql = "select a.autor_id,a.nombre"
                        + " from libros l, autores a, escrito_por e"
                        + " where a.autor_id=e.autor_id and"
                        + " l.libro_id=e.libro_id and"
                        + " l.libro_id=" + libro_id;
                //  + " order by 3,2";
                System.out.println(sql);
                //Leo de la base de datos la lista de autores para este libro
                ResultSet au = EjecutaSQL.devuelveRS(sql, usu, pas, urlConexion);
                System.out.println("");
                // Recorro el ResultSet de autores de este libro y os meto en la lista de autores
                while (au.next()) {
                    //Meto el autor en la lista
                    Autor autor = new Autor(au.getInt("autor_id"), au.getString("nombre"));
                    listaAutores.add(autor);
                }

                Libro libro = new Libro(libro_id, titulo, isbn, category, listaAutores);
                lstLibros.add(libro);
            }
        } catch (Exception e) {

        }
        return lstLibros;
    }

    public Category buscarCatXid(int id) {
        Category category = null;
        try {
            String sql = "SELECT * FROM categorias WHERE categoria_id=?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int categoria_id = rs.getInt(1);
                String categoria = rs.getString(2);

                category = new Category(categoria_id, categoria);
            }

        } catch (Exception e) {

        }
        // devuelvo el objeto elegido de la DB categorias
        return category;
    }

    public List rellenaListaCategorias() throws SQLException {
        List<Category> categorias = new ArrayList();
        String sql = "SELECT * FROM categorias";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            // recorro el resulset con todos los libros y los meto en la lista
            while (rs.next()) {
                // leo un registro del resultSet y lo guardo en variables
                int categoria_id = rs.getInt("categoria_id");
                String categoria = rs.getString("categoria");
                Category category = new Category(categoria_id, categoria);
                categorias.add(category);
            }
        } catch (Exception e) {

        }
        //devuelvo la lista de categorias
        return categorias;
    }

    @Override
    public String ActualizarLibroDisponible(int codigoEjemplar) {

        String mensaje = "";
        try {
            String sql = "{Call sp_LibroAdisponible(?)}";
            CallableStatement cstm = cn.prepareCall(sql);
            cstm.setInt(1, codigoEjemplar);
            cstm.executeUpdate();
            mensaje = "Libro Disponible";
        } catch (Exception e) {

        }
        return mensaje;
    }

    @Override
    public Libro encontrarLibro(int id){
        
        Libro libro = null;
        try {
            String sql = "SELECT * FROM libros WHERE libro_id=?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int libro_id = rs.getInt(1);
                String titulo = rs.getString(2);
                String isbn = rs.getString(3);
                int cat = rs.getInt(4);
                Category category = buscarCatXid(cat);
                String estado = rs.getString(5);

                libro = new Libro(libro_id, titulo, isbn, category, estado);
            }

        } catch (Exception e) {

        }
        return libro;
    }

    public int actualizar(Libro libro) throws ClassNotFoundException {
        String sql = "UPDATE libros SET titulo=?, isbn=?, categoria_id=?, estado=? WHERE libro_id=?";

        int rows = 0;
        try {
            PreparedStatement ps = cn.prepareStatement(sql);

            ps.setString(1, libro.getTitulo());
            ps.setString(2, libro.getIsbn());
            ps.setInt(3, libro.getCategoria_id());
            ps.setString(4, libro.getEstado());
            ps.setInt(5, libro.getLibro_id());

            rows = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        
        return rows;
    }
}
