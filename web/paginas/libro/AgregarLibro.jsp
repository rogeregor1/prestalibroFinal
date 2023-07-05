<%-- 
    Document   : AgregarLibro
    Created on : 4 jul 2023, 1:53:08
    Author     : familiahurtado
--%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<fmt:setLocale value="es_ES"/>
<%@page session="true"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="principal">
            <div class="container">
                <h2 class="title">Agregar Libro</h2>
                <form action="${pageContext.request.contextPath}/ServletLibro?accion=AgregarLibro" method="POST" class="was-validated">
                    <div class="row">
                        <div class="col-25">
                            <input type="hidden" name="accion" value="AgregarLibro">
                        </div>  
                    </div>    
                    <div class="row">
                        <div class="col-25">
                            <label for="txtTitulo">Titulo:</label>
                        </div>
                        <div class="col-75">
                            <input type="text" id="fname" name="txtTitulo" placeholder="titulo...">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-25">
                            <label for="txtIsbn">Isbn:</label>
                        </div>
                        <div class="col-75">
                            <input type="text" id="fname" name="txtIsbn" placeholder="ISBN-22-4444-333-1">
                        </div>
                    </div>   
                    <div class="row"">
                        <div class="col-25">
                            <label for="category">Ejegir Categoria</label>
                        </div>
                        <div class="col-75">
                            <select name="category">
                                <jsp:useBean class="daoImpl.LibroDAOImpl" id="libroDAO"></jsp:useBean>
                                <c:forEach items="${libroDAO.rellenaListaCategorias()}" var="category" >           
                                    <option value="${category.categoria_id}">${category.categoria}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-25">
                            <label for="txtEstado">Condicion:</label>
                        </div>
                        <div class="col-75">
                            <input type="radio" id="fname" name="txtEstado" value="Bueno">
                            <label for="txtEstado">BUENO</label>
                            <input type="radio" id="fname" name="txtEstado" value="REGULAR">
                            <label for="txtEstado">REGULAR</label>
                            <input type="radio" id="fname" name="txtEstado" value="Mal">
                            <label for="txtEstado">MAL</label><br>
                        </div>
                    </div><br>
                    <div class="row">
                        <input type="submit" value="Agregar">
                    </div>
                    <div>
                        <a href="${pageContext.request.contextPath}/ServletLibro?accion=accionDefault"
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
