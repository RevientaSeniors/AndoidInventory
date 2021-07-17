package com.example.inventary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Fiadores extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fiadores);
    }
    public void agregarFiador(View view){
        Intent agregarFiador = new Intent(this, AgregarFiador.class);
        startActivity(agregarFiador);
    }
    public void visualizarFiador(View view){
        Intent visualizarFiador= new Intent(this, VisualizarFiador.class);
        startActivity(visualizarFiador);
    }
    public void editarFiador(View view){
        Intent editarFiador= new Intent();
    }
}