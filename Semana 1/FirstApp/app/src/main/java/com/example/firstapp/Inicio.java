package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Inicio extends AppCompatActivity {
    String cedula, nombres, fecha_nacimiento, ciudad, genero, correo, telefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        TextView txtInfo = (TextView) findViewById(R.id.welcome) ;

        Bundle bundle = this.getIntent().getExtras();

        cedula = bundle.getString("CEDULA");
        nombres =  bundle.getString("NOMBRES");
        fecha_nacimiento  =  bundle.getString("FECHA");
        ciudad =  bundle.getString("CIUDAD");
        genero =  bundle.getString("GENERO");
        correo=  bundle.getString("CORREO");
        telefono=  bundle.getString("TELEFONO");

        txtInfo.setText(
                "Cédula:  " + cedula + "\n" +
                "Nombres:  " + nombres + "\n" +
                "Fecha:  " + fecha_nacimiento + "\n" +
                "Ciudad:  " + ciudad + "\n" +
                "Género:  " + genero + "\n" +
                "Email:  " + correo + "\n" +
                "Teléfono:  " + telefono + "\n"
                );


    }
}