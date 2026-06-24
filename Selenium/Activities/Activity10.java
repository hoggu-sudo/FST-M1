package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity10 {
    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        Actions actions = new Actions(driver);

        driver.get("https://training-support.net/webelements/mouse-events");

        System.out.println("Page title: " + driver.getTitle());

        WebElement cargoLock = driver.findElement(By.xpath("//h1[text()='Cargo.lock']"));
        WebElement cargoToml = driver.findElement(By.xpath("//h1[text()='Cargo.toml']"));
        WebElement srcButton = driver.findElement(By.xpath("//h1[text()='src']"));
        WebElement targetButton = driver.findElement(By.xpath("//h1[text()='target']"));

        actions.click(cargoLock)
               .moveToElement(cargoToml)
               .click(cargoToml)
               .perform();

        System.out.println("First action result: " +
                driver.findElement(By.id("result")).getText());

        actions.doubleClick(srcButton).perform();

        actions.contextClick(targetButton).perform();

        driver.findElement(By.xpath("//ul/li[1]")).click();

        System.out.println("Second action result: " +
                driver.findElement(By.id("result")).getText());

        driver.quit();
    }
}