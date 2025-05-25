package com.yesmadam.androidApp.utils;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class ScrollUtils {
    private final AndroidDriver<WebElement> driver;

    // Configurable parameters
    private Duration swipeDuration;  // how long the swipe action takes
    private int maxSwipes;           // how many times to attempt before giving up

    /**
     * @param driver        your AndroidDriver instance
     * @param swipeDuration how long each swipe should last (e.g. Duration.ofMillis(500))
     * @param maxSwipes     maximum swipe attempts in swipeUntilElementVisible
     */
    public ScrollUtils(AndroidDriver<WebElement> driver, Duration swipeDuration, int maxSwipes) {
        this.driver        = driver;
        this.swipeDuration = swipeDuration;
        this.maxSwipes     = maxSwipes;
    }

    /** Optional: change swipe speed at runtime */
    public void setSwipeDuration(Duration swipeDuration) {
        this.swipeDuration = swipeDuration;
    }

    /** Optional: change max swipe attempts at runtime */
    public void setMaxSwipes(int maxSwipes) {
        this.maxSwipes = maxSwipes;
    }

    /** Generic: swipe until element located or attempts exhausted */
    public void swipeUntilElementVisible(By locator, String direction) {
        int attempts = 0;
        while (driver.findElements(locator).isEmpty() && attempts < maxSwipes) {
            swipe(direction);
            attempts++;
        }
        if (attempts == maxSwipes && driver.findElements(locator).isEmpty()) {
            throw new RuntimeException(
                    "Element " + locator +
                            " not found after " + maxSwipes + " swipes " + direction
            );
        }
    }

    /** Chooses swipe method based on direction */
    private void swipe(String direction) {
        switch (direction.toUpperCase()) {
            case "UP":    swipeUp();    break;
            case "DOWN":  swipeDown();  break;
            case "LEFT":  swipeLeft();  break;
            case "RIGHT": swipeRight(); break;
            default: throw new IllegalArgumentException("Unknown swipe direction: " + direction);
        }
    }

    private void swipeUp() {
        Dimension size = driver.manage().window().getSize();
        int x    = size.width  / 2;
        int startY = (int)(size.height * 0.2);
        int endY   = (int)(size.height * 0.8);

        new TouchAction<>(driver)
                .press(PointOption.point(x, startY))
                .waitAction(WaitOptions.waitOptions(swipeDuration))
                .moveTo(PointOption.point(x, endY))
                .release()
                .perform();
    }

    private void swipeDown() {
        Dimension size = driver.manage().window().getSize();
        int x     = size.width  / 2;
        int startY = (int)(size.height * 0.8);
        int endY   = (int)(size.height * 0.2);

        new TouchAction<>(driver)
                .press(PointOption.point(x, startY))
                .waitAction(WaitOptions.waitOptions(swipeDuration))
                .moveTo(PointOption.point(x, endY))
                .release()
                .perform();
    }

    private void swipeLeft() {
        Dimension size = driver.manage().window().getSize();
        int y     = size.height / 2;
        int startX = (int)(size.width * 0.8);
        int endX   = (int)(size.width * 0.2);

        new TouchAction<>(driver)
                .press(PointOption.point(startX, y))
                .waitAction(WaitOptions.waitOptions(swipeDuration))
                .moveTo(PointOption.point(endX, y))
                .release()
                .perform();
    }

    private void swipeRight() {
        Dimension size = driver.manage().window().getSize();
        int y     = size.height / 2;
        int startX = (int)(size.width * 0.2);
        int endX   = (int)(size.width * 0.8);

        new TouchAction<>(driver)
                .press(PointOption.point(startX, y))
                .waitAction(WaitOptions.waitOptions(swipeDuration))
                .moveTo(PointOption.point(endX, y))
                .release()
                .perform();
    }

    public void scrollToText(String text, String direction) {
        By dynamicTextLocator = By.xpath("//*[contains(@text, '" + text + "') or contains(@name, '" + text + "')]");
        swipeUntilElementVisible(dynamicTextLocator, direction);
    }

    public void swipeUntilElementsVisible(By locator, String direction) {
        int attempt = 0;
        while (attempt < maxSwipes) {
            try {
                // Swipe logic here depending on direction (UP, DOWN, LEFT, RIGHT)
                if (direction.equalsIgnoreCase("UP")) {
                    // Swipe up logic
                } else if (direction.equalsIgnoreCase("DOWN")) {
                    // Swipe down logic
                }

                // Check if the element is visible
                WebElement element = driver.findElement(locator);
                if (element.isDisplayed()) {
                    System.out.println("Found the element.");
                    return;
                }
            } catch (Exception e) {
                System.out.println("Element not found, trying again.");
                attempt++;
            }
        }
        System.out.println("Max attempts reached, could not find element.");
    }

}
