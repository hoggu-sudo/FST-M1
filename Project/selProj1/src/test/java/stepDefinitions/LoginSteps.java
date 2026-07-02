package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.*;
import io.cucumber.java.en.*;

public class LoginSteps extends BaseClass {

    @Before
    public void start() {
        setUp();
    }

    @Given("user opens CRM site")
    public void openSite() {
        driver.get("https://crm.alchemy.hguy.co");
    }

    @When("user enters valid credentials")
    public void enterCredentials() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("5Nx#I6BK%r3$8vz0ch");
    }

    @And("clicks login button")
    public void clickLogin() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("user should see homepage")
    public void verifyHome() {
        wait.until(ExpectedConditions.urlContains("home"));
        System.out.println("✅ Login Successful");
    }

    @After
    public void close() {
        tearDown();
    }
}