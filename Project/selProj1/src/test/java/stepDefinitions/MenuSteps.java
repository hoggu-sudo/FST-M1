package stepDefinitions;

import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.cucumber.java.en.*;

public class MenuSteps extends BaseClass {

    @When("user logs in")
    public void loginAgain() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));

        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("5Nx#I6BK%r3$8vz0ch");

        driver.findElement(By.id("login-button")).click();

        wait.until(ExpectedConditions.urlContains("home"));
    }

    @Then("activities menu should be visible")
    public void checkMenu() {

        List<WebElement> menus = wait.until(
            ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("nav a"))
        );

        for (WebElement menu : menus) {
            if (menu.isDisplayed() &&
                menu.getText().toLowerCase().equalsIgnoreCase("Activities")) {

                System.out.println("✅ Activities menu found");
                return;
            }
        }

        throw new RuntimeException("❌ Activities menu NOT found");
    }
}