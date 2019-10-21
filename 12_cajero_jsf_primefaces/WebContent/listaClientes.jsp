<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>	
	<table border="1">
		<tr><th>Cliente</th><th>Dni</th><th>&nbsp</th></tr>		
			<c:forEach var="cli" items="${requestScope.clientes}">    	
		    	<tr>
		    		<td>${cli.nombre}</td>
		    		<td>${cli.dni}</td>
		    		<td><a href="Controlador?op=hacerListaCuentasCli&idCliente=${cli.dni}">Ver cuentas</a></td>												    		
		    		<td><a href="Controlador?op=hacerListaMovsCliente&idCliente=${cli.dni}">Ver movimientos</a></td>
				</tr>
			</c:forEach>			    	
	</table><br/>
	<a href="Controlador?op=aInicio">Inicio</a>
</body>
</html>