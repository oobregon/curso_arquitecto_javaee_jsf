<%-- 
    Document   : movimientos
    Created on : 19-may-2017, 13:41:25
    Author     : Profesormanana
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <h1>Cuenta: ${sessionScope.codigocuenta}</h1>
        <h1>Saldo: ${requestScope.saldo}</h1>
        <c:set var="movimientos" value="${requestScope.movimientos}"/>
        <br/>
        <table border="1">
            <tr><th>Cantidad</th><th>Fecha</th><th>Tipo</th></tr>
            <c:forEach var="m" items="${movimientos}">
                <tr>
                    <td>${m.cantidad}</td>
                    <td><f:formatDate value="${m.fecha}" type="BOTH" dateStyle="medium"  timeStyle="medium"/></td>
                    <td>${m.operacion}</td>
                    
                </tr>
            </c:forEach>
        </table>
        <br/>
        <a href="Controller?op=toMenu">Volver</a>
    </body>
</html>
