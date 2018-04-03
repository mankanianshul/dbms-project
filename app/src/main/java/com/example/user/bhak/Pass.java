package com.example.user.bhak;

/**
 * Created by User on 4/6/2017.
 */

public class Pass {

    String description, color, price,stock,id;

    public Pass(String id,String description, String color, String price,String stock) {
        this.description = description;
        this.color = color;
        this.price = price;
        this.stock=stock;
        this.id=id;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getColor() {
        return color;
    }

    public String getPrice() {
        return price;
    }

    public String getStock() {
        return stock;
    }
}
