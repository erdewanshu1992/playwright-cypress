//package com.flipkart.tests;
//
//import com.flipkart.base.BaseTest;
//import com.flipkart.pages.CartPage;
//import org.openqa.selenium.By;
//
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import java.io.IOException;
//
//public class CartPageTest extends BaseTest {
//
//    @Test
//    public void testAddToCartAndVerifyPrice() throws IOException {
//        // Step 1: Navigate to the CartPage
//        CartPage cartPage = new CartPage(driver);
//
//        // Step 2: Wait for the cart button to be visible and click it
//        By addToCartBtn = By.xpath("//button[text()='Add to cart']");
//        cartPage.waitForElementToBeVisible(addToCartBtn); // Wait for the element to be visible
//        cartPage.waitAndClick(addToCartBtn); // Click on the 'Add to cart' button
//
//        // Step 3: Capture screenshot after adding to cart
//        cartPage.takeScreenshot("screenshots/addToCart.png");
//
//        // Step 4: Get the price of the item in the cart
//        String cartPrice = cartPage.getCartPrice();
//        System.out.println("Cart Price: " + cartPrice);
//
//        // Step 5: Get the product name in the cart
//        String cartProductName = cartPage.getCartProductName();
//        System.out.println("Cart Product Name: " + cartProductName);
//
//        // Step 6: Capture screenshot after getting cart details
//        cartPage.takeScreenshot("screenshots/cartDetails.png");
//
//        // Step 7: Verify that the price is not empty and the product name is correct
//        Assert.assertNotNull(cartPrice, "Cart price should not be null");
//        Assert.assertTrue(cartProductName.contains("Product Name"), "Product name should match the expected value");
//
//        // Step 8: Get the current page URL
//        String currentUrl = cartPage.getCurrentUrl();
//        System.out.println("Current URL: " + currentUrl);
//
//        // Step 9: Get the page title
//        String pageTitle = cartPage.getPageTitle();
//        System.out.println("Page Title: " + pageTitle);
//
//        // Step 10: Navigate back to the previous page
//        cartPage.navigateBack();
//
//        // Step 11: Capture screenshot after navigating back
//        cartPage.takeScreenshot("screenshots/navigatedBack.png");
//
//        // Step 12: Navigate forward to the CartPage again
//        cartPage.navigateForward();
//
//        // Step 13: Capture screenshot after navigating forward
//        cartPage.takeScreenshot("screenshots/navigatedForward.png");
//
//        // Step 14: Close the browser
//        cartPage.closeBrowser();
//    }
//}
