package com.example.inventary;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.telephony.mbms.MbmsErrors;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class VisualizarFiador extends AppCompatActivity {
    private ArrayList<Fiador> fiadores= new ArrayList<Fiador>();
    private ArrayList<Fiador> fiadoresCargar = new ArrayList<Fiador>();
    private Spinner spinFiadores;
    private TextView textNombre;
    private String nombre;
    private ArrayList<String> listaFiadores = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar_fiador);
        cargarDatos();
        spinFiadores = (Spinner) findViewById(R.id.s_fiadores);
        textNombre = (TextView) findViewById(R.id.tv_nombreFiador);
        for(int i = 0; i<=fiadores.size()-1;i++){
            listaFiadores.add(i,fiadores.get(i).getNombre());
        }
        ArrayAdapter<String> spinAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,listaFiadores);
        spinFiadores.setAdapter(spinAdapter);
        spinFiadores.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ArrayList<Producto> productosFiador = fiadores.get(i).getProductos();
                init(productosFiador,i);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }


    public void cargarDatos(){
        try {
            FileInputStream fin = openFileInput("fiad.dat");

            // Wrapping our stream
            ObjectInputStream oin = new ObjectInputStream(fin);

            // Reading in our object
            fiadores = (ArrayList<Fiador>) oin.readObject();
            // Closing our object stream which also closes the wrapped stream.
            oin.close();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void init(ArrayList<Producto> productosFiador, int numFiador) {
        TableLayout stk = (TableLayout) findViewById(R.id.t_productosFiados);
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
        tv4.setText(" Total ");
        tv4.setTextColor(Color.WHITE);
        tbrow0.addView(tv4);
        TextView tv5 = new TextView(this);
        tv5.setText(" Pagado ");
        tv5.setTextColor(Color.WHITE);
        tbrow0.addView(tv5);

        stk.addView(tbrow0);

        for (int i = 0; i <= productosFiador.size()-1; i++) {
            TableRow tbrow = new TableRow(this);
            TextView t1v = new TextView(this);
            t1v.setText("" + i);
            t1v.setTextColor(Color.WHITE);
            t1v.setGravity(Gravity.CENTER);
            tbrow.addView(t1v);
            TextView t2v = new TextView(this);
            t2v.setText(productosFiador.get(i).getNombre());
            t2v.setTextColor(Color.WHITE);
            t2v.setGravity(Gravity.CENTER);
            tbrow.addView(t2v);
            TextView t3v = new TextView(this);
            t3v.setText(productosFiador.get(i).getTipo());
            t3v.setTextColor(Color.WHITE);
            t3v.setGravity(Gravity.CENTER);
            tbrow.addView(t3v);
            TextView t4v = new TextView(this);
            t4v.setText(String.valueOf(productosFiador.get(i).getPrecio()));
            t4v.setTextColor(Color.WHITE);
            t4v.setGravity(Gravity.CENTER);
            tbrow.addView(t4v);
            if(i==0){
                TextView t5v = new TextView(this);
                t5v.setText(String.valueOf(fiadores.get(numFiador).getDeudaTotal()));
                t5v.setTextColor(Color.WHITE);
                t5v.setGravity(Gravity.CENTER);
                tbrow.addView(t5v);
                TextView t6v = new TextView(this);
                t6v.setText(String.valueOf(fiadores.get(numFiador).getPagado()));
                t6v.setTextColor(Color.WHITE);
                t6v.setGravity(Gravity.CENTER);
                tbrow.addView(t6v);

            }
            stk.addView(tbrow);
        }


    }
}