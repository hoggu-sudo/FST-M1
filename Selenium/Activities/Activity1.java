package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity1 {
    public static void main(String[] args) {

        // Step 1: Launch browser
        WebDriver driver = new FirefoxDriver();

        // Step 2: Open website
        driver.get("https://training-support.net");

        // Step 3: Print page title
        System.out.println("Page title is: " + driver.getTitle());

        // Step 4: Click "About Us" link
        driver.findElement(By.linkText("About Us")).click();

        // Step 5: Print new page title
        System.out.println("New page title is: " + driver.getTitle());

        // Step 6: Close browser
        driver.quit();
    }
}