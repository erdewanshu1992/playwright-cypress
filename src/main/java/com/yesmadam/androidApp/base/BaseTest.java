package com.yesmadam.androidApp.base;
// 2. Abstract Class - BaseTest.java

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class BaseTest {

    protected AndroidDriver<WebElement> driver;

    public void setUp() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("automationName", "UiAutomator2");
        cap.setCapability("deviceName", "Pixel 5");
        cap.setCapability("platformName", "Android");
        cap.setCapability("appPackage", "yesmadamservices.app.com.yesmadamservices");
        cap.setCapability("appActivity", "yesmadamservices.app.com.yesmadamservices.MainActivity");
        cap.setCapability("noReset", true);

        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/"), cap);
    }
}
