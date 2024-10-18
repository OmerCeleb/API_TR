package post_request;

import baseUrl.PetStoreBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Post01 extends PetStoreBaseUrl {

    /*
        Given
            https://petstore.swagger.io/v2/pet
        And
            {
  "id": 2113,
  "category": {
    "id": 0,
    "name": "Dog"
  },
  "name": "Beagle",
  "photoUrls": [
    "string"
  ],
  "tags": [
    {
      "id": 0,
      "name": "Golden"
    }
  ],
  "status": "available"
}

        When
            Kullanici URL e bir POST request gönderir
        Then
            Status code 200
        And
            Content Type "application/json"
     */

    @Test
    public void post01() {

        // Send the URL
        spec.pathParam("first", "pet");

        // Set the expected data (payLoad)
        String payload = "{\n" +
                "  \"id\": 2113,\n" +
                "  \"category\": {\n" +
                "    \"id\": 0,\n" +
                "    \"name\": \"Dog\"\n" +
                "  },\n" +
                "  \"name\": \"Beagle\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"string\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"name\": \"Golden\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"available\"\n" +
                "}";

        // Send the request and get the request
        Response response = given(spec).body(payload).when().post("{first}");
        response.prettyPrint();

    }
}
