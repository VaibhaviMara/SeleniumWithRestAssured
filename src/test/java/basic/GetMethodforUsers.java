package basic;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class GetMethodforUsers extends GetMethod {
    public static void main(String[]args){
        RestAssured.baseURI=baseURI;
        String password = given().pathParam("username","user1")
                .when().get("/user/{username}")
                .then().log().all().extract().jsonPath().getString("password");

        Boolean login = given().queryParam("username","user1").queryParam("password",password)
                .when().get("/user/login")
                .then().log().all().extract().jsonPath().getString("message").contains("logged in user");
        System.out.println(login);

                when().get("/user/logout")
                        .then().log().all().assertThat().statusCode(200);


    }
}
