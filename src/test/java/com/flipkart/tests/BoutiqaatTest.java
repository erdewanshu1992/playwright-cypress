package com.flipkart.tests;

import com.flipkart.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BoutiqaatTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;

    @BeforeClass
    public void setUp() {
        DriverManager.createDriver();
        driver = DriverManager.getDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 13);
        actions = new Actions(driver); // ✅ Initialize AFTER driver is ready
    }

    @Test
    public void testBoutiqaatBrands() throws IOException, InterruptedException {
        driver.get("https://boutiqaat.com/");
        System.out.println("✅ Opened Boutiqaat");

        // Click on MEN menu
        WebElement menMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='MEN']")));
        menMenu.click();
        System.out.println("✅ Clicked MEN menu");

        // Helper method to hover and take screenshot
        hoverAndScreenshot("Grooming & Personal Care");
        hoverAndScreenshot("As Seen On TikTok");
        hoverAndScreenshot("Eyewear");
        hoverAndScreenshot("International Fragrances");
        hoverAndScreenshot("Arabic Fragrances");
        hoverAndScreenshot("Niche Fragrances");
        hoverAndScreenshot("Sports");
        hoverAndScreenshot("Footwear");
        hoverAndScreenshot("Apparel");

        // Wait for Pajama Sets link visible (submenu fully loaded)
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Pajama Sets']")));

        // Find all brand links under MEN > Apparel
        // Locator adapted: <a href contains "/men/" and "/br/"> <strong>Brand Name</strong> </a>
        List<WebElement> brandElements = driver.findElements(By.xpath("//a[contains(@href,'/men/') and contains(@href,'/br/')]/strong"));
        System.out.println("🧾 Found " + brandElements.size() + " brands:");

        List<String> brands = new ArrayList<>();
        for (WebElement brand : brandElements) {
            String brandName = brand.getText().trim();
            System.out.println("👉 " + brandName);
            brands.add(brandName);
        }

        // Save brands to CSV file
        try (FileWriter csvWriter = new FileWriter("brands.csv")) {
            for (String brand : brands) {
                csvWriter.append(brand).append("\n");
            }
        }
        System.out.println("✅ Saved all brands to brands.csv");

        // Click on a specific brand (case-insensitive)
        String targetBrand = "adidas";
        WebElement brandToClick = null;
        for (WebElement brand : brandElements) {
            if (brand.getText().equalsIgnoreCase(targetBrand)) {
                brandToClick = brand;
                break;
            }
        }
        if (brandToClick == null) {
            throw new RuntimeException("Brand not found: " + targetBrand);
        }

        // Click the brand's parent anchor <a>
        brandToClick.findElement(By.xpath("..")).click();
        System.out.println("👉 Clicking on: " + targetBrand);

        // Verify URL contains brand slug (lowercase)
        String expectedSlug = targetBrand.toLowerCase().replaceAll("\\s+", "-");
        wait.until(ExpectedConditions.urlContains(expectedSlug));
        System.out.println("✅ Redirected to " + targetBrand + " brand page");
        System.out.println("🌐 Current URL: " + driver.getCurrentUrl());

        // Wait for product image to load (using alt attribute partial match)
        WebElement productImage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//img[contains(@alt, 'Duramo Speed Running Shoes - Navy')]")));

        // Hover over first adidas product image
        actions.moveToElement(productImage).perform();
        System.out.println("🖱️ Hovered over first adidas product image");
        Thread.sleep(2000);

        // Wait for "View" button on hover
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.action.tocart.primary")));
        System.out.println("👁️ \"View\" button appeared on hover");

        // Screenshot hover state
        takeScreenshot("hover-state.png");

        // Optional: Hover over container of a specific product by title
        String productTitle = "Eclyptix 2000 Sneakers - Grey";
        WebElement titleElement = driver.findElement(By.xpath("//text()[contains(.,'" + productTitle + "')]/parent::*"));
        // Move to grandparent container (adjust if needed)
        WebElement container = titleElement.findElement(By.xpath("../.."));
        actions.moveToElement(container).perform();
        System.out.println("🖱️ Hovered over container of: " + productTitle);
        Thread.sleep(2000);
        takeScreenshot("hoverImage-state.png");
    }

//    private void hoverAndScreenshot(String linkText) throws IOException, InterruptedException {
//        WebElement element = driver.findElement(
//                By.xpath("//a[contains(@class,'noWrap') and contains(@class,'upperCase') and text()='" + linkText + "']"));
//        actions.moveToElement(element).perform();
//        System.out.println("✅ Hovered over " + linkText);
//        Thread.sleep(2000);
//        takeScreenshot("hover-" + linkText.replaceAll("\\s+", "") + ".png");
//    }
private void hoverAndScreenshot(String linkText) throws IOException, InterruptedException {
    By locator = By.xpath("//a[contains(@class,'noWrap') and contains(@class,'upperCase') and text()='" + linkText + "']");
    WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator)); // ⬅️ Updated
    actions.moveToElement(element).perform();
    System.out.println("✅ Hovered over " + linkText);
    Thread.sleep(2000);
    takeScreenshot("hover-" + linkText.replaceAll("\\s+", "") + ".png");
}


    private void takeScreenshot(String fileName) throws IOException {
        var srcFile = ((org.openqa.selenium.TakesScreenshot) driver).getScreenshotAs(org.openqa.selenium.OutputType.FILE);
        java.nio.file.Files.copy(srcFile.toPath(), java.nio.file.Paths.get(fileName), java.nio.file.StandardCopyOption.REPLACE_EXISTING);
        System.out.println("📸 Screenshot saved: " + fileName);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
