package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class ControlesBasicos extends AppCompatActivity {
    EditText txtCedula ,txtNombres, datFecha, txtCiudad , txtXCorreo, txtTelefono ;
    RadioButton rbtnGenero;
    RadioGroup rdbtnGenero ;

    String cedula, nombres, fecha_nacimiento, ciudad, genero, correo, telefono;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_controles_basicos);




    }

    public void register (View view){
        rdbtnGenero = (RadioGroup) findViewById(R.id.rbtnGenero);
        txtCedula = (EditText) findViewById(R.id.txtCedula);
        txtNombres = (EditText) findViewById(R.id.txtNombres);
        datFecha = (EditText) findViewById(R.id.datFechaNa);
        txtCiudad = (EditText) findViewById(R.id.txtCiudad);
        rbtnGenero = (RadioButton) findViewById(R.id.rbMas);
        txtXCorreo = (EditText) findViewById(R.id.txtCorreo);
        txtTelefono = (EditText) findViewById(R.id.txtTeléfono);

        cedula = txtCedula.getText().toString();
        nombres = txtNombres.getText().toString();
        fecha_nacimiento = datFecha.getText().toString();
        genero = rbtnGenero.isChecked()?"Masculino":"Femenino";
        ciudad = txtCiudad.getText().toString();
        correo=txtXCorreo.getText().toString();
        telefono = txtTelefono.getText().toString();

        if (validar()){
            Intent intent = new Intent(ControlesBasicos.this, Inicio.class);
            Bundle b  = new Bundle();
            b.putString("CEDULA",cedula);
            b.putString("NOMBRES",nombres);
            b.putString("FECHA",fecha_nacimiento);
            b.putString("CIUDAD",ciudad);
            b.putString("GENERO",genero);
            b.putString("CORREO",correo);
            b.putString("TELEFONO",telefono);

            intent.putExtras(b);
            startActivity(intent);
        }


    }

    public  Boolean validar(){
        if(cedula.isEmpty()){
            Toast.makeText(this.getApplicationContext(), "El campo cedula es obligatorio", Toast.LENGTH_LONG).show();
            return false;
        }

        else if(nombres.isEmpty()){
            Toast.makeText(this.getApplicationContext(), "El campo nombres es obligatorio", Toast.LENGTH_LONG).show();
            return false;
        }

        else if(fecha_nacimiento.isEmpty()){
            Toast.makeText(this.getApplicationContext(), "La fecha de nacimiento es obligatoria", Toast.LENGTH_LONG).show();
            return false;
        }

        else if(correo.isEmpty()){
            Toast.makeText(this.getApplicationContext(), "El campo correo es obligatorio", Toast.LENGTH_LONG).show();
            return false;
        }

        else if(telefono.isEmpty()){
            Toast.makeText(this.getApplicationContext(), "El campo telefono es obligatorio", Toast.LENGTH_LONG).show();
            return false;
        }

        else if(ciudad.isEmpty()){
            Toast.makeText(this.getApplicationContext(), "El campo ciudad es obligatorio", Toast.LENGTH_LONG).show();
            return false;
        }

        else {

                Toast.makeText(this.getApplicationContext(), "Campos correctos", Toast.LENGTH_LONG).show();
                return true;
        }

    }



    public void clear_Data(View view){
        txtCedula.setText("");
        txtNombres.setText("");
        datFecha.setText("");
        txtCiudad.setText("");
        rdbtnGenero.clearCheck();
        txtXCorreo.setText("");
        txtTelefono.setText("");
    }
}


