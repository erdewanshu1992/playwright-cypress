// com.flipkart.pages.SearchResultsPage.java
package com.flipkart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultsPage {
    private WebDriver driver;

    // Constructor
    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locator for all product titles
    private By productTitles = By.cssSelector("div._4rR01T"); // for laptops, etc.

    // Actions
    public List<WebElement> getAllProductTitles() {
        return driver.findElements(productTitles);
    }

    public String getFirstProductName() {
        return getAllProductTitles().get(0).getText();
    }

    public void printAllProductNames() {
        for (WebElement product : getAllProductTitles()) {
            System.out.println(product.getText());
        }
    }
}
