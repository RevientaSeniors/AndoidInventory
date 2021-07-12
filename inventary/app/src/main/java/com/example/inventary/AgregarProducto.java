package com.example.inventary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class AgregarProducto extends AppCompatActivity {
private Spinner spinner1;
private EditText nombreProducto, precioProducto, cantidadProducto;
private String nombre;
private int cantidad;
private double precio;
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
        seleccion = spinner1.getSelectedItem().toString();
        productos[contadorProducto] = new Producto(nombre, seleccion, cantidad, precio);
        for(int i=0; i<=contadorProducto;i++) {
            Log.i("info", "Nombre: " + productos[i].getNombre()+ " Tipo: "+productos[i].getTipo()+ " Cantidad:"+productos[i].getCantidad()+" Precio: "+productos[i].getPrecio()+ " n"+contadorProducto);
        }
        contadorProducto = contadorProducto+1;



    }
}