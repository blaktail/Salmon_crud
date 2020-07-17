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
        <title>Lista de productos - Salmonex</title>
           <script type="text/javascript" >
           function eliminar(int) {
               var resultado = confirm("¿Estas seguro de que quieres elminar este ingreso?");
               var cod = int;
               console.log(cod);
               if (resultado === true) {
                   window.location.href= "eliminar.do?cod="+cod+"";
                }else{
            }}
        
            </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
            body{
                font-family: Arial;
                background-color:cornsilk;
            }
            div{
                margin: auto;
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
                <div class="col s8" style="margin:0px">
                    <table class="bordered highlight" border= "1">
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
                                        out.println("<td><button onClick = 'javascript:eliminar("+p.getCod_salmon()+");return false'>Eliminar registro</button></td>");
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
