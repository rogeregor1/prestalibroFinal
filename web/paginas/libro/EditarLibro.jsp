<%-- 
    Document   : EditarLibro
    Created on : 18 may 2023, 13:21:23
    Author     : promike16
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                <h2 class="title">Edicion de Libros</h2>
                <!-- Da el directorio raíz de la aplicaión web-->
                <form action="${pageContext.request.contextPath}/ServletLibro?accion=modificar" method="post">
                    <fieldset>
                        <legend>Nuevo Libro</legend>

                        <div class="form-group" style="margin-left: 20px; width: 600px;">
                            <label for="libro_id" class="form-label mt-4">Id</label>
                            <input type="text" class="form-control" id="libro_id" name="libro_id">
                        </div>
                        <div class="form-group" style="margin-left: 20px; width: 600px;">
                            <label for="titulo" class="form-label mt-4">Título</label>
                            <input type="text" class="form-control" id="Titulo" name="titulo">
                        </div>

                        <div class="form-group" style="margin-left: 20px; width: 300px;">
                            <label for="isbn" class="form-label mt-4">ISBN</label>
                            <input type="text" class="form-control" id="isbn" name="isbn">
                        </div>

                        <div class="form-group" style="margin-left: 20px; width: 300px;">
                            <label for="category" class="form-label mt-4">Elegir Categoria</label>
                            <select name="category">
                                <jsp:useBean class="daoImpl.LibroDAOImpl" id="libroDAO"></jsp:useBean>
                                <c:forEach items="${libroDAO.rellenaListaCategorias()}" var="category" >           
                                    <option value="${category.categoria_id}">${category.categoria}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group" style="margin-left: 20px; width: 300px;">
                            <label for="estado" class="form-label mt-4">Condicion:</label><br>
                            <input type="radio" id="fname" name="estado" value="Bueno">
                            <label for="estado">BUENO</label>
                            <input type="radio" id="fname" name="estado" value="REGULAR">
                            <label for="estado">REGULAR</label>
                            <input type="radio" id="fname" name="estado" value="Mal">
                            <label for="estado">MAL</label>
                        </div>
                        <div class="form btn-group" style="margin-left: 20px;margin-top: 20px">
                            <button type="submit" class="btn btn-primary" style="margin-right: 20px">Añadir</button>
                            <a href="${pageContext.request.contextPath}/ServletLibro"
                               class="btn btn-secondary" style="marging-left:10px">Cancelar
                            </a>
                        </div>
                    </fieldset>
                </form>
            </div>
        </div>                     
    </body>
    <script src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/prism.js"></script>
    <script src="${pageContext.request.contextPath}/js/custom.js"></script>
</html>