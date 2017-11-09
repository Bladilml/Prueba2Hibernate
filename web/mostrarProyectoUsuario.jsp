<%-- 
    Document   : mostrarProyectoUsuario
    Created on : 08-11-2017, 16:50:38
    Author     : durib
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mostrar Proyecto Usuario</title>
    </head>
    <body>
        <form name="mostrarProyectoUsuario.do" method="POST">
            <table border="1">
                <thead>
                    <tr>
                        <th>descripcion</th>
                        <th>contenido</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>nombre</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>region</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>comuna</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>presupuesto incial</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>presupuesto gastado</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>estado</td>
                        <td></td>
                    </tr>
                </tbody>
            </table>

        </form>
    </body>
</html>
