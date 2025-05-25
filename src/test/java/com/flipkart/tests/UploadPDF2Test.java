package com.flipkart.tests;


import com.flipkart.base.BaseTest;
import com.flipkart.driver.DriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UploadPDF2Test extends BaseTest {

    private WebDriver driver;

    @BeforeClass
    public void beforeClassSetup() {
        DriverManager.createDriver();        // Create driver once before all tests
        driver = DriverManager.getDriver();  // Get the driver instance
        driver.manage().window().maximize();
        System.out.println("Before Class - runs once");
    }

    @BeforeMethod
    public void beforeMethodSetup() {
        driver.get("https://www.ilovepdf.com/compress_pdf");  // Navigate before each test
        System.out.println("Navigated to upload page");
    }

    @Test
    public void uploadPdfFileTest1() {
        uploadFile("/Users/yesmadamtesting/Desktop/ym-flip-oops/Appium_Key_Concepts.pdf");
    }

    @Test
    public void uploadPdfFileTest2() {
        uploadFile("/Users/yesmadamtesting/Desktop/ym-flip-oops/Appium_Key_Concepts.pdf");
    }

    @Test
    public void uploadPdfFileTest3() {
        uploadFile("/Users/yesmadamtesting/Desktop/ym-flip-oops/Appium_Key_Concepts.pdf");
    }

    @Test
    public void uploadPdfFileTest4() {
        uploadFile("/Users/yesmadamtesting/Desktop/ym-flip-oops/Appium_Key_Concepts.pdf");
    }

    private void uploadFile(String filePath) {
        try {
            Thread.sleep(2000); // Wait for page load
            WebElement fileInput = driver.findElement(By.cssSelector("input[type='file']"));
            fileInput.sendKeys(filePath);
            Thread.sleep(3000); // Let it upload
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void takeScreenshotAfterTest(Method method) {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        ScreenshotUtil(method.getName() + "_" + timestamp);
    }

    public void ScreenshotUtil(String fileName) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest = new File("screenshots/" + fileName + ".png");
        try {
            FileUtils.copyFile(src, dest);
            System.out.println("📸 Screenshot saved to: " + dest.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void commonSetup() {
        if (driver == null) {
            driver = DriverManager.getDriver();
            driver.manage().window().maximize();
        }
    }

    @AfterClass
    public void afterClassTearDown() {
        DriverManager.quitDriver();  // Quit only after all tests complete
    }



}

