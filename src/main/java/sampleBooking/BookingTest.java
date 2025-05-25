package sampleBooking;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class BookingTest {

    WebDriver driver;

    // Set up the driver for the Android device
    public static AndroidDriver<WebElement> setUp() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("automationName", "UiAutomator2");
        cap.setCapability("deviceName", "Pixel 5");
        cap.setCapability("platformName", "Android");
        cap.setCapability("appPackage", "yesmadamservices.app.com.yesmadamservices");
        cap.setCapability("appActivity", "yesmadamservices.app.com.yesmadamservices.MainActivity");
        cap.setCapability("noReset", true);

        return new AndroidDriver<>(new URL("http://127.0.0.1:4723/"), cap);
    }

    // Initialize the driver in main method
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        BookingTest bookingTest = new BookingTest();
        bookingTest.driver = setUp();

        // Example of running the methods
        bookingTest.mainCat();
        bookingTest.addToCart();
        bookingTest.viewCart();
        bookingTest.bottomSheetCrossBtn();
        bookingTest.enterMobNo();
        bookingTest.continueBtn();
        bookingTest.otpEnter("2222");
        bookingTest.afterLoggedInViewCart();

    }

    // Method to select main category
    public void mainCat() throws InterruptedException {
        WebElement ele1 = driver.findElement(By.xpath("(//android.widget.TextView[@text=\"Salon At Home\"])[1]")); // Replace with correct XPath
        ele1.click();
        Thread.sleep(3000);
        System.out.println("Main Cat Clicked");
    }

    // Method to add item to the cart
    public void addToCart() throws InterruptedException {
        WebElement ele2 = driver.findElement(By.xpath("//android.widget.TextView[@text=\"ADD\"]")); // Replace with correct XPath
        ele2.click();
        Thread.sleep(3000);
        System.out.println("Clicked Add to Cart");
    }

    // Method to view cart
    public void viewCart() throws InterruptedException {
        WebElement ele3 = driver.findElement(By.xpath("//android.widget.TextView[@text=\"View Cart\"]")); // Replace with correct XPath
        ele3.click();
        Thread.sleep(3000);
        System.out.println("Clicked on view cart");
    }

    // Method to close bottom sheet
    public void bottomSheetCrossBtn() throws InterruptedException {
        WebElement ele4 = driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Cancel\"]")); // Replace with correct XPath
        ele4.click();
        Thread.sleep(3000);
        System.out.println("clicked on cancel btn");
    }

    // Method to enter mobile number
    public void enterMobNo() throws InterruptedException {
        WebElement ele5 = driver.findElement(By.xpath("//*[@resource-id=\"mobileNumber\"]")); // Replace with correct XPath
        ele5.sendKeys("9855566677"); // Enter a valid mobile number
        Thread.sleep(3000);
        System.out.println("Enter mob no");
    }

    // Method to click continue button
    public void continueBtn() throws InterruptedException {
        WebElement ele6 = driver.findElement(By.xpath("//*[@text=\"Continue\"]")); // Replace with correct XPath
        ele6.click();
        Thread.sleep(3000);
        System.out.println("Click on continue btn");
    }

    // Method to enter OTP
    public void otpEnter(String otp) {
        // Locate the OTP input fields (assuming there are multiple EditText fields for each digit)
        List<WebElement> otpInputs = driver.findElements(By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']//android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]//android.view.ViewGroup/android.widget.EditText"));

        // Ensure there are enough input fields to enter the OTP
        if (otpInputs.size() >= otp.length()) {
            // Enter OTP one digit at a time
            for (int i = 0; i < otp.length(); i++) {
                WebElement otpInput = otpInputs.get(i);  // Get the individual OTP input field
                System.out.println("Entering OTP digit: " + otp.charAt(i)); // Debugging line
                otpInput.sendKeys(String.valueOf(otp.charAt(i)));
            }
        } else {
            System.out.println("Not enough OTP input fields available.");
        }
    }

    public void afterLoggedInViewCart() throws InterruptedException {
        WebElement ele7 = driver.findElement(By.xpath("//android.widget.TextView[@text=\"View Cart\"]")); // Replace with correct XPath
        ele7.click();
        Thread.sleep(3000);
        System.out.println("Clicked on view cart after logged in");
    }

}
