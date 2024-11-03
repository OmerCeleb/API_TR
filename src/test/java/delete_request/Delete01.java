package delete_request;

import baseUrl.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Delete01 extends JsonPlaceHolderBaseUrl {
/*
    Given
    https://jsonplaceholder.typicode.com/todos/198
    When
    Kullanici URL'de bir DELETE request gönderir
    Then
    Status Code 200


 */


    @Test
    public void delete01() {

        // Set the URL
        spec.pathParams("first", "todos", "second", 198);

        // Set the expected data
        Map<String, String> expectedData = new HashMap<>();

        // Send the request and get the response
        Response response = given(spec).when().delete("{first}/{second}");
        response.prettyPrint();

        // Do assertion
        Map<String, String> actualData = response.as(HashMap.class);
        assertEquals(200, response.statusCode());

        //1.yol
        assertEquals(expectedData, actualData);

        //2.yol
        assertTrue(actualData.isEmpty());


    }
}
