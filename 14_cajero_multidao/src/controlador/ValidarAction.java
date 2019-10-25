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
import javax.servlet.http.HttpSession;

import service.ServiceCajero;

/**
 *
 * @author Profesormanana
 */
@WebServlet(name = "ValidarAction", urlPatterns = {"/ValidarAction"})
public class ValidarAction extends HttpServlet {

    @EJB
    ServiceCajero gcajero;
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int codigo=Integer.parseInt(request.getParameter("codigo"));
        if(gcajero.obtenerCuenta(codigo)!=null){
            //si la cuenta existe, la guardamos como atributo de sesión
            HttpSession s=request.getSession();
            s.setAttribute("codigocuenta", codigo);
            request.getRequestDispatcher("menu.html").forward(request, response);
        }else{
            request.getRequestDispatcher("index.html").forward(request, response);
        }
    }

   
}
