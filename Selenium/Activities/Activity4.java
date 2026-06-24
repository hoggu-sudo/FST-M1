package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;

public class Activity4 {
    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();

        driver.get("https://training-support.net/webelements/target-practice");

        System.out.println("Page title: " + driver.getTitle());

        String thirdHeader = driver.findElement(
                By.xpath("//h3[contains(text(),'#3')]")
        ).getText();
        System.out.println("Third header: " + thirdHeader);

        String colorValue = driver.findElement(
                By.xpath("//h5[contains(text(),'#5')]")
        ).getCssValue("color");

        Color color = Color.fromString(colorValue);
        System.out.println("RGB: " + color.asRgb());
        System.out.println("HEX: " + color.asHex());

        String purpleClasses = driver.findElement(
                By.xpath("//button[text()='Purple']")
        ).getDomAttribute("class");
        System.out.println("Purple classes: " + purpleClasses);

        String slateText = driver.findElement(
                By.xpath("//button[text()='Slate']")
        ).getText();
        System.out.println("Slate button text: " + slateText);

        driver.quit();
    }
}
