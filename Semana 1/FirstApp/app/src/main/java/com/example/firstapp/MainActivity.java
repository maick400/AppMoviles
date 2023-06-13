package com.example.firstapp;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.security.PublicKey;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void btn_enviar(View view){
        Toast.makeText(this.getApplicationContext(),"Has precionado el buton login", Toast.LENGTH_LONG).show();
        EditText editnombre =   (EditText) findViewById(R.id.ednombre);
        EditText editApellido =   (EditText) findViewById(R.id.edapellido);
        EditText etUsuario = (EditText) findViewById(R.id.edusuario);
        RadioButton rbtnGenero = (RadioButton)findViewById(R.id.rbtnMasculino);
        Switch swNotificacion = (Switch) findViewById(R.id.switch1);



        String nombre = editnombre.getText().toString();
        String apellido = editApellido.getText().toString();
        String usuario = etUsuario.getText().toString();
        String genero = rbtnGenero.isChecked()?"Masculino":"Femenino";
        String swith = swNotificacion.isChecked()?"SI":"NO";

        Toast.makeText(this.getApplicationContext(), "Hola, " + nombre+ " " + apellido +  " tu usuario es : "+ usuario + genero + swith, Toast.LENGTH_LONG).show();

        Intent intent = new Intent(MainActivity.this, MainActivity2.class);

        Bundle b  = new Bundle();
        b.putString("NOMBRE",nombre);
        b.putString("APELLIDO",apellido);
        b.putString("USUARIO",usuario);
        b.putString("GENERO",genero);
        b.putString("NOTIFICACIONES",swith);

    }

    public void saludo(View view){
       // EditText txtname = (EditText)findViewById(R.id.editTextText);

        //Toast.makeText(this.getApplicationContext(),"Hola como estas "+ txtname.getText().toString(), Toast.LENGTH_LONG).show();

    }


}