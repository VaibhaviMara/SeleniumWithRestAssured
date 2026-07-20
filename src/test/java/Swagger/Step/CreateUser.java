package Swagger.Step;

import basic.map.MapStore;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import java.io.File;

import static io.restassured.RestAssured.given;

public class CreateUser {

   public static void RestCreateUser(){
       RestAssured.baseURI = StepDefinition.BaseURI +"v2";
       /*String createuserresponse = given().contentType("application/json").body(MapStore.createUserRequest())
               .when().post("/user")
               .then().extract().asString();
       JsonPath jsonPath = new JsonPath(createuserresponse);
       System.out.println(jsonPath.getString("message"));*/

       File file = new File("C:\\Learn\\Selenium\\restAssuredPetStore\\src\\test\\java\\Swagger\\resources\\userdetail.json");
       String createuserresponse = given().contentType("application/json").body(file)
               .when().post("/user")
               .then().extract().asString();
       JsonPath jsonPath = new JsonPath(createuserresponse);
       System.out.println(jsonPath.getString("message"));
   }
}
