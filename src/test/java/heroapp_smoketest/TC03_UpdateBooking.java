package heroapp_smoketest;

import baseUrl.HerokuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.herokuapp.BookingDatesPojo;
import pojos.herokuapp.BookingPojo;

import static heroapp_smoketest.TC01_CreateBooking.bookingId;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class TC03_UpdateBooking extends HerokuAppBaseUrl {
    /*
        Given
            https://restful-booker.herokuapp.com/booking/:id
        And
                        {
                "firstname" : "James",
                "lastname" : "Brown",
                "totalprice" : 111,
                "depositpaid" : true,
                "bookingdates" : {
                    "checkin" : "2018-01-01",
                    "checkout" : "2019-01-01"
                },
                "additionalneeds" : "Breakfast"
            }'
         When
            Kullanici PUT Request gönderir
         ThenTC03_UpdateBooking
         And
                       {
            "firstname" : "James",
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
    public void updateBooking01() {
        spec.pathParams("first", "booking", "second", bookingId);

        BookingDatesPojo bookingDates = new BookingDatesPojo("2018-01-01", "2019-01-01");
        BookingPojo payload = new BookingPojo("Jams", "Brown", 111, true, bookingDates, "Breakfast");

        Response response = given(spec).body(payload).when().put("{first}/{second}");

        BookingPojo actualData = response.as(BookingPojo.class);
        assertEquals(200, response.statusCode());
        assertEquals(payload.getFirstname(), actualData.getFirstname());
        assertEquals(payload.getLastname(), actualData.getLastname());
        assertEquals(payload.getTotalprice(), actualData.getTotalprice());
        assertEquals(payload.getDepositpaid(), actualData.getDepositpaid());
        assertEquals(bookingDates.getCheckIn(), actualData.getBookingDatesPojo().getCheckIn());
        assertEquals(bookingDates.getCheckout(), actualData.getBookingDatesPojo().getCheckout());
        assertEquals(payload.getAdditionalneeds(), actualData.getAdditionalneeds());

    }
}
