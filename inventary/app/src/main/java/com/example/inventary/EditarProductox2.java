package com.example.inventary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class EditarProductox2 extends AppCompatActivity {
private ArrayList<Producto> productosCargar = new ArrayList<Producto>();
private Spinner spin;
private String valor;
private TextView nombre, cantidad,precioVenta,precioCompraUnidad, precioCompraConjunto;
private String[] opciones ={"","Limpieza","Farmacia","Consumo Diario","Desechables"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_productox2);
        Intent intent = getIntent();
        valor = intent.getStringExtra("productoPasar");
        cargarDatos();
        asignarDatos();
        Toast.makeText(this,"es: "+valor,Toast.LENGTH_LONG).show();

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
        } catch(Exception e) {
            e.printStackTrace();
        }

    }
    public void asignarDatos(){
        nombre = (TextView) findViewById(R.id.tv_Nombre);
        cantidad= (TextView) findViewById(R.id.tv_Cantidad);
        precioVenta = (TextView) findViewById(R.id.editTextNumberDecimal);
        precioCompraUnidad =(TextView) findViewById(R.id.editTextNumberDecimal2);
        precioCompraConjunto = (TextView) findViewById(R.id.editTextNumberDecimal3);
        spin =(Spinner) findViewById(R.id.spinner);
        Iterator<Producto> iterator = productosCargar.iterator();

        //Probar con getcantidad para ver si hay algún error con el serializado/ hacerlo con for/hacer int alguna variable y probar imprimirla
        for(int i=0;i<=productosCargar.size()-1;i++){
            if(productosCargar.get(i).getNombre().equals(valor)){
                Log.i("info", "Entro al if");
                nombre.setText(productosCargar.get(i).getNombre());
                cantidad.setText(String.valueOf(productosCargar.get(i).getCantidad()));
                precioVenta.setText(String.valueOf(productosCargar.get(i).getPrecio()));
                precioCompraUnidad.setText(String.valueOf(productosCargar.get(i).getPrecioCompraUnidad()));
                precioCompraConjunto.setText(String.valueOf(productosCargar.get(i).getPrecioCompraConjunto()));
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,opciones);
                spin.setAdapter(adapter);

            }
        }


    }

    public void botonEditar(View view){
        for(int i=0;i<=productosCargar.size()-1;i++) {
            if (productosCargar.get(i).getNombre().equals(valor)) {
                Intent pasar = new Intent(this,MainActivity.class);
                String nombreMeter, tipoMeter;
                int cantidadMeter;
                double precioVentaMeter, precioCompraUnidadMeter, precioCompraConjuntoMeter;
                nombreMeter =nombre.getText().toString();
                tipoMeter = spin.getSelectedItem().toString();
                cantidadMeter = Integer.parseInt(cantidad.getText().toString());
                precioVentaMeter = Double.parseDouble(precioVenta.getText().toString());
                precioCompraUnidadMeter =Double.parseDouble(precioCompraUnidad.getText().toString());
                precioCompraConjuntoMeter = Double.parseDouble(precioCompraConjunto.getText().toString());
                productosCargar.remove(i);
                productosCargar.add(new Producto(nombreMeter,tipoMeter,cantidadMeter,precioVentaMeter,precioCompraUnidadMeter,precioCompraConjuntoMeter));
                guardarDatos();
                Toast.makeText(this, "Producto Editado", Toast.LENGTH_SHORT).show();
                startActivity(pasar);
            }
        }
    }
    public void guardarDatos(){
        try {
            FileOutputStream fos = openFileOutput("test.dat", Context.MODE_PRIVATE);

            // Wrapping our file stream.
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            // Writing the serializable object to the file
            oos.writeObject(productosCargar);

            // Closing our object stream which also closes the wrapped stream.
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void eliminarProducto(View view){
        for(int i=0;i<=productosCargar.size()-1;i++) {
            if (productosCargar.get(i).getNombre().equals(valor)) {
                Intent pasar = new Intent(this,MainActivity.class);
                productosCargar.remove(i);
                guardarDatos();
                Toast.makeText(this, "Producto Eliminado", Toast.LENGTH_SHORT).show();
                startActivity(pasar);
            }
        }
    }
}