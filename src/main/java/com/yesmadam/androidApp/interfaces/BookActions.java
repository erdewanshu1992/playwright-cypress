package com.yesmadam.androidApp.interfaces;


public interface BookActions {

    void mainCat();
    void addToCart();
    void viewCart();
    void bottomSheetCrossBtn();
    void enterMobileNumber(String mobileNumber); // ✅ updated
    void continueBtn();
    void enterOtp(String otp);                  // ✅ updated
    void afterLoggedInViewCart();
    void scrollingDown(String text);
}
