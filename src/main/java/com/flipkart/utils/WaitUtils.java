// com.flipkart.utils.WaitUtils.java
package com.flipkart.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;


public class WaitUtils {
    public static WebElement waitForElement(WebDriver driver, By locator) {
        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
