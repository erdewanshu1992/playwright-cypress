//package com.flipkart.tests;
//
//import com.flipkart.base.BaseTest;
//import com.flipkart.pages.HomePage;
//import com.flipkart.pages.CartPage;
//import com.flipkart.pages.FlightLoginPage;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import java.util.*;
//
//public class FlightBookingFlowTest extends BaseTest {
//    public static void main(String[] args) {
//        // 1. WebDriver Interface -> ChromeDriver Class
//        WebDriver driver = new ChromeDriver();
//
//        // 2. Launch app
//        driver.get("https://www.flipkart.com");
//
//        // 3. Login to app using POM
//        FlightLoginPage login = new FlightLoginPage(driver);
//        login.loginWithCredentials("your-email", "your-password");
//
//        // 4. Search/Add products using Set (to avoid duplicates)
//        Set<String> uniqueProducts = new HashSet<>();
//        Map<String, String> productWithPrice = new HashMap<>();
//
//        HomePage home = new HomePage(driver);
//        List<String> products = home.getAllProductNames();
//
//        for (String product : products) {
//            if (uniqueProducts.add(product)) {
//                home.searchProduct(product);
//                home.addToCart(product);
//
//                String price = home.getProductPrice(product);
//                productWithPrice.put(product, price);
//            }
//        }
//
//        // 5. Print products and prices
//        for (Map.Entry<String, String> entry : productWithPrice.entrySet()) {
//            System.out.println("Product: " + entry.getKey() + " | Price: " + entry.getValue());
//        }
//
//        // 6. Use POM to validate cart
//        CartPage cart = new CartPage(driver);
//        System.out.println("Cart contains: " + cart.getCartProductName());
//        System.out.println("Cart total: " + cart.getCartPrice());
//
//        // 7. Close browser
//        driver.quit();
//    }
//}
