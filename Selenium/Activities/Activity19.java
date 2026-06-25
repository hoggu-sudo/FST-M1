package examples;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity19 {

    public static void main(String[] args) {

        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();

        driver.get("https://training-support.net/webelements/alerts");

        System.out.println("Page title: " + driver.getTitle());

        driver.findElement(By.id("confirmation")).click();

        Alert alert = driver.switchTo().alert();

        System.out.println("Alert text: " + alert.getText());

        alert.accept();
        System.out.println("After OK: " + driver.findElement(By.id("result")).getText());

        driver.findElement(By.id("confirmation")).click();

        alert = driver.switchTo().alert();

        alert.dismiss();
        System.out.println("After Cancel: " + driver.findElement(By.id("result")).getText());

        driver.quit();
    }
}