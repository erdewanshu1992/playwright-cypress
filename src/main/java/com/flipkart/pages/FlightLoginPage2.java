package com.flipkart.pages;

import com.flipkart.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlightLoginPage2 extends BasePage {

    private final By emailEnterField = By.xpath("//input[@id='txtEmailNew']");
    private final By continueBtn = By.xpath("(//input[@class='buttonLogin'])[7]");
    private final By enterPasswordField = By.xpath("(//input[@type='password'])[12]");
    private final By continueBtn2 = By.xpath("(//input[@class='_btnLogin'])[2]");

    public FlightLoginPage2(WebDriver driver) {
        super(driver);
    }

    public void login(String email, String password) {
        driver.findElement(emailEnterField).sendKeys(email);
        driver.findElement(continueBtn).click();
        driver.findElement(enterPasswordField).sendKeys(password);
        driver.findElement(continueBtn2).click();
    }
}

