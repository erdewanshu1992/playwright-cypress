// com.flipkart.pages.SearchPage.java
package com.flipkart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {
    private WebDriver driver;
    private By searchBox = By.name("q");
    private By searchBtn = By.cssSelector("button[type='submit']");

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void search(String keyword) {
        driver.findElement(searchBox).sendKeys(keyword);
        driver.findElement(searchBtn).click();
    }
}
