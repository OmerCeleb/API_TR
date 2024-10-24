package get_request;

import baseUrl.HerokuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Get07 extends HerokuAppBaseUrl {

    /*
        Given
            https://restful-booker.herokuapp.com/booking/23
        When
            Kullanici URL e bir GET request gönderir
        Then
            Status code 200
        And
            Content Type "application/json"

        And
            {
                 "firstname": "Bradley"
                 "lastname": "Pearson"
                 "totalprice": "132"
                 "depositpaid": "false"
                 "bookingdates": {
                        "chekin": "2022-10-27",
                        "chekout": "2022-11-07"
                    },
                    "additionalneeds": "None"
             }

     */

    @Test
    public void get07() {

        // Set the URL
        spec.pathParams("first", "booking", "second", "10");

        // Set the expected data

        // Send the request and get the response
        Response response = given(spec).when()
                .get("{first}/{second}");
        response.prettyPrint();

        // Do assertion
        // 1: YOL
        response
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("firstname", equalTo("John"))
                .body("lastname", equalTo("Smith"))
                .body("totalprice", equalTo(111))
                .body("depositpaid", equalTo(true))
                .body("bookingdates.checkin", equalTo("2018-01-01"))
                .body("bookingdates.checkout", equalTo("2019-01-01"))
                .body("additionalneeds", equalTo("Breakfeast"));

        // 2. YOL:
        // Json path alistirma
        JsonPath jsonPath = response.jsonPath();
        String firstname = jsonPath.getString("firstname");
        System.out.println("FirstName: " + firstname);
        int totapprice = jsonPath.getInt("totaprice");
        System.out.println(totapprice);
        System.out.println(jsonPath.getString("bookingdates.checkin"));

        // Dogrulama
        assertEquals(200, response.statusCode());
        assertTrue(response.contentType().contains("application/json"));
        assertEquals("Josh", jsonPath.getString("firstname"));
        assertEquals("Allen", jsonPath.getString("lastname"));
        assertTrue(jsonPath.getBoolean("depositpaid"));


    }
}
