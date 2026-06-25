package examples;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity17 {

    public static void main(String[] args) {

        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();

        driver.get("https://training-support.net/webelements/selects");

        System.out.println("Page title: " + driver.getTitle());

        WebElement dropdown = driver.findElement(By.cssSelector("select.h-80"));

        Select multiSelect = new Select(dropdown);

        multiSelect.selectByVisibleText("HTML");

        multiSelect.selectByIndex(3);
        multiSelect.selectByIndex(4);
        multiSelect.selectByIndex(5);

        multiSelect.selectByValue("nodejs");

        System.out.println("\nSelected options:");
        List<WebElement> selected = multiSelect.getAllSelectedOptions();
        for (WebElement option : selected) {
            System.out.println(option.getText());
        }

        multiSelect.deselectByIndex(4);

        System.out.println("\nAfter deselecting index 4:");
        selected = multiSelect.getAllSelectedOptions();
        for (WebElement option : selected) {
            System.out.println(option.getText());
        }

        driver.quit();
    }
}
