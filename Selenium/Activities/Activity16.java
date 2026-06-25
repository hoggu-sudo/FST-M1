package examples;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity16 {
    public static void main(String[] args) {

        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();

        driver.get("https://training-support.net/webelements/selects");

        System.out.println("Page title is: " + driver.getTitle());

        WebElement dropdown = driver.findElement(By.cssSelector("select.h-10"));

        Select select = new Select(dropdown);

        select.selectByVisibleText("Two");
        System.out.println("Selected (visible text): " + 
            select.getFirstSelectedOption().getText());

        select.selectByIndex(3);
        System.out.println("Selected (index): " + 
            select.getFirstSelectedOption().getText());

        select.selectByValue("four");
        System.out.println("Selected (value): " + 
            select.getFirstSelectedOption().getText());

        List<WebElement> options = select.getOptions();
        System.out.println("\nAll options:");
        for (WebElement option : options) {
            System.out.println(option.getText());
        }

        driver.quit();
    }
}