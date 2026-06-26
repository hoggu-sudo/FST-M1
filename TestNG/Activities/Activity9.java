package examples;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity9 {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://training-support.net/webelements/alerts");
    }

    @BeforeMethod
    public void reset() {
        driver.switchTo().defaultContent();
    }

    @Test
    public void simpleAlertTestCase() {
        driver.findElement(By.id("simple")).click();
        Alert alert = driver.switchTo().alert();

        Assert.assertTrue(alert.getText().toLowerCase().contains("alert"));

        alert.accept();
    }

    @Test
    public void confirmAlertTestCase() {
        driver.findElement(By.id("confirmation")).click();
        Alert alert = driver.switchTo().alert();

        Assert.assertTrue(alert.getText().contains("confirmation"));

        alert.accept();
    }

    @Test
    public void promptAlertTestCase() {
        driver.findElement(By.id("prompt")).click();
        Alert alert = driver.switchTo().alert();

        Assert.assertTrue(alert.getText().toLowerCase().contains("prompt"));

        alert.sendKeys("Awesome!");
        alert.accept();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

