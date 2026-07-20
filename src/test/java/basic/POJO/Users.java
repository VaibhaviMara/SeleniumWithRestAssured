package basic.POJO;

import io.restassured.RestAssured;

import java.util.Map;

import static basic.GetMethod.baseURI;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;

public class Users {

    public static void main(String[] args){
        /*RestAssured.baseURI = baseURI;
        PojoClass pojoClass = given().log().all().pathParam("username","Vaibhavi").auth().basic("api_key", "api_key")
                .when().get("/user/{username}")
                .then().log().all().extract().as(PojoClass.class);
        System.out.println(pojoClass.getPassword());*/

        RestAssured.baseURI = baseURI;
        /*Map<String, Object> mapResponse = given().log().all().pathParam("username","Vaibhavi").auth().basic("api_key", "api_key")
                .when().get("/user/{username}")
                .then().log().all().extract().as(Map.class);
        System.out.println(mapResponse.get("password"));
        System.out.println(mapResponse.get("id"));*/

        /*System.out.println((char[]) given().log().all().pathParam("username","Vaibhavi").auth().basic("api_key", "api_key")
                .when().get("/user/{username}")
                .then().extract().path("find {it.id == 1}.user"));*/

        given().log().all().pathParam("username","Vaibhavi").auth().basic("api_key", "api_key")
                .when().get("/user/{username}")
                .then().body("password", equalTo("Vaibhavi123"));

    }
}
