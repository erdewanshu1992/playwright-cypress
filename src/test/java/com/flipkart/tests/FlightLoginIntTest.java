package com.flipkart.tests;

import com.flipkart.base.BaseTest;
import com.flipkart.pages.FlightLoginIntPage;
import org.testng.annotations.Test;

public class FlightLoginIntTest extends BaseTest {

    @Test
    public void flightLoginTest(){
        // Launch Flipkart Flight Login Page
        driver.get("https://mybookings.easemytrip.com/");

        FlightLoginIntPage flightLoginIntPage = new FlightLoginIntPage(driver);
        flightLoginIntPage.enterEmailId();
        flightLoginIntPage.setContinueBtn();
        flightLoginIntPage.enterPassword();
        flightLoginIntPage.setContinueBtn2();
    }

}
