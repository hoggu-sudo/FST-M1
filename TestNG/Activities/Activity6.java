package examples;


import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity6 {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://training-support.net/webelements/login-form/");
    }

    @Test
    @Parameters({"username", "password"})
    public void loginTest(String username, String password) {

        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);

        driver.findElement(By.xpath("//button[text()='Submit']")).click();

        String msg = driver.findElement(By.tagName("h1")).getText();

        Assert.assertTrue(msg.toLowerCase().contains("login"));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}