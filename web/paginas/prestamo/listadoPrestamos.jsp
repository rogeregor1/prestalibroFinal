<%-- 
    Document   : ListadoPrestamos
    Created on : 1 jul 2023, 13:30:49
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
        <div class="principal">
            <div class="container">
                <h2 class="title">Tabla Prestamos</h2>
                <table class="table">
                    <tr>
                        <th>#</th>
                        <th>Ejemplar</th>
                        <th>Usuario</th>
                        <th>Fecha_Inicio</th>
                        <th>Fecha_termino</th>
                        <th>estado</th>
                    </tr>
                    <jsp:useBean class="daoImpl.PrestamoDAOImpl" id="prestamoDAO"></jsp:useBean>
                    <c:forEach items="${prestamoDAO.listadoPrestamos()}" var="prestamo">
                        <tr>
                            <td>${prestamo.prestamo_id}</td>
                            <td>${prestamo.ejemplar.libro.titulo}</td>
                            <td>${prestamo.usuario.nombre}</td>
                            <td><fmt:formatDate pattern="yyyy-MM-dd" value="${prestamo.fechaInicio}"></fmt:formatDate></td>
                            <td><fmt:formatDate pattern="yyyy-MM-dd" value="${prestamo.fechaTermino}"></fmt:formatDate></td>
                            <td>${prestamo.estado}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/ServletPrestamo?accion=EliminarPrestamo&prestamo_id=${prestamo.prestamo_id}">Devolucion</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>

            </div>
        </div>
    </body>

</html>
