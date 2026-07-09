package basic;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class GetMethod {

    public static String baseURI = "https://petstore.swagger.io/v2";

    public static void main() {
        RestAssured.baseURI = baseURI;
        String petId = given().queryParam("status", "available").auth().basic("api_key", "api_key")
                .when().get("/pet/findByStatus")
                        .then().log().all().extract().jsonPath().getString("id[0]");

        given().log().all().pathParam("petId" ,petId).auth().basic("api_key", "api_key")
                .when().get("/pet/{petId}")
                .then().assertThat().statusCode(200);
    }

}
