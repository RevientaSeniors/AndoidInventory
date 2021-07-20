package com.example.inventary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.PointerIcon;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class AgregarFiador extends AppCompatActivity {
private ArrayList<Fiador> fiadores= new ArrayList<Fiador>();
private ArrayList<Fiador> fiadoresCargar= new ArrayList<Fiador>();
private ArrayList<Producto> listaProductos = new ArrayList<Producto>();
private int contadorFiador = 0;
private TextView nombreTv;
private  String nombre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_fiador);
        nombreTv = (TextView) findViewById(R.id.tv_nombreFiador);
        cargarDatos();
    }

    public void agregarFia(View view){
        nombre = nombreTv.getText().toString();
        for(int i=0;i<=5;i++) {
            listaProductos.add(i,new Producto("producto"+i,"Farmacia",20,22.5,23,0));
        }
        fiadores.add(contadorFiador,new Fiador(nombre,listaProductos,0.0,0.0));
        contadorFiador = contadorFiador+1;
        guardarDatos();
    }
    public void guardarDatos(){
        try {
            FileOutputStream fos = openFileOutput("fiad.dat", Context.MODE_PRIVATE);

            // Wrapping our file stream.
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            // Writing the serializable object to the file
            oos.writeObject(fiadores);

            // Closing our object stream which also closes the wrapped stream.
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Toast.makeText(this, "Fiador Agregado", Toast.LENGTH_SHORT).show();


    }
    public void cargarDatos(){
        try {
            FileInputStream fin = openFileInput("fiad.dat");

            // Wrapping our stream
            ObjectInputStream oin = new ObjectInputStream(fin);

            // Reading in our object
            fiadoresCargar = (ArrayList<Fiador>) oin.readObject();
            // Closing our object stream which also closes the wrapped stream.
            oin.close();
            fiadores = (ArrayList) fiadoresCargar.clone();
            contadorFiador = fiadoresCargar.size()-1;
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}