package servlets;

import java.io.IOException;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.DaoCuentas;
import daos.DaoMovimientos;
import model.Cuenta;
import model.Movimiento;

/**
 * Servlet implementation class AltaMovimientoAction
 */
@WebServlet("/AltaMovimientoAction")
public class AltaMovimientoAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	DaoMovimientos movEjb;
	@EJB
	DaoCuentas cuentaEjb;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operacion = request.getParameter("operacion");
		double cantidad = Double.parseDouble(request.getParameter("cantidad"));
		int numCuenta = Integer.parseInt(request.getParameter("numeroCuenta"));
		Cuenta cuenta = cuentaEjb.obtenerCuenta(numCuenta);
		Movimiento movimiento = new Movimiento(0,cantidad,new Date(),operacion,cuenta);
		movEjb.altaMovimiento(movimiento);
	}
}
