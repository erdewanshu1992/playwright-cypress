package com.flipkart.tests;

import com.flipkart.pages.FlightLoginPage;
import com.flipkart.base.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class FlightLoginTest extends BaseTest {

    @Test
    public void testFlightLogin() {
        // Launch Flipkart Flight Login Page
        driver.get("https://mybookings.easemytrip.com/");

        // Initialize page object
        FlightLoginPage loginPage = new FlightLoginPage(driver);

        // Enter email
        driver.findElement(loginPage.getEmailEnterField()).sendKeys("qadev432@gmail.com");

        // Click continue
        driver.findElement(loginPage.getContinueBtn()).click();

        // Wait until password field is present (You may want to add an explicit wait here)
        try {
            Thread.sleep(5000); // Prefer WebDriverWait in real code
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Enter password
        driver.findElement(loginPage.getEnterPasswordField()).sendKeys("Qwerty@@123");

        // Submit password (assuming the same continue button submits the password, else use another locator)
        driver.findElement(loginPage.getContinueBtn2()).click();

        // Add assertions here if there's an expected post-login element
    }
}

















/*
package com.flipkart.tests;

import com.flipkart.base.BaseTest;
import com.flipkart.pages.FlightLoginPage;
import org.testng.annotations.Test;

public class FlightLoginTest extends BaseTest {

    @Test
    public void loginTest(){
        driver.get("https://mybookings.easemytrip.com/");

        // Initialize page object
        FlightLoginPage loginPage = new FlightLoginPage(driver);

        driver.findElement(loginPage.getEmailEnterField()).sendKeys("qadev432@gmail.com");

        driver.findElement(loginPage.getContinueBtn()).click();

        // Wait until password field is present (You may want to add an explicit wait here)
        try {
            Thread.sleep(2000); // Prefer WebDriverWait in real code
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(loginPage.getEnterPasswordField()).sendKeys("Qwerty@@123");

        driver.findElement(loginPage.getContinueBtn2()).click();
    }

}
*/
