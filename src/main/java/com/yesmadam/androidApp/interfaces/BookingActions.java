package com.yesmadam.androidApp.interfaces;
// 1. Interface - BookingActions.java

public interface BookingActions {
    void selectMainCategory() throws InterruptedException;
    void addItemToCart() throws InterruptedException;
    void viewCart() throws InterruptedException;
    void closeBottomSheet() throws InterruptedException;
    void enterMobileNumber(String mobileNumber) throws InterruptedException;
    void continueButtonClick() throws InterruptedException;
    void enterOtp(String otp);
    void afterLoginViewCart() throws InterruptedException;
}

