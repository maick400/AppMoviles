package com.example.firstapp;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;

import java.util.HashMap;
import java.util.Map;

public class MainActivity2 extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView txtSaludo = (TextView) findViewById(R.id.txt_saludo);
        Bundle bundle = this.getIntent().getExtras();
        txtSaludo.setText("Hola!, Bienvenido \n " + "\n" +
                "NOMBRE: " + bundle.getString("NOMBRE") + "\n" +
                "APELLIDO: " + bundle.getString("APELLIDO") + "\n" +
                "USUARIO: " + bundle.getString("USUARIO") + "\n" +
                "GENERO: " + bundle.getString("GENERO") + "\n" +
                "NOTIFICACIONES: " + bundle.getString("NOTIFICACIONES") + "\n"
        );

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://revistas.uteq.edu.ec/ws/login.php?usr="
                + bundle.getString("USUARIO") + "&pass=" + bundle.getString("PASS");

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(MainActivity2.this, "Resp"+response, Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity2.this, "Resp"+error, Toast.LENGTH_SHORT).show();

                    }
                });

        queue.add(stringRequest);


 /*
        Bundle bndl = this.getIntent().getExtras();
        Map<String, String> datos = new HashMap<String, String>();
        com.example.myapplication.WebService.WebService ws= new com.example.myapplication.WebService.WebService(
                "https://revistas.uteq.edu.ec/ws/login.php?usr="
                        + bundle.getString("USUARIO") + "&pass=" + bundle.getString("PASS"),
                datos, MainActivity2.this, MainActivity2.this);
        ws.execute("GET");

    }
    @Override
    public void processFinish(String result) throws
            JSONException {
        Toast.makeText(this, "Resp"+result, Toast.LENGTH_SHORT).show();
    }
*/
    }
}