package basic;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class GetStore {
    public static void main(String[] args){
        RestAssured.baseURI = GetMethod.baseURI;
        String response = given().when().get("/store/inventory")
                .then().log().all().extract().asString();

        JsonPath jsonPath = new JsonPath(response);
        System.out.println("Number of sold items are : " + jsonPath.getString("sold"));
        System.out.println("Number of available items are : " + jsonPath.getString("available"));
        System.out.println("Number of pending items are : " + jsonPath.getString("pending"));

        String orderID1 = given().pathParam("orderId","1")
                .when().get("/store/order/{orderId}")
                .then().log().all().assertThat().statusCode(200).extract().asString();

        JsonPath jsonPath1 = new JsonPath(orderID1);
        if(jsonPath1.getString("complete").equals("true")) {
            System.out.println("Complete is :" + jsonPath1.getString("complete"));
        }
        System.out.println("Quantity is : " + jsonPath1.getString("quantity")
        );
    }
}
