package put_request;

import baseUrl.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Put01 extends JsonPlaceHolderBaseUrl {

    /*
            Given
            1)  https://jsonplaceholder.typicode.com/todos/198
            2) {
                "userId": 21,
            "title": "Wash the dishes",
            "completed": false
            }
            When
                Kullanici URL bir put request gönderir
            Then
                Status Code 200
                Response:
                 {
                "userId": 21,
            "title": "Wash the dishes",
            "completed": false,
            "id" : 198
            }

     */

    @Test
    public void put01() {
        // Set the URL
        spec.pathParams("first", "todos", "second", 198);

        // Set the expected data
        Map<String, Object> payload = new HashMap<>();
        payload.put("userId", 21);
        payload.put("title", "Wash the dishes");
        payload.put("completed", false);

        // Send the request and get the response
        Response response = given(spec).body(payload).when().put("{first}/{second}"); // Serialization
        response.prettyPrint();

        // Do assertion
        Map<String, Object> actualData = response.as(HashMap.class);
        assertEquals(200, response.statusCode());
        assertEquals(payload.get("userId"), actualData.get("userId"));
        assertEquals(payload.get("title"), actualData.get("title"));
        assertEquals(payload.get("completed"), actualData.get("completed"));


    }


    @Test
    public void put01Methodlu() {
        // Set the URL
        spec.pathParams("first", "todos", "second", 198);

        // Set the expected data
        JsonPlaceHolderTestData obj = new JsonPlaceHolderTestData();
        Map<String, Object> payload = obj.getPayLoad(21, "Wash the dishes", false);

        // Send the request and get the response
        Response response = given(spec).body(payload).when().put("{first}/{second}"); // Serialization
        response.prettyPrint();

        // Do assertion
        Map<String, Object> actualData = response.as(HashMap.class);
        assertEquals(200, response.statusCode());
        assertEquals(payload.get("userId"), actualData.get("userId"));
        assertEquals(payload.get("title"), actualData.get("title"));
        assertEquals(payload.get("completed"), actualData.get("completed"));


    }
}
