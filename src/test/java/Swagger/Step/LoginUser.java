package Swagger.Step;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

public class LoginUser {

    public static void apiResponse(){
        RestAssured.baseURI = StepDefinition.BaseURI + "v2";
        String output = given().queryParam("username","Vaibhavi").queryParam("password", StepDefinition.password)
                .when().get("/user/login")
                .then().assertThat().statusCode(200).extract().asString();
        JsonPath jsonPath = new JsonPath(output);
        String OutputBody = jsonPath.getString("message");
        System.out.println(OutputBody);
    }
}
