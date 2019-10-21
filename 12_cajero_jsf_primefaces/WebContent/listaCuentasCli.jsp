<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mis cuentas</title>
</head>
<body>	
cliente: ${param.idCliente}
	<table border="1">
		<tr><th>Número de cuenta</th><th>Saldo</th><th>tipo</th><th>&nbsp</th></tr>		
			<c:forEach var="cuenta" items="${requestScope.cuentas}">    	
		    	<tr>
		    		<td>${cuenta.numeroCuenta}</td>
		    		<td>${cuenta.saldo}</td>
		    		<td>${cuenta.tipocuenta}</td>	
		    		<td><a href="Controlador?op=hacerListaMovsCuenta&numeroCuenta=${cuenta.numeroCuenta}&idCliente=${param.idCliente}">Ver movimientos</a></td>
		    		<td><a href="Controlador?op=aFormAltaMov&numeroCuenta=${cuenta.numeroCuenta}&idCliente=${param.idCliente}">Operar</a></td>		    			    						
				</tr>
			</c:forEach>			    	
	</table>	
	<a href="Controlador?op=hacerListaCliente">Clientes</a>
</body>
</html>