package Swagger.Step;

import Swagger.POMPackage.BaseClass;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class StepDefinition extends BaseClass {
    public static String password;
    public static String  BaseURI = "https://petstore.swagger.io/";

    @Given("I have a chrome opened with URL")
    public void iHaveAChromeOpenedWithURL() {
        getDriver().get(BaseURI);
        getDriver().findElement(By.xpath("//button[.='Allow all cookies']")).click();
    }

    @When("I see the SwaggerPetStore Homepage")
    public void iSeeTheSwaggerPetStoreHomepage() {
        getDriver().findElement(By.xpath("//h1[contains(.,'Swagger Petstore')]")).isDisplayed();

    }

    @And("I scroll to operations user TAG")
    public void iScrollToOperationsUserTAG() {
        WebElement UserTag = getDriver().findElement(By.id("operations-tag-user"));
        getActions().scrollToElement(UserTag);
    }

    @And("I select Get user by user name method")
    public void iSelectGetUserByUserNameMethod() {
        getDriver().findElement(By.xpath("(//button[@class='opblock-summary-control'])[14]")).click();
    }

    @And("I select Try It Out")
    public void iSelectTryItOut() {
        getDriver().findElement(By.xpath("(//button[@class='btn try-out__btn'])[1]")).click();

    }

    @And("I provide Username in the textbox")
    public void iProvideUsernameInTheTextbox() {
        getDriver().findElement(By.xpath("//input[@placeholder='username']")).sendKeys("Vaibhavi");
    }

    @And("I click on execute")
    public void iClickOnExecute() {
        getDriver().findElement(By.xpath("//button[@class='btn execute opblock-control__btn']")).click();
    }


    @Then("I fetch Password from the respone")
    public void iFetchPasswordFromTheRespone() {
        String ResponseBody = getDriver().findElement(By.xpath("//div[h5[contains(text(), 'Response body')]]//pre/code")).getText();
        System.out.println(ResponseBody);
        JsonPath jsonPath = new JsonPath(ResponseBody);
        password = jsonPath.getString("password");
    }

    @And("I validate the login success or failure")
    public void iValidateTheLoginSuccessOrFailure() {
        LoginUser.apiResponse();
    }

    @Given("I create new user")
    public void iCreateNewUser() {
        CreateUser.RestCreateUser();
    }
}
