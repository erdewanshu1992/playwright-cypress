package com.yesmadam.androidApp.tests;
// 6. BookingTest.java ➔ (Test Class Using Everything)

import com.yesmadam.androidApp.base.BaseTest;
import com.yesmadam.androidApp.interfaces.BookingActions;
import com.yesmadam.androidApp.screen.BookingScreen;
import com.yesmadam.androidApp.utils.CommonUtils;

public class BookingTest extends BaseTest implements BookingActions {

    BookingScreen bookingScreen;

    public static void main(String[] args) {
        BookingTest test = new BookingTest();
        test.runTest();
    }

    public void runTest() {
        initializeDriver();
        bookingScreen = new BookingScreen(driver);

        mainCat();
        addToCart();
        viewCart();
        bottomSheetCrossBtn();
        enterMobNo();
        continueBtn();
        otpEnter("2222");
        afterLoggedInViewCart();

        scrollingDown("Stories From The Best");


        quitDriver();
    }

    @Override
    public void mainCat() {
        bookingScreen.getMainCat().click();
        CommonUtils.sleep(3000);
        System.out.println("Clicked Main Category");
    }

    @Override
    public void addToCart() {
        bookingScreen.getAddToCart().click();
        CommonUtils.sleep(3000);
        System.out.println("Clicked Add to Cart");
    }

    @Override
    public void viewCart() {
        bookingScreen.getViewCart().click();
        CommonUtils.sleep(3000);
        System.out.println("Clicked View Cart");
    }

    @Override
    public void bottomSheetCrossBtn() {
        bookingScreen.getCancelBtn().click();
        CommonUtils.sleep(3000);
        System.out.println("Clicked Cancel Button");
    }

    @Override
    public void enterMobNo() {
        bookingScreen.getMobInput().sendKeys("9855566677");
        CommonUtils.sleep(3000);
        System.out.println("Entered Mobile Number");
    }

    @Override
    public void continueBtn() {
        bookingScreen.getContinueBtn().click();
        CommonUtils.sleep(3000);
        System.out.println("Clicked Continue");
    }

    @Override
    public void otpEnter(String otp) {
        var fields = bookingScreen.getOtpFields();
        for (int i = 0; i < otp.length(); i++) {
            fields.get(i).sendKeys(String.valueOf(otp.charAt(i)));
            System.out.println("Entered OTP Digit: " + otp.charAt(i));
        }
    }

    @Override
    public void afterLoggedInViewCart() {
        bookingScreen.getViewCart().click();
        CommonUtils.sleep(3000);
        System.out.println("Clicked View Cart after Login");
    }

    @Override
    public void scrollingDown(String text) {
        bookingScreen.scrollToElementWithText(text);
        CommonUtils.sleep(3000);
        System.out.println("Scroll down");
    }

    @Override
    public void m1 (){
        System.out.println("abc");
    }



}