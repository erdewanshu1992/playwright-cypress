package com.yesmadam.androidApp.utils;


import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class ScrollAll {
    private AndroidDriver<WebElement> driver;

    public ScrollAll(AndroidDriver<WebElement> driver) {
        this.driver = driver;
    }

    // Generic swipe method that takes direction and element locator as arguments
    public void swipeUntilElementVisible(By locator, String direction, int maxSwipes) {
        int swipes = 0;
        while (driver.findElements(locator).isEmpty() && swipes < maxSwipes) {
            switch (direction.toUpperCase()) {
                case "UP":
                    swipeUp();
                    break;
                case "DOWN":
                    swipeDown();
                    break;
                case "LEFT":
                    swipeLeft();
                    break;
                case "RIGHT":
                    swipeRight();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid swipe direction: " + direction);
            }
            swipes++;
        }

        if (swipes == maxSwipes && driver.findElements(locator).isEmpty()) {
            throw new RuntimeException("Element not found after swiping " + maxSwipes + " times in " + direction + " direction.");
        }
    }

    // Swipe up
    private void swipeUp() {
        new TouchAction(driver)
                .press(PointOption.point(500, 1500))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(500, 500))
                .release()
                .perform();
    }

    // Swipe down
    private void swipeDown() {
        new TouchAction(driver)
                .press(PointOption.point(500, 500))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(500, 1500))
                .release()
                .perform();
    }

    // Swipe left
    private void swipeLeft() {
        new TouchAction(driver)
                .press(PointOption.point(1500, 1000))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(500, 1000))
                .release()
                .perform();
    }

    // Swipe right
    private void swipeRight() {
        new TouchAction(driver)
                .press(PointOption.point(500, 1000))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(1500, 1000))
                .release()
                .perform();
    }
}


/*

How to Use:

Here’s how you would call this method for different swipe directions:

ScrollAll scrollAll = new ScrollAll(driver);

// Example for scrolling up until the element is found:
scrollAll.swipeUntilElementVisible(By.xpath("//android.widget.TextView[@text='MakeUp At Home']"), "UP", 5);

// Example for scrolling down until the element is found:
scrollAll.swipeUntilElementVisible(By.xpath("//android.widget.TextView[@text='Salon At Home']"), "DOWN", 5);

// Example for scrolling left until the element is found:
scrollAll.swipeUntilElementVisible(By.xpath("//android.widget.TextView[@text='Male Grooming']"), "LEFT", 5);

// Example for scrolling right until the element is found:
scrollAll.swipeUntilElementVisible(By.xpath("//android.widget.TextView[@text='Advance Facials']"), "RIGHT", 5);

 */