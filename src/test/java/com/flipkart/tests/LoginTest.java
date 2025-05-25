package com.flipkart.tests;

import com.flipkart.base.BaseTest;
import com.flipkart.factory.LoginFactory;
import com.flipkart.interfaces.LoginActions;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void testLoginBasedOnUserType() {
        String userType = "flight"; // or "admin", etc.

        // Launch URL based on userType
        if (userType.equals("flight")) {
            driver.get("https://mybookings.easemytrip.com/");
        } else if (userType.equals("admin")) {
            driver.get("https://admin.flipkart.com/");
        }

        LoginActions loginPage = LoginFactory.getLoginPage(userType, driver);
        loginPage.enterEmailId();
        loginPage.clickContinueAfterEmail();
        loginPage.enterPassword();
        loginPage.clickContinueAfterPassword();
    }
}
