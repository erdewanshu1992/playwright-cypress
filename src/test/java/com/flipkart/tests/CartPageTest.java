// com.flipkart.tests.CartPageTest.java
package com.flipkart.tests;

import com.flipkart.base.BaseTest;
import com.flipkart.pages.CartPage;
import org.testng.annotations.Test;

import java.io.IOException;

public class CartPageTest extends BaseTest {

    @Test
    public void testCartPageFeatures() throws IOException {
        CartPage cartPage = new CartPage(driver);

        cartPage.addToCart(); // Uses waitAndClick
        cartPage.scrollToCartItem(); // Uses scroll
        String price = cartPage.getCartPrice(); // Wait + getText
        String name = cartPage.getCartProductName(); // Wait + getText
        String title = cartPage.fetchCartPageTitle(); // Page title
        cartPage.captureCartScreenshot("screenshots/cartPage.png"); // Screenshot
        cartPage.goBackAndForward(); // Navigation

        System.out.println("Product: " + name + " | Price: " + price + " | Page Title: " + title);
    }
}
