package com.example.matala3.models;

public class Product {
    private String id;
    private String name;
    private String price;
    private int stock;
    private int quantity;

    public Product() {}

    public Product(String id, String name, String price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.quantity =1;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPrice() { return price; }
    public void setPrice(String price) { this.price = price; }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }
    public int getQuantity() { return quantity; } // ✅ Getter for quantity
    public void setQuantity(int quantity) { this.quantity = quantity; }
}
