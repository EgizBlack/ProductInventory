package com.company;

import java.util.Scanner;

public class Console {

    Scanner scanner;
    Inventory inventory;

    public Console(Inventory inventory) {
        this.scanner =  new Scanner(System.in);
        this.inventory = inventory;
    }

    private double getInput(){

        double input = 0;
        boolean isValid = true;
        while (isValid) {
            try {
                String inputSting = scanner.next();
                input = Double.parseDouble(inputSting);
                isValid = false;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input!");
                System.out.println("Try Again");
                System.out.print(">> ");
            }
        }


        return input;
    }

    public void run() {

        boolean quitFlag = true;

        while (quitFlag) {
            System.out.println();
            System.out.println("-------------------------------------------");
            System.out.println("Print all products: enter 1");
            System.out.println("Print single product: enter 2");
            System.out.println("Print value of entire inventory: enter 3");
            System.out.println("Add a product: enter 4");
            System.out.println("Remove a product: enter 5");
            System.out.println("Change price of a product: enter 6");
            System.out.println("Change stock of a product: enter 7");
            System.out.println("Exit application: enter 8");
            System.out.println("-------------------------------------------");
            System.out.println();
            System.out.print(">> ");

            int res = (int)getInput();

            System.out.println();
            switch (res) {
                case 1 -> {
                    System.out.println("---------------------------");
                    inventory.printAllProducts();
                    System.out.println("---------------------------");
                }
                case 2 -> {
                    System.out.println("Enter id of product:");
                    System.out.print(">> ");
                    inventory.printProduct((int) getInput());
                    System.out.println();
                }
                case 3 -> {
                    System.out.println();
                    inventory.printInventoryValue();
                    System.out.println();
                }
                case 4 -> {
                    System.out.println("Enter id of product:");
                    System.out.print(">> ");
                    int id = (int) getInput();
                    if (inventory.checkIfExists(id)) {
                        System.out.println("Enter price of product:");
                        System.out.print(">> ");
                        double price = getInput();
                        System.out.println("Enter quantity of product in storage:");
                        System.out.print(">> ");
                        int quantity = (int) getInput();
                        inventory.addItem(new Product(id, price, quantity));
                        System.out.println();
                        System.out.println("-----------------");
                        System.out.println("Product added: ");
                        System.out.println();
                        inventory.printProduct(id);
                        System.out.println();
                    } else {
                        System.out.println("Item all ready exists");
                    }
                }
                case 5 -> {
                    System.out.println("Enter id of product:");
                    System.out.print(">> ");
                    int id4 = (int) getInput();
                    inventory.removeItem(id4);
                    System.out.println();
                    System.out.println("Product removed");
                    System.out.println();
                }
                case 6 -> {
                    System.out.println("Enter id of product:");
                    System.out.print(">> ");
                    int id2 = (int) getInput();
                    System.out.println("Enter by how much you want to change price: ");
                    System.out.print(">> ");
                    double priceChange = getInput();
                    inventory.changePrice(id2, priceChange);
                    System.out.println();
                    System.out.println("Price Changed");
                    System.out.println();
                    inventory.printProduct(id2);
                    System.out.println();
                }
                case 7 -> {
                    System.out.println("Enter id of product:");
                    System.out.print(">> ");
                    int id3 = (int) getInput();
                    System.out.println("Enter how much you want to change stock:");
                    System.out.print(">> ");
                    int stockChange = (int) getInput();
                    inventory.changeQuantity(id3, stockChange);
                    System.out.println();
                    System.out.println("Stock changed");
                    inventory.printProduct(id3);
                    System.out.println();
                    System.out.println();
                }
                case 8 -> {
                    System.out.println("Goodbye!");
                    quitFlag = false;
                }
            }
        }

    }
}
