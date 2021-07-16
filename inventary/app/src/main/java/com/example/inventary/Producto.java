package com.example.inventary;

import android.content.Context;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Producto implements Serializable {
    String nombre;
    String tipo;
    int cantidad;
    double precio;
    double precioCompraUnidad;
    double precioCompraConjunto;

    public Producto(String nombre, String tipo, int cantidad, double precio, double precioCompraUnidad, double precioCompraConjunto) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.precio = precio;
        this.precioCompraUnidad = precioCompraUnidad;
        this.precioCompraConjunto = precioCompraConjunto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getPrecioCompraUnidad(){
        return precioCompraUnidad;
    }

    public void setPrecioCompraUnidad(double precioCompraUnidad){
        this.precioCompraUnidad = precioCompraUnidad;
    }

    public double getPrecioCompraConjunto() {
        return precioCompraConjunto;
    }

    public void setPrecioCompraConjunto(double precioCompraConjunto) {
        this.precioCompraConjunto = precioCompraConjunto;
    }
}
