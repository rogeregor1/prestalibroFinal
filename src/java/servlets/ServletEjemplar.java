/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import daoImpl.EjemplarDAOImpl;
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
import modelo.Ejemplar;
import modelo.Libro;

/**
 *
 * @author familiahurtado
 */
public class ServletEjemplar extends HttpServlet {
    EjemplarDAOImpl ejemplarDAO =new EjemplarDAOImpl();
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
            out.println("<title>Servlet ServletEjemplar</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletEjemplar at " + request.getContextPath() + "</h1>");
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
                    response.sendRedirect(request.getContextPath() + "/paginas/ejemplar/AgregarEjemplar.jsp");
                    break;
                    case "EliminarEjemplar":
                        this.eliminar(request, response);
                        break;
                    default: {
                        try {
                            this.accionDefault(request, response);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(ServletPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                }
            } else {
                try {
                    this.accionDefault(request, response);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ServletPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        } catch (Exception ex) {
            Logger.getLogger(ServletPrincipal.class.getName()).log(Level.SEVERE, null, ex);
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
                    case "AgregarEjemplar":
                        this.insertarEjemplar(request, response);
                        break;

                    default: {
                        this.accionDefault(request, response);
                    }

                }
            } else {
                this.accionDefault(request, response);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletEjemplar.class.getName()).log(Level.SEVERE, null, ex);
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

    private void insertarEjemplar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        //recuperamos los valores del formulario agregarCliente

        try {
            int id = Integer.parseInt(request.getParameter("cboLibro"));
            Libro libro = libroDAO.buscarXid(id);
            int inventory_in_stock = Integer.parseInt(request.getParameter("txtInventory"));
            //int inventory_in_stock = 0;
            String estado = request.getParameter("txtEstado");
            //String estado = "DISPONIBLE";
           
            Ejemplar ejemplar = new Ejemplar();
            ejemplar.setLibro(libro);
            ejemplar.setInventory_in_stock(inventory_in_stock);
            ejemplar.setEstado(estado);

            String mensaje = ejemplarDAO.Agregar(ejemplar);


            if (mensaje.equals("AGREGADO")) {
                request.setAttribute("mensaje", mensaje);
            } else {
                request.setAttribute("error", mensaje);
            }
            request.getRequestDispatcher("ejemplares.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", e);
            request.getRequestDispatcher("paginas/ejemplar/AgregarEjemplar.jsp").forward(request, response);
        }
    }

    private void accionDefault(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        //consulta la db y se trae una lista con los clientes
        List<Ejemplar> ejemplares = new EjemplarDAOImpl().ListadoEjemplares();
        //muestra de control interno de lista de clientes getSecion()

        System.out.println("ejemplares = " + ejemplares);
        //recupera las variables de secion 
        HttpSession sesion = request.getSession();
        //carga la variable de secion clientes con la lista de clientes
        sesion.setAttribute("ejemplares", ejemplares);
        //carga el totoal de eclientes de una variable de session
        sesion.setAttribute("totalUsuarios", ejemplares.size());
        //request.getRequestDispatcher("usuarios.jsp").forward(request, response);
        //navega a la pagina cliente.jsp
        response.sendRedirect("ejemplares.jsp");
    }

    private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     try {
            int codigo = Integer.parseInt(request.getParameter("ejemplar_id"));

            String mens = libroDAO.ActualizarLibroDisponible(codigo);
            
            if (mens.equals("Libro Disponible")) {
                request.setAttribute("mens", mens);
            } else {
                request.setAttribute("NOmens", mens);
            }

            String mensaje = ejemplarDAO.Eliminar(codigo);

            if (mensaje.equals("ELIMINADO")) {
                request.setAttribute("mensaje", mensaje);
                libroDAO.ActualizarLibroDisponible(codigo);
            } else {
                request.setAttribute("error", mensaje);
            }
            request.getRequestDispatcher("ejemplares.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", e);
            request.getRequestDispatcher("paginas/ejemplar/ListadoEjemplares.jsp").forward(request, response);
        }
    }
}
