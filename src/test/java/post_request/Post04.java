package post_request;

import baseUrl.HerokuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.herokuapp.BookingDatesPojo;
import pojos.herokuapp.BookingPojo;
import pojos.herokuapp.BookingResponsePojo;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;

public class Post04 extends HerokuAppBaseUrl {
/*

 Given
    https://restful-booker.herokuapp.com/booking
    When
    Kullanici URL e bir Post request gönderir
            Then
    Status code 200
    And

        {
        "firstname": "Ali"
        "lastname": "Can"
        "totalprice": 999
        "depositpaid": "true"
        "bookingdates": {
        "chekin": "2023-03-04",
                "chekout": "2024-09-25"
    },
        "additionalneeds": "Breakfast"
    }

And
    {
    bookingid: 16,
    booking :{
    "firstname": "Ali"
     "lastname": "Can"
        "totalprice": 999
        "depositpaid": "true"
        "bookingdates": {
        "chekin": "2023-03-04",
                "chekout": "2024-09-25"
    },
        "additionalneeds": "Breakfast"
    }

 */


    @Test
    public void post01() {

        // Set the URL
        spec.pathParam("first", "booking");

        // Set the expected data
        BookingDatesPojo bookingDates = new BookingDatesPojo("2023-03-04", "2024-09-25");
        BookingPojo payload = new BookingPojo("Ali", "Can", 999, true, bookingDates, "Breakfast");
        //System.out.println(payload);

        // Send the request and get the response
        Response response = given(spec).body(payload).when().post("{first}");
        response.prettyPrint();

        // Do assertion
        BookingResponsePojo actualData = response.as(BookingResponsePojo.class);
        assertEquals(200, response.statusCode());
        assertEquals(payload.getFirstname(), actualData.getBooking().getFirstname());
        assertEquals(payload.getLastname(), actualData.getBooking().getLastname());
        assertEquals(payload.getTotalprice(), actualData.getBooking().getTotalprice());
        assertEquals(payload.getDepositpaid(), actualData.getBooking().getDepositpaid());
        assertEquals(bookingDates.getCheckIn(), actualData.getBooking().getBookingDatesPojo().getCheckIn());
        assertEquals(bookingDates.getCheckout(), actualData.getBooking().getBookingDatesPojo().getCheckout());
        assertEquals(payload.getAdditionalneeds(), actualData.getBooking().getAdditionalneeds());


    }
}
