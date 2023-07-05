<%-- 
    Document   : AgregarEjemplar
    Created on : 1 jul 2023, 21:21:06
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
                <h2 class="title">Registro de Ejemplares</h2>
                <form action="${pageContext.request.contextPath}/ServletEjemplar?accion=AgregarEjemplar" method="POST" class="was-validated">
                    <div class="row">
                        <div class="col-25">
                            <input type="hidden" name="accion" value="AgregarEjemplar">
                        </div>  
                    </div>    
                    <div class="row">
                        <div class="col-25">
                            <label for="libro">Elegir Libro:</label>
                        </div>
                        <div class="col-75">
                            <select name="cboLibro">
                                <jsp:useBean class="daoImpl.LibroDAOImpl" id="libroDAO"></jsp:useBean>
                                <c:forEach items="${libroDAO.ListadoLibroDisponibles()}" var="libro">
                                    <option value="${libro.libro_id}">${libro.titulo}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-25">
                            <label for="txtInventory">Existencias:</label>
                        </div>
                        <div class="col-75">
                            <input type="text" id="fname" name="txtInventory" placeholder="cantidad..">
                        </div>
                    </div>    
                    <div class="row">
                        <div class="col-25">
                            <label for="txtEstado">Condicion:</label>
                        </div>
                        <div class="col-75">
                            <input type="radio" id="fname" name="txtEstado" value="DISPONIBLE">
                            <label for="txtEstado">DISPONIBLE</label>
                            <input type="radio" id="fname" name="txtEstado" value="NO DISPONIBLE">
                            <label for="txtEstado">NO DISPONIBLE</label><br>

                        </div>
                    </div> 
                    <br>
                    <div class="row">
                        <input type="submit" value="Agregar">
                    </div>
                    <div>
                        <a href="${pageContext.request.contextPath}/ServletEjemplar?accion=accionDefault"
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
