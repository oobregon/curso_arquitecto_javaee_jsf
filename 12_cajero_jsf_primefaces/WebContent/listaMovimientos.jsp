<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Movimientos en cuenta</title>
</head>
<body>
<label>Número de cuenta: ${param.numeroCuenta}</label>
<label>Cliente: ${param.idCliente}</label>
	<table border="1">
		<tr><th>Número de cuenta</th><th>Operación</th><th>Cantidad</th><th>Fecha</th><th>&nbsp</th></tr>		
			<c:forEach var="movimiento" items="${requestScope.movimientos}">    	
		    	<tr>
		    		<td>${movimiento.cuenta.numeroCuenta}</td>
		    		<td>${movimiento.operacion}</td>
		    		<td>${movimiento.cantidad}</td>
		    		<td>${movimiento.fecha}</td>			    			    						
				</tr>
			</c:forEach>			    	
	</table>
	<a href="Controlador?op=hacerListaCuentasCli&idCliente=${param.idCliente}">Mis Cuentas</a><br/>
	<a href="Controlador?op=hacerListaCliente">Clientes</a>
</body>
</html>