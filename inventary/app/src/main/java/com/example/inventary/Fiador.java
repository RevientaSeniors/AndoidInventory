package com.example.inventary;


import java.io.Serializable;
import java.util.ArrayList;

public class Fiador implements Serializable {
private String nombre;
private ArrayList<Producto> productos;
private double deudaTotal;
private double pagado;

    public Fiador(String nombre, ArrayList<Producto> productos, double deudaTotal, double pagado) {
        this.nombre = nombre;
        this.productos = productos;
        this.deudaTotal = deudaTotal;
        this.pagado = pagado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public double getDeudaTotal() {
        return deudaTotal;
    }

    public void setDeudaTotal(double deudaTotal) {
        this.deudaTotal = deudaTotal;
    }

    public double getPagado() {
        return pagado;
    }

    public void setPagado(double pagado) {
        this.pagado = pagado;
    }




}
