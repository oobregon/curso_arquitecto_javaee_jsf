package servlets;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.DaoCuentas;
import model.Cuenta;

/**
 * Servlet implementation class ListadoCuentasAction
 */
@WebServlet("/ListadoCuentasAction")
public class ListadoCuentasAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	DaoCuentas cuentasEjb;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idCliente = Integer.parseInt(request.getParameter("idCliente"));
		List<Cuenta> cuentas = cuentasEjb.cuentasDeCliente(idCliente);
		request.setAttribute("cuentas",cuentas);
	}
}
