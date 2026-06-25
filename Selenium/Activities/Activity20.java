package examples;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity20 {

    public static void main(String[] args) {

        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();

        driver.get("https://training-support.net/webelements/alerts");

        System.out.println("Page title: " + driver.getTitle());

        driver.findElement(By.id("prompt")).click();

        Alert alert = driver.switchTo().alert();

        System.out.println("Alert text: " + alert.getText());

        alert.sendKeys("Awesome!");

        alert.accept();

        System.out.println("Result: " + driver.findElement(By.id("result")).getText());

        driver.quit();
    }
}
