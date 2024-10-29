package post_request;

import baseUrl.JsonPlaceHolderBaseUrl;
import baseUrl.PetStoreBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Post02 extends JsonPlaceHolderBaseUrl {

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
    public void post02() {

        // Set the URL
        spec.pathParam("first", "todos");

        // Set the expected data (payload)
        String payload = "{\n" +
                "       \"userId\": 55,\n" +
                "       \"title\": \"Tidy your room\",\n" +
                "       \"completed\": false\n" +
                "}";

        // Send the request and get the response
        Response response = given(spec).body(payload)
                .when().post("{first}");

        response.prettyPrint();
    }
}
