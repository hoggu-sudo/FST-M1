package examples;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity21 {

    public static void main(String[] args) {

        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://training-support.net/webelements/tabs");

        System.out.println("Page title: " + driver.getTitle());

        System.out.println("Current tab: " + driver.getWindowHandle());

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[text()='Open A New Tab']"))).click();

        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        Set<String> handles = driver.getWindowHandles();
        System.out.println("All tabs: " + handles);

        for (String handle : handles) {
            driver.switchTo().window(handle);
        }

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(text(),'Another One')]")));

        System.out.println("New tab title: " + driver.getTitle());
        System.out.println("Message: " + driver.findElement(By.cssSelector("h2.mt-5")).getText());

        driver.findElement(By.xpath("//button[contains(text(),'Another One')]")).click();

        wait.until(ExpectedConditions.numberOfWindowsToBe(3));

        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }

        driver.quit();
    }
}