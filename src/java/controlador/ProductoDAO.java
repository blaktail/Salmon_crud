/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Modelo.Producto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author gabo
 */
public class ProductoDAO {
    private Connection con = null;
    private Statement sentencia = null;
    private ResultSet rs = null;
    
    private void conectar(){
        try{
            String parametros = "com.mysql.jdbc.Driver";
            Class.forName(parametros);
            String url = "jdbc:mysql://localhost:3306/productos";
            con = DriverManager.getConnection(url,"root","");
        }catch(Exception e1){            
            System.exit(0);
        }
    }
    
    private void desconectar(){
        try{
            con.close();
        }catch(Exception e1){            
            System.exit(0);
        }
    }
       public void agregarProducto(Producto p){
        try{
            conectar();
            sentencia = con.createStatement();
            String sql = "insert into salmones values ("+p.getCod_salmon()+",'"+p.getNombre()+"',"+p.getPrecio()+","+p.getCod_mercado()+","+p.getCod_formato()+")";
            sentencia.execute(sql);
            sentencia.close();
            desconectar();
        }catch(Exception e1){            
            System.exit(0);
        }
    }
       
       
       public String obtenercomboformato(){
           String elementos="";
           try{
              conectar();
              sentencia = con.createStatement();
              String sql = "select * from formato order by cod_formato asc";
              rs = sentencia.executeQuery(sql);
              while(rs.next()){
                  int cod = rs.getInt("cod_formato");
                  String nom = rs.getString("nombre_formato");
                  elementos += "<option value='"+cod+"'>"+nom+"</option>"; 
              }
              sentencia.close();
              desconectar();
           }catch(Exception e){
               System.exit(0);
           }
           return elementos;
       }
       
       public boolean comprobar (int cod){
           try{
               conectar();
               sentencia = con.createStatement();
               String sql = "select cod_salmon from salmones where cod_salmon="+cod;
               rs = sentencia.executeQuery(sql);
               if(rs.next()){
                   sentencia.close();
                   desconectar();
                   return true;
               }
           }catch(Exception e1){            
            System.exit(0);
        }
        return false;
       } 
       
       public ArrayList<Producto> obtenerProductos(){
           ArrayList<Producto> listap = null;
           try{
               conectar();
               sentencia = con.createStatement();
               String sql = "select cod_salmon,nombre,precio,nombre_mercado,nombre_formato from salmones, mercado, formato where salmones.cod_mercado=mercado.cod_mercado and salmones.cod_formato=formato.cod_formato order by cod_salmon asc";
               listap = new ArrayList<Producto>();
               rs = sentencia.executeQuery(sql);
               while(rs.next()){
                   Producto p = new Producto();
                   p.setCod_salmon(rs.getInt("cod_salmon"));
                   p.setNombre(rs.getString("nombre"));
                   p.setPrecio(rs.getInt("precio"));
                   p.setNombre_mercado(rs.getString("nombre_mercado"));
                   p.setNombre_formato(rs.getString("nombre_formato"));
                   listap.add(p);
               }
                 }catch(Exception e1){            
            System.exit(0);
        }
           return listap;
       }
       
       public void eliminarProducto(int cod){
           try{
               conectar();
               sentencia = con.createStatement();
               String sql = "delete from salmones where cod_salmon="+cod;
               sentencia.execute(sql);
               sentencia.close();
               desconectar();
           }catch (Exception e ){
               System.exit(0);
           }
       }
}
