package com.flipkart.pages;

import java.util.ArrayList;
import java.util.List;

public class GroceryOrderSystem {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Apples", "Perishable", 100, 6, 10, 0));
        products.add(new Product("Rice (5kg bag)", "Non-Perishable", 500, 4, 0, 5));
        products.add(new Product("Milk (1 liter)", "Perishable", 50, 10, 5, 0));

        double totalAmount = 0;
        Product highestCostProduct = null;
        double highestCost = 0;

        for (Product product : products) {
            double productTotal = product.calculateDiscountedTotal();
            totalAmount += productTotal;

            if (productTotal > highestCost) {
                highestCost = productTotal;
                highestCostProduct = product;
            }
        }

        if (highestCostProduct != null) {
            System.out.println("Product with the highest total cost after discounts: " + highestCostProduct.getName());
            System.out.println("Total amount to be paid by the customer: Rs. " + totalAmount);
        }
    }
}

