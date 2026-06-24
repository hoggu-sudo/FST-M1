package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5 {
    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();

        driver.get("https://training-support.net/webelements/dynamic-controls");

        System.out.println("Page title: " + driver.getTitle());

        boolean isVisible = driver.findElements(By.id("checkbox")).size() > 0;
        System.out.println("Checkbox visible before click: " + isVisible);

        driver.findElement(By.xpath("//button[text()='Toggle Checkbox']")).click();

        isVisible = driver.findElements(By.id("checkbox")).size() > 0;
        System.out.println("Checkbox visible after removal: " + isVisible);

        driver.findElement(By.xpath("//button[text()='Toggle Checkbox']")).click();

        isVisible = driver.findElements(By.id("checkbox")).size() > 0;
        System.out.println("Checkbox visible after adding back: " + isVisible);

        driver.quit();
    }
}
