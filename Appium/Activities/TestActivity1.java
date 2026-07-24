package activities;

import java.net.URI;
import java.net.URL;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class TestActivity1 {

    AndroidDriver driver;

    @BeforeClass
    public void setUp() throws Exception {

        UiAutomator2Options options =
                new UiAutomator2Options();

        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");

        // Replace with values from Inspector
        options.setAppPackage("com.google.android.calculator");
        options.setAppActivity("com.android.calculator2.Calculator");

        options.noReset();

        URL serverUrl =
                new URI("http://127.0.0.1:4723")
                        .toURL();

        driver =
                new AndroidDriver(serverUrl, options);
    }

    @Test
    public void multiplyTest() {

        driver.findElement(
                AppiumBy.id("digit_5"))
                .click();

        driver.findElement(
                AppiumBy.accessibilityId("multiply"))
                .click();

        driver.findElement(
                AppiumBy.id("digit_8"))
                .click();

        driver.findElement(
                AppiumBy.accessibilityId("equals"))
                .click();

        String result =
                driver.findElement(
                        AppiumBy.id("result_final"))
                        .getText();

        Assert.assertEquals(result, "40");
    }

    @AfterClass
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}