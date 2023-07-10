package com.example.zambrano_jose_ev_frecuente.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.zambrano_jose_ev_frecuente.Modelos.Producto;
import com.example.zambrano_jose_ev_frecuente.R;

import java.util.ArrayList;

public class AdaptadorProducto extends ArrayAdapter<Producto> {

    public AdaptadorProducto(Context context, ArrayList<Producto> data){
        super(context, R.layout.lyitemsproductos, data);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.lyitemsproductos, null);

        TextView lblNombreP = (TextView)item.findViewById(R.id.lblNombreProduct);
        lblNombreP.setText("Nombre del Producto: "+getItem(position).getTitle());

        TextView lblDescri = (TextView)item.findViewById(R.id.lblDescriptionProduct);
        lblDescri.setText("Descripción: " + getItem(position).getDescription());

        TextView lblCategory = (TextView)item.findViewById(R.id.lblCategory);
        lblCategory.setText("Categoría: " + getItem(position).getCategory());

        TextView lblPrice = (TextView)item.findViewById(R.id.lblPrice);
        lblPrice.setText("Precio: " + getItem(position).getPrice());

        ImageView imageView = (ImageView)item.findViewById(R.id.imgProduct);
        Glide.with(this.getContext()).load(getItem(position).getImage()).into(imageView);
        return(item);
    }
}
