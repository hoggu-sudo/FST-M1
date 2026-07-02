package stepDefinitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountsSteps extends BaseClass {

	@When("user navigates to Accounts page")
	public void goToAccounts() {

	    clickMenu("Sales");   // ✅ correct way

	    WebElement accounts = wait.until(
	        ExpectedConditions.elementToBeClickable(
	            By.xpath("//*[contains(text(),'Accounts')]")
	        )
	    );

	    accounts.click();

	    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("table")));
	}
	

    @Then("user prints first 5 odd rows from accounts table")
    public void printOddRows() {

        // ✅ Get ALL rows
        List<WebElement> rows = driver.findElements(
            By.xpath("//table//tbody/tr")
        );

        System.out.println("🔹 First 5 odd rows (Names):");

        int count = 0;

        for (int i = 0; i < rows.size(); i++) {

            // ✅ Odd index (1,3,5,7,9 → index 0,2,4,6,8)
            if (i % 2 == 0) {

                String name = rows.get(i)
                        .findElement(By.xpath("./td[2]")) // Name column
                        .getText();

                System.out.println("Row " + (i + 1) + ": " + name);

                count++;

                if (count == 5) break; // ✅ only 5 rows
            }
        }
    }
    

}