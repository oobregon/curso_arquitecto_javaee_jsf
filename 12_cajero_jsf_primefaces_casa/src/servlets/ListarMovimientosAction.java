package servlets;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.DaoMovimientos;
import model.Movimiento;

/**
 * Servlet implementation class ListarMovimientosAction
 */
@WebServlet("/ListarMovimientosAction")
public class ListarMovimientosAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	DaoMovimientos movEjb;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int numCuenta = Integer.parseInt(request.getParameter("numeroCuenta"));
		List<Movimiento> movimientos = movEjb.movimientosCuenta(numCuenta);
		request.setAttribute("movimientos",movimientos);
	}
}
