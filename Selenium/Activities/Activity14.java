package examples;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity14 {

    public static void main(String[] args) {

        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();

        driver.get("https://training-support.net/webelements/tables");

        System.out.println("Page Title: " + driver.getTitle());

        List<WebElement> cols = driver.findElements(
                By.xpath("//table[contains(@class,'table-auto')]//thead//th"));
        System.out.println("Number of Columns: " + cols.size());

        List<WebElement> rows = driver.findElements(
                By.xpath("//table[contains(@class,'table-auto')]//tbody//tr"));
        System.out.println("Number of Rows: " + rows.size());

        WebElement bookNameBefore = driver.findElement(
                By.xpath("//table[contains(@class,'table-auto')]//tbody//tr[5]//td[2]"));
        System.out.println("Book Name before sorting: " + bookNameBefore.getText());

        driver.findElement(
                By.xpath("//table[contains(@class,'table-auto')]//thead//th[5]")).click();

        WebElement bookNameAfter = driver.findElement(
                By.xpath("//table[contains(@class,'table-auto')]//tbody//tr[5]//td[2]"));
        System.out.println("Book Name after sorting: " + bookNameAfter.getText());

        driver.quit();
    }
}