package get_request;

import baseUrl.PetStoreBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get04 extends PetStoreBaseUrl {

        /*
    Given
        https://petstore.swagger.io/v2/pet/2113
    When
        Kullanici Url'e bir Get request gönderir
    Then
        HTTP Status Code 200
    And
        Content Type "application/json"


     */

    @Test
    public void get04() {
        // Set the URL
        spec.pathParams("first", "pet", "second", 2113);

        // Set the expected data

        // Send the request and get the response
        Response response = given(spec).when().get("{first}/{second}");
        response.prettyPrint();

        // Do assertion
        response.then()
                .statusCode(200)
                .contentType(ContentType.JSON);


    }
}
