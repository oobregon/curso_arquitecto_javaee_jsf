package controlador;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ServiceCajero;

/**
 * Servlet implementation class TransferenciaAction
 */
@WebServlet("/TransferenciaAction")
public class TransferenciaAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
    ServiceCajero gcajero;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double cantidad=Double.parseDouble(request.getParameter("cantidad"));
        int codigo=(int)request.getSession().getAttribute("codigocuenta");
        int codDestino=Integer.parseInt(request.getParameter("destino"));
        if(gcajero.obtenerCuenta(codDestino)!=null) {
        	gcajero.transferencia(codigo, codDestino, cantidad);
        }
        request.getRequestDispatcher("menu.html").forward(request, response);
	}

}
