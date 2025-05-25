// com.flipkart.pages.CheckoutPage.java
package com.flipkart.pages;

import com.flipkart.base.BasePage;
import com.flipkart.interfaces.CheckoutActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage implements CheckoutActions {
    private By checkoutBtn = By.xpath("//button[text()='Proceed to checkout']");
    private By totalPrice = By.cssSelector(".totalPrice");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void proceedToCheckout() {
        driver.findElement(checkoutBtn).click();
    }

    @Override
    public String getCheckoutPrice() {
        return driver.findElement(totalPrice).getText();
    }

    @Override
    public void applyCoupon() {
        // apply coupon logic
    }
}












/*
package com.flipkart.pages;

import com.flipkart.interfaces.CheckoutActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage implements CheckoutActions {
    private WebDriver driver;

    private By checkoutBtn = By.xpath("//button[text()='Proceed to checkout']");
    private By totalPrice = By.cssSelector(".totalPrice");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public void proceedToCheckout() {
        driver.findElement(checkoutBtn).click();
    }

    @Override
    public String getCheckoutPrice() {
        return driver.findElement(totalPrice).getText();
    }

    @Override
    public void applyCoupon() {
        // Logic for applying coupon
    }
}
*/
