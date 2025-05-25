// com.flipkart.base.BaseTest.java
/*
In Summary:

    BasePage: Common reusable actions jaise wait, scroll, etc. define karta hai. Yeh abstract class hai, jo page classes ko extend karke use hoti hai.

    BaseTest: Test setup aur teardown provide karta hai. WebDriver initialization aur termination yahan manage hota hai.

    DriverManager: WebDriver ka creation aur termination manage karta hai. Singleton pattern follow karta hai jisse ki ek hi WebDriver instance globally accessible ho.

Is tarah, yeh tino classes test automation framework ke structure ko modular aur reusable banane ke liye use hoti hain.
 */
package com.flipkart.base;

import com.flipkart.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setup() {
        DriverManager.createDriver();
        driver = DriverManager.getDriver();
        driver.manage().window().maximize();
    }


}









/*
package com.flipkart.base;

import com.flipkart.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = DriverManager.getDriver();
        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com");
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }
}

 */













//package com.flipkart.base;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.*;
//
//public class BaseTest {
//    protected WebDriver driver;
//
//    @BeforeMethod
//    public void setup() {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//    }
//
//    @AfterMethod
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
//}
