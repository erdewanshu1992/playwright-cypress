package com.yesmadam.androidApp.base;

// 1. BaseTest.java ➔ (Abstract Class, Setup/Teardown)

import com.yesmadam.androidApp.driver.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;


public abstract class BaseTest {

    public AndroidDriver<WebElement> driver;

    public void initializeDriver() {
        driver = DriverManager.createDriver();
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}

