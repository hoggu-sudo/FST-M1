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
import io.appium.java_client.android.options.UiAutomator2Options;

public class TestActivity4 {

    // Driver Declaration
    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws Exception {

        UiAutomator2Options options = new UiAutomator2Options();

        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");

        options.setAppPackage("com.google.android.contacts");
        options.setAppActivity(
                "com.android.contacts.activities.PeopleActivity");

        options.noReset();

        URL serverURL =
                new URI("http://127.0.0.1:4723")
                        .toURL();

        driver =
                new AndroidDriver(serverURL, options);

        wait =
                new WebDriverWait(
                        driver,
                        Duration.ofSeconds(10));
    }

    @Test
    public void contactsTest() {

        // Click Create Contact
        driver.findElement(
                AppiumBy.accessibilityId("Create new contact"))
                .click();

        // Wait for form
        wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.xpath(
                                "//android.widget.EditText[@text='First name']")));

        // First Name
        driver.findElement(
                AppiumBy.xpath(
                        "//android.widget.EditText[@text='First name']"))
                .sendKeys("Aaditya");

        // Last Name
        driver.findElement(
                AppiumBy.xpath(
                        "//android.widget.EditText[@text='Last name']"))
                .sendKeys("Varma");

        // Phone Number
        driver.findElement(
                AppiumBy.xpath(
                        "//android.widget.EditText[@text='Phone']"))
                .sendKeys("999148292");

        // Save Contact
        driver.findElement(
                AppiumBy.id("editor_menu_save_button"))
                .click();

        // Wait Until Saved
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        AppiumBy.id("large_title")));

        // Verify Contact Name
        String contactName =
                driver.findElement(
                        AppiumBy.id("large_title"))
                        .getText();

        System.out.println(
                "Created Contact: " + contactName);

        Assert.assertEquals(
                contactName,
                "Aaditya Varma");
    }

    @AfterClass
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}