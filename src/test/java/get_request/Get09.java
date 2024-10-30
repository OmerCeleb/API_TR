package get_request;

import baseUrl.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get09 extends JsonPlaceHolderBaseUrl {

    /*
          Given
             https://jsonplaceholder.typicode.com/todos/2
        When
             Kullanici URL'de bir GEt request gönderir
         Then
            Status Code 200
            "Completed" = false
            "userId" : 1
            "title" : "quis ut nam facilis et oodicia qui"
            "header "Via" is "1.1 vegur"
            Server = "cloudflare

            {
            "userId" : 1,
            "id" : 2,
            "title": "quis ut nam facilis et oodicia qui"
            "completed" : false
            }


     */

    @Test
    public void get01() {

        // Set the URL
        spec.pathParams("first", "todos", "second", 2);

        // Set the expected data
        JsonPlaceHolderTestData obj = new JsonPlaceHolderTestData();
        Map<String, Object> expectedData = obj.getPayLoad(1, "quis ut nam facilis et officia qui", false);
        expectedData.put("Via", "1.1 vegur");
        expectedData.put("Server", "cloudflare");

        // Send the request get the response
        Response response = given(spec).when().get("{first}/{second}");
        response.prettyPrint();

        // Do assertion
        Map<String, Object> actualData = response.as(HashMap.class); // De-Serialization
        assertEquals(200, response.statusCode());
        assertEquals(expectedData.get("completed"), actualData.get("completed"));
        assertEquals(expectedData.get("userId"), actualData.get("userId"));
        assertEquals(expectedData.get("title"), actualData.get("title"));
        assertEquals(expectedData.get("Via"), response.header("Via"));
        assertEquals(expectedData.get("Server"), response.header("Server"));

    }
}
