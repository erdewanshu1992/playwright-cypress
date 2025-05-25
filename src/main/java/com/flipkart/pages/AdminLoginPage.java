package com.flipkart.pages;

import com.flipkart.base.BasePage;
import com.flipkart.interfaces.LoginActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminLoginPage extends BasePage implements LoginActions {

    private final By email = By.id("admin_email");
    private final By continue1 = By.id("admin_continue1");
    private final By password = By.id("admin_pass");
    private final By continue2 = By.id("admin_continue2");

    public AdminLoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void enterEmailId() {
        driver.findElement(email).sendKeys("admin@flipkart.com");
    }

    @Override
    public void clickContinueAfterEmail() {
        driver.findElement(continue1).click();
    }

    @Override
    public void enterPassword() {
        driver.findElement(password).sendKeys("admin123");
    }

    @Override
    public void clickContinueAfterPassword() {
        driver.findElement(continue2).click();
    }
}
