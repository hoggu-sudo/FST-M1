package examples;


import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity5 {

    WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://training-support.net/webelements/target-practice");
    }

    @Test(groups = {"HeaderTests", "ButtonTests"})
    public void pageTitleTest() {
        Assert.assertEquals(driver.getTitle(), "Selenium: Target Practice");
    }

    @Test(groups = "HeaderTests")
    public void headerTest1() {
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).getText().contains("Heading"));
    }

    @Test(groups = "HeaderTests")
    public void headerTest2() {
        Assert.assertTrue(driver.findElement(By.tagName("h5")).isDisplayed());
    }

    @Test(groups = "ButtonTests")
    public void buttonTest1() {
        Assert.assertEquals(
            driver.findElement(By.xpath("//button[contains(@class,'emerald')]")).getText(),
            "Emerald"
        );
    }

    @Test(groups = "ButtonTests")
    public void buttonTest2() {
        Assert.assertTrue(driver.findElement(By.xpath("(//button)[3]")).isDisplayed());
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
