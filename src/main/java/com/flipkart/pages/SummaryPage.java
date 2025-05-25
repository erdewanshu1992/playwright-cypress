package com.flipkart.pages;

import com.flipkart.interfaces.ProductDetailsActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SummaryPage implements ProductDetailsActions {
    private WebDriver driver;

    private By title = By.cssSelector("span.B_NuCI");
    private By price = By.cssSelector("._30jeq3._16Jk6d");
    private By rating = By.cssSelector("._3LWZlK");

    public SummaryPage(WebDriver driver) {
        this.driver = driver;
    }

    // Implementing getTitle() from ProductDetailsActions interface
    @Override
    public String getTitle() {
        return driver.findElement(title).getText();
    }

    // Implementing getPrice() from ProductDetailsActions interface
    @Override
    public String getPrice() {
        return driver.findElement(price).getText();
    }

    // ✅ Getter method for rating
    public String getRating() {

        return driver.findElement(rating).getText();
    }
}
