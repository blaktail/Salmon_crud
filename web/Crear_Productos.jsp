<%-- 
    Document   : Crear_Productos
    Created on : 13/07/2020, 02:49:39 PM
    Author     : gabo
--%>
<%@page import="controlador.ProductoDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario de creación</title>
        <style>
            .button {
            transition-duration: 0.4s;
            margin-right: 100px;
            background-color: #4CAF50;
            padding: 15px 32px;
            text-align: center;
            font-size: 16px;
            color: white;
            box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2), 0 6px 20px 0 rgba(0,0,0,0.19);
            }
            .button2{
            transition-duration: 0.4s;
            background-color: #f44336;
            padding: 15px 32px;
            color: white;
            text-align: center;
            font-size: 16px;
            box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2), 0 6px 20px 0 rgba(0,0,0,0.19);
            }
            .button2:hover {
             background-color: #4CAF50; 
             color: black;
             background-color:crimson;
            }
            .button:hover {
             background-color: #4CAF50; 
             color: black;
             background-color:greenyellow;
            }
            body{
                font-family: Arial;
                background-color:bisque;
            }
            input{
                box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2), 0 6px 20px 0 rgba(0,0,0,0.19);
           
            }
            div{
                margin-top: 15px;
            }
            
        </style>
    </head>
    <body>
        <div class="container">
            <h4 style="margin:90px">Registro de productos : Salmón</h4>
            
            <form action="CrearServlet" method="post">
                <div class="row" >
                <div class="col s6 input-field ">
                    <label for="txtcod">Ingrese el código del salmón:</label>
                    <input type="number" name="txtcod" id="txtcod" required/>
                </div>
                </div>
                <div class="row" >
                <div class="col s6 input-field ">
                    <label for="txtname">Nombre del producto:</label>
                    <input type="text" name="txtname" id="txtname" required/>
                </div>
                </div>
                 <div class="row">
                <div class="col s6 input-field ">
                    <label for="txtprecio">Precio del producto:</label>
                    <input type="number" name="txtprecio" id="txtprecio" required/>
                </div>
                </div>
                <div class="row"style="margin:0px">
                    <div class="col s6">
                        <fieldset>
                            <label for="option">
                            Marque el tipo de mercado:
                            </label>
                            <input type="radio" name="option" id="option1" value="1" checked=""/>
                            <label for="option1">Internacional</label>
                            <input type="radio" name="option" id="option2" value="2"/>
                            <label for="option2">Nacional</label>
                        </fieldset>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s6 input-field">
                        <select id="dropformato" name="dropformato" required>
                            <option value="">Seleccione un formato:</option>
                            <%
                                ProductoDAO p = new ProductoDAO();
                                out.println(p.obtenercomboformato());
                            %>
                        </select>
                    </div>
                </div>    
                        <div class="row" >
                    <div class="col s6" style="margin:0px">
                        <button class="button" name="btnok" type="submit">Guardar
                        </button>
                        <button class="button2" name="btnres" type="reset">Restablecer
                        </button>
                    </div>
                </div>         
                        
            </form>
            <h4 style="margin-top: 30px"><a href="index.html">Volver Al Index</a></h4>
            <% 
               if(request.getParameter("ok") != null){
                   String ok = request.getParameter("ok");
                   out.println("<h5><front color='green'>"+ok+"</font></h5>");
               }
               if(request.getAttribute("escucha") != null){
                   ArrayList <String> escucha = (ArrayList<String>) request.getAttribute("escucha");
                   for(String item : escucha){
                       out.println("<h5><font color='red'>"+item+"</font></h5>");
                   }
               }
            %>
        </div>
    </body>
</html>
