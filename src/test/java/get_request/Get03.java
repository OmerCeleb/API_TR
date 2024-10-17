package get_request;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Get03 {


     /*
    Given
        https://petstore.swagger.io/v2/pet/2113
    When
        Kullanici Url'e bir Get request gönderir
    Then
        HTTP Status Code 200
    And
        Content Type "application/json"
    And
        "name" = "Beagle"
    And
        status = "available"
    And
        "category" altindaki name = "dog"
    And
        "tags" altindaki "name" = "Golden"

     */

    @Test
    public void get03() {

        //1- Set the URL
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        RestAssured.basePath = "/pet/2113";


        //2- Set the expected data

        //3- Send the request and get the response
        given().
                when().
                get()
                .then()
                .statusCode(200)
                .contentType("application/json")
                .body("name", containsString("Beagle"))
                .body("status", equalTo("available"))
                .body("category.name", equalTo("Dog"))
                .body("tags[0].name", equalTo("Golden"));


    }
}
