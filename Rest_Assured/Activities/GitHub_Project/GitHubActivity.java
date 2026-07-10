package activities;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GitHubActivity {

    RequestSpecification requestSpec;

    // Replace with your public SSH key
    String sshKey =
            "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIK1DC8fXPmfgDSpqQx1tT0+lHBgS7Zg/WHbf7Zf9AexG azuread\\hemasundaroggu@IBM-C8VJTH4";

    int keyId;

    @BeforeClass
    public void setUp() {

        requestSpec =
                new RequestSpecBuilder()
                        .setBaseUri("https://api.github.com")
                        .addHeader(
                                "Authorization",
                                "token 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")
                        .addHeader(
                                "Content-Type",
                                "application/json")
                        .build();
    }

    @Test(priority = 1)
    public void addSSHKey() {

        Map<String, Object> requestBody = new HashMap<>();

        requestBody.put("title", "TestAPIKey");
        requestBody.put("key", sshKey);

        Response response =
                given()
                        .spec(requestSpec)
                        .body(requestBody)
                .when()
                        .post("/user/keys");

        response.prettyPrint();

        System.out.println(
                "POST Status Code: "
                        + response.getStatusCode());

        Assert.assertEquals(
                response.getStatusCode(),
                201,
                "SSH Key creation failed");

        keyId = response.jsonPath().getInt("id");

        System.out.println(
                "Generated Key ID: "
                        + keyId);

        Reporter.log(
                "Generated Key ID: "
                        + keyId);
    }

    @Test(priority = 2, dependsOnMethods = "addSSHKey")
    public void getSSHKey() {

        Response response =
                given()
                        .spec(requestSpec)
                        .pathParam("keyId", keyId)
                .when()
                        .get("/user/keys/{keyId}");

        response.prettyPrint();

        Reporter.log(
                response.getBody().asPrettyString());

        Assert.assertEquals(
                response.getStatusCode(),
                200,
                "GET request failed");
    }

    @Test(priority = 3, dependsOnMethods = "addSSHKey")
    public void deleteSSHKey() {

        Response response =
                given()
                        .spec(requestSpec)
                        .pathParam("keyId", keyId)
                .when()
                        .delete("/user/keys/{keyId}");

        System.out.println(
                "DELETE Status Code: "
                        + response.getStatusCode());

        Reporter.log(
                "DELETE Status: "
                        + response.getStatusCode());

        Assert.assertEquals(
                response.getStatusCode(),
                204,
                "DELETE request failed");
    }
}
