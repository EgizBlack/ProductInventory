package com.company;

public class Main {
    
    public static void main(String[] args) {

        var inventory = new Inventory();

        inventory.addItem(new Product(1,2F,20));
        inventory.addItem(new Product(2,4F,50));
        inventory.addItem(new Product(3,1F,50));
        inventory.addItem(new Product(4,1F,50));

        var console = new Console(inventory);
        console.run();

    }

}
