package com.example.inventary;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class VisualizarProducto extends AppCompatActivity {
private ArrayList <Producto> productosA = new ArrayList <Producto>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar_producto);

        try {
            FileInputStream fin = openFileInput("test.dat");

            // Wrapping our stream
            ObjectInputStream oin = new ObjectInputStream(fin);

            // Reading in our object
            productosA = (ArrayList<Producto>) oin.readObject();
            // Closing our object stream which also closes the wrapped stream.
            oin.close();
        } catch(Exception e) {
            e.printStackTrace();
        }

        init();

    }



    public void init() {
        TableLayout stk = (TableLayout) findViewById(R.id.table_main);
        TableRow tbrow0 = new TableRow(this);
        TextView tv0 = new TextView(this);
        tv0.setText(" id ");
        tv0.setTextColor(Color.WHITE);
        tbrow0.addView(tv0);
        TextView tv1 = new TextView(this);
        tv1.setText(" Producto ");
        tv1.setTextColor(Color.WHITE);
        tbrow0.addView(tv1);
        TextView tv2 = new TextView(this);
        tv2.setText(" Tipo ");
        tv2.setTextColor(Color.WHITE);
        tbrow0.addView(tv2);
        TextView tv3 = new TextView(this);
        tv3.setText(" Venta Unidad ");
        tv3.setTextColor(Color.WHITE);
        tbrow0.addView(tv3);
        TextView tv4 = new TextView(this);
        tv4.setText(" Compra Unidad ");
        tv4.setTextColor(Color.WHITE);
        tbrow0.addView(tv4);
        TextView tv5 = new TextView(this);
        tv5.setText("Cantidad");
        tv5.setTextColor(Color.WHITE);
        tbrow0.addView(tv5);

        stk.addView(tbrow0);

        for (int i = 0; i <= productosA.size()-1; i++) {
                TableRow tbrow = new TableRow(this);
                TextView t1v = new TextView(this);
                t1v.setText("" + i);
                t1v.setTextColor(Color.WHITE);
                t1v.setGravity(Gravity.CENTER);
                tbrow.addView(t1v);
                TextView t2v = new TextView(this);
                t2v.setText(productosA.get(i).getNombre());
                t2v.setTextColor(Color.WHITE);
                t2v.setGravity(Gravity.CENTER);
                tbrow.addView(t2v);
                TextView t3v = new TextView(this);
                t3v.setText(productosA.get(i).getTipo());
                t3v.setTextColor(Color.WHITE);
                t3v.setGravity(Gravity.CENTER);
                tbrow.addView(t3v);
                TextView t4v = new TextView(this);
                t4v.setText(String.valueOf(productosA.get(i).getPrecio()));
                t4v.setTextColor(Color.WHITE);
                t4v.setGravity(Gravity.CENTER);
                tbrow.addView(t4v);
                TextView t5v = new TextView(this);
                t5v.setText(String.valueOf(productosA.get(i).getPrecioCompraUnidad()));
                t5v.setTextColor(Color.WHITE);
                t5v.setGravity(Gravity.CENTER);
                tbrow.addView(t5v);
                TextView t6v = new TextView(this);
                t6v.setText(String.valueOf(productosA.get(i).getCantidad()));
                t6v.setTextColor(Color.WHITE);
                t6v.setGravity(Gravity.CENTER);
                tbrow.addView(t6v);
                stk.addView(tbrow);

        }

    }



}