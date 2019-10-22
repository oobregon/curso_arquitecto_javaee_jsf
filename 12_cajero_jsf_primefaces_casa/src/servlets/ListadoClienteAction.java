package servlets;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.DaoClientes;
import model.Cliente;

/**
 * Servlet implementation class ListadoClienteAction
 */
@WebServlet("/ListadoClienteAction")
public class ListadoClienteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	DaoClientes cliEjb;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Cliente> clientes = cliEjb.obtenerClientes();
		request.setAttribute("clientes",clientes);
	}
}
