package com.yesmadam.androidApp.tests;

import com.yesmadam.androidApp.screen.BookingScreen;

public class MainTest {
    public static void main(String[] args) {
        BookingTest bookingTest = new BookingTest();
        bookingTest.initializeDriver();
        bookingTest.bookingScreen = new BookingScreen(bookingTest.driver);

        bookingTest.mainCat();
        bookingTest.addToCart();
        bookingTest.viewCart();
        bookingTest.continueBtn();
        bookingTest.bottomSheetCrossBtn();
        bookingTest.enterMobNo();
        bookingTest.otpEnter("2222");
        bookingTest.afterLoggedInViewCart();


    }
}

