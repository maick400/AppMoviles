package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import WebService.WebService;
import WebService.Asynchtask;


public class Login extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webservicelogin);

    }

    public  void login(View view){
        EditText txtUsuario = (EditText) findViewById(R.id.txt_user);
        EditText txtPassword = (EditText) findViewById(R.id.txt_pass);

        String usuario = txtUsuario.getText().toString();
        String password = txtPassword.getText().toString();

        Intent intent = new Intent(Login.this, home.class);

        Bundle b  = new Bundle();
        b.putString("USUARIO",usuario);

        intent.putExtras(b);
        startActivity(intent);
    }




}