package com.flipkart.tests;

import com.flipkart.base.BaseTest;
import com.flipkart.pages.FlightLoginPage3;
import org.testng.annotations.Test;

public class FlightLogin3Test extends BaseTest {

    @Test
    public void testFlightLogin() {
        driver.get("https://mybookings.easemytrip.com/");
        FlightLoginPage3 loginPage = new FlightLoginPage3(driver);
        loginPage.login(); // one-liner method
    }
}
