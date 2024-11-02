package post_request;

import baseUrl.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.jsonplaceholder.JsonPlaceHolderPojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post03 extends JsonPlaceHolderBaseUrl {
    /*
             Given
            https://jsonplaceholder.typicode.com/todos
       {
       "userId": 55,
       "title": "Tidy your room",
       "completed": false
}

        When
            Kullanici URL e bir POST request gönderir
        Then
            Status code 201
        And
            Response:
            {
            "userId": 55,
            "title": "Tidy your room",
            "completed": false,
            "id": 201
            }

     */

    @Test
    public void post01() {
        // Set the URL
        spec.pathParam("first", "todos");

        // Set the expected data
        JsonPlaceHolderPojo payload = new JsonPlaceHolderPojo(55, "Tidy your room", false);

        // Send the request and get the response
        Response response = given(spec).body(payload).when().post("{first}"); // Serialization

        // Do assertion
        JsonPlaceHolderPojo actualData = response.as(JsonPlaceHolderPojo.class);
        assertEquals(201, response.statusCode());
        assertEquals(payload.getUserId(), actualData.getUserId());
        assertEquals(payload.getTitle(), actualData.getTitle());
        assertEquals(payload.getCompleted(), actualData.getCompleted());

    }
}
