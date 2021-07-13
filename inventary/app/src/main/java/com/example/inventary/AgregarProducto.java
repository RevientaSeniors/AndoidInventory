package com.example.inventary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AgregarProducto extends AppCompatActivity {
private Spinner spinner1;
private EditText nombreProducto, precioProducto, cantidadProducto, precioProductoUnidad, precioProductoConjunto;
private String nombre;
private int cantidad;
private double precio, precioCompraUnidad, precioCompraConjunto;
private  String seleccion;
Producto[] productos;
private int contadorProducto = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_producto);
        spinner1 = (Spinner)findViewById(R.id.spinner);
        nombreProducto = (EditText)findViewById((R.id.editTextTextPersonName));
        precioProducto = (EditText)findViewById(R.id.editTextNumberDecimal);
        precioProductoUnidad = (EditText)findViewById(R.id.editTextNumberDecimal2);
        precioProductoConjunto = (EditText)findViewById(R.id.editTextNumberDecimal3);
        cantidadProducto = (EditText)findViewById(R.id.editTextNumber);
        String [] opciones ={"Limpieza","Farmacia","Consumo Diario", "Desechables"};
        ArrayAdapter <String> arreglo1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opciones);
        spinner1.setAdapter(arreglo1);
    }

    public AgregarProducto() {
        this.productos = new Producto[500];
    }

    /*
        @Override
        public boolean onKeyDown(int keyCode, KeyEvent event) {
            System.out.println("Presionaste el boton de volver xd");
            return super.onKeyDown(keyCode, event);
        }
        */
    public void agregarP(View view){
        nombre = nombreProducto.getText().toString();
        precio = Double.parseDouble(precioProducto.getText().toString());
        cantidad = Integer.parseInt(cantidadProducto.getText().toString());
        precioCompraUnidad = Double.parseDouble(precioProductoUnidad.getText().toString());
        precioCompraConjunto = Double.parseDouble(precioProductoConjunto.getText().toString());
        seleccion = spinner1.getSelectedItem().toString();
        if(precioCompraConjunto>0) {
            precioCompraUnidad = precioCompraConjunto / cantidad;
        }
        productos[contadorProducto] = new Producto(nombre, seleccion, cantidad, precio,precioCompraUnidad, precioCompraConjunto);
        for(int i=0; i<=contadorProducto;i++) {
            Log.i("info", "Nombre: " + productos[i].getNombre()+ " Tipo: "+productos[i].getTipo()+ " Cantidad:"+productos[i].getCantidad()+" Precio: "+productos[i].getPrecio()+ " n"+contadorProducto);
        }
        contadorProducto = contadorProducto+1;
        VisualizarProducto tabla = new VisualizarProducto();
        tabla.recibirProducto(productos);
        Toast.makeText(this, "Producto Agregado", Toast.LENGTH_SHORT).show();



    }
}