package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.*;

public class ImageSteps extends BaseClass {

    @Then("print header image url")
    public void imageUrl() {
        String url = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("img.image-company_logo")
            )
        ).getAttribute("src");

        System.out.println("Image URL: " + url);
    }
}
