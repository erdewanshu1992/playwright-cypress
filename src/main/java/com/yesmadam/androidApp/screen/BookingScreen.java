package com.yesmadam.androidApp.screen;
// 4. BookingPage.java ➔ (Page Object Model)

import com.yesmadam.androidApp.utils.Scrolls;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class BookingScreen {
    AndroidDriver<WebElement> driver;
    Scrolls scrolls;

    public BookingScreen(AndroidDriver<WebElement> driver) {
        this.driver = driver;
        // ✅ Initialize scrolls properly
        scrolls = new Scrolls(driver); // ← fix here
    }

    private final By mainCat = By.xpath("(//android.widget.TextView[@text=\"Salon At Home\"])[1]");
    private final By addToCart = By.xpath("//android.widget.TextView[@text=\"ADD\"]");
    private final By viewCart = By.xpath("//android.widget.TextView[@text=\"View Cart\"]");
    private final By cancelBtn = By.xpath("//android.widget.ImageView[@content-desc=\"Cancel\"]");
    private final By mobInput = By.xpath("//*[@resource-id=\"mobileNumber\"]");
    private final By continueBtn = By.xpath("//*[@text=\"Continue\"]");
    private final By otpFields = By.xpath("//android.widget.EditText");
    private final By getCashBackText = By.xpath("//com.horcrux.svg.PathView");

    // all getters
    public WebElement getMainCat() {
        return driver.findElement(mainCat);
    }

    public WebElement getAddToCart() {
        return driver.findElement(addToCart);
    }

    public WebElement getViewCart() {
        return driver.findElement(viewCart);
    }

    public WebElement getCancelBtn() {
        return driver.findElement(cancelBtn);
    }

    public WebElement getMobInput() {
        return driver.findElement(mobInput);
    }

    public WebElement getContinueBtn() {
        return driver.findElement(continueBtn);
    }

    public List<WebElement> getOtpFields() {
        return driver.findElements(otpFields);
    }

    // Method to perform Scroll
    public void scrollToElementWithText(String text) {
        new Scrolls(driver);
        scrolls.scrollToText(text);
    }

    public void scrollToElement(String text, String direction) {
        Scrolls scrolls = new Scrolls(driver);
        scrolls.scrollToText(text, direction);
    }

    public boolean scrollToElementWithText(String text, String direction) {
        Scrolls scrolls = new Scrolls(driver);  // Ensure you have access to the driver
        return scrolls.scrollToText(text, direction);
    }










}
