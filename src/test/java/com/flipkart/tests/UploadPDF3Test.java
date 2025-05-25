package com.flipkart.tests;

import com.flipkart.base.BaseTest;
import com.flipkart.driver.DriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;



public class UploadPDF3Test extends BaseTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        DriverManager.createDriver();
        driver = DriverManager.getDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void goToUploadPage() {
        driver.get("https://www.ilovepdf.com/compress_pdf");
    }

    @Test(priority = 1, enabled = true)
    public void uploadPdfFileTest1() {
        try {
            Thread.sleep(3000); // Let page load

            // Locate the hidden <input type="file">
            WebElement fileInput = driver.findElement(By.cssSelector("input[type='file']"));

            // Provide absolute file path
            fileInput.sendKeys("/Users/yesmadamtesting/Desktop/ym-flip-oops/Appium_Key_Concepts.pdf");
            // fileInput.sendKeys("/Users/yesmadamtesting/Downloads/Appium_Key_Concepts_Updated.pdf");


            Thread.sleep(3000); // Optional wait to observe upload

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Take screenshot of uploaded screenpublic class GroceryOrderSystem {
        //    public static void main(String[] args) {
        //        List<Product> products = new ArrayList<>();
        //        products.add(new Product("Apples", "Perishable", 100, 6, 10, 0));
        //        products.add(new Product("Rice (5kg bag)", "Non-Perishable", 500, 4, 0, 5));
        //        products.add(new Product("Milk (1 liter)", "Perishable", 50, 10, 5, 0));
        //
        //        double totalAmount = 0;
        //        Product highestCostProduct = null;
        //        double highestCost = 0;
        //
        //        for (Product product : products) {
        //            double productTotal = product.calculateDiscountedTotal();
        //            totalAmount += productTotal;
        //
        //            if (productTotal > highestCost) {
        //                highestCost = productTotal;
        //                highestCostProduct = product;
        //            }
        //        }
        //
        //        if (highestCostProduct != null) {
        //            System.out.println("Product with the highest total cost after discounts: " + highestCostProduct.getName());
        //            System.out.println("Total amount to be paid by the customer: Rs. " + totalAmount);
        //        }
        //    }
        //}
        ScreenshotUtil("uploaded_screen");
        System.out.println("File uploaded successfully...");



    }


    public void ScreenshotUtil (String fileName){

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest = new File("uploadedFile/" + fileName + ".png");
        try {
            FileUtils.copyFile(src, dest);
            System.out.println("Screenshot saved to: " + dest.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Test(priority = 2, enabled = true)
    public void uploadPdfFileTest2() {
        try {
            Thread.sleep(3000); // Wait for page load

            WebElement fileInput = driver.findElement(By.cssSelector("input[type='file']"));

            // Load file from resources using ClassLoader
            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(classLoader.getResource("Appium_Key_Concepts.pdf").getFile());

            // Check if file exists and upload
            if (file.exists()) {
                fileInput.sendKeys(file.getAbsolutePath());
                System.out.println("✅ File uploaded: " + file.getAbsolutePath());
            } else {
                System.out.println("❌ File not found in resources.");
            }

            Thread.sleep(5000); // Wait for upload to reflect
            ScreenshotUtil("uploaded_screen");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 3, enabled = true)
    public void uploadPdfFileTest3 () {
        try {
            Thread.sleep(3000); // Wait for page load

            WebElement fileInput = driver.findElement(By.cssSelector("input[type='file']"));

            // Load file from resources using ClassLoader
            ClassLoader classLoader = getClass().getClassLoader();
            URL resource = classLoader.getResource("Appium_Key_Concepts.pdf");

            if (resource != null) {
                File file = new File(resource.getFile());
                fileInput.sendKeys(file.getAbsolutePath());
                System.out.println("✅ File uploaded: " + file.getAbsolutePath());
            } else {
                System.err.println("❌ File not found in resources folder.");
            }


            Thread.sleep(5000); // Wait for upload to reflect
            ScreenshotUtil("uploaded_screen");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 4, enabled = true)
    public void uploadPdfFileTest4 () {
        try {
            Thread.sleep(3000); // Let page load

            WebElement fileInput = driver.findElement(By.cssSelector("input[type='file']"));

            // Relative path inside project
            File file = new File("src/test/resources/Appium_Key_Concepts.pdf");

            if (file.exists()) {
                fileInput.sendKeys(file.getAbsolutePath());
            } else {
                System.out.println("❌ File not found: " + file.getAbsolutePath());
            }

            // Upload using absolute path
            // fileInput.sendKeys(file.getAbsolutePath());

            Thread.sleep(5000); // Wait for upload to complete

            ScreenshotUtil("uploaded_screen");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void takeScreenshotAfterTest(Method method) {
        ScreenshotUtil(method.getName());
    }

    @AfterClass
    public void afterClassTearDown() {
        DriverManager.quitDriver();  // Quit only after all tests complete
    }




}
