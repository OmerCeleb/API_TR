package get_request;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class Get02 {

    /*
    Given
        https://petstore.swagger.io/v2/pet/0
    When
        Kullanici Url'e bir Get request gönderir
    Then
        HTTP Status Code 404
    And
        Status Line "HTTP/1.1 404 Not found" olmali
    And
        Response body "Pet not found"
    And
        Response body "TechproEd" icermemeli
    And
        Server degeri "Jetty(9.29.v20150224)"

     */

    @Test
    public void get02() {

        /*
                1- Set the URL
                2- Set the expected data
                3- Send the request and get the response
                4- Do assertion

         */

        // 1- Set the URL
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        RestAssured.basePath = "/pet/0";

        // 2-Set the expected data
        /*
                Bu islem basamagini POST, PUT gibi body gerektiren sorgularda ve
                GET, DELETE gibi response'tan bekledigimiz datayi biliyorsak kullanabiliriz
         */

        //3- Send the request and get the response
        Response response = given().when().get();
        response.prettyPrint();

        // 4- Do assertion
        response.then()
                .statusCode(404)
                .statusLine("HTTP/1.1 404 Not Found")
                .body(containsString("Pet not found"))
                .body(not(containsString("TechProEd")))
                .header("Server", "Jetty(9.2.9.v20150224)");


    }
}
