package com.example.zambrano_jose_ev_frecuente;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetalleProductoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_producto);

        Bundle bundle= this.getIntent().getExtras();

        TextView lblNombreP = (TextView) findViewById(R.id.twnomb);
        lblNombreP.setText("Nombre del Producto: \n"+bundle.getString("tit"));

        TextView lblCategory = (TextView) findViewById(R.id.twCatego);
        lblCategory.setText("Categoría: \n" + bundle.getString("cat"));

        TextView lblPrice = (TextView) findViewById(R.id.twpric);
        lblPrice.setText("Total a Pagar: \n" + bundle.getString("pric"));

        ImageView imageView = (ImageView) findViewById(R.id.imageP);
        Glide.with(this).load(bundle.getString("port")).into(imageView);

    }
}