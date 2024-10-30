package post_request;

import baseUrl.JsonPlaceHolderBaseUrl;
import baseUrl.PetStoreBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

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
        // payload: Body icerisinde POST Request ile gönderdigimiz data
        // Expected Data Request sonucunda response'tan gelmesini bekledigimiz data
        String payload = "{\n" +
                "       \"userId\": 55,\n" +
                "       \"title\": \"Tidy your room\",\n" +
                "       \"completed\": false\n" +
                "}";

        // Send the request and get the response
        Response response = given(spec).body(payload)
                .when().post("{first}");

        response.prettyPrint();

        // Do assertion
        assertEquals(201, response.statusCode());

        JsonPath jsonPath = response.jsonPath();
        assertEquals(55, jsonPath.getInt("userId"));
        assertEquals("Tidy your room", jsonPath.getString("title"));
        assertFalse(jsonPath.getBoolean("completed"));

    }

    @Test
    public void post02Map() {

        // Set the URL
        spec.pathParam("first", "todos");

        // Set the expected data (payload)
        Map<String, Object> payload = new HashMap<>();
        payload.put("userId", 55);
        payload.put("title", "Tidy your room");
        payload.put("completed", false);
        System.out.println(payload);

        // Send the request and get the response
        // Serialization Java datalarinin JSON datalarina dönusturulmesi
        Response response = given(spec).body(payload).when().post("{first}");
        response.prettyPrint();

        // Do Assertion
        // De - Serialization JSON datanin Java datasina dönusturulmesi
        Map<String, Object> actualData = response.as(HashMap.class);


        assertEquals(201, response.statusCode());
        assertEquals(payload.get("userId"), actualData.get("userId"));
        assertEquals(payload.get("title"), actualData.get("title"));
        assertEquals(payload.get("completed"), actualData.get("completed"));

    }

}
