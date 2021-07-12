package com.example.inventary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TableLayout;

public class VisualizarProducto extends AppCompatActivity {
private TableLayout tabla1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar_producto);
        tabla1 =(TableLayout)findViewById(R.id.TableLayout1);

    }
}