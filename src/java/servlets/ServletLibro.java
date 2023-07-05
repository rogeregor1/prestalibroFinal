/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import daoImpl.LibroDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Libro;

/**
 *
 * @author familiahurtado
 */
public class ServletLibro extends HttpServlet {

    LibroDAOImpl libroDAO = new LibroDAOImpl();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletLibro</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletLibro at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {

            switch (accion) {
                case "insertar":
                    response.sendRedirect(request.getContextPath() + "/paginas/libro/AgregarLibro.jsp");
                    break;
                case "editar": {
                    try {
                        this.editarLibro(request, response);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(ServletLibro.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
                case "eliminar":
                    this.eliminarLibro(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }

    private void editarLibro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        
            int id = Integer.parseInt(request.getParameter("libro_id"));
            Libro libro = new LibroDAOImpl().encontrarLibro(id);
            request.setAttribute("libro", libro);
            String jspEditar = "paginas/libro/EditarLibro.jsp";
            request.getRequestDispatcher(jspEditar).forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "AgregarLibro":
                    this.insertarLibro(request, response);
                    break;
                case "modificar": {
                    try {
                        this.modificarLibro(request, response);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(ServletLibro.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;

                default: {
                    this.accionDefault(request, response);
                }

            }
        } else {
            this.accionDefault(request, response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void insertarLibro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Libro libro = null;
        try {
            String titulo = request.getParameter("txtTitulo");
            String isbn = request.getParameter("txtIsbn");
            String cat = request.getParameter("category");
            String sql = "select categoria_id from categorias where categoria='" + cat + "'";
            int categoria_id = Integer.parseInt(request.getParameter(sql));
            System.out.println(categoria_id);
            String estado = request.getParameter("txtEstado");
            
            libro.setTitulo(titulo);
            libro.setIsbn(isbn);
            libro.setCategoria_id(categoria_id);
            libro.setEstado(estado);
            
            String mensaje = libroDAO.Agregar(libro);

            if (mensaje.equals("AGREGADO")) {
                request.setAttribute("mensaje", mensaje);
            } else {
                request.setAttribute("error", mensaje);
            }
            request.getRequestDispatcher("libros.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", e);
            request.getRequestDispatcher("paginas/libro/AgregarLibro.jsp").forward(request, response);
        }
    }

    private void modificarLibro(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, IOException {
        //recuperamos los valores del formulario editarCliente
        int libro_id = Integer.parseInt(request.getParameter("libro_id"));
        String titulo = request.getParameter("titulo");
        String isbn = request.getParameter("isbn");
        String cat = request.getParameter("categoria");
        String sql = "select categoria_id from categorias where categoria='" + cat + "'";
        int categoria_id = Integer.parseInt(request.getParameter(sql));
        System.out.println(categoria_id);

        String estado = request.getParameter("estado");

        //Creamos el objeto de cliente (modelo)
        Libro libro = new Libro(libro_id, titulo, isbn, categoria_id, estado);

        //Modificar el  objeto en la base de datos
        int registrosModificados = new LibroDAOImpl().actualizar(libro);
        System.out.println("registrosModificados = " + registrosModificados);

        //Redirigimos hacia accion por default
        this.accionDefault(request, response);
    }

    private void accionDefault(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //consulta la db y se trae una lista con los clientes
        List<Libro> libros = new LibroDAOImpl().listadoLibros();
        //muestra de control interno de lista de clientes getSecion()

        System.out.println("libros = " + libros);
        //recupera las variables de secion 
        HttpSession sesion = request.getSession();
        //carga la variable de secion clientes con la lista de clientes
        sesion.setAttribute("libros", libros);
        //carga el totoal de eclientes de una variable de session
        sesion.setAttribute("totalLibros", libros.size());
        //request.getRequestDispatcher("clientes.jsp").forward(request, response);
        //navega a la pagina cliente.jsp
        response.sendRedirect("libros.jsp");

    }

    private void eliminarLibro(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int libro_id = Integer.parseInt(request.getParameter("libro_id"));

        //Creamos el objeto de cliente (modelo)
        Libro libro = new Libro(libro_id);

        //Eliminamos el  objeto en la base de datos
        int registrosModificados = new LibroDAOImpl().eliminar(libro);
        System.out.println("registrosModificados = " + registrosModificados);

        //Redirigimos hacia accion por default
        this.accionDefault(request, response);
    }

}
