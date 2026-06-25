package examples;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity13 {

    public static void main(String[] args) {

    	WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();

        driver.get("https://training-support.net/webelements/tables");

        System.out.println("Page Title: " + driver.getTitle());

        List<WebElement> columns = driver.findElements(
                By.xpath("//table[contains(@class,'table-auto')]//thead//th"));
        System.out.println("Number of Columns: " + columns.size());

        List<WebElement> rows = driver.findElements(
                By.xpath("//table[contains(@class,'table-auto')]//tbody//tr"));
        System.out.println("Number of Rows: " + rows.size());

        List<WebElement> thirdRow = driver.findElements(
                By.xpath("//table[contains(@class,'table-auto')]//tbody//tr[3]//td"));

        System.out.println("\nThird Row Values:");
        for (WebElement cell : thirdRow) {
            System.out.println(cell.getText());
        }

        WebElement cell = driver.findElement(
                By.xpath("//table[contains(@class,'table-auto')]//tbody//tr[2]//td[2]"));

        System.out.println("\nValue of 2nd Row, 2nd Column: " + cell.getText());

        driver.quit();
    }
}