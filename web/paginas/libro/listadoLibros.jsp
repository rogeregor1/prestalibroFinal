<%-- 
    Document   : ListadoLibros
    Created on : 1 jul 2023, 13:30:49
    Author     : familiahurtado
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
            <div class="contenido">
                <h2 class="title">Lista de Libros</h2>  
                <table class="table">
                    <tr >
                        <th>Código</th>
                        <th>Titulo</th>
                        <th>Isbn</th>
                        <th>Categoría</th>
                        <th>Autores</th>
                    </tr>
                    <jsp:useBean class="daoImpl.LibroDAOImpl" id="libroDAO"></jsp:useBean>
                    <c:forEach items="${libroDAO.listadoLibros()}" var="libro">
                        <!-- Iteramos cada elemento de la lista de libros -->
                        <tr>
                            <td>${libro.libro_id}</td>
                            <td>${libro.titulo}</td>
                            <td>${libro.isbn}</td>
                            <td>${libro.category.categoria}</td>
                            <td><select class="form-select" id="autores" name="autores">
                                    <!-- Cargo la lista de autores del libro-->
                                    <c:forEach var="aut" items="${libro.listaAutores}" varStatus="status" >         
                                        <option value="${aut.id}">${aut.nombre}</option>
                                    </c:forEach>
                                </select></td>
                            <td>
                                <a href="${pageContext.request.contextPath}/ServletLibro?accion=eliminar&libro_id=${libro.libro_id}">Eliminar</a>
                            </td>
                            <td>
                                <a href="${pageContext.request.contextPath}/ServletLibro?accion=editar&libro_id=${libro.libro_id}" class="btn btn-secondary"><i class="fas fa-angle-double-right"></i> Editar</a>

                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </body>
</html>