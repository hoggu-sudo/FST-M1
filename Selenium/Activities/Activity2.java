package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {
    public static void main(String[] args) {

        // Step 1: Open browser
        WebDriver driver = new FirefoxDriver();

        // Step 2: Open website
        driver.get("https://training-support.net/webelements/login-form");

        // Step 3: Print page title
        System.out.println("Page title: " + driver.getTitle());

        // Step 4: Enter username
        driver.findElement(By.id("username")).sendKeys("admin");

        // Step 5: Enter password
        driver.findElement(By.id("password")).sendKeys("password");

        // Step 6: Click login button
        driver.findElement(By.xpath("//button[text()='Submit']")).click();

        // Step 7: Print login message
        String message = driver.findElement(By.tagName("h1")).getText();
        System.out.println("Login message: " + message);

        // Step 8: Close browser
        driver.quit();
    }
}
