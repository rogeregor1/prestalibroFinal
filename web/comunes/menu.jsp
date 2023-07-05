
<!--  menu -->

    <nav class="navbar navbar-expand-lg navbar-dark bg-opacity-50">
        <div class="container-fluid">
            <link href="../css/cssDigi.css" rel="stylesheet" type="text/css"/>
            <a class="navbar-brand" href="${pageContext.request.contextPath}/ServletPrincipal?accion=accionDefault">Biblioteca</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarColor19"
                    aria-controls="navbarColor19" aria-expanded="true" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarColor19">
                <ul class="navbar-nav me-auto">

                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button" aria-haspopup="true"
                           aria-expanded="false">Libros</a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/ServletLibro?accion=listar">Listado Libros</a> 
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/ServletLibro?accion=insertar">Agregar Libro</a>
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/ServletLibro?accion=buscalibro&libro_id">Eliminar</a>
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/ServletLibro?accion=editar&libro_id" method="post">Actualizar</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/servletLibro?accion=buscalibro">Buscar</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button" aria-haspopup="true"
                           aria-expanded="false">Ejemplares</a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/ServletEjemplar?accion=listar">Listar Ejemplar</a>
                            <div class="dropdown-divider"></div> 
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/ServletEjemplar?accion=insertar">Agregar Stock</a>
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/ServletEjemplar?accion=modificar&ejemplar_id" method="post">Editar</a>
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/ServletEjemplar?accion=eliminar&ejemplar_id">Eliminar</a>

                        </div>    
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button" aria-haspopup="true"
                           aria-expanded="false">Usuarios</a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/ServletUsuario?accion=listar">Listado Usuario</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/ServletUsuario?accion=insertar">Agregar Usuario</a>
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/ServletUsuario?accion=modificar&id" method="post">Editar</a>
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/ServletUsuario?accion=eliminar&id">Eliminar</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button" aria-haspopup="true"
                           aria-expanded="false">Prestamos</a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/ServletPrestamo?accion=listar">Listar Prestamo</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/ServletPrestamo?accion=insertar">Agregar Prestamo</a>
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/ServletPrestamos?accion=eliminar">Devolucion</a>
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/ServletPrestamo?accion=editar" method="post">Modificar</a>
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/ServletPrestamo?accion=buscar">Buscar</a>
                        </div>
                    </li>
                    
                </ul>
                </ul>

            </div>
        </div>
    </nav>
