package stepDefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.cucumber.java.en.*;

public class TitleSteps extends BaseClass {

    @Then("title should be SuiteCRM")
    public void verifyTitle() {
        String title = driver.getTitle();
        System.out.println("Title: " + title);
        assertEquals("SuiteCRM", title);
    }
}
