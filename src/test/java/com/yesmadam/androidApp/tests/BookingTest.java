package com.yesmadam.androidApp.tests;
// 3. Concrete Class - BookingTest.java

import com.yesmadam.androidApp.base.BaseTest;
import com.yesmadam.androidApp.interfaces.BookingActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class BookingTest extends BaseTest implements BookingActions {

    // Encapsulated - private variables (if any needed)

    @Override
    public void selectMainCategory() throws InterruptedException {
        WebElement ele1 = driver.findElement(By.xpath("(//android.widget.TextView[@text=\"Salon At Home\"])[1]"));
        ele1.click();
        Thread.sleep(3000);
        System.out.println("Main Category Clicked");
    }

    @Override
    public void addItemToCart() throws InterruptedException {
        WebElement ele2 = driver.findElement(By.xpath("//android.widget.TextView[@text=\"ADD\"]"));
        ele2.click();
        Thread.sleep(3000);
        System.out.println("Item Added to Cart");
    }

    @Override
    public void viewCart() throws InterruptedException {
        WebElement ele3 = driver.findElement(By.xpath("//android.widget.TextView[@text=\"View Cart\"]"));
        ele3.click();
        Thread.sleep(3000);
        System.out.println("View Cart Clicked");
    }

    @Override
    public void closeBottomSheet() throws InterruptedException {
        WebElement ele4 = driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Cancel\"]"));
        ele4.click();
        Thread.sleep(3000);
        System.out.println("Bottom Sheet Closed");
    }

    @Override
    public void enterMobileNumber(String mobileNumber) throws InterruptedException {
        WebElement ele5 = driver.findElement(By.xpath("//*[@resource-id=\"mobileNumber\"]"));
        ele5.sendKeys(mobileNumber);
        Thread.sleep(3000);
        System.out.println("Mobile Number Entered: " + mobileNumber);
    }

    @Override
    public void continueButtonClick() throws InterruptedException {
        WebElement ele6 = driver.findElement(By.xpath("//*[@text=\"Continue\"]"));
        ele6.click();
        Thread.sleep(3000);
        System.out.println("Continue Button Clicked");
    }

    @Override
    public void enterOtp(String otp) {
        List<WebElement> otpInputs = driver.findElements(By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']//android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]//android.view.ViewGroup/android.widget.EditText"));

        if (otpInputs.size() >= otp.length()) {
            for (int i = 0; i < otp.length(); i++) {
                WebElement otpInput = otpInputs.get(i);
                otpInput.sendKeys(String.valueOf(otp.charAt(i)));
            }
            System.out.println("OTP Entered Successfully: " + otp);
        } else {
            System.out.println("Not enough OTP fields available.");
        }
    }

    // Method Overloading - enterOtp without parameters (default OTP)
    public void enterOtp() {
        enterOtp("2222");
    }

    @Override
    public void afterLoginViewCart() throws InterruptedException {
        WebElement ele7 = driver.findElement(By.xpath("//android.widget.TextView[@text=\"View Cart\"]"));
        ele7.click();
        Thread.sleep(3000);
        System.out.println("View Cart after login clicked");
    }

    // Main method to execute the flow
    public static void main(String[] args) throws Exception {
        BookingTest bookingTest = new BookingTest();
        bookingTest.setUp();

        bookingTest.selectMainCategory();
        bookingTest.addItemToCart();
        bookingTest.viewCart();
        bookingTest.closeBottomSheet();
        bookingTest.enterMobileNumber("9855566677");
        bookingTest.continueButtonClick();
        bookingTest.enterOtp();  // calling overloaded method
        bookingTest.afterLoginViewCart();
    }
}
