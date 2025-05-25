package com.flipkart.tests;
// testFlightLogin

import com.flipkart.base.BaseTest;
import com.flipkart.pages.FlightLoginPage2;
import org.testng.annotations.Test;

public class FlightLogin2Test extends BaseTest {
    @Test
    public void testLogin() {
        driver.get("https://mybookings.easemytrip.com/");

        new FlightLoginPage2(driver).login("qadev432@gmail.com", "Qwerty@@123");

    }

}
