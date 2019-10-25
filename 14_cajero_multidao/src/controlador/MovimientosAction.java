/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Movimiento;
import service.ServiceCajero;

/**
 *
 * @author Profesormanana
 */
@WebServlet(name = "MovimientosAction", urlPatterns = {"/MovimientosAction"})
public class MovimientosAction extends HttpServlet {

	@EJB
    ServiceCajero gcajero;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recuperamos el código de cuenta y le pedimos al modelo
        //el saldo y los movimientos
        int codigo=(int)request.getSession().getAttribute("codigocuenta");
        double saldo=gcajero.obtenerSaldo(codigo);
        List<Movimiento> movs=gcajero.obtenerMovimientos(codigo);
        System.out.println("Movimientos "+movs.size());
       
        request.setAttribute("saldo", saldo);
        request.setAttribute("movimientos", movs);
        request.getRequestDispatcher("movimientos.jsp").forward(request, response);
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
