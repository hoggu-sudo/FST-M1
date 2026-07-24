package activities;

import static org.testng.Assert.assertTrue;

import java.net.URI;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class TestActivity6 {

    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws Exception {

        UiAutomator2Options options =
                new UiAutomator2Options();

        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");

        options.setAppPackage("com.android.chrome");
        options.setAppActivity(
                "com.google.android.apps.chrome.Main");

        options.noReset();

        URL serverURL =
                new URI("http://127.0.0.1:4723")
                        .toURL();

        driver =
                new AndroidDriver(serverURL, options);

        wait =
                new WebDriverWait(
                        driver,
                        Duration.ofSeconds(20));

        driver.get(
                "https://training-support.net/webelements/sliders");
    }

    @Test(priority = 1)
    public void volume75Test() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.xpath("//android.widget.SeekBar")));

        Dimension dims =
                driver.manage().window().getSize();

        Point start =
                new Point(
                        (int) (dims.getWidth() * 0.50),
                        (int) (dims.getHeight() * 0.77));

        Point end =
                new Point(
                        (int) (dims.getWidth() * 0.67),
                        (int) (dims.getHeight() * 0.77));

        new ActionsBase().doSwipe(
                driver,
                1500,
                start,
                end);

        String volumeText =
                driver.findElement(
                        AppiumBy.xpath(
                                "//android.view.View/android.widget.TextView[contains(@text,'%')]"))
                        .getText();

        System.out.println(
                "Volume after 75% move: "
                        + volumeText);

        assertTrue(volumeText.contains("75%"));
    }

    @Test(priority = 2)
    public void volume25Test() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.xpath("//android.widget.SeekBar")));

        Dimension dims =
                driver.manage().window().getSize();

        Point start =
                new Point(
                        (int) (dims.getWidth() * 0.50),
                        (int) (dims.getHeight() * 0.77));

        Point end =
                new Point(
                        (int) (dims.getWidth() * 0.33),
                        (int) (dims.getHeight() * 0.77));

        new ActionsBase().doSwipe(
                driver,
                1500,
                start,
                end);

        String volumeText =
                driver.findElement(
                        AppiumBy.xpath(
                                "//android.view.View/android.widget.TextView[contains(@text,'%')]"))
                        .getText();

        System.out.println(
                "Volume after 25% move: "
                        + volumeText);

        assertTrue(volumeText.contains("25%"));
    }

    @AfterClass
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}