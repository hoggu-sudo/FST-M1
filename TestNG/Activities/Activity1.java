package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity1 {

    WebDriver driver;

    // Before all tests
    @BeforeClass
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://training-support.net");
    }

    // Test 1 - Home page
    @Test(priority = 1)
    public void homePageTest() {
        String title = driver.getTitle();
        System.out.println("Home Page Title: " + title);

        // Assertion
        Assert.assertEquals(title, "Training Support");

        // Click About Us
        driver.findElement(By.linkText("About Us")).click();
    }

    // Test 2 - About page
    @Test(priority = 2)
    public void aboutPageTest() {
        String title = driver.getTitle();
        System.out.println("About Page Title: " + title);

        // Assertion
        Assert.assertEquals(title, "About Training Support");
    }

    // After all tests
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}