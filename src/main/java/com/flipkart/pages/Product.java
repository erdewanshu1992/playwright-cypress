package com.flipkart.pages;

class Product {
    private String name;
    private String category;
    private double pricePerUnit;
    private int quantity;
    private double bulkDiscount;
    private double nonPerishableDiscount;

    public Product(String name, String category, double pricePerUnit, int quantity, double bulkDiscount, double nonPerishableDiscount) {
        this.name = name;
        this.category = category;
        this.pricePerUnit = pricePerUnit;
        this.quantity = quantity;
        this.bulkDiscount = bulkDiscount;
        this.nonPerishableDiscount = nonPerishableDiscount;
    }

    public String getName() {
        return name;
    }

    public double calculateDiscountedTotal() {
        double total = pricePerUnit * quantity;

        // Apply bulk discount if Perishable and quantity > 5
        if (category.equals("Perishable") && quantity > 5) {
            total -= total * (bulkDiscount / 100);
        }

        // Apply Non-Perishable discount if total > 2000
        if (category.equals("Non-Perishable") && total > 2000) {
            total -= total * (nonPerishableDiscount / 100);
        }

        return total;
    }
}

