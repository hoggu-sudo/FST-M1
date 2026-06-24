package examples;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity8 {
    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://training-support.net/webelements/dynamic-controls");

        System.out.println("Page title: " + driver.getTitle());

        System.out.println("Checkbox visible: " +
                driver.findElement(By.id("checkbox")).isDisplayed());

        driver.findElement(By.xpath("//button[text()='Toggle Checkbox']")).click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("checkbox")));

        System.out.println("Checkbox visible after removal: false");

        driver.findElement(By.xpath("//button[text()='Toggle Checkbox']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkbox")));

        driver.findElement(By.id("checkbox")).click();

        System.out.println("Checkbox selected: " +
                driver.findElement(By.id("checkbox")).isSelected());

        driver.quit();
    }
}

