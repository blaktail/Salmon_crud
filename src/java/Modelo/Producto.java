/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author gabo
 */
public class Producto {
   private String  nombre,nombre_mercado,nombre_formato;
   private int cod_salmon,precio,cod_mercado,cod_formato;

    public Producto() {
    }

    public Producto(String nombre, int cod_salmon, int precio, int cod_mercado, int cod_formato) {
        this.nombre = nombre;
        this.cod_salmon = cod_salmon;
        this.precio = precio;
        this.cod_mercado = cod_mercado;
        this.cod_formato = cod_formato;
    }

 

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre_mercado() {
        return nombre_mercado;
    }

    public void setNombre_mercado(String nombre_mercado) {
        this.nombre_mercado = nombre_mercado;
    }

    public String getNombre_formato() {
        return nombre_formato;
    }

    public void setNombre_formato(String nombre_formato) {
        this.nombre_formato = nombre_formato;
    }

    public int getCod_salmon() {
        return cod_salmon;
    }

    public void setCod_salmon(int cod_salmon) {
        this.cod_salmon = cod_salmon;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCod_mercado() {
        return cod_mercado;
    }

    public void setCod_mercado(int cod_mercado) {
        this.cod_mercado = cod_mercado;
    }

    public int getCod_formato() {
        return cod_formato;
    }

    public void setCod_formato(int cod_formato) {
        this.cod_formato = cod_formato;
    }
    
    
}
