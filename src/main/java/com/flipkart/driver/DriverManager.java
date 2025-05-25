// com.flipkart.driver.DriverManager.java

/*
In Summary:

    BasePage: Common reusable actions jaise wait, scroll, etc. define karta hai. Yeh abstract class hai, jo page classes ko extend karke use hoti hai.

    BaseTest: Test setup aur teardown provide karta hai. WebDriver initialization aur termination yahan manage hota hai.

    DriverManager: WebDriver ka creation aur termination manage karta hai. Singleton pattern follow karta hai jisse ki ek hi WebDriver instance globally accessible ho.

Is tarah, yeh tino classes test automation framework ke structure ko modular aur reusable banane ke liye use hoti hain.
 */

/*
package com.flipkart.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
    private static WebDriver driver;

    private DriverManager() {
        // Private constructor to prevent instantiation
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}

 */

package com.flipkart.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
    private static WebDriver driver;

    private DriverManager() {
        // Prevent instantiation
    }

    public static void createDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            throw new IllegalStateException("WebDriver not initialized. Call createDriver() first.");
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}

