package com.example.inventary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class EditarProducto extends AppCompatActivity {
    private Spinner spinnerProducto, spinnerOpciones;
    private Button editar;
    private String[] opciones = {"","Limpieza","Farmacia","Consumo Diario", "Desechables"} ;
    private ArrayList<Producto> productosA = new ArrayList<Producto>();
    private ArrayList<String> productosFiltrados = new ArrayList<String>();
    private int valorSpinnerPro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_producto);
        spinnerOpciones = (Spinner) findViewById(R.id.spinnerTipo);
        ArrayAdapter<String> spin = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,opciones);
        spinnerProducto = (Spinner) findViewById(R.id.spinnerPruducto);
        spinnerProducto.setEnabled(false);
        spinnerProducto.setVisibility(View.INVISIBLE);
        editar =(Button) findViewById(R.id.button8);
        editar.setEnabled(false);
        editar.setVisibility(View.INVISIBLE);
        spinnerOpciones.setAdapter(spin);
        cargarDatos();
        spinnerOpciones.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if(spinnerOpciones.getItemAtPosition(i).toString().equals(opciones[1])){
                    spinnerProducto.setAdapter(listAArray(0));
                    enabledVisible();

                }else if (spinnerOpciones.getItemAtPosition(i).toString().equals(opciones[2])){
                    spinnerProducto.setAdapter(listAArray(1));
                    enabledVisible();

                }else if(spinnerOpciones.getItemAtPosition(i).toString().equals(opciones[3])){
                    spinnerProducto.setAdapter(listAArray(2));
                    enabledVisible();

                }else if(spinnerOpciones.getItemAtPosition(i).toString().equals(opciones[4])){
                    spinnerProducto.setAdapter(listAArray(3));
                    enabledVisible();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinnerProducto.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Log.i("Info spinner de pro", "Se está tocando: "+spinnerProducto.getItemAtPosition(i).toString());
                valorSpinnerPro = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    public ArrayAdapter<String> listAArray(int tipo){
        productosFiltrados.clear();
        for(int i=0; i<=productosA.size()-1;i++){
            if(tipo == 0) {
                if(productosA.get(i).getTipo().equals(opciones[1])) {
                    productosFiltrados.add(productosA.get(i).getNombre());
                }
            }else if(tipo == 1){
                if(productosA.get(i).getTipo().equals(opciones[2])){
                    productosFiltrados.add(productosA.get(i).getNombre());
                }
            }else if(tipo == 2){
                if(productosA.get(i).getTipo().equals(opciones[3])){
                    productosFiltrados.add(productosA.get(i).getNombre());
                }
            }else if(tipo==3){
                if(productosA.get(i).getTipo().equals(opciones[4])){
                    productosFiltrados.add(productosA.get(i).getNombre());
                }

            }
        }
        ArrayAdapter<String> spin2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,productosFiltrados);
        return spin2;
    }
    public void cargarDatos(){
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
    }
    public void enabledVisible(){
        spinnerProducto.setEnabled(true);
        spinnerProducto.setVisibility(View.VISIBLE);
        editar.setEnabled(true);
        editar.setVisibility(View.VISIBLE);
    }
    public void editarP(View view){
        Intent pasar = new Intent(this,EditarProductox2.class);
        pasar.putExtra("productoPasar", spinnerProducto.getItemAtPosition(valorSpinnerPro).toString());
        startActivity(pasar);
    }

}