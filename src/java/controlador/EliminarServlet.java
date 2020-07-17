/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gabo
 */
@WebServlet(name = "EliminarServlet", urlPatterns = {"/eliminar.do"})
public class EliminarServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        try{
            if(request.getParameter("cod") != null){
                int cod = Integer.parseInt(request.getParameter("cod"));
                if(cod<1 || cod>99999){
                    String error = "El codigo esta incorrecto.";
                    response.sendRedirect("Lista_Productos.jsp?error="+error);
                }else{
                    ProductoDAO d = new ProductoDAO();
                    boolean res = d.comprobar(cod);
                    if (res) {
                        d.eliminarProducto(cod);
                        String ok = "Producto "+cod+" Eliminado correctamente.";
                        response.sendRedirect("Lista_Productos.jsp?ok="+ok);
                        
                    }else{
                        String error = "El codigo "+cod+" no existe. imposible de eliminar.";
                        response.sendRedirect("Lista_Productos.jsp?error="+error);
                    }
                }
            }
        }catch(Exception e){
            String error = "El codigo no existe. imposible de eliminar.";
            response.sendRedirect("Lista_Productos.jsp?error="+error);
        }
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
