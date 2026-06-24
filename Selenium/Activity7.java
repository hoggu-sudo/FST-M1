package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity7 {
    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();

        driver.get("https://training-support.net/webelements/dynamic-controls");

        System.out.println("Page title: " + driver.getTitle());

        WebElement textbox = driver.findElement(By.id("textInput"));

        System.out.println("Textbox initially enabled: " + textbox.isEnabled());

        driver.findElement(By.id("textInputButton")).click();

        System.out.println("Textbox after click enabled: " + textbox.isEnabled());

        if (textbox.isEnabled()) {
            textbox.sendKeys("Example text");
            System.out.println("Entered text: " + textbox.getDomProperty("value"));
        }

        driver.quit();
    }
}
