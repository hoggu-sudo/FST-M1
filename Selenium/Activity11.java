package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity11 {
    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        Actions actions = new Actions(driver);

        driver.get("https://training-support.net/webelements/keyboard-events");

        System.out.println("Page title: " + driver.getTitle());

        actions.sendKeys("This is coming from Selenium")
               .sendKeys(Keys.ENTER)
               .perform();

        String result = driver.findElement(By.cssSelector("h1.mt-3")).getText();
        System.out.println("Message displayed: " + result);

        driver.quit();
    }
}