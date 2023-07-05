/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import daoImpl.EjemplarDAOImpl;
import daoImpl.PrestamoDAOImpl;
import daoImpl.UsuarioDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Ejemplar;
import modelo.Prestamo;
import modelo.Usuario;
import util.GeneraFecha;

/**
 *
 * @author familiahurtado
 */
public class ServletPrestamo extends HttpServlet {
PrestamoDAOImpl prestamoDAO = new PrestamoDAOImpl();    
EjemplarDAOImpl ejemplarDAO = new EjemplarDAOImpl();
UsuarioDAOImpl usuarioDAO = new UsuarioDAOImpl();
GeneraFecha genera = new GeneraFecha();
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
        
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletPrestamo</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletPrestamo at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
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
                    response.sendRedirect(request.getContextPath() + "/paginas/prestamo/AgregarPrestamo.jsp");
                    break;
                    case "EliminarPrestamo":
                        this.eliminar(request, response);
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

     private void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
        try {
            int codigo = Integer.parseInt(request.getParameter("prestamo_id"));

            String mens = ejemplarDAO.ActualizarEjemplarDisponible(codigo);
            
            if (mens.equals("Ejemplar Disponible")) {
                request.setAttribute("mens", mens);
            } else {
                request.setAttribute("NOmens", mens);
            }

            String mensaje = prestamoDAO.Eliminar(codigo);

            if (mensaje.equals("ELIMINADO")) {
                request.setAttribute("mensaje", mensaje);
                ejemplarDAO.ActualizarEjemplarDisponible(codigo);
            } else {
                request.setAttribute("error", mensaje);
            }
            request.getRequestDispatcher("prestamos.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", e);
            request.getRequestDispatcher("paginas/prestamo/listadoPrestamos.jsp").forward(request, response);
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
                    case "AgregarPrestamo":
                        this.insertarPrestamo(request, response);
                        break;
                    default: {
                        this.accionDefault(request, response);
                    }
                }
            } else {
                this.accionDefault(request, response);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletPrestamo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

      private void accionDefault(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {

        //consulta la db y se trae una lista con los clientes
        List<Prestamo> prestamos = new PrestamoDAOImpl().listadoPrestamos();
        //muestra de control interno de lista de clientes getSecion()
        System.out.println("prestamos = " + prestamos);
        //recupera las variables de secion 
        HttpSession sesion = request.getSession();
        //carga la variable de secion clientes con la lista de clientes
        sesion.setAttribute("prestamos", prestamos);
        //carga el totoal de eclientes de una variable de session
        sesion.setAttribute("totalPrestamos", prestamos.size());

        //request.getRequestDispatcher("clientes.jsp").forward(request, response);
        //navega a la pagina cliente.jsp
        response.sendRedirect("prestamos.jsp");
    }

    private void insertarPrestamo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          try {
            int Eid = Integer.parseInt(request.getParameter("cboEjemplar"));
            Ejemplar ejemplar = ejemplarDAO.buscarXid(Eid);
            
            int Uid = Integer.parseInt(request.getParameter("cboUsuario"));
            Usuario usuario = usuarioDAO.buscarXid(Uid);
            
            Date fechaSQL = genera.parsearFecha(request.getParameter("dtFechaInicio"));

            Prestamo prestamo = new Prestamo();
            prestamo.setEjemplar(ejemplar);
            prestamo.setUsuario(usuario);
            prestamo.setFechaTermino(fechaSQL);

            String mensaje = prestamoDAO.Agregar(prestamo);

            if (mensaje.equals("EXITO")) {
                request.setAttribute("mensaje", mensaje);
            } else {
                request.setAttribute("error", mensaje);
            }
            request.getRequestDispatcher("prestamos.jsp").forward(request, response);

        } catch (Exception e) {
            request.setAttribute("error", e);
            request.getRequestDispatcher("paginas/prestamo/AgregarPrestamo.jsp").forward(request, response);
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

  
}
