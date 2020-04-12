package com.company;

public class Product {
    private final int id;
    private double price;
    private int quantity;

    public Product(int id, double price, int quantity) {
        this.id = id;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public void changePrice(double amount) {
        this.price += amount;

    }

    public int getQuantity() {
        return quantity;
    }

    public void changeQuantity(int amount) {
        this.quantity += amount;
    }

}
