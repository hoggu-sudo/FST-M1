package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.Then;

public class ColorSteps extends BaseClass {

    @Then("user prints navigation bar color")
    public void getNavBarColor() {

        // ✅ Wait for navigation bar
        WebElement navBar = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("nav")
            )
        );

        // ✅ Get background color
        String color = navBar.getCssValue("background-color");

        // ✅ Convert to HEX
        String hexColor = Color.fromString(color).asHex();

        System.out.println("RGBA Color: " + color);
        System.out.println("HEX Color: " + hexColor);
    }
}