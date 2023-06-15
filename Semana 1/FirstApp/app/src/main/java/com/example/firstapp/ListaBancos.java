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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import WebService.WebService;
import WebService.Asynchtask;


public class ListaBancos extends AppCompatActivity implements Asynchtask {
    TextView txtBancos = (TextView) findViewById(R.id.txtBancos);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_bancos);

        Map<String, String> datos = new HashMap<String, String>();
       /* WebService ws= new
                WebService("https://api-uat.kushkipagos.com/transfer-subscriptions/v1/bankList",
                datos, ListaBancos.this, ListaBancos.this);
        ws.execute("GET","Public-Merchant-Id","84e1d0de1fbf437e9779fd6a52a9ca18");
*/
        txtBancos.setText("Respuesta WS Lista de Bancos" );




    }

    public  String getApi(){
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="https://api-uat.kushkipagos.com/transfer-subscriptions/v1/bankList";
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
    }

    @Override
    public void processFinish(String result) throws JSONException{

        String lstBancos = "";
        JSONArray JSONlista = new JSONArray(result);

        for (int i = 0; i < JSONlista.length(); i++) {
            JSONObject banco = JSONlista.getJSONObject(i);
            lstBancos = lstBancos + "\n" +
                    banco.getString("code").toString()+ "_" +
            banco.getString("name").toString();
        }
        txtBancos.setText("Respuesta WS Lista de Bancos" + lstBancos);
    }

}