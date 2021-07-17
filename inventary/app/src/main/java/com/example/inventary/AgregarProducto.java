package com.example.inventary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class AgregarProducto extends AppCompatActivity {
    private Spinner spinner1;
    private EditText nombreProducto, precioProducto, cantidadProducto, precioProductoUnidad, precioProductoConjunto;
    private String nombre;
    private int cantidad;
    private double precio, precioCompraUnidad, precioCompraConjunto;
    private String seleccion;
    private ArrayList<Producto> productosA = new ArrayList<Producto>(), productosCargar = new ArrayList<Producto>();
    private int contadorProducto = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_producto);
        cargarDatos();
        spinner1 = (Spinner) findViewById(R.id.spinner);
        nombreProducto = (EditText) findViewById((R.id.tv_Nombre));
        precioProducto = (EditText) findViewById(R.id.editTextNumberDecimal);
        precioProductoUnidad = (EditText) findViewById(R.id.editTextNumberDecimal2);
        precioProductoConjunto = (EditText) findViewById(R.id.editTextNumberDecimal3);
        cantidadProducto = (EditText) findViewById(R.id.tv_Cantidad);
        String[] opciones = {"Limpieza", "Farmacia", "Consumo Diario", "Desechables"};
        ArrayAdapter<String> arreglo1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opciones);
        spinner1.setAdapter(arreglo1);
    }

    /*
        @Override
        public boolean onKeyDown(int keyCode, KeyEvent event) {
            System.out.println("Presionaste el boton de volver xd");
            return super.onKeyDown(keyCode, event);
        }
        */
    public void agregarP(View view) {
        nombre = nombreProducto.getText().toString();
        precio = Double.parseDouble(precioProducto.getText().toString());
        cantidad = Integer.parseInt(cantidadProducto.getText().toString());
        precioCompraUnidad = Double.parseDouble(precioProductoUnidad.getText().toString());
        precioCompraConjunto = Double.parseDouble(precioProductoConjunto.getText().toString());
        seleccion = spinner1.getSelectedItem().toString();
        if (precioCompraConjunto > 0) {
            precioCompraUnidad = precioCompraConjunto / cantidad;
        }

        productosA.add(contadorProducto, new Producto(nombre, seleccion, cantidad, precio, precioCompraUnidad, precioCompraConjunto));
        contadorProducto = contadorProducto + 1;
        try {
            FileOutputStream fos = openFileOutput("test.dat", Context.MODE_PRIVATE);

            // Wrapping our file stream.
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            // Writing the serializable object to the file
            oos.writeObject(productosA);

            // Closing our object stream which also closes the wrapped stream.
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Toast.makeText(this, "Producto Agregado", Toast.LENGTH_SHORT).show();


    }
    public void cargarDatos(){
        try {
            FileInputStream fin = openFileInput("test.dat");

            // Wrapping our stream
            ObjectInputStream oin = new ObjectInputStream(fin);

            // Reading in our object
            productosCargar = (ArrayList<Producto>) oin.readObject();
            // Closing our object stream which also closes the wrapped stream.
            oin.close();
            productosA = (ArrayList) productosCargar.clone();
            contadorProducto = productosCargar.size()-1;
        } catch(Exception e) {
            e.printStackTrace();
        }

    }

}