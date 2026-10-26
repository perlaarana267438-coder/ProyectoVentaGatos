<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Tienda de Gatos</title>
    <link rel="stylesheet" type="text/css" href="estilos.css">
</head>
<body>

    <h1 class="titulo1">Venta de Gatos</h1>

    <div class="contenedor">
        <!--FORMULARIO-->
        <div class="columna">
            <h2>Registrar Gato</h2>
            <form action="ControladorGatos" method="POST">
                <label>Raza del gato:</label>
                <input type="text" name="raza" required>
                
                <label>Nombre:</label>
                <input type="text" name="nombre" required>
                
                <label>Precio:</label>
                <input type="number" name="precio" required>
                
                <button type="submit">Guardar nene</button>
            </form>
        </div>

        <!--TABLE-->
        <div class="columna">
            <h2>Gatos Disponibles en la Tienda</h2>
            <table>
                <tr>
                    <th>ID</th>
                    <th>Raza</th>
                    <th>Nombre</th>
                    <th>Precio</th>
                </tr>
                <c:forEach var="gato" items="${listaGatos}">
                    <tr>
                        <td>${gato.id}</td>
                        <td>${gato.raza}</td>
                        <td>${gato.nombre}</td>
                        <td>$${gato.precio}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>

</body>
</html>