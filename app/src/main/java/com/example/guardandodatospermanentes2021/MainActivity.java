package com.example.guardandodatospermanentes2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textViewHora;
    EditText editTextNombre,editTextEdad;
    Button btnGuardar,btnRecuperar,btnBorrar,btnHora;
    static final String NOMBRE_FICHERO="DATOS";
    static final String NOMBRE="NOMBRE";
    static final String EDAD="EDAD";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNombre=findViewById(R.id.editTextNombre);
        btnBorrar=findViewById(R.id.btnBorrar);
        btnGuardar=findViewById(R.id.btnGuardar);
        btnRecuperar=findViewById(R.id.btnRecuperar);
        editTextEdad=findViewById(R.id.editTextEdad);
        textViewHora=findViewById(R.id.textViewHora);
        btnHora=findViewById(R.id.btnSeleccionarHora);


        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences misDatos=getSharedPreferences(NOMBRE_FICHERO,MODE_PRIVATE);
                //capturamos el editor
                SharedPreferences.Editor editor=misDatos.edit();

                //guardar datos
                editor.putString(NOMBRE,editTextNombre.getText().toString());
                editor.putInt(EDAD,Integer.parseInt(String.valueOf(editTextEdad)));

                //para guardar definitivamente
                editor.apply();
            }
        });

        btnRecuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences misDatos=getSharedPreferences(NOMBRE_FICHERO,MODE_PRIVATE);
                editTextNombre.setText(misDatos.getString(NOMBRE,"--sin guardar"));
                editTextEdad.setText(String.valueOf(misDatos.getInt(EDAD,0)));
            }
        });

        btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                SharedPreferences misDatos=getSharedPreferences(NOMBRE_FICHERO,MODE_PRIVATE);
                SharedPreferences.Editor editor = misDatos.edit();
                editor.clear();
                editor.apply();*/
                getSharedPreferences(NOMBRE_FICHERO,MODE_PRIVATE).edit().clear().apply();
            }
        });

        btnHora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}