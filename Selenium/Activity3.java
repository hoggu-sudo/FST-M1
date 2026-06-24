package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class Activity3 {
    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();

        driver.get("https://training-support.net/webelements/login-form");

        System.out.println("Page title: " + driver.getTitle());

        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("password");

        driver.findElement(By.xpath("//button[text()='Submit']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        String message = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h1")  
            )
        ).getText();

        System.out.println("Login message: " + message);

        driver.quit();
    }
}