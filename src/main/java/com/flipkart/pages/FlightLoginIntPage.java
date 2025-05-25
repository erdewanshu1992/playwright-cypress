package com.flipkart.pages;

import com.flipkart.base.BasePage;
import com.flipkart.interfaces.LoginActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlightLoginIntPage extends BasePage implements LoginActions {

    private final By emailEnterField = By.xpath("//input[@id=\"txtEmailNew\"]");
    private final By continueBtn = By.xpath("(//input[@class=\"buttonLogin\"])[7]");
    private final By enterPasswordField = By.xpath("(//input[@type=\"password\"])[12]");
    private final By continueBtn2 = By.xpath("(//input[@class=\"_btnLogin\"])[2]");

    public FlightLoginIntPage(WebDriver driver){
        super(driver);
    }

    @Override
    public void enterEmailId (){
        driver.findElement(emailEnterField).sendKeys("qadev432@gmail.com");
    }

    public void setContinueBtn(){
        driver.findElement(continueBtn).click();
    }

    @Override
        public void enterPassword(){
        driver.findElement(enterPasswordField).sendKeys("Qwerty@@123");
    }

    public void setContinueBtn2 (){
        driver.findElement(continueBtn2).click();
    }

    public void clickContinueAfterEmail(){
        System.out.println("abc");
    }
    public void clickContinueAfterPassword(){
        System.out.println("abc");
    }

}
