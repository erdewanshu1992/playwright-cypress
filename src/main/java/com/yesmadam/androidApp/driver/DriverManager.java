package com.yesmadam.androidApp.driver;
// 2. DriverManager.java ➔ (Encapsulate Driver Creation)

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {

    public static AndroidDriver<WebElement> createDriver() {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("automationName", "UiAutomator2");
        cap.setCapability("deviceName", "Pixel 5");
        cap.setCapability("platformName", "Android");
        cap.setCapability("appPackage", "yesmadamservices.app.com.yesmadamservices");
        cap.setCapability("appActivity", "yesmadamservices.app.com.yesmadamservices.MainActivity");
        cap.setCapability("noReset", true);

        AndroidDriver<WebElement> driver;
        try {
            driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/"), cap);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Appium server URL is incorrect", e);
        }
        return driver;
    }

}
