<%-- 
    Document   : crearProyecto
    Created on : 08-11-2017, 16:42:42
    Author     : durib
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear Proyecto</title>
        <script src="js/jquery-3.2.1.min.js" type="text/javascript"></script>
        <script>
            function buscarProvincia(str) {
                var xhttp;
                //if (str==""){
                //    document.getElementById()
                //}
                xhttp = new XMLHttpRequest();
                xhttp.open("GET", "getProvinciaServlet.do?q=" + str, true);
                xhttp.onreadystatechange = function () {
                    if (this.readyState == 4 && this.status == 200) {
                        document.getElementById("provincia").innerHTML = this.responseText;
                    }
                };
                xhttp.send();
            }

            function buscarComuna(str) {
                var xhttp;
                //if (str==""){
                //    document.getElementById()
                //}
                xhttp = new XMLHttpRequest();
                xhttp.open("GET", "getComunaServlet.do?q=" + str, true);
                xhttp.onreadystatechange = function () {
                    if (this.readyState == 4 && this.status == 200) {
                        document.getElementById("comuna").innerHTML = this.responseText;
                    }
                };
                xhttp.send();
            }
        </script>
    </head>
    <body>
        <form name="crearProyecto.do" method="POST">
            <table border="1">
                <thead>
                    <tr>
                        <th>descripcion</th>
                        <th>contenido</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Nombre</td>
                        <td><input type="text" name="nombretxt" value="" size="30" placeholder="ingrese Nombre Proyecto" required /> </td>
                    </tr>
                    <tr>
                        <td>Descripcion</td>
                        <td><input type="text" name="descripciontxt" value="" size="180" placeholder="ingrese descripcion" required/></td>
                    </tr>
                    <tr>
                        <td>Region</td>
                        <td>
                            <select name="region" id="region" onchange="buscarProvincia(this.value);">
                                <option value="" selected>Seleccione</option>
                                <c:forEach var="region" items="${listaRegiones}">
                                    <option value="${region.regionId}">${region.regionNombre} (${region.regionOrdinal})</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Provincia</td>
                        <td>
                            <select name="provincia" id="provincia" onchange="buscarComuna(this.value);">
                                <option value="" selected>Seleccione</option>
                                <c:forEach var="provincia" items="${listaProvincias}">
                                    <option value="${provincia.provinciaId}">${provincia.provinciaNombre}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Comuna</td>
                        <td>
                            <select name="comuna" id="comuna">
                                <option value="" selected>Seleccione</option>
                                <c:forEach var="comuna" items="${listaComunas}">
                                    <option value="${comuna.comunaId}">${comuna.comunaNombre}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Fecha de inicio</td>
                        <td><input type="datetime"/></td>
                    </tr>
                    <tr>
                        <td>Estado</td>
                        <td>
                            <select name="Estado">
                                <option value="Aprobado" selected="">Aprobado</option>
                                <option value="Encurso">Encurso</option>
                                <option value="Finalizado">Finalizado</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Presupuesto inicial</td>
                        <td><input type="text" name="presupuestoinicialtxt" value="" size="180" placeholder="ingrese Presupuesto" required/></td>
                    </tr>
                    <tr>
                        <td>Presupuesto gastado</td>
                        <td><input type="text" name="presupuestogastadotxt" value="" size="180" placeholder="ingrese presupuesto gastado" required /></td>
                    </tr>
                </tbody>
            </table>
        </form>
        <input type="submit" value="Registrar">&nbsp;&nbsp;
        <input type="submit" value="Salir"><br/>
    </body>
</html>
