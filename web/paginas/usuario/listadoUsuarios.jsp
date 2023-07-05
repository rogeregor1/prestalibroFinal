<%-- 
    Document   : listadoUsuarios
    Created on : 23 jun 2023, 11:51:33
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
                <h2 class="title">Listado Usuarios</h2>
                <table class="table">
                    <tr>
                        <th>Codigo</th>
                        <th>Nombre y Apellido</th>
                        <th>Estado</th>
                    </tr>
                    <jsp:useBean class="daoImpl.UsuarioDAOImpl" id= "usuarioDAO"></jsp:useBean>
                    <c:forEach items="${usuarioDAO.listadoUsuarios()}" var="usuario">
                        <tr>
                            <td>${usuario.id}</td>
                            <td>${usuario.nombre}</td>
                            <td>${usuario.estado}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/ServletUsuario?accion=eliminar&id=${usuario.id}">Eliminar</a>
                            </td>
                            <td>
                                <a href="${pageContext.request.contextPath}/ServletUsuario?accion=editar&id=${usuario.id}"
                                   class="btn btn-secondary">
                                    <i class="fas fa-angle-double-right"></i> Editar
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </table> 
            </div> 
        </div>  
    </body>

</html>
