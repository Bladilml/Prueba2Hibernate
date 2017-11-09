<%-- 
    Document   : login
    Created on : 08-11-2017, 16:35:21
    Author     : durib
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <div class="container">
            <div class="wrapper">
                 <form action="login.do" method="post" name="Login" class="form-signin">
                    <input type="text" class="form-control" name="Username" placeholder="Username" required="" autofocus="" /><br>
                    <input type="password" class="form-control" name="Password" placeholder="Password" required=""/><br>     		  

                    <button class="btn btn-lg btn-primary btn-block"  name="Submit" value="Login" type="Submit">Login</button>
                    ¿Nuevo Usuario?&nbsp;<a href="crearUsuario.jsp">Crear cuenta</a>
                </form>
            </div>
            <div class="bg-warning">
                <c:if test="${not empty listaMensajes}">
                    <ul>
                        <c:forEach var="mensaje" items="${listaMensajes}">
                            <li>${mensaje}</li>
                            </c:forEach>
                    </ul>
                </c:if>
            </div>        
    </body>
</html>
