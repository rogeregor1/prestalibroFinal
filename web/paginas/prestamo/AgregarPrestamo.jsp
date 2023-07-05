<%-- 
    Document   : AgregarPrestamo
    Created on : 23 jun 2023, 20:50:02
    Author     : familiahurtado
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<fmt:setLocale value="es_ES"/>
<%@page session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

    </head>
    <body>
        <div class="principal">
            <div class="container">
                <h2 class="title">Registro de Prestamos</h2>
                <form action="${pageContext.request.contextPath}/ServletPrestamo?accion=AgregarPrestamo" method="POST" class="was-validated">
                    <div class="row">
                        <div class="col-25">
                            <input type="hidden" name="accion" value="AgregarPrestamo">
                        </div>  
                    </div>    
                    <div class="row">
                        <div class="col-25">
                            <label for="ejemplar">Elegir Ejemplar:</label>
                        </div>
                        <div class="col-75">
                            <select name="cboEjemplar">
                                <jsp:useBean class="daoImpl.EjemplarDAOImpl" id="ejemplarDAO"></jsp:useBean>
                                <c:forEach items="${ejemplarDAO.ListadoEjemplarDisponibles()}" var="ejemplar">
                                    <option value="${ejemplar.ejemplar_id}">${ejemplar.libro.titulo}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-25">
                            <label for="usuario">Elegir Usuario:</label>
                        </div>
                        <div class="col-75">
                            <select name="cboUsuario">
                                <jsp:useBean class="daoImpl.UsuarioDAOImpl" id="usuarioDAO"></jsp:useBean>
                                <c:forEach items="${usuarioDAO.ListadoUsuarioDisponibles()}" var="usuario">
                                    <option value="${usuario.id}">${usuario.nombre}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div> 
                    <div class="row">
                        <div class="col-25">
                            <label for="dtfechaInicio">Fecha de Inicio:</label>
                        </div>
                        <div class="col-75">
                            <input type="date" id="dtFechaInicio" name="dtFechaInicio">
                        </div>
                    </div>
                    <br>
                    <div class="row">
                        <input type="submit" value="Agregar">
                    </div>
                    <div>
                        <a href="${pageContext.request.contextPath}/ServletPrestamo?accion=accionDefault"
                           class="btn btn-secondary">
                            <i class="fas fa-angle-double-right"></i> Atras
                        </a>
                    </div>
                    ${mensaje}
                    ${error}
                </form>
            </div>
        </div>
    </body>

</html>
