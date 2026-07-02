package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.*;

public class FooterSteps extends BaseClass {

    @Then("print footer text")
    public void footerText() {
        String text = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.footer-link"))
        ).getText();

        System.out.println("Footer: " + text);
    }
}
