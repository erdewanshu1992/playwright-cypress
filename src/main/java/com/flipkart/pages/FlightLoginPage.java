package com.flipkart.pages;

import com.flipkart.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlightLoginPage extends BasePage {

    private By emailEnterField = By.xpath("//input[@id=\"txtEmailNew\"]");
    private By continueBtn = By.xpath("(//input[@class=\"buttonLogin\"])[7]");
    private By enterPasswordField = By.xpath("(//input[@type=\"password\"])[12]");
    private By continueBtn2 = By.xpath("(//input[@class=\"_btnLogin\"])[2]");

    public FlightLoginPage(WebDriver driver) {
        super(driver);
    }


    public By getEmailEnterField() {
        return emailEnterField;
    }

    public void setEmailEnterField(By emailEnterField) {
        this.emailEnterField = emailEnterField;
    }

    public By getContinueBtn() {
        return continueBtn;
    }

    public void setContinueBtn(By continueBtn) {
        this.continueBtn = continueBtn;
    }

    public By getEnterPasswordField() {
        return enterPasswordField;
    }

    public void setEnterPasswordField(By enterPasswordField) {
        this.enterPasswordField = enterPasswordField;
    }

    public By getContinueBtn2() {
        return continueBtn2;
    }

    public void setContinueBtn2(By continueBtn2) {
        this.continueBtn2 = continueBtn2;
    }
}
