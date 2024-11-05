package heroapp_smoketest;

import baseUrl.HerokuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.herokuapp.BookingDatesPojo;
import pojos.herokuapp.BookingPojo;

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

        BookingPojo payload = new BookingPojo("Ömer", "Brown");
        BookingDatesPojo bookingDatesPojo = new BookingDatesPojo("2018-01-01", "2019-01-01");
        BookingPojo expectedData = new BookingPojo("Ömer", "Brown", 111, true, bookingDatesPojo, "Breakfast");

        Response response = given(spec).body(payload).when().patch("{first}/{second}");
        response.prettyPrint();

        BookingPojo actualData = response.as(BookingPojo.class);
        assertEquals(200, response.statusCode());
        assertEquals(payload.getFirstname(), actualData.getFirstname());
        assertEquals(payload.getLastname(), actualData.getLastname());
        assertEquals(payload.getTotalprice(), actualData.getTotalprice());
        assertEquals(payload.getDepositpaid(), actualData.getDepositpaid());
        assertEquals(bookingDatesPojo.getCheckIn(), actualData.getBookingDatesPojo().getCheckIn());
        assertEquals(bookingDatesPojo.getCheckout(), actualData.getBookingDatesPojo().getCheckout());
        assertEquals(payload.getAdditionalneeds(), actualData.getAdditionalneeds());

    }
}
