/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 *
 * @author Profesormanana
 */
@WebServlet(name = "IngresarAction", urlPatterns = {"/IngresarAction"})
public class IngresarAction extends HttpServlet {
	@EJB
    ServiceCajero gcajero;
    
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        double cantidad=Double.parseDouble(request.getParameter("cantidad"));
        int codigo=(int)request.getSession().getAttribute("codigocuenta");
        gcajero.ingreso(codigo, cantidad);
        request.getRequestDispatcher("menu.html").forward(request, response);
    }

}
