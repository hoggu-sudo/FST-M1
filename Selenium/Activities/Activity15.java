package examples;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity15 {

    public static void main(String[] args) {

        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://training-support.net/webelements/dynamic-attributes");

        System.out.println("Page title is: " + driver.getTitle());

        WebElement fullName = driver.findElement(
                By.xpath("//input[starts-with(@id,'full-name')]"));

        WebElement email = driver.findElement(
                By.xpath("//input[contains(@id,'-email')]"));

        WebElement eventDate = driver.findElement(
                By.xpath("//input[contains(@name,'event-date')]"));

        WebElement details = driver.findElement(
                By.xpath("//textarea[contains(@id,'additional')]"));

        fullName.sendKeys("Hema Sundar");
        email.sendKeys("hema@example.com");
        eventDate.sendKeys("2026-06-20");
        details.sendKeys("Automation testing using Selenium");

        driver.findElement(By.xpath("//button[text()='Submit']")).click();

        WebElement message = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("action-confirmation")));

        System.out.println("Success message: " + message.getText());

        driver.quit();
    }
}