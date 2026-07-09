package basic.POJO;

import io.restassured.RestAssured;

import static basic.GetMethod.baseURI;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class Users {

    public static void main(String[] args){
        RestAssured.baseURI = baseURI;
        PojoClass pojoClass = given().log().all().pathParam("username","Vaibhavi").auth().basic("api_key", "api_key")
                .when().get("/user/{username}")
                .then().log().all().extract().as(PojoClass.class);
        System.out.println(pojoClass.getPassword());

    }
}
