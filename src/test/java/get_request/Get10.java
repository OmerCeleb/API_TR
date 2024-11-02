package get_request;

import baseUrl.HerokuAppBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get10 extends HerokuAppBaseUrl {



    /*
        Given
            https://restful-booker.herokuapp.com/booking/91
        When
            Get Request
        Then
            Response Body;
            {
                "firstname": "Jane",
                "lastname": "Doe",
                "totalprice" : 111,
                "depositpaid" true,
                    "bookingdates": {
                            "checkin":"2018-01-01",
                            "checkout":"2019-01-01"
                            },
                            "additionalneeds" : "Extra pillows please"
              }





     */

    @Test
    public void get01() {
        // Set the URL
        spec.pathParams("first", "booking", "second", 91);

        // Set the expected data
        Map<String, String> bookingsDatesData = new HashMap<>();
        bookingsDatesData.put("checkin", "2018-01-01");
        bookingsDatesData.put("checkout", "2019-01-01");

        Map<String, Object> expactedData = new HashMap<>();
        expactedData.put("firstname", "Jane");
        expactedData.put("lastname", "Doe");
        expactedData.put("totalprice", 111);
        expactedData.put("depositpaid", true);
        expactedData.put("bookingdates", bookingsDatesData);
        expactedData.put("additionalneeds", "Extra pillows please");

        // Send the request and get the response
        Response response = given(spec).when().get("{first}/{second}");
        response.prettyPrint();

        //Do assertion
        Map<String, Object> actualData = response.as(HashMap.class);
        assertEquals(200, response.statusCode());
        assertEquals(expactedData.get("firstname"), actualData.get("firstname"));
        assertEquals(expactedData.get("lastname"), actualData.get("lastname"));
        assertEquals(expactedData.get("totalprice"), actualData.get("totalprice"));
        assertEquals(expactedData.get("depositpaid"), actualData.get("depositpaid"));
        assertEquals(expactedData.get("depositpaid"), actualData.get("depositpaid"));
        assertEquals(expactedData.get("additionalneeds"), actualData.get("additionalneeds"));

        assertEquals(bookingsDatesData.get("checkin"), ((Map) actualData.get("bookingdates")).get("checkin"));

        assertEquals(bookingsDatesData.get("checkout"), ((Map) actualData.get("bokingsdate")).get("checkout"));

        // 2. yol
        JsonPath jsonPath = response.jsonPath();
        assertEquals(bookingsDatesData.get("checkin"), jsonPath.getString("bookingdates.checkin"));
        assertEquals(bookingsDatesData.get("checkout"), jsonPath.getString("bookingdates.checkout"));


    }

    @Test
    public void get01Metotlu() {

        // Set the URL
        spec.pathParams("first", "booking", "second", 91);

        // Set the expected data
        Map<String, String> bookingsDatesData = new HashMap<>();
        bookingsDatesData.put("checkin", "2018-01-01");
        bookingsDatesData.put("checkout", "2019-01-01");

        Map<String, Object> expactedData = new HashMap<>();
        expactedData.put("firstname", "Jane");
        expactedData.put("lastname", "Doe");
        expactedData.put("totalprice", 111);
        expactedData.put("depositpaid", true);
        expactedData.put("bookingdates", bookingsDatesData);
        expactedData.put("additionalneeds", "Extra pillows please");

        // Send the request and get the response
        Response response = given(spec).when().get("{first}/{second}");
        response.prettyPrint();

        //Do assertion
        Map<String, Object> actualData = response.as(HashMap.class);
        assertEquals(200, response.statusCode());
        assertEquals(expactedData.get("firstname"), actualData.get("firstname"));
        assertEquals(expactedData.get("lastname"), actualData.get("lastname"));
        assertEquals(expactedData.get("totalprice"), actualData.get("totalprice"));
        assertEquals(expactedData.get("depositpaid"), actualData.get("depositpaid"));
        assertEquals(expactedData.get("depositpaid"), actualData.get("depositpaid"));
        assertEquals(expactedData.get("additionalneeds"), actualData.get("additionalneeds"));

        assertEquals(bookingsDatesData.get("checkin"), ((Map) actualData.get("bookingdates")).get("checkin"));

        assertEquals(bookingsDatesData.get("checkout"), ((Map) actualData.get("bokingsdate")).get("checkout"));

        // 2. yol
        JsonPath jsonPath = response.jsonPath();
        assertEquals(bookingsDatesData.get("checkin"), jsonPath.getString("bookingdates.checkin"));
        assertEquals(bookingsDatesData.get("checkout"), jsonPath.getString("bookingdates.checkout"));


    }
}
