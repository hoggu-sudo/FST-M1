package activities;

import java.net.URI;
import java.net.URL;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class TestActivity2 {

    AndroidDriver driver;

    @BeforeClass
    public void setUp() throws Exception {

        UiAutomator2Options options =
                new UiAutomator2Options();

        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");

        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");

        options.noReset();

        URL serverURL =
                new URI("http://127.0.0.1:4723")
                        .toURL();

        driver =
                new AndroidDriver(serverURL, options);

        driver.get("https://training-support.net");
    }

    @Test
    public void chromeTest() {

    	String pageHeading =
    	        driver.findElement(
    	                AppiumBy.xpath("//*[@text='Training Support']"))
    	                .getText();


        System.out.println(
                "Heading: " + pageHeading);

        driver.findElement(
                AppiumBy.accessibilityId("About Us"))
                .click();

        String aboutPageHeading =
                driver.findElement(
                        AppiumBy.xpath(
                                "//android.widget.TextView[@text='About Us']"))
                        .getText();

        System.out.println(
                "About Page Heading: " + aboutPageHeading);
    }

    @AfterClass
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}