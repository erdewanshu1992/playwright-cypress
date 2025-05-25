package com.flipkart.tests;

import com.flipkart.utils.DateUtils;
import com.flipkart.utils.FileUtils;
import com.flipkart.utils.RandomUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

public class UtilityTest {

    @Test
    public void testDateUtils() {
        // Test DateUtils
        String today = DateUtils.getCurrentDate();
        System.out.println("Today's Date: " + today);

        String dateAfter3Days = DateUtils.addDaysToCurrentDate(3);
        System.out.println("Date After 3 Days: " + dateAfter3Days);

        // Assert current date format (yyyy-MM-dd)
        Assert.assertTrue(today.matches("\\d{4}-\\d{2}-\\d{2}"));
        Assert.assertTrue(dateAfter3Days.matches("\\d{4}-\\d{2}-\\d{2}"));
    }

    @Test
    public void testFileUtils() throws IOException {
        // Test FileUtils

        // Write content to file
        FileUtils.writeFile("testFile.txt", "Hello, World!");

        // Read from file
        String content = FileUtils.readFile("testFile.txt");
        System.out.println("File Content: " + content);

        // Append to file
        FileUtils.appendToFile("testFile.txt", "\nAppended Text");

        // Read again
        String appendedContent = FileUtils.readFile("testFile.txt");
        System.out.println("Appended File Content: " + appendedContent);

        // Assert the file content
        Assert.assertTrue(content.equals("Hello, World!"));
        Assert.assertTrue(appendedContent.contains("Appended Text"));
    }

    @Test
    public void testRandomUtils() {
        // Test RandomUtils

        // Generate a random integer between 1 and 100
        int randomInt = RandomUtils.generateRandomInt(1, 100);
        System.out.println("Random Integer: " + randomInt);

        // Generate a random string of length 10
        String randomString = RandomUtils.generateRandomString(10);
        System.out.println("Random String: " + randomString);

        // Generate a random boolean
        boolean randomBoolean = RandomUtils.generateRandomBoolean();
        System.out.println("Random Boolean: " + randomBoolean);

        // Assert random integer is within bounds
        Assert.assertTrue(randomInt >= 1 && randomInt <= 100);
        Assert.assertTrue(randomString.length() == 10);
    }

    @Test
    public void testAllUtilities() throws IOException {
        // Combined Test for all utilities

        // Test DateUtils
        String currentDate = DateUtils.getCurrentDate();
        String futureDate = DateUtils.addDaysToCurrentDate(5);

        // Test RandomUtils
        String randomStr = RandomUtils.generateRandomString(8);
        int randomNum = RandomUtils.generateRandomInt(50, 150);

        // Test FileUtils
        FileUtils.writeFile("combinedTestFile.txt", "Testing combined utilities");

        // Read from the file to ensure FileUtils worked
        String fileContent = FileUtils.readFile("combinedTestFile.txt");

        // Assertions
        Assert.assertTrue(currentDate.matches("\\d{4}-\\d{2}-\\d{2}"));
        Assert.assertTrue(futureDate.matches("\\d{4}-\\d{2}-\\d{2}"));
        Assert.assertEquals(fileContent, "Testing combined utilities");
        Assert.assertTrue(randomStr.length() == 8);
        Assert.assertTrue(randomNum >= 50 && randomNum <= 150);
    }
}
