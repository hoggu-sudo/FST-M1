package stepDefinitions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

    public static WebDriver driver;
    public static WebDriverWait wait;

    public static void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public static void tearDown() {
        driver.quit();
    }
    
    public void clickMenu(String menuName) {

        WebElement navBar = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.cssSelector("nav"))
        );

        List<WebElement> menus = navBar.findElements(By.cssSelector("a"));

        for (WebElement menu : menus) {

            System.out.println("Menu Found: " + menu.getText()); // ✅ Debug

            if (menu.isDisplayed() &&
                menu.getText().trim().equalsIgnoreCase(menuName)) {

                menu.click();
                return;
            }
        }

        throw new RuntimeException("Menu not found: " + menuName);
    }

    
}

