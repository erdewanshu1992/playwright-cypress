package com.yesmadam.androidApp.tests;

import com.yesmadam.androidApp.base.BaseTest;
import com.yesmadam.androidApp.interfaces.BookActions;
import com.yesmadam.androidApp.screen.BookingScreen;
import com.yesmadam.androidApp.utils.CommonUtils;

public class BookTest extends BaseTest implements BookActions {

    BookingScreen bookingScreen;

    public static void main(String[] args) {
        BookTest test = new BookTest();
        test.runTest("9855566677", "2222", "Stories From The Best");
    }

    public void runTest(String mobileNumber, String otp, String scrollText) {
        initializeDriver();
        bookingScreen = new BookingScreen(driver);

        performBookingFlow();
        performLoginFlow(mobileNumber, otp);
        performPostLoginActions(scrollText);

        quitDriver();
    }

    // -------------------- Booking Flow --------------------

    private void performBookingFlow() {
        mainCat();
        addToCart();
        viewCart();
        bottomSheetCrossBtn();
    }

    // -------------------- Login Flow --------------------

    private void performLoginFlow(String mobileNumber, String otp) {
        enterMobileNumber(mobileNumber);
        continueBtn();
        enterOtp(otp);
    }

    // -------------------- Post-Login Flow --------------------

    private void performPostLoginActions(String scrollText) {
        afterLoggedInViewCart();
        scrollingDown(scrollText);
    }

    // -------------------- Actions Implementation --------------------

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
    public void enterMobileNumber(String mobileNumber) {
        bookingScreen.getMobInput().sendKeys(mobileNumber);
        CommonUtils.sleep(3000);
        System.out.println("Entered Mobile Number: " + mobileNumber);
    }

    @Override
    public void continueBtn() {
        bookingScreen.getContinueBtn().click();
        CommonUtils.sleep(3000);
        System.out.println("Clicked Continue");
    }

    @Override
    public void enterOtp(String otp) {
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
        System.out.println("Scrolled to text: " + text);
    }
}

