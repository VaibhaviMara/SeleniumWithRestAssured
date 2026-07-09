package basic.POJO.Parent;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;

import java.util.List;

import static basic.GetMethod.baseURI;
import static io.restassured.RestAssured.given;

public class GetPetID {
    public static void main(String[]args){
        RestAssured.baseURI = baseURI;
        MainPOJO mainPOJO = given().pathParams("petId","9223372016900039000")
                .when().get("/pet/{petId}")
                .then().log().all().extract().as(MainPOJO.class);
        System.out.println(mainPOJO.getCategory().getId());
    }
}
