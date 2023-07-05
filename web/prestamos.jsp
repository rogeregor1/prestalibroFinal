<%-- 
    Document   : prestamos
    Created on : 1 jul 2023, 13:15:47
    Author     : familiahurtado
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<fmt:setLocale value="es_ES"/>
<%@page session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--Cabecero-->
        <jsp:include page="/comunes/cabecera.jsp"/>
        <!--Menú-->
        <div class="menu">
                <jsp:include page="/comunes/menu.jsp"></jsp:include>
        </div>
    </head>
    <body>
        
        <!--Listado Usuarios -->
        <jsp:include page="/paginas/prestamo/listadoPrestamos.jsp"/>
        <!--Pie de Pagina-->
        <jsp:include page="/comunes/pie.jsp"/>

    </body>

</html>
