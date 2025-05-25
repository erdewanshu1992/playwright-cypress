package com.yesmadam.androidApp.interfaces;

// 3. BookingActions.java ➔ (Interface for all Booking Activities)

public interface BookingActions {

    void mainCat() throws InterruptedException;
    void addToCart() throws InterruptedException;
    void viewCart() throws InterruptedException;
    void bottomSheetCrossBtn() throws InterruptedException;
    void enterMobNo() throws InterruptedException;
    void continueBtn() throws InterruptedException;
    void otpEnter(String otp);
    void afterLoggedInViewCart() throws InterruptedException;
    void scrollingDown(String text);
    default void m1() {

    }
}

