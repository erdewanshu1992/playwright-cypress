package com.flipkart.pages;

import com.flipkart.base.BasePage;
import com.flipkart.interfaces.LoginActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlightLoginPage3 extends BasePage implements LoginActions {

    private final By emailField = By.xpath("//input[@id='txtEmailNew']");
    private final By continueEmailBtn = By.xpath("(//input[@class='buttonLogin'])[7]");
    private final By passwordField = By.xpath("(//input[@type='password'])[12]");
    private final By continuePasswordBtn = By.xpath("(//input[@class='_btnLogin'])[2]");

    public FlightLoginPage3(WebDriver driver) {
        super(driver);
    }

    @Override
    public void enterEmailId() {
        driver.findElement(emailField).sendKeys("qadev432@gmail.com");
    }

    @Override
    public void clickContinueAfterEmail() {
        driver.findElement(continueEmailBtn).click();
    }

    @Override
    public void enterPassword() {
        driver.findElement(passwordField).sendKeys("Qwerty@@123");
    }

    @Override
    public void clickContinueAfterPassword() {
        driver.findElement(continuePasswordBtn).click();
    }

    // Optional: combine steps for convenience
    public void login() {
        enterEmailId();
        clickContinueAfterEmail();
        enterPassword();
        clickContinueAfterPassword();
    }
}
