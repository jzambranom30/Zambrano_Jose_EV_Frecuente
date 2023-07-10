package com.example.zambrano_jose_ev_frecuente;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.zambrano_jose_ev_frecuente.Adaptadores.AdaptadorProducto;
import com.example.zambrano_jose_ev_frecuente.Modelos.Producto;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView LstOp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //VISTA
        LstOp = (ListView) findViewById(R.id.ListaProductos);
        View header = getLayoutInflater().inflate(R.layout.lyheader, null);
        LstOp.addHeaderView(header);
        LstOp.setOnItemClickListener(this);

        String url="https://fakestoreapi.com/products";

        RequestQueue que = Volley.newRequestQueue(this);

        StringRequest req = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                JSONArray JSONlistaproducto = null;
                try {
                    JSONlistaproducto = new JSONArray(response);
                    ArrayList<Producto> lstproduct = Producto.JsonObjectsBuild(JSONlistaproducto);
                    AdaptadorProducto adaptadorProducto = new AdaptadorProducto(MainActivity.this,lstproduct);
                    LstOp.setAdapter(adaptadorProducto);
                } catch (JSONException e) {
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        que.add(req);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Producto producto = (Producto) parent.getItemAtPosition(position);
        Intent intent = new Intent(MainActivity.this, DetalleProductoActivity.class);

        Bundle bundle = new Bundle();
        bundle.putString("tit",producto.getTitle().toString());
        bundle.putString("cat",producto.getCategory().toString());
        bundle.putString("pric",producto.getPrice().toString());
        bundle.putString("port",producto.getImage().toString());

        intent.putExtras(bundle);
        startActivity(intent);
    }
}