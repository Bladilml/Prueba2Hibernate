<%-- 
    Document   : crearUsuario
    Created on : 08-11-2017, 16:38:48
    Author     : durib
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Creaci&oacute;n de nuevo usuario</title>
    </head>
    <form action="crearUsuario.do" method="POST">
            <div class="container">
                <h2 class="text-align:left">Crear usuario nuevo</h2>
                <div class="row">
                    <div class="col-sm-4">
                        <table class="table table-striped">
                            <tbody>
                                <tr>
                                    <th>Username:</th>
                                    <td> <input type="text" name="user" value="" size="30"placeholder="ingrese Nombre Usuario" required/> </td>
                                </tr>
                                <tr>
                                    <th>Password:</th>
                                    <td> <input type="password" name="password1" value="" size="30" placeholder="ingrese contraseña" required/> </td>
                                </tr>
                                <tr>
                                    <th>Password:</th>
                                    <td> <input type="password" name="password2" value="" size="30"  placeholder="ingrese contraseña nuevamente" required/> </td>
                                </tr>
                               
                                <tr>
                                    <td colspan="2"> <input type="submit" value="Crear" /> </td> <td colspan="2"> <input type="button" value="cancelar" onclick="window.location.href='login.jsp'" /></td>
                                </tr>
                                 
                            </tbody>
                             
                        </table>
                    </div>
                </div>
                <c:if test="${not empty listaMensajes}">                      
                <div class="bg-warning">
                    <ul>
                    <c:forEach var="mensaje" items="${listaMensajes}">
                        <li>${mensaje}</li>
                    </c:forEach>
                    </ul>
                </div>
                </c:if>
            </div>
        </form>
    </body>
</html>
