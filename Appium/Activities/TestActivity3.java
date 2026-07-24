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

public class TestActivity3 {

    AndroidDriver driver;

    @BeforeClass
    public void setUp() throws Exception {

        UiAutomator2Options options = new UiAutomator2Options();

        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");

        // Option 1: If Calculator APK is available
        // options.setApp("C:/Apps/calculator.apk");

        // Option 2: If Calculator app already installed
        options.setAppPackage("com.google.android.calculator");
        options.setAppActivity("com.android.calculator2.Calculator");

        options.noReset();

        URL serverURL =
                new URI("http://127.0.0.1:4723")
                        .toURL();

        driver = new AndroidDriver(serverURL, options);
    }

    @Test(priority = 1)
    public void additionTest() {

        driver.findElement(AppiumBy.id("digit_5")).click();
        driver.findElement(AppiumBy.accessibilityId("plus")).click();
        driver.findElement(AppiumBy.id("digit_9")).click();
        driver.findElement(AppiumBy.accessibilityId("equals")).click();

        String result =
                driver.findElement(AppiumBy.id("result_final"))
                        .getText();

        System.out.println("5 + 9 = " + result);

        Assert.assertEquals(result, "14");
    }

    @Test(priority = 2)
    public void subtractTest() {

        driver.findElement(AppiumBy.id("digit_1")).click();
        driver.findElement(AppiumBy.id("digit_0")).click();
        driver.findElement(AppiumBy.accessibilityId("minus")).click();
        driver.findElement(AppiumBy.id("digit_5")).click();
        driver.findElement(AppiumBy.accessibilityId("equals")).click();

        String result =
                driver.findElement(AppiumBy.id("result_final"))
                        .getText();

        System.out.println("10 - 5 = " + result);

        Assert.assertEquals(result, "5");
    }

    @Test(priority = 3)
    public void multiplyTest() {

        driver.findElement(AppiumBy.id("digit_5")).click();
        driver.findElement(AppiumBy.accessibilityId("multiply")).click();
        driver.findElement(AppiumBy.id("digit_1")).click();
        driver.findElement(AppiumBy.id("digit_0")).click();
        driver.findElement(AppiumBy.id("digit_0")).click();
        driver.findElement(AppiumBy.accessibilityId("equals")).click();

        String result =
                driver.findElement(AppiumBy.id("result_final"))
                        .getText();

        System.out.println("5 * 100 = " + result);

        Assert.assertEquals(result, "500");
    }

    @Test(priority = 4)
    public void divideTest() {

        driver.findElement(AppiumBy.id("digit_5")).click();
        driver.findElement(AppiumBy.id("digit_0")).click();
        driver.findElement(AppiumBy.accessibilityId("divide")).click();
        driver.findElement(AppiumBy.id("digit_2")).click();
        driver.findElement(AppiumBy.accessibilityId("equals")).click();

        String result =
                driver.findElement(AppiumBy.id("result_final"))
                        .getText();

        System.out.println("50 / 2 = " + result);

        Assert.assertEquals(result, "25");
    }

    @AfterClass
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}