package com.flipkart.tests;

import com.flipkart.base.BaseTest;
import com.flipkart.pages.CheckoutPage;
import org.testng.annotations.Test;

public class testCheckoutFlow extends BaseTest {

    @Test
    public void testCheckoutFlow() {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.proceedToCheckout();  // ✅ Ab method use ho gaya
        checkoutPage.getCheckoutPrice();
        checkoutPage.applyCoupon();
    }

}
