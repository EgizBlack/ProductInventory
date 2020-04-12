package com.company;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;

public class Inventory {

    private Map<Integer, Product> inventory;

    public Inventory() {
        this.inventory = new HashMap<>();
    }

    public void addItem(Product product){
        if (inventory.containsKey(product.getId())){
            System.out.println("Product with this id all ready exists");
        } else {
        inventory.put(product.getId(),product);
        }
    }

    public void removeItem(int id){
        inventory.remove(id);
    }

    public void changePrice( int id ,double amount){
        if ((inventory.get(id).getPrice() - amount) < 0){
            inventory.get(id).changePrice(amount);
        } else {
            System.out.println("Price cant be less than 0");
        }
    }

    public void changeQuantity(int id, int amount){
        inventory.get(id).changeQuantity(amount);
    }

    public boolean checkIfExists(int id){
        return !inventory.containsKey(id);
    }

    public void printInventoryValue(){
        double value = 0;
        for (Product product : inventory.values()){
            value += (inventory.get(product.getId()).getPrice() * inventory.get(product.getId()).getQuantity());
        }
        System.out.println("Inventory value: " + NumberFormat.getCurrencyInstance().format(value));
    }

    public void printAllProducts(){
        for (Product product : inventory.values()){
            System.out.println("-------------------------");
            System.out.println("Product id: " + product.getId());
            System.out.println("Product Price: " + NumberFormat.getCurrencyInstance().format(product.getPrice()));
            System.out.println("Product Stock: " + product.getQuantity());
            System.out.println("-------------------------");
            System.out.println();
        }
    }

    public void printProduct(int id){
        if (!inventory.containsKey(id)) {
            System.out.println("Product doesn't exist");
        } else {
            System.out.println("Product id: " + inventory.get(id).getId());
            System.out.println("Product price: " + NumberFormat.getCurrencyInstance().format(inventory.get(id).getPrice()));
            System.out.println("Product items in inventory: " + inventory.get(id).getQuantity());
        }
    }
}
