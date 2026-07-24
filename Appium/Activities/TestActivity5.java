package activities;

import java.net.URI;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;

public class TestActivity5 {

    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws Exception {

        UiAutomator2Options options = new UiAutomator2Options();

        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");

        options.setAppPackage("com.google.android.apps.messaging");
        options.setAppActivity(".ui.ConversationListActivity");

        options.noReset();

        URL serverURL =
                new URI("http://127.0.0.1:4723")
                        .toURL();

        driver = new AndroidDriver(serverURL, options);

        wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(10));
    }

    @Test
    public void smsTest() {

        // Create new message
        driver.findElement(
                AppiumBy.accessibilityId("Start new conversation"))
                .click();

        // Wait for recipient field
        wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.id("recipient_text_view")));

        // Enter phone number
        driver.findElement(
                AppiumBy.id("recipient_text_view"))
                .sendKeys("999148292");

        // Press Enter
        driver.pressKey(
                new KeyEvent(AndroidKey.ENTER));

        // Wait for message box
        wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.id("compose_message_text")));

        // Enter message
        driver.findElement(
                AppiumBy.id("compose_message_text"))
                .sendKeys("Hello from Appium");

        // Send message
        driver.findElement(
                AppiumBy.accessibilityId("Send SMS"))
                .click();

        // Verify sent message
        String sentMessage =
                driver.findElement(
                        AppiumBy.id("message_text"))
                        .getText();

        System.out.println(
                "Sent Message: " + sentMessage);

        Assert.assertEquals(
                sentMessage,
                "Hello from Appium");
    }

    @AfterClass
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}