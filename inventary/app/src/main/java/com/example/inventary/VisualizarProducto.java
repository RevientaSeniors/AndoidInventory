package com.example.inventary;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;

import java.util.ArrayList;

public class VisualizarProducto extends AppCompatActivity {
private Producto[] productos;
private TableLayout tabla;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar_producto);
        tabla = (TableLayout)findViewById(R.id.TableLayout1);

        for(int i=0; i<productos.length;i++){

        }

    }

    public void recibirProducto(Producto productos[]){
        this.productos = productos;
    }
}