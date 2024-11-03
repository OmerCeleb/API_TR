package get_request;

import baseUrl.HerokuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.herokuapp.BookingDatesPojo;
import pojos.herokuapp.BookingPojo;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class Get12 extends HerokuAppBaseUrl {

    /*
         Given
            https://restful-booker.herokuapp.com/booking/4
        When
            Kullanici URL e bir GET request gönderir
        Then
            Status code 200
        And
            Content Type "application/json"

        And
            {
                 "firstname": "Mark"
                 "lastname": "Brown"
                 "totalprice": 604
                 "depositpaid": "true"
                 "bookingdates": {
                        "chekin": "2023-03-04",
                        "chekout": "2024-09-25"
                    },
                    "additionalneeds": "Breakfast"
             }

     */


    @Test
    public void get01() {

        // Set the URL
        spec.pathParams("first", "booking", "second", 4);

        // Set the expected data
        BookingDatesPojo bookingDates = new BookingDatesPojo("2015-04-26", "2017-01-31");
        BookingPojo expectedData = new BookingPojo("Mark", "Ericsson", 739, false, bookingDates, "Breakfast");
        // System.out.println(expectedData);

        // Send the request and get the response
        Response response = given(spec).when().get("{first}/{second}");
        response.prettyPrint();

        // Do assertion
        BookingPojo actualData = response.as(BookingPojo.class);
        assertEquals(200, response.statusCode());
        assertEquals(expectedData.getFirstname(), actualData.getFirstname());
        assertEquals(expectedData.getLastname(), actualData.getLastname());
        assertEquals(expectedData.getTotalprice(), actualData.getTotalprice());
        assertEquals(expectedData.getDepositpaid(), actualData.getDepositpaid());
        assertEquals(bookingDates.getCheckIn(), actualData.getBookingDatesPojo().getCheckIn());
        assertEquals(bookingDates.getCheckout(), actualData.getBookingDatesPojo().getCheckout());
        assertEquals(expectedData.getAdditionalneeds(), actualData.getAdditionalneeds());


    }
}
