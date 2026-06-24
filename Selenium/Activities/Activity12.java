package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity12 {
    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        Actions actions = new Actions(driver);

        driver.get("https://training-support.net/webelements/drag-drop");

        System.out.println("Page title: " + driver.getTitle());

        WebElement ball = driver.findElement(By.id("ball"));
        WebElement dropzone1 = driver.findElement(By.id("dropzone1"));
        WebElement dropzone2 = driver.findElement(By.id("dropzone2"));

        actions.dragAndDrop(ball, dropzone1).perform();

        String dz1Text = dropzone1.findElement(By.className("dropzone-text")).getText();
        if (dz1Text.equals("Dropped!")) {
            System.out.println("Ball successfully dropped in Dropzone 1");
        }

        actions.dragAndDrop(ball, dropzone2).perform();

        String dz2Text = dropzone2.findElement(By.className("dropzone-text")).getText();
        if (dz2Text.equals("Dropped!")) {
            System.out.println("Ball successfully dropped in Dropzone 2");
        }

        driver.quit();
    }
}