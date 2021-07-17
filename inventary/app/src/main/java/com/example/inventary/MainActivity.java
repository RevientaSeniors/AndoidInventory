package com.example.inventary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.util.Log;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void visualizar(View view){
        Intent visualizarProducto = new Intent(this,VisualizarProducto.class);
        startActivity((visualizarProducto));

    }
    public void agregar(View view){
        //Log.i("info","Botón Agregar contenido presionado");
        Intent agregarProducto = new Intent(this,AgregarProducto.class);
        startActivity(agregarProducto);
    }
    public void editar(View view){
        Intent editarProducto = new Intent(this, EditarProducto.class);
        startActivity(editarProducto);
    }
    public void fiadores(View view){
        Intent fiadores = new Intent(this, Fiadores.class);
        startActivity(fiadores);


    }

}