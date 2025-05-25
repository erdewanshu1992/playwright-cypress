package com.flipkart.pages;

import com.flipkart.interfaces.ProductDetailsActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage implements ProductDetailsActions {
    private WebDriver driver;

    // Private locators (data hiding — encapsulation)
    private By title = By.cssSelector("span.B_NuCI");
    private By price = By.cssSelector("._30jeq3._16Jk6d");
    private By rating = By.cssSelector("._3LWZlK");
    private By addToCartBtn = By.xpath("//button[text()='Add to cart']");

    public ProductDetailPage(WebDriver driver) {
        this.driver = driver;
    }

    // ✅ Getter method for title
    public String getTitle() {
        return driver.findElement(title).getText();
    }

    // ✅ Getter method for price
    public String getPrice() {
        return driver.findElement(price).getText();
    }

    // ✅ Getter method for rating
    public String getRating() {
        return driver.findElement(rating).getText();
    }

}













/*
// com.flipkart.pages.ProductDetailPage.java
package com.flipkart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage {
    private WebDriver driver;

    private By title = By.cssSelector("span.B_NuCI");
    private By price = By.cssSelector("._30jeq3._16Jk6d");
    private By rating = By.cssSelector("._3LWZlK");

    public ProductDetailPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        return driver.findElement(title).getText();
    }

    public String getPrice() {
        return driver.findElement(price).getText();
    }

    public String getRating() {
        return driver.findElement(rating).getText();
    }
}

 */
