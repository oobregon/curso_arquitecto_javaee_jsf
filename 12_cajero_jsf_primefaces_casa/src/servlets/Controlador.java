package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controlador
 */
@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op=request.getParameter("op");
		String url="inicio.html";
		switch(op) {
			case "aInicio":
				url = "inicio.html";
				break;
			case "aFormAltaMov":
				url = "altaMov.jsp";
				break;
			case "hacerAltaMov":
				request.getRequestDispatcher("AltaMovimientoAction").include(request, response);
				request.getRequestDispatcher("ListadoCuentasAction").include(request, response);
				url = "listaCuentasCli.jsp";
				break;
			case "hacerListaCliente":
				request.getRequestDispatcher("ListadoClienteAction").include(request, response);
                url = "listaClientes.jsp";
                break;
			case "hacerListaCuentasCli":
				request.getRequestDispatcher("ListadoCuentasAction").include(request, response);
				url = "listaCuentasCli.jsp";
				break;
			case "hacerListaMovsCuenta":
				request.getRequestDispatcher("ListarMovimientosAction").include(request, response);
				url="listaMovimientos.jsp";		
				break;
			case "hacerListaMovsCliente":
				request.getRequestDispatcher("ListadoMovsClienteAction").include(request,response);
				url="listaMovimientos.jsp";
		}
		request.getRequestDispatcher(url).forward(request,response);
	}
}
