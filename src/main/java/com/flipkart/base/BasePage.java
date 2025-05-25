// com.flipkart.base.BasePage.java
/*
In Summary:

    BasePage: Common reusable actions jaise wait, scroll, etc. define karta hai. Yeh abstract class hai, jo page classes ko extend karke use hoti hai.

    BaseTest: Test setup aur teardown provide karta hai. WebDriver initialization aur termination yahan manage hota hai.

    DriverManager: WebDriver ka creation aur termination manage karta hai. Singleton pattern follow karta hai jisse ki ek hi WebDriver instance globally accessible ho.

Is tarah, yeh tino classes test automation framework ke structure ko modular aur reusable banane ke liye use hoti hain.
 */
package com.flipkart.base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
    }

    // Wait for element to be visible
    protected void waitForElementToBeVisible(By locator) {
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Wait and click on element
    protected void waitAndClick(By locator) {
        WebElement element = new WebDriverWait(driver, 20)
                .until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    // Get text of element with wait
    protected String waitForTextToAppear(By locator) {
        WebElement element = new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element.getText();
    }

    // Scroll to element
    protected void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    // Handle alert
    protected void handleAlert() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    // Get attribute of element
    protected String getElementAttribute(By locator, String attribute) {
        WebElement element = driver.findElement(locator);
        return element.getAttribute(attribute);
    }

    // Take screenshot
    protected void takeScreenshot(String filePath) throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File source = screenshot.getScreenshotAs(OutputType.FILE);
        File destination = new File(filePath);
        FileUtils.copyFile(source, destination);
    }

    // Get current URL
    protected String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    // Get page title
    protected String getPageTitle() {
        return driver.getTitle();
    }

    // Close browser
    protected void closeBrowser() {
        driver.close();
    }

    // Navigate back
    protected void navigateBack() {
        driver.navigate().back();
    }

    // Navigate forward
    protected void navigateForward() {
        driver.navigate().forward();
    }
}

