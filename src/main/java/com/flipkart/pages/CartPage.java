// com.flipkart.pages.CartPage.java
package com.flipkart.pages;

import com.flipkart.base.BasePage;
import com.flipkart.interfaces.CartActions;
import org.openqa.selenium.*;

import java.io.IOException;

public class CartPage extends BasePage implements CartActions {
    private By addToCartBtn = By.xpath("//button[text()='Add to cart']");
    private By cartPrice = By.cssSelector("._2-ut7f._1WpvJ7");
    private By cartItem = By.cssSelector("._2Kn22P");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void addToCart() {
        waitAndClick(addToCartBtn); // using BasePage's protected method internally
    }

    @Override
    public String getCartPrice() {
        waitForElementToBeVisible(cartPrice); // safe internal usage
        return driver.findElement(cartPrice).getText();
    }

    @Override
    public String getCartProductName() {
        waitForElementToBeVisible(cartItem);
        return driver.findElement(cartItem).getText();
    }

    // 👇 Public method for test to trigger screenshot
    public void captureCartScreenshot(String filePath) throws IOException, IOException {
        takeScreenshot(filePath);
    }

    // 👇 Public method to get page title
    public String fetchCartPageTitle() {
        return getPageTitle();
    }

    // 👇 Public method to scroll to cart item
    public void scrollToCartItem() {
        WebElement element = driver.findElement(cartItem);
        scrollToElement(element);
    }

    // 👇 Public method to test navigation
    public void goBackAndForward() {
        navigateBack();
        navigateForward();
    }
}








/*
// com.flipkart.pages.CartPage.java
package com.flipkart.pages;

import com.flipkart.base.BasePage;
import com.flipkart.interfaces.CartActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage implements CartActions {
    private By addToCartBtn = By.xpath("//button[text()='Add to cart']");
    private By cartPrice = By.cssSelector("._2-ut7f._1WpvJ7");
    private By cartItem = By.cssSelector("._2Kn22P");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void addToCart() {
        driver.findElement(addToCartBtn).click();
    }

    @Override
    public String getCartPrice() {
        return driver.findElement(cartPrice).getText();
    }

    @Override
    public String getCartProductName() {
        return driver.findElement(cartItem).getText();
    }
}
*/













/*
package com.flipkart.pages;

import com.flipkart.interfaces.CartActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage implements CartActions {
    private WebDriver driver;

    // Private locators (Encapsulation)
    private By addToCartBtn = By.xpath("//button[text()='Add to cart']");
    private By cartPrice = By.cssSelector("._2-ut7f._1WpvJ7");
    private By cartItem = By.cssSelector("._2Kn22P");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    // ✅ Interface method (acts like controlled setter in UI sense)
    @Override
    public void addToCart() {
        driver.findElement(addToCartBtn).click();
    }

    // ✅ Getter for cart price
    @Override
    public String getCartPrice() {
        return driver.findElement(cartPrice).getText();
    }

    // ✅ Getter for product name from cart
    @Override
    public String getCartProductName() {
        return driver.findElement(cartItem).getText();
    }
}
*/










/*
// com.flipkart.pages.CartPage.java
package com.flipkart.pages;

import com.flipkart.interfaces.CartActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage implements CartActions {
    private WebDriver driver;

    private By addToCartBtn = By.xpath("//button[text()='Add to cart']");
    private By cartPrice = By.cssSelector("._2-ut7f._1WpvJ7");
    private By cartItem = By.cssSelector("._2Kn22P");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public void addToCart() {
        driver.findElement(addToCartBtn).click();
    }

    @Override
    public String getCartPrice() {
        return driver.findElement(cartPrice).getText();
    }

    @Override
    public String getCartProductName() {
        return driver.findElement(cartItem).getText();
    }
}

 */
