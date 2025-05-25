package com.flipkart.factory;

import com.flipkart.interfaces.LoginActions;
import com.flipkart.pages.AdminLoginPage;
import com.flipkart.pages.FlightLoginPage3;
import org.openqa.selenium.WebDriver;

public class LoginFactory {

    public static LoginActions getLoginPage(String userType, WebDriver driver) {
        switch (userType.toLowerCase()) {
            case "flight":
                return new FlightLoginPage3(driver);

            case "admin":
                return new AdminLoginPage(driver);

            // You can add more cases as needed
            // case "customer": return new CustomerLoginPage(driver);

            default:
                throw new IllegalArgumentException("Unsupported user type: " + userType);
        }
    }
}
