// com.flipkart.pages.HomePage.java
package com.flipkart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    // Locators
    private By closeLoginPopup = By.xpath("//button[text()='✕']");
    private By searchInput = By.name("q");
    private By searchBtn = By.cssSelector("button[type='submit']");

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void closeLoginPopupIfPresent() {
        try {
            driver.findElement(closeLoginPopup).click();
        } catch (Exception e) {
            // Popup not present — safe to ignore
        }
    }

    public void enterSearch(String keyword) {
        driver.findElement(searchInput).sendKeys(keyword);
    }

    public void clickSearchButton() {
        driver.findElement(searchBtn).click();
    }

    public void searchFor(String keyword) {
        enterSearch(keyword);
        clickSearchButton();
    }
}
