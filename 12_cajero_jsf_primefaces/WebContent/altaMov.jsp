<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alta movimiento</title>
</head>
<body>
Num Cuenta:${param.numeroCuenta}
id Cliente:${param.idCliente}
	<form action="Controlador?op=hacerAltaMov" method="POST">		 		
		<input type="hidden" name="idCliente" value="${param.idCliente}" /><br/>
		<input type="hidden" name="numeroCuenta" value="${param.numeroCuenta}" /><br/>
		Operacion:<input type="text" name="operacion" /><br/>
		Cantidad:<input type="text" name="cantidad"/><br/>			
		<br/>
		<input type="submit" value="Confirmar"/>			
	</form>
	<br/>
	<a href="Controlador?op=hacerListaCuentasCli&idCliente=${param.idCliente}">Mis Cuentas</a><br/>	
</body>
</html>