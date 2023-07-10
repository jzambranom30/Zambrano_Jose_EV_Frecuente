package com.example.zambrano_jose_ev_frecuente.Modelos;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Producto {
    private String title;
    private String description;
    private String price;
    private String category;
    private String image;

    public Producto(JSONObject jsondata) throws JSONException {
        title = jsondata.getString("title");
        description = jsondata.getString("description");
        price = jsondata.getString("price");
        category = jsondata.getString("category");
        image = jsondata.getString("image");
    }

    public static ArrayList<Producto> JsonObjectsBuild(JSONArray jsondato) throws JSONException {
        ArrayList<Producto> products = new ArrayList<>();
        for (int i = 0; i < jsondato.length() && i<20; i++) {
            products.add(new Producto(jsondato.getJSONObject(i)));
        }
        return products;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
