// com.flipkart.tests.FlipkartTest.java
package com.flipkart.tests;

import com.flipkart.base.BaseTest;
import com.flipkart.pages.*;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class FlipkartTest extends BaseTest {

    @Test
    public void fullUserFlow() {
        driver.get("https://www.flipkart.com");

        // Close login popup
        try {
            driver.findElement(By.xpath("//button[text()='✕']")).click();
        } catch (Exception ignored) {}

        // Step 1: Search
        SearchPage searchPage = new SearchPage(driver);
        searchPage.search("iPhone 13");

        // Step 2: Click product
        driver.findElement(By.cssSelector("._4rR01T")).click();

        // Step 3: Switch to new tab
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }

        // Step 4: Get product details
        ProductDetailPage productDetailPage = new ProductDetailPage(driver);
        System.out.println("Title: " + productDetailPage.getTitle());
        System.out.println("Price: " + productDetailPage.getPrice());
        System.out.println("Rating: " + productDetailPage.getRating());

        // Step 5: Add to cart
        CartPage cartPage = new CartPage(driver);
        cartPage.addToCart();
        System.out.println("Cart Price: " + cartPage.getCartPrice());
        System.out.println("Cart Product: " + cartPage.getCartProductName());
    }
}
