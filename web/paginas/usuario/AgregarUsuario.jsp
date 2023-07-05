<%-- 
    Document   : agregarusuario
    Created on : 23 jun 2023, 12:20:43
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
                <h2 class="title">Registro de Usuarios</h2>
                <form action="${pageContext.request.contextPath}/ServletUsuario?accion=AgregarUsuario" method="POST" class="was-validated">
                    <div class="row">
                        <div class="col-25">
                            <input type="hidden" name="accion" value="AgregarUsuario">
                        </div>  
                    </div>    
                    <div class="row">
                        <div class="col-25">
                            <label for="txtNombre">Nombre y Apellido:</label>
                        </div>
                        <div class="col-75">
                            <input type="text" id="fname" name="txtNombre" placeholder="Nombre y Apellido..">
                        </div>
                    </div>    
                    <div class="row">
                        <div class="col-25">
                            <label for="txtEstado">Condicion:</label>
                        </div>
                        <div class="col-75">
                            <input type="radio" id="fname" name="txtEstado" value="OK">
                            <label for="txtEstado">OK</label>
                            <input type="radio" id="fname" name="txtEstado" value="DEUDOR">
                            <label for="txtEstado">DEUDOR</label><br>
                        </div>
                    </div> 
                    <br>
                    <div class="row">
                        <input type="submit" value="Agregar">
                    </div>
                    <div>
                        <a href="${pageContext.request.contextPath}/ServletUsuario?accion=accionDefault"
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
