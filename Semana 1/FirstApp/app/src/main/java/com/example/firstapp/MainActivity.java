package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
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

    }

    public void saludo(View view){
        EditText txtname = (EditText)findViewById(R.id.editTextText);

        Toast.makeText(this.getApplicationContext(),"Hola como estas "+ txtname.getText().toString(), Toast.LENGTH_LONG).show();

    }


}