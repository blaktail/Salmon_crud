/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Modelo.Producto;
import controlador.ProductoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gabo
 */
@WebServlet(name = "CrearServlet", urlPatterns = {"/CrearServlet"})
public class CrearServlet extends HttpServlet {

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
        ArrayList <String> escucha = new ArrayList <>();
        try{
            String cod= request.getParameter("txtcod");
            String nam=request.getParameter("txtname");
            String prec=request.getParameter("txtprecio");
            String m=request.getParameter("option");
            String f=request.getParameter("dropformato");
            int c = 0,pr = 0,mer = 0,fo = 0;
            boolean res= false;
            ProductoDAO p = new ProductoDAO();
            
            try{
                if(cod.isEmpty()){
                    escucha.add("El codigo no debe quedar en blanco.");
                }else{
                c = Integer.parseInt(cod);
                if(c<1 || c>99999){
                    escucha.add("El codigo debe tener hasta 5 números");
                }else{
                    res = p.comprobar(c);
                    if(res){
                        escucha.add("El codigo "+c+" Ya existe.");
                    }        
                }
            }
        } catch(Exception e){
        escucha.add("Error en el valor del codigo");
        }
        
             if(nam.isEmpty()){
                escucha.add("El nombre No Debe Quedar En Blanco.");
            }else if(nam.length()>100){
                escucha.add("El Nombre No Debe Superar Los 100 Caracteres.");
            } 
             
             try{
                 if(prec.isEmpty()){
                     escucha.add("El precio no puede estar en blanco");
                 }else{
                     pr = Integer.parseInt(prec);
                     if(pr>9999999 || pr<1){
                      escucha.add("Rango maximo de precio "+pr);
                     }
                 }
             }catch(Exception e){
                 escucha.add("Error en el valor precio");
             }
             
             try{
                 if(m.isEmpty()){
                     escucha.add("El mercado no puede quedar en blanco");
                 }else{
                     mer = Integer.parseInt(m);
                     if(mer!=1 && mer!=2){
                         escucha.add("Error en la opcion del mercado");
                     }
                 }            
             }catch(Exception e){
                 escucha.add("error en el valor mercado");
             }

             try{
                 if (f.isEmpty()) {
                     escucha.add("El formato no puede quedar sin opcion");
                 }else{
                     fo = Integer.parseInt(f);
                     if (fo!=1 && fo!=2 && fo!=3) {
                         escucha.add("Error en la opcion de formato");
                     }
                 }
             }catch(Exception e){
                 escucha.add("Error en el valor del formato");
             }
             
             if(escucha.isEmpty()){
                  Producto producto = new   Producto(nam,c,pr,mer,fo);
                 p.agregarProducto(producto);
                 String ok = "Producto agregado correctamente.";
                 response.sendRedirect("Crear_Productos.jsp?ok="+ok);
             }else{
                 request.setAttribute("escucha", escucha);
                 request.getRequestDispatcher("Crear_Productos.jsp").forward(request, response);
             }
          }catch(Exception e1){
            escucha.add(e1.getMessage());
            request.setAttribute("escucha",escucha);
            request.getRequestDispatcher("Form_Agregar.jsp").forward(request, response);
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
