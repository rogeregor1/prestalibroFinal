/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import daoImpl.UsuarioDAOImpl;
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
import modelo.Usuario;

/**
 *
 * @author familiahurtado
 */
public class ServletUsuario extends HttpServlet {

    UsuarioDAOImpl usuarioDAO = new UsuarioDAOImpl();

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
            out.println("<title>Servlet ServletUsuario</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletUsuario at " + request.getContextPath() + "</h1>");
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
        try {
            if (accion != null) {

                switch (accion) {
                    case "insertar":
                    response.sendRedirect(request.getContextPath() + "/paginas/usuario/AgregarUsuario.jsp");
                    break;
                    case "editar": {

                    //    this.editarUsuario(request, response);
                    }
                    break;

                    case "eliminar":
                    //    this.eliminarUsuario(request, response);
                        break;

                    default:
                        this.accionDefault(request, response);
                }
            } else {
                this.accionDefault(request, response);
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Editar: " + ex.toString());
        }
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
        try {
            if (accion != null) {
                switch (accion) {
                    case "AgregarUsuario":
                    this.insertarUsuario(request, response);
                    break;
                    default: {
                        this.accionDefault(request, response);
                    }

                }
            } else {
                this.accionDefault(request, response);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletUsuario.class.getName()).log(Level.SEVERE, null, ex);
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

    private void insertarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        //recuperamos los valores del formulario agregarCliente

        try {
            String nombre = request.getParameter("txtNombre");
            String estado = request.getParameter("txtEstado");
            Usuario usuario = new Usuario();

            usuario.setNombre(nombre);
            usuario.setEstado(estado);

            String mensaje = usuarioDAO.Agregar(usuario);

            if (mensaje.equals("AGREGADO")) {
                request.setAttribute("mensaje", mensaje);
            } else {
                request.setAttribute("error", mensaje);
            }
            request.getRequestDispatcher("usuarios.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", e);
            request.getRequestDispatcher("paginas/usuario/AgregarUsuario.jsp").forward(request, response);
        }
    }

    private void accionDefault(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        //consulta la db y se trae una lista con los clientes
        List<Usuario> usuarios = new UsuarioDAOImpl().listadoUsuarios();
        //muestra de control interno de lista de clientes getSecion()

        System.out.println("usuarios = " + usuarios);
        //recupera las variables de secion 
        HttpSession sesion = request.getSession();
        //carga la variable de secion clientes con la lista de clientes
        sesion.setAttribute("usuarios", usuarios);
        //carga el totoal de eclientes de una variable de session
        sesion.setAttribute("totalUsuarios", usuarios.size());
        //request.getRequestDispatcher("usuarios.jsp").forward(request, response);
        //navega a la pagina cliente.jsp
        response.sendRedirect("usuarios.jsp");
    }
}
