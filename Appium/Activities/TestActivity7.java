package activities;

import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class TestActivity7 {

    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws Exception {

        UiAutomator2Options options = new UiAutomator2Options();

        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");

        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");

        options.noReset();

        URL serverURL =
                new URI("http://127.0.0.1:4723")
                        .toURL();

        driver = new AndroidDriver(serverURL, options);

        wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(10));

        driver.get(
                "https://training-support.net/webelements/lazy-loading");
    }

    @Test
    public void uiScrollableTest() {

        // Wait for page to load
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        AppiumBy.className("android.widget.Image")));

        String uiScrollable =
                "new UiScrollable(new UiSelector().scrollable(true))";

        // Images before scroll
        List<WebElement> imageElements =
                driver.findElements(
                        AppiumBy.className("android.widget.Image"));

        System.out.println(
                "Before scroll: " + imageElements.size());

        // Scroll to Helen
        String imageText =
                driver.findElement(
                        AppiumBy.androidUIAutomator(
                                uiScrollable +
                                ".scrollIntoView(text(\"Helen\"))"))
                        .getText();

        System.out.println(
                "Found " + imageText + "!");

        // Images after scroll
        imageElements =
                driver.findElements(
                        AppiumBy.className("android.widget.Image"));

        System.out.println(
                "After scroll: " + imageElements.size());

        Assert.assertEquals(
                imageElements.size(),
                3);
    }

    @AfterClass
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}