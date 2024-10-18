package get_request;

import baseUrl.PetStoreBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Get05 extends PetStoreBaseUrl {

    /*
     Given
        https://petstore.swagger.io/v2/pet/findByStatus?status=available
    When
        Kullanici Url'e bir Get request gönderir
    Then
        HTTP Status Code 200
    And
        Content Type "application/json"
    And
        Listede id degeri 2113 olan bir eleman olmali
    And
        name="Beagle";
    And
        Listede name degerleri "Beagle","Doggie","Fish" olan elemanlar olmali
    And
        En az 200 elaman
    And
        En az 500dem az eleman
    And
        Listenin ilk elamanin category - id degeri 0
    And
        Listenin ilk elemanin photoUrl = "string"
    And
        Ilk elemanin tag - id degeri 0

     */

    @Test
    public void get05() {

        // Set the URL
        spec.pathParams("first", "pet", "second", "findByStatus")
                .queryParam("status", "available");

        // Set the expected data

        // Send the request ánd get the response
        Response response = given(spec).when().get("{first}/{second}");
        response.prettyPrint();

        // Do assertion
        response
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("id", hasItem(2113))
                .body("name", hasItem("Beagle"))
                .body("name", hasItems("Beagle", "Doggie", "Fish"))
                .body("id", hasSize(greaterThan(100)))
                .body("id", hasSize(lessThan((500))))
                .body("[0].category.id", equalTo(0))
                .body("[0].photoUrls[0]", equalTo("string"))
                .body("[0].tags[0].id", equalTo(0));


    }
}
