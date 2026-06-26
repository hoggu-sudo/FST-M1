package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity3 {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://training-support.net/webelements/login-form/");
    }

    @Test
    public void loginTest() {

        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password");

        driver.findElement(By.xpath("//button[text()='Submit']")).click();

        String msg = driver.findElement(By.tagName("h1")).getText();

        Assert.assertEquals(msg, "Login successful");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

