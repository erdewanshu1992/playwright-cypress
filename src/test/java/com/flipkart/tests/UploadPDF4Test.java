package com.flipkart.tests;

import com.flipkart.base.BaseTest;
import com.flipkart.driver.DriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class UploadPDF4Test extends BaseTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = DriverManager.getDriver();
        driver.manage().window().maximize();
        driver.get("https://www.ilovepdf.com/compress_pdf");
    }

    @Test
    public void uploadPdfFileTest1() {
        WebElement fileInput = driver.findElement(By.cssSelector("input[type='file']"));
        fileInput.sendKeys("/Users/yesmadamtesting/Desktop/ym-flip-oops/Appium_Key_Concepts.pdf");
    }

    @Test
    public void uploadPdfFileTest2() {
        WebElement fileInput = driver.findElement(By.cssSelector("input[type='file']"));
        fileInput.sendKeys("NonExistingFile.pdf"); // This will fail
    }

    @Test
    public void uploadPdfFileTest3() {
        WebElement fileInput = driver.findElement(By.cssSelector("input[type='file']"));
        fileInput.sendKeys("/Users/yesmadamtesting/Downloads/Appium_Key_Concepts_Updated.pdf");
    }

    @AfterMethod
    public void captureScreenshotOnFailure(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String fileName = result.getName() + "_" + timestamp + ".png";
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destFile = new File("screenshots/" + fileName);

            try {
                FileUtils.copyFile(screenshot, destFile);
                Reporter.log("Screenshot captured for test: " + result.getName(), true);
                Reporter.log("<br><a href='screenshots/" + fileName + "'><img src='screenshots/" + fileName + "' height='100' width='100'/></a>", true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @AfterSuite
    public void zipScreenshotsFolder() {
        File screenshotsDir = new File("screenshots");
        if (!screenshotsDir.exists()) return;

        try {
            String zipFileName = "screenshots.zip";
            FileOutputStream fos = new FileOutputStream(zipFileName);
            ZipOutputStream zos = new ZipOutputStream(fos);

            for (File file : screenshotsDir.listFiles()) {
                FileInputStream fis = new FileInputStream(file);
                zos.putNextEntry(new ZipEntry(file.getName()));

                byte[] buffer = new byte[1024];
                int length;
                while ((length = fis.read(buffer)) > 0) {
                    zos.write(buffer, 0, length);
                }

                zos.closeEntry();
                fis.close();
            }

            zos.close();
            fos.close();
            System.out.println("📦 Zipped screenshots to: " + zipFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
