package com.yesmadam.androidApp.utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.time.Duration;
import org.openqa.selenium.Dimension;


public class Scrolls {

    private AndroidDriver<WebElement> driver;

    public Scrolls(AndroidDriver<WebElement> driver) {
        this.driver = driver;
    }

    // Scroll down using UiScrollable
    public void scrollDown() {
        driver.findElementByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollForward();"
        );
    }

    // Scroll up using UiScrollable
    public void scrollUp() {
        driver.findElementByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollBackward();"
        );
    }

    // Scroll to visible text
    public void scrollToText(String text) {
        driver.findElementByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView("
                        + "new UiSelector().text(\"" + text + "\"));"
        );
    }

    public boolean scrollToText(String text, String direction) {
        String scrollCommand = "new UiScrollable(new UiSelector().scrollable(true))";

        if (direction.equalsIgnoreCase("UP")) {
            scrollCommand += ".scrollBackward()";  // Scroll UP
        } else if (direction.equalsIgnoreCase("DOWN")) {
            scrollCommand += ".scrollForward()";   // Scroll DOWN
        }

        scrollCommand += ".scrollIntoView(new UiSelector().text(\"" + text + "\"));";

        try {
            driver.findElementByAndroidUIAutomator(scrollCommand);
            return true;
        } catch (Exception e) {
            System.out.println("Text not found while scrolling " + direction + ".");
            return false;
        }
    }


    // Swipe down manually using TouchAction
    public void swipeDown() {
        Dimension size = driver.manage().window().getSize();
        int startY = (int) (size.height * 0.6);
        int endY = (int) (size.height * 0.2);
        int x = size.width / 2;

        new TouchAction<>(driver)
                .press(PointOption.point(x, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(x, endY))
                .release()
                .perform();
    }

    // Swipe up manually using TouchAction
    public void swipeUp() {
        Dimension size = driver.manage().window().getSize();
        int startY = (int) (size.height * 0.2);
        int endY = (int) (size.height * 0.6);
        int x = size.width / 2;

        new TouchAction<>(driver)
                .press(PointOption.point(x, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(x, endY))
                .release()
                .perform();
    }

    // Swipe left
    public void swipeLeft() {
        Dimension size = driver.manage().window().getSize();
        int startX = (int) (size.width * 0.8);
        int endX = (int) (size.width * 0.2);
        int y = size.height / 2;

        new TouchAction<>(driver)
                .press(PointOption.point(startX, y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(endX, y))
                .release()
                .perform();
    }

    // Swipe right
    public void swipeRight() {
        Dimension size = driver.manage().window().getSize();
        int startX = (int) (size.width * 0.2);
        int endX = (int) (size.width * 0.8);
        int y = size.height / 2;

        new TouchAction<>(driver)
                .press(PointOption.point(startX, y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(endX, y))
                .release()
                .perform();
    }

    // ✅ Scroll Until Element is Visible (Vertical Example)
    public void swipeUpUntilElementVisible(By locator, int maxSwipes) {
        int swipes = 0;
        while (driver.findElements(locator).isEmpty() && swipes < maxSwipes) {
            swipeUp();
            swipes++;
        }

        if (swipes == maxSwipes && driver.findElements(locator).isEmpty()) {
            throw new RuntimeException("Element not found after swiping " + maxSwipes + " times");
        }
    }

    // 🧠 You can also write a similar method for swipe left/right:
    public void swipeLeftUntilElementVisible(By locator, int maxSwipes) {
        int swipes = 0;
        while (driver.findElements(locator).isEmpty() && swipes < maxSwipes) {
            swipeLeft();
            swipes++;
        }

        if (swipes == maxSwipes && driver.findElements(locator).isEmpty()) {
            throw new RuntimeException("Element not found after swiping left " + maxSwipes + " times");
        }
    }


}


/*
✅ Example Usage:
Scrolls scrolls = new Scrolls(driver);
Scrolls.swipeUp(); // or Scrolls.scrollToText("MakeUp At Home");
Scrolls.swipeLeft();

 */

/*
✅ How to Use:
Scrolls scrolls = new Scrolls(driver);
Scrolls.swipeUpUntilElementVisible(By.xpath("//android.widget.TextView[@text='MakeUp At Home']"), 5);

 */