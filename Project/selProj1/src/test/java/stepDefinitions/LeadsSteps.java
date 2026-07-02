package stepDefinitions;

import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.cucumber.java.en.*;

public class LeadsSteps extends BaseClass {

    // ✅ LOGIN STEP
    @Given("user logs in to CRM")
    public void login() {

        driver.get("https://crm.alchemy.hguy.co");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));

        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("5Nx#I6BK%r3$8vz0ch");

        driver.findElement(By.id("login-button")).click();

        wait.until(ExpectedConditions.urlContains("home"));
    }

    // ✅ NAVIGATE TO LEADS (USED BY MULTIPLE TESTS)
    @When("user navigates to Leads page")
    public void navigateToLeads() {

    	clickMenu("Sales");  // ✅ Reusable navigation

        WebElement leads = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(text(),'Leads')]")
            )
        );

        leads.click();

        // ✅ IMPORTANT: wait for table
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("table")));
    }

    // ✅ CLICK ADDITIONAL INFO ICON
    @And("user clicks additional information icon")
    public void clickInfoIcon() {

        List<WebElement> icons = wait.until(
            ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.xpath("//table//tr//i | //table//tr//button")
            )
        );

        for (WebElement icon : icons) {
            if (icon.isDisplayed()) {
                icon.click();
                break;
            }
        }
    }

    // ✅ READ POPUP PHONE NUMBER
    @Then("user should see phone number in popup")
    public void readPopup() {

        WebElement popup = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(text(),'Mobile')]")
            )
        );

        String popupText = popup.getText();

        System.out.println("Popup Content: " + popupText);

        String phone = popupText.replaceAll("[^0-9]", "");
        System.out.println("📞 Phone Number: " + phone);
    }

    // ✅ TABLE: FIRST 10 NAME + USER COLUMNS
    @Then("user prints first 10 names and users from table")
    public void printTableData() {

        List<WebElement> rows = wait.until(
            ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.xpath("//table/tbody/tr")
            )
        );

        System.out.println("🔹 First 10 Names and Users:\n");

        for (int i = 0; i < rows.size() && i < 10; i++) {

            WebElement row = rows.get(i);

            String name = row.findElement(By.xpath("./td[2]")).getText();
            String user = row.findElement(By.xpath("./td[7]")).getText();

            System.out.println("Row " + (i + 1));
            System.out.println("Name: " + name);
            System.out.println("User: " + user);
            System.out.println("-------------------");
        }
    }
}