<%-- 
    Document   : ListadoEjemplares
    Created on : 1 jul 2023, 22:57:37
    Author     : familiahurtado
--%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
        <div class ="principal">
            <div class="container">
                <h2 class="title">Listado Ejemplares</h2>
                <table class="table">
                    <tr>
                        <th>Codigo</th>
                        <th>Libro Titulo</th>
                        <th>Existencias</th>
                        <th>Estado</th>
                    </tr>
                    <jsp:useBean class="daoImpl.EjemplarDAOImpl" id= "ejemplarDAO"></jsp:useBean>
                    <c:forEach items="${ejemplarDAO.ListadoEjemplares()}" var="ejemplar">
                        <tr>
                            <td>${ejemplar.ejemplar_id}</td>
                            <td>${ejemplar.libro.titulo}</td>
                            <td>${ejemplar.inventory_in_stock}</td>
                            <td>${ejemplar.estado}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/ServletEjemplar?accion=EliminarEjemplar&ejemplar_id=${ejemplar.ejemplar_id}">Eliminar</a>
                            </td>
                            <td>
                                <a href="${pageContext.request.contextPath}/ServletEjemplar?accion=EditarEjemplar&ejemplar_id=${ejemplar.ejemplar_id}"
                                   class="btn btn-secondary">
                                    <i class="fas fa-angle-double-right"></i>Editar
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </table> 
            </div> 
        </div>  
    </body>

</html>