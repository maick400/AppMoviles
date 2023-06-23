package com.example.firstapp;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import WebService.WebService;
import WebService.Asynchtask;


public class ListaBancos extends AppCompatActivity implements Asynchtask {
    String token;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_bancos);


    }


    public  void  login (View view){
        EditText tuser =   (EditText) findViewById(R.id.temail);
        EditText tpass = (EditText) findViewById(R.id.tpass);

        String user = tuser.getText().toString();
        String pass = tpass.getText().toString();



        Map<String, String> datos = new HashMap<String, String>();
        datos.put("correo",user);
        datos.put("clave",pass);

        WebService ws= new
                WebService("https://api.uealecpeterson.net/public/login",
                datos, ListaBancos.this, ListaBancos.this);
        ws.execute("POST");


        Intent intent = new Intent(ListaBancos.this, home.class);
        Bundle b  = new Bundle();
        b.putString("TOKEN",token);
        b.putString("USER",user);
        b.putString("PASS",pass);


        startActivity(intent);

    }
/*
    public  String getApi(){
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://www.google.com";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        txtBancos.setText("Response is: "+ response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }

                });
    }*/

    @Override
    public void processFinish(String result) throws JSONException{
        JSONObject jsonObject = new JSONObject(result);
        String token  = jsonObject.getString("access_token");
        this.token = token;
        Toast.makeText(ListaBancos.this,  token, Toast.LENGTH_SHORT).show();

    }

}