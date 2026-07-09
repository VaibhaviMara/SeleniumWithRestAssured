package basic;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class getMethodSwaggerPetStore {
    public static void main(String[]args){
        RestAssured.baseURI = GetMethod.baseURI;
        /*String petId = given().queryParam("status","sold").auth().basic("api_key","api_key")
                .when().get("/pet/findByStatus")
                .then().log().all().extract().jsonPath().getString("id[0]");
        System.out.println(petId);*/
          given().auth().basic("api_key","api_key")
                .when().get("/store/inventory")
                .then().log().all();

    }


}
