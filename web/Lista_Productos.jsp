<%-- 
    Document   : Lista_Productos
    Created on : 13/07/2020, 02:54:42 PM
    Author     : gabo
--%>

<%@page import="Modelo.Producto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="controlador.ProductoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
            body{
                font-family: Arial;
                background-color:cornsilk;
            }
            div{
                margin: auto;
            }
            td{
               box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2), 0 6px 20px 0 rgba(0,0,0,0.19);
               border: 3px solid green;padding: 10px;
               
            }
            th{
                box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2), 0 6px 20px 0 rgba(0,0,0,0.19);
                padding: 20px;
            }
        </style>
    </head>
    <body>
        <div class="container"style="  margin: auto;
  width: 50%;
  padding: 10px;">
            <div class="row">
                <div class="col s8"style="margin: auto">
                    <h2>LISTADO DE PRODUCTOS</h2>
            </div>
        <div class="row" style="margin:0px">
                <div class="col s8" style="margin:0px"style="border: 3px solid green;">
                    <table class="bordered highlight">
                        <thead>
                            <tr>
                                <th>CODIGO</th>
                                <th>NOMBRE</th>
                                <th>PRECIO</th>
                                <th>MERCADO</th>
                                <th>FORMATO</th>
                                <th>ELIMINAR</th>
                            </tr>
                        </thead>
                          <tbody>
                            <%
                                ProductoDAO pro = new ProductoDAO();
                                ArrayList<Producto> listap = pro.obtenerProductos();
                                for(Producto p : listap){
                                    out.println("<tr>");
                                        out.println("<td>"+p.getCod_salmon()+"</td>");
                                        out.println("<td>"+p.getNombre()+"</td>");
                                        out.println("<td>"+p.getPrecio()+"</td>");
                                        out.println("<td>"+p.getNombre_mercado()+"</td>");
                                        out.println("<td>"+p.getNombre_formato()+"</td>");
                                        out.println("<td><a href='eliminar.do?cod="+p.getCod_salmon()+"'>Eliminar registro</a></td>");
                                    out.println("</tr>");
                                }
                            %>
                        </tbody>
                    </table>
              
        <h4><a href="index.html">Volver Al Index</a></h4>
        <%
             if(request.getParameter("ok") != null){
              String ok = request.getParameter("ok");
              out.println("<h5><font color='green'>"+ok+"</font></h5>");
             }
             if(request.getParameter("error") != null){
               String error = request.getParameter("error");
               out.println("<h5><font color='red'>"+error+"</font></h5>");
          }
        %>
                  </div>
            </div>
        </div>
    </body>
</html>
