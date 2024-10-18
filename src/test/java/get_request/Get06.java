package get_request;

import baseUrl.ThinkingTesterContactListUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get06 extends ThinkingTesterContactListUrl {

    /*
        Given
             https://thinking-tester-contact-list.herokuapp.com/contacts
        When
             Kullanici URL'de bir GEt request gönderir
         Then
             HTTP Status Code 200 olmali
         And
            Content Type = "application/json"
     */

    @Test
    public void get06() {

        // Set the URL
        spec.pathParam("first", "contacts");

        // Set the expected data

        // Send the request and get response
        Response response = given(spec).when().get("{first}");
        response.prettyPrint();
    }
}
