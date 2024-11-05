package heroapp_smoketest;

import baseUrl.HerokuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.herokuapp.BookingDatesPojo;
import pojos.herokuapp.BookingPojo;
import test_data.HerokuAppTestData;

import java.util.HashMap;
import java.util.Map;

import static heroapp_smoketest.TC01_CreateBooking.bookingId;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class TC04_ParcaliUpdateBooking extends HerokuAppBaseUrl {

    /*
        Given
            https://restful-booker.herokuapp.com/booking/:id
        And
                        {
                "firstname" : "Ömer",
                "lastname" : "Brown"
            }
        When
            Kullanici PATCH Request gönderir
        Then
            Status Code 200
        And
                          {
                "firstname" : "Ömer",
                "lastname" : "Brown",
                "totalprice" : 111,
                "depositpaid" : true,
                "bookingdates" : {
                    "checkin" : "2018-01-01",
                    "checkout" : "2019-01-01"
                },
                "additionalneeds" : "Breakfast"
            }

     */

    @Test
    public void parcaliUpdate() {
        spec.pathParams("first", "booking", "second", bookingId);

        HerokuAppTestData obj = new HerokuAppTestData();
        Map<String, Object> payload = obj.getPayload("Ömer", "Celebi", null, null, null, null);

        Response response = given(spec).body(payload).when().patch("{first}/{second}");
        response.prettyPrint();

        Map<String, Object> actualData = response.as(HashMap.class);
        assertEquals(200, response.statusCode());
        assertEquals(payload.get("firstname"), actualData.get("firstname"));
        assertEquals(payload.get("lastname"), actualData.get("lastname"));
    }
}
