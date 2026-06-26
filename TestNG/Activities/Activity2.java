package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity2 {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://training-support.net/webelements/target-practice/");
    }

    @Test
    public void testCase1() {
        String title = driver.getTitle();
        System.out.println("Title: " + title);
        Assert.assertEquals(title, "Selenium: Target Practice");
    }

    @Test
    public void testCase2() {
        WebElement blackButton = driver.findElement(By.cssSelector("button.black"));

        // Wrong assertion (intentional fail)
        Assert.assertEquals(blackButton.getText(), "BLACK"); 
    }

    @Test(enabled = false)
    public void testCase3() {
        // This will not run (silent skip)
        System.out.println("This test is disabled");
    }

    @Test
    public void testCase4() {
        // Explicit skip
        throw new SkipException("Skipping this test intentionally");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

